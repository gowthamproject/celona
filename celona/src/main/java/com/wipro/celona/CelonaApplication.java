package com.wipro.celona;

import java.util.Timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.celona.common.Constants;
import com.wipro.celona.poll.GNBPolling;
import com.wipro.celona.poll.LocationPolling;
import com.wipro.celona.poll.SubscriberPolling;

@SpringBootApplication
public class CelonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CelonaApplication.class, args);
		System.out.println("Celona Client Application Starting...");

		new Timer().schedule(new SubscriberPolling(), 0, Constants.POLL_INTERVAL_10_SEC);
		System.out.println("Subscriber Polling Polling Activated...");
		
		/*
		 * new Timer().schedule(new GNBPolling(), 0, Constants.POLL_INTERVAL_10_SEC);
		 * System.out.println("GNB Polling Polling Activated...");
		 */

		new Timer().schedule(new LocationPolling(), 0, Constants.POLL_INTERVAL_10_SEC);
		System.out.println("Location Polling Polling Activated...");
		
	}
}
