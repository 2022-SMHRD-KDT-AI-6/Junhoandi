

public class status {

	pController pc = new pController();

//	Date today = new Date (0);

	long time1 = System.currentTimeMillis();
	long time2 = System.currentTimeMillis();

	public void status_syso() {
		System.out.println("NAME : " + pc.getName() + "LV : " + pc.getLv() + "HP : " + pc.getHp() + "EXP : "
				+ pc.getExp() + "현재 상태 : " + pc.getCon() + "누적 시간 : " + (time2 - time1) / 1000.0);
		
	}

	public void exp(String b) {
		System.out.println("현재 경험치를 확인하시겠습니까? Y/N ");
		if(b.equals("Y")) {
			System.out.println("현재 경험치 : " + pc.getExp());
		}
	}

	// 현재 상태
	public void nowstatus (int c) {
	if(pc.getHgr()<50&&pc.getHgr()>31){
		pc.setCon("배고파요 ㅠㅠ");
	}
	else if(pc.getHgr()<=30){
		pc.setCon("너무 배고파요 ㅠㅠ");
	}
	if(pc.getSlp()<50&&pc.getSlp()>31){
		pc.setCon("피곤파요 ㅠㅠ");
	}
	else if(pc.getSlp()<=30){
		pc.setCon("너무 피곤해요 ㅠㅠ");
	}
	}
	
	
}
