package com.facebook.common.idleexecutor;

import android.annotation.SuppressLint;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.SingleThreadedExecutorService;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.ExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: user_message */
public class IdleExecutorModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @DefaultIdleExecutor
    static DefaultProcessIdleExecutor m2730a(IdleExecutorFactory idleExecutorFactory, ExecutorService executorService) {
        return idleExecutorFactory.m2728a(executorService);
    }

    @ProviderMethod
    @Singleton
    @SingleThreadedExecutorService
    static DefaultProcessIdleExecutor m2731b(IdleExecutorFactory idleExecutorFactory, ExecutorService executorService) {
        return idleExecutorFactory.m2728a(executorService);
    }

    @ProviderMethod
    @SuppressLint({"ExplicitSimpleProvider"})
    @DefaultIdleExecutor
    static DefaultSerialListeningExecutorService m2729a(DefaultProcessIdleExecutor defaultProcessIdleExecutor, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return new DefaultSerialListeningExecutorService(defaultProcessIdleExecutor, backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    @ProviderMethod
    @ForUiThread
    static DefaultProcessIdleExecutor m2732c(IdleExecutorFactory idleExecutorFactory, ExecutorService executorService) {
        return idleExecutorFactory.m2728a(executorService);
    }
}
