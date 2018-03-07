package com.facebook.katana;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.devicebasedlogin.settings.DBLSettingsPreferenceViewHolder;
import com.facebook.devicebasedlogin.settings.DBLSettingsViewHolder;

/* compiled from: image_element_start */
public class DividerItemDecoration extends ItemDecoration {
    private Drawable f24190a;

    public DividerItemDecoration(Context context) {
        this.f24190a = context.getResources().getDrawable(2130843343);
    }

    public final void m25490b(Canvas canvas, RecyclerView recyclerView, State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (m25488a(childAt, recyclerView)) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bottom = (layoutParams.bottomMargin + childAt.getBottom()) + ((int) childAt.getTranslationY());
                this.f24190a.setBounds(paddingLeft, bottom, width, this.f24190a.getIntrinsicHeight() + bottom);
                this.f24190a.draw(canvas);
            }
        }
    }

    public final void m25489a(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (m25488a(view, recyclerView)) {
            rect.set(0, 0, 0, this.f24190a.getIntrinsicHeight());
        } else {
            super.a(rect, view, recyclerView, state);
        }
    }

    private static boolean m25488a(View view, RecyclerView recyclerView) {
        return ((DBLSettingsViewHolder) recyclerView.a(view)) instanceof DBLSettingsPreferenceViewHolder;
    }
}
