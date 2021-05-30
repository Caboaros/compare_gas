package com.example.compare_gas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPriceGas, editPriceEtanol;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPriceGas = findViewById(R.id.price_gas);
        editPriceEtanol = findViewById(R.id.price_etanol);
        textResult = findViewById(R.id.text_result);
    }

    public void compare(View view) {

        String pGas = editPriceGas.getText().toString();
        String pEtanol = editPriceEtanol.getText().toString();

        if(validEntry(pGas, pEtanol)) {
            Double valueGas = Double.parseDouble(pGas);
            Double valueEtanol = Double.parseDouble(pEtanol);

            Double result = valueEtanol / valueGas;

            if (result >= 0.7) {
                textResult.setText("Melhor usar Gasolina.");
            }
            else{
                textResult.setText("Melhor usar Etanol.");
            }
        }
        else{
            textResult.setText("Insira os valores!");
        }
    }

    public Boolean validEntry(String pGas, String pEtanol){
        if (pGas == null || pEtanol == null || pEtanol.equals("") || pGas.equals(""))
            return false;
        else
            return true;
    }
}