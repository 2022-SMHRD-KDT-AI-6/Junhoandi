import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class battle extends pataDTO{

	public battle(String name, int lv, int hp, String con) {
		super(name, lv, hp, con);
		
	}
//		********** 呪舛琶呪!! 因維径 去 痕呪級 嬬車左戚惟馬奄是背 績税稽 背兜製 魚稽 走舛背醤杯艦陥 ~ 
//  薄仙 杷坪汽柵佼引 穿燈拭辞 戚医聖凶 雌殿但生稽 宜焼亜澗号狛 持唖.....背醤敗	
	
	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		pataDTO pata = new pataDTO();

		int patask1 = 9; // 倖搭酵帖奄, (葵聖 嬢胸惟竺舛背醤馬走?)
		int airshot = 1; //因奄椴精 郊稽郊稽 公掌.
		int damage = 1 ;
		int picohp = 300;	// 杷坪汽柵佼税 端径.. 護生稽??
		int picost ;	//杷坪汽柵佼 因維径 痕呪. 薄仙澗 10税 沓棋呪稽 宜軒澗掻
		int array[] = new int[10];
		int patahp=50;	
	// patahp澗 績税稽 叔蝿生稽 竺舛梅奄凶庚拭 伽!!!!!! 原走厳拭 get生稽 災君辞 竺舛背操醤杯艦陥!! 
		int picoexp = 10; // 杷坪汽柵佼税 井蝿帖勲 繕舛.


			System.out.println("             杷坪汽柵佼引 穿燈 獣拙!!!!");
			System.out.println();
			System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");

			while (true) {
				
				System.out.println(" [1]倖搭酵帖奄 [2]因奄椴 [3]枢滴軒奄");
				int sel2 = sc.nextInt();

				if (sel2 == 1) {
					// 倖搭酵帖奄
					System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");
					System.out.println();
					System.out.println("              倖搭酵帖奄!!       ");
					System.out.println();

		
					airshot += 1; // 因奄椴 亜管
					damage = patask1 + pata.getStr();

					picohp -= damage;
					System.out.println("- 杷坪 汽柵佼 拭惟 " + damage + " 税 杷背研 脊縛陥." + "(杷坪汽柵佼税 害精HP :" + picohp + ")");

					int dam = rd.nextInt(10) + 1;
					patahp -=dam;
					System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば"+ "(督韓佼税 害精HP :" + patahp + ")");
					System.out.println("===============================================");
					if (patahp<=0) {
						System.out.println();
						System.out.println("            旋拭惟 鳶壕梅柔艦陥.......");
						System.out.println();
						System.out.println("        匂幻姶戚 10 匝嬢級壱 杷稽亀亜 10 装亜杯艦陥. ");
						pata.setHgr(-10);
						pata.setSlp(+10);
						break;
					}
					if (picohp <= 0) {
						System.out.println("       人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
						System.out.println();
						System.out.println("    杷坪汽柵佼拭惟 戚移辞 弦精井蝿帖研 条柔艦陥."+"井蝿帖+"+picoexp+" 塙究!!");
						//焼掘税 井蝿帖澗 績税稽 繕舛
						pataexp +=10; 
						System.out.println();
						break;
					}
					System.out.println("                   び");
					System.out.println("                   び");
					System.out.println("                   び");
					
					// hp -= dam;

					System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");

				} else if (sel2 == 2) {

					if (airshot <= 0) {
						System.out.println("-- 因奄亜 採膳背辞 因奄椴精 尻紗生稽 紫遂拝呪 蒸柔艦陥. --");
						System.out.println("-- 因奄研 乞生澗 疑照 陥献奄綬聖 紫遂背爽室推. --");
						System.out.println();
					} else {
						//*****mp3 督析 切軒 // 因奄椴
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
						System.out.println("          因奄~~~~~~~~椴!!!!!!!");
						System.out.println();
						System.out.println();
						airshot -= 1;

						picohp -= damage;
						System.out.println("- 杷坪 汽柵佼 拭惟 " + damage + " 税 杷背研 脊縛陥." + "(杷坪汽柵佼税 害精HP :" + picohp + ")");
						System.out.println();
						
						int dam = rd.nextInt(10) + 1;
						pata.setHp(-dam);
						
						System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば"+ "(督韓佼税 害精HP :" + patahp + ")");
						System.out.println("===============================================");
						if (patahp<=0) {
							System.out.println();
							System.out.println("            旋拭惟 鳶壕梅柔艦陥.......");
							System.out.println();
							System.out.println("        匂幻姶戚 10 匝嬢級壱 杷稽亀亜 10 装亜杯艦陥. ");
							pata.setHgr(-10);
							pata.setSlp(+10);
							break;
						}
						if (picohp <= 0) {
							System.out.println("    人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
							System.out.println();
							System.out.println("    杷坪汽柵佼拭惟 戚移辞 弦精井蝿帖研 条柔艦陥."+"井蝿帖+"+picoexp+" 塙究!!");
							pata.setExp(+10); 
							System.out.println();
							break;
						}
						System.out.println("                   び");
						System.out.println("                   び");
						System.out.println("                   び");
					
						System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");
					}

				} else {
					System.out.println();
					System.out.println("     督韓佼戚 倖聖 枢滴形辞 端径聖 噺差梅陥.");
					
					pata.setHp(+3);
					airshot += 1;
					System.out.println("     督韓佼税 端径 3 噺差!!! "+"(督韓佼税 HP :"+pata.getHp()+")");
					System.out.println();
					int dam = rd.nextInt(10) + 1;
					pata.setHp(-dam);
					System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば"+ "(督韓佼税 害精HP :" + patahp + ")");
					System.out.println("===============================================");
					if (patahp<=0) {
						System.out.println();
						System.out.println("            旋拭惟 鳶壕梅柔艦陥.......");
						System.out.println();
						System.out.println("        匂幻姶戚 10 匝嬢級壱 杷稽亀亜 10 装亜杯艦陥. ");
						pata.setHgr(-10);
						pata.setSlp(+10);
						break;
					}
					if (picohp <= 0) {
						System.out.println("        人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
						System.out.println();
						System.out.println("    杷坪汽柵佼拭惟 戚移辞 弦精井蝿帖研 条柔艦陥."+"井蝿帖+"+picoexp+" 塙究!!");
						pata.setExp(+10); 
						System.out.println();
						break;
					}
					System.out.println("                   び");
					System.out.println("                   び");
					System.out.println("                   び");
					
				
					System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");
					System.out.println();
				}

			}
			System.out.println();
			System.out.println("               五昔生稽 宜焼逢艦陥.");
			System.out.println();
			System.out.println();	
			System.out.println("===============================================");
	    	System.out.println("               戚賎 校拝猿...?");	
	    	System.out.println();	
	
		
	}
}
    