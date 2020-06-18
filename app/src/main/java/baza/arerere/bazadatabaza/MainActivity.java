package baza.arerere.bazadatabaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();


    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Озеро");
        spinnerArrayList.add("Название базы");
        spinnerArrayList.add("Цена");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int number = (int)parent.getItemIdAtPosition(position);

        LinearLayout linearFourth = findViewById(R.id.fourthLine);
        LinearLayout linearThird = findViewById(R.id.thirdLine);

        if (position == 0) {
            linearFourth.setVisibility(View.INVISIBLE);
            linearThird.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            linearFourth.setVisibility(View.INVISIBLE);
            linearThird.setVisibility(View.VISIBLE);
        } else {
            linearFourth.setVisibility(View.VISIBLE);
            linearThird.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Search(View view) {
        Intent intent = new Intent(MainActivity.this, SearchResult.class);
        startActivity(intent);
    }
}
