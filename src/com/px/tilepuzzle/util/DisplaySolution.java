package com.px.tilepuzzle.util;


import com.px.tilepuzzle.R;
import com.px.tilepuzzle.R.id;
import com.px.tilepuzzle.R.layout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;

/* DisplaySolution.java
 * A new activity that accepts, via the Intent bundle,
 * an ID representing the image to display full-screen
 * to the user.
 */

public class DisplaySolution extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.display_solution);

        // find our ImageView in the layout
        ImageView image = (ImageView)findViewById(R.id.display_solution);
        //GridView image = (GridView)findViewById(R.id.display_solution);
        
        // retrieve the set of data passed to us by the Intent
        Bundle extras = getIntent().getExtras();

        // and retrieve the imageToDisplay ID from the extras bundle
        int resource = (int)extras.getLong("imageToDisplay");

        GridView board = (GridView) findViewById(R.id.board_display);
        board.setAdapter(new BoardDisplay(this));
        //Bitmap background = BitmapFactory.decodeResource(this.getResources(), resource);
        //Bitmap tile = Bitmap.createBitmap(background, 0, 0, 100, 100);
        //background.recycle();
        //image.setImageBitmap(tile);
        
        // Scale the image to full screen while preserving the aspect ratio
        //final double scale_ratio = (double) image.getWidth() / (double) background.getWidth();
        //image.setLayoutParams() = (int) (background.getHeight() * scale_ratio);
        
        
        // set the ImageView to display the specified resource ID
        //image.setImageResource(resource);

        // close the Activity when a user taps/clicks on the image.
        image.setOnClickListener(this);
	}
	
	/*
	 * finishes (closes) the activity when the user clicks on the image
	 */
	public void onClick(View v) {
		finish();
	}
}
