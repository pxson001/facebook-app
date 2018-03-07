package com.facebook.fbreact.abtest;

import android.os.Build.VERSION;
import com.facebook.fbreact.annotations.IsFb4aReactNativeEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: respond_to_region_tos */
public class FbReactAbTestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsFb4aReactNativeEnabled
    public static Boolean m11580a(Provider<Boolean> provider) {
        if (VERSION.SDK_INT <= 15) {
            return Boolean.valueOf(false);
        }
        return (Boolean) provider.get();
    }
}
