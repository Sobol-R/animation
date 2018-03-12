package com.example.user.animation.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.user.animation.R;

/**
 * Created by User on 12.03.2018.
 */

public class BanansProgressBar extends FrameLayout {
    ImageView circle1;
    ImageView circle2;
    ImageView circle3;
    public BanansProgressBar(@NonNull Context context) {
        super(context);
        initialize();
    }

    public BanansProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public BanansProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BanansProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {
        View view = inflate(getContext(), R.layout.layout__progress_bar, null);
        addView(view);

        circle1 = findViewById(R.id.circle);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        startAnimation(circle1);
    }
    void startAnimation(final View v) {
        Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.enlarge);
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                View nextView = getNextView(v);
                startAnimation(nextView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(a);
    }
    View getNextView(View v) {
        if (v == circle1) {
            return circle2;
        } else if (v == circle2) {
            return circle3;
        } else if (v == circle3) {
            return circle1;
        }
        return null;
    }
}
