package com.itjsfy.testapp.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

import com.itjsfy.testapp.AlertPlanActivity;
import com.itjsfy.testapp.R;

public class Tab_PlanActivity extends Fragment implements OnClickListener
{

	private HomeActivity activity;
	private LinearLayout AddPlan;
	private LinearLayout AlertPlan;
	private LinearLayout ModifyPlan;
	private LinearLayout PlanList;
	private PopupWindow mPopWindow;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		activity = (HomeActivity) getActivity();
		View view = inflater.inflate(R.layout.activity_plan, null);
		initView(view);
		return view;
	}

	private void initView(View view)
	{
		AddPlan = (LinearLayout) view.findViewById(R.id.ll_plans_addplan);
		AlertPlan = (LinearLayout) view.findViewById(R.id.ll_plans_alertplan);
		ModifyPlan = (LinearLayout) view.findViewById(R.id.ll_plans_modifyplan);
		PlanList = (LinearLayout) view.findViewById(R.id.ll_plans_planlist);
		AddPlan.setOnClickListener(this);
		AlertPlan.setOnClickListener(this);
		ModifyPlan.setOnClickListener(this);
		PlanList.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		Intent intent = null;
		switch (v.getId()) {
			case R.id.ll_plans_addplan:
				intent = new Intent(activity, AddPlanActivity.class);
				intent.putExtra("TAG", "add");
				startActivity(intent);
				break;
			case R.id.ll_plans_alertplan:
				intent = new Intent(activity, AlertPlanActivity.class);
				startActivity(intent);
				break;
			case R.id.ll_plans_modifyplan:

				break;
			case R.id.ll_plans_planlist:
				showPopupWindow();
				break;
		}

	}

	private void showPopupWindow()
	{
		int[] location = new int[2];
		PlanList.getLocationOnScreen(location);
		View contentView = LayoutInflater.from(activity).inflate(R.layout.plan_popup, null);  
		mPopWindow = new PopupWindow(contentView,  
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);  
		mPopWindow.setContentView(contentView);  

		mPopWindow.setBackgroundDrawable(new BitmapDrawable());   
		mPopWindow.setFocusable(true);   
		mPopWindow.setOutsideTouchable(true); 

		contentView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int popupWidth = contentView.getMeasuredWidth();
		int popupHeight =  contentView.getMeasuredHeight();
		mPopWindow.showAtLocation(PlanList, Gravity.NO_GRAVITY, (location[0]+PlanList.getWidth()/2)-popupWidth/2,
				location[1]-popupHeight);
	}
}
