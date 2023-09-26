package com.wipro.celona.services;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.dao.SubscriberDAO;
import com.wipro.celona.model.Subscriber;
import com.wipro.celona.utils.Util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SubscriberService extends CelonaService {

	@SuppressWarnings("unchecked")
	public void pull_SubsriberDetailsFromRaemisAPI() throws Exception {
		Certificate.doTrustToCertificates();
		String responseJson = super.pullData(Constants.SUBSCRIBER_URL);
		JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(responseJson);
        JSONArray data = (JSONArray) json.get("data");
		//System.out.println("SUBSCRIBER RESPONSE ----: " + data.toString());
		if (responseJson != null && !responseJson.isEmpty())
			new SubscriberDAO().pollRecords((List<Subscriber>) Util.parseJsonStrToObject(data.toString(), Constants.SUBSCRIBER));
	}
	
	/*
	 * public static void main(String[] args) { try { new
	 * SubscriberService().pull_SubsriberDetailsFromRaemisAPI(); } catch (Exception
	 * e) { e.printStackTrace(); } }
	 */
}
