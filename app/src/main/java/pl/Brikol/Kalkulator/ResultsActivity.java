package pl.Brikol.Kalkulator;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class ResultsActivity extends Activity {

    TextView product, model;
    EditText test2;
    float productivity, powerCons, parts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        product = (TextView) findViewById(R.id.textView);
        model = (TextView) findViewById(R.id.textView2);

        Bundle dane = getIntent().getExtras();
        String[] data = dane.getStringArray("dane");
        Init(data[0]);
        model.setText(data[0]);
        //Double z = new BigDecimal(1000/productivity).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //test2.setText(z.toString());
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
        }
    }
}