package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: did_tap_commerce_bubble */
public class RotatingGridLayoutManager extends GridLayoutManager {
    private float f16156t;

    public RotatingGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public final void m16285c(Recycler recycler, State state) {
        super.c(recycler, state);
        m16282I();
    }

    public final void m16284b(View view, int i) {
        super.b(view, i);
        m16283l(view);
    }

    private void m16282I() {
        int v = v();
        for (int i = 0; i < v; i++) {
            m16283l(f(i));
        }
    }

    private void m16283l(View view) {
        if (view instanceof ViewGroup) {
            view.setRotation(0.0f);
        } else {
            view.setRotation(this.f16156t);
        }
    }
}
