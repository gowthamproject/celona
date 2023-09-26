package com.wipro.celona.poll;

import com.wipro.celona.services.SubscriberService;

import java.util.TimerTask;

public class SubscriberPolling extends TimerTask {

	@Override
	public void run() {
		try {
			startPolling();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void startPolling() throws Exception {
		new SubscriberService().pull_SubsriberDetailsFromRaemisAPI();

	}
}
