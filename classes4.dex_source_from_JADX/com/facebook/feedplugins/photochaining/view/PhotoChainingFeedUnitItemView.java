package com.facebook.feedplugins.photochaining.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: nrOptimizationsAttempted */
public class PhotoChainingFeedUnitItemView extends PagerItemWrapperLayout implements RecyclableView {
    public final PhotoChainingItemContainer f6660a;
    public boolean f6661b;

    public PhotoChainingFeedUnitItemView(Context context) {
        this(context, null);
    }

    private PhotoChainingFeedUnitItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906187);
        this.f6660a = new PhotoChainingItemContainer(this);
    }

    public PhotoChainingItemContainer getBody() {
        return this.f6660a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -813654998);
        super.onAttachedToWindow();
        this.f6661b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2112974698, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1125761602);
        super.onDetachedFromWindow();
        this.f6661b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -859480102, a);
    }

    public final boolean mo569a() {
        return this.f6661b;
    }
}
