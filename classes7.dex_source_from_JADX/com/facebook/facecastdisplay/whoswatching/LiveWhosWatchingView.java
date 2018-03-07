package com.facebook.facecastdisplay.whoswatching;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

/* compiled from: artist */
public class LiveWhosWatchingView extends RecyclerView {
    private final GridLayoutManager f19110h;
    private final Adapter f19111i;

    public LiveWhosWatchingView(Context context) {
        this(context, null);
    }

    public LiveWhosWatchingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveWhosWatchingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = true;
        this.f19110h = new GridLayoutManager(getContext(), 4);
        setLayoutManager(this.f19110h);
        this.f19111i = new LiveWhosWatchingAdapter();
        setAdapter(this.f19111i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        setMeasuredDimension(size, (int) (((double) (size / 4)) * 2.5d));
    }
}
