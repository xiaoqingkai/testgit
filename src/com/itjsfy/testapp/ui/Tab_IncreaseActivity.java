package com.itjsfy.testapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itjsfy.testapp.R;

public class Tab_IncreaseActivity extends Fragment
{

	private HomeActivity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		activity = (HomeActivity) getActivity();
		View view = inflater.inflate(R.layout.activity_increase, null);
		initView();
		return view;
	}

	private void initView()
	{
		
	}
}
