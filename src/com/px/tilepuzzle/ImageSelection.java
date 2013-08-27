package com.px.tilepuzzle;

import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import android.app.ListActivity;

public class ImageSelection extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_image_selection);

		// define verification messages when pressing different difficulty level buttons
		final Button level_easy = (Button) findViewById(R.id.Difficulty_Level_1);
		level_easy.setOnClickListener (verify_msg);
		//final Button level_medium = (Button) findViewById(R.id.Difficulty_Level_2);
		//level_medium.setOnClickListener (verify_msg);
		final Button level_hard = (Button) findViewById(R.id.Difficulty_Level_3);
		level_hard.setOnClickListener (verify_msg);
		}
	
	 private OnClickListener verify_msg = new OnClickListener() {

		@Override
		public void onClick(View v) {
   		// get the current context to display a Toast (below)
   		Context context = getApplicationContext();
   		
   		CharSequence text;
   		
   		switch(v.getId()) {
   		case R.id.Difficulty_Level_1: text = "Level Easy Selected!"; break;
   		//case R.id.Difficulty_Level_2: text = "Level Medium Selected!"; break;
   		case R.id.Difficulty_Level_3: text = "Level Hard Selected!"; break;
   		default: text="Dunno what was pushed!";
   		}
   		
   		// show a Toast for a short amount of time, displaying
   		// which button was pushed.
   		int duration = Toast.LENGTH_SHORT;
   		Toast toast = Toast.makeText(context, text, duration);
   		toast.show();
			
		}
	};
	
	
	// Switch to another activity
	public void ImageBreakdown(View v) {
		Intent i = new Intent(this, ImageBreakdown.class);
		startActivity(i);
	}
}
