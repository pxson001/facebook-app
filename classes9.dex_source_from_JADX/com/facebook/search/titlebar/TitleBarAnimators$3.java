package com.facebook.search.titlebar;

import android.view.View;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;

/* compiled from: video_frame_height */
class TitleBarAnimators$3 extends SimpleSpringListener {
    final /* synthetic */ float f418a;
    final /* synthetic */ View f419b;
    final /* synthetic */ TitleBarAnimators f420c;

    TitleBarAnimators$3(TitleBarAnimators titleBarAnimators, float f, View view) {
        this.f420c = titleBarAnimators;
        this.f418a = f;
        this.f419b = view;
    }

    public final void m523b(Spring spring) {
        float d = (float) spring.d();
        if (this.f418a == 0.0f && d == 0.0f) {
            this.f419b.setVisibility(8);
        }
    }

    public final void m522a(Spring spring) {
        float d = (float) spring.d();
        this.f419b.setAlpha(d);
        this.f419b.setScaleX(d);
        this.f419b.setScaleY(d);
    }
}
