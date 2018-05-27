package com.example.adm1.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final String[] month = getResources().getStringArray(R.array.month);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, month) {
            @Override
            public int getCount() {
                return super.getCount() - 1;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount());

        Button button = findViewById(R.id.OKbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.output);
                Spinner spinner = findViewById(R.id.spinner);
                if (spinner.getSelectedItemId() != spinner.getCount()) {
                    text.setText(spinner.getSelectedItem().toString());
                }
            }
        });

        Button button1 = findViewById(R.id.CancelButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = findViewById(R.id.spinner);
                spinner.setSelection(spinner.getAdapter().getCount());

                TextView text = findViewById(R.id.output);
                text.setText("");
            }
        });
    }
}
