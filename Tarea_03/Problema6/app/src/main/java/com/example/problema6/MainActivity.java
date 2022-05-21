package com.example.problema6;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    Button btnStartProgress;
    ProgressDialog progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartProgress = (Button) findViewById(R.id.btnIniciar);
        addListenerOnButton();
    }

        public void addListenerOnButton () {
            btnStartProgress.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // prepare for a progress bar dialog
                    progressBar = new ProgressDialog(v.getContext());
                    progressBar.setCancelable(true);
                    progressBar.setMessage("File downloading ...");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    Hilo();
                    progressBar.show();
                }
            });
        }

        public void Hilo(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{ while (progressBar.getProgress()<= progressBar.getMax()) {
                        Thread.sleep(200);
                        progressBar.incrementProgressBy(10);
                        if (progressBar.getProgress() ==progressBar.getMax() ){
                            progressBar.dismiss();
                        }
                    }

                    } catch (Exception e){

                    }
                }}).start();

        }


/*
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }*/
    }
