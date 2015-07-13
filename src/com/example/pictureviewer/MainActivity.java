package com.example.pictureviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private EditText mUrlEditText = null;
	private Button mScanButton = null;
	private ImageView mImageView = null;
	private ImageButton mImageButton = null;
	private String mUrl = null;
	private int[] picIds = new int[] { R.drawable.p1, R.drawable.p2,
			R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6,
			R.drawable.p7, R.drawable.p8, R.drawable.p9 };
	private int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mUrlEditText = (EditText) findViewById(R.id.editText);
		mUrl = mUrlEditText.getText().toString();
		mScanButton = (Button) findViewById(R.id.button);
		mImageView = (ImageView) findViewById(R.id.imageView);
		mImageButton = (ImageButton) findViewById(R.id.nextButton);
		mImageButton.setOnClickListener(this);

	}

	private boolean first = true;

	public void onClick(View v) {
		mImageView.setImageResource(picIds[count % picIds.length]);
		if (count == 0 && first) {
			first = false;
			Toast.makeText(this, "温馨提示: 您正在观看的是第一张图片", Toast.LENGTH_SHORT)
					.show();
		}
		count = (count + 1) % picIds.length;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
