package com.facebook.webrtc;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: lat */
public class WebrtcCrashReporter {
    private final AbstractFbErrorReporter f9509a;

    public static WebrtcCrashReporter m9877b(InjectorLike injectorLike) {
        return new WebrtcCrashReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public WebrtcCrashReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9509a = abstractFbErrorReporter;
    }

    @DoNotStrip
    public void crashReport(String str, Throwable th) {
        this.f9509a.a("RtcJniException:" + str, th.toString(), th, 1);
    }

    @DoNotStrip
    public void crashReport(String str, String str2) {
        this.f9509a.a("RtcJniException:" + str, str2, 1);
    }
}
