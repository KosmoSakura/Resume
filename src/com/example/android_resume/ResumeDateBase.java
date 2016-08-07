package com.example.android_resume;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ResumeDateBase {
	SQLiteDatabase db;

	public ResumeDateBase(Context context) {
		MyDateBase mdb = new MyDateBase(context, "resume.db", null, 1);
		db = mdb.getReadableDatabase();
	}
	public void inserts(String name,String birthday,String degree,String major,String school,
			String salary,String sex,String project){
		ContentValues v = new ContentValues();
		v.put("name", name);
		v.put("birthday", birthday);
		v.put("degree", degree);
		v.put("major", major);
		v.put("school", school);
		v.put("salary", salary);
		v.put("sex", sex );
		v.put("project", project );
		
		db.insert("resume", "name", v);
	}
	public Cursor search(){
		String s ="select * from resume";
		//Cursor c = db.query("resume", null, null, null, null, null, null);
		Cursor c = db.rawQuery(s, null);
		return c;
	}
	public void del(String name){
		String d = "delete from resume where name = '"+name+"'";
		db.execSQL(d);
	}
}
