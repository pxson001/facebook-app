package com.facebook.common.errorreporting;

import com.facebook.common.executors.NamedThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: video_debug_mode */
public class ErrorReportingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @ErrorReportingSingleThreadExecutor
    static ExecutorService m2357a() {
        return new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("ErrorReportingThread-", ThreadPriority.FOREGROUND));
    }
}
