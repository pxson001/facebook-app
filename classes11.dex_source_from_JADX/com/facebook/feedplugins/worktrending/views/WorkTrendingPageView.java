package com.facebook.feedplugins.worktrending.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: allow_new_paypal */
public class WorkTrendingPageView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f10049a;
    public final PillsBlingBarView f10050b;

    public WorkTrendingPageView(Context context) {
        this(context, null);
    }

    private WorkTrendingPageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907787);
        this.f10050b = (PillsBlingBarView) c(2131568571);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1654898339);
        super.onAttachedToWindow();
        this.f10049a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -196462408, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1153495036);
        super.onDetachedFromWindow();
        this.f10049a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -689504113, a);
    }

    public final boolean m10396a() {
        return this.f10049a;
    }
}
