package info.lolbigdata.servicedemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class AverageService extends Service {
    float lastAverage;
    int[] lastNumList;

    @Nullable
    @Override
    public android.os.IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();
        Log.i("AverageService", "Average Service Created");
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("AverageService", "Just doin my thing");
        int[] numArray = intent.getExtras().getIntArray("numbers");
        if(numArray != lastNumList){
            lastNumList = numArray;
            lastAverage = findAverage(numArray);
        }
        Toast.makeText(getApplicationContext(), String.format("Average: %s", lastAverage), Toast.LENGTH_SHORT).show();
        onDestroy();
        return startId;

    }
    public void onDestroy(){
        super.onDestroy();
        Log.i("AverageService", "On destroy called for service");
        Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
    }
    public float findAverage(int[] numArray){
        float average = 0;
        for(int i = 0; i < numArray.length; i++){
            average += numArray[i];
        }
        return (float)(average/numArray.length);
    }

}
