package info.lolbigdata.popularmovies;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieGrid extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        String popular_movies;

        popular_movies = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=584990f2625eaa71797fd404c0b088a2";
        String response = getHTML(popular_movies);
        try {
            JSONObject mainObject = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        setContentView(R.layout.activity_movie_grid);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_grid, menu);
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


    public void getJson(String selection, String url){
        new LoadJsonTask().execute(selection, url);
    }
    private class LoadJsonTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>> >{
        ProgressDialog dialog;
        protected void onPreExecute(){
            dialog = ProgressDialog.show(MovieGrid.this, "title", "message");
        }
        protected ArrayList<HashMap<String, String>> doInBackground(String... params){
            return doGetJson(params[0],params[1]);
        }
        protected void onPostExecute(ArrayList<HashMap<String, String>> mylist){
            ListAdapter adapter = new JsonAdapter(MovieGrid.this, mylist, R.layout.list. new String[] { "name", "text", "ts"}, new int[]{ R.id.item_title,
                    R.id.item_subtitle, R.id.timestamp});
        }
    }
}
