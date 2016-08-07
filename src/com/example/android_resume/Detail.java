package com.example.android_resume;

import java.text.DateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;

public class Detail extends Activity {
	EditText D_etName,D_etBirthday,D_etDegree,D_etmajor,D_etschool,D_etsalary,D_et_Project;
	RadioGroup D_rg_sex;
	RadioButton rb1,rb2;
	String name,birthday,degree,major,school,salary,project,sex,pic;
	Calendar cal = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		D_etName = (EditText) findViewById(R.id.D_etName);
		D_etBirthday = (EditText) findViewById(R.id.D_etBirthday);
		D_etDegree = (EditText) findViewById(R.id.D_etDegree);
		D_etmajor = (EditText) findViewById(R.id.D_etmajor);
		D_etschool = (EditText) findViewById(R.id.D_etschool);
		D_etsalary = (EditText) findViewById(R.id.D_etsalary);
		D_et_Project = (EditText) findViewById(R.id.D_et_Project);
		D_rg_sex = (RadioGroup) findViewById(R.id.D_rg_sex);
		rb1 = (RadioButton) findViewById(R.id.rb1);
		rb2 = (RadioButton) findViewById(R.id.rb2);
		App.db= new ResumeDateBase(this);
		D_etBirthday.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				DatePickerDialog dp = new DatePickerDialog(Detail.this, new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO 自动生成的方法存根
						cal.set(cal.YEAR, year);
						cal.set(cal.MONTH, monthOfYear);
						cal.set(cal.DAY_OF_MONTH, dayOfMonth);
						DateFormat df = DateFormat.getDateInstance();
						String d = df.format(cal.getTime());
						D_etBirthday.setText(d);
					}
				}, 1991, 10, 5);
				dp.show();
				
			}
		});
		
	}

	public void myclick(View v){
		switch (v.getId()) {
		case R.id.D_btn_forgo:
			startActivity(new Intent(Detail.this, Editlist.class));
			break;
		case R.id.D_btn_save:
			int id = D_rg_sex.getCheckedRadioButtonId();
			RadioButton button = (RadioButton) D_rg_sex.findViewById(id);
			sex = button.getText()+"";
			name = D_etName.getText()+"";
			birthday = D_etBirthday.getText()+"";
			degree = D_etDegree.getText()+"";
			major = D_etmajor.getText()+"";
			school = D_etschool.getText()+"";
			salary = D_etsalary.getText()+"";
			project = D_et_Project.getText()+"";
			
			App.db.inserts(name, birthday, degree, major, school, salary, sex,project);
			Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
			startActivity(new Intent(Detail.this, Editlist.class));
			break;
		}
	}
}
