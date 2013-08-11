package com.marketing.cubicle.genericcart.database.query;

import java.util.ArrayList;
import com.marketing.cubicle.genericcart.database.entity.CategoryEO;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CategoryQuery extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "g2d";

	// Contacts table name
	private static final String TABLE_CATEGORY = "category";

	// Contacts Table Columns names
	private static final String CATEGORY_ID = "category_id";
	private static final String CATEGORY_NAME = "category_name";
	private static final String SEQUENCE = "sequence";
	private static final String PARENT_CATEGORY_ID = "parent_category_id";
	private static final String IMAGEID = "imageid";

	public CategoryQuery(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
				+ CATEGORY_ID + " INTEGER PRIMARY KEY," + CATEGORY_NAME
				+ " TEXT," + SEQUENCE + " INTEGER ," + PARENT_CATEGORY_ID
				+ " INTEGER ," + IMAGEID + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);

		// Create tables again
		onCreate(db);
	}

	// Getting All Contacts
	public ArrayList<CategoryEO> getAllCategory() {
		ArrayList<CategoryEO> list = new ArrayList<CategoryEO>();
		String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				CategoryEO eo = new CategoryEO();
				eo.setCategory_id(cursor.getString(0));
				eo.setCategory_name(cursor.getString(1));
				eo.setSequence(cursor.getString(2));
				eo.setParent_category_id(cursor.getString(3));
				eo.setImageid(cursor.getString(4));
				list.add(eo);
			} while (cursor.moveToNext());
		}
		return list;
	}

	// Getting contacts Count
	public int getCategoryCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CATEGORY;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		return cursor.getCount();
	}

	public ArrayList<CategoryEO> getCategoryByCategoryId(String id) {
		ArrayList<CategoryEO> list = new ArrayList<CategoryEO>();
		String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY
				+ " WHERE PARENT_CATEGORY_ID = " + id;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				CategoryEO eo = new CategoryEO();
				eo.setCategory_id(cursor.getString(0));
				eo.setCategory_name(cursor.getString(1));
				eo.setSequence(cursor.getString(2));
				eo.setParent_category_id(cursor.getString(3));
				eo.setImageid(cursor.getString(4));
				list.add(eo);
			} while (cursor.moveToNext());
		}
		return list;
	}

	public ArrayList<CategoryEO> getCategoryByCategoryIdsIn(String ids) {
		ArrayList<CategoryEO> list = new ArrayList<CategoryEO>();
		String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY
				+ " WHERE PARENT_CATEGORY_ID IN (" + ids + ")";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				CategoryEO eo = new CategoryEO();
				eo.setCategory_id(cursor.getString(0));
				eo.setCategory_name(cursor.getString(1));
				eo.setSequence(cursor.getString(2));
				eo.setParent_category_id(cursor.getString(3));
				eo.setImageid(cursor.getString(4));
				list.add(eo);
			} while (cursor.moveToNext());
		}
		return list;
	}
}