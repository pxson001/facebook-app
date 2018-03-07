package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: online */
public class RequestLoggingListener implements RequestListener {
    @GuardedBy("this")
    private final Map<Pair<String, String>, Long> f11049a = new HashMap();
    @GuardedBy("this")
    private final Map<String, Long> f11050b = new HashMap();

    public final synchronized void mo2103a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (FLog.a(2)) {
            Long.valueOf(m16393a());
            Boolean.valueOf(z);
            this.f11050b.put(str, Long.valueOf(m16393a()));
        }
    }

    public final synchronized void mo2106a(String str, String str2) {
        if (FLog.a(2)) {
            Pair create = Pair.create(str, str2);
            long a = m16393a();
            this.f11049a.put(create, Long.valueOf(a));
            Long.valueOf(a);
        }
    }

    public final synchronized void mo2109a(String str, String str2, @Nullable Map<String, String> map) {
        if (FLog.a(2)) {
            Long l = (Long) this.f11049a.remove(Pair.create(str, str2));
            long a = m16393a();
            Object[] objArr = new Object[]{Long.valueOf(a), str, str2, Long.valueOf(m16394a(l, a)), map};
        }
    }

    public final synchronized void mo2108a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        if (FLog.a(5)) {
            Long l = (Long) this.f11049a.remove(Pair.create(str, str2));
            long a = m16393a();
            FLog.a("RequestLoggingListener", "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[]{Long.valueOf(a), str, str2, Long.valueOf(m16394a(l, a)), map, th.toString()});
        }
    }

    public final synchronized void mo2112b(String str, String str2, @Nullable Map<String, String> map) {
        if (FLog.a(2)) {
            Long l = (Long) this.f11049a.remove(Pair.create(str, str2));
            long a = m16393a();
            Object[] objArr = new Object[]{Long.valueOf(a), str, str2, Long.valueOf(m16394a(l, a)), map};
        }
    }

    public final synchronized void mo2107a(String str, String str2, String str3) {
        if (FLog.a(2)) {
            Long l = (Long) this.f11049a.get(Pair.create(str, str2));
            long a = m16393a();
            Object[] objArr = new Object[]{Long.valueOf(m16393a()), str, str2, str3, Long.valueOf(m16394a(l, a))};
        }
    }

    public final synchronized void mo2105a(ImageRequest imageRequest, String str, boolean z) {
        if (FLog.a(2)) {
            Long l = (Long) this.f11050b.remove(str);
            long a = m16393a();
            Long.valueOf(a);
            Long.valueOf(m16394a(l, a));
        }
    }

    public final synchronized void mo2104a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (FLog.a(5)) {
            Long l = (Long) this.f11050b.remove(str);
            long a = m16393a();
            FLog.a("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[]{Long.valueOf(a), str, Long.valueOf(m16394a(l, a)), th.toString()});
        }
    }

    public final synchronized void mo2111b(String str) {
        if (FLog.a(2)) {
            Long l = (Long) this.f11050b.remove(str);
            long a = m16393a();
            Long.valueOf(a);
            Long.valueOf(m16394a(l, a));
        }
    }

    public final boolean mo2110a(String str) {
        return FLog.a(2);
    }

    private static long m16394a(@Nullable Long l, long j) {
        if (l != null) {
            return j - l.longValue();
        }
        return -1;
    }

    private static long m16393a() {
        return SystemClock.uptimeMillis();
    }
}
