package com.facebook.content;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: sent_text */
public class ContentModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static SecureContextHelper getInstanceForTest_SecureContextHelper(FbInjector fbInjector) {
        return (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
    }
}
