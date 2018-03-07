package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: gbk */
public class ProductItemViewBindable implements InvoicesSummaryBindable {
    private final SingleItemInfoView f14282a;

    @Inject
    public ProductItemViewBindable(@Assisted ViewGroup viewGroup) {
        this.f14282a = new SingleItemInfoView(viewGroup.getContext());
        this.f14282a.setLayoutParams(new LayoutParams(-1, -2));
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(2131433427);
        this.f14282a.setBackgroundResource(2130842551);
        this.f14282a.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final View mo560a() {
        return this.f14282a;
    }

    public final void mo561a(InvoicesSummaryModel invoicesSummaryModel) {
        Preconditions.checkState(invoicesSummaryModel.f14249b.isPresent());
        this.f14282a.setViewParams((SingleItemInfoViewParams) invoicesSummaryModel.f14249b.get());
    }
}
