package com.example.android.qrcodereader;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.android.qrcodereader.R.id.textViewCollege;

public class ReaderActivity extends AppCompatActivity {
private Button scanbutn;
    private TextView textViewName, textViewCollege,textViewBranch,textViewYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        scanbutn =(Button) findViewById(R.id.scanbutn);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewCollege = (TextView) findViewById(R.id.textViewCollege);
        textViewBranch = (TextView) findViewById(R.id.textViewBranch);
        textViewYear = (TextView) findViewById(R.id.textViewYear);
        final Activity activity=this;
        scanbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You cancelled scanning", Toast.LENGTH_LONG).show();
            } else {
                // Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG).show();
                try {

                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    textViewName.setText(obj.getString("name"));
                    textViewCollege.setText(obj.getString("college"));
                    textViewBranch.setText(obj.getString("branch"));
                    textViewYear.setText(obj.getString("year"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

