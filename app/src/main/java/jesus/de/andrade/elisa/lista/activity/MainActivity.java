package jesus.de.andrade.elisa.lista.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import jesus.de.andrade.elisa.lista.R;
import jesus.de.andrade.elisa.lista.model.MyItem;
import jesus.de.andrade.elisa.lista.adapter.MyAdapter;


public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST = 1;
    List<MyItem> itens = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Código que adicionei ↓

        FloatingActionButton fabAddNewItem = findViewById(R.id.fabAddNewItem);
        fabAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class);
                startActivityForResult(i, NEW_ITEM_REQUEST);

            }
        });

    RecyclerView rvItens = findViewById(R.id.rvItens);
    myAdapter = new MyAdapter(this,itens);
    rvItens.setAdapter(myAdapter);

    rvItens.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    rvItens.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(),DividerItemDecoration.VERTICAL);
        rvItens.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == NEW_ITEM_REQUEST){
            if (resultCode == Activity.RESULT_OK){
                MyItem MyItem = new MyItem();
                MyItem.title = data.getStringExtra("title");
                MyItem.description = data.getStringExtra("description");
                MyItem.photo = data.getData();
                itens.add(MyItem);
                myAdapter.notifyItemInserted(itens.size()-1);
            }
        }


    }
}