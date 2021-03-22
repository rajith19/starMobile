package com.example.starmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class HomeActivity extends AppCompatActivity {

    TextView prime, delivery;
    ImageView imageView1, imageView2, slideImage;
    DatabaseReference reff1, reff2;
    Animation animSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button send_button= (Button)findViewById(R.id.btnID);

        send_button.setOnClickListener(v -> {
            Intent myIntent = new Intent(HomeActivity.this, ProductsActivity.class);
            myIntent.putExtra("Name", "starMobile");
            startActivity(myIntent);

        });

        imageView1= findViewById(R.id.samsung);

        reff1 = FirebaseDatabase.getInstance().getReference().child("Mobile").child("1");
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String image = snapshot.child("image").getValue().toString();
                StorageReference storeRef = FirebaseStorage.getInstance().getReferenceFromUrl(image);

                Glide.with(imageView1.getContext())
                        .load(storeRef)
                        .into(imageView1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        imageView2= findViewById(R.id.apple);
        reff2 = FirebaseDatabase.getInstance().getReference().child("Mobile").child("4");

        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image = snapshot.child("image").getValue().toString();
                StorageReference storeRef = FirebaseStorage.getInstance().getReferenceFromUrl(image);

                Glide.with(imageView2.getContext())
                        .load(storeRef)
                        .into(imageView2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        // Refer the ImageView like this
        slideImage = (ImageView) findViewById(R.id.slideImage);
        // Load the animation like this
        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        // Start the animation like this
        slideImage.startAnimation(animSlide);

        // fade animation
        prime = findViewById(R.id.prime);
        delivery = findViewById(R.id.delivery);
        prime.startAnimation(AnimationUtils.loadAnimation(prime.getContext(), R.anim.fade));
        delivery.startAnimation(AnimationUtils.loadAnimation(delivery.getContext(), R.anim.fade1));


    }
}


