package com.wipro.celona.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.wipro.celona.common.Constants;
import com.wipro.celona.model.*;

import java.io.StringReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

	public static Object parseJsonStrToObject(String jsonStr, String oper) {

		jsonStr = jsonStr.replace("\"", "'");
		JsonReader reader = new JsonReader(new StringReader(jsonStr.trim()));
		reader.setLenient(true);

		switch (oper) {
		case Constants.ALARM:
			return Arrays.asList(new Gson().fromJson(reader, Alarm[].class));
		case Constants.SUBSCRIBER:
			return Arrays.asList(new Gson().fromJson(reader, Subscriber[].class));
		case Constants.GNB:
			return Arrays.asList(new Gson().fromJson(reader, GNB[].class));
		case Constants.SITE:
			return Arrays.asList(new Gson().fromJson(reader, Site[].class));
		case Constants.PDU_SESSION:
			return Arrays.asList(new Gson().fromJson(reader, PDUSession[].class));
		case Constants.CUSTOMER:
			return Arrays.asList(new Gson().fromJson(reader, Customer[].class));
		case Constants.THROUGHPUT:
			return new Gson().fromJson(reader, MS_Throughput.class);
		}
		return null;
	}

	public static Date between(Date startInclusive, Date endExclusive) {
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
		return new Timestamp(new Date(randomMillisSinceEpoch).getTime());
	}

	public static String getRandomIpAddr() {
		return randomNumber() + "." + randomNumber() + "." + randomNumber() + "." + randomNumber();
	}

	public static int randomNumber() {
		return new Random().nextInt((255 - 1) + 1) + 1;
	}

	public static Iterator<LocalDateTime> datesBetween(LocalDateTime start, LocalDateTime end, int periodInMinutes) {
		return new DatesBetweenIterator(start, end, periodInMinutes);
	}

	public static String changeDateFormat(long millis) {
		Date date = new Date(millis);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
	}

	private static class DatesBetweenIterator implements Iterator<LocalDateTime> {

		private LocalDateTime nextDate;
		private final LocalDateTime end;
		private final int periodInMinutes;

		private DatesBetweenIterator(LocalDateTime start, LocalDateTime end, int periodInMinutes) {
			this.nextDate = start;
			this.end = end;
			this.periodInMinutes = periodInMinutes;
		}

		@Override
		public boolean hasNext() {
			return nextDate.isBefore(end);
		}

		@Override
		public LocalDateTime next() {
			LocalDateTime toReturn = nextDate;
			nextDate = nextDate.plusMinutes(periodInMinutes);
			return toReturn;
		}
	}

	public static String parseAndGetSqlParam(Map<String, Object> paramMap) {
		if (paramMap.isEmpty())
			return "";
		StringBuffer sb = new StringBuffer(" where ");
		int mapSize = paramMap.size();
		int i = 1;
		for (String param : paramMap.keySet()) {
			Object obj = paramMap.get(param);
			if (obj instanceof String)
				sb.append(param).append("=").append("'" + paramMap.get(param) + "'");
			else if (obj instanceof Integer)
				sb.append(param).append("=").append(paramMap.get(param));
			if (i < mapSize) {
				sb.append(" and ");
			}
			i++;
		}
		return sb.toString();
	}

}
