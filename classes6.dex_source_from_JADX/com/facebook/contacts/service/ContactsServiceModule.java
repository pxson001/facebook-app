package com.facebook.contacts.service;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: oxygen_map_here_upsell_dialog_impression */
public class ContactsServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DynamicContactDataQueue
    public static BlueServiceHandler m12307a(DynamicContactDataLocalServiceHandler dynamicContactDataLocalServiceHandler, DynamicContactDataServiceHandler dynamicContactDataServiceHandler) {
        return new FilterChainLink(dynamicContactDataLocalServiceHandler, dynamicContactDataServiceHandler);
    }
}
