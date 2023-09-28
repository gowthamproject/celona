package com.wipro.celona.services;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.model.Customer;
import com.wipro.celona.utils.Util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CustomerService extends CelonaService {

	private static List<Customer> customerList = new ArrayList<Customer>();

	@SuppressWarnings("unchecked")
	public void pull_CustomerDetailsFromRaemisAPI() throws Exception {

		Certificate.doTrustToCertificates();
		String responseJson = super.pullData(Constants.CUSTOMER_URL);

		if (responseJson != null && !responseJson.isEmpty()) {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(responseJson);
			JSONArray data = (JSONArray) json.get("data");
			System.out.println("Customer RESPONSE ----: " + data.toString());
			setCustomerList((List<Customer>) Util.parseJsonStrToObject(data.toString(), Constants.CUSTOMER));
		}
	}

	public static List<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(List<Customer> customerList) {
		CustomerService.customerList = customerList;
	}

	public static void main(String[] args) {
		try {
			new CustomerService().pull_CustomerDetailsFromRaemisAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
