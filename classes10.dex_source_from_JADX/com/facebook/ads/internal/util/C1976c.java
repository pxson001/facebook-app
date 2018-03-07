package com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public class C1976c {
    private static final List<C1975b> f14318a = new ArrayList();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m14445a() {
        /*
        r1 = f14318a;
        monitor-enter(r1);
        r0 = f14318a;	 Catch:{ all -> 0x0039 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = "";
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0039 }
        r2 = f14318a;	 Catch:{ all -> 0x0039 }
        r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        r2 = f14318a;	 Catch:{ all -> 0x0039 }
        r2.clear();	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r1 = new org.json.JSONArray;
        r1.<init>();
        r2 = r0.iterator();
    L_0x0025:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x002b:
        r0 = r2.next();
        r0 = (com.facebook.ads.internal.util.C1975b) r0;
        r0 = r0.m14444a();
        r1.put(r0);
        goto L_0x0025;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x003c:
        r0 = r1.toString();
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.c.a():java.lang.String");
    }

    public static void m14446a(C1975b c1975b) {
        synchronized (f14318a) {
            f14318a.add(c1975b);
        }
    }
}
