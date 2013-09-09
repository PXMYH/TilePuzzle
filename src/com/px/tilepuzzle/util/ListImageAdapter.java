package com.px.tilepuzzle.util;

import java.lang.reflect.Field;

import com.px.tilepuzzle.R;
import com.px.tilepuzzle.R.drawable;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.ListView;


public class ListImageAdapter extends BaseAdapter {
	private Context list_adapter_context;
	private Integer[] list_adapter_images;
	private Bitmap[] list_adapter_cache;
	
	// constructor
	public ListImageAdapter (Context c) {
		// set the list image adapter's context as to what context images are placed into
		list_adapter_context = c;
		
		// Dynamically monitoring the raw folder to extract images placed into the folder information
		Field[] list_adapter_gallery = R.drawable.class.getFields();
		
		int img_cnt = 0;
		int img_length = list_adapter_gallery.length;
		
		// Get the number of logo images in the res/raw folder
		for (int i = 0; i< img_length; i++) 
		{
			if ( list_adapter_gallery[i].getName().startsWith("puzzle") )
				img_cnt ++;
		}
		
		
		// Set up the image array to hold the image information
		// Set up the cache array to pre-size the images so that loading would be faster
		list_adapter_images = new Integer[img_cnt];
		list_adapter_cache = new Bitmap[img_cnt];
		
		int list_img_idx = 0;
		try {
			for(int i=0; i < img_length; i++)
				if(list_adapter_gallery[i].getName().startsWith("puzzle")) {
					list_adapter_images[list_img_idx++] = list_adapter_gallery[i].getInt(null);
				}
		} catch(Exception e) {}
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView list_img_View;
		
		Log.i("ListImageAdapter", "Inside getView method");
		
		// Check existance of  convertable view
		if(convertView == null) {
			// create a new view
			list_img_View = new ImageView(list_adapter_context);
			list_img_View.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.WRAP_CONTENT,ListView.LayoutParams.WRAP_CONTENT));
			Log.i("getView","ConvertView exists");
		} else {
			// recycle an old view (it might have old thumbs in it!)
			list_img_View = (ImageView) convertView;
			Log.i("getView","ConvertView exists");
			
		}
			
		// see if a resized thumbnail is already in cache
		if(list_adapter_cache[position] == null) {
				Log.i("getView","Checking Cache");
				// create a new Bitmap that stores a resized
				// version of the image we want to display. 
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 2;
				Bitmap thumb = BitmapFactory.decodeResource(list_adapter_context.getResources(), list_adapter_images[position], options);
	
				// store the resized thumb in a cache so we don't have to re-generate it
				list_adapter_cache[position] = thumb;
			}
			Log.i("Out of Cache", "loading file from cache");
			list_img_View.setImageBitmap(list_adapter_cache[position]);
	
		return list_img_View;
	}
	
	
	@Override
	public int getCount() {
		return list_adapter_images.length;
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return list_adapter_images[position];
	}
	
}