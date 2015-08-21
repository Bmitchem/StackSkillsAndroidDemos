package info.lolbigdata.intentservicewithnetwork;

import android.app.IntentService;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NetworkDownload extends IntentService {
    String url;
    String content;

    public NetworkDownload() {
        super("NetworkDownload");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        url = intent.getExtras().getString("url");
        content = getHTML(url);
        Intent passBack = new Intent(NetworkDownload.this, MainActivity.class);
        passBack.putExtra("content", content);
        startActivity(intent);


    }
    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }


}
