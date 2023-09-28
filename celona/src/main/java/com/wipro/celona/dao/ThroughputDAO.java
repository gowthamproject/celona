package com.wipro.celona.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.wipro.celona.common.Core5GDetails;
import com.wipro.celona.model.Throughput;

public class ThroughputDAO implements DAOInterface<Throughput> {

	private static final String INSERT_SUBSCRIBER_THROUGHPUT_QUERY = "INSERT INTO subscriber_5g_throughput VALUES";
	private static Connection connection = null;

	public ThroughputDAO() {
		connection = DAOConnection.create_connection();
	}

	public void insertRecords(List<Throughput> listOfData) throws SQLException {
		for (Throughput data : listOfData) {
			insertRecord(data);
		}
	}

	@Override
	public void insertRecord(Throughput data) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			String queryParam = "('" + Core5GDetails._5G_CORE_ID + "', '" + data.getParentId() + "', '"
					+ data.getDatetime() + "'," + " '" + data.getUplink() + "', '" + data.getDownlink() + "')";
			int res = statement.executeUpdate(INSERT_SUBSCRIBER_THROUGHPUT_QUERY + queryParam);
			if (res != 0) {
				// System.out.println("subscriber id ----:" + data.getNmsId() + " successfully
				// polled.!");
			}
		} catch (SQLException e) {
			connection.close();
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrInsertRecords(List<Throughput> listOfData) throws SQLException {
		insertRecords(listOfData);
	}

	public void pollRecords(List<Throughput> listOfData) throws SQLException, InterruptedException {
		updateOrInsertRecords(listOfData);
		System.out.println("Subscriber Throughput records are polling..");
	}

	@Override
	public void updateRecord(Throughput data) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Throughput> getRecordByParam(Map<String, Object> paramMap) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecords(List<String> params) throws SQLException {
		// TODO Auto-generated method stub

	}
}
