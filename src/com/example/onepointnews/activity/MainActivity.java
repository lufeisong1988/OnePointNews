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
package com.example.onepointnews.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.onepointnews.fragment.SlidLeftFragment;
import com.example.onepointnews.fragment.SlidRightFragment;
import com.example.onepointnews.fragment.SlidCenterFragment;
import com.example.onepointnews.fragment.SlidCenterFragment.MyPageChangeListener;
import com.example.onepointnews.view.SlidingMenu;
import com.example.onepointnews.R;

public class MainActivity extends FragmentActivity {
	SlidingMenu mSlidingMenu;
	SlidLeftFragment leftFragment;
	SlidRightFragment rightFragment;
	SlidCenterFragment viewPageFragment;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);
		init();
		initListener();

	}

	private void init() {
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.slidleft_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.slidright_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.slidcenter_frame, null));

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new SlidLeftFragment();
		t.replace(R.id.left_frame, leftFragment);

		rightFragment = new SlidRightFragment();
		t.replace(R.id.right_frame, rightFragment);

		viewPageFragment = new SlidCenterFragment();
		t.replace(R.id.center_frame, viewPageFragment);
		t.commit();
	}

	private void initListener() {
		viewPageFragment.setMyPageChangeListener(new MyPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				if(viewPageFragment.isFirst()){
					mSlidingMenu.setCanSliding(true,false);
				}else if(viewPageFragment.isEnd()){
					mSlidingMenu.setCanSliding(false,true);
				}else{
					mSlidingMenu.setCanSliding(false,false);
				}
			}
		});
	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
