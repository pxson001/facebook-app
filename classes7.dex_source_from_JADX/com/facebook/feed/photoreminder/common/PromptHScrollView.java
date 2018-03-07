package com.facebook.feed.photoreminder.common;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.HScrollDividerDecorator;

/* compiled from: admin_panel_show_admin_panel */
public class PromptHScrollView extends BetterRecyclerView {
    private Context f19753l;
    private LinearLayoutManager f19754m;

    public PromptHScrollView(Context context) {
        super(context);
        m23016a(context);
    }

    public PromptHScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23016a(context);
    }

    public PromptHScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23016a(context);
    }

    private void m23016a(Context context) {
        this.f19753l = context;
        this.f19754m = new BetterLinearLayoutManager(this.f19753l, 0, false);
        a(new HScrollDividerDecorator(this.f19753l.getResources().getColor(2131361871), this.f19753l.getResources().getDimensionPixelSize(2131430433)));
        setLayoutManager(this.f19754m);
        setVisibility(8);
    }
}
