package info.lolbigdata.masterdetaildemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bmitchem on 7/19/15.
 */
public class ItemDetailFragment extends Fragment {

    private Item item;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        item = (Item) getArguments().getSerializable("item");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_item_detail,
                container, false);
        return view;
    }
    public static ItemDetailFragment newInstance(Item item){
        ItemDetailFragment fragmentDemo = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}
