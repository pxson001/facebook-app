package com.facebook.tigon.tigonliger;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: networkStatusDidChange */
public class TigonLigerCrashReporter {
    private final AbstractFbErrorReporter f5080a;

    public static TigonLigerCrashReporter m6366b(InjectorLike injectorLike) {
        return new TigonLigerCrashReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public TigonLigerCrashReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5080a = abstractFbErrorReporter;
    }

    @DoNotStrip
    public void crashReport(String str, Throwable th) {
        this.f5080a.a("Tigon: " + (th == null ? str : th.getClass().getSimpleName()), str, th, 1);
    }

    public static TigonLigerCrashReporter m6365a(InjectorLike injectorLike) {
        return m6366b(injectorLike);
    }
}
