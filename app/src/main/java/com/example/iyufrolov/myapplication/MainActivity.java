package com.example.iyufrolov.myapplication;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import java.io.File;


public class MainActivity extends AppCompatActivity {


    private final int CAMERA_RESULT = 0;
    private EditText editText;
    private ListView listView;
    private HospitalChartDB hospitalChartDB;
    private Cursor userCursor;
    private SimpleCursorAdapter userAdapter;
    private String[] headers;
    private SurfaceView preview;
    private ScannerView scannerView;

    private Button scan;

    final String TAG = "myLogs";
    File directory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);

        scan = (Button) findViewById(R.id.button2);

        hospitalChartDB = new HospitalChartDB(getApplicationContext());
        // создаем базу данных
        hospitalChartDB.create_db();


        scan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ScannerActivity.class);
                startActivityForResult(intent,1000);
                // TODO Auto-generated method stub
            }
        });
    }

    public void ClickButton(View v) {
//        String[] s = {"Ivan", "Fedor", "Nikolay", "Vladimir"};
        int id = Integer.parseInt(editText.getText().toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item, hospitalChartDB.getPatient(id).getView());

        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            hospitalChartDB.open();
//            listResult.setAdapter(userAdapter);

        } catch (SQLException ex) {
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                // Handle successful scan



            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Log.i("App", "Scan unsuccessful");
            }
        }
    }


}
