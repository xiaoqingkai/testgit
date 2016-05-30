package com.itjsfy.testapp.ui;

import com.itjsfy.testapp.R;
import com.itjsfy.testapp.R.id;
import com.itjsfy.testapp.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends Activity
{

	private TextView mTvName;
	private TextView mTvPsd;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView()
	{
		mTvName = (TextView) findViewById(R.id.et_userName);
		mTvPsd = (TextView) findViewById(R.id.et_psd);
		
	}
}
