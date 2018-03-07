package com.facebook.messaging.payment.awareness;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: invite_all */
public class DefaultPaymentAwarenessViewParams {
    public final String f12789a;
    @Nullable
    public final String f12790b;
    public final PaymentAwarenessRow f12791c;
    public final PaymentAwarenessRow f12792d;
    public final PaymentAwarenessRow f12793e;
    public final int f12794f;
    public final int f12795g;

    public static DefaultPaymentAwarenessViewParamsBuilder newBuilder() {
        return new DefaultPaymentAwarenessViewParamsBuilder();
    }

    public DefaultPaymentAwarenessViewParams(DefaultPaymentAwarenessViewParamsBuilder defaultPaymentAwarenessViewParamsBuilder) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(defaultPaymentAwarenessViewParamsBuilder.f12796a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(defaultPaymentAwarenessViewParamsBuilder.f12798c);
        Preconditions.checkNotNull(defaultPaymentAwarenessViewParamsBuilder.f12799d);
        Preconditions.checkNotNull(defaultPaymentAwarenessViewParamsBuilder.f12800e);
        if (defaultPaymentAwarenessViewParamsBuilder.f12801f != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (defaultPaymentAwarenessViewParamsBuilder.f12802g == 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f12789a = defaultPaymentAwarenessViewParamsBuilder.f12796a;
        this.f12790b = defaultPaymentAwarenessViewParamsBuilder.f12797b;
        this.f12791c = defaultPaymentAwarenessViewParamsBuilder.f12798c;
        this.f12792d = defaultPaymentAwarenessViewParamsBuilder.f12799d;
        this.f12793e = defaultPaymentAwarenessViewParamsBuilder.f12800e;
        this.f12794f = defaultPaymentAwarenessViewParamsBuilder.f12801f;
        this.f12795g = defaultPaymentAwarenessViewParamsBuilder.f12802g;
    }
}
