package com.facebook.payments.checkout.recyclerview;

import android.support.annotation.StringRes;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: cannot swap buffers! */
public class PayButtonCheckoutRow implements CheckoutRow {
    public final State f18534a;
    @StringRes
    public final int f18535b;

    @Immutable
    /* compiled from: cannot swap buffers! */
    public enum State {
        INIT,
        READY_FOR_PAYMENT,
        PROCESSING_PAYMENT,
        PAYMENT_COMPLETED
    }

    public PayButtonCheckoutRow(State state, @StringRes int i) {
        this.f18534a = state;
        this.f18535b = i;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.PAY_BUTTON;
    }

    public final boolean mo636b() {
        return true;
    }

    public final boolean mo637c() {
        return false;
    }
}
