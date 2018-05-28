package cn.lp.po.plan;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Manufacture {
	private Integer id;

	private String state;

	private Integer planStaffId;

	private Integer planDetailId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planStartTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planEndTime;

	private Integer partTechnologyId;

	private Integer num;

	private Integer workStaffId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date realityTime;

	private Integer checkStaffId;

	private Integer qualifiedNum;

	private Integer unqualifiedNum;

	private String partName;
	

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Integer getPlanStaffId() {
		return planStaffId;
	}

	public void setPlanStaffId(Integer planStaffId) {
		this.planStaffId = planStaffId;
	}

	public Integer getPlanDetailId() {
		return planDetailId;
	}

	public void setPlanDetailId(Integer planDetailId) {
		this.planDetailId = planDetailId;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Integer getPartTechnologyId() {
		return partTechnologyId;
	}

	public void setPartTechnologyId(Integer partTechnologyId) {
		this.partTechnologyId = partTechnologyId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getWorkStaffId() {
		return workStaffId;
	}

	public void setWorkStaffId(Integer workStaffId) {
		this.workStaffId = workStaffId;
	}

	public Date getRealityTime() {
		return realityTime;
	}

	public void setRealityTime(Date realityTime) {
		this.realityTime = realityTime;
	}

	public Integer getCheckStaffId() {
		return checkStaffId;
	}

	public void setCheckStaffId(Integer checkStaffId) {
		this.checkStaffId = checkStaffId;
	}

	public Integer getQualifiedNum() {
		return qualifiedNum;
	}

	public void setQualifiedNum(Integer qualifiedNum) {
		this.qualifiedNum = qualifiedNum;
	}

	public Integer getUnqualifiedNum() {
		return unqualifiedNum;
	}

	public void setUnqualifiedNum(Integer unqualifiedNum) {
		this.unqualifiedNum = unqualifiedNum;
	}

	@Override
	public String toString() {
		return "Manufacture [id=" + id + ", state=" + state + ", planStaffId=" + planStaffId + ", planDetailId="
				+ planDetailId + ", planStartTime=" + planStartTime + ", planEndTime=" + planEndTime
				+ ", partTechnologyId=" + partTechnologyId + ", num=" + num + ", workStaffId=" + workStaffId
				+ ", realityTime=" + realityTime + ", checkStaffId=" + checkStaffId + ", qualifiedNum=" + qualifiedNum
				+ ", unqualifiedNum=" + unqualifiedNum + ", partName=" + partName + "]";
	}
}