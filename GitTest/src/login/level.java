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
		// 壕壱把 +3
		hgr += 3;
		
		
		
		
		System.out.println("拡拡...言赤陥!!");
		System.out.println("");

	}

	public void sleep() {
		// 杷逸敗 +2
		slp += 2;
		System.out.println("督韓佼戚 節級醸柔艦陥Zz..倖戚 噺差桔艦陥.");
		System.out.println("");
	}

	public void train() {
		// 汎恵馬奄? 奄管 -> 壕壱把 -2 / 井蝿帖 +3
		hgr -= 2;
		exp += 3;
		System.out.println("督韓佼戚 汎恵掻.");
		System.out.println("");
	}

	public void levelUp(pataDTO dto) {
		if (exp > 10) {
			exp -= 10;
			lv++;
			System.out.println("傾婚穣!!" + dto.getName() + "税 傾婚戚 " + lv + "稽 臣串柔艦陥! ");
			System.out.println("");
		}

	}

	public void die() {
		if (hgr < 5) {
			System.out.println("井壱: 督韓佼戚 壕壱播艦陥. 督韓佼戚 域紗壕壱覗檎 宋聖呪赤製");
		}
		if (slp < 5) {
			System.out.println("井壱: 督韓佼戚 噌験艦陥. 督韓佼戚 域紗巷軒廃陥檎 宋聖呪赤製");
		}
	}

	public boolean TheEnd() {
		boolean returnValue = true;
		if (hgr < 0) {
			System.out.println("督韓佼戚 壕壱督辞 紫諺梅嬢推...");
			returnValue = false;

		} else if (slp < 0) {
			System.out.println("督韓佼戚 噌形辞 慎据備 節聖説艦陥");
			returnValue = false;
		}
		return returnValue;
	}
	
	public void battle() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		pataDTO pata = new pataDTO(getName(), getLv(), getHp(), getCon()); // 溌昔

		int patask1 = 9; // 倖搭酵帖奄, (葵聖 嬢胸惟竺舛背醤馬走?)
		int airshot = 1; //因奄椴精 郊稽郊稽 公掌.
		int damage = 1 ;
		int picohp = 30;	// 杷坪汽柵佼税 端径.. 護生稽??
		int picost ;	//杷坪汽柵佼 因維径 痕呪. 薄仙澗 10税 沓棋呪稽 宜軒澗掻
		int array[] = new int[10];
		
		// //穿燈馬奄 ?
	
		// 旋 持失.
		// 旋税 端径 猿奄 / 因維径 (痕呪 str)
		// 傾婚穣馬檎 因維径,hp 雌渋.
		// 旋 坦帖獣 壕壱把 貢 杷逸敗 井蝿帖 雌渋

		// public void battle() {

		System.out.println("  杷坪 汽柵佼戚 去舌梅陥!");
		
		while (true) {
			
			System.out.println("[1] 穿燈廃陥 [2] 亀諺娃陥");
			int sel = sc.nextInt();
			System.out.println();
//			if(pata.getHp() <= 0) {
//				System.out.println("杷坪汽柵佼引 穿燈拭辞 鳶壕梅柔艦陥 ばば");
//				System.out.println("壕壱把引 杷稽亀亜 3 装亜杯艦陥.");
//				pata.setSlp(-3);
//				pata.setHgr(-3);
//				break;
//			}
			if (sel == 1 ) {

				System.out.println("       杷坪汽柵佼引 穿燈 獣拙!!!!");
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

						// damage = patask1 + str
						// pico税 端径 - damage 窒径
						airshot += 1; // 因奄椴 亜管
					    damage = patask1 + pata.getStr();

					    picohp -= damage;
						System.out.println("- 杷坪 汽柵佼 拭惟 " + damage + " 税 杷背研 脊縛陥."+"(害精HP :"+picohp+")");
						
						int dam = rd.nextInt(10)+1;
						System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば");
						System.out.println("===============================================");
						if(picohp<=0) {
							System.out.println("    人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
							System.out.println();
							System.out.println("            -  穿燈 魁 -");
							break;
						}
						System.out.println("                   び");
						System.out.println("                   び");
						System.out.println("                   び");
						pata.setHp(-dam);
						//hp -= dam;

						System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");

					} else if (sel2 == 2) {

						if (airshot <= 0) {
							System.out.println("-- 因奄亜 採膳背辞 因奄椴精 尻紗生稽 紫遂拝呪 蒸柔艦陥. --");
							System.out.println("-- 因奄研 乞生澗 疑照 陥献奄綬聖 紫遂背爽室推. --");
							System.out.println();
						} else {
							// 因奄椴
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
							System.out.println("          因奄~~~~~~~~椴!!!!!!!");
							System.out.println();
							System.out.println();
							airshot -= 1;
							
							picohp -= damage;
							System.out.println("- 杷坪 汽柵佼 拭惟 " + damage + " 税 杷背研 脊縛陥."+"(害精HP :"+picohp+")");
							System.out.println();
							int dam = rd.nextInt(10)+1;
							System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば");
							System.out.println("===============================================");
							if(picohp<=0) {
								System.out.println("    人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
								System.out.println();
								System.out.println("            -  穿燈 魁 -");
								break;
							}
							System.out.println("                   び");
							System.out.println("                   び");
							System.out.println("                   び");
							pata.setHp(-dam);
							//hp -= dam;
							System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");
						}

					} else {
						System.out.println();
						System.out.println("     督韓佼戚 倖聖 枢滴形辞 端径聖 噺差梅陥.");
						// 枢滴軒奄
						pata.setHp(+10);
						airshot += 1;					
						
						int dam = rd.nextInt(10)+1;
						System.out.println("- 杷坪 汽柵佼 税 因維!! " + dam + " 税 杷背研 閤紹陥ばば");
						System.out.println("===============================================");
						if(picohp<=0) {
							System.out.println("    人~~~~ 杷坪汽柵佼拭惟 戚医陥!!!ぞぞぞ ");
							System.out.println();
							System.out.println("            -  穿燈 魁 -");
							break;
						}
						System.out.println("                   び");
						System.out.println("                   び");
						System.out.println("                   び");
						pata.setHp(-dam);
						//hp -= dam;
						System.out.println("============== 紫遂拝 奄綬聖 識澱馬室推 ==============");
					}

				}
				
				
			} else {
				System.out.println("== 杷坪汽柵佼 引 穿燈拭辞 亀諺弾柔艦陥 ==");
				System.out.println(" 『 杷稽亀人 壕壱把戚 3梢 臣虞逢艦陥. ");
				pata.setSlp(-3);
				pata.setHgr(-3);
				break;
			}
	}
	}	
}