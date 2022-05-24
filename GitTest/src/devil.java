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

		int patask1 = 9; // 몸통박치기, (값을 어떻게설정해야하지?)
		int airshot = 1; //공기팡은 바로바로 못씀.
		int damage = 1 ;
		int picohp = 30;	// 피코데빌몬의 체력.. 몇으로??
		int picost ;	//피코데빌몬 공격력 변수. 현재는 10의 랜덤수로 돌리는중
		int array[] = new int[10];
		
		int devilhp = 50; //데빌몬 피 설정
		
		
			System.out.println("[경고!!!!!] 데빌몬과 전투합니다. 전투에서 패배하면 게임이 끝납니다. 계속하시겠습니까?");
			System.out.println("          <     파닥몬의 레벨이 5 이상일때 도전가능    >");
			int boss = sc.nextInt();
			if(boss==1) {
				while(true) {
					if(pata.getLv()>5) {
						
								//전투 코드 그대로. 피코데빌몬 바꿔서.

			     		System.out.println("                데빌몬이 등장했다!!");
						System.out.println();
						System.out.println("===============================================");
						System.out.println();


							System.out.println("             데빌몬과 전투 시작!!!!");
							System.out.println();
							System.out.println("============== 사용할 기술을 선택하세요 ==============");

							while (true) {

								System.out.println(" [1]몸통박치기 [2]공기팡 [3]웅크리기");
								int sel3 = sc.nextInt();

								if (sel3 == 1) {
									// 몸통박치기
									System.out.println("============== 사용할 기술을 선택하세요 ==============");
									System.out.println();
									System.out.println("              몸통박치기!!       ");
									System.out.println();

									airshot += 1; // 공기팡 가능
									damage = patask1 + pata.getStr();

									//데빌몬 hp따로 설정.
									devilhp -= damage;
									System.out.println("-     데빌몬 에게 " + damage + " 의 피해를 입혔다." + "(데빌몬의 남은HP :" + devilhp + ")");

									int dam = rd.nextInt(15) + 1;
									pata.setHp(-dam);
									System.out.println("-     데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ"+ "(파닥몬의 남은HP :" + getHp() + ")");
									System.out.println("===============================================");
									if (devilhp <= 0) {
										System.out.println("    와~~~~     데빌몬에게 이겼다!!!ㅎㅎㅎ ");
										System.out.println();
										System.out.println("            -  전투 끝 -");
										break;
									}
									System.out.println("                   ㅣ");
									System.out.println("                   ㅣ");
									System.out.println("                   ㅣ");
									pata.setHp(-dam);
									// hp -= dam;

									System.out.println("============== 사용할 기술을 선택하세요 ==============");

								} else if (sel3 == 2) {

									if (airshot <= 0) {
										System.out.println("-- 공기가 부족해서 공기팡은 연속으로 사용할수 없습니다. --");
										System.out.println("-- 공기를 모으는 동안 다른기술을 사용해주세요. --");
										System.out.println();
									} else {
										// 공기팡
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
										System.out.println("          공기~~~~~~~~팡!!!!!!!");
										System.out.println();
										System.out.println();
										airshot -= 1;

										devilhp -= damage;
										System.out.println("-     데빌몬 에게 " + damage + " 의 피해를 입혔다." + "(데빌몬의 남은HP :" + devilhp + ")");
										System.out.println();
										int dam = rd.nextInt(15) + 1;
										pata.setHp(-dam);
										System.out.println("-     데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ"+ "(파닥몬의 남은HP :" + getHp() + ")");
										System.out.println("===============================================");
										if (devilhp <= 0) {
											System.out.println("    와~~~~     데빌몬에게 이겼다!!!ㅎㅎㅎ ");
											System.out.println();
											System.out.println("            -  전투 끝 -");
											break;
										}
										System.out.println("                   ㅣ");
										System.out.println("                   ㅣ");
										System.out.println("                   ㅣ");
										pata.setHp(-dam);
										// hp -= dam;
										System.out.println("============== 사용할 기술을 선택하세요 ==============");
									}

								} else {
									System.out.println();
									System.out.println("     파닥몬이 몸을 웅크려서 체력을 회복했다.");
									// 웅크리기
									pata.setHp(+3);
									airshot += 1;
									System.out.println("     파닥몬의 체력 3 회복!!! "+"(파닥몬의 HP :"+pata.getHp()+")");
									System.out.println();
									int dam = rd.nextInt(15) + 1;
									pata.setHp(-dam);
									System.out.println("-     데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ"+ "(파닥몬의 남은HP :" + getHp() + ")");
									System.out.println("===============================================");
									if (devilhp <= 0) {
										System.out.println("        와~~~~     데빌몬에게 이겼다!!!ㅎㅎㅎ ");
										System.out.println();
										System.out.println("                -  전투 끝 -");
										break;
					}
					else {
						System.out.println();
						System.out.println("파닥몬의 레벨이 낮아서 도전할수 없습니다.");
						break;
					}
				
				}
				break;
				// 전투에서 패배함 ... 게임 끝
			}
				
			}
					else {
						System.out.println("            메인으로 돌아갑니다.");
						System.out.println();
						System.out.println();	
						System.out.println("===============================================");
				    	System.out.println("           이젠 뭘할까...?");	
				    	System.out.println();	
					break;
						
					}
			
				}
			}
		
		}
		
	
	
}


