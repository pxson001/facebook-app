package com.facebook.video.videohome.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

/* compiled from: show_entry_points */
public class VideoHomeLiveVideoHScrollEmptyCardView extends PagerItemWrapperLayout implements RecyclableView, RecyclerViewKeepAttached {
    public boolean f3351a;
    private FrameLayout f3352b;

    public VideoHomeLiveVideoHScrollEmptyCardView(Context context) {
        this(context, null);
    }

    private VideoHomeLiveVideoHScrollEmptyCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907718);
        this.f3352b = (FrameLayout) c(2131568430);
    }

    public FrameLayout getContainer() {
        return this.f3352b;
    }

    public final boolean m3180a() {
        return this.f3351a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1692585852);
        super.onAttachedToWindow();
        this.f3351a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 526546922, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1514635255);
        super.onDetachedFromWindow();
        this.f3351a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1469125113, a);
    }

    public void addView(View view) {
        this.f3352b.addView(view);
    }

    public void removeAllViews() {
        this.f3352b.removeAllViews();
    }

    public final boolean gK_() {
        return false;
    }
}
