package info.lolbigdata.masterdetaildemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ItemsListFragment extends Fragment {

    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;
    private OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener {
        public void onItemSelected(Item item);
    }
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener){
            listener = (OnListItemSelectedListener)activity;
        }else{
            throw new ClassCastException(activity.toString()
            + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ArrayList<Item> items = Item.getItems();

        adapterItems = new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);


        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = adapterItems.getItem(position);
                listener.onItemSelected(item);
            }
        });


        lvItems = (ListView)view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);

        return view;

    }



}
