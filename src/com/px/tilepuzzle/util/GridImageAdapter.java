package com.px.tilepuzzle.util;

import java.lang.reflect.Field;

import com.px.tilepuzzle.R;

import android.util.Log;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* GridImageAdapter.java
 * This util java script defines customized tile game board style in GridView layout
 */

public class GridImageAdapter extends BaseAdapter {
	private Context grid_adapter_context;
	private Integer[] grid_adapter_images;
	private Bitmap[] grid_adapter_cache;
	
	
	// Constructor
	public GridImageAdapter (Context c) {
		grid_adapter_context = c;
		Log.i("board display", "***** checkpoint 1 *****");
		
		Field[] grid_adapter_gallery = R.drawable.class.getFields();
		
		
		// Get the total number of images in R/drawable folder
		int img_length = grid_adapter_gallery.length;
		
		// Get the total number of ubc logo in R/drawable folder
		int img_cnt = 0;
		for (int i = 0; i< img_length; i++) {
			if ( grid_adapter_gallery[i].getName().startsWith("puzzle") )
				img_cnt ++;
		}
		
		// Set up the image array to hold the image information
		// Set up the cache array to pre-size the images so that loading would be faster
		grid_adapter_images = new Integer[img_cnt];
		grid_adapter_cache = new Bitmap[img_cnt];
		
		int grid_img_idx = 0;
		try {
			for(int i=0; i < img_length; i++)
				if(grid_adapter_gallery[i].getName().startsWith("puzzle")) {
					grid_adapter_images[grid_img_idx++] = grid_adapter_gallery[i].getInt(null);
				}
		} catch(Exception e) {}
	}
	
	// Get View Method
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView board_View;
        Log.i("board display", "***** checkpoint 2 *****");
        
        if (convertView == null) { 
        	
        	// if it's not recycled, initialize some attributes
        	board_View = new ImageView(grid_adapter_context);
        	
        	board_View.setLayoutParams(new GridView.LayoutParams(100, 100));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
            Log.i("board display", "***** checkpoint 3 *****");
        } 
        else {
        	board_View = (ImageView) convertView;
            Log.i("board display", "***** checkpoint 4 *****");
        }

		if(grid_adapter_cache[position] == null) {
			Log.i("getView","Checking Cache");
			// create a new Bitmap that stores a resized
			// version of the image we want to display. 
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 1;
			Bitmap thumb = BitmapFactory.decodeResource(grid_adapter_context.getResources(), grid_adapter_images[position], options);
			
			
			// store the resized thumb in a cache so we don't have to re-generate it
			grid_adapter_cache[position] = thumb;
		}
        
		
		
        board_View.setImageBitmap(grid_adapter_cache[position]);
        Log.i("board display", "***** checkpoint 5 *****");
        return board_View;
    }
	
	@Override
    public int getCount() {
        return 0;
    }

	@Override
    public Object getItem(int position) {
        return null;
    }

	@Override
    public long getItemId(int position) {
        return 0;
    }

}
