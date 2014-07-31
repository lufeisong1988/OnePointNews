package com.example.onepointnews.activity;

import com.example.onepointnews.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class RegisterActivity extends Activity implements OnClickListener{
	private ImageButton back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_register);
		initView();
		listener();
	}
	void initView(){
		back = (ImageButton) findViewById(R.id.my_register_back);
	}
	void listener(){
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.my_register_back:
			RegisterActivity.this.finish();
		break;
		}
	}

}
