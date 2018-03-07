package com.facebook.uberbar.module;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.uberbar.annotations.IsPageOnlyUberbarSearchEnabled;

@InjectorModule
/* compiled from: total_attachment_size */
public class UberbarModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPageOnlyUberbarSearchEnabled
    public static Boolean m1546a() {
        return Boolean.valueOf(false);
    }
}
