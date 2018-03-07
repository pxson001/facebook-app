package com.facebook.common.errorreporting;

import com.facebook.acra.ErrorReporter;
import java.util.Map;

/* compiled from: sticker_media_gallery_promotion */
public class FbErrorReporterImpl$4 implements Runnable {
    final /* synthetic */ String f2531a;
    final /* synthetic */ int f2532b;
    final /* synthetic */ Map f2533c;
    final /* synthetic */ String f2534d;
    final /* synthetic */ FbErrorReporterImpl f2535e;

    public FbErrorReporterImpl$4(FbErrorReporterImpl fbErrorReporterImpl, String str, int i, Map map, String str2) {
        this.f2535e = fbErrorReporterImpl;
        this.f2531a = str;
        this.f2532b = i;
        this.f2533c = map;
        this.f2534d = str2;
    }

    public void run() {
        String a = FbErrorReporterImpl.a(this.f2535e, this.f2531a, this.f2532b, false);
        if (a != null) {
            try {
                this.f2533c.put("runtime_linter_message", this.f2534d);
                this.f2533c.put("runtime_linter_category", a);
                ((ErrorReporter) this.f2535e.g.get()).handleException(new RuntimeLinterException(this.f2534d), null, this.f2533c);
            } catch (Throwable th) {
            }
        }
    }
}
