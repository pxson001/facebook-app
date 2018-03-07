package com.facebook.sequencelogger;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: session */
public class SequenceLoggerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static SequenceLogger getInstanceForTest_SequenceLogger(FbInjector fbInjector) {
        return (SequenceLogger) SequenceLoggerImpl.a(fbInjector);
    }
}
