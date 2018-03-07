package com.facebook.ui.images.webp;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.view.animation.LinearInterpolator;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: search_results_participants */
public class BitmapAnimationDrawable extends LevelListDrawable implements AnimatableDrawable {
    private final int f5154a;
    private final ValueAnimator f5155b;

    /* compiled from: search_results_participants */
    class C03091 implements AnimatorUpdateListener {
        final /* synthetic */ BitmapAnimationDrawable f5153a;

        C03091(BitmapAnimationDrawable bitmapAnimationDrawable) {
            this.f5153a = bitmapAnimationDrawable;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f5153a.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public BitmapAnimationDrawable(Resources resources, List<Bitmap> list, List<Integer> list2) {
        boolean z;
        Preconditions.checkArgument(list.size() == list2.size(), "There must be the same number of frames as frame durations.");
        if (list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "BitmapAnimationDrawable requires at least one frame");
        addLevel(0, 1, new BitmapDrawable(resources, (Bitmap) list.get(list.size() - 1)));
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += ((Integer) list2.get(i2)).intValue();
            addLevel(0, i, new BitmapDrawable(resources, (Bitmap) list.get(i2)));
        }
        this.f5154a = i;
        this.f5155b = m7884b();
    }

    private ValueAnimator m7884b() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, this.f5154a});
        valueAnimator.setDuration((long) this.f5154a);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(m7885a());
        return valueAnimator;
    }

    public final ValueAnimator m7886a(int i) {
        ValueAnimator b = m7884b();
        b.setRepeatMode(1);
        b.setRepeatCount(Math.max(i / this.f5154a, 1));
        return b;
    }

    public final AnimatorUpdateListener m7885a() {
        return new C03091(this);
    }

    public void start() {
        if (!this.f5155b.isRunning()) {
            this.f5155b.start();
        }
    }

    public void stop() {
        if (this.f5155b.isRunning()) {
            this.f5155b.end();
        }
    }

    public boolean isRunning() {
        return this.f5155b.isRunning();
    }
}
