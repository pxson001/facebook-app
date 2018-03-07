package com.facebook.database.threadchecker;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: saved_for_later_products */
public class DbThreadCheckerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @AllowAnyThread
    @ProviderMethod
    static DbThreadChecker m10316a() {
        return new DbThreadCheckerAllowAnyThread();
    }
}
