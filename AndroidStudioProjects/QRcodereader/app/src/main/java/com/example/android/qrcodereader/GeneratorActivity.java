package com.example.android.qrcodereader;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {
     EditText text;
    Button genbutn;
    ImageView image;
    String text2Qr;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        text=(EditText)findViewById(R.id.text);
        genbutn=(Button)findViewById(R.id.genbutn);
        image=(ImageView)findViewById(R.id.image);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        genbutn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                text2Qr=text.getText().toString().trim();
                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch(WriterException e){
                   e.printStackTrace();
                }
                }
        });

    }
}
