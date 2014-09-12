package theDebtCalculator;

import java.util.ArrayList;

import cj.the.debt.calculator.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CompareFragment extends Fragment {
	private TableLayout myView;
	private int numRows = 0;
	private ArrayList<Integer> highlightedRows;


	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_compare, container, false);
		return rootView;
	}
	

	public void addData(String[] data, Activity activity) {
		TableRow newRow = new TableRow(activity);
		numRows++;
		newRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		newRow.setId(numRows);
		
		
		for(int x = 0; x < data.length; x++) {
			
			TextView newView = new TextView(activity);
			newView.setLayoutParams(new TableRow.LayoutParams(0, 30, 1.0f));
			newView.setGravity(17);
			newView.setId(numRows);			
			newView.setTextSize(14);
			newView.setText(data[x]);
			newRow.addView(newView);
		}
		((TableLayout) activity.findViewById(R.id.compare_table)).addView(newRow);
	}		
}
