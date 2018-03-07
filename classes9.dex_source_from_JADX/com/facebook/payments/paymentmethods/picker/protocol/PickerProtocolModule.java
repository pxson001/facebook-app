package com.facebook.payments.paymentmethods.picker.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: bindComponent for  */
public class PickerProtocolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PickerProtocolQueue
    @UserScoped
    static BlueServiceHandler m18863a(PickerWebServiceHandler pickerWebServiceHandler) {
        return new FilterChainLink(pickerWebServiceHandler, new TerminatingHandler());
    }
}
