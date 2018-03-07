package com.facebook.pages.common.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: scroll_invites */
public class SelectiveVerticalSpaceDecorator extends ItemDecoration {
    private final int f2249a;
    private final Drawable f2250b;

    public SelectiveVerticalSpaceDecorator(int i, @Nullable Drawable drawable) {
        this.f2249a = i;
        this.f2250b = drawable;
    }

    public final void m3198a(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.a(rect, view, recyclerView, state);
        if (mo56a(view, recyclerView)) {
            rect.bottom = this.f2249a;
        }
    }

    public final void m3197a(Canvas canvas, RecyclerView recyclerView, State state) {
        if (this.f2250b != null) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (mo56a(childAt, recyclerView)) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.f2250b.setBounds(paddingLeft, bottom, width, this.f2249a + bottom);
                    this.f2250b.draw(canvas);
                }
            }
        }
    }

    protected boolean mo56a(View view, RecyclerView recyclerView) {
        return true;
    }
}
