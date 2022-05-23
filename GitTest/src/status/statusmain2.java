package status;

import java.sql.ResultSet;
import java.util.Scanner;

public class statusmain2 {

	public static void main(String[] args) {

		// [1] 추가 [2] 수정 [3] 검색 [4] 탈퇴 [5] 종료
		// 사용자가 사용하고자 하는 기능 입력받기
		// 5번이 입력되기 전까지 계속 메뉴를 반복할 수 있는 구조 갖기!

		Scanner sc = new Scanner(System.in);
		statusController controller = new statusController();
		ResultSet rs;
		int row = 0;
		// 사용자의 결과를 확인하기 위한 전역변수 !
		while (true) {
			String name = "padapada";
			statusDTO dto = new statusDTO(name);
			controller.show(dto);
			String exit = sc.next();
			if (exit.equals("Y")) {
				System.out.println("메인화면으로 돌아갑니다.");
			}
		}

	}

}
