package com.facebook.messaging.payment.util;

import com.facebook.common.time.Clock;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: extra_uri */
public class PaymentUrlHelper {
    public Clock f15171a;
    public final Random f15172b = new Random();

    @Inject
    public PaymentUrlHelper(Clock clock) {
        this.f15171a = clock;
    }
}
