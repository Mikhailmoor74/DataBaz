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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();

        mDatabase = FirebaseDatabase.getInstance().getReference();




        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                BazaItem bazaItem = dataSnapshot.getValue(BazaItem.class);
                ((TextView)findViewById(R.id.title)).setText(bazaItem.getTitle());


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("failed update", "Failed to read value.", error.toException());
            }
        });

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
