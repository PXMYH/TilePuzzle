package com.px.tilepuzzle;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.GridView;


public class GamePlayEasy extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.board_display_easy);
        
        // find the image to crop
/*        Field[] grid_adapter_gallery = R.drawable.class.getFields();
        grid_adapter_gallery[0].getName().startsWith("puzzle_001");
        int logo_id = R.drawable.puzzle_001;
        Resources logo_context = getResources();*/
        
        // level easy: crop the image into 3*3 grid 
/*        Bitmap logo_orig = BitmapFactory.decodeResource(logo_context, logo_id);
        int crop_width  = getResources().getDisplayMetrics().widthPixels;
        int crop_height = getResources().getDisplayMetrics().heightPixels;
        Bitmap.createBitmap(logo_orig, 0, 0, crop_width, crop_height);*/
        
        GridView board = (GridView) findViewById(R.id.board_display_easy_grid);
        //board.setAdapter(new GridImageAdapter (this));
        
        
        
	}
	

}