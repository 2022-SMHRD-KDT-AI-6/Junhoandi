package login;

import java.sql.ResultSet;
import java.util.Scanner;

public class MemberMainView {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		ResultSet rs;
		System.out.println("[1]ȸ������ [2]�α��� [3]���� ");
		int row = 0;
		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==ȸ�� ����==");
				System.out.println("ID�� �Է����ּ��� >> ");
				String id = sc.next();
				System.out.println("pw�� �Է����ּ��� >> ");
				String pw = sc.next();
				System.out.println("�̸��� �Է����ּ��� >> ");
				String name = sc.next();

				// insert �޼ҵ带 ȣ��!
				MemberDto dto = new MemberDto(id, pw, name);
				row = controller.insert(dto);
				if (row > 0) {
					System.out.println("������ �߰� ����!!!!");
				} else {
					System.out.println("�߰� ����!!!!");
				}

			} else if (menu == 2) {

				System.out.println("==�α��� �ϱ�==");
				System.out.print("�̸� �Է� >> ");
				String inputName = sc.next();
				MemberDto dto = new MemberDto(inputName);
				dto = controller.select(dto);
				if (dto.getId() != null && dto.getPw() != null) {
					System.out.println("�α��� ����");
					// �α����� �����ϸ� �Ĵڸ� Ű��� �����ִ� â �ҷ�����
					
				}

				if (dto.getId() == null || dto.getPw() == null) {
					System.out.println("�α��� ����");
				}
			}

			else if (menu == 3) {
				System.out.println("���α׷��� ����˴ϴ�.");
				break;
			}
		}
	}
}
