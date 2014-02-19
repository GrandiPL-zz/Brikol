package pl.Brikol.Kalkulator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
    String selected;
    Spinner Machines, Materials;
    ImageView MachineImg;
    Button Send, Clear;
    EditText Electro;
    ArrayAdapter<CharSequence> machineTypes, materialType;
    Context context;
    Toast Empty;
    Intent Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Send = (Button) findViewById(R.id.sendBt);
        Clear = (Button) findViewById(R.id.clearBt);
        Machines = (Spinner) findViewById(R.id.spinner);
        Materials = (Spinner) findViewById(R.id.spinner2);
        MachineImg = (ImageView) findViewById(R.id.imageView);
        Electro = (EditText) findViewById(R.id.editText);
        machineTypes = ArrayAdapter.createFromResource(this,R.array.machines,android.R.layout.simple_spinner_item);
        materialType = ArrayAdapter.createFromResource(this, R.array.materials,android.R.layout.simple_spinner_item);
        context = getApplicationContext();

        materialType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        machineTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Machines.setAdapter(machineTypes);
        Materials.setAdapter(materialType);
        Materials.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                notEmpty();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Machines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = Machines.getSelectedItem().toString();
                notEmpty();
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
        Send.setOnClickListener(this);

        Clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Machines.setSelection(0);
                Materials.setSelection(0);
                Electro.setText("");
            }
        });

        Electro.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                notEmpty();
                return false;
            }
        });
    }
  /*  @Override
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
 */
    /** Edited slash*/public boolean notEmpty(){
        if(Machines.getSelectedItem().toString().length() != 0 && Materials.getSelectedItem().toString().length() != 0 && Electro.getText().toString().length() != 0){
            Send.setEnabled(true);
            return true;
        }else{
           // Send.setEnabled(false);
            return false;
        }
    }

    public void onClick(View view) {
        if(notEmpty()){
            //float[] onLoadData = {(float)Machines.getSelectedItemId(), (float)Materials.getSelectedItemId(),Electro.getAlpha()};
             String[] dane = {Machines.getSelectedItem().toString(),Materials.getSelectedItem().toString(), Electro.getText().toString()};
             Data = new Intent(this,ResultsActivity.class);
             Data.putExtra("dane",dane);
             //Data.putExtra("Count","");
            startActivity(Data);
        }else{
            Empty.makeText(context,"Proszę wypełnić wszystkie pola.",30).show();
        }
    }
}