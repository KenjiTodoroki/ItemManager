package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ItemDAO;
import model.dao.MakerDAO;
import model.entity.MakerBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/item-register")
public class ItemRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public ItemRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションの有無を確認
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("user") != null) { //セッション有の場合
			String url = "item-register.jsp"; // 商品登録画面のパスを設定

			MakerDAO dao = new MakerDAO(); // UserDAOクラスをインスタンス化

			//データベースからメーカマスタの一覧を取得
			try {
				List<MakerBean> records = dao.getAllrecords();
				request.setAttribute("records", records); //一覧をセット
				// 例外キャッチ
			} catch (ClassNotFoundException | SQLException e) {

				//エラーメッセージをセット
				request.setAttribute("errorMessage", "SQL操作時に例外が発生しました。");
				e.printStackTrace();
			}

			// 転送
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} else { //セッション無の場合

			// 転送
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String itemName = request.getParameter("itemName"); // 商品名
		String makerCode = request.getParameter("makerCode"); // メーカーコード
		int price = Integer.parseInt(request.getParameter("price")); // 価格

		ItemDAO dao = new ItemDAO(); // ItemDAOクラスをインスタンス化

		// try-catchで例外処理
		try {
			// 商品情報を登録
			dao.registerItem(itemName, makerCode, price);

			// 例外キャッチ
		} catch (ClassNotFoundException | SQLException e) {

			//エラーメッセージをセット
			request.setAttribute("errorMessage", "SQL操作時に例外が発生しました。");
			e.printStackTrace();
		}

		// 転送
		String url = "menu.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		

	}

}
