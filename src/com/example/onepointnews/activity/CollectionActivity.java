package com.example.onepointnews.activity;

import com.example.onepointnews.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class CollectionActivity extends Activity implements OnClickListener{
	private ImageButton back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collection);
		initView();
		listener();
	}
	void initView(){
		back = (ImageButton) findViewById(R.id.collection_back);
	}
	void listener(){
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.collection_back:
			this.finish();
			overridePendingTransition(R.anim.keep_state, R.anim.dismiss_to_right);
			break;
		}
		
	}
}
