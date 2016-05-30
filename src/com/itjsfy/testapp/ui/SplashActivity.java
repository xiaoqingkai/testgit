package com.itjsfy.testapp.ui;

import com.itjsfy.testapp.R;
import com.itjsfy.testapp.R.layout;
import com.itjsfy.testapp.util.PreferenceConstants;
import com.itjsfy.testapp.util.PreferenceUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity
{
	private static final int SHOW_TIME = 3000;// 最小显示时间
	public Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		handler = new Handler();

		String userName = PreferenceUtils.getPrefString(this, PreferenceConstants.USER_NAME, null);
		String userPsd = PreferenceUtils.getPrefString(this, PreferenceConstants.USER_PSD, null);
		if (userName != null && userPsd != null)
		{
			handler.postDelayed(goToHomeActivity, SHOW_TIME);
		}
		else
		{
			handler.postDelayed(goToLoginActivity, SHOW_TIME);
		}
	}
	// 进入LoginActivity
	Runnable goToLoginActivity = new Runnable()
	{

		@Override
		public void run()
		{
			SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
			finish();
		}
	};

	// 进入HomeAcitivty
	Runnable goToHomeActivity = new Runnable()
	{

		@Override
		public void run()
		{
			SplashActivity.this.startActivity(new Intent(SplashActivity.this, HomeActivity.class));
			finish();
		}
	};
}
