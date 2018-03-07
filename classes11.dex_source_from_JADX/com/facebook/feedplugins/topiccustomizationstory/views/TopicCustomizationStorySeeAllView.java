package com.facebook.feedplugins.topiccustomizationstory.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: android.hardware.bluetooth_le */
public class TopicCustomizationStorySeeAllView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f9989a;
    public TextView f9990b;
    public FbButton f9991c;

    public TopicCustomizationStorySeeAllView(Context context) {
        this(context, null);
    }

    private TopicCustomizationStorySeeAllView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907526);
        this.f9990b = (TextView) c(2131568073);
        this.f9991c = (FbButton) c(2131568074);
    }

    public void setOnButtonClickListener(OnClickListener onClickListener) {
        this.f9991c.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1257733623);
        super.onAttachedToWindow();
        this.f9989a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -607482917, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -85155845);
        super.onDetachedFromWindow();
        this.f9989a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1800854646, a);
    }

    public final boolean m10351a() {
        return this.f9989a;
    }
}
