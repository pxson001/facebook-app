package com.facebook.debug.http;

import java.util.concurrent.Callable;

/* compiled from: pinId */
class GraphQLReporter$Request implements Callable<String> {
    private String f6586a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call() {
        /*
        r7 = this;
        r2 = 0;
        r0 = new java.net.URL;
        r1 = r7.f6586a;
        r0.<init>(r1);
        r3 = r0.openStream();
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x002c, all -> 0x004d }
        r4.<init>();	 Catch:{ Throwable -> 0x002c, all -> 0x004d }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0020, all -> 0x005c }
    L_0x0015:
        r1 = r3.read(r0);	 Catch:{ Throwable -> 0x0020, all -> 0x005c }
        if (r1 < 0) goto L_0x0039;
    L_0x001b:
        r5 = 0;
        r4.write(r0, r5, r1);	 Catch:{ Throwable -> 0x0020, all -> 0x005c }
        goto L_0x0015;
    L_0x0020:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0022 }
    L_0x0022:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0026:
        if (r1 == 0) goto L_0x004f;
    L_0x0028:
        r4.close();	 Catch:{ Throwable -> 0x0048, all -> 0x004d }
    L_0x002b:
        throw r0;	 Catch:{  }
    L_0x002c:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x002e }
    L_0x002e:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0031:
        if (r3 == 0) goto L_0x0038;
    L_0x0033:
        if (r2 == 0) goto L_0x0058;
    L_0x0035:
        r3.close();	 Catch:{ Throwable -> 0x0053 }
    L_0x0038:
        throw r0;
    L_0x0039:
        r0 = "UTF-8";
        r0 = r4.toString(r0);	 Catch:{  }
        r4.close();	 Catch:{  }
        if (r3 == 0) goto L_0x0047;
    L_0x0044:
        r3.close();
    L_0x0047:
        return r0;
    L_0x0048:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r4);	 Catch:{  }
        goto L_0x002b;
    L_0x004d:
        r0 = move-exception;
        goto L_0x0031;
    L_0x004f:
        r4.close();	 Catch:{  }
        goto L_0x002b;
    L_0x0053:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r1);
        goto L_0x0038;
    L_0x0058:
        r3.close();
        goto L_0x0038;
    L_0x005c:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.http.GraphQLReporter$Request.call():java.lang.Object");
    }

    public GraphQLReporter$Request(String str) {
        this.f6586a = str;
    }
}
