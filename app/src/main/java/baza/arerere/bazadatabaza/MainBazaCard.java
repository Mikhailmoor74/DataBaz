package baza.arerere.bazadatabaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainBazaCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_baza_card);

        TextView title = findViewById(R.id.titleTextView);
        TextView description = findViewById(R.id.descriptionTextView);
        TextView distance = findViewById(R.id.distanceTextView);
        TextView price = findViewById(R.id.priceTextView);
        TextView lake = findViewById(R.id.lakeTextView);
        ImageView imageView = findViewById(R.id.imageView);


        Intent intent = getIntent();
        if (intent != null) {
            title.setText(intent.getStringExtra("title"));
            description.setText(intent.getStringExtra("description"));
            distance.setText(intent.getStringExtra("distance"));
            price.setText(intent.getStringExtra("price"));
            lake.setText(intent.getStringExtra("lake"));

        }
    }
}