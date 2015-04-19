package com.example.aadebuger.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Handler;
import java.util.Date;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ImageView mQrView;

     int count =0;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
         /*
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
*/
         //   timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            System.out.println( new Date());
            timerHandler.postDelayed(this, 6000);
            displayQr();
        }
    };


    void displayQr()
    {
        if ( count%4==0)
            mQrView.setImageDrawable(getResources().getDrawable(R.drawable.qr1));
        if ( count%4==1)
            mQrView.setImageDrawable(getResources().getDrawable(R.drawable.qr2));
        if ( count%4==2)
            mQrView.setImageDrawable(getResources().getDrawable(R.drawable.qr3));
        if ( count%4==3)
            mQrView.setImageDrawable(getResources().getDrawable(R.drawable.qr4));

        count++;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQrView =  (ImageView) findViewById(R.id.imageView);
        System.out.println("mQrView="+ mQrView);
        timerHandler.post(timerRunnable);
        // Find the root view
        /*
        View root = mQrView.getRootView();

        // Set the color
        root.setBackgroundColor(getResources().getColor(android.R.color.white));
        */
        mQrView.setImageDrawable(getResources().getDrawable(R.drawable.qr4));
        count ++;

    //    final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

         }

}
