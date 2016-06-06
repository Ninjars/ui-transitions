package net.jeremystevens.jez.uiinteraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CardActivity extends AppCompatActivity {

    boolean mTransitioned = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);

        final View image = findViewById(R.id.image);
        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTransitioned) return;
                mTransitioned = true;
                Intent intent = new Intent(CardActivity.this, ExpandedActivity.class);
                String transitionName = getString(R.string.transition_image);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(CardActivity.this, image, transitionName);
                startActivity(intent, options.toBundle());
            }
        };
        View card = findViewById(R.id.card);
        if (card != null) {
            card.setOnClickListener(clickListener);
        }
        View button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(clickListener);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mTransitioned = false;
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        mTransitioned = false;
    }
}
