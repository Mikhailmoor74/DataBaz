package baza.arerere.bazadatabaza;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BazaAdapter extends RecyclerView.Adapter<BazaAdapter.BazaViewHolder> {

    ArrayList<BazaItem> bazaItems;
    Context context;
    private DatabaseReference mDatabase;

    public BazaAdapter(ArrayList<BazaItem> bazaItems, Context context) {
        this.bazaItems = bazaItems;
        this.context = context;
    }

    @NonNull
    @Override
    public BazaAdapter.BazaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_result,
                parent, false);
        BazaViewHolder bazaViewHolder = new BazaViewHolder(view);
        return bazaViewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull final BazaAdapter.BazaViewHolder holder, int position) {
        BazaItem bazaItem = bazaItems.get(position);
        holder.bazaImageView.setImageResource(bazaItem.getImageResource());
        /*holder.title.setText(bazaItem.getTitle());*/
        holder.price.setText(bazaItem.getPrice());
        holder.distance.setText(bazaItem.getDistance());
        holder.lake.setText(bazaItem.getLake());



        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                BazaItem bazaItem = dataSnapshot.getValue(BazaItem.class);
                /*((TextView)findViewById(R.id.title)).setText(bazaItem.getTitle());*/

                holder.title.setText(bazaItem.getTitle());
                holder.lake.setText(bazaItem.getLake());
                holder.distance.setText(bazaItem.getDistance());
                holder.price.setText(bazaItem.getDescription());


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("failed update", "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public int getItemCount() {
        return bazaItems.size();
    }

    public class BazaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView bazaImageView;
        public TextView title;
        public TextView description;
        public TextView price;
        public TextView distance;
        public TextView lake;

        public BazaViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            bazaImageView = itemView.findViewById(R.id.bazaImageView);
            title = itemView.findViewById(R.id.titleTextView);
            description = itemView.findViewById(R.id.descriptionTextView);
            price = itemView.findViewById(R.id.priceTextView);
            distance = itemView.findViewById(R.id.distanceTextView);
            lake = itemView.findViewById(R.id.lakeTextView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            BazaItem bazaItem = bazaItems.get(position);

            Intent intent = new Intent(context, MainBazaCard.class);
            intent.putExtra("imageRecourse", bazaItem.getImageResource());
            intent.putExtra("title", bazaItem.getTitle());
            intent.putExtra("description", bazaItem.getDescription());
            intent.putExtra("price", bazaItem.getPrice());
            intent.putExtra("distance", bazaItem.getDistance());
            intent.putExtra("lake", bazaItem.getLake());
            context.startActivity(intent);
        }
    }
}
