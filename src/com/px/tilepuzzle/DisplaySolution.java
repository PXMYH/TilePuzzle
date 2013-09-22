package com.px.tilepuzzle;

import java.io.ByteArrayOutputStream;


import com.px.tilepuzzle.GridImageAdapter;
import com.px.tilepuzzle.R;
import com.px.tilepuzzle.R.id;
import com.px.tilepuzzle.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

/* DisplaySolution.java
 * A new activity that accepts, via the Intent bundle,
 * an ID representing the image to display full-screen
 * to the user.*/
 
public class DisplaySolution extends Activity implements OnClickListener{
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_display);
        
        // retrieve the set of data passed to us by the Intent
        Bundle extras = getIntent().getExtras();

        // retrieve the ubc logo ID from the extras bundle
        int logo_id = (int)extras.getLong("ubc_logo");
        Log.d("Display Solution", "received value:" + Integer.toString(logo_id));
        
        // Create a square bitmap image based on non-square logo retrieved
        Bitmap logo_orig = BitmapFactory.decodeResource(this.getResources(), logo_id);
        
        // Get the background color of the bitmap image
        int logo_height = logo_orig.getHeight();
        int logo_bg_color = logo_orig.getPixel(0, logo_orig.getHeight()-1);
        
        // Scale the image while preserving the aspect ratio
        int screenWidth  = this.getResources().getDisplayMetrics().widthPixels;
        int screenHeight = this.getResources().getDisplayMetrics().heightPixels;
        final int screen_Ratio = screenWidth / logo_orig.getHeight();
        
        Bitmap logo_scale = Bitmap.createScaledBitmap(logo_orig,screen_Ratio*logo_orig.getWidth(),screenWidth,true);
        
        Canvas logo_canvas;
        Bitmap logo_background;
        Paint logo_bg_paint = new Paint();
        
        if (logo_orig.getHeight() > logo_orig.getWidth()) {
        	logo_background = Bitmap.createBitmap(screenWidth, screenWidth, Bitmap.Config.ARGB_8888);
        	logo_canvas = new Canvas (logo_background);
/*        	float trans_y_canvas =  (screenHeight - screenWidth) / 2;
        	float trans_x_canvas =  0;
        	logo_canvas.translate(trans_x_canvas, trans_y_canvas);*/
        	logo_canvas.drawColor(logo_bg_color);   
        	int logo_pos_width = screenWidth/2 - screen_Ratio*logo_orig.getWidth()/2;
        	//int logo_pos_height= screenHeight/2 - screenWidth/2;
        	//logo_canvas.drawBitmap(logo_scale, logo_pos_width, logo_pos_height, logo_bg_paint);
        	logo_canvas.drawBitmap(logo_scale, logo_pos_width, 0, logo_bg_paint);
        } else {
        	logo_background = Bitmap.createBitmap(screenHeight, screenHeight, Bitmap.Config.ARGB_8888);
        	logo_canvas = new Canvas (logo_background);
        	logo_canvas.drawColor(Color.GREEN); 
        	logo_canvas.drawBitmap(logo_scale, 0, screenWidth/4, logo_bg_paint);       	
        }
        
        logo_canvas.setBitmap(null);        
        
        // Crop logo into 16 pieces
        //Bitmap tile = Bitmap.createBitmap(logo_square, 0, 0, 100, 100);
        //background.recycle();
        //image.setImageBitmap(tile);

        //GridView board = (GridView) findViewById(R.id.board_display_grid);
        //board.setAdapter(new GridImageAdapter (this));

        // find our ImageView in the layout
        ImageView image = (ImageView)findViewById(R.id.solution_display);
        image.setImageBitmap(logo_background);
        
        // set the ImageView to display the specified resource ID
        //image.setImageResource(resource);

        // close the Activity when a user taps/clicks on the image.
        image.setOnClickListener(this);
	}
	
    public void onClick(View v) {
    	
    	// ** Passing bitmap image method #1:
    	// * recreate bitmap and direct passing
    	 v.setDrawingCacheEnabled(true);        
         v.buildDrawingCache(true);
         Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache()); // creates immutable clone 
    	 v.setDrawingCacheEnabled(false); // clear drawing cache
    	 ByteArrayOutputStream stream = new ByteArrayOutputStream();
    	 bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
    	 byte[] bmp_bytes = stream.toByteArray(); 
    	 Intent play = new Intent(this, GamePlayMedium.class); 
    	 play.putExtra("bitmap_scaled", bmp_bytes);
    	 startActivity(play);
    	
    	// ** Passing bitmap image method #2:
    	// * code image to byteArray and decode from the other side
//		Intent play = new Intent(this, GamePlayMedium.class); 
//		//play.putExtra("bitmap_scaled", this.image.toByteArray());
//		Log.d("Display Solution", "passed Value:" + Integer.toString(v.getId()));
//    	startActivity(play);
    }
    
}
