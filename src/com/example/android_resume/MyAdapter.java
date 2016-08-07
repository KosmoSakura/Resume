package com.example.android_resume;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	List<Infos> list;
	LayoutInflater lay;
	
	
	public MyAdapter(List<Infos> list, Context context) {
		this.list = list;
		this.lay = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		ViewHolder hol;
		if (convertView==null) {
			convertView = lay.inflate(R.layout.infos, null);
			hol = new ViewHolder();
			hol.pic = (ImageView) convertView.findViewById(R.id.iv_pic);
			hol.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			hol.tv_sex = (TextView) convertView.findViewById(R.id.tv_sex);
			convertView.setTag(hol);
		}else {
			hol = (ViewHolder) convertView.getTag();
		}
		Infos in = list.get(position);
		hol.pic.setImageResource(in.getPic());
		hol.tv_name.setText(in.getName()+"");
		hol.tv_sex.setText(in.getSex()+"");
		return convertView;
	}

	class ViewHolder{
		ImageView pic;
		TextView tv_name,tv_sex;
	}
}
