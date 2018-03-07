package com.facebook.messaging.payment.prefs.receipts.manual;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ModelToItemsConverter;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ModelToItemsConverter.Item;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.BasicReceiptSummaryBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PaymentStatusWithAttachmentBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PriceBreakdownBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductItemViewBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductQuantityBindableProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: getMobileDataEnabled */
public class InvoicesSummaryAdapter extends Adapter<InvoicesSummaryViewHolder> {
    private final ModelToItemsConverter f14207a;
    private final InvoicesSummaryBindableFactory f14208b;
    public InvoicesSummaryModel f14209c;
    public ImmutableList<Item> f14210d = RegularImmutableList.a;

    /* compiled from: getMobileDataEnabled */
    public class InvoicesSummaryViewHolder extends ViewHolder {
        public final InvoicesSummaryBindable f14206l;

        public InvoicesSummaryViewHolder(InvoicesSummaryBindable invoicesSummaryBindable) {
            super(invoicesSummaryBindable.mo560a());
            this.f14206l = invoicesSummaryBindable;
        }
    }

    public static InvoicesSummaryAdapter m14661b(InjectorLike injectorLike) {
        return new InvoicesSummaryAdapter(new ModelToItemsConverter(), new InvoicesSummaryBindableFactory((ProductItemViewBindableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProductItemViewBindableProvider.class), (PriceBreakdownBindableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PriceBreakdownBindableProvider.class), (BasicReceiptSummaryBindableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BasicReceiptSummaryBindableProvider.class), (ProductQuantityBindableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProductQuantityBindableProvider.class), (PaymentStatusWithAttachmentBindableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PaymentStatusWithAttachmentBindableProvider.class)));
    }

    public final void m14663a(ViewHolder viewHolder, int i) {
        InvoicesSummaryViewHolder invoicesSummaryViewHolder = (InvoicesSummaryViewHolder) viewHolder;
        invoicesSummaryViewHolder.f14206l.mo561a(this.f14209c);
    }

    @Inject
    public InvoicesSummaryAdapter(ModelToItemsConverter modelToItemsConverter, InvoicesSummaryBindableFactory invoicesSummaryBindableFactory) {
        this.f14207a = modelToItemsConverter;
        this.f14208b = invoicesSummaryBindableFactory;
    }

    public final ViewHolder m14662a(ViewGroup viewGroup, int i) {
        return new InvoicesSummaryViewHolder(this.f14208b.m14666a(viewGroup, i));
    }

    public final int aZ_() {
        return this.f14210d.size();
    }

    public int getItemViewType(int i) {
        return ((Item) this.f14210d.get(i)).getItemViewType();
    }
}
