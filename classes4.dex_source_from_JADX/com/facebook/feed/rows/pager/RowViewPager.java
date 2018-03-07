package com.facebook.feed.rows.pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.inject.FbInjector;
import com.facebook.widget.ListViewFriendlyViewPager;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: o_cancel_req */
public class RowViewPager extends ListViewFriendlyViewPager {
    public static int f6347a = 2;
    @Inject
    public FeedRenderUtils f6348b;
    private int f6349c;

    private static <T extends View> void m6824a(Class<T> cls, T t) {
        m6825a((Object) t, t.getContext());
    }

    private static void m6825a(Object obj, Context context) {
        ((RowViewPager) obj).f6348b = FeedRenderUtils.a(FbInjector.get(context));
    }

    public RowViewPager(Context context) {
        super(context);
        m6826h();
    }

    public RowViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6826h();
    }

    private void m6826h() {
        m6824a(RowViewPager.class, (View) this);
    }

    public void setHiddenPages(int i) {
        this.f6349c = i;
        m6827i();
    }

    public int getHiddenPages() {
        return this.f6349c;
    }

    private void m6822a(@Nullable PagerAdapter pagerAdapter) {
        if (pagerAdapter != null && pagerAdapter.b() >= f6347a) {
            int a = this.f6348b.a();
            float f = ((float) this.q) / ((float) a);
            float d = pagerAdapter.d(0) + f;
            a = ((int) (((1.0f - (((float) getPaddingLeft()) / ((float) a))) - d) / (f + pagerAdapter.d(1)))) + 1;
            setOffscreenPageLimit(Math.max(1, a) + this.f6349c);
        }
    }

    private void m6827i() {
        m6822a(getAdapter());
    }

    public void onMeasure(int i, int i2) {
        m6827i();
        super.onMeasure(i, i2);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        m6822a(pagerAdapter);
        super.setAdapter(pagerAdapter);
    }

    private void m6823a(FeedRenderUtils feedRenderUtils) {
        this.f6348b = feedRenderUtils;
    }
}
