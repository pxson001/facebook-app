package com.facebook.messaging.payment.utils;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.prefs.verification.PaymentRiskVerificationActivity;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: extra_should_show_rationale */
public class PaymentRiskFlowHelper {
    private final SecureContextHelper f15181a;

    public static PaymentRiskFlowHelper m15536b(InjectorLike injectorLike) {
        return new PaymentRiskFlowHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public PaymentRiskFlowHelper(SecureContextHelper secureContextHelper) {
        this.f15181a = secureContextHelper;
    }

    public static boolean m15535a(SendPaymentMessageResult sendPaymentMessageResult) {
        return sendPaymentMessageResult.m15208c().equals("REQUIRE_VERIFICATION") || sendPaymentMessageResult.m15208c().equals("UNDER_MANUAL_REVIEW");
    }

    public final void m15537a(String str, String str2, Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Intent intent = new Intent(context, PaymentRiskVerificationActivity.class);
        intent.putExtra("transaction_id", str);
        intent.putExtra("recipient_id", str2);
        this.f15181a.a(intent, context);
    }
}
