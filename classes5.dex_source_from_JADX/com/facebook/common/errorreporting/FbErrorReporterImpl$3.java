package com.facebook.common.errorreporting;

import com.facebook.acra.ErrorReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: sticker_media_gallery_promotion */
class FbErrorReporterImpl$3 implements Runnable {
    final /* synthetic */ String f2527a;
    final /* synthetic */ String f2528b;
    final /* synthetic */ String f2529c;
    final /* synthetic */ FbErrorReporterImpl f2530d;

    FbErrorReporterImpl$3(FbErrorReporterImpl fbErrorReporterImpl, String str, String str2, String str3) {
        this.f2530d = fbErrorReporterImpl;
        this.f2527a = str;
        this.f2528b = str2;
        this.f2529c = str3;
    }

    public void run() {
        String a = FbErrorReporterImpl.a(this.f2530d, this.f2527a, 1, false);
        if (a != null) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("strict_mode_message", this.f2528b);
                hashMap.put("strict_mode_category", a);
                ((ErrorReporter) this.f2530d.g.get()).handleException(new StrictModeException(this.f2528b), this.f2529c, hashMap);
            } catch (Throwable th) {
            }
        }
    }
}
