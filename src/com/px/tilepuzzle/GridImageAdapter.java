package com.px.tilepuzzle;

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
 
public class GridImageAdapter extends BaseAdapter {

	private Integer[] grid_adapter_images;
	private Context grid_adapter_context;
	private Bitmap[] grid_adapter_cache;
	
	private Bitmap grid_adapter_logo;
	private Bitmap[] grid_adapter_tile;
	
	private static int puzzle_row_num    = 4;
	private static int puzzle_column_num = 4;
	
	// Constructor
	public GridImageAdapter(Context c, Bitmap b) {
		grid_adapter_context = c;
		
		// obtain a list of all of the objects in the R.drawable class
//		Field[] grid_adapter_gallery = R.drawable.class.getFields();
		
		
		// Get the total number of images in R/drawable folder
//		int img_length = grid_adapter_gallery.length;
		
		// Get the total number of ubc logo in R/drawable folder
//		int img_cnt = 0;
//		for (int i = 0; i< img_length; i++) {
//			if ( grid_adapter_gallery[i].getName().startsWith("puzzle_") )
//				img_cnt ++;
//		}
		
		// Get the image to be cropped into 16 tiles -- M.H. temporarily, need to get imageID later on
		//int grid_adapter_image_src = R.drawable.puzzle_001;
		// crop the image into 16 tiles
		//grid_adapter_logo = BitmapFactory.decodeResource(grid_adapter_context.getResources(),grid_adapter_image_src);
		grid_adapter_logo = b;
		
		Log.i("GridImageAdapter","checkpoint1");
		
		grid_adapter_tile = getTile(grid_adapter_logo);
		
		Log.i("GridImageAdapter","checkpoint2");
		
		// Set up the image array to hold the image information
		// Set up the cache array to pre-size the images so that loading would be faster
//		grid_adapter_images = new Integer[img_cnt];
//		grid_adapter_cache = new Bitmap[img_cnt];
//		
//		int grid_img_idx = 0;
//		try {
//			for(int i=0; i < img_length; i++)
//				if(grid_adapter_gallery[i].getName().startsWith("puzzle_")) {
//					grid_adapter_images[grid_img_idx++] = grid_adapter_gallery[i].getInt(null);
//				}
//		} catch(Exception e) {}
	}

	@Override
	// the number of items in the adapter
	public int getCount() {
		//return grid_adapter_images.length;
		return 16;
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
		
		ImageView board_View;

		if(convertView == null) {
			board_View = new ImageView(grid_adapter_context);
			board_View.setLayoutParams(new GridView.LayoutParams(184,190));
		} else {
			// recycle an old view (it might have old thumbs in it!)
			board_View = (ImageView) convertView;
		}
		Log.i("GridImageAdapter","checkpoint3");
		// see if we've stored a resized thumb in cache
//		if(grid_adapter_cache[position] == null) {
//		
//			BitmapFactory.Options options = new BitmapFactory.Options();
//			options.inSampleSize = 1;
//			Bitmap thumb = BitmapFactory.decodeResource(grid_adapter_context.getResources(), grid_adapter_images[position], options);
//			//Bitmap thumb = BitmapFactory.decodeResource(grid_adapter_context.getResources(), grid_adapter_tile[position], options);
//			
//			// store the resized thumb in a cache so we don't have to re-generate it
//			grid_adapter_cache[position] = thumb;
//		}

		// use the resized image we have in the cache
		//board_View.setImageBitmap(grid_adapter_cache[position]);
		board_View.setImageBitmap(grid_adapter_tile[position]);
		Log.i("GridImageAdapter","checkpoint4");

		return board_View;
	}
	
	// calculate tile width
	private int getTileWidth (Bitmap logo, int num_column)
	{
		return logo.getWidth()/num_column;
	}
	
	// calculate tile height
	private int getTileHeight (Bitmap logo, int num_row)
	{
		return logo.getHeight()/num_row;
	}
	
	// crop image to tiles
	public Bitmap[] getTile (Bitmap logo)
	{
		// smart way of assigning numbers to tiles
//		for (int tile_id = 0; tile_id <= 15; tile_id++) {
//			grid_adapter_tile[tile_id] = Bitmap.createBitmap(grid_adapter_logo, 0+tile_id*, 0, logo_height/puzzle_row_num, logo_width/puzzle_column_num);
//		}
		
		// dumb way of assigning numbers to tiles
		// 16 tiles
		Bitmap[] tile_list = new Bitmap[16];
		int tile_width  = getTileWidth (logo, puzzle_column_num);
		int tile_height = getTileHeight(logo, puzzle_row_num);
		// row 1
		tile_list[0]  = Bitmap.createBitmap(logo, tile_width * 0, tile_height * 0, tile_width, tile_height);
		tile_list[1]  = Bitmap.createBitmap(logo, tile_width * 1, tile_height * 0, tile_width, tile_height);
		tile_list[2]  = Bitmap.createBitmap(logo, tile_width * 2, tile_height * 0, tile_width, tile_height);
		tile_list[3]  = Bitmap.createBitmap(logo, tile_width * 3, tile_height * 0, tile_width, tile_height);
		// row 2
		tile_list[4]  = Bitmap.createBitmap(logo, tile_width * 0, tile_height * 1, tile_width, tile_height);
		tile_list[5]  = Bitmap.createBitmap(logo, tile_width * 1, tile_height * 1, tile_width, tile_height);
		tile_list[6]  = Bitmap.createBitmap(logo, tile_width * 2, tile_height * 1, tile_width, tile_height);
		tile_list[7]  = Bitmap.createBitmap(logo, tile_width * 3, tile_height * 1, tile_width, tile_height);
		// row 3
		tile_list[8]  = Bitmap.createBitmap(logo, tile_width * 0, tile_height * 2, tile_width, tile_height);
		tile_list[9]  = Bitmap.createBitmap(logo, tile_width * 1, tile_height * 2, tile_width, tile_height);
		tile_list[10] = Bitmap.createBitmap(logo, tile_width * 2, tile_height * 2, tile_width, tile_height);
		tile_list[11] = Bitmap.createBitmap(logo, tile_width * 3, tile_height * 2, tile_width, tile_height);
		// row 4
		tile_list[12] = Bitmap.createBitmap(logo, tile_width * 0, tile_height * 3, tile_width, tile_height);
		tile_list[13] = Bitmap.createBitmap(logo, tile_width * 1, tile_height * 3, tile_width, tile_height);
		tile_list[14] = Bitmap.createBitmap(logo, tile_width * 2, tile_height * 3, tile_width, tile_height);
//		tile_list[15] = Bitmap.createBitmap(logo, tile_width * 3, tile_height * 3, tile_width, tile_height); // most special one -- blank tile
		tile_list[15] = Bitmap.createBitmap(tile_width, tile_height, Bitmap.Config.ARGB_8888);               // create a blank tile
		return tile_list;
	}
}
	
