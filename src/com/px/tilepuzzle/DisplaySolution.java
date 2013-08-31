package com.px.tilepuzzle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

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

        // retrieve the set of data passed to us by the Intent
        Bundle extras = getIntent().getExtras();

        // and retrieve the imageToDisplay ID from the extras bundle
        int resource = (int)extras.getLong("imageToDisplay");

        // set the ImageView to display the specified resource ID
        image.setImageResource(resource);

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
