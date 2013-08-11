package com.marketing.cubicle.genericcart.database.entity;

public class CategoryEO {
	private String category_id;
	private String category_name;
	private String sequence;
	private String parent_category_id;
	private String imageid;
	private String level;
	private String color;

	public CategoryEO() {
		category_id = null;
		category_name = null;
		sequence = null;
		parent_category_id = null;
		imageid = null;
		color = null;
		level = null;
	}

	public CategoryEO(String category_id, String category_name,
			String sequence, String parent_category_id, String imageid,
			String level, String color) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.sequence = sequence;
		this.parent_category_id = parent_category_id;
		this.imageid = imageid;
		this.level = level;
		this.color = color;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getParent_category_id() {
		return parent_category_id;
	}

	public void setParent_category_id(String parent_category_id) {
		this.parent_category_id = parent_category_id;
	}

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
