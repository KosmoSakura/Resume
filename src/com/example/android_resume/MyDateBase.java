package com.example.android_resume;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDateBase extends SQLiteOpenHelper {

	public MyDateBase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		String t = "create table resume (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"name VARCHAR(10),birthday VARCHAR(15),degree VARCHAR(5),major VARCHAR(5),school VARCHAR(5),salary VARCHAR(5)," +
				"sex VARCHAR(5),project VARCHAR(5) )";
		db.execSQL(t);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �Զ����ɵķ������

	}

}
