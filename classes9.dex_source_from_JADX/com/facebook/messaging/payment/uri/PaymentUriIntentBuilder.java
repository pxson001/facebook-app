package com.facebook.messaging.payment.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.payment.value.input.checkout.MessengerPayCheckoutIntentHelper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: f4c7e81c0a583a15ff822112c69c2d9a */
public class PaymentUriIntentBuilder extends UriIntentBuilder {
    public final MessengerPayCheckoutIntentHelper f15163a;
    public final Provider<Boolean> f15164b;

    /* compiled from: f4c7e81c0a583a15ff822112c69c2d9a */
    class PaymentViewUriIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ PaymentUriIntentBuilder f15162a;

        public PaymentViewUriIntentBuilder(PaymentUriIntentBuilder paymentUriIntentBuilder) {
            this.f15162a = paymentUriIntentBuilder;
        }

        public final Intent m15512a(Context context, Bundle bundle) {
            if (!((Boolean) this.f15162a.f15164b.get()).booleanValue() || bundle.get("product_item_id") == null) {
                return null;
            }
            return this.f15162a.f15163a.m15975a(context, Long.toString(bundle.getLong("product_item_id")));
        }
    }

    @Inject
    public PaymentUriIntentBuilder(MessengerPayCheckoutIntentHelper messengerPayCheckoutIntentHelper, Provider<Boolean> provider) {
        this.f15163a = messengerPayCheckoutIntentHelper;
        this.f15164b = provider;
        a(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.t, "product_item_id"), new PaymentViewUriIntentBuilder(this));
    }
}
