package com.facebook.feed.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import java.text.NumberFormat;

/* compiled from: UI_LIVE */
public class StoryInsightsExtendedFooterView extends CustomLinearLayout {
    private TextView f21595a;
    private TextView f21596b;
    private TextView f21597c;

    public StoryInsightsExtendedFooterView(Context context) {
        this(context, null);
        m24208a();
    }

    public StoryInsightsExtendedFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24208a();
    }

    private void m24208a() {
        setContentView(2130904342);
        setOrientation(0);
        this.f21595a = (TextView) a(2131562005);
        this.f21596b = (TextView) a(2131562006);
        this.f21597c = (TextView) a(2131562007);
    }

    public final void m24209a(int i, int i2, int i3) {
        NumberFormat instance = NumberFormat.getInstance(getResources().getConfiguration().locale);
        this.f21595a.setText(instance.format((long) i));
        this.f21596b.setText(instance.format((long) i2));
        this.f21597c.setText(instance.format((long) i3));
    }
}
