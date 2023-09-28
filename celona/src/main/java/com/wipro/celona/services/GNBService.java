package com.wipro.celona.services;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.dao.GNBDAO;
import com.wipro.celona.model.GNB;
import com.wipro.celona.utils.Util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GNBService extends CelonaService {

	private static List<GNB> GNB_LIST = new ArrayList<GNB>();

	@SuppressWarnings("unchecked")
	public void pull_GNBDetailsFromRaemisAPI() throws Exception {

		Certificate.doTrustToCertificates();
		String responseJson = super.pullData(Constants.GNB_URL);
	
		if (responseJson != null && !responseJson.isEmpty()) {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(responseJson);
			JSONArray data = (JSONArray) json.get("data");
			//System.out.println("GNB RESPONSE ----: " + data.toString());
			List<GNB> gnbList = (List<GNB>) Util.parseJsonStrToObject(data.toString(), Constants.GNB);
			setGNB_LIST(gnbList);
			new GNBDAO().pollRecords(GNB_LIST);
		}
	}

	public static List<GNB> getGNB_LIST() {
		return GNB_LIST;
	}

	public static void setGNB_LIST(List<GNB> gNB_LIST) {
		GNB_LIST = gNB_LIST;
	}

	/*
	 * public static void main(String[] args) { try { new
	 * GNBService().pull_GNBDetailsFromRaemisAPI(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	 
}
