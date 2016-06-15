package com.example.iyufrolov.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.zxing.Result;

/**
 * Created by dmitriy on 15.06.16.
 */
public class ScannerActivity extends Activity implements ScannerView.ScannerListener {
    private ScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = (ScannerView) LayoutInflater.from(this).inflate(R.layout.scanner_view_layout, null);
        scannerView.setListener(this);
        setContentView(scannerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        scannerView.startCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        scannerView.stopCamera();
    }

    @Override
    public void scannerResult(Result result) {
        //сюда приходит результат сканировния
    }
}
