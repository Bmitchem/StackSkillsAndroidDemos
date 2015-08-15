package info.lolbigdata.listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countries=getResources().getStringArray(R.array.countries);
        this.setListAdapter(new ArrayAdapter<String>(
                this,
                R.layout.list_element,
                R.id.countryName,
                countries));

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String countryName = countries[position];
                Toast.makeText(MainActivity.this,
                        String.format("%s was chosen!", countryName),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


}
