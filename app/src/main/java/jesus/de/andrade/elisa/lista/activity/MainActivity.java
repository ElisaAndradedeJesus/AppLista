package jesus.de.andrade.elisa.lista.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import jesus.de.andrade.elisa.lista.R;

public class MainActivity extends AppCompatActivity {

    static int New_ITEM_REQUEST = 1;

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
                startActivityForResult(i, New_ITEM_REQUEST);

            }
        });


    }
}