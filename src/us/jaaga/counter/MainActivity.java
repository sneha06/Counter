package us.jaaga.counter;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	public static int count = 0;
	public static String a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Timer timer = new Timer();
		final Button button = (Button) findViewById(R.id.Tapme);
		final TextView result = (TextView) findViewById(R.id.result);
		Button reset = (Button) findViewById(R.id.Reset);

		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count = 0;
				a = Integer.toString(count);
				result.setText(a);
				
			}
		});

		a = Integer.toString(count);
		result.setText(a);

		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				count++;

				a = Integer.toString(count);
				result.setText(a);
			}
		});

		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// button.setClickable(false);

				Intent intent = new Intent(getApplicationContext(),
						NewActivity.class);
				intent.putExtra("score", a);
				startActivity(intent);

			}
		}, 15 * 1000);
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

}
