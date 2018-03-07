package com.facebook.common.process;

import android.os.Process;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: video_broadcast_update_type */
public class ProcessModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MyProcessId
    public static Integer m2433a() {
        return Integer.valueOf(Process.myPid());
    }

    @ProviderMethod
    static ProcessName m2432a(DefaultProcessUtil defaultProcessUtil) {
        return defaultProcessUtil.m2389a();
    }
}
