package com.marketing.cubicle.genericcart.util;

import java.util.ArrayList;

import com.marketing.cubicle.genericcart.database.entity.CategoryEO;

public class CategoryTree {
	private ArrayList<CategoryEO> cat;
	private ArrayList<CategoryEO> result;
	private String category_id = "0";

	public CategoryTree(CategoryEO cat, ArrayList<CategoryEO> query) {
		if (cat == null) {
			cat = new CategoryEO("0", "Root", "0", null, null, "nonleaf",
					"white");
		}
		this.cat = query;
		this.category_id = cat.getCategory_id();
		this.result = new ArrayList<CategoryEO>();
		result.add(cat);
		for (int i = 0; i < this.cat.size(); i++) {
			CategoryEO p = this.cat.get(i);
			p.setColor("white");
			p.setLevel("nonleaf");
		}
		for (int i = 0; i < this.cat.size(); i++) {
			CategoryEO p = this.cat.get(i);
			boolean flag = false;
			for (int j = 0; j < this.cat.size(); j++) {
				CategoryEO r = this.cat.get(j);
				if (p.getCategory_id() == r.getParent_category_id()) {
					flag = true;
				}
			}
			if (flag == false) {
				p.setLevel("leaf");
			}
		}
	}

	public void runDFS(int level, CategoryEO u) {
		u.setColor("grey");
		for (int i = 0; i < this.cat.size(); i++) {
			CategoryEO p = this.cat.get(i);
			if (p.getParent_category_id().equals(u.getCategory_id())
					&& p.getColor() == "white") {
				if (p.getCategory_id() != this.category_id)
					if (level == 0 && p.getLevel() != "leaf") {
						result.add(p);
					}
				if (level == 1 && p.getLevel() != "leaf") {
					result.add(p);
				}
				if (p.getLevel() == "leaf") {
					result.add(p);
				}
				this.runDFS(level + 1, p);
			}
		}
		u.setColor("black");
	}

	public ArrayList<CategoryEO> allChildren() {
		CategoryEO u = new CategoryEO(this.category_id, "Root", "0", null,
				null, "nonleaf", "white");
		this.runDFS(0, u);
		return this.result;
	}
}