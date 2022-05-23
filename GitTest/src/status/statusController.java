package status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class statusController {
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_8_0516_4";
			String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		}
	}

	public boolean show(statusDTO DTO) {
		getCon();
		try {
			String sql = "select p_name, p_lv, p_hp, p_con from dmon where p_name= '?'";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, DTO.getName());
			rs = psmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String name = rs.getString("p_name");
					int lv = rs.getInt("p_lv");
					int hp = rs.getInt("p_hp");
					String con = rs.getString("p_con");
					DTO = new statusDTO(name, lv, hp, con);
				}
			}
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			close();
		}
		return true;
	}
}
