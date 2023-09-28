package com.wipro.celona.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.dao.ThroughputDAO;
import com.wipro.celona.model.Customer;
import com.wipro.celona.model.MS_Throughput;
import com.wipro.celona.model.Throughput;
import com.wipro.celona.utils.Util;

public class ThroughputService extends CelonaService {

	public void pull_ThroughputDetailsFromRaemisAPI() throws Exception {

		new CustomerService().pull_CustomerDetailsFromRaemisAPI();
		for (Customer customer : CustomerService.getCustomerList()) {

			Certificate.doTrustToCertificates();
			Map<String, Object> params = getRequestParam(customer.getId());
			System.out.println(params.toString());
			String responseJson = super.pullData_GET(Constants.THROUGHPUT_URL, params);
			List<Throughput> throughputs = new ArrayList<>();
			if (responseJson != null && !responseJson.isEmpty()) {
				JSONParser parser = new JSONParser();
				JSONArray json = (JSONArray) parser.parse(responseJson);
				List<MS_Throughput> ms_throughputs = new ArrayList<MS_Throughput>();
				for (int i = 0; i < json.size(); i++) {
					JSONObject obj = (JSONObject) json.get(i);
					JSONObject event = (JSONObject)obj.get("event");
					MS_Throughput throughput = (MS_Throughput) Util.parseJsonStrToObject(event.toString(),
							Constants.THROUGHPUT);
					ms_throughputs.add(throughput);
				}

				for (MS_Throughput throughput : ms_throughputs) {
					System.out.println("THROUGHPUT RESPONSE ----: " + throughput.toString());

				}
				throughputs.add(calculateandGetThroughput(ms_throughputs));
				new ThroughputDAO().pollRecords(throughputs);
			}
		}
	}

	private Map<String, Object> getRequestParam(int customer_id) {
		Map<String, Object> params = new HashMap<String, Object>();
		Date fromDate = new Date();
		fromDate.setTime(fromDate.getTime() - Constants.BETWEEN_10_SEC);
		long millisFrom = fromDate.getTime();
		Date toDate = new Date();
		long millisTo = toDate.getTime();

		params.put("startTime", millisFrom);
		params.put("endTime", millisTo);
		params.put("customerId", customer_id);
		params.put("direction", "both"); 
		params.put("granularity", 60);
		return params;
	}

	private Throughput calculateandGetThroughput(List<MS_Throughput> ms_Throughputs) {
		double uplink = 0;
		double downlink = 0;
		long millisec = 0;
		Throughput throughput = new Throughput();
		for (MS_Throughput ms_Throughput : ms_Throughputs) {
			uplink += ms_Throughput.getuThroughput();
			downlink += ms_Throughput.getdThroughput();
			if (millisec < ms_Throughput.getTs())
				millisec = ms_Throughput.getTs();
		}
		throughput.setUplink(uplink / 1000);
		throughput.setDownlink(downlink / 1000);
		throughput.setDatetime(Util.changeDateFormat(millisec));
		return throughput;
	}

	public static void main(String[] args) {
		try {
			new ThroughputService().pull_ThroughputDetailsFromRaemisAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
