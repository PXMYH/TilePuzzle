package com.px.tilepuzzle;


/*import com.px.tilepuzzle.ListImageAdapter;*/
import android.app.Activity;
import android.content.Context;
/*import android.content.Intent;*/
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.Button;


public class ImageSelection extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_selection);
        
        CharSequence toast_msg = "Image is selected";
        showMessage (toast_msg);
		
        // Find the list image view by ID and pass it to customized list image adapter
        // The customized list image adapter is defined in ListImageAdapter.java
        ListView img_list = (ListView)findViewById(R.id.image_list);
        Log.i(getPackageName(), "We are out of listview");
        img_list.setAdapter(new ListImageAdapter(this));
        
        // Set the behavior of difficulty level buttons
        Button diff_button_easy = (Button)findViewById(R.id.Difficulty_Easy);
	}
	
	private void showMessage (CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
	
	
	// Switch to another activity -- Display a full screen picture with breakdown solution image
//	public void ImageBreakdown(View v) {
//		Intent i = new Intent(this, ImageBreakdown.class);
//		startActivity(i);
//	}
	
}
