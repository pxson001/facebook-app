package com.facebook.messaging.payment.prefs.receipts.manual;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.widget.ViewSwitcher;

/* compiled from: getBlockedPeople */
public class InvoicesSummaryView {
    public final RecyclerView f14229a;
    public final ViewSwitcher f14230b;

    public InvoicesSummaryView(RecyclerView recyclerView, ViewSwitcher viewSwitcher, LayoutManager layoutManager) {
        this.f14229a = recyclerView;
        this.f14230b = viewSwitcher;
        this.f14229a.setLayoutManager(layoutManager);
    }

    public final void m14683b() {
        this.f14230b.setDisplayedChild(1);
    }
}
