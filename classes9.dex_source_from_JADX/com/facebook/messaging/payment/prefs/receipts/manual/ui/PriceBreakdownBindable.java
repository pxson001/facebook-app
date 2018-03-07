package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.messaging.payment.ui.PlatformCommerceAmountView;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParams;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: generation */
public class PriceBreakdownBindable implements InvoicesSummaryBindable {
    private final PlatformCommerceAmountView f14281a;

    @Inject
    public PriceBreakdownBindable(@Assisted ViewGroup viewGroup) {
        this.f14281a = new PlatformCommerceAmountView(viewGroup.getContext());
        this.f14281a.setLayoutParams(new LayoutParams(-1, -2));
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(2131433427);
        this.f14281a.setBackgroundResource(2130842551);
        this.f14281a.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final View mo560a() {
        return this.f14281a;
    }

    public final void mo561a(InvoicesSummaryModel invoicesSummaryModel) {
        Preconditions.checkState(invoicesSummaryModel.f14250c.isPresent());
        this.f14281a.setViewParams((PlatformCommerceAmountViewParams) invoicesSummaryModel.f14250c.get());
    }
}
