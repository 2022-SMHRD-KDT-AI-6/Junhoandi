package status;

import java.sql.ResultSet;
import java.util.Scanner;

public class statusmain2 {

	public static void main(String[] args) {

		// [1] �߰� [2] ���� [3] �˻� [4] Ż�� [5] ����
		// ����ڰ� ����ϰ��� �ϴ� ��� �Է¹ޱ�
		// 5���� �ԷµǱ� ������ ��� �޴��� �ݺ��� �� �ִ� ���� ����!

		Scanner sc = new Scanner(System.in);
		statusController controller = new statusController();
		ResultSet rs;
		int row = 0;
		// ������� ����� Ȯ���ϱ� ���� �������� !
		while (true) {
			String name = "padapada";
			statusDTO dto = new statusDTO(name);
			controller.show(dto);
			String exit = sc.next();
			if (exit.equals("Y")) {
				System.out.println("����ȭ������ ���ư��ϴ�.");
			}
		}

	}

}
