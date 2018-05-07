package cn.lp.po.account;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Staff {
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", state=" + state + ", birthday=" + birthday + ", deptId=" + deptId
				+ ", type=" + type + ", joinDate=" + joinDate + ", dept=" + dept + "]";
	}

	public Staff() {
		super();
	}

	public Staff(Integer id, String name, String sex, String phone, String email, String address, String state,
			Date birthday, Integer deptId, String type, Date joinDate, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.state = state;
		this.birthday = birthday;
		this.deptId = deptId;
		this.type = type;
		this.joinDate = joinDate;
		this.dept = dept;
	}

	private Integer id;

	private String name;

	private String sex;

	private String phone;

	private String email;

	private Account account;
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private String address;

	private String state;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date birthday;

	public Staff(Integer id, String name, String sex, String phone, String email, Account account, String address,
			String state, Date birthday, Integer deptId, String type, Date joinDate, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.account = account;
		this.address = address;
		this.state = state;
		this.birthday = birthday;
		this.deptId = deptId;
		this.type = type;
		this.joinDate = joinDate;
		this.dept = dept;
	}

	private Integer deptId;

	private String type;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joinDate;

	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Staff(Integer id, Integer deptId) {
		super();
		this.id = id;
		this.deptId = deptId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}