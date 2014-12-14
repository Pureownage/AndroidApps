package com.example.waiterapitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	int WaterTotal = 0;
	int CokeTotal = 0;
	int BeerTotal = 0;
	double Total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	TextView textView7 = (TextView)findViewById(R.id.textView7);
    	textView7.setText("Total ammount of water = " + WaterTotal);
    	TextView textView4 = (TextView)findViewById(R.id.textView4);
    	textView4.setText("Total ammount of coke = " + CokeTotal);
    	TextView textView5 = (TextView)findViewById(R.id.textView5);
    	textView5.setText("Total ammount of beer = " + BeerTotal);
    	TextView textView6 = (TextView)findViewById(R.id.textView6);
    	textView6.setText("Total ammount of your order is = £" + Total);
    }
public void addWater(View view){
    	WaterTotal = WaterTotal + 1;
    	Total = Total + 1.00;
    	TextView textView7 = (TextView)findViewById(R.id.textView7);
    	textView7.setText("Total ammount of water = " + WaterTotal);
    	TextView textView6 = (TextView)findViewById(R.id.textView6);
    	textView6.setText("Total ammount of your order is = £" + Total);
    }
public void addCoke(View view){
	CokeTotal = CokeTotal + 1;
	Total = Total + 1.50;
	TextView textView4 = (TextView)findViewById(R.id.textView4);
	textView4.setText("Total ammount of coke = " + CokeTotal);
	TextView textView6 = (TextView)findViewById(R.id.textView6);
	textView6.setText("Total ammount of your order is = £" + Total);
}
public void addBeer(View view){
	BeerTotal = BeerTotal + 1;
	Total = Total + 2.75;
	TextView textView5 = (TextView)findViewById(R.id.textView5);
	textView5.setText("Total ammount of beer = " + BeerTotal);
	TextView textView6 = (TextView)findViewById(R.id.textView6);
	textView6.setText("Total ammount of your order is = £" + Total);
}
public void removeWater(View view){
	if (WaterTotal == 0){
		
	} else {
	WaterTotal = WaterTotal - 1;
	Total = Total - 1.0;
	TextView textView7 = (TextView)findViewById(R.id.textView7);
	textView7.setText("Total ammount of water = " + WaterTotal);
	TextView textView6 = (TextView)findViewById(R.id.textView6);
	textView6.setText("Total ammount of your order is = £" + Total);
	}
}
public void removeCoke(View view){
	if (CokeTotal == 0){
		
	} else {
		CokeTotal = CokeTotal - 1;
		Total = Total - 1.50;
		TextView textView4 = (TextView)findViewById(R.id.textView4);
		textView4.setText("Total ammount of coke = " + CokeTotal);
		TextView textView6 = (TextView)findViewById(R.id.textView6);
		textView6.setText("Total ammount of your order is = £" + Total);
	}
}
public void removeBeer(View view){
	if (BeerTotal == 0){
		
	} else {
		BeerTotal = BeerTotal - 1;
		Total = Total - 2.75;
		TextView textView5 = (TextView)findViewById(R.id.textView5);
		textView5.setText("Total ammount of beer = " + BeerTotal);
		TextView textView6 = (TextView)findViewById(R.id.textView6);
		textView6.setText("Total ammount of your order is = £" + Total);
	}
}
}
    