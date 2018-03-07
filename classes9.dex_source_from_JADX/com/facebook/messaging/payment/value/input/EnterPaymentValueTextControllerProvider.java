package com.facebook.messaging.payment.value.input;

import android.content.Context;
import com.facebook.common.android.VibratorMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.util.PaymentsSoundUtil;
import com.facebook.messaging.payment.utils.PaymentTextUtils;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueTextController.Listener;

/* compiled from: extra_custom_subtitle */
public class EnterPaymentValueTextControllerProvider extends AbstractAssistedProvider<EnterPaymentValueTextController> {
    public final EnterPaymentValueTextController m15673a(Listener listener) {
        return new EnterPaymentValueTextController(listener, (Context) getInstance(Context.class), PaymentViewUtil.m15542b(this), PaymentTextUtils.m15538b(this), new PaymentValueFormattingTextWatcher(PaymentCurrencyUtil.m13192a((InjectorLike) this)), PaymentsSoundUtil.m15530b(this), VibratorMethodAutoProvider.b(this));
    }
}
