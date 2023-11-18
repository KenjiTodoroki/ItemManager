package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/itemDetail")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemDetailServlet() {
		super();
	}

	/**
	 * GETリクエストを受け付けて、DBからデータを取得する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング（文字化けを防ぐ）
		request.setCharacterEncoding("UTF-8");
		// データベース接続に必要な情報
		final String DSN = "jdbc:mysql://localhost:3306/item_manager_db";
		final String USER = "itemU";
		final String PASSWORD = "itemP";
		//DBの内容を表示するための準備
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();

		Connection con = null;

		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(DSN, USER, PASSWORD);
			// SQLを実行
			String sql = "SELECT * FROM m_item";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String[] data = new String[6];
				data[0] = rs.getString("item_id");
				data[1] = rs.getString("item_name");
				data[2] = rs.getString("maker_code");
				data[3] = rs.getString("price");
				data[4] = rs.getString("insert_datatime");
				data[5] = rs.getString("update_datatime");
				list.add(data);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			System.out.println("例外発生:" + e.getMessage());
			e.printStackTrace();
		}
		// リクエストスコープへオブジェクト設定する
		request.setAttribute("data", list);

		// 次の画面に遷移
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/item-detail.jsp");
		rd.forward(request, response);
	}

}
