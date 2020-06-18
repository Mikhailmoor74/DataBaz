package baza.arerere.bazadatabaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_search_result);

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;

        ArrayList<BazaItem> bazaItems = new ArrayList<>();


        bazaItems.add(new BazaItem(R.drawable.ic_launcher_background, Utils.BAZA_1_TTILE, Utils.BAZA_1_LAKE, Utils.BAZA_1_DISTANCE,
                Utils.BAZA_1_PRICE, Utils.BAZA_1_DESCRIPTION));





        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new BazaAdapter(bazaItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


    }
}
