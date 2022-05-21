
public class pController {

	private String id;
	private String pw;
	private String name;
	private String hp;
	private String lv;
	private String exp;
	private String con;
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
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
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
	public void signup(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public void status(String name, String lv, String hp, String con) {
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.con = con;
	}
	
}
