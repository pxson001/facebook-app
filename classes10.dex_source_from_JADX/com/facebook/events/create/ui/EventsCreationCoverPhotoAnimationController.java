package com.facebook.events.create.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

/* compiled from: composer_trigger_banner_pointer_location */
public class EventsCreationCoverPhotoAnimationController {
    public static int f16383h;
    public static int f16384i;
    public static int f16385j;
    public Context f16386a;
    private CoverPhotoSelector f16387b;
    public LinearLayout f16388c;
    private FrameLayout f16389d;
    private ValueAnimator f16390e;
    private ObjectAnimator f16391f;
    private int f16392g;

    public EventsCreationCoverPhotoAnimationController(Context context, CoverPhotoSelector coverPhotoSelector, LinearLayout linearLayout, FrameLayout frameLayout, int i) {
        this.f16386a = context;
        this.f16387b = coverPhotoSelector;
        this.f16388c = linearLayout;
        this.f16389d = frameLayout;
        this.f16392g = i;
        Resources resources = this.f16386a.getResources();
        f16384i = resources.getDimensionPixelSize(2131431098);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431105) + ((int) (((double) resources.getDisplayMetrics().widthPixels) / 1.78d));
        f16385j = dimensionPixelSize;
        f16383h = dimensionPixelSize - f16384i;
    }

    private ObjectAnimator m16848d() {
        if (this.f16391f == null) {
            this.f16391f = ObjectAnimator.ofFloat(this.f16389d, "y", new float[]{0.0f, (float) f16383h});
            this.f16391f.setDuration((long) this.f16392g);
        }
        return this.f16391f;
    }

    private ValueAnimator m16849e() {
        if (this.f16390e == null) {
            final LayoutParams layoutParams = (LayoutParams) this.f16388c.getLayoutParams();
            this.f16390e = ValueAnimator.ofInt(new int[]{f16384i, f16385j});
            this.f16390e.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ EventsCreationCoverPhotoAnimationController f16382b;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.f16382b.f16388c.setLayoutParams(layoutParams);
                }
            });
            this.f16390e.setDuration((long) this.f16392g);
        }
        return this.f16390e;
    }

    public final void m16850a() {
        this.f16387b.m16791a(false, this.f16392g);
        m16848d().start();
        m16849e().start();
    }

    public final void m16852b() {
        this.f16387b.m16791a(true, this.f16392g);
        m16848d().reverse();
        m16849e().reverse();
    }

    public final void m16851a(boolean z) {
        ((MarginLayoutParams) this.f16388c.getLayoutParams()).topMargin = z ? f16385j : f16384i;
    }

    public final void m16853b(boolean z) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f16389d.getLayoutParams();
        if (z) {
            marginLayoutParams.topMargin = f16383h;
        } else {
            marginLayoutParams.topMargin = 0;
        }
    }
}
