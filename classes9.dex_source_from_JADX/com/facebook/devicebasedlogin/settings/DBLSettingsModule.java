package com.facebook.devicebasedlogin.settings;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.katana.annotations.DBLLoginSettingsFragmentName;

@InjectorModule
/* compiled from: The field 'type' has been assigned the invalid value  */
public class DBLSettingsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DBLLoginSettingsFragmentName
    public static String m26168a() {
        return DBLLoginSettingsAccountsListFragment.class.getName();
    }
}
