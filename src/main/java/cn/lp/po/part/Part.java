package cn.lp.po.part;

public class Part {
    private Integer id;

    private String name;

    private String unit;

    private String drawing;

    private String tested;

    private Integer staffId;

    private String state;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing == null ? null : drawing.trim();
    }

    public String getTested() {
        return tested;
    }

    public void setTested(String tested) {
        this.tested = tested == null ? null : tested.trim();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", unit=" + unit + ", drawing=" + drawing + ", tested=" + tested
				+ ", staffId=" + staffId + ", state=" + state + "]";
	}
}