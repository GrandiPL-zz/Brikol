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

public class ResultsActivity extends Activity {

    TextView test;
    EditText test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        test = (TextView) findViewById(R.id.textView2);
        Bundle dane = getIntent().getExtras();
        String[] mystrings = dane.getStringArray("dane");
        test.setText(String.valueOf(Integer.parseInt(mystrings[2])*2));
    }
}
