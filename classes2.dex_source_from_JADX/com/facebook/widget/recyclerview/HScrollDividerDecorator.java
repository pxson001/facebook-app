package com.facebook.widget.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: mutation_name */
public class HScrollDividerDecorator extends ItemDecoration {
    private int f13102a;
    private final Paint f13103b = new Paint(5);

    public HScrollDividerDecorator(int i, int i2) {
        this.f13102a = i2;
        this.f13103b.setColor(i);
    }

    public final void mo2585a(Canvas canvas, RecyclerView recyclerView, State state) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int right = layoutParams.rightMargin + childAt.getRight();
            int i2 = right + this.f13102a;
            canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) height, this.f13103b);
        }
    }

    public final void mo2586a(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.left = RecyclerView.m17093d(view) == 0 ? 0 : this.f13102a;
    }
}
