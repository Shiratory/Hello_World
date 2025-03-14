package inharrydance;
/*
 * 칭구1: 이름, 연락처
 */

public class Friend {
	// 필드
	private String name;
	private String tel;
	
	// 생성자
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}
	//gettersetter
	public String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
