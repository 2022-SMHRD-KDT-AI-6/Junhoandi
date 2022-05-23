package patamon;

public class lv {
	    private int exp=10;
	    private int hgr=10;
	    private int slp=10;
	    private int lv=1;
	 
	    @Override
	    public void eat() {
	       //배고픔 +3
	    	hgr+=3;
	        System.out.println("냠냠...맛있다!!");
	        System.out.println("");
	    }
	 
	    @Override
	    public void sleep() {
	       // 피곤함 +2
	    	slp+=2;
	        System.out.println("파닥몬이 잠들었습니다 Z z Z z");
	        System.out.println("");
	    }
	 
	  
	    @Override
	    public void train() {
	       // 훈련하기? 기능 -> 배고픔 -2 /  경험치 +3
	    	hgr-=2;
	        exp+=3;
	        System.out.println("파닥몬이 훈련중.");
	        System.out.println("");
	    }
	 
	    @Override
	    public void levelUp() {
	        if(exp>10) {
	            exp-=10;
	            lv++;
	            System.out.println("레벨업!!"+ name +"의 레벨이 "+ lv +"로 올랐습니다! ");
	            System.out.println("");
	        }
	 
	    }
	 
	    @Override
	    public boolean TheEnd() {
	        boolean returnValue=true;
	        if(level<0) {
	            System.out.println("");
	            returnValue=false;
	  
	        }else if(hgr<0) {
	            System.out.println("파닥몬이 배고파서 사망했어요...");
	            returnValue=false;
	  
	        }else if(slp<0) {
	            System.out.println("파닥몬이 졸려서 영원히 잠을잡니다");
	            returnValue=false;
	        }
	        return returnValue;
	    }
}