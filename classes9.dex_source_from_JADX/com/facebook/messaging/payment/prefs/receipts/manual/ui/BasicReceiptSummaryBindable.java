package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.model.BasicReceiptSummaryModelAdapter;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: generic_attachment_small_cover_image_width */
public class BasicReceiptSummaryBindable implements InvoicesSummaryBindable {
    private final ViewGroup f14271a;
    private final BetterTextView f14272b = ((BetterTextView) FindViewUtil.b(this.f14271a, 2131558927));
    private final BetterTextView f14273c = ((BetterTextView) FindViewUtil.b(this.f14271a, 2131559769));
    private final BasicReceiptSummaryModelAdapter f14274d;

    @Inject
    public BasicReceiptSummaryBindable(LayoutInflater layoutInflater, @Assisted ViewGroup viewGroup, @Assisted BasicReceiptSummaryModelAdapter basicReceiptSummaryModelAdapter) {
        this.f14274d = (BasicReceiptSummaryModelAdapter) Preconditions.checkNotNull(basicReceiptSummaryModelAdapter);
        this.f14271a = (ViewGroup) layoutInflater.inflate(2130906740, viewGroup, false);
    }

    public final View mo560a() {
        return this.f14271a;
    }

    public final void mo561a(InvoicesSummaryModel invoicesSummaryModel) {
        this.f14272b.setText(this.f14274d.mo558a());
        this.f14273c.setText(this.f14274d.mo559a(invoicesSummaryModel));
    }
}
