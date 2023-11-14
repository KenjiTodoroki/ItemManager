package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.MakerBean;

public class MakerDAO {

	public List<MakerBean> getAllrecords() throws ClassNotFoundException, SQLException {

		//SQL結果格納用の変数
		List<MakerBean> records = new ArrayList<>();

		// SQL文
		String sql = "SELECT * FROM m_maker ORDER BY maker_code ASC";

		// try-with-resourcesを使用し、データベース接続確立と該当レコード取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();

			// データベースのレコード毎に各カラムの値をセット
			while (res.next()) {
				MakerBean maker = new MakerBean();
				maker.setMakerCode(res.getString("maker_code"));
				maker.setMakerName(res.getString("maker_name"));
				records.add(maker);
			}
		}
		return records;
	}
}
