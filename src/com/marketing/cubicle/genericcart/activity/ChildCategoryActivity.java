package com.marketing.cubicle.genericcart.activity;

import java.util.ArrayList;

import com.marketing.cubicle.genericcart.database.entity.CategoryEO;
import com.marketing.cubicle.genericcart.database.query.CategoryQuery;
import com.marketing.cubicle.genericcart.util.ExpandableList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

public class ChildCategoryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_category);
		Intent intent = getIntent();
		String id = intent.getStringExtra("category_id");
		CategoryQuery db = new CategoryQuery(this);
		ArrayList<CategoryEO> query = db.getCategoryByCategoryId(id);
		String ids = "";
		for (CategoryEO cn : query) {
			ids = ids + "," + cn.getCategory_id();
		}
		ArrayList<CategoryEO> child_query = db.getCategoryByCategoryIdsIn(ids
				.substring(1));
		ExpandableListView explvlist = (ExpandableListView) findViewById(R.id.ParentLevel);
		explvlist.setAdapter(new ExpandableList(this, query, child_query));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
