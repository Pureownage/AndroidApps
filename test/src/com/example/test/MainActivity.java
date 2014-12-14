package com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
	
	
	
	
	TextView Line1;
	TextView Line2;
	TextView Line3;
	TextView Line4;
	TextView Line5;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
    	//new HttpAsyncTask().execute("http://api.openweathermap.org/data/2.5/forecast/daily?q=Solihull&cnt=3&mode=json");
    	
    	//public static String JSON_STRING = "{\"coord\":{\"lon\":-1.78,\"lat\":52.41},\"sys\":{\"type\":1,\"id\":5055,\"message\":0.1066,\"country\":\"GB\",\"sunrise\":1415344499,\"sunset\":1415377601},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":284.25,\"pressure\":986,\"humidity\":93,\"temp_min\":283.15,\"temp_max\":285.15},\"wind\":{\"speed\":4.6,\"deg\":190,\"var_beg\":160,\"var_end\":230},\"clouds\":{\"all\":40},\"dt\":1415355115,\"id\":2637546,\"name\":\"Solihull\",\"cod\":200}";
    	
    	new HttpAsyncTask().execute("http://api.openweathermap.org/data/2.5/weather?q=London,uk");

    }
    public static String GET(String url){
    	InputStream inputStream = null;
    	String Result = "";
    	try {
    		// This makes a new HTTPClient
    		HttpClient httpclient = new DefaultHttpClient();
    		
    		HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
    		
    		inputStream = httpResponse.getEntity().getContent();
    		
    		if(inputStream != null){
    		Result = convertInputStreamToString(inputStream);
    		} else{
    			Result = "Not working";
    		}
    	} catch (Exception e){
    		Log.d("InputStream", e.getLocalizedMessage());
    	}
    	return Result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String Line = "";
        String Result = "";
        while((Line = bufferedReader.readLine()) != null)
            Result += Line;
 
        inputStream.close();
        return Result;
 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	makeJson(result);
       }
    }
    
    public void makeJson(String Result){
    	
    	 Line1 = (TextView) findViewById(R.id.Line1);
    	 Line2 = (TextView) findViewById(R.id.Line2);
    	 Line3 = (TextView) findViewById(R.id.Line3);
    	 Line4 = (TextView) findViewById(R.id.Line4);
    	try {
    		JSONObject weather = (new JSONObject(Result)).getJSONObject("main");
    		int temp = weather.getInt("temp");
    			StringBuilder sb = new StringBuilder();
    			sb.append(temp);
    			String strTemp = sb.toString();
    			Line1.setText("The temp is " + strTemp);
    		int pres = weather.getInt("pressure");
    		StringBuilder sb1 = new StringBuilder();
    			sb1.append(pres);
    			String strpres = sb1.toString();
    			Line2.setText("The pressure is " + strpres);
    		int hum = weather.getInt("humidity");
    		StringBuilder sb2 = new StringBuilder();
    		sb2.append(hum);
    		String strhum = sb2.toString();
    		Line3.setText("The humidity is " + strhum);
    		

       		
    		JSONArray Arraymain = (new JSONObject (Result)).getJSONArray("weather");
    		JSONObject Test = Arraymain.getJSONObject(0);
    		Line4.setText("The weather is " + Test.getString("main"));
    		
    	} catch (JSONException e) {
    		e.printStackTrace();			
    	}
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
}
