import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class battle extends pataDTO{

	public battle(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
		// TODO Auto-generated constructor stub
	}
//		********** �����ʼ�!! ���ݷ� �� ������ �ֺܼ��̰��ϱ����� ���Ƿ� �س��� ���� �����ؾ��մϴ� ~ 
//  ���� ���ڵ������ �������� �̰����� ����â���� ���ư��¹�� ����.....�ؾ���	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random(10);
		pataDTO pata = new pataDTO();

		int patask1 = 10; // �����ġ��, (���� ��Լ����ؾ�����?)
		int airshot = 1; //�������� �ٷιٷ� ����.
		int damage = 1 ;
		int picohp = 30;	// ���ڵ������� ü��.. ������??
		int picost ;	//���ڵ����� ���ݷ� ����. ����� 10�� �������� ��������
		int array[] = new int[10];

		// //�����ϱ� ?
	
		// �� ����.
		// ���� ü�� ��� / ���ݷ� (���� str)
		// �������ϸ� ���ݷ�,hp ���.
		// �� óġ�� ����� �� �ǰ��� ����ġ ���

		// public void battle() {

		System.out.println("  ���� �������� �����ߴ�!");

		while (true) {
			if(picohp <=0) {
				System.out.println("  ��~ ���ڵ������� �̰��!!!!!");
			}
			System.out.println("[1] �����Ѵ� [2] ��������");
			int sel = sc.nextInt();
			System.out.println();
//			if(pata.getHp() <= 0) {
//				System.out.println("���ڵ������ �������� �й��߽��ϴ� �Ф�");
//				System.out.println("����İ� �Ƿε��� 3 �����մϴ�.");
//				pata.setSlp(-3);
//				pata.setHgr(-3);
//				break;
//			}
			if (sel == 1 ) {

				System.out.println("       ���ڵ������ ���� ����!!!!");
				System.out.println();
				System.out.println("============== ����� ����� �����ϼ��� ==============");
				while (true) {
					System.out.println(" [1]�����ġ�� [2]������ [3]��ũ����");
					int sel2 = sc.nextInt();

					if (sel2 == 1) {
						// �����ġ��
						System.out.println("       �����ġ��!!       ");
						System.out.println();

						// damage = patask1 + str
						// pico�� ü�� - damage ���
						airshot += 1; // ������ ����
					    damage = patask1 + pata.getStr();

						System.out.println("  ���� ������ ���� " + damage + " �� ���ظ� ������."+"(����HP :"+picohp+")");
						System.out.println();
						picohp -= damage;
						
						int dam = rd.nextInt(10)+1;
						System.out.println("  ���� �������� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�");
						System.out.println("===============================================");
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println();
						pata.setHp(-dam);
						//hp -= dam;

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
								Thread.sleep(2);
							}
							 damage = pata.getStr()+2;
//							damage = str + 2;
							System.out.println("  ����~~~~~~~~��!!!!!!!");
							System.out.println();
							System.out.println("  ���� ������ ���� " + damage + " �� ���ظ� ������."+"(����HP :"+picohp+")");
							System.out.println();
							airshot -= 1;
							
							System.out.println("  ���� ������ ���� " + damage + " �� ���ظ� ������."+"(����HP :"+picohp+")");
							System.out.println();
							picohp -= damage;
							
							int dam = rd.nextInt(10)+1;
							System.out.println("  ���� �������� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�");
							System.out.println("===============================================");
							System.out.println("                   ��");
							System.out.println("                   ��");
							System.out.println("                   ��");
							System.out.println();
							pata.setHp(-dam);
							//hp -= dam;
							System.out.println("============== ����� ����� �����ϼ��� ==============");
						}

					} else {
						System.out.println("  �Ĵڸ��� ���� ��ũ���� ü���� ȸ���ߴ�.");
						// ��ũ����
						pata.setHp(+10);
						airshot += 1;					
						
						int dam = rd.nextInt(10)+1;
						System.out.println("  ���� �������� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�");
						System.out.println("===============================================");
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println("                   ��");
						System.out.println();
						pata.setHp(-dam);
						//hp -= dam;
						System.out.println("============== ����� ����� �����ϼ��� ==============");
					}

				}

			} else {
				System.out.println("== ���ڵ����� �� �������� �����ƽ��ϴ� ==");
				System.out.println(" �� �Ƿε��� ������� 3�� �ö󰩴ϴ�. ");
				pata.setSlp(-3);
				pata.setHgr(-3);
				break;
			}

		}

	}
	// }
}

