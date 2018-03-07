package com.facebook.pages.common.recyclerview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: setTargetAlbum */
public class SelectiveDividerWithPaddingDecorator extends ItemDecoration {
    private Drawable f1715a;

    /* compiled from: setTargetAlbum */
    public class DividerPadding {
        public int f2247a;
        public int f2248b;

        public DividerPadding(int i, int i2) {
            this.f2247a = i;
            this.f2248b = i2;
        }
    }

    public SelectiveDividerWithPaddingDecorator(Drawable drawable) {
        this.f1715a = drawable;
    }

    public final void m2528b(Canvas canvas, RecyclerView recyclerView, State state) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (mo41a(childAt, recyclerView)) {
                DividerPadding b = mo42b(childAt, recyclerView);
                int i2 = b.f2247a;
                int i3 = b.f2248b;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bottom = layoutParams.bottomMargin + childAt.getBottom();
                this.f1715a.setBounds(i2, bottom, i3, this.f1715a.getIntrinsicHeight() + bottom);
                this.f1715a.draw(canvas);
            }
        }
    }

    protected boolean mo41a(View view, RecyclerView recyclerView) {
        return true;
    }

    protected DividerPadding mo42b(View view, RecyclerView recyclerView) {
        return new DividerPadding(recyclerView.getPaddingLeft(), recyclerView.getWidth() - recyclerView.getPaddingRight());
    }
}
