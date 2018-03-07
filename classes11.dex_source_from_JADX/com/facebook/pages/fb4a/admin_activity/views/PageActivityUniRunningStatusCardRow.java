package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: quicksilver_extra_app_id */
public class PageActivityUniRunningStatusCardRow extends CustomLinearLayout {
    private final TextView f2839a;
    private final TextView f2840b;

    public PageActivityUniRunningStatusCardRow(Context context) {
        this(context, null, 0);
    }

    public PageActivityUniRunningStatusCardRow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageActivityUniRunningStatusCardRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905958);
        this.f2839a = (TextView) a(2131560124);
        this.f2840b = (TextView) a(2131565341);
    }

    public void setName(String str) {
        this.f2839a.setText(str);
    }

    public void setValue(String str) {
        this.f2840b.setText(str);
    }
}
