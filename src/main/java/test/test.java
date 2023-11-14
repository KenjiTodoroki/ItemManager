package test;

import java.sql.SQLException;

import model.dao.UserDAO;
import model.entity.UserBean;

public class test {

	public static void main(String[] args) {
		//		try {
		//			Connection con = ConnectionManager.getConnection();
		//			System.out.println("成功");
		//		} catch (ClassNotFoundException | SQLException e) {
		// TODO 自動生成された catch ブロック
		//			e.printStackTrace();
		//			System.out.println("失敗");
		//		}

		UserBean user2 = new UserBean();
		user2.setUserId("山田");
		user2.setPassword("太郎");
		System.out.println(user2.getUserId());
		System.out.println(user2.getPassword());

		UserBean user = new UserBean();

		user.setUserId("中村");
		//user.setPassword("小屋町");

		UserDAO dao = new UserDAO();

		try {
			user = dao.checkLogin("user", "password");

			if (user != null) {
				System.out.println("ログイン成功");
			} else {
				System.out.println("ログイン失敗");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("接続失敗");
		}
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());

		introduce();
		introduce2("山田");
		introduce3("山田", 1);
		System.out.println(multiply(3, 2));
		System.out.println(triangle(6, 5));
		System.out.println(circle(3));
		System.out.println(sumLoop(1, 100));
		for (String fruit : getFruits()) {
			System.out.println(fruit);
		}
		timesTable();

	}

	public static void introduce() {
		System.out.println("私の名前は山田太郎です。");
	}

	public static void introduce2(String name) {
		System.out.println("私の名前は" + name + "です。");
	}

	public static void introduce3(String name, int age) {
		System.out.println("私の名前は" + name + "です。年齢は" + age + "歳です。");
	}

	public static int multiply(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}

	public static double triangle(double num1, double num2) {
		double result = (num1 * num2) / 2;
		return result;
	}

	public static double circle(double radius) {
		double result = Math.pow(radius, 2) * Math.PI;
		return result;
	}

	public static int sumLoop(int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
			result = result + i;
		}
		return result;
	}

	public static String[] getFruits() {
		String Fruits[] = { "りんご", "バナナ", "ぶどう", "キウイ", "もも" };
		return Fruits;
	}

	public static void timesTable() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int result = i * j;

				System.out.printf(" %2d", result);
			}
			System.out.println();
		}
	}
}
