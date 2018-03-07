package com.facebook.base.broadcast;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.HandlerListeningExecutorServiceImpl;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: uk */
public class BroadcastModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @BackgroundBroadcastThread
    public static Looper m4115a(FbHandlerThreadFactory fbHandlerThreadFactory) {
        HandlerThread a = fbHandlerThreadFactory.m3580a("BackgroundBroadcastHandler", ThreadPriority.NORMAL);
        a.start();
        return a.getLooper();
    }

    @ProviderMethod
    @Singleton
    @BackgroundBroadcastThread
    public static Handler m4114a(Looper looper) {
        return new Handler(looper);
    }

    @ProviderMethod
    @Singleton
    @BackgroundBroadcastThread
    public static ListeningScheduledExecutorService m4116a(Handler handler) {
        return new HandlerListeningExecutorServiceImpl(handler);
    }
}
