package com.facebook.backstage;

import com.facebook.auth.annotations.IsFirstPartySsoEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: select_address_dialog */
public class BackstageModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsFirstPartySsoEnabled
    @ProviderMethod
    static Boolean m4254a() {
        return Boolean.valueOf(true);
    }
}
