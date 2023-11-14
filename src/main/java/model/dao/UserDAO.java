package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	/**
	 * 入力されたuserId、passwordがデータベースに登録されているかチェック
	 * @param id ユーザID
	 * @param password パスワード
	 * @return UserBean ユーザ情報
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserBean checkLogin(String id, String password) throws ClassNotFoundException, SQLException {
		// ユーザ情報を格納する変数
		UserBean user = null;

		// プレースホルダー2つのSQL文
		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();

			// id、passwordが一致する情報がデータベースにあれば、UserBeanをインスタンス化し、各カラムの値をインスタンスにセット
			if (res.next()) {
				user = new UserBean();
				user.setUserId(res.getString("user_id"));
				user.setPassword(res.getString("password"));
			}
		}
		return user;
	}
}
