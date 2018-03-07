package com.facebook.feed.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.inject.Inject;

/* compiled from: nux_contact_logs_upload_screen_shown */
public class NewsFeedRecyclerView extends BetterRecyclerView {
    @Inject
    public AbstractFbErrorReporter f11768l;

    private static <T extends View> void m17023a(Class<T> cls, T t) {
        m17024a((Object) t, t.getContext());
    }

    private static void m17024a(Object obj, Context context) {
        ((NewsFeedRecyclerView) obj).f11768l = FbErrorReporterImpl.m2317a(FbInjector.get(context));
    }

    public NewsFeedRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17026p();
    }

    public NewsFeedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17026p();
    }

    private void m17026p() {
        m17023a(NewsFeedRecyclerView.class, (View) this);
        mo2196l();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        throw new UnsupportedOperationException("Use addScrollListener instead");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -756233070);
        try {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, -1408525668, a);
            return onTouchEvent;
        } catch (Exception e) {
            m17025a("OutOfBoundsOnTouchEvent", getAdapter().aZ_(), e);
            LogUtils.a(-1986334712, a);
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            m17025a("OutOfBoundsOnInterceptTouchEvent", getAdapter().aZ_(), e);
            return false;
        }
    }

    public final int mo2187o() {
        return m17022a(getBetterLayoutManager().m17374l(), getChildCount(), getLayoutManager().m17288D());
    }

    public int getAccurateFirstVisiblePosition() {
        return getBetterLayoutManager().mo2297I();
    }

    private void m17025a(String str, int i, Exception exception) {
        this.f11768l.m2351b(str, "Items in adapter: " + i, exception);
    }

    private static int m17022a(int i, int i2, int i3) {
        int i4 = 0;
        if (i < 0 || i2 <= 0) {
            return 0;
        }
        if (i != 0) {
            if (i + i2 == i3) {
                i4 = i3 - 1;
            } else {
                i4 = (i2 / 2) + i;
            }
        }
        return (int) (((((float) i4) / ((float) i3)) * ((float) i2)) + ((float) i));
    }
}
