import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pController {

	// Main���� ȣ���ϴ� ��ɵ��� ������ �� �ִ� Ŭ����

	// ��� �޼ҵ忡�� ��ü�� ����� �� �ֵ��� ���������� ����!
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	// ��� �������� ���� �� �ִ� ���� ����
	int row = 0;

	// JDBC ������ ���� �޼ҵ� ����! --> getCon();
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

	// ��ü�� ����� �� �ִ� close�޼ҵ� ����
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("�ݳ� ����");
			e.printStackTrace();
		}

	}
}
