package com.example.iyufrolov.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.Arrays;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by dmitriy on 15.06.16.
 */
public class ScannerView extends FrameLayout implements ZXingScannerView.ResultHandler {
    private ZXingScannerView scannerView;
    public  ScannerListener scannerListener;

    public ScannerView(Context context) {
        super(context);
    }

    public ScannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initViews();
    }

    public void startCamera() {
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    public void setListener(ScannerListener listener) {
        this.scannerListener = listener;
    }

    public void stopCamera() {
        scannerView.stopCamera();
    }

    private void initViews() {
        FrameLayout scannerContainer = (FrameLayout) findViewById(R.id.scanner_container_scanner_view);
        scannerView = new ZXingScannerView(getContext());
        scannerView.setFormats(Arrays.asList(BarcodeFormat.QR_CODE));
        scannerView.setAutoFocus(true);
        scannerContainer.addView(scannerView);
    }

    @Override
    public void handleResult(Result rawResult) {
        if (rawResult.getText() != null) {
            scannerListener.scannerResult(rawResult);
        }

    }

    public interface ScannerListener {
         void scannerResult(Result result);
    }
}