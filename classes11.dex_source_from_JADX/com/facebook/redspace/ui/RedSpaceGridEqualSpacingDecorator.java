package com.facebook.redspace.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.device.ScreenUtil;
import com.facebook.ultralight.Inject;

/* compiled from: PRIVACY_REVIEW_WRITE_TIMEOUT */
public class RedSpaceGridEqualSpacingDecorator extends ItemDecoration {
    @Inject
    public ScreenUtil f12322a;
    @Inject
    public Resources f12323b;
    private final ItemDecoration f12324c = new RedSpaceGridEqualSpacingDecoration();

    /* compiled from: PRIVACY_REVIEW_WRITE_TIMEOUT */
    class RedSpaceGridEqualSpacingDecoration extends ItemDecoration {
        public final void m12745a(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.a(rect, view, recyclerView, state);
            int d = RecyclerView.d(view);
            if (d != -1) {
                d = ((GridLayoutManager) recyclerView.getLayoutManager()).h.a(d) == ((GridLayoutManager) recyclerView.getLayoutManager()).c ? -recyclerView.getPaddingLeft() : 0;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                if (marginLayoutParams.leftMargin != d) {
                    marginLayoutParams.rightMargin = d;
                    marginLayoutParams.leftMargin = d;
                    view.setLayoutParams(view.getLayoutParams());
                }
            }
        }
    }

    public final void m12747a(RecyclerView recyclerView) {
        recyclerView.a(this.f12324c);
        recyclerView.setBackgroundColor(this.f12323b.getColor(2131361920));
        m12746c(recyclerView);
    }

    private void m12746c(RecyclerView recyclerView) {
        int i = ((GridLayoutManager) recyclerView.getLayoutManager()).c;
        int c = this.f12322a.c() - (this.f12323b.getDimensionPixelSize(2131430558) * i);
        int i2 = (c / i) / 2;
        i = (int) ((((float) c) / ((float) ((i2 * 2) + c))) * ((float) i2));
        if (recyclerView.getPaddingLeft() != i) {
            recyclerView.setPadding(i, 0, i, 0);
            recyclerView.setClipToPadding(false);
        }
    }

    public final void m12748b(RecyclerView recyclerView) {
        m12746c(recyclerView);
        recyclerView.h();
    }
}
