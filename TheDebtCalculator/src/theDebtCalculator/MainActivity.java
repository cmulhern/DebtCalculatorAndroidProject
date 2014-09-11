package theDebtCalculator;



import cj.the.debt.calculator.R;
import theDebtCalculatorAdapter.TabsPagerAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements TabListener {

	private TabsPagerAdapter tabsPagerAdapter;
	private ViewPager viewPager;
	private ActionBar actionBar;
	private String[] tabs = {"Calculate", "Compare"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		
		viewPager.setAdapter(tabsPagerAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for(String name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(name).setTabListener(this));
		}
		
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// Do nothing
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// Do nothing				
			}		
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// Do nothing
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// Do nothing
	}	
	
}
	
