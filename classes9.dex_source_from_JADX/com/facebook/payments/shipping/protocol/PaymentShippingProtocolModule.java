package com.facebook.payments.shipping.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: backstage_cache */
public class PaymentShippingProtocolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @ShippingAddressProtocolQueue
    static BlueServiceHandler m19021a(ShippingAddressWebServiceHandler shippingAddressWebServiceHandler) {
        return new FilterChainLink(shippingAddressWebServiceHandler, new TerminatingHandler());
    }
}
