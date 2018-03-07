package com.facebook.messaging.payment.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: fragment_state */
public class PaymentProtocolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @PaymentQueue
    static BlueServiceHandler m14936a(PaymentCacheServiceHandler paymentCacheServiceHandler, PaymentDbServiceHandler paymentDbServiceHandler, PaymentWebServiceHandler paymentWebServiceHandler) {
        return new FilterChainLink(paymentCacheServiceHandler, new FilterChainLink(paymentDbServiceHandler, new FilterChainLink(paymentWebServiceHandler, new TerminatingHandler())));
    }
}
