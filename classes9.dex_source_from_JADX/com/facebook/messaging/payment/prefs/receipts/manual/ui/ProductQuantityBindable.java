package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: gb18030 */
public class ProductQuantityBindable implements InvoicesSummaryBindable {
    private final ViewGroup f14283a;
    private final BetterTextView f14284b = ((BetterTextView) FindViewUtil.b(this.f14283a, 2131566833));

    @Inject
    public ProductQuantityBindable(LayoutInflater layoutInflater, @Assisted ViewGroup viewGroup) {
        this.f14283a = (ViewGroup) layoutInflater.inflate(2130906742, viewGroup, false);
    }

    public final View mo560a() {
        return this.f14283a;
    }

    public final void mo561a(InvoicesSummaryModel invoicesSummaryModel) {
        this.f14284b.setText(String.valueOf(invoicesSummaryModel.f14258k.get()));
    }
}
