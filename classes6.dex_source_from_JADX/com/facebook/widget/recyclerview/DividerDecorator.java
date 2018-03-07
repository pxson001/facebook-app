package com.facebook.widget.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: receipient */
public class DividerDecorator extends ItemDecoration {
    private final Paint f6125a = new Paint();
    public int f6126b = 0;
    public int f6127c = 0;
    private DefaultDividerDrawer f6128d = new DefaultDividerDrawer();
    public boolean f6129e = false;

    /* compiled from: receipient */
    public class DefaultDividerDrawer {
        public final void m8687a(Canvas canvas, Paint paint, RecyclerView recyclerView, View view, int i, int i2) {
            int paddingLeft = recyclerView.getPaddingLeft() + i;
            int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - i2;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int bottom = layoutParams.bottomMargin + view.getBottom();
            float f = (float) bottom;
            canvas.drawLine((float) paddingLeft, (float) bottom, (float) width, f, paint);
        }
    }

    public DividerDecorator(int i, int i2) {
        this.f6125a.setColor(i);
        this.f6125a.setAntiAlias(true);
        this.f6125a.setStrokeWidth((float) i2);
        this.f6125a.setDither(true);
    }

    public final void m8689a(Canvas canvas, RecyclerView recyclerView, State state) {
        super.a(canvas, recyclerView, state);
        if (!this.f6129e) {
            m8688a(canvas, recyclerView);
        }
    }

    public final void m8690b(Canvas canvas, RecyclerView recyclerView, State state) {
        super.b(canvas, recyclerView, state);
        if (this.f6129e) {
            m8688a(canvas, recyclerView);
        }
    }

    private void m8688a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            Canvas canvas2 = canvas;
            RecyclerView recyclerView2 = recyclerView;
            this.f6128d.m8687a(canvas2, this.f6125a, recyclerView2, recyclerView.getChildAt(i), this.f6126b, this.f6127c);
        }
    }
}
