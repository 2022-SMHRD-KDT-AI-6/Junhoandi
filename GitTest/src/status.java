
public class status {

pController pc = new pController();
	public void status(String a){
		System.out.println("NAME : " + getName.p_name +"LV : " + p_lv +"HP : "+ p_hp + 
				"EXP : " + p_exp + "현재 상태 : " + pata_condition + "누적 일수 : " + p_time );
		System.out.println("현재 경험치를 확인하시겠습니까? ");
		
		
	}

	public void exp(String b) {
		System.out.println("현재 경험치 : "+ p_exp);
	}
	
	public void exit(String c) {
		
	}
	if(hp<50&&hp>31) {
		System.out.println("배고파요ㅠㅠ");
	}
	if(hp<=30) {
		System.out.println("너무배고파요ㅠㅠ");
	}
	
}
