
public class level extends pataDTO {
	public level(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
		// TODO Auto-generated constructor stub
	}

	private int exp = 0; // max 10
	private int hgr = 10; // max 10
	private int slp = 10; // max 10
	private int lv = 1;

	public void eat() {
		// ����� +3
		hgr += 3;
		System.out.println("�ȳ�...���ִ�!!");
		System.out.println("");

	}

	public void sleep() {
		// �ǰ��� +2
		slp += 2;
		System.out.println("�Ĵڸ��� �������ϴ�Zz..���� ȸ���˴ϴ�.");
		System.out.println("");
	}

	public void train() {
		// �Ʒ��ϱ�? ��� -> ����� -2 / ����ġ +3
		hgr -= 2;
		exp += 3;
		System.out.println("�Ĵڸ��� �Ʒ���.");
		System.out.println("");
	}

	public void levelUp(pataDTO dto) {
		if (exp > 10) {
			exp -= 10;
			lv++;
			System.out.println("������!!" + dto.getName() + "�� ������ " + lv + "�� �ö����ϴ�! ");
			System.out.println("");
		}

	}

	public void die() {
		if (hgr < 5) {
			System.out.println("���: �Ĵڸ��� ����Ŵϴ�. �Ĵڸ��� ��ӹ������ ����������");
		}
		if (slp < 5) {
			System.out.println("���: �Ĵڸ��� �����ϴ�. �Ĵڸ��� ��ӹ����Ѵٸ� ����������");
		}
	}

	public boolean TheEnd() {
		boolean returnValue = true;
		if (hgr < 0) {
			System.out.println("�Ĵڸ��� ����ļ� ����߾��...");
			returnValue = false;

		} else if (slp < 0) {
			System.out.println("�Ĵڸ��� ������ ������ ������ϴ�");
			returnValue = false;
		}
		return returnValue;
	}
}