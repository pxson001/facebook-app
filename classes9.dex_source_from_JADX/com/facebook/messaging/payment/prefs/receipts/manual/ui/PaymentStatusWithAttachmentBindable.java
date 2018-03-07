package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: generic_attachment_large_square_image_dimension */
public class PaymentStatusWithAttachmentBindable implements InvoicesSummaryBindable {
    private static final CallerContext f14275a = CallerContext.a(PaymentStatusWithAttachmentBindable.class);
    private final ViewGroup f14276b;
    private final ViewGroup f14277c = ((ViewGroup) FindViewUtil.b(this.f14276b, 2131566829));
    private final BetterTextView f14278d = ((BetterTextView) FindViewUtil.b(this.f14276b, 2131566830));
    private final FbDraweeView f14279e = ((FbDraweeView) FindViewUtil.b(this.f14276b, 2131566831));
    private final FbDraweeView f14280f = ((FbDraweeView) FindViewUtil.b(this.f14276b, 2131566832));

    @Inject
    public PaymentStatusWithAttachmentBindable(LayoutInflater layoutInflater, @Assisted ViewGroup viewGroup) {
        this.f14276b = (ViewGroup) layoutInflater.inflate(2130906741, viewGroup, false);
    }

    public final View mo560a() {
        return this.f14276b;
    }

    public final void mo561a(InvoicesSummaryModel invoicesSummaryModel) {
        Preconditions.checkState(invoicesSummaryModel.f14264q.isPresent());
        this.f14278d.setText((CharSequence) invoicesSummaryModel.f14264q.get());
        if (invoicesSummaryModel.f14257j.isPresent()) {
            this.f14279e.setVisibility(0);
            this.f14279e.a((Uri) invoicesSummaryModel.f14257j.get(), f14275a);
        } else {
            this.f14279e.setVisibility(8);
        }
        if (invoicesSummaryModel.f14256i.isPresent()) {
            this.f14280f.setVisibility(0);
            this.f14280f.a((Uri) invoicesSummaryModel.f14256i.get(), f14275a);
            return;
        }
        this.f14280f.setVisibility(8);
    }
}
