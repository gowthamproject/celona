package com.wipro.celona.dao;

import com.wipro.celona.common.Constants;
import com.wipro.celona.common.Core5GDetails;
import com.wipro.celona.model.Subscriber;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubscriberDAO implements DAOInterface<Subscriber> {

	private static final String DELETE_SUBSCRIBER_QUERY = "DELETE FROM subscriber where imsi=";
	private static final String INSERT_SUBSCRIBER_QUERY = "INSERT INTO subscriber VALUES";
	private static final String UPDATE_SUBSCRIBER_QUERY = "UPDATE subscriber SET local_ps_attachment=?, name=? where imsi=?";
	private static final String VIEW_SUBSCRIBER_QUERY = "SELECT * FROM subscriber";
	private static Connection connection = null;

	public SubscriberDAO() {
		connection = DAOConnection.create_connection();
	}

	@Override
	public void insertRecords(List<Subscriber> listOfData) throws SQLException {
		for (Subscriber data : listOfData) {
			String status = data.getOp_status_name().equals(Constants.OFFLINE)
					? Constants.DETACHED :Constants.ATTACHED;
			data.setOp_status_name(status);
			insertRecord(data);
		}
	}

	@Override
	public void insertRecord(Subscriber data) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			String queryParam = "(" + data.getId() + ", '" + data.getImsi() + "', " + null + "," + null + "," + " '"
					+ data.getImei() + "', " + null + ", " + null + "," + " " + null + ", '"
					+ data.getOp_status_name() + "'," + " " + null + ", '" + data.getIp_address() + "', '"
					+ data.getDescription() + "' , '" + Core5GDetails._5G_CORE_ID + "')";

			int res = statement.executeUpdate(INSERT_SUBSCRIBER_QUERY + queryParam);
			if (res != 0) {
				// System.out.println("subscriber ----:" + data.getId() + " successfully
				// polled.!");
			}
		} catch (SQLException e) {
			connection.close();
			System.out.println("Connection Closed while inserting subscriber records");
		}
	}

	@Override
	public void updateRecord(Subscriber data) throws SQLException {
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(UPDATE_SUBSCRIBER_QUERY);
			preparedStmt.setString(1, data.getOp_status_name());
			preparedStmt.setString(2, data.getDescription());
			preparedStmt.setString(3, data.getImsi());
			int res = preparedStmt.executeUpdate();
			if (res != 0) {
				// System.out.println("subscriber ----:" + data.getId() + " successfully
				// updated.!");
			}
		} catch (SQLException e) {
			connection.close();
			System.out.println("Connection Closed while updating subscriber records");
		}
	}

	@Override
	public List<Subscriber> getRecordByParam(Map<String, Object> paramMap) throws SQLException {
		List<Subscriber> subscribers = new ArrayList<Subscriber>();
		try (Statement statement = connection.createStatement()) {
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
			ResultSet resultSet = statement.executeQuery(VIEW_SUBSCRIBER_QUERY + sb);

			while (resultSet.next()) {
				Subscriber subscriber = new Subscriber();
				subscriber.setImsi(resultSet.getString(2));
				subscriber.setImei(resultSet.getString(5));
				subscriber.setOp_status_name(resultSet.getString(9));
				subscribers.add(subscriber);
			}
		} catch (SQLException e) {
			connection.close();
			System.out.println("Connection Closed while fetching gnb records");
		}
		return subscribers;
	}

	@Override
	public void updateOrInsertRecords(List<Subscriber> listOfData) throws SQLException {

		if (listOfData == null || listOfData.isEmpty())
			return;

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("core_id", Core5GDetails._5G_CORE_ID);
		List<Subscriber> existingSubscribers = getRecordByParam(paramMap);

		if (existingSubscribers.isEmpty()) {
			insertRecords(listOfData);
		} else {

			List<String> existingSubscribersImsi = existingSubscribers.stream().map(sub -> sub.getImsi())
					.collect(Collectors.toList());
			List<String> currentSubscribersImsi = listOfData.stream().map(sub -> sub.getImsi())
					.collect(Collectors.toList());

			List<String> deleteSubscribers = existingSubscribersImsi.stream()
					.filter(i -> !currentSubscribersImsi.contains(i)).collect(Collectors.toList());
			deleteRecords(deleteSubscribers);
			List<Subscriber> insertSubscribers = listOfData.stream()
					.filter(i -> !existingSubscribersImsi.contains(i.getImsi())).collect(Collectors.toList());
			insertRecords(insertSubscribers);

			for (Subscriber curr_sub : listOfData) {
				for (Subscriber ext_sub : existingSubscribers) {
					if (curr_sub.getImsi().equals(ext_sub.getImsi())) {
						String status = curr_sub.getOp_status_name().equals(Constants.OFFLINE)
								? Constants.DETACHED :Constants.ATTACHED;
						if (!status.equals(ext_sub.getOp_status_name())) {
							curr_sub.setOp_status_name(status);
							updateRecord(curr_sub);
						}
					}
				}
			}
		}
	}

	@Override
	public void deleteRecords(List<String> params) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			for (String param : params) {
				statement.executeUpdate(DELETE_SUBSCRIBER_QUERY + "'" + param + "'");
			}
		} catch (SQLException e) {
			connection.close();
		}
	}

	@Override
	public void pollRecords(List<Subscriber> listOfData) throws SQLException, InterruptedException {
		updateOrInsertRecords(listOfData);
		System.out.println("Celona::Subscriber records are polling..");
	}
}
