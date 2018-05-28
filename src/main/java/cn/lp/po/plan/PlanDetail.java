package cn.lp.po.plan;

public class PlanDetail {
    private Integer id;

    private Integer partId;

    private Integer num;

    private Integer planId;
    
   

    private Integer qualifiedNum;

    private Integer unqualifiedNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPlanId() {
        return planId;
    }

  

	public void setPlanId(Integer planId) {
        this.planId = planId;
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
		return "PlanDetail [id=" + id + ", partId=" + partId + ", num=" + num + ", planId=" + planId + ", qualifiedNum="
				+ qualifiedNum + ", unqualifiedNum=" + unqualifiedNum + "]";
	}
}