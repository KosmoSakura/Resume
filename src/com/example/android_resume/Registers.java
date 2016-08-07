package com.example.android_resume;

import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registers extends Activity {
	EditText name,passWord1,passWord2;
	SharedPreferences sp ;
	Editor e;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name = (EditText) findViewById(R.id.R_editUserName);
		passWord1 = (EditText) findViewById(R.id.R_editpassword);
		passWord2 = (EditText) findViewById(R.id.R_et_countersignPassword);
		sp = getSharedPreferences("login", MODE_PRIVATE);
		e = sp.edit();
	}
public void tt(String s){
	Toast.makeText(Registers.this, s, Toast.LENGTH_SHORT).show();
}
	public void myclick(View v){
		switch (v.getId()) {
		case R.id.R_btn_cancel:
			finish();
			break;
		case R.id.R_btn_submit:
			String sName = name.getText()+"";
			String pWord1 = passWord1.getText()+"";
			String pWord2 = passWord2.getText()+"";
			if (sName.equals("")) {
				tt("�������˺š���");
			}else if (sName.equals(sp.getString(sName, ""))) {
				tt("���˻��Ѵ���");
			}
			else if (pWord1.equals("")) {
				tt("����������");
			}
			
			else if (pWord2.equals("")) {
				tt("������ȷ������");
			}
			else if (!pWord1.equals(pWord2)) {
				tt("�������벻һ��");
			}else {
				e.putString(sName, sName);
				e.putString(sName+1, pWord1);
				e.commit();
				tt("ע��ɹ�");
				startActivity(new Intent(Registers.this, MainActivity.class));
				finish();
			}
			break;
		}
	}
}
