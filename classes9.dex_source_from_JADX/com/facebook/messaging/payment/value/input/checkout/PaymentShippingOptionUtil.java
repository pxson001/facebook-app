package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentShippingOption;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

/* compiled from: enableBuiltInNS(%b) */
public class PaymentShippingOptionUtil {
    public static ImmutableList<ShippingOption> m15977a(List<PaymentShippingOption> list) {
        Builder builder = new Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            builder.c(m15976a((PaymentShippingOptionModel) it.next()));
        }
        return builder.b();
    }

    public static ShippingOption m15976a(PaymentShippingOptionModel paymentShippingOptionModel) {
        return new MessengerCommerceShippingOption(paymentShippingOptionModel);
    }
}
