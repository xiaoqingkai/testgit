package com.itjsfy.testapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itjsfy.testapp.R;
import com.itjsfy.testapp.util.PreferenceConstants;
import com.itjsfy.testapp.util.PreferenceUtils;

public class LoginActivity extends Activity implements OnClickListener
{

	private TextView mTvName;
	private TextView mTvPsd;
	private Button BtnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void findData()
	{
		String name = mTvName.getText().toString().trim();
		String password = mTvPsd.getText().toString().trim();
		if (name.equals("")||password.equals(""))
		{
			Toast.makeText(getApplicationContext(), "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
		}else {
			if (name.equals("test")&&password.equals("123"))
			{
				PreferenceUtils.setPrefString(getApplicationContext(), PreferenceConstants.USER_NAME, name);
				PreferenceUtils.setPrefString(getApplicationContext(), PreferenceConstants.USER_PSD, password);
				Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				startActivity(intent);
				finish();
			}else {
				Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void initView()
	{
		mTvName = (TextView) findViewById(R.id.et_userName);
		mTvPsd = (TextView) findViewById(R.id.et_psd);
		BtnLogin = (Button) findViewById(R.id.btn_login);
		BtnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId()) {
			case R.id.btn_login:
				findData();
				break;
			default:
				break;
		}
	}
}
