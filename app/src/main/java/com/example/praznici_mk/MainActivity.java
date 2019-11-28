package com.example.praznici_mk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.praznici_mk.adapter.PrazniciAdapter;
import com.example.praznici_mk.model.PrazniciModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerViewPraznici;

    // Adapter
    private List<PrazniciModel> prazniciModelList  = new ArrayList<>();
    private PrazniciAdapter prazniciAdapter  = new PrazniciAdapter(prazniciModelList);

    // Firebase
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        setComponents();
        
        dbFirebase ();
    }

    private void initComponents() {
        // RecyclerView
        recyclerViewPraznici = findViewById(R.id.recyclerViewMain);
    }

    private void setComponents() {
        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewPraznici.setLayoutManager(layoutManager);
        recyclerViewPraznici.setAdapter(prazniciAdapter);
    }

    // Read data - Firebase -- FireStore
    private void dbFirebase() {
        db.collection("RestDays")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            PrazniciModel prazniciModel = new PrazniciModel();

                            prazniciModel.setDay        (String.valueOf(document.getData().get("day")));
                            prazniciModel.setType       (String.valueOf(document.getData().get("type")));
                            prazniciModel.setYear       (String.valueOf(document.getData().get("year")));
                            prazniciModel.setName       (String.valueOf(document.getData().get("name")));
                            prazniciModel.setDate       (String.valueOf(document.getData().get("date")));
                            prazniciModel.setMonth      (String.valueOf(document.getData().get("month")));
                            prazniciModel.setMonthNumber(String.valueOf(document.getData().get("monthNumber")));

                            prazniciModel.setDocumentID(document.getId());

                            prazniciModelList.add(prazniciModel);
                        }
                        prazniciAdapter.notifyDataSetChanged();
                    }
                });
    }
}
