package status;

import java.sql.ResultSet;
import java.util.Scanner;

import login.MemberController;
import login.MemberDto;

public class pataStatusMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		statusController controller2 = new statusController();
		ResultSet rs;
		int row = 0;
		while (true) {
				String name = name;

				
				// insert �޼ҵ带 ȣ��!
				statusDTO dto = new statusDTO(name);
				controller2.show(dto);
				
				System.out.println(dto.getName() + "/"+ dto.getLv() + "/"+ dto.getHp() + "/"+ dto.getCon());

				String exit = sc.next();
			if (exit.equals("Y")) {
				System.out.println("����ȭ������ ���ư��ϴ�.");
				break;
			}
		}
	}

}
