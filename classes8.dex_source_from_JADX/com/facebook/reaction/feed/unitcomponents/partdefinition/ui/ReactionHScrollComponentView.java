package com.facebook.reaction.feed.unitcomponents.partdefinition.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: above */
public class ReactionHScrollComponentView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f20180a;
    public LinearLayout f20181b;

    public ReactionHScrollComponentView(Context context) {
        this(context, null);
    }

    private ReactionHScrollComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906675);
        this.f20181b = (LinearLayout) c(2131566723);
    }

    public void setBottomMargin(float f) {
        LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(0, 0);
        }
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, SizeUtil.a(getContext(), f));
        setLayoutParams(layoutParams);
    }

    public final boolean m24048a() {
        return this.f20180a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1859711018);
        super.onAttachedToWindow();
        this.f20180a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -883423864, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1485098534);
        super.onDetachedFromWindow();
        this.f20180a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1847113684, a);
    }

    public void addView(View view) {
        this.f20181b.addView(view);
    }

    public void removeAllViews() {
        this.f20181b.removeAllViews();
    }
}
