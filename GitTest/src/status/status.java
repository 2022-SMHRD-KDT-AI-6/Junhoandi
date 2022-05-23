package status;

public class status {

	statusDTO dto = new statusDTO();

//		Date today = new Date (0);

	long time1 = System.currentTimeMillis();
	long time2 = System.currentTimeMillis();

	public void status_syso() {
		System.out.println("NAME : " + dto.getName() + "LV : " + dto.getLv() + "HP : " + dto.getHp() + "EXP : "
				+ dto.getExp() + "현재 상태 : " + dto.getCon() + "누적 시간 : " + (time2 - time1) / 1000.0);

	}

	public void exp(String b) {
		System.out.println("현재 경험치를 확인하시겠습니까? Y/N ");
		if (b.equals("Y")) {
			System.out.println("현재 경험치 : " + dto.getExp());
		}
	}

	// 현재 상태
	public void nowstatus(int c) {
		if (dto.getHgr() < 50 && dto.getHgr() > 31) {
			dto.setCon("배고파요 ㅠㅠ");
		} else if (dto.getHgr() <= 30) {
			dto.setCon("너무 배고파요 ㅠㅠ");
		}
		if (dto.getSlp() < 50 && dto.getSlp() > 31) {
			dto.setCon("피곤파요 ㅠㅠ");
		} else if (dto.getSlp() <= 30) {
			dto.setCon("너무 피곤해요 ㅠㅠ");
		}
	}

}
