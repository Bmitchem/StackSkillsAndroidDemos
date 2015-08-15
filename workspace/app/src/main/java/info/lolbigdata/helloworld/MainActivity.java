package info.lolbigdata.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHelloTouch(View v){
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText("Hello, World!");
    }
    public void onGoodbyeTouch(View v){
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText("Cya, later!");
    }
    public void onCustomInputTouch(View v){
        TextView tv = (TextView) findViewById(R.id.textView1);
        EditText et = (EditText) findViewById(R.id.customMessageInput);
        String customMessage = et.getText().toString();
        if(customMessage.equals("Timer")){
            Intent intent = new Intent(MainActivity.this, TimerActivity.class);
            startActivity(intent);
        }else{
            tv.setText(customMessage);
        }

    }

}
