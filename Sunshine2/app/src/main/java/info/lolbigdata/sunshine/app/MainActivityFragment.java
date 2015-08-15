package info.lolbigdata.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<String> weekForcast = new ArrayList<String>();
        //I'm not a big fan of hardcoding 8 dates but we do what we must

        weekForcast.add("Today - Sunny - 88/63");
        weekForcast.add("Tomorrow - Foggy - 70/46");
        weekForcast.add("Weds - Cloudy - 72/63");
        weekForcast.add("Thurs - Rainy - 64/51");
        weekForcast.add("Fri - Foggy - 70/46");
        weekForcast.add("Sat - Sunny - 76/68");


        ArrayAdapter WeekForcastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forcast,
                R.id.list_item_forcast_textview,
                weekForcast);



        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
