package status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.MemberDto;

public class statusController {
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	statusDTO sdto = new statusDTO();

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	

	public statusDTO show(statusDTO DTO) {
		getCon();
		try {
			String sql = "select * from dmon where p_name= ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, DTO.getName());
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("p_name");
				int lv = rs.getInt("p_lv");
				int hp = rs.getInt("p_hp");
				String con = rs.getString("p_con");
				int exp = rs.getInt("p_exp");
				int hgr = rs.getInt("p_hgr");
				int slp = rs.getInt("p_slp");
				
				DTO = new statusDTO(name, hp, lv, exp, con, hgr, slp);
			}
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			close();
		}
		return DTO;
	}
	
//	public statusDTO update(statusDTO dto) {
//		getCon();
//		try {
//			String updateQuery = "update dmon set p_hgr=? where p_name = ?";
//			psmt = conn.prepareStatement(updateQuery);
//			psmt.setInt(1, dto.getHgr()+2);
//			psmt.setString(2, dto.getName());
//
//		} catch (SQLException e) {
//			System.out.println("연결 실패");
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return ;
//	}


	
	}

