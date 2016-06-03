package com.itjsfy.testapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.itjsfy.testapp.R;

public class HomeActivity extends FragmentActivity implements OnCheckedChangeListener
{
	protected static final int INVALID_FRAGMENT_ID = -1;
	protected FragmentManager mFragmentManager;
	private RadioGroup Tabbar;
	private RadioButton RbExchange;
	private RadioButton RbIncrease;
	private RadioButton RbMine;
	private RadioButton RbPlan;
	protected Fragment mCurrrentSecondaryFragment;
	private int mCurrentPrimaryFragmentId = INVALID_FRAGMENT_ID;
	private String mCurrentPrimaryFragmentTag;
	protected Fragment mCurrentPrimaryFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mFragmentManager = getSupportFragmentManager();
		Tabbar = (RadioGroup) findViewById(R.id.rg_tab_bar);
		RbExchange = (RadioButton) findViewById(R.id.rb_tab_exchange);
		RbIncrease = (RadioButton) findViewById(R.id.rb_tab_increase);
		RbMine = (RadioButton) findViewById(R.id.rb_tab_mine);
		RbPlan = (RadioButton) findViewById(R.id.rb_tab_plan);
		Tabbar.setOnCheckedChangeListener(this);
		SwitchTab(R.id.rb_tab_mine);
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		SwitchTab(checkedId);
	}

	private void SwitchTab(int index)
	{
		switch (index)
		{
			case R.id.rb_tab_exchange:
				// 初始化进入主页 底部
				RbExchange.setChecked(true);
				break;
			case R.id.rb_tab_increase:
				RbIncrease.setChecked(true);
				break;
			case R.id.rb_tab_plan:
				RbPlan.setChecked(true);
				break;
			case R.id.rb_tab_mine:
				RbMine.setChecked(true);
				break;
			default:
				throw new IllegalArgumentException();
		}
		switchPrimaryFragment(index);
	}
	protected FragmentTransaction beginPrimaryFragmentTransaction(int enterFragmentId, int exitFragmentId)
	{
		FragmentTransaction ft = mFragmentManager.beginTransaction();
		return ft;
	}
	private void switchPrimaryFragment(int fragmentId)
	{
		Class<? extends Fragment> clz = getPrimaryFragmentClass(fragmentId);
		mCurrentPrimaryFragmentTag = clz.getName();
		Fragment fragment = mFragmentManager.findFragmentByTag(mCurrentPrimaryFragmentTag);
		FragmentTransaction ft = beginPrimaryFragmentTransaction(fragmentId, mCurrentPrimaryFragmentId);
		if (fragment == null)
		{
			fragment = Fragment.instantiate(this, clz.getName());
			Bundle args = getPrimaryFragmentArguments(fragmentId);
			fragment.setArguments(args);
			ft.replace(getPrimaryFragmentStubId(), fragment, mCurrentPrimaryFragmentTag);
		} else
		{
			ft.attach(fragment);
		}
		mCurrentPrimaryFragment = fragment;
		ft.commit();
	}

	private int getPrimaryFragmentStubId()
	{
		return R.id.fragment_stub;
	}

	private Bundle getPrimaryFragmentArguments(int fragmentId)
	{
		return null;
	}

	private Class<? extends Fragment> getPrimaryFragmentClass(int fragmentId)
	{
		Class clazz = null;
		switch (fragmentId)
		{
			case R.id.rb_tab_exchange:
				clazz = Tab_Exchange.class;
				break;
			case R.id.rb_tab_increase:
				clazz = Tab_IncreaseActivity.class;
				break;
			case R.id.rb_tab_plan:
				clazz = Tab_PlanActivity.class;
				break;
			case R.id.rb_tab_mine:
				clazz = Tab_MineActivity.class;
				break;
			default:
				throw new IllegalArgumentException();
		}
		return clazz;
	}
}
