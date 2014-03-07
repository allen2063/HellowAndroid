package com.example.hellowandroid;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import java.text.DecimalFormat;


public class HellowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		TextView tv = new TextView(this);
		tv.setText("Hellow 一吹!");
		setContentView(tv);
		*/
		setContentView(R.layout.activity_hellow);
		Button button = (Button)findViewById(R.id.submit);
		findViews();
		setListeners();
		//button.setOnClickListener(calcBMI);
	}
	
	private Button button_calc;
	private EditText field_height;
	private EditText field_weight;
	private TextView view_result;
	private TextView view_suggest;
	private void findViews(){
		button_calc = (Button) findViewById(R.id.submit);
		field_height = (EditText) findViewById(R.id.height);
		field_weight = (EditText) findViewById(R.id.weight);
		view_result = (TextView) findViewById(R.id.result);
		view_suggest = (TextView) findViewById(R.id.suggest);
	}
	
	private void setListeners(){
		button_calc.setOnClickListener(calcBMI);
	}
	
	private Button.OnClickListener calcBMI = new Button.OnClickListener(){
		public void onClick(View v){
			DecimalFormat nf = new DecimalFormat("0.0");
			double height = Double.parseDouble(field_height.getText().toString())/100;
			double weight = Double.parseDouble(field_weight.getText().toString());
			double BMI = weight / (height*height);
			
			view_result.setText("Your BMI is "+nf.format(BMI));
			
			TextView fieldsuggest = (TextView)findViewById(R.id.suggest);
			if(BMI>25){
				fieldsuggest.setText(R.string.advice_heavy);
			}else if (BMI<20){
				fieldsuggest.setText(R.string.advice_light);
			}else {
				fieldsuggest.setText(R.string.advice_average);
			}
			//openOptionsDialog();
		}
		
		
		
		
	};
	
	private void openOptionsDialog(){
		new AlertDialog.Builder(HellowActivity.this)
		.setTitle(R.string.about_title)
		.setMessage(R.string.about_msg)
		.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		})
		.setNegativeButton(R.string.homepage_label, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// go to url
				Uri uri = Uri.parse(getString(R.string.homepage_uri));
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
				
			}
		})
		.show();
	}

	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST+1;
	
		@Override
		public boolean onCreateOptionsMenu(Menu menu){
			menu.add(0,MENU_ABOUT,0,"关于……");
			menu.add(0,MENU_QUIT,0,"结束");
			return super.onCreateOptionsMenu(menu);
		} 
		
		public boolean onOptionsItemSelected(MenuItem item){
			switch(item.getItemId()){
				case MENU_ABOUT:
					 openOptionsDialog();
					 break;
				case MENU_QUIT:
					 finish();
					 break;
			}
			return super.onOptionsItemSelected(item);
		}
	/*
	private OnClickListener calcBMI = new OnClickListener(){
		public void onClick(View v){
			DecimalFormat nf = new DecimalFormat("0.00");
			EditText fieldheight = (EditText)findViewById(R.id.height);
			EditText fieldweight = (EditText)findViewById(R.id.weight);
			
			double height = Double.parseDouble(fieldheight.getText().toString())/100;
			double weight = Double.parseDouble(fieldweight.getText().toString());
			double BMI = weight / (height * height);
			
			TextView result = (TextView)findViewById(R.id.result);
			result.setText("Your BMI is "+nf.format(BMI));
			
			TextView fieldsuggest = (TextView)findViewById(R.id.suggest);
			if(BMI>25){
				fieldsuggest.setText(R.string.advice_heavy);
			}else if (BMI<20){
				fieldsuggest.setText(R.string.advice_light);
			}else {
				fieldsuggest.setText(R.string.advice_average);
			}
		}
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hellow, menu);
		return true;
	}
	*/
}
