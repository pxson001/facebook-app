package com.facebook.adspayments.controller;

import android.content.res.Resources;
import android.view.View;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.validation.SecurityCodeInputValidator;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.resources.ui.FbEditText;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Unable to create program */
public class CardFormSecurityCodeInputController extends SecurityCodeInputController {
    private FbEditText f23653c;

    public static CardFormSecurityCodeInputController m25647b(InjectorLike injectorLike) {
        return new CardFormSecurityCodeInputController(SecurityCodeFormattingTextWatcher.a(injectorLike), SecurityCodeInputValidator.m25766a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), PaymentsQeAccessor.m25554a(injectorLike));
    }

    @Inject
    public CardFormSecurityCodeInputController(SecurityCodeFormattingTextWatcher securityCodeFormattingTextWatcher, SecurityCodeInputValidator securityCodeInputValidator, Resources resources, ExecutorService executorService, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(securityCodeFormattingTextWatcher, securityCodeInputValidator, resources, executorService, adsPaymentsExperimentsHelper, paymentsQeAccessor);
    }

    protected final void mo1088a(View view) {
        this.f23653c = (FbEditText) view.findViewById(2131565786);
        super.mo1088a(view);
    }

    protected final FbPaymentCardType mo1094e() {
        return PaymentMethodInputFormattingUtils.a(this.f23653c.getText().toString());
    }
}
