/*
 * Copyright (C) 2012 yueyueniao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.onepointnews.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.onepointnews.R;
import com.example.onepointnews.activity.MainActivity;
import com.example.onepointnews.adapter.SlidLeftThemeAdapter;

public class SlidLeftFragment extends Fragment implements OnClickListener{
	private LinearLayout explore;
	private LinearLayout collection;
	private LinearLayout offline;
	private LinearLayout setting;
	private ImageView headIv;
	private TextView nameTv;
	private ListView themeLv;
	
	private SlidLeftThemeAdapter adapter;
	private ArrayList<String> themeNameList = new ArrayList<String>();
	public SlidLeftFragment(){
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slidleft, null);
		initParams(view);
		initView(view);
		listener();
		initData();
		return view;
	}
	void initParams(View view){
		float scale = this.getResources().getDisplayMetrics().density;
		DisplayMetrics dm = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		view.setLayoutParams(new LayoutParams(dm.widthPixels - (int)(80 * scale + 0.5f), dm.heightPixels));
	}
	void initView(View view){
		explore = (LinearLayout) view.findViewById(R.id.left_explore);
		collection = (LinearLayout) view.findViewById(R.id.left_collection);
		offline = (LinearLayout) view.findViewById(R.id.left_offline);
		setting = (LinearLayout) view.findViewById(R.id.left_setting);
		headIv = (ImageView) view.findViewById(R.id.left_head_iv);
		nameTv = (TextView) view.findViewById(R.id.left_name_tv);
		themeLv = (ListView) view.findViewById(R.id.left_themeLv);
	}
	void listener(){
		explore.setOnClickListener(this);
		collection.setOnClickListener(this);
		offline.setOnClickListener(this);
		setting.setOnClickListener(this);
	}
	void initData(){
		themeNameList.add("1");
		themeNameList.add("2");
		themeNameList.add("3");
		themeNameList.add("4");
		themeNameList.add("5");
		themeNameList.add("6");
		themeNameList.add("7");
		themeNameList.add("8");
		themeNameList.add("9");
		themeNameList.add("10");
		
		adapter = new SlidLeftThemeAdapter(getActivity(), themeNameList);
		themeLv.setAdapter(adapter);
		themeLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				((MainActivity)getActivity()).showCenter(themeNameList.get(arg2));
				
			}
		});
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.left_explore:
			break;
		case R.id.left_collection:
			break;
		case R.id.left_offline:
			break;
		case R.id.left_setting:
			break;
		}
		
	}

}
