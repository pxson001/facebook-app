package com.facebook.tigon.httpclientadapter;

import android.util.Log;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: noteID */
public class TigonHttpClientAdapterModule extends AbstractLibraryModule {
    public static final boolean f4961a = Log.isLoggable("TigonHttpClientAdapter", 3);
    public static final boolean f4962b = Log.isLoggable("TigonHttpClientAdapter", 2);

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @ResponseHandlerThreadPool
    static Executor m6240a() {
        return Executors.newCachedThreadPool();
    }
}
