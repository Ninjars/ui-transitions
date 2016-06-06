package net.jeremystevens.jez.uiinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ExpandedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expanded_layout);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bottom_slide_anim);
        View textContainer = findViewById(R.id.text_container);
        if (textContainer != null) {
            textContainer.startAnimation(animation);
        }
    }
}
