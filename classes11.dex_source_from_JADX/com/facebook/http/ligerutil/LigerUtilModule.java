package com.facebook.http.ligerutil;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: VisibleFriends */
public class LigerUtilModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static LigerCancellationExceptionDetectorImpl m10778a() {
        return new LigerCancellationExceptionDetectorImpl();
    }
}
