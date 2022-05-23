package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class 로그인_테스트 {

	public static void main(String[] args) throws InterruptedException {
//aa
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		boolean isStart = false;
		int row = 0;
		boolean isSearch = false;
		// try구문안에서 선언되면 지역변수가 되기때문에!!!!
		// finally구문에 닿기 위해서 맨 위로 빼는 작업을 진행했다.
		Scanner sc = new Scanner(System.in);
		level lv1 = new level(null, row, row, null);
		lv1.setName("test");
		lv1.setLv(1);
		lv1.setHp(20);
		lv1.setCon("좋음");
		
		
		// 로그인 시 필요한 데이터?
		// id,pw
		// 입력받을 수 있게 코드 작성
		
		
		String art4 = """
				
				
			      ⣤⣤⣤⣤⣤⣤⣤⡄⣿⣿⠀⠀⠀⣤⣤⣤⣤⣤⣤⣤⠀⢰⣿⡗⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣤⣤⣤⣤⣤⣤⠀⠀⢰⣿⡇⠀⠀⠀ ⣀⣤⣶⣶⣶⣶⣶⣤⣄⠀⠀⠀ ⣀⣀⣀⣀⣀⣀⠀⢰⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠁⣿⣿⠀⠀⠀⣿⣿⠉⠉⠉⠉⠉⠀⢸⣿⣇⣀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⣹⣿⠀⠀⢸⣿⡇⠀⠀⢰⣿⡏⠀⠀⠀⠀  ⠀⠉⣿⣷⠀⠀⠀⠛⠛⠛⠛⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⠀⠀⣿⣿⠀⠀⠀⣿⣿⣀⣀⣀⣀⣠⡄⢸⣿⡿⠿⠇⠀⠸⠿⠿⠿⢿⣿⡿⠿⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣶⣶⣶⣶⣿⡟⠀⠀⢸⣿⡇⠀⠀⠀⠛⠿⢷⣶⣶⣶⣶⠿⠟⠁⠀⠀ ⠀⠀   ⢸⣿⠇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀⣾⣿⠀⠀⣿⣿⠿⠇⠀⠿⠿⠿⠟⠛⠛⠛⠃⠸⠿⠇⠀⠀⣤⣤⣤⣤⣤⣼⣿⣧⣤⣤⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢀⣾⡿⠁⠀⠀⢸⣿⡇⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⠀⠀ ⠀⣠⣿⡟⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⢀⣀⣸⣿⣀⣿⣿⣤⡄⣿⣿⠀⠀⠀⠀⣶⣶⣶⣶⣶⣶⣶⣶⣶⡆⠀⠀⠉⢩⣭⡍⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⡿⠟⠀⠀⠀⠀⢸⣿⡇⠀⠈⠉⠉⠉⠉⠉⣿⣿⠉⠉⠉⠉⠉⠀⠀⣀⣴⣿⠟⠀⠀⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀ ⠀⠘⠟⠛⠛⠛⠛⠉⠉⠉⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⢸⣿⣇⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠀⠀⠀⠀  ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠈⠻⠛⠁⠀⠀⠀⠀⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠿⠇⠀⠀⠀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠘⠿⠇⠀⠀⠀⠀⠀⠀⠀⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠸⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
			⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
							
							
							""";
			for (int i = 0; i < art4.length(); i++) {
			System.out.print(art4.charAt(i));
			Thread.sleep(2);
			}
		
		
		
		

		String art = """
				                                                               .=+*#*:
				                                                        .=+*#@%@#+:
				                                                   :=*%%%##*#+:
				                                               .=*%#**+++#+:
				                                            :+##*+++==*+:
				                                        .+**++++++==+=
				                                     :=**++++++===++
				                                   +#+++++++=====*.
				                                 +#+++++++=====++
				                               :#+++++++======+=
				                             :++++++++=======+=                                             .====++*++===:.
				                           .*+++++++++=======#                                     .:=++*%%%#############%%%@@%*:
				                           %:++++++++++======*=.                             :==+*#*++++++++++++++++***====:.
				                           #:++++++++++++++++**+                        .=+**+++++++++++++++====**=:
				                          :*=++++++++====++=:                       =+**+==+++++++++=========*=:
				                          =+=+++++======*                        =**====++++++++=========:++:
				                          +=+++++=====+=                        @===+++++++++==========:++.
				                          #=+++++=====*.                      .%:=++++++++++==========:#.
				                          #=++++++++=++##                    =#:++++++++++++=========:#
				                          #+++++++++#+:              =+*####%*=++++++++++++++++=======+
				                         .#++++++++#.            :+##****+*#==++++++++++++======+****+%
				                         .*++++++*#           :+#******+*#+=+++++++++======+++==:.
				                         +*+++++*+         .+#******++*#*=+++++++++======#++:
				                         #+*++++*   ..:==+#*******++*#+==+++++++++=====*#+#@*
				                        .#****+*#####**********+++#*+=+++++++++++++===#++++*#
				                        %+*+++##************+++***=++++++++++++++++++=*++++**#
				                       =***+*#******+++++++++**+++++++++++++++++++=++++%*++**:=
				                      .#+*+*****+++++++++****+++++++++=+==********#****++++*+.#
				                     *%+******++++++*+***=++++++=====+*#**++++++++++++++++*=  #
				                    @+****+++++++++***+=*##**++*###***=++++++++++++++++++*.   #:
				                   #+***+++++++++++++=+++++*#**+++===++++++++**++*+++++=.    .*.
				                  :##**++++++++++++++++++++====+++++++++*=:.   ..             #
				                  %:#+++++++++++++++=++++++++++++++++++:                      #
				                 =@%#+++++++++++++++##**#+=+++++++++++                        *=
				                *##=*+++++++++++++*%.  :=**=++++++++*                :      .. =+
				               #*++*+=+++++++++++*%:@%==@:@=++++++++:               =+*:  ..    #=
				               =:+= ===++++++++++##:=*=== **=+++++++.            .... #*+=+==**+@*@+
				               #  = ++++++++++++*+*#**===+++++=.           ..... =+=      #%@%%+:
				               .*    .....:::::::::::====++==:.             ....===
				                 *=  =::=:            ==                     .::*=
				                   *+                 ==                   :*++
				                    %#%*:::           ==                    =.*
				                    @*#%* .==*#======::.                   =.
				                    +#**+=::.         .:::=:=++=         ..+
				                                                == ..    . +
				                                                 .+. .  . .+
				                                                   ==    =@:
				                                                    =#%+@%#@.
				                                                   .*###%@##
				                                                    .=:+*:

				""";
		for (int i = 0; i < art.length(); i++) {
			System.out.print(art.charAt(i));
			//Thread.sleep(2);
		}

		String art1 = """
				 ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄
				▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
				▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀
				▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌               ▐░▌               ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌
				▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▐░▌ ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌
				▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌
				▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▀   ▐░▌▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌     ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀      ▐░▌
				▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌                         ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌     ▐░▌       ▐░▌
				▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌▐░▌      ▐░▌      ▐░▌
				▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌
				 ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀       ▀         ▀  ▀         ▀       ▀



							""";

		for (int i = 0; i < art1.length(); i++) {
			System.out.print(art1.charAt(i));
			//Thread.sleep(2);
		}
		
		System.out.println("[파닥몬 키우기 로그인창]");
		System.out.println("파닥몬 키우기 로그인을 해주세요");
		System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");

		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==회원 가입==");
				// 휘바렁 데이터 : class를 실행만 시켰을때 저장되는 데이터
				// 비휘발성 데이터: 실행을 종료해도 남아있는 데이터
				System.out.println("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.println("pw를 입력해주세요 >> ");
				String pw = sc.next();
				System.out.println("이름을 입력해주세요 >> ");
				String name = sc.next();
				// 1. JDBC ---> ojdbc6.jar파일 가져오기
				// 1-1) 드라이버 동적로딩
				// 실행하는 순간에 자료형이 결정되는 것
				// Class.forName(name);

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					// 어떤 데이터베이스의 드라이버를 가지고 올껀지 정해주는 코드
					// 오류
					// 1) 런타임오류
					// by / zero
					// 1 / 0 ===>
					// 2) 컴파일 오류
					// oracle.jdbc.driver ---> 패키지
					// OracleDriver ----> 클래스
					// url, id, pw
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					// jdbc:oracle:thin : 드라이버
					// @localhost : ip주소
					// 1521 : 포트번호
					// xe : db이름
					String user = "hr"; // 데이터베이스 계정
					String password = "hr"; // 비밀번호

					conn = DriverManager.getConnection(url, user, password);
					// 2. sql문을 준비
					// 2-1) sql문 만들기
					
					String searchQuery = "select mem_id, mem_pw from mem where mem_id= ?";
					psmt =  conn.prepareStatement(searchQuery);
					psmt.setString(1, id);
					rs = psmt.executeQuery();
					if (rs.next() == true) {
						System.out.println("이미 아이디 값이 있습니다.");
						isSearch = true;
						System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					}
					
					if(isSearch == false)
					{
						//System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					String insertQuery = "insert into mem values(?, ?, ?)";
					// 2-2) sql문 전송
					psmt = conn.prepareStatement(insertQuery);
					// ----> sql구문 양식에 맞게 담아주는 구문

					// ? 인자를 채우어서 보내줄거에요!!!! <---- 입력받은 데이터로 채워주자
					psmt.setString(1, id);
					psmt.setString(2, pw);
					psmt.setString(3, name);

					// ? 인자가 table에 맞게 다 채워졌는지 확인하기
					// 영향을 받은 줄(테이블)이 있는지 확인을 해주는 기능
					row = psmt.executeUpdate();

					// row > 0 : 영향을 받은 테이블이 있다!!!!
					// 그게 아니라면 데이터가 입력이 안됬다.
					if (row > 0) {
						System.out.println("회원가입 성공!!!!");
						System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					} else {
						System.out.println("회원가입 실패!!!!");
					}
					}
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로딩 오류");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("연결 실패");
					e.printStackTrace();
				} finally {
					// 중간에 예외상황이 생기더라도 한번은 꼭 실행시키게 만드는 구문
					// 4. 닫기
					// ( 사용한 반대방향으로 닫자!!!1 역순으로 닫자!!!!)
					try {
						// psmt가 열려있다면 닫아주자
						// psmt에 값이 들어가 있으면 즉 null값이 아니라ㅏ면
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println("반납 오류");
						e.printStackTrace();
					}
				}
				
			} else if (menu == 2) {

				System.out.println("로그인하기");
				System.out.print("ID 입력 >> ");
				String id = sc.next();
				System.out.print("PW 입력 >> ");
				String pw = sc.next();
				// JDBC시작!
				// 사용자가 입력한 데이터가 실제 테이블에 존재하는 지 확인!
				// 1.데이터베이스 연결
				// 1-1) 드라이버 동적로딩
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					// exception -> try-catch잡아줘야하는 이유??
					// 1-2) 데이터베이스 연결
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "hr";
					String password = "hr";
					conn = DriverManager.getConnection(url, user, password);
					// 2.Query문 전송
					// 2-1) sql문 작성
					String sql = "select * from mem where mem_id = ? and mem_pw = ? ";
					// *의미는? --> 전체 컬럼!!!!!
					// 2-2) sql문 규격에 맞게 담아주기!
					psmt = conn.prepareStatement(sql);
					// 2-3) ?인자 채워주기!
					psmt.setString(1, id);
					psmt.setString(2, pw);
					// 2-4) sql문장 전송하기
					// executeQuery --> select구문을 사용할때 쓰는 메소드!
					// executeUpdate
					// --> insert,update,delete 테이블에
					// 데이터를 변화시키는 구문을 사용할때 쓰는 메소드!
					rs = psmt.executeQuery();
					// ResultSet
					// -> 테이블과 같은 형태!
					// -> cursor라고 하는 애를 가지고 있다!
					// -> cursor는 column명을 초기에 가리키고 있다!
					// -> 원하는 데이터를 가져오기 위해서는 cursor가 가리키고 있는 행에 대해서만 데이터를 가져올 수 있다.
					// 3. 결과를 이용한 작업처리
					if (rs.next()) {
						// rs.next() --> cursor를 현재위치에서 한칸 내려주는 메소드
						// 데이터가 존재한다! 로그인 성공!
						System.out.println("로그인 성공!");
						String name = rs.getString("mem_name");
						System.out.println("반가워요!!!" + name + "님");
						isStart = true;
						break;
					} else {
						System.out.println("로그인 실패");
						System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					// 4.데이터베이스 자원 반납
					// rs,psmt,conn --> 열어준 순서의 역순으로 반납하자!!!!
					try {
						if (rs != null)
							rs.close();
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if (menu == 3) {
				System.out.println("게임을 종료합니다.");
			}
			else {
				System.out.println("다시입력해주세요");
			}
		}
		System.out.println("게임시작!!");

		// 게임시작 isStart가 true가 되면 게임을 시작합니다.
		if (isStart == true) {
			System.out.println("파닥몬 키우기를 시작합니다^^");
			
			// 파닥몬 메인 이미지
			파닥몬_메인_이미지 patpic1 = new 파닥몬_메인_이미지();
			patpic1.mainPata();
			
			// 상태창 
			
			// 메뉴
			
			while(true) {
			System.out.println("[1]밥 먹이기 || [2]잠자기 || [3]전투하기");
			int ans1 = sc.nextInt();
			
			
			if(ans1 == 1) {
				lv1.eat();
			}else if(ans1 == 2) {
				lv1.sleep();
			}else if(ans1 ==3) {
				System.out.println("전투하기");
			}
			
			}
			
			
		}
		
	}

}