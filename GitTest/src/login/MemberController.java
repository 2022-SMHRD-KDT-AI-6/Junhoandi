package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberController {
	// main에서 호출하는 기능들을 관리할수 있는 클래스
		// 모든 메소드에서 객체를 사용할 수 있도록 전역변수 지정!
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<UserList> list = new ArrayList<UserList>();
		// 기능 수행결과를 담을 수 있는 변수 생성
		int row = 0;

		// JDBC 접속을 위한 메소드 생성! => getCon()
		public void getCon() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr"; // 데이터베이스 계정
				String password = "hr"; // 비밀번호
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	//객체를 닫아줄수 있는 close() 생성
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

		// jdbc 저장하기 위한 메소드
		// insert
		public int insert(MemberDto dto) {
			getCon();
			try {
				String insertQuery = "insert into mem values(?, ?, ?)";
				psmt = conn.prepareStatement(insertQuery);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());
				psmt.setString(3, dto.getName());
				row = psmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("연결 실패");
				e.printStackTrace();
			} finally {
				close();
			}
			return row;
		}

		// update
		public int update(MemberDto dto) {
			getCon();
			try {
				String updateQuery = "update mem " + "set mem_pw = ?, mem_name =? where mem_id=?";
				psmt = conn.prepareStatement(updateQuery);
				psmt.setString(1, dto.getPw());
				psmt.setString(2, dto.getName());
				psmt.setString(3, dto.getId());
				row = psmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("연결 실패");
				e.printStackTrace();
			} finally {
				close();
			}
			return row;
		}

		// delete
		public int delete(MemberDto dto) {
			getCon();

			try {
				String deleteQuery = "delete from mem where mem_id = ?";
				// DB로 전송하기 위한 sql문 담기!
				psmt = conn.prepareStatement(deleteQuery);
				psmt.setString(1, dto.getId());
				row = psmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("연결 실패");
				e.printStackTrace();
			} finally {
				close();
			}
			return row;
		}

		// select
		public MemberDto select(MemberDto dto) {
			getCon();
			try {
				String selectQuery = "select mem_id, mem_pw from mem where mem_name=" + "'" + dto.getName() + "'";
				psmt = conn.prepareStatement(selectQuery);
				rs = psmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						String id = rs.getString("mem_id");
						String pw = rs.getString("mem_pw");
						dto = new MemberDto(id,pw);
					}
				} 
			} catch (SQLException e) {
				System.out.println("연결 실패");
				e.printStackTrace();
			} finally {
				close();
			}
			return dto;
		}

	}
