package com.example.onepointnews.activity;
/**
 * 引导界面
 */
import java.util.ArrayList;
import java.util.List;

import com.example.onepointnews.R;
import com.example.onepointnews.adapter.GuideViewAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuideViewActivity extends Activity implements OnClickListener,OnPageChangeListener{
	private ViewPager vp;
	private LinearLayout dotContains;
	
	private GuideViewAdapter adapter;
	private ImageView iv;
	private Button bnt;
	private List<View> views = new ArrayList<View>();
	private int[] imgs = new int[]{
		R.drawable.guide1,R.drawable.guide2,R.drawable.guide3,R.drawable.guide4
	};
	private ImageView[] dots;
	private int currentIndex;  //记录当前被选中的page
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_guideview);
		initView();
		initDots();
		initData();
	}
	void initView(){
		vp = (ViewPager) findViewById(R.id.guideview_vp);
		dotContains = (LinearLayout) findViewById(R.id.guideview_contian);
		adapter = new GuideViewAdapter(views);
		vp.setAdapter(adapter);
		vp.setOnPageChangeListener(this);
	}
	void initDots(){
		dots = new ImageView[imgs.length];
		for(int i = 0;i < imgs.length;i++){
			dots[i] = (ImageView) dotContains.getChildAt(i);
			dots[i].setEnabled(true);
			dots[i].setOnClickListener(this);
			dots[i].setTag(i);
		}
		currentIndex = 0;
		dots[currentIndex].setEnabled(false);
	}
	void initData(){
		for(int i = 0;i < imgs.length;i++){
			View view = LayoutInflater.from(this).inflate(R.layout.login_guideview_item, null);
			iv = (ImageView) view.findViewById(R.id.guideview_item_iv);
			bnt = (Button) view.findViewById(R.id.guideview_item_bnt);
			iv.setBackgroundResource(imgs[i]);
			bnt.setOnClickListener(BntClickListener);
			views.add(view);
		}
		adapter.notifyDataSetChanged();
	}
	void setCurView(int position){
		if(position < 0 || position >= imgs.length)
			return;
		vp.setCurrentItem(position);
	}
	void setCurDot(int position){
		System.out.print(position + ":");
		if(position == (imgs.length - 1)){
			bnt.setVisibility(View.VISIBLE);
		}else{
			bnt.setVisibility(View.INVISIBLE);
		}
		if(position < 0 || position > imgs.length - 1 || currentIndex == position)
			return;
		dots[position].setEnabled(false);
		dots[currentIndex].setEnabled(true);
		currentIndex = position;
	}
	/*
	 * 底部 点 的监听事件
	 * (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setCurView(position);
		setCurDot(position);
	}
	/*
	 * ViewPager 的监听事件
	 * (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	@Override
	public void onPageSelected(int arg0) {
		setCurDot(arg0);
	}
	
	
	private View.OnClickListener BntClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent(GuideViewActivity.this,SelectLoginActivity.class));
			GuideViewActivity.this.finish();
		}
	};
}
