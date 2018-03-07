package com.facebook.feedplugins.pyml.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: notification_timeout */
public class EgoProfileSwipeUnitItemView extends PagerItemWrapperLayout implements RecyclableView {
    public final EgoItemContainer f6763a;
    public boolean f6764b;

    public EgoProfileSwipeUnitItemView(Context context) {
        this(context, null);
    }

    private EgoProfileSwipeUnitItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903964);
        this.f6763a = new EgoItemContainer(this);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1932383953);
        super.onAttachedToWindow();
        this.f6764b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1453921385, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 932219822);
        super.onDetachedFromWindow();
        this.f6764b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1442534124, a);
    }

    public final boolean mo569a() {
        return this.f6764b;
    }
}
