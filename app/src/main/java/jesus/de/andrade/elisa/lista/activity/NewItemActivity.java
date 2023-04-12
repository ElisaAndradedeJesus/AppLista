package jesus.de.andrade.elisa.lista.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import jesus.de.andrade.elisa.lista.R;

public class NewItemActivity extends AppCompatActivity {
    // some attributes (～￣▽￣)～
    static  int PHOTO_PICKER_REQUEST = 1;
    Uri photoSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);


        //Adding code ↓ ~(￣▽￣~)
        ImageButton imgCI = findViewById(R.id.imbCI);
        imgCI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent,PHOTO_PICKER_REQUEST);
            }// end

        });// end imgCI listener ♪(´▽｀)

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == PHOTO_PICKER_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                photoSelected = data.getData();
                ImageView imvFotoPreview = findViewById(R.id.imvPhotoPreview);
                imvFotoPreview.setImageURI(photoSelected);
            }
        }
    }
}