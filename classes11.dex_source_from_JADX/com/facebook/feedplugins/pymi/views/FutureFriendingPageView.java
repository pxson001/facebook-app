package com.facebook.feedplugins.pymi.views;

import android.content.Context;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: checkup_items */
public class FutureFriendingPageView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f8813a;

    public FutureFriendingPageView(Context context) {
        super(context);
        setContentView(2130904570);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1006693796);
        super.onAttachedToWindow();
        this.f8813a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1268141800, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1421255593);
        super.onDetachedFromWindow();
        this.f8813a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1089506577, a);
    }

    public final boolean m9573a() {
        return this.f8813a;
    }
}
