package com.wipro.celona.poll;

import com.wipro.celona.services.GNBService;

import java.util.TimerTask;

public class GNBPolling extends TimerTask {

	@Override
	public void run() {
		try {
			startPolling();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void startPolling() throws Exception {

		new GNBService().pull_GNBDetailsFromRaemisAPI();
	}
}
