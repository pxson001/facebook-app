package com.facebook.payments.confirmation;

import android.content.Intent;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.base.Preconditions;

/* compiled from: callId */
public class SimpleConfirmationOnActivityResultHandler {
    public SimplePaymentsComponentCallback f18633a;

    public final void m18652a(SimpleConfirmationData simpleConfirmationData, int i, int i2, Intent intent) {
        simpleConfirmationData = simpleConfirmationData;
        Preconditions.checkNotNull(this.f18633a);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    simpleConfirmationData.f18628a.add(PostPurchaseActionType.ACTIVATE_SECURITY_PIN);
                    this.f18633a.a(new PaymentsComponentAction(Action.RESET));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
