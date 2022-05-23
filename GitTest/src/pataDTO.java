
public class pataDTO {

	private String id;
	private String pw;
	private String name;
	private int hp;
	private int lv;
	private int exp;
	private String con;
	private int hgr;
	private int slp;
	
	
	public int getHgr() {
		return hgr;
	}
	public void setHgr(int hgr) {
		this.hgr = hgr;
	}
	public int getSlp() {
		return slp;
	}
	public void setSlp(int slp) {
		this.slp = slp;
	}
	private int time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	// 유저 생성자 메소드
	public pataDTO (String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	// 스테이터스 생성자 메소드
	public pataDTO(String name, int lv, int hp, String con) {
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.con = con;
	}
	
}
