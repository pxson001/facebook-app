package com.facebook.adspayments.controller;

import android.content.res.Resources;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.validation.SecurityCodeInputValidator;
import com.facebook.inject.Assisted;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Unable to acquire db for markLastConferenceCallEnded */
public class StandaloneSecurityCodeInputController extends SecurityCodeInputController {
    public FbPaymentCardType f23676c;

    @Inject
    public StandaloneSecurityCodeInputController(@Assisted FbPaymentCardType fbPaymentCardType, SecurityCodeFormattingTextWatcher securityCodeFormattingTextWatcher, SecurityCodeInputValidator securityCodeInputValidator, Resources resources, ExecutorService executorService, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(securityCodeFormattingTextWatcher, securityCodeInputValidator, resources, executorService, adsPaymentsExperimentsHelper, paymentsQeAccessor);
        this.f23676c = fbPaymentCardType;
    }

    protected final FbPaymentCardType mo1094e() {
        return this.f23676c;
    }
}
