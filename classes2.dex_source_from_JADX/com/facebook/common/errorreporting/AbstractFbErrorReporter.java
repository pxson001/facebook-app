package com.facebook.common.errorreporting;

import java.net.Proxy;
import java.util.Map;

/* compiled from: video_default_autoplay_setting_wifi_only */
public abstract class AbstractFbErrorReporter {
    public abstract void mo335a();

    public abstract void mo336a(SoftError softError);

    public abstract void mo337a(String str);

    public abstract void mo338a(String str, FbCustomReportDataSupplier fbCustomReportDataSupplier);

    public abstract void mo339a(String str, String str2, String str3);

    public abstract void mo340a(String str, String str2, Map<String, String> map);

    public abstract void mo341a(Proxy proxy);

    public abstract void mo342b();

    public abstract void mo343b(String str);

    public abstract void mo344c(String str);

    public abstract void mo345c(String str, String str2);

    public abstract void mo346d(String str);

    public final void m2340a(String str, String str2) {
        mo336a(SoftError.b(str, str2));
    }

    public final void m2343a(String str, String str2, Throwable th) {
        SoftErrorBuilder a = SoftError.a(str, str2);
        a.c = th;
        mo336a(a.g());
    }

    public final void m2346a(String str, Throwable th) {
        m2343a(str, th.getMessage(), th);
    }

    public final void m2344a(String str, String str2, Throwable th, int i) {
        SoftErrorBuilder a = SoftError.a(str, str2);
        a.c = th;
        a = a;
        a.e = i;
        mo336a(a.g());
    }

    public final void m2350b(String str, String str2) {
        SoftErrorBuilder a = SoftError.a(str, str2);
        a.d = true;
        mo336a(a.g());
    }

    public final void m2351b(String str, String str2, Throwable th) {
        SoftErrorBuilder a = SoftError.a(str, str2);
        a.d = true;
        a = a;
        a.c = th;
        mo336a(a.g());
    }

    public final void m2341a(String str, String str2, int i) {
        SoftErrorBuilder softErrorBuilder = new SoftErrorBuilder();
        softErrorBuilder.a = str;
        softErrorBuilder = softErrorBuilder;
        softErrorBuilder.b = str2;
        softErrorBuilder = softErrorBuilder;
        softErrorBuilder.e = i;
        mo336a(softErrorBuilder.g());
    }

    public final void m2352b(String str, Throwable th) {
        m2351b(str, th.getMessage(), th);
    }
}
