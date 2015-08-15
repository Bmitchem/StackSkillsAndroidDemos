package info.lolbigdata.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    public EditText numbersList;
    public Intent averageIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numbersList = (EditText) findViewById(R.id.TextInputField);
    }

    public void startService(View v){
        String[] numbersRaw = numbersList.getText().toString().split(" ");
        int[] numbers = new int[numbersRaw.length];
        for(int i = 0; i < numbersRaw.length; i++){
            numbers[i] = Integer.parseInt(numbersRaw[i]);

        }
        averageIntent = new Intent(MainActivity.this, AverageService.class);
        averageIntent.putExtra("numbers", numbers);
        startService(averageIntent);

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

    public void stopService(View v){
        stopService(averageIntent);
    }
}
