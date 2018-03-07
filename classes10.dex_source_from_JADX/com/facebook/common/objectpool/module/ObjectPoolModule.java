package com.facebook.common.objectpool.module;

import android.graphics.Rect;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.objectpool.ObjectPoolManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: convertInboxV2QueryModel */
public class ObjectPoolModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static ObjectPoolManager m16292a(MonotonicClock monotonicClock) {
        ObjectPoolManager objectPoolManager = new ObjectPoolManager(monotonicClock);
        new ObjectPoolBuilder(objectPoolManager, Rect.class, objectPoolManager.b).a();
        return objectPoolManager;
    }
}
