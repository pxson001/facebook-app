package com.facebook.payments.contactinfo.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: broadcast_recipients */
public class ContactInfoProtocolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @ContactInfoProtocolQueue
    static BlueServiceHandler m18704a(ContactInfoWebServiceHandler contactInfoWebServiceHandler) {
        return new FilterChainLink(contactInfoWebServiceHandler, new TerminatingHandler());
    }
}
