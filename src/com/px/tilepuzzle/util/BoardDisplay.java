package com.px.tilepuzzle.util;

import java.lang.reflect.Field;

import com.px.tilepuzzle.R;

import android.util.Log;
import android.content.Context;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* BoardDisplay.java
 * This util java script defines customized tile game board style in gridview layout
 */

public class BoardDisplay extends BaseAdapter {
	private Context grid_adapter_context;
	
	
	// Constructor
	public BoardDisplay (Context c) {
		grid_adapter_context = c;
	}
	
	// Get View Method
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(grid_adapter_context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
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
	
    private Integer[] mThumbIds = {
    		R.drawable.puzzle_001,
    		R.drawable.puzzle_002,
    		R.drawable.puzzle_003,
    		R.drawable.puzzle_004,
    		R.drawable.puzzle_005,
    		R.drawable.puzzle_006
    };

}
