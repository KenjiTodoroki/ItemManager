package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("/login");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションの有無を確認
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("user") != null) { //セッション有の場合

			UserBean user = (UserBean) session.getAttribute("user"); //ユーザー情報取得
			request.setAttribute("id", user.getUserId()); //ユーザIDをセット

			session.invalidate(); //セッションを無効

			String url = "logout.jsp"; // 遷移先jsp

			// 転送
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} else { //セッション無の場合
			// 転送
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);
		}
	}
}
