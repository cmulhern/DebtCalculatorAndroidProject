package theDebtCalculator;

import java.text.DecimalFormat;

import cj.the.debt.calculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalculateFragment extends Fragment  {
	
    private Double months;
	private Double interestPayment;
	private DataMessenger messenger;
	
	public interface DataMessenger {
		public void sendData(String[] data);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_calculate, container, false);
		
		final TextView answer = (TextView) rootView.findViewById(R.id.answer);
		final EditText amountField = (EditText) rootView.findViewById(R.id.debt1_amount);
		final EditText interestField = (EditText) rootView.findViewById(R.id.debt1_interest);
		final EditText monthlyField = (EditText) rootView.findViewById(R.id.debt1_monthly);
		final DecimalFormat format = new DecimalFormat("'$'0.00");
		final Button saveButton = (Button) rootView.findViewById(R.id.saveResult);
		
		saveButton.setVisibility(View.GONE);
		answer.setVisibility(View.GONE);

		Button calculateButton = (Button) rootView.findViewById(R.id.calculate);
		calculateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				

				String answerText = "";
				if(!amountField.getText().toString().equals("") && !interestField.getText().toString().equals("") && !monthlyField.getText().toString().equals("")) {
					Double amount = Double.parseDouble(amountField.getText().toString());
					Double interest = Double.parseDouble(interestField.getText().toString())/100;
					Double monthly = Double.parseDouble(monthlyField.getText().toString());
					
					if(amount * interest > monthly) {
						answerText = "Your monthly payment is too low! Your total owed grows by " + format.format((amount*interest) - monthly) +" every month!";
						saveButton.setVisibility(View.GONE);
					}
					else {
						double num = Math.log(1-((amount/monthly)*(interest/12)));
						double denom = Math.log(1+(interest/12));
						months = -1.0 * (num/denom);
						interestPayment = (monthly * months) - amount;
						months = Math.ceil(months);
						answerText = "You will pay your debt off in " + months + " months. You will pay " + format.format(interestPayment) + " in interest.";
						saveButton.setVisibility(View.VISIBLE);
					}
				}
				else {
					answerText = "You must fill out all fields!";
					answer.setVisibility(View.GONE);
				}
				
				answer.setText(answerText);
				answer.setVisibility(View.VISIBLE);
				
			}
			
		});
		
		saveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String[] data = {amountField.getText().toString(), interestField.getText().toString(), monthlyField.getText().toString(),
						months.toString(), format.format(interestPayment).toString() }; 
				if(messenger != null) {
					messenger.sendData(data);
				}
			}
			
		});
		return rootView;
	}
	
	
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			messenger = (DataMessenger) activity;
		}
		catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + 
					" must implement DataMessenger");
		}
	}


}
