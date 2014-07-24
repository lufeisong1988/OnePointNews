package com.example.onepointnews.adapter;

import java.util.ArrayList;

import com.example.onepointnews.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SlidLeftThemeAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<String> themeNameList;
	public SlidLeftThemeAdapter(Context mContext,ArrayList<String> themeNameList){
		this.mContext = mContext;
		this.themeNameList = themeNameList;
	}
	@Override
	public int getCount() {
		return themeNameList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder vh = null;
		if(arg1 == null){
			vh = new ViewHolder();
			arg1 = LayoutInflater.from(mContext).inflate(R.layout.slidleft_theme_item, null);
			arg1.setTag(vh);
		}else{
			vh = (ViewHolder) arg1.getTag();
		}
		vh.tv = (TextView) arg1.findViewById(R.id.slidleft_theme_item_tv);
		vh.tv.setText(themeNameList.get(arg0));
		return arg1;
	}
	class ViewHolder{
		TextView tv;
	}
}
