package com.facebook.groups.gysc;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: payments_add_card_fail */
public class GYSCRowView extends BetterRecyclerView {
    private LinearLayoutManager f6924l;

    public GYSCRowView(Context context) {
        super(context);
        m7209o();
    }

    public GYSCRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7209o();
    }

    public GYSCRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7209o();
    }

    private void m7209o() {
        this.f6924l = new LinearLayoutManager(getContext());
        this.f6924l.b(0);
        setLayoutManager(this.f6924l);
        this.d.g = false;
    }
}
