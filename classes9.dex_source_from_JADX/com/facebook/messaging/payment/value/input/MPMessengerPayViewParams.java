package com.facebook.messaging.payment.value.input;

import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: existing_fbid */
public class MPMessengerPayViewParams implements MessengerPayViewParams {
    public final MessengerPayState f15427a;
    @Nullable
    public Optional<PaymentMethod> f15428b;
    public final MoneyPennyItemParams f15429c;

    public MPMessengerPayViewParams(MPMessengerPayViewParamsBuilder mPMessengerPayViewParamsBuilder) {
        this.f15427a = mPMessengerPayViewParamsBuilder.f15430a;
        this.f15428b = mPMessengerPayViewParamsBuilder.f15431b;
        this.f15429c = mPMessengerPayViewParamsBuilder.f15432c;
    }
}
