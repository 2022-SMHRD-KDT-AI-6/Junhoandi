package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberController {
	// main���� ȣ���ϴ� ��ɵ��� �����Ҽ� �ִ� Ŭ����
		// ��� �޼ҵ忡�� ��ü�� ����� �� �ֵ��� �������� ����!
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<UserList> list = new ArrayList<UserList>();
		// ��� �������� ���� �� �ִ� ���� ����
		int row = 0;

		// JDBC ������ ���� �޼ҵ� ����! => getCon()
		public void getCon() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr"; // �����ͺ��̽� ����
				String password = "hr"; // ��й�ȣ
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	//��ü�� �ݾ��ټ� �ִ� close() ����
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

		// jdbc �����ϱ� ���� �޼ҵ�
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
				System.out.println("���� ����");
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
				System.out.println("���� ����");
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
				// DB�� �����ϱ� ���� sql�� ���!
				psmt = conn.prepareStatement(deleteQuery);
				psmt.setString(1, dto.getId());
				row = psmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("���� ����");
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
				System.out.println("���� ����");
				e.printStackTrace();
			} finally {
				close();
			}
			return dto;
		}

	}
