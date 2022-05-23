import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pController {

	// Main에서 호출하는 기능들을 관리할 수 있는 클래스

	// 모든 메소드에서 객체를 사용할 수 있도록 전역변수를 지정!
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	// 기능 수행결과를 담을 수 있는 변수 생성
	int row = 0;

	// JDBC 접속을 위한 메소드 생성! --> getCon();
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";

			String user = "cgi_8_0516_4";
			String password = "smhrd4";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 객체를 담아줄 수 있는 close메소드 생성
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("반납 오류");
			e.printStackTrace();
		}

	}
}
