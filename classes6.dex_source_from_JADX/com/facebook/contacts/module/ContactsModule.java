package com.facebook.contacts.module;

import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: participants_added */
public class ContactsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ContactLinkQueryType
    @ProviderMethod
    static ContactLinkType m12114a(Boolean bool) {
        return bool.booleanValue() ? ContactLinkType.USER_CONTACT : ContactLinkType.FRIEND;
    }
}
