package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	/**
	* データベースURL
	*/
	private static final String URL = "jdbc:mysql://localhost:3306/item_manager_db";

	/**
	 * ユーザ
	 */
	private static final String USER = "itemU";

	/**
	 * パスワード
	 */
	private static final String PASSWORD = "itemP";

	/**
	 * データベース接続確立しコネクションを返す
	 * @return コネクション
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// ドライバの読み込み
		Class.forName("com.mysql.jdbc.Driver");
		// データベース接続確立
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
