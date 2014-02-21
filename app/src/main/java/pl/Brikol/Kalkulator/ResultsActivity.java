package pl.Brikol.Kalkulator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.lang.Enum.*;
import java.util.concurrent.TimeUnit;

public class ResultsActivity extends Activity {

    TextView product, model;
    EditText Prod, tPerH;
    float productivity, powerCons, parts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        product = (TextView) findViewById(R.id.textView);
        model = (TextView) findViewById(R.id.textView2);
        Prod = (EditText) findViewById(R.id.editText);
        tPerH = (EditText) findViewById(R.id.editText2);

        Bundle dane = getIntent().getExtras();
        String[] data = dane.getStringArray("dane");
        Init(data[0]);
        model.setText(data[0]);
       //edit.setText(String.valueOf(productivity));
        //edit.setText(Float.toString(productivity),TextView.BufferType.EDITABLE);
        Double z = new BigDecimal(1000/productivity).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String.valueOf(z);
        Prod.setText(String.valueOf(productivity));
        //tPerH.setText(tonPerHour(productivity));
        tPerH.setText(tonPerHour(productivity));
    }

    public void Init(String data){
        double power = 0.86;
        switch(data){
            case "ZSJ25":
                productivity = 200;
                powerCons = 17*(float)power;
                break;
            case "ZSJ28":
                productivity = 220;
                powerCons = 24*(float)power;
                break;
            case "ZSJ30":
                productivity = 350;
                powerCons = 32*(float)power;
                break;
            case "ZSJ50":
                productivity = 400;
                powerCons = 34*(float)power;
                break;
            case "ZSJ70":
                productivity = 700;
                powerCons = 65*(float)power;
                break;
            default:
                productivity = 0;
                powerCons = 0;
        }
    }
    public String tonPerHour(float prod){
        float ton = 1000;
        prod = prod/3600;
        int s = 0;

        while(ton >= 0){
            s++;
            ton -= prod;
        }
        return String.format("%02d:%02d",TimeUnit.SECONDS.toHours(s),TimeUnit.SECONDS.toMinutes(TimeUnit.SECONDS.toSeconds(s) - TimeUnit.SECONDS.toHours(s)*3600));
    }
} //2 + 44