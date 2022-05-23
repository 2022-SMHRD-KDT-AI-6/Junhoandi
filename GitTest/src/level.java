
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
		// 배고픔 +3
		hgr += 3;
		System.out.println("냠냠...맛있다!!");
		System.out.println("");

	}

	public void sleep() {
		// 피곤함 +2
		slp += 2;
		System.out.println("파닥몬이 잠들었습니다Zz..몸이 회복됩니다.");
		System.out.println("");
	}

	public void train() {
		// 훈련하기? 기능 -> 배고픔 -2 / 경험치 +3
		hgr -= 2;
		exp += 3;
		System.out.println("파닥몬이 훈련중.");
		System.out.println("");
	}

	public void levelUp(pataDTO dto) {
		if (exp > 10) {
			exp -= 10;
			lv++;
			System.out.println("레벨업!!" + dto.getName() + "의 레벨이 " + lv + "로 올랐습니다! ");
			System.out.println("");
		}

	}

	public void die() {
		if (hgr < 5) {
			System.out.println("경고: 파닥몬이 배고픕니다. 파닥몬이 계속배고프면 죽을수있음");
		}
		if (slp < 5) {
			System.out.println("경고: 파닥몬이 졸립니다. 파닥몬이 계속무리한다면 죽을수있음");
		}
	}

	public boolean TheEnd() {
		boolean returnValue = true;
		if (hgr < 0) {
			System.out.println("파닥몬이 배고파서 사망했어요...");
			returnValue = false;

		} else if (slp < 0) {
			System.out.println("파닥몬이 졸려서 영원히 잠을잡니다");
			returnValue = false;
		}
		return returnValue;
	}
}