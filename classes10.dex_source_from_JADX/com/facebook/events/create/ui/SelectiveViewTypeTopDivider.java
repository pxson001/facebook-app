package com.facebook.events.create.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: composer_photo_media_resource_list */
public class SelectiveViewTypeTopDivider extends ItemDecoration {
    private final Paint f16393a = new Paint();
    private final Adapter f16394b;
    private final int f16395c;
    public int f16396d;

    public SelectiveViewTypeTopDivider(int i, int i2, Adapter adapter, int i3) {
        this.f16393a.setColor(i);
        this.f16393a.setAntiAlias(true);
        this.f16393a.setStrokeWidth((float) i2);
        this.f16393a.setDither(true);
        this.f16394b = adapter;
        this.f16395c = i3;
    }

    public final void m16854a(Canvas canvas, RecyclerView recyclerView, State state) {
        super.a(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (this.f16394b.getItemViewType(recyclerView.a(childAt).d()) == this.f16395c) {
                int top = childAt.getTop() + this.f16396d;
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) recyclerView.getPaddingLeft(), (float) top, (float) (recyclerView.getWidth() - recyclerView.getPaddingRight()), (float) top, this.f16393a);
            }
        }
    }
}
