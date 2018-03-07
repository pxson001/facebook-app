package com.facebook.messaging.payment.value.input;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentShippingOption;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: expire_year */
public class MCMessengerPayViewParamsBuilder {
    public MessengerPayState f15380a;
    public Optional<PaymentMethod> f15381b;
    public List<PaymentShippingOption> f15382c;
    public Optional<PaymentShippingOption> f15383d;
    public ImmutableList<MailingAddress> f15384e;
    public Optional<MailingAddress> f15385f;
    public PaymentPlatformItemModel f15386g;
}
