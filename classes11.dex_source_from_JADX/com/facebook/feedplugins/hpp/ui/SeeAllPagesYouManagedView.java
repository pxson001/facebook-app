package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: currentActionText */
public class SeeAllPagesYouManagedView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f7851a;
    private ImageButton f7852b;

    public SeeAllPagesYouManagedView(Context context) {
        this(context, null);
    }

    private SeeAllPagesYouManagedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904807);
        this.f7852b = (ImageButton) findViewById(2131560752);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1021409376);
        super.onAttachedToWindow();
        this.f7851a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -454757621, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -674326352);
        super.onDetachedFromWindow();
        this.f7852b.setOnClickListener(null);
        this.f7851a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1794667288, a);
    }

    public final boolean m8976a() {
        return this.f7851a;
    }

    public void setButtonClickListener(OnClickListener onClickListener) {
        this.f7852b.setOnClickListener(onClickListener);
    }
}
