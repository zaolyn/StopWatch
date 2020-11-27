package com.example.stopwatchmantul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnStart, btnStop, btnReset;
    ImageView icanchor;
    Animation roundingalone, resetrounding, stoprounding ;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnstart);
        btnReset = findViewById(R.id.btnreset);
        btnStop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        btnReset.setAlpha(0);

        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);
        resetrounding = AnimationUtils.loadAnimation(this, R.anim.resetrounding);
        stoprounding = AnimationUtils.loadAnimation(this, R.anim.stoprounding);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundingalone);
                btnReset.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.clearAnimation();
                btnReset.animate().alpha(0).setDuration(300).start();
                btnStart.animate().alpha(1).translationY(-80).setDuration(300).start();
                timerHere.stop();

            }
        });

//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                icanchor.clearAnimation();
//                timerHere.stop();
//            }
//        });
    }
}
