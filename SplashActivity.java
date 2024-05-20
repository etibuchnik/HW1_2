package com.example.hw_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private LottieAnimationView lottie_LOTTIE_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViews();
        lottie_LOTTIE_animation.resumeAnimation();
        lottie_LOTTIE_animation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {

                TransactToMainActivity();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });
    }

    private void findViews() {
        lottie_LOTTIE_animation = findViewById(R.id.lottie_LOTTIE_animation);
    }

    private void TransactToMainActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}