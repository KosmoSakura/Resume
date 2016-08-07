package com.example.android_resume;

import java.util.ArrayList;
import java.util.List;

import com.example.android_resume.R.layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;

public class Editlist extends Activity {
	ArrayList<Infos>list;
	ListView lv;
	int pic;
	SimpleCursorAdapter adapter;
	Cursor c;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editlist);
		lv = (ListView) findViewById(R.id.lv);
		c = App.db.search();
		/* (_id integer primary key autoincrement," +
				"name String,birthday String,degree String,major String,school String,sal String," +
				"sex String,project String 
				new String[]{"name","sex","major"}
				new int[]{R.id.tt1,R.id.tt2,R.id.tt3}
		 */
		String[]cMel = {"name","birthday","degree","major","school","salary","sex","project"};
		int[]cid = {R.id.t1,R.id.t2,R.id.t3,R.id.t4,R.id.t5,R.id.t6,R.id.t7,R.id.t8};
		
		adapter = new SimpleCursorAdapter(Editlist.this, R.layout.lay_datebase, c,
				new String[]{"name","sex","major"},new int[]{R.id.tt1,R.id.tt2,R.id.tt3} );
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			/* （非 Javadoc）
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder dia = new AlertDialog.Builder(Editlist.this);
				dia.setTitle("详细信息:");
				LayoutInflater lay = LayoutInflater.from(Editlist.this);
				View v = lay.inflate(R.layout.laydialog, null);
				dia.setView(v);
				TextView t1 = (TextView) v.findViewById(R.id.t1);
				TextView t2 = (TextView) v.findViewById(R.id.t2);
				TextView t3 = (TextView) v.findViewById(R.id.t3);
				TextView t4 = (TextView) v.findViewById(R.id.t4);
				TextView t5 = (TextView) v.findViewById(R.id.t5);
				TextView t6 = (TextView) v.findViewById(R.id.t6);
				TextView t7 = (TextView) v.findViewById(R.id.t7);
				TextView t8 = (TextView) v.findViewById(R.id.t8);
				c.moveToPosition(position);
				String gname ="姓名:"+ c.getString(c.getColumnIndex("name"));
				String birthday = "生日："+c.getString(c.getColumnIndex("birthday"));
				String degree ="学位："+ c.getString(c.getColumnIndex("degree"));
				String major ="专业："+ c.getString(c.getColumnIndex("major"));
				String school ="学校："+ c.getString(c.getColumnIndex("school"));
				String salary ="薪水："+ c.getString(c.getColumnIndex("salary"));
				String sex ="性别："+ c.getString(c.getColumnIndex("sex"));
				String project ="项目经验："+ c.getString(c.getColumnIndex("project"));
				t1.setText(gname);
				t2.setText(birthday);
				t3.setText(degree);
				t4.setText(major);
				t5.setText(school);
				t6.setText(salary);
				t7.setText(sex);
				t8.setText(project);
				dia.show();
				
			}
		});
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				c.moveToPosition(position);
				String dname = c.getString(c.getColumnIndex("name"));
				App.db.del(dname);
				c=App.db.search();
				adapter = new SimpleCursorAdapter(Editlist.this, R.layout.lay_datebase, c,
						new String[]{"name","sex","major"},new int[]{R.id.tt1,R.id.tt2,R.id.tt3} );
				lv.setAdapter(adapter);
				Toast.makeText(Editlist.this, "删除成功", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		
	}

	public void myclick(View v){
		switch (v.getId()) {
		case R.id.btn_list:
			Intent intent = new Intent();
			intent.setClass(Editlist.this, Detail.class);
			startActivity(intent);
			break;
		case R.id.btn_exit:
			SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
			sp.edit().putBoolean("auto", false).commit();
			startActivity(new Intent(Editlist.this, MainActivity.class));
			break;
		}
	}
}
