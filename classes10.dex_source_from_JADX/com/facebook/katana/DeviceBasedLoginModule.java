package com.facebook.katana;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.katana.annotations.DBLFragment;

@InjectorModule
/* compiled from: SEEN_HEADS */
public class DeviceBasedLoginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DBLFragment
    static String m25487a() {
        return DeviceBasedLoginAccountsListFragment.class.getName();
    }
}
