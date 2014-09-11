package cj.the.deb.calculator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import cj.the.debt.calculator.CalculateFragment;
import cj.the.debt.calculator.CompareFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter{

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return new CalculateFragment();
		case 1:
			return new CompareFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		
		return 2;
	}

}
