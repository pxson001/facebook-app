package com.facebook.prefs.light;

import android.content.Context;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory.Builder;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.ExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: verified_proxy_address */
public class LightSharedPreferencesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static LightSharedPreferencesFactory m2547a(Context context, ExecutorService executorService) {
        Builder builder = new Builder(context);
        builder.f1302b = executorService;
        return builder.m2548a();
    }
}
