package com.facebook.widget.soundwave;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.internal.IGoogleMapDelegate */
public class SoundWaveView extends CustomLinearLayout {
    public final List<SoundBar> f19872a;
    private boolean f19873b;

    /* compiled from: com.google.android.gms.maps.internal.IGoogleMapDelegate */
    class C14941 extends AnimatorListenerAdapter {
        final /* synthetic */ SoundWaveView f19866a;

        C14941(SoundWaveView soundWaveView) {
            this.f19866a = soundWaveView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (SoundBar soundBar : this.f19866a.f19872a) {
                if (soundBar.f19869c == null) {
                    return;
                }
            }
            for (SoundBar soundBar2 : this.f19866a.f19872a) {
                soundBar2.f19869c.start();
            }
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IGoogleMapDelegate */
    public class SoundBar {
        final /* synthetic */ SoundWaveView f19867a;
        public View f19868b;
        @Nullable
        public AnimatorSet f19869c = null;

        public SoundBar(SoundWaveView soundWaveView, View view) {
            this.f19867a = soundWaveView;
            this.f19868b = view;
        }

        public final View m28586a() {
            return this.f19868b;
        }

        @Nullable
        public final AnimatorSet m28588b() {
            return this.f19869c;
        }

        public final void m28587a(@Nullable AnimatorSet animatorSet) {
            this.f19869c = animatorSet;
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IGoogleMapDelegate */
    public class StepFunctionInterpolator implements Interpolator {
        final /* synthetic */ SoundWaveView f19870a;
        private float f19871b = 0.1f;

        public StepFunctionInterpolator(SoundWaveView soundWaveView, float f) {
            this.f19870a = soundWaveView;
            this.f19871b = f;
        }

        public float getInterpolation(float f) {
            return this.f19871b * ((float) Math.floor((double) (f / this.f19871b)));
        }
    }

    public SoundWaveView(Context context) {
        this(context, null);
    }

    public SoundWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19873b = false;
        setOrientation(0);
        setClipChildren(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SoundWaveView);
        int color = obtainStyledAttributes.getColor(1, getResources().getColor(2131361864));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, getResources().getDimensionPixelSize(2131428276));
        int i = obtainStyledAttributes.getInt(2, 3);
        obtainStyledAttributes.recycle();
        this.f19872a = Lists.a();
        for (int i2 = 0; i2 < i; i2++) {
            int i3;
            View view = new View(context);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            if (i2 < i - 1) {
                i3 = dimensionPixelSize;
            } else {
                i3 = 0;
            }
            layoutParams.rightMargin = i3;
            addView(view, layoutParams);
            this.f19872a.add(new SoundBar(this, view));
        }
        m28592a(new ColorDrawable(color));
        m28593c();
    }

    @TargetApi(16)
    private void m28592a(ColorDrawable colorDrawable) {
        Object obj = VERSION.SDK_INT >= 16 ? 1 : null;
        for (SoundBar soundBar : this.f19872a) {
            if (obj != null) {
                soundBar.f19868b.setBackground(colorDrawable);
            } else {
                soundBar.f19868b.setBackgroundDrawable(colorDrawable);
            }
        }
    }

    private void m28593c() {
        for (SoundBar soundBar : this.f19872a) {
            soundBar.f19869c = m28589a(soundBar.f19868b);
        }
    }

    private AnimatorSet m28589a(View view) {
        Animator a = m28590a(view, 0.1f, 1.0f);
        Animator a2 = m28590a(view, 1.0f, 0.1f);
        Animator a3 = m28590a(view, 0.1f, 0.3f);
        Animator a4 = m28590a(view, 0.3f, 0.1f);
        Animator a5 = m28590a(view, 0.1f, 0.5f);
        Animator a6 = m28590a(view, 0.5f, 0.1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a).before(a2).before(a3).before(a4).before(a5).before(a6);
        animatorSet.addListener(new C14941(this));
        return animatorSet;
    }

    private ValueAnimator m28590a(View view, float f, float f2) {
        long abs = (long) (Math.abs(f - f2) * 100.0f);
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleY", new float[]{2.0f * f, 2.0f * f2});
        abs = ((long) (((double) abs) * Math.random())) + 264;
        ofFloat.setDuration(abs);
        ofFloat.setInterpolator(new StepFunctionInterpolator(this, (float) (33.0d / ((double) abs))));
        return ofFloat;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1233266031);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f19873b) {
            m28594a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 798811573, a);
    }

    public final void m28594a() {
        this.f19873b = true;
        m28593c();
        for (SoundBar soundBar : this.f19872a) {
            View view = soundBar.f19868b;
            view.setScaleY(2.0f);
            view.setTranslationY((float) (getHeight() / 2));
            soundBar.f19869c.start();
        }
    }

    public final void m28595b() {
        this.f19873b = false;
        for (SoundBar soundBar : this.f19872a) {
            AnimatorSet animatorSet = soundBar.f19869c;
            if (animatorSet != null && animatorSet.isRunning()) {
                animatorSet.cancel();
                animatorSet.end();
                animatorSet.removeAllListeners();
                soundBar.f19869c = null;
            }
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2052256192);
        super.onDetachedFromWindow();
        m28595b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1997285270, a);
    }
}
