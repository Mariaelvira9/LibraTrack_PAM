package mep.mobile.libratrack_pam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        List<Integer> bookCovers = new ArrayList<>();
        // Add your book cover resource IDs here
        bookCovers.add(R.drawable.cover1);
        bookCovers.add(R.drawable.cover2);
        bookCovers.add(R.drawable.cover3);
        bookCovers.add(R.drawable.cover4);
        bookCovers.add(R.drawable.cover5);
        bookCovers.add(R.drawable.cover6);
        bookCovers.add(R.drawable.cover7);
        bookCovers.add(R.drawable.cover8);
        bookCovers.add(R.drawable.cover9);
        bookCovers.add(R.drawable.cover10);
        // Add more book covers...

        adapter = new BookAdapter(bookCovers, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(MainActivity.this, pinjam.class);
            startActivity(intent);
        });
    }
}