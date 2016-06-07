package net.jeremystevens.jez.uiinteraction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ExpandedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expanded_layout);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_slide_anim);
        View textContainer = findViewById(R.id.text_container);
        if (textContainer != null) {
            textContainer.startAnimation(bottomAnim);
        }

        ImageView middleView = (ImageView) findViewById(R.id.middle);
        bindImage(middleView, R.drawable.confused_cat);
        middleView.startAnimation(bottomAnim);

        ImageView leftView = (ImageView) findViewById(R.id.left);
        bindImage(leftView, R.drawable.sad_cat);
        Animation leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_slide_anim);
        leftView.startAnimation(leftAnim);

        ImageView rightView = (ImageView) findViewById(R.id.right);
        bindImage(rightView, R.drawable.happy_cat);
        Animation rightAnim = AnimationUtils.loadAnimation(this, R.anim.right_slide_anim);
        rightView.startAnimation(rightAnim);
    }

    private void bindImage(ImageView view, int resource) {
        // view may be null, but at least in the short term it's clearer to crash sooner rather than later
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
        RoundedBitmapDrawable image = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        image.setCircular(true);
        view.setImageDrawable(image);
    }
}
