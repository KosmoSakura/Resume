package com.example.android_resume;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity {
	SharedPreferences sp;
	EditText edtId, edtpass;
	CheckBox cb,auto;
	Editor e;
	String passWord, num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp = getSharedPreferences("login", MODE_PRIVATE);
		e = sp.edit();
		edtId = (EditText) findViewById(R.id.editName);
		edtpass = (EditText) findViewById(R.id.editpassword);
		cb = (CheckBox) findViewById(R.id.cbKeep);
		auto = (CheckBox) findViewById(R.id.cbAuto);
		auto.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO 自动生成的方法存根
				if (isChecked) {
					cb.setChecked(true);
				}
			}
		});
		if (sp.getBoolean("keep" + 2, false)) {
			edtId.setText(sp.getString("keep", ""));
			edtpass.setText(sp.getString("keep" + 1, ""));
			cb.setChecked(true);
			if (sp.getBoolean("auto", false)) {
				startActivity(new Intent(MainActivity.this, Editlist.class));
				finish();
			}
		} else {
			cb.setChecked(false);
		}
	}

	public void myclick(View v) {
		switch (v.getId()) {
		case R.id.btnRegister:
			Intent intent = new Intent(MainActivity.this, Registers.class);
			startActivity(intent);
			break;
		case R.id.btnLogIn:
			num = edtId.getText() + "";
			passWord = edtpass.getText() + "";
			String s = sp.getString(num, "");
			String ss = sp.getString(num + 1, "");
			if (s.equals("")) {
				Toast.makeText(getApplicationContext(), "请先注册账号。。。",
						Toast.LENGTH_SHORT).show();
			} else if (!passWord.equals(ss)) {
				Toast.makeText(getApplicationContext(), "密码错误",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "登陆成功",
						Toast.LENGTH_SHORT).show();

				if (cb.isChecked()) {
					e.putString("keep", num);
					e.putString("keep"+1, passWord);
					e.putBoolean("keep"+2, true);
					if (auto.isChecked()) {
						e.putBoolean("auto", true);
						e.commit();
					}else {
						e.putBoolean("auto", false);
						e.commit();
					}
				} else {
					e.putBoolean("keep"+2, false);
					e.commit();
				}
				
				startActivity(new Intent(MainActivity.this, Editlist.class));
				finish();
			}
			break;
		}
	}
}
