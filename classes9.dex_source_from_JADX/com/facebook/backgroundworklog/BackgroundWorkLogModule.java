package com.facebook.backgroundworklog;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: select_shipping_option_dialog */
public class BackgroundWorkLogModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
        binderImpl.a(BackgroundWorkRecorder.class).a(new BackgroundWorkRecorderAutoProvider()).c(Singleton.class);
        binderImpl.a(DumpBackgroundWorkLogger.class).a(new DumpBackgroundWorkLoggerAutoProvider()).c(Singleton.class);
        binderImpl.d(DumpStatsCollectorProvider.class);
    }

    public static BackgroundWorkRecorder getInstanceForTest_BackgroundWorkRecorder(FbInjector fbInjector) {
        return (BackgroundWorkRecorder) fbInjector.getInstance(BackgroundWorkRecorder.class);
    }
}
