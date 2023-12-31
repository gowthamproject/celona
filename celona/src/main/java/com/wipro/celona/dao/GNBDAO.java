package com.wipro.celona.dao;

import com.wipro.celona.common.Constants;
import com.wipro.celona.common.Core5GDetails;
import com.wipro.celona.model.GNB;
import com.wipro.celona.model.Radios;
import com.wipro.celona.utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GNBDAO implements DAOInterface<GNB> {
	private static final String INSERT_GNB_QUERY = "INSERT INTO gnb VALUES";
	private static final String VIEW_GNB_QUERY = "SELECT * FROM gnb";
	private static final String UPDATE_GNB_QUERY = "UPDATE gnb SET plmn_id=?, name=?, status=? where gnb_id=?";
	private static final String DELETE_GNB_QUERY = "DELETE from gnb where core_id = '" + Core5GDetails._5G_CORE_ID
			+ "' and gnb_id=";

	private static Connection connection = null;

	public GNBDAO() {
		connection = DAOConnection.create_connection();
	}

	@Override
	public List<GNB> getRecordByParam(Map<String, Object> paramMap) throws SQLException {
		List<GNB> gnbs = new ArrayList<GNB>();
		try (Statement statement = connection.createStatement()) {
			String param = Util.parseAndGetSqlParam(paramMap);
			ResultSet resultSet = statement.executeQuery(VIEW_GNB_QUERY + param);

			while (resultSet.next()) {
				GNB gnb = new GNB();
				gnb.setName(resultSet.getString(1));
				gnb.setId(resultSet.getInt(3));
				gnb.setState(resultSet.getString(6));
				gnbs.add(gnb);
			}
		} catch (SQLException e) {
			connection.close();
			System.out.println("Connection Closed while fetching gnb records");
		}
		return gnbs;
	}

	@Override
	public void insertRecords(List<GNB> listOfData) throws SQLException {
		for (GNB data : listOfData) {
			insertRecord(data);
		}
	}

	@Override
	public void insertRecord(GNB data) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			String status = getState(data.getRadios());
			String queryParam = "('" + data.getName() + "', '" + data.getPlmn_id() + "', " + data.getId() + ", " + null
					+ "," + " '" + data.getIp_address() + "', '" + status + "','" + Core5GDetails._5G_CORE_ID + "')";

			int res = statement.executeUpdate(INSERT_GNB_QUERY + queryParam);
			if (res != 0) {
				// System.out.println("gnb id ----:" + data.getGnb_id() + " successfully
				// polled.!");
			}
		} catch (SQLException e) {
			connection.close();
			System.out.println("Connection Closed while inserting gnb records");
		}

	}

	private String getState(List<Radios> radios) {
		String state = Constants.DISCONNECTED;
		for (Radios radio : radios) {
			if (radio.getOp_status() == 4) {
				state = Constants.CONNECTED;
			}
		}
		return state;
	}

	@Override
	public void updateRecord(GNB data) throws SQLException {
		{
			try {
				String status = getState(data.getRadios());
				PreparedStatement preparedStmt = connection.prepareStatement(UPDATE_GNB_QUERY);
				preparedStmt.setString(1, data.getPlmn_id());
				preparedStmt.setString(2, data.getName());
				preparedStmt.setString(3, status);
				preparedStmt.setInt(4, data.getId());
				int res = preparedStmt.executeUpdate();
				if (res != 0) {
					// System.out.println("gnb ----:" + data.getName() + " successfully updated.!");
				}
			} catch (SQLException e) {
				connection.close();
				System.out.println("Connection Closed while updating gnb records");
			}
		}
	}

	@Override
	public void deleteRecords(List<String> params) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			for (String param : params) {
				statement.executeUpdate(DELETE_GNB_QUERY + param);
			}
		} catch (SQLException e) {
			connection.close();
		}
	}

	public void deleteRecordss(List<Integer> params) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			for (Integer param : params) {
				statement.executeUpdate(DELETE_GNB_QUERY + param);
			}
		} catch (SQLException e) {
			connection.close();
		}
	}

	@Override
	public void updateOrInsertRecords(List<GNB> listOfData) throws SQLException {
		if (listOfData == null || listOfData.isEmpty())
			return;

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("core_id", Core5GDetails._5G_CORE_ID);
		List<GNB> existingGNBs = getRecordByParam(paramMap);

		if (existingGNBs.isEmpty()) {
			insertRecords(listOfData);
		} else {

			List<Integer> existingGNBIds = existingGNBs.stream().map(gnb -> gnb.getId()).collect(Collectors.toList());
			List<Integer> currentGNBIds = listOfData.stream().map(gnb -> gnb.getId()).collect(Collectors.toList());

			List<Integer> deleteGNBs = existingGNBIds.stream().filter(i -> !currentGNBIds.contains(i))
					.collect(Collectors.toList());
			deleteRecordss(deleteGNBs);
			List<GNB> insertGNBs = listOfData.stream().filter(i -> !existingGNBIds.contains(i.getId()))
					.collect(Collectors.toList());
			insertRecords(insertGNBs);

			for (GNB curr_gnb : listOfData) {
				for (GNB ext_gnb : existingGNBs) {
					if (curr_gnb.getId() == ext_gnb.getId()) {
						String status = getState(curr_gnb.getRadios());
						if (!status.equals(ext_gnb.getState()))
							updateRecord(curr_gnb);
					}
				}
			}
		}
	}

	@Override
	public void pollRecords(List<GNB> listOfData) throws SQLException, InterruptedException {
		updateOrInsertRecords(listOfData);
		System.out.println("Celona::gNB records are polling..");
	}
}
