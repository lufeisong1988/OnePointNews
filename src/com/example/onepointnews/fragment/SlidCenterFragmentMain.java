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

import java.util.Arrays;
import java.util.LinkedList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.onepointnews.R;
import com.example.onepointnews.view.PullAndLoadListView;


public class SlidCenterFragmentMain extends Fragment {
	private PullAndLoadListView lv;
	private LinearLayout title;
	private LinkedList<String> mListItems;

	// The data to be displayed in the ListView
	private String[] mNames = { "Fabian", "Carlos", "Alex", "Andrea", "Karla",
			"Freddy", "Lazaro", "Hector", "Carolina", "Edwin", "Jhon",
			"Edelmira", "Andres" };
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slidcenter_main, null);
		
		
		initView(view);
		initData();
		return view;
	}
	void initView(View view){
		lv = (PullAndLoadListView) view.findViewById(R.id.lv);
		title = (LinearLayout) view.findViewById(R.id.slidcenter_main_title);
	}
	void initData(){
		mListItems = new LinkedList<String>();
		mListItems.addAll(Arrays.asList(mNames));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mListItems);

		lv.setAdapter(adapter);
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}

