package com.facebook.contacts.upload;

import com.facebook.auth.annotations.NeedPrivilegedUserInfo;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: tapped_follow_button */
public class ContactsUploadModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @NeedPrivilegedUserInfo
    static Boolean m2091a() {
        return Boolean.valueOf(true);
    }
}
