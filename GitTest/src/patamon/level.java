package patamon;

public class lv {
	    private int exp=10;
	    private int hgr=10;
	    private int slp=10;
	    private int lv=1;
	 
	    @Override
	    public void eat() {
	       //����� +3
	    	hgr+=3;
	        System.out.println("�ȳ�...���ִ�!!");
	        System.out.println("");
	    }
	 
	    @Override
	    public void sleep() {
	       // �ǰ��� +2
	    	slp+=2;
	        System.out.println("�Ĵڸ��� �������ϴ� Z z Z z");
	        System.out.println("");
	    }
	 
	  
	    @Override
	    public void train() {
	       // �Ʒ��ϱ�? ��� -> ����� -2 /  ����ġ +3
	    	hgr-=2;
	        exp+=3;
	        System.out.println("�Ĵڸ��� �Ʒ���.");
	        System.out.println("");
	    }
	 
	    @Override
	    public void levelUp() {
	        if(exp>10) {
	            exp-=10;
	            lv++;
	            System.out.println("������!!"+ name +"�� ������ "+ lv +"�� �ö����ϴ�! ");
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
	            System.out.println("�Ĵڸ��� ����ļ� ����߾��...");
	            returnValue=false;
	  
	        }else if(slp<0) {
	            System.out.println("�Ĵڸ��� ������ ������ ������ϴ�");
	            returnValue=false;
	        }
	        return returnValue;
	    }
}