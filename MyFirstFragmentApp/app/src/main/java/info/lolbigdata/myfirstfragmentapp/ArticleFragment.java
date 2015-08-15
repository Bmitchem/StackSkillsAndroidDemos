package info.lolbigdata.myfirstfragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleFragment extends Fragment {

    private ArrayAdapter<String> adapterItems;
    private ListView LvItems;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ArrayList<String> items = new ArrayList<String>();
        for(int i = 0; i < 100; i++){
            items.add("Item " + i);
        }
        adapterItems = new ArrayAdapter<String>(getActivity(),
                android.R.layout.activity_list_item, items);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.article_fragment,
                container, false);

        LvItems = (ListView) view.findViewById(R.id.LvItems);
        LvItems.setAdapter(adapterItems);

        return view;
    }

}
