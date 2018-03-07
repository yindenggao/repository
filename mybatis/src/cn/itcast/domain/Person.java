package cn.itcast.domain;

public class Person {
	
	private Integer id;
	private String goodName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + goodName + "]";
	}

}
