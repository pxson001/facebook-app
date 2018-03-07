package com.facebook.messaging.payment.value.input;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentShippingOption;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: expiry_timestamp */
public class MCMessengerPayViewParams implements MessengerPayViewParams {
    public final MessengerPayState f15373a;
    @Nullable
    public final Optional<PaymentMethod> f15374b;
    @Nullable
    public final List<PaymentShippingOption> f15375c;
    @Nullable
    public final Optional<PaymentShippingOption> f15376d;
    @Nullable
    public final ImmutableList<MailingAddress> f15377e;
    @Nullable
    public final Optional<MailingAddress> f15378f;
    public final PaymentPlatformItemModel f15379g;

    public MCMessengerPayViewParams(MCMessengerPayViewParamsBuilder mCMessengerPayViewParamsBuilder) {
        this.f15373a = mCMessengerPayViewParamsBuilder.f15380a;
        this.f15374b = mCMessengerPayViewParamsBuilder.f15381b;
        this.f15375c = mCMessengerPayViewParamsBuilder.f15382c;
        this.f15376d = mCMessengerPayViewParamsBuilder.f15383d;
        this.f15377e = mCMessengerPayViewParamsBuilder.f15384e;
        this.f15378f = mCMessengerPayViewParamsBuilder.f15385f;
        this.f15379g = mCMessengerPayViewParamsBuilder.f15386g;
    }
}
