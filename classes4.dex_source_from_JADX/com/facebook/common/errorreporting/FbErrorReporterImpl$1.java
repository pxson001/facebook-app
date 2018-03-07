package com.facebook.common.errorreporting;

import com.facebook.acra.ErrorReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: primary_email */
class FbErrorReporterImpl$1 implements Runnable {
    final /* synthetic */ SoftError f4231a;
    final /* synthetic */ String f4232b;
    final /* synthetic */ Throwable f4233c;
    final /* synthetic */ FbErrorReporterImpl f4234d;

    FbErrorReporterImpl$1(FbErrorReporterImpl fbErrorReporterImpl, SoftError softError, String str, Throwable th) {
        this.f4234d = fbErrorReporterImpl;
        this.f4231a = softError;
        this.f4232b = str;
        this.f4233c = th;
    }

    public void run() {
        String d = FbErrorReporterImpl.d(this.f4234d, this.f4231a);
        if (d != null) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("soft_error_category", d);
                hashMap.put("soft_error_message", this.f4232b);
                ((ErrorReporter) this.f4234d.g.get()).handleException(this.f4233c, hashMap);
            } catch (Throwable th) {
                if (!this.f4234d.h) {
                    return;
                }
                if (th instanceof Error) {
                    Error error = (Error) th;
                } else if (th instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) th;
                } else {
                    RuntimeException runtimeException2 = new RuntimeException(th);
                }
            }
        }
    }
}
