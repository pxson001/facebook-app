package com.facebook.events.tickets;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseIntArray;
import android.view.View;
import com.facebook.widget.recyclerview.DividerDecorator.DefaultDividerDrawer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ask_info_request */
public class QuantityPickerDividerDecoration extends ItemDecoration {
    private final Paint f19199a;
    private final DefaultDividerDrawer f19200b;
    private final int f19201c;
    private final SparseIntArray f19202d = new SparseIntArray();

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ask_info_request */
    @interface DividerType {
    }

    public QuantityPickerDividerDecoration(RecyclerView recyclerView) {
        Resources resources = recyclerView.getResources();
        this.f19201c = resources.getDimensionPixelSize(2131427416);
        this.f19199a = new Paint(1);
        this.f19199a.setColor(resources.getColor(2131361986));
        this.f19199a.setAntiAlias(true);
        this.f19199a.setStrokeWidth((float) resources.getDimensionPixelSize(2131434216));
        this.f19199a.setDither(true);
        this.f19200b = new DefaultDividerDrawer();
        m19379a();
    }

    private void m19379a() {
        m19380a(2131561215, 2);
        m19380a(2131561203, 1);
    }

    private void m19380a(@IdRes int i, int i2) {
        this.f19202d.put(i, i2);
    }

    public final void m19381a(Canvas canvas, RecyclerView recyclerView, State state) {
        super.a(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            switch (this.f19202d.get(childAt.getId(), 0)) {
                case 0:
                    this.f19200b.a(canvas, this.f19199a, recyclerView, childAt, 0, 0);
                    break;
                case 1:
                    this.f19200b.a(canvas, this.f19199a, recyclerView, childAt, this.f19201c, this.f19201c);
                    break;
                default:
                    break;
            }
        }
    }
}
