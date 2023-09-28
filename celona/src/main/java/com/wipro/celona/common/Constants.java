package com.wipro.celona.common;

public class Constants {

	// ----------------- Endpoint Constants --------------
	public static final String CELONA_ENDPOINT = "https://beta-cso.celonanetworks.com";
	public static final String SITE_URL = CELONA_ENDPOINT + "/v1/api/cfgm/sites";
	public static final String CUSTOMER_URL = CELONA_ENDPOINT + "/v1/api/cfgm/customers";
	public static final String CUSTOMER_FEATURE_FLAG_URL = CELONA_ENDPOINT + "/v1/api/cfgm/customers";
	public static final String SUBSCRIBER_URL = CELONA_ENDPOINT + "/v1/api/cfgm/devices";
	public static final String GNB_URL = CELONA_ENDPOINT + "/v1/api/cfgm/enodebs";
	public static final String ALARM_URL = CELONA_ENDPOINT + "/v2/api/events/query";
	public static final String THROUGHPUT_URL = CELONA_ENDPOINT + "/v1/api/stats/msThroughput";

	/*
	 * public static final String SESSION_URL = RAEMIS_ENDPOINT + "/api/session";
	 * public static final String SUBSCRIBER_URL = RAEMIS_ENDPOINT + "/api/subscriber";
	 * public static final String NETDEVICE_URL = RAEMIS_ENDPOINT +
	 * "/api/net_device"; public static final String MGW_CTRL_FLOW_STATS_URL =
	 * RAEMIS_ENDPOINT + "/api/mgw_ctrl_flow_stats"; public static final String
	 * GNB_URL = RAEMIS_ENDPOINT + "/api/gnb"; public static final String
	 * PDU_SESSON_URL = RAEMIS_ENDPOINT + "/api/ngap_context";
	 * 
	 */
	public static final String MGW_CTRL_FLOW_STATS_URL = null;


	// ----------------- Operation Constants --------------
	public static final String ALARM = "Alarm";
	public static final String SUBSCRIBER = "Subscriber";
	public static final String NETDEVICE = "NetDevice";
	public static final String THROUGHPUT = "Throughput";
	public static final String GNB = "gNB";
	public static final String SITE = "Site";
	public static final String _5G_CORE = "5GCore";
	public static final String PDU_SESSION = "PDU";

	public static final String CUSTOMER = "Customer";

	// ----------------- Throughput Constants --------------

	public static final String UP_LINK = "0";
	public static final String DOWN_LINK = "1";
	public static final String _5G = "SMF";
	public static final String DIRECTION[] = { UP_LINK, DOWN_LINK };

	// --------------- Poll Interval Constants ---------------

	public static final int POLL_INTERVAL_5_SEC = 5000;
	public static final int POLL_INTERVAL_10_SEC = 10000;
	public static final int POLL_INTERVAL_15_SEC = 15000;
	public static final int BETWEEN_10_SEC = 10000;
	public static final int BETWEEN_100_SEC = 100000;


	public static final String[] SEVIRITY = { "Critical", "Major", "Warning", "Minor" };
	public static final String[] ALARM_STATUS = { "Closed", "Open" };

	// ---------------utils ----------------------

	public static final String DETACHED = "DETACHED";
	public static final String ATTACHED = "ATTACHED";

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	public static final String OFFLINE = "Offline";
	
	public static final String CONNECTED = "Connected";
	public static final String DISCONNECTED = "Disconnected";

}
