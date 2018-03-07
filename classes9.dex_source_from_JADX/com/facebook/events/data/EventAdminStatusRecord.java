package com.facebook.events.data;

import android.util.LruCache;
import com.facebook.auth.userscope.UserScoped;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: The difference between the current total budget and the new budget must be greater than zero */
public class EventAdminStatusRecord {
    private static final Object f24245b = new Object();
    private final LruCache<String, String> f24246a = new LruCache(20);

    private static EventAdminStatusRecord m26188a() {
        return new EventAdminStatusRecord();
    }

    public final synchronized void m26190a(String str) {
        this.f24246a.put(str, "-1");
    }

    public final synchronized void m26192b(String str) {
        this.f24246a.remove(str);
    }

    public final synchronized boolean m26194c(String str) {
        return this.f24246a.get(str) != null;
    }

    public final synchronized void m26191a(String str, String str2) {
        if (m26194c(str2)) {
            this.f24246a.put(str2, str);
        }
    }

    public final synchronized void m26195d(String str) {
        if (m26194c(str)) {
            this.f24246a.put(str, "-1");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.events.data.EventAdminStatusRecord m26189a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f24245b;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m26188a();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f24245b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.events.data.EventAdminStatusRecord) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.events.data.EventAdminStatusRecord) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f24245b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.events.data.EventAdminStatusRecord) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.data.EventAdminStatusRecord.a(com.facebook.inject.InjectorLike):com.facebook.events.data.EventAdminStatusRecord");
    }

    public final synchronized boolean m26193b(String str, String str2) {
        boolean z;
        z = m26194c(str2) && str.equals(this.f24246a.get(str2));
        return z;
    }

    public final synchronized boolean m26196e(String str) {
        return !"-1".equals(this.f24246a.get(str));
    }
}
