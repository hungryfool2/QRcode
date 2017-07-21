package com.example.android.qrcodereader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import static com.example.android.qrcodereader.R.id.genbutn;

public class MainActivity extends AppCompatActivity {
    private Button g;
    private Button g1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g=(Button)findViewById(R.id.gene);
        g.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent inten=new Intent("com.example.android.qrcodereader.GeneratorActivity");
                startActivity(inten);
            }
        });
        g1=(Button)findViewById(R.id.scan);
        g1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent("com.example.android.qrcodereader.ReaderActivity");
                startActivity(intent);
            }
        });
    }
}
