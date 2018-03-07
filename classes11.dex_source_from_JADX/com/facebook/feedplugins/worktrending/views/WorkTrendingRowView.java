package com.facebook.feedplugins.worktrending.views;

import android.content.Context;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: allow_new_cc */
public class WorkTrendingRowView extends CustomLinearLayout implements RecyclableView {
    public boolean f10051a;
    public ImageWithTextView f10052b = ((ImageWithTextView) a(2131568567));

    public WorkTrendingRowView(Context context) {
        super(context);
        setContentView(2130907786);
        setOrientation(0);
        setBackground(getResources().getDrawable(2130840170));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1996558558);
        super.onAttachedToWindow();
        this.f10051a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -155956011, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1094782663);
        super.onDetachedFromWindow();
        this.f10051a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1803858201, a);
    }

    public final boolean m10397a() {
        return this.f10051a;
    }
}
