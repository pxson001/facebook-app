package com.facebook.payments.paymentmethods.cardform.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: tabBarSelectedIndex */
public class CardFormProtocolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @CardFormProtocolQueue
    static BlueServiceHandler m2107a(CardFormWebServiceHandler cardFormWebServiceHandler) {
        return new FilterChainLink(cardFormWebServiceHandler, new TerminatingHandler());
    }
}
