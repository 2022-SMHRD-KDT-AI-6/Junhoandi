package status;

public class status {

	statusDTO dto = new statusDTO();

//		Date today = new Date (0);

	long time1 = System.currentTimeMillis();
	long time2 = System.currentTimeMillis();

	public void status_syso() {
		System.out.println("NAME : " + dto.getName() + "LV : " + dto.getLv() + "HP : " + dto.getHp() + "EXP : "
				+ dto.getExp() + "���� ���� : " + dto.getCon() + "���� �ð� : " + (time2 - time1) / 1000.0);

	}

	public void exp(String b) {
		System.out.println("���� ����ġ�� Ȯ���Ͻðڽ��ϱ�? Y/N ");
		if (b.equals("Y")) {
			System.out.println("���� ����ġ : " + dto.getExp());
		}
	}

	// ���� ����
	public void nowstatus(int c) {
		if (dto.getHgr() < 50 && dto.getHgr() > 31) {
			dto.setCon("����Ŀ� �Ф�");
		} else if (dto.getHgr() <= 30) {
			dto.setCon("�ʹ� ����Ŀ� �Ф�");
		}
		if (dto.getSlp() < 50 && dto.getSlp() > 31) {
			dto.setCon("�ǰ��Ŀ� �Ф�");
		} else if (dto.getSlp() <= 30) {
			dto.setCon("�ʹ� �ǰ��ؿ� �Ф�");
		}
	}

}
