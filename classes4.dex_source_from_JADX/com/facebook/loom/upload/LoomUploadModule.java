package com.facebook.loom.upload;

import android.content.Context;
import android.os.Process;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.loom.core.BackgroundUploadService;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@InjectorModule
/* compiled from: getOnMessenger */
public class LoomUploadModule extends AbstractLibraryModule {

    /* compiled from: getOnMessenger */
    final class C05271 implements ThreadFactory {
        C05271() {
        }

        public final Thread newThread(Runnable runnable) {
            Thread a = ThreadInitDetour.a(runnable, 478560035);
            a.setName("Loom-Upload");
            Process.setThreadPriority(10);
            return a;
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static BackgroundUploadService m11580a(BackgroundUploadServiceImplProvider backgroundUploadServiceImplProvider) {
        return new BackgroundUploadServiceImpl(new UploadConstraints((Context) backgroundUploadServiceImplProvider.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(backgroundUploadServiceImplProvider), IdBasedProvider.a(backgroundUploadServiceImplProvider, 640)), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(backgroundUploadServiceImplProvider), Executors.newSingleThreadExecutor(new C05271()), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(backgroundUploadServiceImplProvider), LoomUploadMethod.m11598a((InjectorLike) backgroundUploadServiceImplProvider));
    }
}
