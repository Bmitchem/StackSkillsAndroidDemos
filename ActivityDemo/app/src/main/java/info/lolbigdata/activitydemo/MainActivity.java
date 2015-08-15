package info.lolbigdata.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    public int timesCalled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.testTextView);
        tv.setText("Activity Main");

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityTwo(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStart(){
        super.onStart();
        String counterText = "Counter is at " + timesCalled;
        Log.i("Counter", counterText);
    }

    public void startActivityTwo(View v){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        startActivity(intent);
        Log.i("Two Activities", "Start Activity two called");
    }
}
