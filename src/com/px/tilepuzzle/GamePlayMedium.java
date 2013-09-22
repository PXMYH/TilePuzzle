package com.px.tilepuzzle;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;


public class GamePlayMedium extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
		
		// Testing transfer bitmap image between two activities using image view
		// M.H. uncomment to test bitmap passing pipeline 
//		setContentView(R.layout.activity_game_play);
//		byte[] logo_encode = getIntent().getExtras().getByteArray("bitmap_scaled"); 			// receive bitmap from bundle extras
//		Bitmap logo_test = BitmapFactory.decodeByteArray(logo_encode, 0, logo_encode.length); 	// uncompress and decode bitmap resources
//		int tile_width  = logo_test.getWidth()/4;
//		int tile_height = logo_test.getHeight()/4;
//		Bitmap logo_crop = Bitmap.createBitmap(logo_test, tile_width * 1, tile_height * 3, tile_width, tile_height);
//		ImageView test_board = (ImageView) findViewById(R.id.gameplaytestboard);				// find the test board layout
//		test_board.setImageBitmap(logo_test);													// put image into test board layout
//		test_board.setImageBitmap(logo_crop);
        
        // put image to be cropped into gridview adapter
        setContentView(R.layout.board_display_medium);
        byte[] logo_encode = getIntent().getExtras().getByteArray("bitmap_scaled");
        Bitmap logo_play = BitmapFactory.decodeByteArray(logo_encode, 0, logo_encode.length);
        GridView board = (GridView) findViewById(R.id.board_display_medium_grid);
        board.setAdapter(new GridImageAdapter (this, logo_play));
        
        
        //Bundle extras = getIntent().getExtras();
        //Bitmap logo_test = (Bitmap)this.getIntent().getParcelableExtra("bitmap_scaled");
        //Log.d("GamePlayMedium","received value " + Integer.toString(logo_test));
        //int logo_test_id = (int)extras.getParcelable(key)"bitmap_scaled");
        //Log.d("GamePlayMedium", "logo_test_id:" + Float.toString(logo_test_id));
        //Bitmap logo_test = BitmapFactory.decodeResource(this.getResources(), logo_test_id);
        
        
	}
	

}