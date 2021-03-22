package com.example.starmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

public class ListFragment extends Fragment {

RecyclerView rView;
private Query query;
FirebaseRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_fragment, container, false);
        rView = v.findViewById(R.id.recyclerView);

        query = FirebaseDatabase.getInstance().getReference().child("Mobile");

        FirebaseRecyclerOptions<Mobile> options = new FirebaseRecyclerOptions.Builder<Mobile>().setQuery(query, Mobile.class).build();

        adapter = new MobileAdapter(options);

        rView = v.findViewById(R.id.recyclerView);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        return  v;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
}
