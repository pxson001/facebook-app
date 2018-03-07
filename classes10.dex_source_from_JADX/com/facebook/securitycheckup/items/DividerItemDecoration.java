package com.facebook.securitycheckup.items;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: image_element_start */
public class DividerItemDecoration extends ItemDecoration {
    private Drawable f9790a;

    public DividerItemDecoration(Context context) {
        this.f9790a = context.getResources().getDrawable(2130843251);
    }

    public final void m10013b(Canvas canvas, RecyclerView recyclerView, State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int bottom = (layoutParams.bottomMargin + childAt.getBottom()) + ((int) childAt.getTranslationY());
            this.f9790a.setBounds(paddingLeft, bottom, width, this.f9790a.getIntrinsicHeight() + bottom);
            this.f9790a.draw(canvas);
        }
    }
}
