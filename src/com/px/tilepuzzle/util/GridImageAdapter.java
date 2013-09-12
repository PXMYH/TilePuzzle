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
 * This util java script defines customized tile game board style in GridView layout*/
 

/*public class GridImageAdapter extends BaseAdapter {
  
	private Integer[] grid_adapter_images;
	private Context grid_adapter_context;
	private Bitmap[] grid_adapter_cache;
	
	// Constructor
	public GridImageAdapter(Context c) {
		grid_adapter_context = c;
		
		// obtain a list of all of the objects in the R.drawable class
		Field[] grid_adapter_gallery = R.drawable.class.getFields();
		
		
		// Get the total number of images in R/drawable folder
		int img_length = grid_adapter_gallery.length;
		
		// Get the total number of ubc logo in R/drawable folder
		int img_cnt = 0;
		for (int i = 0; i< img_length; i++) {
			if ( grid_adapter_gallery[i].getName().startsWith("puzzle_") )
				img_cnt ++;
		}
		
		// Set up the image array to hold the image information
		// Set up the cache array to pre-size the images so that loading would be faster
		grid_adapter_images = new Integer[img_cnt];
		grid_adapter_cache = new Bitmap[img_cnt];
		
		int grid_img_idx = 0;
		try {
			for(int i=0; i < img_length; i++)
				if(grid_adapter_gallery[i].getName().startsWith("puzzle_")) {
					grid_adapter_images[grid_img_idx++] = grid_adapter_gallery[i].getInt(null);
				}
		} catch(Exception e) {}
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
	
	// Get View Method
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView board_View;
        Log.i("gridview adapter", "***** checkpoint 2 *****");
        
        if (convertView == null) { 
        	
        	// if it's not recycled, initialize some attributes
        	board_View = new ImageView(grid_adapter_context);
        	
        	board_View.setLayoutParams(new GridView.LayoutParams(100, 100));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
        } 
        else {
        	board_View = (ImageView) convertView;
        }

		if(grid_adapter_cache[position] == null) { 
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 1;
			Bitmap thumb = BitmapFactory.decodeResource(grid_adapter_context.getResources(), grid_adapter_images[position], options);
			
			grid_adapter_cache[position] = thumb;
		}
        
        board_View.setImageBitmap(grid_adapter_cache[position]);
        return board_View;
    }

}*/






import java.lang.reflect.Field;
import com.px.tilepuzzle.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridImageAdapter extends BaseAdapter {

	private Integer[] grid_adapter_images;
	private Context grid_adapter_context;
	private Bitmap[] grid_adapter_cache;

/*	// Constructor
	public GridImageAdapter(Context c) {

		grid_adapter_context = c;

		// obtain a list of all of the objects in the R.drawable class
		Field[] grid_adapter_gallery = R.drawable.class.getFields();

		
		int img_cnt = 0, img_length = grid_adapter_gallery.length;

		for(int i=0; i < img_length; i++)
			if(grid_adapter_gallery[i].getName().startsWith("puzzle_")) 
				img_cnt++;


		grid_adapter_images = new Integer[img_cnt];
		grid_adapter_cache = new Bitmap[img_cnt];

		int grid_img_idx = 0;

		try {
			for(int i=0; i < img_length; i++)
				if(grid_adapter_gallery[i].getName().startsWith("puzzle_"))
					grid_adapter_images[grid_img_idx++] = grid_adapter_gallery[i].getInt(null);
		} catch(Exception e) {}
		// safer: catch IllegalArgumentException & IllegalAccessException

	}*/
	
	
	// Constructor
	public GridImageAdapter(Context c) {
		grid_adapter_context = c;
		
		// obtain a list of all of the objects in the R.drawable class
		Field[] grid_adapter_gallery = R.drawable.class.getFields();
		
		
		// Get the total number of images in R/drawable folder
		int img_length = grid_adapter_gallery.length;
		
		// Get the total number of ubc logo in R/drawable folder
		int img_cnt = 0;
		for (int i = 0; i< img_length; i++) {
			if ( grid_adapter_gallery[i].getName().startsWith("puzzle_") )
				img_cnt ++;
		}
		
		// Set up the image array to hold the image information
		// Set up the cache array to pre-size the images so that loading would be faster
		grid_adapter_images = new Integer[img_cnt];
		grid_adapter_cache = new Bitmap[img_cnt];
		
		int grid_img_idx = 0;
		try {
			for(int i=0; i < img_length; i++)
				if(grid_adapter_gallery[i].getName().startsWith("puzzle_")) {
					grid_adapter_images[grid_img_idx++] = grid_adapter_gallery[i].getInt(null);
				}
		} catch(Exception e) {}
	}

	@Override
	// the number of items in the adapter
	public int getCount() {
		return grid_adapter_images.length;
	}

	////// This is where the Fuxxing problem is!!!!
	// I spent 4 hours to figure out the problem why I can't get gridview displayed!
	// It is neither the order of method to write
	// nor the logic inside getView method
	// It is the tiny detail here that the count method has to return a valid number!!!!
	
	
/*	@Override
    public int getCount() {
        return 1;
    }*/
	
	@Override
	// not implemented, but normally would return 
	// the object at the specified position
	public Object getItem(int position) {
		return null;
	}

	@Override
	// return the resource ID of the item at the current position
	public long getItemId(int position) {
		return grid_adapter_images[position];
	}

/*	@Override
    public long getItemId(int position) {
        return 0;
    }*/
	
	
	// create a new ImageView when requested
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("GridImage", "I am In");
		
		ImageView board_View;

		if(convertView == null) {

			board_View = new ImageView(grid_adapter_context);
			board_View.setLayoutParams(new GridView.LayoutParams(100,100));

		} else {
	
			// recycle an old view (it might have old thumbs in it!)
			board_View = (ImageView) convertView;
	
		}

		// see if we've stored a resized thumb in cache
		if(grid_adapter_cache[position] == null) {
		
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 1;
			Bitmap thumb = BitmapFactory.decodeResource(grid_adapter_context.getResources(), grid_adapter_images[position], options);

			// store the resized thumb in a cache so we don't have to re-generate it
			grid_adapter_cache[position] = thumb;
		}

		// use the resized image we have in the cache
		board_View.setImageBitmap(grid_adapter_cache[position]);

		return board_View;
	}
}
