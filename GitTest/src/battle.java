import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class battle extends pataDTO{

	public battle(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
		
	}
//		********** �����ʼ�!! ���ݷ� �� ������ �ֺܼ��̰��ϱ����� ���Ƿ� �س��� ���� �����ؾ��մϴ� ~ 
//  ���� ���ڵ������ �������� �̰����� ����â���� ���ư��¹�� ����.....�ؾ���	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		pataDTO pata = new pataDTO();

		int patask1 = 9; // �����ġ��, (���� ��Լ����ؾ�����?)
		int airshot = 1; //�������� �ٷιٷ� ����.
		int damage = 1 ;
		int picohp = 300;	// ���ڵ������� ü��.. ������??
		int picost ;	//���ڵ����� ���ݷ� ����. ����� 10�� �������� ��������
		int array[] = new int[10];
		int end =1;
		int patahp=50;	
		int testexp = 10; // ���ڵ������� ����ġ�� ����.


			System.out.println("             ���ڵ������ ���� ����!!!!");
			System.out.println();
			System.out.println("============== ����� ����� �����ϼ��� ==============");

			while (true) {
				if(patahp<0) {
					System.out.println("1�� if��");
					break;
				}
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
					patahp -=dam;
					System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + patahp + ")");
					System.out.println("===============================================");
					if (patahp<0) {
						System.out.println("              2�� if��");
						System.out.println("            ������ �й��߽��ϴ�.......");
						System.out.println();
						//���⿡ �й�� ������̶� �Ƿε� ����????
						break;
					}
					if (picohp <= 0) {
						System.out.println("       ��~~~~ ���ڵ����󿡰� �̰��!!!������ ");
						System.out.println();
						System.out.println("    ���ڵ����󿡰� �̰ܼ� ��������ġ�� ����ϴ�."+"����ġ+"+testexp+" ȹ��!!");
						//�Ʒ��� ����ġ�� ���Ƿ� ����
						//setexp(+10); ?? 
						System.out.println();
						break;
					}
					System.out.println("                   ��");
					System.out.println("                   ��");
					System.out.println("                   ��");
					
					// hp -= dam;

					System.out.println("============== ����� ����� �����ϼ��� ==============");

				} else if (sel2 == 2) {

					if (airshot <= 0) {
						System.out.println("-- ���Ⱑ �����ؼ� �������� �������� ����Ҽ� �����ϴ�. --");
						System.out.println("-- ���⸦ ������ ���� �ٸ������ ������ּ���. --");
						System.out.println();
					} else {
						//*****mp3 ���� �ڸ� // ������
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
//						damage = str + 2;
						System.out.println("          ����~~~~~~~~��!!!!!!!");
						System.out.println();
						System.out.println();
						airshot -= 1;

						picohp -= damage;
						System.out.println("- ���� ������ ���� " + damage + " �� ���ظ� ������." + "(���ڵ������� ����HP :" + picohp + ")");
						System.out.println();
						int dam = rd.nextInt(10) + 1;
						pata.setHp(-dam);
						System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + patahp + ")");
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
					System.out.println("- ���� ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + patahp + ")");
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
    