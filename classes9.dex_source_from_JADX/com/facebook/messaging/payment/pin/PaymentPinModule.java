package com.facebook.messaging.payment.pin;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.payment.pin.protocol.PaymentPinDbServiceHandler;
import com.facebook.messaging.payment.pin.protocol.PaymentPinQueue;
import com.facebook.messaging.payment.pin.protocol.PaymentPinWebServiceHandler;

@InjectorModule
/* compiled from: has_authorized */
public class PaymentPinModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PaymentPinQueue
    @UserScoped
    static BlueServiceHandler m14183a(PaymentPinDbServiceHandler paymentPinDbServiceHandler, PaymentPinWebServiceHandler paymentPinWebServiceHandler) {
        return new FilterChainLink(paymentPinDbServiceHandler, new FilterChainLink(paymentPinWebServiceHandler, new TerminatingHandler()));
    }
}
