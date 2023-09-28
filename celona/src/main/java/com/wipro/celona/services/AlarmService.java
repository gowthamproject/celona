package com.wipro.celona.services;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.dao.AlarmDAO;
import com.wipro.celona.model.Alarm;
import com.wipro.celona.model.Customer;
import com.wipro.celona.utils.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AlarmService extends CelonaService {
	public void pull_AlarmDetailsFromRaemisAPI() throws Exception {

		new CustomerService().pull_CustomerDetailsFromRaemisAPI();
		for (Customer customer : CustomerService.getCustomerList()) {

			Certificate.doTrustToCertificates();
			Map<String, Object> params = getRequestParam(customer.getId());
			String responseJson = super.pullData_POST(Constants.ALARM_URL, params);

			if (responseJson != null && !responseJson.isEmpty()) {
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(responseJson);
				JSONObject data = (JSONObject) json.get("data");
				JSONArray records = (JSONArray) data.get("records");

				List<Alarm> alarms = parseJsonToListOfAlarm(records);
				// System.out.println("ALARM RESPONSE ----: " + records.toString());
				new AlarmDAO().pollRecords(alarms);
			}

		}
	}

	private Map<String, Object> getRequestParam(int customer_id) {
		/*
		 * String severities[] = { "WARN", "ERROR", "CRITICAL" }; List<String>
		 * severityList = Arrays.asList(severities);
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		Date fromDate = new Date();
		fromDate.setTime(fromDate.getTime() - Constants.BETWEEN_100_SEC);
		long millisFrom = fromDate.getTime();
		Date toDate = new Date();
		long millisTo = toDate.getTime();

		params.put("startTime", millisFrom);
		params.put("endTime", millisTo);
		params.put("customer_id", customer_id);
		params.put("pageSize", 1000);
		params.put("severity", "[\"WARN\", \"ERROR\", \"CRITICAL\"]");
		return params;
	}

	private List<Alarm> parseJsonToListOfAlarm(JSONArray records) {
		List<Alarm> alarmList = new ArrayList<Alarm>();
		Set<Alarm> setAlarm = new HashSet<Alarm>();
		Alarm alarm = null;
		for (int i = 0; i < records.size(); i++) {
			alarm = new Alarm();
			JSONObject rec = (JSONObject) records.get(i);
			String severity = (String) rec.get("severity");

			if (severity == null)
				continue;

			String ip = rec.get("ip") != null ? (String) rec.get("ip") : "";
			String host = rec.get("host") != null ? (String) rec.get("host") : "";
			String type = rec.get("type") != null ? (String) rec.get("type") : "";
			String catagory = rec.get("category") != null ? (String) rec.get("category") : "";
			String clusterId = rec.get("clusterID") != null ? (String) rec.get("clusterID") : "";
			String uuid = rec.get("uuid") != null ? (String) rec.get("uuid") : "";
			String edgeName = rec.get("edgeName") != null ? (String) rec.get("edgeName") : "";
			String deviceName = rec.get("deviceName") != null ? (String) rec.get("deviceName") : "";
			String eventType = rec.get("cnCoreEvents.eventType") != null ? (String) rec.get("cnCoreEvents.eventType")
					: "";
			String eventDesc = rec.get("cnCoreEvents.eventTypeDesc") != null
					? (String) rec.get("cnCoreEvents.eventTypeDesc")
					: "";
			String cell_enbId = rec.get("cnCoreEvents.cellevent.enbId") != null
					? (String) rec.get("cnCoreEvents.cellevent.enbId")
					: "";
			String cell_eventType = rec.get("cnCoreEvents.cellevent.cellEventType") != null
					? (String) rec.get("cnCoreEvents.cellevent.cellEventType")
					: "";
			String cell_desc = rec.get("cnCoreEvents.cellevent.description") != null
					? (String) rec.get("cnCoreEvents.cellevent.description")
					: "";

			String sev = severity.equals("WARN") ? "warning" : severity.toLowerCase();
			alarm.setIp(ip);
			alarm.setHost(host);
			alarm.setType(type);
			alarm.setCategory(catagory);
			alarm.setClusterID(clusterId);
			alarm.setSeverity(sev);
			alarm.setDeviceName(deviceName);
			alarm.setTimestamp((long) rec.get("timestamp"));
			alarm.setUuid(uuid);
			alarm.setEdgeName(edgeName);
			alarm.setEventType(eventType);
			alarm.setEventTypeDesc(eventDesc);
			alarm.setCell_enbId(cell_enbId);
			alarm.setCell_eventType(cell_eventType);
			alarm.setCell_description(cell_desc);
			setAlarm.add(alarm);
			alarmList.add(alarm);
		}
		for (Alarm al : setAlarm) {
			System.out.println("----:" + al.hashCode());
			al.setId(Math.abs(al.hashCode()));
			System.out.println(
					"***************" + Util.changeDateFormat((long) al.getTimestamp()) + "----: " + al.toString());
		}
		return new ArrayList<Alarm>(setAlarm);
	}

	public static void main(String[] args) {
		try {
			new AlarmService().pull_AlarmDetailsFromRaemisAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}