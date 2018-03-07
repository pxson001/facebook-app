package com.facebook.video.videohome.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

/* compiled from: show_error_toasts */
public class VideoHomeLiveVideoHScrollComponentView extends PagerItemWrapperLayout implements RecyclableView, RecyclerViewKeepAttached {
    public boolean f3349a;
    private LinearLayout f3350b;

    public VideoHomeLiveVideoHScrollComponentView(Context context) {
        this(context, null);
    }

    private VideoHomeLiveVideoHScrollComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907719);
        this.f3350b = (LinearLayout) c(2131568431);
    }

    public LinearLayout getContainer() {
        return this.f3350b;
    }

    public final boolean m3179a() {
        return this.f3349a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1470279847);
        super.onAttachedToWindow();
        this.f3349a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -141838108, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1558723597);
        super.onDetachedFromWindow();
        this.f3349a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1892754149, a);
    }

    public void addView(View view) {
        this.f3350b.addView(view);
    }

    public void removeAllViews() {
        this.f3350b.removeAllViews();
    }

    public final boolean gK_() {
        return true;
    }
}
