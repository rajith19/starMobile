package com.example.starmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ProductsDetailActivity extends AppCompatActivity {

    TextView mobileName;
    private Query query;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.products_detail_activity);

        Intent i = getIntent();
        String key_get = i.getStringExtra("key_send");

        query = FirebaseDatabase.getInstance().getReference().child("Mobile").child(key_get);

        Log.i("key_get", "" + key_get + query);

         mobileName = findViewById(R.id.mobileName);
        mobileName.setText("Hello");

    }
}
