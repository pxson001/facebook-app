package com.facebook.messaging.payment.prefs.receipts.manual;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.Assisted;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ModelToItemsConverter.Item;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getIncomingPaymentRequests */
public class InvoicesSummaryPresenter {
    public final InvoiceSummaryFetcher f14222a;
    public final InvoicesSummaryAdapter f14223b;
    private final AbstractFbErrorReporter f14224c;
    public final InvoicesSummaryView f14225d;
    public final String f14226e;
    @Nullable
    public EventListener f14227f;
    public final AbstractDisposableFutureCallback<InvoicesSummaryModel> f14228g = new C16191(this);

    /* compiled from: getIncomingPaymentRequests */
    class C16191 extends AbstractDisposableFutureCallback<InvoicesSummaryModel> {
        final /* synthetic */ InvoicesSummaryPresenter f14221a;

        C16191(InvoicesSummaryPresenter invoicesSummaryPresenter) {
            this.f14221a = invoicesSummaryPresenter;
        }

        protected final void m14680a(Object obj) {
            InvoicesSummaryModel invoicesSummaryModel = (InvoicesSummaryModel) obj;
            InvoicesSummaryAdapter invoicesSummaryAdapter = this.f14221a.f14223b;
            invoicesSummaryAdapter.f14209c = invoicesSummaryModel;
            Builder builder = new Builder();
            if (invoicesSummaryModel.f14249b.isPresent()) {
                builder.c(Item.PRODUCT_ITEM);
            }
            if (invoicesSummaryModel.f14258k.isPresent()) {
                builder.c(Item.QUANTITY);
            }
            if (invoicesSummaryModel.f14250c.isPresent()) {
                builder.c(Item.PRICE_BREAKDOWN);
            }
            if (invoicesSummaryModel.f14251d.isPresent()) {
                builder.c(Item.SHIPPING_ADDRESS);
            }
            if (invoicesSummaryModel.f14252e.isPresent()) {
                builder.c(Item.SHIPPING_METHOD);
            }
            if (invoicesSummaryModel.f14255h.isPresent()) {
                if (invoicesSummaryModel.f14256i.isPresent() || invoicesSummaryModel.f14257j.isPresent()) {
                    builder.c(Item.PAYMENT_STATUS_WITH_ATTACHMENT);
                } else {
                    builder.c(Item.PAYMENT_STATUS);
                }
            }
            if (invoicesSummaryModel.f14253f.isPresent()) {
                builder.c(Item.SHIPPING_FULFILLMENT);
            }
            invoicesSummaryAdapter.f14210d = builder.b();
            invoicesSummaryAdapter.notifyDataSetChanged();
            this.f14221a.f14225d.m14683b();
            if (this.f14221a.f14227f != null) {
                this.f14221a.f14227f.mo313a();
            }
        }

        protected final void m14681a(Throwable th) {
            this.f14221a.f14225d.m14683b();
            if (this.f14221a.f14227f != null) {
                this.f14221a.f14227f.mo314b();
            }
        }
    }

    @Inject
    public InvoicesSummaryPresenter(InvoiceSummaryFetcher invoiceSummaryFetcher, InvoicesSummaryAdapter invoicesSummaryAdapter, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted InvoicesSummaryView invoicesSummaryView, @Assisted String str) {
        this.f14222a = invoiceSummaryFetcher;
        this.f14223b = invoicesSummaryAdapter;
        this.f14224c = abstractFbErrorReporter;
        this.f14225d = invoicesSummaryView;
        this.f14226e = str;
        this.f14225d.f14229a.setAdapter(invoicesSummaryAdapter);
        this.f14225d.f14230b.setDisplayedChild(0);
        this.f14222a.m14629a(this.f14226e, this.f14228g);
    }
}
