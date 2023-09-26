package com.wipro.celona.poll;

import java.util.TimerTask;

import com.wipro.celona.services.LocationService;

public class LocationPolling extends TimerTask {

	@Override
	public void run() {
		try {
			new LocationService().pull_SitesDetailsFromRaemisAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
