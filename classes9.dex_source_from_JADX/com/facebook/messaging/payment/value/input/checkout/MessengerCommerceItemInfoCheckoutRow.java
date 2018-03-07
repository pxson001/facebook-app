package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.MerchantLogoModel;
import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import javax.annotation.Nullable;

/* compiled from: encrypted_attachments */
public class MessengerCommerceItemInfoCheckoutRow implements CheckoutRow {
    @Nullable
    public final MerchantLogoModel f15778a;
    public final SingleItemInfoViewParams f15779b;

    public MessengerCommerceItemInfoCheckoutRow(MerchantLogoModel merchantLogoModel, SingleItemInfoViewParams singleItemInfoViewParams) {
        this.f15778a = merchantLogoModel;
        this.f15779b = singleItemInfoViewParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.SINGLE_ITEM_INFO;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return false;
    }
}
