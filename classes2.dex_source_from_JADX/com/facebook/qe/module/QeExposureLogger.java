package com.facebook.qe.module;

import com.facebook.abtest.qe.log.QuickExperimentLogger;
import com.facebook.abtest.qe.log.QuickExperimentLogger.LoggingChannel;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: unsubscribee_id */
public class QeExposureLogger {
    final QuickExperimentLogger f1858a;

    @Inject
    public QeExposureLogger(QuickExperimentLogger quickExperimentLogger) {
        this.f1858a = quickExperimentLogger;
    }

    public static QeExposureLogger m3755b(InjectorLike injectorLike) {
        return new QeExposureLogger(QuickExperimentLogger.m3771a(injectorLike));
    }

    public final void m3756a(boolean z, String str, String str2) {
        this.f1858a.m3779a(z, str, str2, LoggingChannel.MARAUDER, "QuickerExperiment", null);
    }
}
