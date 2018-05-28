package cn.lp.po.plan;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Plan {
    private Integer id;

    private String state;

    private Integer createStaffId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date createTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date planEnd;
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date realityTime;

    private Integer planStaffId;

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

    public Integer getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    public Date getRealityTime() {
        return realityTime;
    }

    public void setRealityTime(Date realityTime) {
        this.realityTime = realityTime;
    }

    public Integer getPlanStaffId() {
        return planStaffId;
    }

    public void setPlanStaffId(Integer planStaffId) {
        this.planStaffId = planStaffId;
    }
}