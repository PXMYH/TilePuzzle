package com.px.tilepuzzle;


import com.px.tilepuzzle.util.DisplaySolution;
import com.px.tilepuzzle.util.ImageBreakdown;
import com.px.tilepuzzle.util.ListImageAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;


public class ImageSelection extends Activity implements OnItemClickListener {
	
	private Button diff_button_easy, diff_button_medium, diff_button_hard;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_selection);
        
        CharSequence toast_msg = "Loaded UBC Logo";
        showMessage (toast_msg);
		
        // Find the list image view by ID and pass it to customized list image adapter
        // The customized list image adapter is defined in ListImageAdapter.java
        ListView logo_list = (ListView)findViewById(R.id.image_list);
        logo_list.setAdapter(new ListImageAdapter(this));
        logo_list.setOnItemClickListener(this);
        
        // Set the behavior of difficulty level buttons
        diff_button_easy = (Button)findViewById(R.id.Difficulty_Easy);
        diff_button_medium = (Button)findViewById(R.id.Difficulty_Medium);
        diff_button_hard = (Button)findViewById(R.id.Difficulty_Hard);
        
        diff_button_easy.setOnClickListener((OnClickListener) this);
	}
	
	public void onClick(View v) {
		CharSequence text;

		// find out which button was pushed based on its ID
		switch(v.getId()) {
			case R.id.Difficulty_Easy: text = "'accept' clicked!"; break;
			case R.id.Difficulty_Hard: text = "'cancel' clicked!"; break;
			default: text="Dunno what was pushed!";
		}

		// notify the user which button was clicked
		showMessage(text);
	}
	
	private void showMessage (CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
	
	
	// Switch to another activity -- Display a full screen picture with breakdown solution image
	public void ImageBreakdown(View v) {
		Intent i = new Intent(this, ImageBreakdown.class);
		startActivity(i);
	}
	
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
    	
    	// create the Intent to open our ShowImage activity.
    	Intent solution = new Intent(this, DisplaySolution.class);
   
    	// pass a key:value pair into the 'extra' bundle for
    	// the intent so the activity is made aware which
    	// photo was selected.
    	solution.putExtra("ubc_logo", id);

    	// start our activity
    	startActivity(solution);
    }
	
}



