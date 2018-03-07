package com.facebook.messaging.payment.prefs.receipts.manual;

import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ModelToItemsConverter.Item;
import com.facebook.messaging.payment.prefs.receipts.manual.model.PaymentStatusModelAdapter;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ShippingAddressModelAdapter;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ShippingFulfillmentModelAdapter;
import com.facebook.messaging.payment.prefs.receipts.manual.model.ShippingMethodModelAdapter;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.BasicReceiptSummaryBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PaymentStatusWithAttachmentBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PaymentStatusWithAttachmentBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PriceBreakdownBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.PriceBreakdownBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductItemViewBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductItemViewBindableProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductQuantityBindable;
import com.facebook.messaging.payment.prefs.receipts.manual.ui.ProductQuantityBindableProvider;
import javax.inject.Inject;

/* compiled from: getInstance */
public class InvoicesSummaryBindableFactory {
    private final ProductItemViewBindableProvider f14212a;
    private final PriceBreakdownBindableProvider f14213b;
    private final BasicReceiptSummaryBindableProvider f14214c;
    private final ProductQuantityBindableProvider f14215d;
    private final PaymentStatusWithAttachmentBindableProvider f14216e;

    @Inject
    public InvoicesSummaryBindableFactory(ProductItemViewBindableProvider productItemViewBindableProvider, PriceBreakdownBindableProvider priceBreakdownBindableProvider, BasicReceiptSummaryBindableProvider basicReceiptSummaryBindableProvider, ProductQuantityBindableProvider productQuantityBindableProvider, PaymentStatusWithAttachmentBindableProvider paymentStatusWithAttachmentBindableProvider) {
        this.f14212a = productItemViewBindableProvider;
        this.f14213b = priceBreakdownBindableProvider;
        this.f14214c = basicReceiptSummaryBindableProvider;
        this.f14215d = productQuantityBindableProvider;
        this.f14216e = paymentStatusWithAttachmentBindableProvider;
    }

    public final InvoicesSummaryBindable m14666a(ViewGroup viewGroup, int i) {
        Item itemFromViewType = Item.getItemFromViewType(i);
        switch (itemFromViewType) {
            case PRODUCT_ITEM:
                return new ProductItemViewBindable(viewGroup);
            case PRICE_BREAKDOWN:
                return new PriceBreakdownBindable(viewGroup);
            case PAYMENT_STATUS:
                return this.f14214c.m14699a(viewGroup, new PaymentStatusModelAdapter(viewGroup.getContext()));
            case PAYMENT_STATUS_WITH_ATTACHMENT:
                return new PaymentStatusWithAttachmentBindable(LayoutInflaterMethodAutoProvider.b(this.f14216e), viewGroup);
            case SHIPPING_ADDRESS:
                return this.f14214c.m14699a(viewGroup, new ShippingAddressModelAdapter(viewGroup.getContext()));
            case SHIPPING_METHOD:
                return this.f14214c.m14699a(viewGroup, new ShippingMethodModelAdapter(viewGroup.getContext()));
            case SHIPPING_FULFILLMENT:
                return this.f14214c.m14699a(viewGroup, new ShippingFulfillmentModelAdapter(viewGroup.getContext()));
            case QUANTITY:
                return new ProductQuantityBindable(LayoutInflaterMethodAutoProvider.b(this.f14215d), viewGroup);
            default:
                throw new UnsupportedOperationException("Item of type " + itemFromViewType.toString() + " not implemented");
        }
    }
}
