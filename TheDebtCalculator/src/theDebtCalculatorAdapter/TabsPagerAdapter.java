package theDebtCalculatorAdapter;

import cj.the.debt.calculator.R;
import theDebtCalculator.CalculateFragment;
import theDebtCalculator.CompareFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter{
	CalculateFragment calculate;
	CompareFragment compare;
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
