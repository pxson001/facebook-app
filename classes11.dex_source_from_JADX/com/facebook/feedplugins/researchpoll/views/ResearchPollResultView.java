package com.facebook.feedplugins.researchpoll.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: bytecode_cache_read_only */
public class ResearchPollResultView extends PagerItemWrapperLayout implements RecyclableView {
    public TextView f9142a;
    public ResearchPollResultItemView[] f9143b;
    public boolean f9144c = false;

    public ResearchPollResultView(Context context) {
        super(context);
        setContentView(2130906832);
        this.f9143b = new ResearchPollResultItemView[5];
        this.f9142a = (TextView) c(2131566972);
        LinearLayout linearLayout = (LinearLayout) c(2131566973);
        for (int i = 0; i < 5; i++) {
            this.f9143b[i] = (ResearchPollResultItemView) linearLayout.getChildAt(i);
            this.f9143b[i].setVisibility(4);
        }
    }

    public final boolean m9827a() {
        return this.f9144c;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1115874414);
        super.onAttachedToWindow();
        this.f9144c = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 424802191, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1717079429);
        super.onDetachedFromWindow();
        this.f9144c = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1944198251, a);
    }
}
