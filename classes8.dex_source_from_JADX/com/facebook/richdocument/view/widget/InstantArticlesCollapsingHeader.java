package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.richdocument.view.widget.RichDocumentCollapsingHeaderAndRecyclerViewLayout.CollapsingHeader;

/* compiled from: onscreen_raw_time */
public class InstantArticlesCollapsingHeader extends FrameLayout implements CollapsingHeader {
    private ShareBar f7201a;
    private int f7202b;
    private int f7203c;

    public InstantArticlesCollapsingHeader(Context context) {
        this(context, null);
    }

    public InstantArticlesCollapsingHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InstantArticlesCollapsingHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7202b = getResources().getDimensionPixelSize(2131431840);
        this.f7203c = getResources().getDimensionPixelSize(2131431841);
    }

    public int getExpandedHeight() {
        return this.f7203c;
    }

    public int getCollapsedHeight() {
        return this.f7202b;
    }

    public int getCurrentHeight() {
        return getHeight();
    }

    public int getCurrentBottom() {
        return getBottom();
    }

    public final void mo449a(int i) {
        this.f7201a = (ShareBar) findViewById(2131562986);
        if (this.f7201a != null && ViewCompat.E(this.f7201a)) {
            this.f7201a.m7693a(i);
        }
    }

    public final View mo448a() {
        return this;
    }
}
