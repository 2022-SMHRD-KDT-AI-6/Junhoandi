
public class status {

pController pc = new pController();
	public void status(String a){
		System.out.println("NAME : " + getName.p_name +"LV : " + p_lv +"HP : "+ p_hp + 
				"EXP : " + p_exp + "���� ���� : " + pata_condition + "���� �ϼ� : " + p_time );
		System.out.println("���� ����ġ�� Ȯ���Ͻðڽ��ϱ�? ");
		
		
	}

	public void exp(String b) {
		System.out.println("���� ����ġ : "+ p_exp);
	}
	
	public void exit(String c) {
		
	}
	if(hp<50&&hp>31) {
		System.out.println("����Ŀ�Ф�");
	}
	if(hp<=30) {
		System.out.println("�ʹ�����Ŀ�Ф�");
	}
	
}
