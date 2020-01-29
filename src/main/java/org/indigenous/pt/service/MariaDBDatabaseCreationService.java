package org.indigenous.pt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MariaDBDatabaseCreationService implements DatabaseCreationService {

	@Resource
	private Environment env;

	@Override
	public void createDatabase(String projectName) {
		String url = env.getProperty("mariadb.db.instance");
		String user = env.getProperty("mariadb.db.user");
		String password = env.getProperty("mariadb.db.password");
		Connection conn;
		try {
			conn = DriverManager.getConnection(url + "/?user=" + user + "&password=" + password);
			Statement s = conn.createStatement();
			s.executeUpdate("CREATE DATABASE " + projectName.toLowerCase());
			s.executeUpdate("CREATE USER '" + projectName.toLowerCase() + "'@'%' IDENTIFIED BY '"
					+ projectName.toLowerCase() + "'");
			s.executeUpdate("GRANT ALL PRIVILEGES ON " + projectName.toLowerCase() + ".* TO '"
					+ projectName.toLowerCase() + "'@'localhost'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
