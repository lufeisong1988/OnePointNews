package com.example.onepointnews.activity;
/**
 * 选择登入界面
 */
import com.example.onepointnews.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SelectLoginActivity extends Activity implements OnClickListener{
	private LinearLayout registerBnt;
	private LinearLayout testBnt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_select);
		initView();
		listener();
	}
	void initView(){
		registerBnt = (LinearLayout) findViewById(R.id.login_select_register);
		testBnt = (LinearLayout) findViewById(R.id.login_select_test);
	}
	void listener(){
		registerBnt.setOnClickListener(this);
		testBnt.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.login_select_register:
			startActivity(new Intent(SelectLoginActivity.this,RegisterActivity.class));
			break;
		case R.id.login_select_test:
			startActivity(new Intent(SelectLoginActivity.this,MainActivity.class));
			SelectLoginActivity.this.finish();
			break;
		}
	}
}
