package login;

public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	

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
	
	
	//ȸ�����������Ҷ� ����ϴ� ������
	public MemberDto(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
//	
//	//�˻��Ҷ� ����ϴ� ������
	public MemberDto(String name) {
		this.name = name;
	}
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//Ż���Ҷ� ����ϴ� ������
//	public MemDTO(String id) {
//		this.id = id;
//	}
}
