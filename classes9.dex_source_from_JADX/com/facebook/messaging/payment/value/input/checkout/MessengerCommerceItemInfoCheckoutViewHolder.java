package com.facebook.messaging.payment.value.input.checkout;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.MerchantLogoModel;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: encodeURIComponent( */
public class MessengerCommerceItemInfoCheckoutViewHolder extends PaymentsComponentViewHolder<MessengerCommerceItemInfoCheckoutView, MessengerCommerceItemInfoCheckoutRow> {
    public final void m15968a(PaymentsComponentRow paymentsComponentRow) {
        MessengerCommerceItemInfoCheckoutRow messengerCommerceItemInfoCheckoutRow = (MessengerCommerceItemInfoCheckoutRow) paymentsComponentRow;
        MessengerCommerceItemInfoCheckoutView messengerCommerceItemInfoCheckoutView = (MessengerCommerceItemInfoCheckoutView) this.a;
        MerchantLogoModel merchantLogoModel = messengerCommerceItemInfoCheckoutRow.f15778a;
        if (merchantLogoModel == null || StringUtil.a(merchantLogoModel.m13769a())) {
            messengerCommerceItemInfoCheckoutView.f15781b.setVisibility(8);
        } else {
            messengerCommerceItemInfoCheckoutView.f15781b.a(Uri.parse(merchantLogoModel.m13769a()), MessengerCommerceItemInfoCheckoutView.f15780a);
            messengerCommerceItemInfoCheckoutView.f15781b.setVisibility(0);
        }
        messengerCommerceItemInfoCheckoutView.setSingleItemInfoViewParams(messengerCommerceItemInfoCheckoutRow.f15779b);
    }

    public MessengerCommerceItemInfoCheckoutViewHolder(MessengerCommerceItemInfoCheckoutView messengerCommerceItemInfoCheckoutView) {
        super(messengerCommerceItemInfoCheckoutView);
    }

    public final void m15969a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}
