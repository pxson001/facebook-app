package com.facebook.widget.ratingbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;

/* compiled from: com.google.android.gms.maps.internal.IMapFragmentDelegate */
public class AnimatedRatingBar extends BetterRatingBar {

    /* compiled from: com.google.android.gms.maps.internal.IMapFragmentDelegate */
    class Animator implements RatingChangedListener {
        final /* synthetic */ AnimatedRatingBar f19837a;

        public Animator(AnimatedRatingBar animatedRatingBar) {
            this.f19837a = animatedRatingBar;
        }

        public final void mo1342a(int i) {
            if (i > 0) {
                m28553a(this.f19837a.getChildAt(i - 1));
            }
            for (int i2 = i - 2; i2 >= 0; i2--) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f19837a.getContext(), 2130968700);
                loadAnimation.setStartOffset((long) (((i - 1) - i2) * 50));
                this.f19837a.getChildAt(i2).startAnimation(loadAnimation);
            }
        }

        public final void mo1343a(int i, int i2) {
            if (i > 0) {
                m28553a(this.f19837a.getChildAt(i - 1));
            }
            m28554b(this.f19837a.getChildAt(i2 - 1));
        }

        private void m28553a(View view) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f19837a.getContext(), 2130968699);
            view.clearAnimation();
            view.startAnimation(loadAnimation);
        }

        private void m28554b(View view) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f19837a.getContext(), 2130968698);
            view.clearAnimation();
            view.startAnimation(loadAnimation);
        }
    }

    public AnimatedRatingBar(Context context) {
        this(context, null);
    }

    public AnimatedRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClipToPadding(false);
        m28565a(new Animator(this));
    }

    public final void mo1499a() {
        super.mo1499a();
        m28565a(new Animator(this));
    }
}
