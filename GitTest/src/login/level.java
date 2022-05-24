package login;

import java.util.Random;
import java.util.Scanner;

public class level extends pataDTO {
	public level(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);

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

	public void battle() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		pataDTO pata = new pataDTO(getName(), getLv(), getHp(), getCon()); // Ȯ��

		int patask1 = 9; // �����ġ��, (���� ��Լ����ؾ�����?)
		int airshot = 1; // �������� �ٷιٷ� ����. ������.
		int damage = 1;
		int picohp = 30; // ���ڵ������� ü��.. ������??
		int picost; // ���ڵ����� ���ݷ� ����. ����� 10�� �������� ��������
		int array[] = new int[10];

		// //�����ϱ� ?

		// �� ����.
		// ���� ü�� ��� / ���ݷ� (���� str)
		// �������ϸ� ���ݷ�,hp ���.
		// �� óġ�� ����� �� �ǰ��� ����ġ ���

	

     		System.out.println("             ���� �������� �����ߴ�!!");
			System.out.println();
			System.out.println("===============================================");
			System.out.println();


				System.out.println("             ���ڵ������ ���� ����!!!!");
				System.out.println();
				System.out.println("============== ����� ����� �����ϼ��� ==============");

				while (true) {

					System.out.println(" [1]�����ġ�� [2]������ [3]��ũ����");
					int sel2 = sc.nextInt();

					if (sel2 == 1) {
						// �����ġ��
						System.out.println("============== ����� ����� �����ϼ��� ==============");
						System.out.println();
						System.out.println("              �����ġ��!!       ");
						System.out.println();

						// damage = patask1 + str
						// pico�� ü�� - damage ���
						airshot += 1; // ������ ����
						damage = patask1 + pata.getStr();

						picohp -= damage;
						System.out.println("- ���� ������ ���� " + damage + " �� ���ظ� ������." + "(���ڵ������� ����HP :" + picohp + ")");

						int dam = rd.nextInt(10) + 1;
						pata.setHp(-dam);
						System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
						System.out.println("===============================================");
						if (picohp <= 0) {
							System.out.println("    ��~~~~ ���ڵ����󿡰� �̰��!!!������ ");
							System.out.println();
							System.out.println("            -  ���� �� -");
							break;
						}
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println("                   ��");
						pata.setHp(-dam);
						// hp -= dam;

						System.out.println("============== ����� ����� �����ϼ��� ==============");

					} else if (sel2 == 2) {

						if (airshot <= 0) {
							System.out.println("-- ���Ⱑ �����ؼ� �������� �������� ����Ҽ� �����ϴ�. --");
							System.out.println("-- ���⸦ ������ ���� �ٸ������ ������ּ���. --");
							System.out.println();
						} else {
							// ������
							String art3 = """
									#%####(###(                                     (%##########,
									       .#%####(#(##(                                  (##########
									         #%%######((#%/                                (#(####(%@
									         ##########((/%#(                              (%#(##((#.
									            ((#(###(#####(                          /#%##((#(/#(
									               *%####(#%%(                       /%##(#((((####
									                #%%#####%%(                      (%%###((#(##(
									               *%########%#(                     /#%#####(
									                ,//(#%%#(####/                   (%###(
									                        ((%##((                ####(
									                    *(#/   .((##(########((/(/(##(
									                 //((###(/#################((###(
									              ((######(#(#####(*###(*(/########(##(
									           ,(########################(/((####(#/(#//
									          /((######%#########(#####((##%#####%%%%&%#/
									    (/   /################(#%%&%%%%##(///////////(#%%&#
									    *,&@%@%#(####(####%@@@@@&%%##(//////////////////#%%#
									     (&&(@@&#####(#&@@@@@@&%%%#(/////////////////(((((%%*
									     /%%/@@@@&##&@@@@@@@@&%%%/////////////////((//////#%#
									      #&%&@@@@@@@@@@@@@@&%%#//////((((((((//******,,,,/(/
									       #&&@@@@@@@@@@@@@@&%%(((((((####((/*,,..........*/.
									        #&&@@@@@@@@@@@@@&&%#%%%%%%###((/*,.     ......**
									         #%&&@@@@@@@@@@@@&&%&&&&&&&%#(/*,,.          ,*.
									          /%&&@@@@@@@&&@@@@&&&&&&&%##/*,,,,.        ,,*
									            #&&&@&&&@@@@@@@@&&&&&&%##(/***,,.......,,
									              %&%&&@@@@@@@@@@&&&&&%%##((////*,,,,*/.
									               /%#%&&&@@@@@@@@@&&%%%###((((///(#(
									                *%&&#%&&&&&@@@@@@@@&%##((#%####
									                 ,&@@@&#&((%&&&&&&&&%%####
									                   %@@@&&(%&#*
									                     (/..*(&
									                      (/
									           .,,,,,,,    .,,,,,,,.  #@@:                 .,,,,,,,.  *@@*        @@@,
									          -@@@@@@@@#  -#@@@@@@@=. @@@:                .@@@@@@@@@. *@@=        @@@,
									          -@@@@@@@@#  :@@@@@@@@$. @@@:                .@@@@@@@@@, *@@=        @@@,
									          .;;;;;*@@#  ,;;;;;$@@$. @@@:                 *@@@*@@@;. *@@=        @@@,
									                ~@@#        *@@$. @@@:                 -#@@~@@@   *@@=        @@@,
									                ~@@#        *@@$. @@@:                 -#@@~@@@   *@@@##;     @@@,
									                ~@@#        *@@$. @@@:                 -#@@~@@@   *@@@@@@     @@@,
									                ~@@#        *@@$. @@@:                 -#@@~@@@   *@@@@@$     @@@,
									                ~@@#        *@@$. @@@:                 *@@@=@@@!  *@@$::,     @@@,
									                :@@#        *@@$. @@@:                .@@@@@@@@@, *@@=        @@@,
									             ;@@@@@#        *@@$. @@@:                .@@@@@@@@@, *@@=        @@@,
									             ;@@@*$~        .=$!  @@@:                 ;$$$$$$$!  *@@=        @@@,
									             ;@@#                 @@@:                            *@@=        #@@,
									          ;!!$@@@!!!.             @@@:                            *@@=        -:~
									          #@@@@@@@@@=             @@@:                            *@@=
									          #@@@@@@@@@$             @@@:                            *@@=        @@@-
									          ,::::::::~              @@@:                            *@@=        @@@-
									             ,::~.                @@@:                            *@@=        *$=,
									            *$@@@=~               *@@:                          ,*#@@#*,      .,.
									           $@@@@@@@-               ..                           #@@@@@@#.
									          ~@@@##@@@#                                           =@@@##@@@*
									          #@@!  ,#@@:                                         .@@@~  ~@@@.
									         .#@@~   ;@@$                                         ;@@=.  ,$@@~
									         .#@@:   ;@@$                                         ~@@=.  ,#@@~
									          #@@=. ,#@@-                                          @@@;  ;@@@
									          -@@@#$@@@$                                           *@@@$$@@@;
									           ;#@@@@@$,                                            *@@@@@@*.
									            ~!#@=;,                                             .;*@@*:.
									              ,,.                                                 .,,.

												""";
							for (int i = 0; i < art3.length(); i++) {
								System.out.print(art3.charAt(i));
								Thread.sleep(1);
							}
							damage = pata.getStr() + 2;
//							damage = str + 2;
							System.out.println("          ����~~~~~~~~��!!!!!!!");
							System.out.println();
							System.out.println();
							airshot -= 1;

							picohp -= damage;
							System.out.println("- ���� ������ ���� " + damage + " �� ���ظ� ������." + "(���ڵ������� ����HP :" + picohp + ")");
							System.out.println();
							int dam = rd.nextInt(10) + 1;
							pata.setHp(-dam);
							System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
							System.out.println("===============================================");
							if (picohp <= 0) {
								System.out.println("    ��~~~~ ���ڵ����󿡰� �̰��!!!������ ");
								System.out.println();
								System.out.println("            -  ���� �� -");
								break;
							}
							System.out.println("                   ��");
							System.out.println("                   ��");
							System.out.println("                   ��");
							pata.setHp(-dam);
							// hp -= dam;
							System.out.println("============== ����� ����� �����ϼ��� ==============");
						}

					} else {
						System.out.println();
						System.out.println("     �Ĵڸ��� ���� ��ũ���� ü���� ȸ���ߴ�.");
						// ��ũ����
						pata.setHp(+3);
						airshot += 1;
						System.out.println("     �Ĵڸ��� ü�� 3 ȸ��!!! "+"(�Ĵڸ��� HP :"+pata.getHp()+")");
						System.out.println();
						int dam = rd.nextInt(10) + 1;
						pata.setHp(-dam);
						System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
						System.out.println("===============================================");
						if (picohp <= 0) {
							System.out.println("        ��~~~~ ���ڵ����󿡰� �̰��!!!������ ");
							System.out.println();
							System.out.println("                -  ���� �� -");
							break;
						}
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println("                   ��");
						pata.setHp(-dam);
						// hp -= dam;
						System.out.println("============== ����� ����� �����ϼ��� ==============");
						System.out.println();
					}

				}
				System.out.println("            �������� ���ư��ϴ�.");
				System.out.println();
				System.out.println();	
				System.out.println("===============================================");
		    	System.out.println("           ���� ���ұ�...?");	
		    	System.out.println();	

	}
	

}