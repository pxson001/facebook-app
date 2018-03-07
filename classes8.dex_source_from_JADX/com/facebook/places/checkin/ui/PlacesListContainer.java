package com.facebook.places.checkin.ui;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.BetterListView;

/* compiled from: chained_units */
public class PlacesListContainer extends CustomFrameLayout {
    private View f18112a;
    public BetterListView f18113b;
    private SwipeRefreshLayout f18114c;

    private static <T extends View> void m22080a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m22081a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PlacesListContainer(Context context) {
        super(context);
        m22082f();
    }

    public PlacesListContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22082f();
    }

    public PlacesListContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22082f();
    }

    private void m22082f() {
        m22080a(PlacesListContainer.class, (View) this);
        setContentView(2130906268);
        this.f18113b = (BetterListView) c(2131566020);
        this.f18112a = c(2131559623);
        this.f18113b.setEmptyView(null);
    }

    public BetterListView getListView() {
        return this.f18113b;
    }

    public int getListViewCount() {
        return this.f18113b.getCount();
    }

    public final void m22083a() {
        this.f18112a.setVisibility(8);
        this.f18113b.setVisibility(8);
        if (this.f18114c != null) {
            this.f18114c.setRefreshing(false);
            this.f18114c.setEnabled(false);
        }
    }

    public final void m22085b() {
        this.f18112a.setVisibility(8);
        if (this.f18114c != null) {
            this.f18114c.setRefreshing(false);
            this.f18114c.setEnabled(true);
        }
        this.f18113b.setVisibility(0);
    }

    public final void m22086e() {
        Object obj;
        int i;
        int i2 = 8;
        if (getListViewCount() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        View view = this.f18112a;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        BetterListView betterListView = this.f18113b;
        if (obj == null) {
            i2 = 0;
        }
        betterListView.setVisibility(i2);
    }

    public final void m22084a(OnRefreshListener onRefreshListener) {
        this.f18114c = (SwipeRefreshLayout) ((ViewStub) c(2131566019)).inflate();
        this.f18114c.setColorSchemeResources(new int[]{2131361916});
        removeView(this.f18113b);
        this.f18114c.addView(this.f18113b);
        this.f18114c.e = onRefreshListener;
    }
}
