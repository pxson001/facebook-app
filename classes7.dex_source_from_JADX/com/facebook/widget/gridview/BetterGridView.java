package com.facebook.widget.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.ScrollableView;
import com.facebook.widget.listeners.BetterViewOnScrollListener;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: date_text */
public class BetterGridView extends GridView implements ScrollableView {
    public BetterViewOnScrollListener f16124a;

    private static <T extends View> void m20152a(Class<T> cls, T t) {
        m20153a((Object) t, t.getContext());
    }

    private static void m20153a(Object obj, Context context) {
        ((BetterGridView) obj).f16124a = BetterViewOnScrollListener.a(FbInjector.get(context));
    }

    public BetterGridView(Context context) {
        super(context);
        m20150a();
    }

    public BetterGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20150a();
    }

    public BetterGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20150a();
    }

    @Inject
    private void m20151a(BetterViewOnScrollListener betterViewOnScrollListener) {
        this.f16124a = betterViewOnScrollListener;
    }

    private void m20150a() {
        m20152a(BetterGridView.class, (View) this);
        super.setOnScrollListener(this.f16124a);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f16124a.b = onScrollListener;
    }

    public final void m20155a(OnScrollListener onScrollListener) {
        this.f16124a.b(onScrollListener);
    }

    public final int m20154a(int i) {
        Preconditions.checkArgument(getChildCount() > 0);
        int i2 = ((MarginLayoutParams) getLayoutParams()).leftMargin;
        int measuredWidth = getChildAt(0).getMeasuredWidth();
        return (measuredWidth >= 0 && i != measuredWidth) ? i2 + ((measuredWidth - i) / 2) : i2;
    }
}
