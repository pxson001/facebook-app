package com.facebook.messaging.payment.value.input.checkout;

import android.content.Context;
import android.content.Intent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.MessengerPayType;
import com.facebook.payments.checkout.CheckoutActivity;
import com.facebook.payments.checkout.CheckoutCommonParams;
import com.facebook.payments.checkout.CheckoutCommonParams.Builder;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.model.PaymentItemType;
import javax.inject.Inject;

/* compiled from: enableMMS */
public class MessengerPayCheckoutIntentHelper {
    public final GatekeeperStoreImpl f15784a;
    public final PaymentCurrencyUtil f15785b;

    public static MessengerPayCheckoutIntentHelper m15974b(InjectorLike injectorLike) {
        return new MessengerPayCheckoutIntentHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public MessengerPayCheckoutIntentHelper(GatekeeperStoreImpl gatekeeperStoreImpl, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15784a = gatekeeperStoreImpl;
        this.f15785b = paymentCurrencyUtil;
    }

    public final Intent m15975a(Context context, String str) {
        if (this.f15784a.a(896, false)) {
            Builder newBuilder = CheckoutCommonParams.newBuilder();
            newBuilder.f18454a = CheckoutStyle.MESSENGER_COMMERCE;
            newBuilder = newBuilder;
            newBuilder.f18455b = PaymentItemType.MESSENGER_COMMERCE;
            CheckoutCommonParams f = newBuilder.m18461f();
            MessengerCommerceCheckoutParamsBuilder messengerCommerceCheckoutParamsBuilder = new MessengerCommerceCheckoutParamsBuilder();
            messengerCommerceCheckoutParamsBuilder.f15760a = f;
            MessengerCommerceCheckoutParamsBuilder messengerCommerceCheckoutParamsBuilder2 = messengerCommerceCheckoutParamsBuilder;
            messengerCommerceCheckoutParamsBuilder2.f15761b = str;
            return CheckoutActivity.m18455a(context, (CheckoutParams) new MessengerCommerceCheckoutParams(messengerCommerceCheckoutParamsBuilder2));
        }
        Intent intent = new Intent(context, EnterPaymentValueActivity.class);
        intent.putExtra("messenger_pay_type", MessengerPayType.MC);
        intent.putExtra("item_id", str);
        return intent;
    }
}
