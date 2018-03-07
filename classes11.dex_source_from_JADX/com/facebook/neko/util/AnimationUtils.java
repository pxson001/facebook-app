package com.facebook.neko.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: topDrawerSlide */
public class AnimationUtils {

    /* compiled from: topDrawerSlide */
    final class C01081 extends AnimatorListenerAdapter {
        final /* synthetic */ View f819a;
        final /* synthetic */ int f820b;

        C01081(View view, int i) {
            this.f819a = view;
            this.f820b = i;
        }

        public final void onAnimationEnd(Animator animator) {
            this.f819a.setVisibility(this.f820b);
        }
    }

    public static void m1114a(View view, View view2, int i) {
        view2.setAlpha(0.0f);
        view2.setVisibility(0);
        view2.animate().alpha(1.0f).setDuration(400).setListener(null);
        view.animate().alpha(0.0f).setDuration(400).setListener(new C01081(view, i));
    }
}
