import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class battle {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random(10);

		int patask1; // 몸통박치기, (값을 어떻게설정해야하지?)
		int airshot = 1; //공기팡은 바로바로 못씀.
		int damage ;
		int picohp = 30;	// 피코데빌몬의 체력.. 몇으로??
		int picost ;	//피코데빌몬 공격력 변수. 현재는 10의 랜덤수로 돌리는중
		int array[] = new int[10];

		// //전투하기 ?
//
//		@Override
//		    public void play() {
//		    // 전투하기? 기능 -> 배고픔 -3 / 피곤함 -4 / 경험치 +3 
//		    	hgr-=3;
//		        slp-=4;
//		        exp+=3;
//		        System.out.println("");
//		        System.out.println("");
//		    }
//	
//		
		// 적 생성.
		// 적의 체력 까기 / 공격력 (변수 str)
		// 레벨업하면 공격력,hp 상승.
		// 적 처치시 배고픔 및 피곤함 경험치 상승

		// public void battle() {

		System.out.println("피코 데빌몬이 등장했다!");

		while (true) {
			if(picohp <=0) {
				System.out.println("와~ 피코데빌몬을 이겼다!!!!!");
			}
			System.out.println("[1] 전투한다 [2] 도망간다");
			int sel = sc.nextInt();
			System.out.println();
			if(hp <= 0) {
				System.out.println("피코데빌몬과 전투에서 패배했습니다 ㅠㅠ");
				System.out.println("배고픔과 피로도가 3 증가합니다.");
				slp -= 3;
				hgr -= 3;
				break;
			}
			if (sel == 1 ) {

				System.out.println("  피코데빌몬과 전투 시작!!!!");
				System.out.println();
				System.out.println("====사용할 기술을 선택하세요====");
				while (true) {
					System.out.println(" [1]몸통박치기 [2]공기팡 [3]웅크리기");
					int sel2 = sc.nextInt();

					if (sel2 == 1) {
						// 몸통박치기
						System.out.println("몸통박치기!!");
						System.out.println();

						// damage = patask1 + str
						// pico의 체력 - damage 출력
						airshot += 1; // 공기팡 가능
					    damage = patask1 + str;

						System.out.println("피코 데빌몬 에게 " + damage + " 의 피해를 입혔다.");
						System.out.println();
						picohp -= damage;
						
						int dam = rd.nextInt(10);
						System.out.println("피코 데빌몬의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
						System.out.println();
						hp -= dam;
						System.out.println("  ==사용할 기술을 선택하세요==  ");

					} else if (sel2 == 2) {

						if (airshot <= 0) {
							System.out.println("- 공기가 부족해서 공기팡은 연속으로 사용할수 없습니다. -");
							System.out.println("- 공기를 모으는 동안 다른기술을 사용해주세요. -");
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
//								Thread.sleep(2);
							}
						
							damage = str + 2;
							System.out.println("  공기~~~~~~~~팡!!!!!!!");
							System.out.println();
							System.out.println(" 피코 데빌몬 에게 " + damage + " 의 피해를 입혔다.");
							System.out.println();
							airshot -= 1;
							
							System.out.println("피코 데빌몬 에게 " + damage + " 의 피해를 입혔다.");
							System.out.println();
							picohp -= damage;
							
							int dam = rd.nextInt(10);
							System.out.println("피코 데빌몬의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
							System.out.println();
							hp -= dam;
							System.out.println("  ==사용할 기술을 선택하세요==  ");
						}

					} else {
						System.out.println(" 파닥몬이 몸을 웅크려서 체력을 회복했다.");
						// 웅크리기
						hp +=10;
						airshot += 1;
					
						System.out.println("피코 데빌몬 에게 " + damage + " 의 피해를 입혔다.");
						System.out.println();
						picohp -= damage;
						
						int dam = rd.nextInt(10);
						System.out.println("피코 데빌몬의 공격!! " + dam + " 의 피해를 받았다ㅠㅠ");
						System.out.println();
						hp -= dam;
						System.out.println("  ==사용할 기술을 선택하세요==  ");
					}

				}

			} else {
				System.out.println("== 피코데빌몬 과 전투에서 도망쳤습니다 ==");
				System.out.println(" ※ 피로도와 배고픔이 3씩 올라갑니다. ");
							slp -= 3;
							hgr -= 3;
				break;
			}

		}

	}
	// }
}

