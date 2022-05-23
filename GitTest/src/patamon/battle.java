package patamon;

public class battle {
	//전투하기 ?

		@Override
		    public void play() {
		    // 전투하기? 기능 -> 배고픔 -3 / 피곤함 -4 / 경험치 +3 
		    	hgr-=3;
		        slp-=4;
		        exp+=3;
		        System.out.println("파닥몬 전투중");
		        System.out.println("");
		    }
		
}
