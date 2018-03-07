package com.facebook.feedplugins.findpages.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: doNotSetTitleBar */
public class FindPagesView extends CustomLinearLayout implements RecyclableView {
    public boolean f7599a;

    public FindPagesView(Context context) {
        this(context, null);
    }

    private FindPagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904338);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -105969401);
        super.onAttachedToWindow();
        this.f7599a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1567637723, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2105634799);
        super.onDetachedFromWindow();
        this.f7599a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1672753927, a);
    }

    public final boolean m8825a() {
        return this.f7599a;
    }
}
