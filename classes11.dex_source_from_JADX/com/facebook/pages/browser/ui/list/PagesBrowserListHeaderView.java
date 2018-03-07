package com.facebook.pages.browser.ui.list;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: story_gallery_survey_feed_unit */
public class PagesBrowserListHeaderView extends CustomRelativeLayout implements RecyclableView {
    public final TextView f1320a;
    public boolean f1321b;

    public PagesBrowserListHeaderView(Context context) {
        this(context, null);
    }

    private PagesBrowserListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906099);
        this.f1320a = (TextView) a(2131565678);
        this.f1320a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1207243515);
        super.onAttachedToWindow();
        this.f1321b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1011571691, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1093828798);
        super.onDetachedFromWindow();
        this.f1321b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1721737084, a);
    }

    public final boolean m1977a() {
        return this.f1321b;
    }
}
