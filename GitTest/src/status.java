

public class status {

	pController pc = new pController();

//	Date today = new Date (0);

	long time1 = System.currentTimeMillis();
	long time2 = System.currentTimeMillis();

	public void status_syso() {
		System.out.println("NAME : " + pc.getName() + "LV : " + pc.getLv() + "HP : " + pc.getHp() + "EXP : "
				+ pc.getExp() + "���� ���� : " + pc.getCon() + "���� �ð� : " + (time2 - time1) / 1000.0);
		
	}

	public void exp(String b) {
		System.out.println("���� ����ġ�� Ȯ���Ͻðڽ��ϱ�? Y/N ");
		if(b.equals("Y")) {
			System.out.println("���� ����ġ : " + pc.getExp());
		}
	}

	// ���� ����
	public void nowstatus (int c) {
	if(pc.getHgr()<50&&pc.getHgr()>31){
		pc.setCon("����Ŀ� �Ф�");
	}
	else if(pc.getHgr()<=30){
		pc.setCon("�ʹ� ����Ŀ� �Ф�");
	}
	if(pc.getSlp()<50&&pc.getSlp()>31){
		pc.setCon("�ǰ��Ŀ� �Ф�");
	}
	else if(pc.getSlp()<=30){
		pc.setCon("�ʹ� �ǰ��ؿ� �Ф�");
	}
	}
	
	
}
