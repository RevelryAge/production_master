package cn.lp.po.part;

public class PartTechnology implements Comparable<PartTechnology> {
    private Integer id;

    private Integer partId;

    private Integer count;

    private String drawing;

    private String name;

    private String info;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing == null ? null : drawing.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

	

	@Override
	public int compareTo(PartTechnology o) {
		// TODO Auto-generated method stub
		return this.count-o.count;
	}
    
}