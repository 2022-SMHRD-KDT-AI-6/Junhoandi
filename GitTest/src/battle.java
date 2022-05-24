import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class battle extends pataDTO{

	public battle(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
		
	}
//		********** 수정필수!! 공격력 등 변수들 콘솔보이게하기위해 임의로 해놓음 따로 지정해야합니다 ~ 
//  현재 피코데빌몬과 전투에서 이겼을때 상태창으로 돌아가는방법 생각.....해야함	
	
	
	
	
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
		
		System.out.println("  피코 데빌몬이 등장했다!");
		
		while (true) {
			
			System.out.println("[1] 전투한다 [2] 그냥 못본척한다.");
			int sel = sc.nextInt();
			System.out.println();

			if (sel == 1 ) {

				System.out.println("       피코데빌몬과 전투 시작!!!!");
				System.out.println();
				System.out.println("============== 사용할 기술을 선택하세요 ==============");
				
				while (true) {
					
					System.out.println(" [1]몸통박치기 [2]공기팡 [3]웅크리기 [4]도망간다");
					int sel2 = sc.nextInt();

					if (sel2 == 1) {
						// 몸통박치기
						System.out.println("============== 사용할 기술을 선택하세요 ==============");
						System.out.println();
						System.out.println("              몸통박치기!!       ");
						System.out.println();

						// damage = patask1 + str
						// pico의 체력 - damage 출력
						airshot += 1; // 공기팡 가능
					    damage = patask1 + pata.getStr();

					    picohp -= damage;
						System.out.println("- 피코 데빌몬 에게 " + damage + " 의 피해를 입혔다."+"(남은HP :"+picohp+")");
						
						int dam = rd.nextInt(10)+1;
						System.out.println("- 피코 데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
						System.out.println("===============================================");
						if(picohp<=0) {
							System.out.println("    와~~~~ 피코데빌몬에게 이겼다!!!ㅎㅎㅎ ");
							System.out.println();
							System.out.println("            -  전투 끝 -");
							System.out.println("===============================================");
							break;
						}
						System.out.println("                   ㅣ");
						System.out.println("                   ㅣ");
						System.out.println("                   ㅣ");
						pata.setHp(-dam);
						//hp -= dam;

						System.out.println("============== 사용할 기술을 선택하세요 ==============");

					} else if (sel2 == 2) {

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
							 damage = pata.getStr()+2;
//							damage = str + 2;
							System.out.println("          공기~~~~~~~~팡!!!!!!!");
							System.out.println();
							System.out.println();
							airshot -= 1;
							
							picohp -= damage;
							System.out.println("- 피코 데빌몬 에게 " + damage + " 의 피해를 입혔다."+"(남은HP :"+picohp+")");
							System.out.println();
							int dam = rd.nextInt(10)+1;
							System.out.println("- 피코 데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
							System.out.println("===============================================");
							if(picohp<=0) {
								System.out.println("    와~~~~ 피코데빌몬에게 이겼다!!!ㅎㅎㅎ ");
								System.out.println();
								System.out.println("            -  전투 끝 -");
								System.out.println("===============================================");
								break;
							}
							System.out.println("                   ㅣ");
							System.out.println("                   ㅣ");
							System.out.println("                   ㅣ");
							pata.setHp(-dam);
							//hp -= dam;
							System.out.println("============== 사용할 기술을 선택하세요 ==============");
						}

					} else if(sel ==3){
						System.out.println();
						System.out.println("     파닥몬이 몸을 웅크려서 체력을 회복했다.");
						// 웅크리기
						pata.setHp(+10);
						airshot += 1;					
						
						int dam = rd.nextInt(10)+1;
						System.out.println("- 피코 데빌몬 의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
						System.out.println("===============================================");
						if(picohp<=0) {
							System.out.println("    와~~~~ 피코데빌몬에게 이겼다!!!ㅎㅎㅎ ");
							System.out.println();
							System.out.println("            -  전투 끝 -");
							System.out.println("===============================================");
							break;
						}
						System.out.println("                   ㅣ");
						System.out.println("                   ㅣ");
						System.out.println("                   ㅣ");
						pata.setHp(-dam);
						//hp -= dam;
						System.out.println("============== 사용할 기술을 선택하세요 ==============");
					}

					break;
				}
				System.out.println();
				
			} else {
				System.out.println("그냥 못본척한다");
				break;
			}
		}
	
		
	}
}
    