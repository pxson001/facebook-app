package com.facebook.katana.util;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: sum_sample_value */
public class Fb4aUtilsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static FqlQueryBuilderUtils m1785a() {
        return new FqlQueryBuilderUtils();
    }
}
