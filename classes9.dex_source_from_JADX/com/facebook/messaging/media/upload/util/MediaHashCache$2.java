package com.facebook.messaging.media.upload.util;

import com.facebook.common.util.Hex;
import com.facebook.debug.log.BLog;
import java.util.Locale;
import javax.crypto.Mac;

/* compiled from: lastUpdatedTimeMs= */
public class MediaHashCache$2 {
    public final /* synthetic */ Mac f12226a;
    final /* synthetic */ long f12227b;
    final /* synthetic */ MediaHashCache f12228c;
    public boolean f12229d = true;
    public long f12230e = 0;

    MediaHashCache$2(MediaHashCache mediaHashCache, Mac mac, long j) {
        this.f12228c = mediaHashCache;
        this.f12226a = mac;
        this.f12227b = j;
    }

    public final Object m12719a() {
        if (!this.f12229d && this.f12230e == this.f12227b) {
            return Hex.a(this.f12226a.doFinal(), false).toLowerCase(Locale.US);
        }
        BLog.a(MediaHashCache.a, "Read bytes failed. IsAllBytesZero: %b, TotalBytesRead: %d, FileSize: %d", new Object[]{Boolean.valueOf(this.f12229d), Long.valueOf(this.f12230e), Long.valueOf(this.f12227b)});
        return "";
    }
}
