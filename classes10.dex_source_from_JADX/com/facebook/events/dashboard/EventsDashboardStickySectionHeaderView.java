package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: com.google.android.gms.wearable.internal.IWearableListener */
public class EventsDashboardStickySectionHeaderView extends CustomFrameLayout {
    private FbTextView f16762a;

    public EventsDashboardStickySectionHeaderView(Context context) {
        super(context);
        m17154a();
    }

    public EventsDashboardStickySectionHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17154a();
    }

    public EventsDashboardStickySectionHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17154a();
    }

    private void m17154a() {
        setContentView(2130904137);
        this.f16762a = (FbTextView) c(2131561527);
    }

    public void setTitle(CharSequence charSequence) {
        this.f16762a.setText(charSequence);
    }

    public void setTitle(int i) {
        this.f16762a.setText(i);
    }
}
