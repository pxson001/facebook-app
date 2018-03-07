package com.facebook.contacts.background;

import com.facebook.contacts.annotations.IsAddressBookSyncEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: enabled_notification_listeners */
public class ContactsBackgroundModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAddressBookSyncEnabled
    public static Boolean m13924a() {
        return Boolean.valueOf(true);
    }
}
