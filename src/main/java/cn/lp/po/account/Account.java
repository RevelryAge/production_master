package cn.lp.po.account;

public class Account {
    private Integer id;

    private Integer staffId;

    private String staffName;

    private String password;

    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Account() {
		
	}

	public Integer getGrade() {
        return grade;
    }

    public Account(Integer id, String staffName) {
		super();
		this.id = id;
		this.staffName = staffName == null ? null : staffName.trim();
	}

	public void setGrade(Integer grade) {
        this.grade = grade;
    }
}