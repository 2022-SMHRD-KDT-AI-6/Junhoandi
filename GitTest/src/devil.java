import java.util.Random;
import java.util.Scanner;

public class devil extends pataDTO{
	 	
	public devil(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
	}
	public static void main(String[] args) throws InterruptedException {
	
		
			
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		pataDTO pata = new pataDTO();

		int patask1 = 9; // �����ġ��, (���� ��Լ����ؾ�����?)
		int airshot = 1; //�������� �ٷιٷ� ����.
		int damage = 1 ;
		int picohp = 30;	// ���ڵ������� ü��.. ������??
		int picost ;	//���ڵ����� ���ݷ� ����. ����� 10�� �������� ��������
		int array[] = new int[10];
		
		int devilhp = 50; //������ �� ����
		
		
			System.out.println("[���!!!!!] ������� �����մϴ�. �������� �й��ϸ� ������ �����ϴ�. ����Ͻðڽ��ϱ�?");
			System.out.println("          <     �Ĵڸ��� ������ 5 �̻��϶� ��������    >");
			int boss = sc.nextInt();
			if(boss==1) {
				while(true) {
					if(pata.getLv()>5) {
						
								//���� �ڵ� �״��. ���ڵ����� �ٲ㼭.

			     		System.out.println("                �������� �����ߴ�!!");
						System.out.println();
						System.out.println("===============================================");
						System.out.println();


							System.out.println("             ������� ���� ����!!!!");
							System.out.println();
							System.out.println("============== ����� ����� �����ϼ��� ==============");

							while (true) {

								System.out.println(" [1]�����ġ�� [2]������ [3]��ũ����");
								int sel3 = sc.nextInt();

								if (sel3 == 1) {
									// �����ġ��
									System.out.println("============== ����� ����� �����ϼ��� ==============");
									System.out.println();
									System.out.println("              �����ġ��!!       ");
									System.out.println();

									airshot += 1; // ������ ����
									damage = patask1 + pata.getStr();

									//������ hp���� ����.
									devilhp -= damage;
									System.out.println("-     ������ ���� " + damage + " �� ���ظ� ������." + "(�������� ����HP :" + devilhp + ")");

									int dam = rd.nextInt(15) + 1;
									pata.setHp(-dam);
									System.out.println("-     ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
									System.out.println("===============================================");
									if (devilhp <= 0) {
										System.out.println("    ��~~~~     �����󿡰� �̰��!!!������ ");
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

								} else if (sel3 == 2) {

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
//										damage = str + 2;
										System.out.println("          ����~~~~~~~~��!!!!!!!");
										System.out.println();
										System.out.println();
										airshot -= 1;

										devilhp -= damage;
										System.out.println("-     ������ ���� " + damage + " �� ���ظ� ������." + "(�������� ����HP :" + devilhp + ")");
										System.out.println();
										int dam = rd.nextInt(15) + 1;
										pata.setHp(-dam);
										System.out.println("-     ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
										System.out.println("===============================================");
										if (devilhp <= 0) {
											System.out.println("    ��~~~~     �����󿡰� �̰��!!!������ ");
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
									int dam = rd.nextInt(15) + 1;
									pata.setHp(-dam);
									System.out.println("-     ������ �� ����!! " + dam + " �� ���ظ� �޾Ҵ٤Ф�"+ "(�Ĵڸ��� ����HP :" + getHp() + ")");
									System.out.println("===============================================");
									if (devilhp <= 0) {
										System.out.println("        ��~~~~     �����󿡰� �̰��!!!������ ");
										System.out.println();
										System.out.println("                -  ���� �� -");
										break;
					}
					else {
						System.out.println();
						System.out.println("�Ĵڸ��� ������ ���Ƽ� �����Ҽ� �����ϴ�.");
						break;
					}
				
				}
				break;
				// �������� �й��� ... ���� ��
			}
				
			}
					else {
						System.out.println("            �������� ���ư��ϴ�.");
						System.out.println();
						System.out.println();	
						System.out.println("===============================================");
				    	System.out.println("           ���� ���ұ�...?");	
				    	System.out.println();	
					break;
						
					}
			
				}
			}
		
		}
		
	
	
}


