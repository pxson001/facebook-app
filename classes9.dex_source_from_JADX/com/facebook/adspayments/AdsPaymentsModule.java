package com.facebook.adspayments;

import com.facebook.adspayments.protocol.PaymentsQueue;
import com.facebook.adspayments.protocol.PaymentsWebServiceHandler;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: Unable to write to file  */
public class AdsPaymentsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @PaymentsQueue
    static BlueServiceHandler m25465a(PaymentsWebServiceHandler paymentsWebServiceHandler) {
        return new FilterChainLink(paymentsWebServiceHandler, new TerminatingHandler());
    }
}
