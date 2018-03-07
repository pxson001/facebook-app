package com.facebook.saved.views;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.menu.PopoverMenu.Callback;
import com.facebook.fbui.menu.PopoverMenu.MenuPresenter;
import com.facebook.fbui.popover.PopoverListView;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionType;
import com.facebook.fbui.popover.PopoverWindow;
import javax.annotation.Nullable;

/* compiled from: instant_shopping_first_parse */
public class SavedDashboardFilterPopoverWindow extends PopoverWindow implements Callback, MenuPresenter {
    public PopoverMenu f9345a;

    public SavedDashboardFilterPopoverWindow(Context context) {
        super(context);
        a(TransitionType.SLIDE_UP);
        c(true);
    }

    public final void m9500a(PopoverMenu popoverMenu, boolean z) {
        this.f9345a = popoverMenu;
        this.f9345a.a(this);
        this.f9345a.a(this);
        d();
    }

    public final boolean m9501a(MenuItem menuItem) {
        return false;
    }

    private void m9497b(@Nullable View view) {
        PopoverListView popoverListView;
        if (this.f9345a == null || !this.f9345a.hasVisibleItems()) {
            popoverListView = null;
        } else {
            PopoverListView popoverListView2 = new PopoverListView(getContext());
            popoverListView2.setAdapter(this.f9345a);
            popoverListView2.setOnItemClickListener(this.f9345a);
            popoverListView2.setShowFullWidth(this.e);
            popoverListView2.setMaxWidth(this.c);
            popoverListView2.setMaxRows(10.0f);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131432265);
            if (popoverListView2.e != dimensionPixelSize) {
                popoverListView2.e = dimensionPixelSize;
                popoverListView2.requestLayout();
                popoverListView2.invalidate();
            }
            View h = h();
            popoverListView2.setMinimumWidth(h != null ? h.getWidth() : 0);
            popoverListView = popoverListView2;
        }
        View view2 = popoverListView;
        if (view2 != null) {
            if (this.r) {
                e(view2);
                e();
                return;
            }
            d(view2);
            if (view != null) {
                super.a(view);
            } else {
                super.d();
            }
        }
    }

    public final void m9502d() {
        a(null);
    }

    public final void m9499a(View view) {
        m9497b(view);
    }

    public final void m9498a() {
        l();
    }
}
