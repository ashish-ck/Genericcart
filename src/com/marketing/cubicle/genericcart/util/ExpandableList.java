package com.marketing.cubicle.genericcart.util;

import java.util.ArrayList;

import com.marketing.cubicle.genericcart.database.entity.CategoryEO;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ExpandableList extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<CategoryEO> query;
	private ArrayList<CategoryEO> child_query;

	public ExpandableList(Context context, ArrayList<CategoryEO> query,
			ArrayList<CategoryEO> child_query) {
		super();
		this.context = context;
		this.query = query;
		this.child_query = child_query;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		return arg1;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	@SuppressWarnings("deprecation")
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		/*
		TextView row = (TextView) convertView;
		if (row == null) {
			row = new TextView(activity);
		}
		row.setText(mContents[groupPosition][childPosition]);
		return row;
		*/
		return null;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 3;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupPosition;
	}

	@Override
	public int getGroupCount() {
		return 5;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		TextView tv = new TextView(context);
		tv.setText("->FirstLevel");
		tv.setBackgroundColor(Color.BLUE);
		tv.setPadding(10, 7, 7, 7);

		return tv;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
