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

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        };

        ImageView middleView = (ImageView) findViewById(R.id.middle);
        bindImageView(middleView, R.drawable.confused_cat, onClickListener, bottomAnim);

        ImageView leftView = (ImageView) findViewById(R.id.left);
        Animation leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_slide_anim);
        bindImageView(leftView, R.drawable.sad_cat, onClickListener, leftAnim);

        ImageView rightView = (ImageView) findViewById(R.id.right);
        Animation rightAnim = AnimationUtils.loadAnimation(this, R.anim.right_slide_anim);
        bindImageView(rightView, R.drawable.happy_cat, onClickListener, rightAnim);
    }

    private void bindImageView(ImageView view, int resource, View.OnClickListener clickListener, Animation animation) {
        // view may be null, but at least in the short term it's clearer to crash sooner rather than later
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
        RoundedBitmapDrawable image = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        image.setCircular(true);
        view.setImageDrawable(image);
        view.setOnClickListener(clickListener);
        view.startAnimation(animation);
    }
}
