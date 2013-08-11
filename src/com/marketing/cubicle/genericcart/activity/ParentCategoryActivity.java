package com.marketing.cubicle.genericcart.activity;

import java.util.ArrayList;
import com.marketing.cubicle.genericcart.database.entity.CategoryEO;
import com.marketing.cubicle.genericcart.database.query.CategoryQuery;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ParentCategoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent_category);
		CategoryQuery db = new CategoryQuery(this);
		final Context context = this;
		ArrayList<CategoryEO> query = db.getCategoryByCategoryId("0");
		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout_id);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (CategoryEO cn : query) {
			View view = inflater.inflate(R.layout.inflate_category_menu_items,
					null);
			final Button button = (Button) view;
			button.setText(cn.getCategory_name());
			button.setTag(cn.getCategory_id());
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					String id = (String) button.getTag();
					Intent intent = new Intent(context,
							ChildCategoryActivity.class);
					intent.putExtra("category_id", id);
					startActivity(intent);

				}
			});
			mainLayout.addView(button);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
