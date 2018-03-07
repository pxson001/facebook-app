package com.facebook.orca.threadlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: native_impression_report_url */
public class ThreadListEmptyView extends CustomViewGroup {
    private final TextView f6593a;

    public ThreadListEmptyView(Context context) {
        this(context, null);
    }

    public ThreadListEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadListEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905875);
        this.f6593a = (TextView) getView(2131565187);
    }

    public void setStartConversationTextVisibility(boolean z) {
        if (z) {
            this.f6593a.setVisibility(0);
        } else {
            this.f6593a.setVisibility(8);
        }
    }
}
