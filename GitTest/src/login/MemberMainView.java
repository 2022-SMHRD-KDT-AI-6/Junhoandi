package login;

import java.sql.ResultSet;
import java.util.Scanner;

public class MemberMainView {
	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		ResultSet rs;
		System.out.println("[1]회원가입 [2]로그인 [3]종료 ");
		int row = 0;
		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==회원 가입==");
				System.out.println("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.println("pw를 입력해주세요 >> ");
				String pw = sc.next();
				System.out.println("이름을 입력해주세요 >> ");
				String name = sc.next();

				// insert 메소드를 호출!
				MemberDto dto = new MemberDto(id, pw, name);
				row = controller.insert(dto);
				if (row > 0) {
					System.out.println("데이터 추가 성공!!!!");
				} else {
					System.out.println("추가 실패!!!!");
				}

				
			} else if (menu == 2) {
				System.out.println("==로그인 하기==");
				System.out.print("아이디 입력 >> ");
				String inputId = sc.next();
				System.out.print("패스워드 입력 >> ");
				String inputPw = sc.next();
				MemberDto dto = new MemberDto(inputId);
				dto = controller.select(dto);
				// 아무것도 안넣는 사용자 입력방지
				if (dto.getId() == null || dto.getPw() == null) {
					System.out.println("로그인 실패");
				}
				// 빈값이 아닌 사용자 입력하게하고 입력값이 같으면 로그인성공 보여주기
				else if (dto.getId() != null && dto.getPw() != null) {
					if(dto.getId().equals(inputId) && dto.getPw().equals(inputPw))
					{
						System.out.println("로그인 성공");
						// 로그인이 성공하면 파닥몬 키우기 보여주는 창 불러오기
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
							Thread.sleep(2);
					}
						
					}
						
					else System.out.println("로그인 실패");
				}
				
			} else if (menu == 2) {

				System.out.println("==로그인 하기==");
				System.out.print("이름 입력 >> ");
				String inputName = sc.next();
				MemberDto dto = new MemberDto(inputName);
				dto = controller.select(dto);
				if (dto.getId() != null && dto.getPw() != null) {
					System.out.println("로그인 성공");
					
			
				

				if (dto.getId() == null || dto.getPw() == null) {
					System.out.println("로그인 실패");
				}
			}

			else if (menu == 3) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}
		}
	}
	}
}
