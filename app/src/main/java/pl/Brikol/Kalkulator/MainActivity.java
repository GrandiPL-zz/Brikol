package pl.Brikol.Kalkulator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends ActionBarActivity{
    String selected;
    Spinner Machines, Materials;
    ImageView MachineImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Machines = (Spinner) findViewById(R.id.spinner);
        Materials = (Spinner) findViewById(R.id.spinner2);
        MachineImg = (ImageView) findViewById(R.id.imageView);
        ArrayAdapter<CharSequence> machineTypes, materialType;
        machineTypes = ArrayAdapter.createFromResource(this,R.array.machines,android.R.layout.simple_spinner_item);
        materialType = ArrayAdapter.createFromResource(this, R.array.materials,android.R.layout.simple_spinner_item);
        materialType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        machineTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Machines.setAdapter(machineTypes);
        Materials.setAdapter(materialType);

        Machines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = Machines.getSelectedItem().toString();
                switch(selected){
                    case "ZSJ25":
                        MachineImg.setImageResource(R.drawable.zsj25);
                        break;
                    case "ZSJ28":
                        MachineImg.setImageResource(R.drawable.zsj28);
                        break;
                    case "ZSJ30":
                        MachineImg.setImageResource(R.drawable.zsj30);
                        break;
                    case "ZSJ50":
                        MachineImg.setImageResource(R.drawable.zsj50);
                        break;
                    case "ZSJ70":
                        MachineImg.setImageResource(R.drawable.zsj70);
                        break;
                    default:
                        MachineImg.setImageResource(android.R.drawable.screen_background_light_transparent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /*public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            return rootView;
        }
    }*/

}