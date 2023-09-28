package com.wipro.celona.services;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.wipro.celona.certificate.Certificate;
import com.wipro.celona.common.Constants;
import com.wipro.celona.dao.LocationDAO;
import com.wipro.celona.model.GNB;
import com.wipro.celona.model.Location;
import com.wipro.celona.model.Site;
import com.wipro.celona.utils.Util;

public class LocationService extends CelonaService {

	public void pull_SitesDetailsFromRaemisAPI() throws Exception {

		Certificate.doTrustToCertificates();
		new GNBService().pull_GNBDetailsFromRaemisAPI();
		String responseJson = super.pullData(Constants.SITE_URL);
		if (responseJson != null && !responseJson.isEmpty()) {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(responseJson);
			JSONArray data = (JSONArray) json.get("data");
			// System.out.println("LOCATION RESPONSE ----: " + data.toString());
			List<Site> sites = (List<Site>) Util.parseJsonStrToObject(data.toString(), Constants.SITE);
			List<GNB> gNBs = GNBService.getGNB_LIST();
			if (gNBs.isEmpty())
				System.out.println("GNB RECORD NOT COMING.....................................");

			new LocationDAO().pollRecords(getLocations(sites, gNBs));
		}
	}

	private List<Location> getLocations(List<Site> sites, List<GNB> gNBs) {
		List<Location> locations = new ArrayList<Location>();
		Location location = null;
		for (Site site : sites) {
			for (GNB gnb : gNBs) {
				if (site.getId() == gnb.getSite_id()) {
					location = new Location();
					location.setGnb_id(gnb.getId());
					location.setGnb_name(gnb.getName());
					location.setLatitude(site.getMap_lat());
					location.setLongitude(site.getMap_long());
					location.setRegion_state("California");
					locations.add(location);
				}
			}
		}
		return locations;
	}

	public static void main(String[] args) {
		try {
			new LocationService().pull_SitesDetailsFromRaemisAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
