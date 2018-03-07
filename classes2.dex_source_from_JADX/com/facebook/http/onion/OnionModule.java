package com.facebook.http.onion;

import com.facebook.http.onion.impl.FbTorProxyFactory;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: unknown image format */
public class OnionModule extends AbstractLibraryModule {
    private static boolean f1950a = false;
    private static boolean f1951b = false;

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static TorProxy m3889a(Lazy<TorProxyFactory> lazy, Lazy<OrbotFinder> lazy2) {
        if (!f1950a) {
            f1951b = ((OrbotFinder) lazy2.get()).m3892a();
            f1950a = true;
        }
        if (f1951b) {
            return ((FbTorProxyFactory) lazy.get()).a;
        }
        return new DefaultTorProxy();
    }
}
