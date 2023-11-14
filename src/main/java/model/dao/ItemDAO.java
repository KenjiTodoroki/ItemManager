package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDAO {

	public void registerItem(String itemName, String makerCode, int price) throws ClassNotFoundException, SQLException {

		// プレースホルダー3つのSQL文
		String sql = "INSERT INTO m_item (item_name, maker_code, price) VALUES (?, ?, ?)";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, itemName);
			pstmt.setString(2, makerCode);
			pstmt.setInt(3, price);

			// SQL文の実行
			pstmt.executeUpdate();

		}
	}
}
