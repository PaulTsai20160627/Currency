package currency.home.com.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float ExchangeRate = 30.9f;
    private EditText ntd;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ntd = findViewById(R.id.ntd);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ntd.getText().toString().matches("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage(R.string.please_enter_ntd)
                            .setTitle(R.string.problem)
                            .setPositiveButton("OK",null).show();
                }
                if(ntd.getText().toString().trim().length()>0){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.result)
                            .setMessage(getString(R.string.usd_is)+US_DollarExchange(Integer.parseInt(ntd.getText().toString())))
                            //.setMessage("Your USD is "+ 444)
                            .setPositiveButton("OK",null)
                            .show();
                    ntd.setText("");
                }
            }
        });
    }

    public float US_DollarExchange(int NTD){
        float US_Dollar = NTD / ExchangeRate;
        return US_Dollar;
    }

}
