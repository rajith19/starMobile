package com.example.starmobile;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MobileAdapter extends FirebaseRecyclerAdapter<Mobile, MobileAdapter.MobileHolder> {


public MobileAdapter(FirebaseRecyclerOptions<Mobile> options){
    super(options);
}

    @NonNull
    public MobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
     return new MobileHolder(layoutInflater, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull MobileAdapter.MobileHolder holder, int position, Mobile model) {

        StorageReference storeRef = FirebaseStorage.getInstance().getReferenceFromUrl(model.getImage());
        holder.txtName.setText(model.getName());
        Glide.with(holder.imgMobile.getContext()).load(storeRef).into(holder.imgMobile);
        holder.brand.setText(model.getBrand());
        holder.rating.setRating(model.getRating());
        holder.price.setText(model.getPrice());
        holder.orderLeft.setText(model.getOrderLeft().toString());

//        if(model.getOrderLeft().toString() == 0){
//            holder.hideOrderLeft =
//        }
    }

    class MobileHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName;
        ImageView imgMobile;
        TextView brand;
        RatingBar rating;
        TextView price;
        TextView orderLeft;
        LinearLayout hideOrderLeft;

        public MobileHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));
            txtName = itemView.findViewById(R.id.txtName);
            imgMobile = itemView.findViewById(R.id.imgMobile);
            brand = itemView.findViewById(R.id.brand);
            rating = itemView.findViewById(R.id.ratingBar);
            price = itemView.findViewById(R.id.price);
            orderLeft = itemView.findViewById(R.id.orderLeft);
            hideOrderLeft = itemView.findViewById(R.id.hideOrderLeft);
itemView.setOnClickListener(this);

            Log.i("orderLeft", "" + orderLeft + " " + orderLeft.getText().toString());
        }

        @Override
        public void onClick(View v) {
        String Key_send = getSnapshots().getSnapshot(getAdapterPosition()).getKey();
            Intent i = new Intent(v.getContext(), ProductsDetailActivity.class);
            i.putExtra("key_send",Key_send );
            v.getContext().startActivity(i);

        }
    }
}
