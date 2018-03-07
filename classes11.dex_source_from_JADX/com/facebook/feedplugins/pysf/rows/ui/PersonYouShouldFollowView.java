package com.facebook.feedplugins.pysf.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: change_privacy */
public class PersonYouShouldFollowView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f8840a;

    public PersonYouShouldFollowView(Context context) {
        this(context, null);
    }

    private PersonYouShouldFollowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906172);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2060845784);
        super.onAttachedToWindow();
        this.f8840a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -371971283, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -528391936);
        super.onDetachedFromWindow();
        this.f8840a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 882689429, a);
    }

    public final boolean m9592a() {
        return this.f8840a;
    }
}
