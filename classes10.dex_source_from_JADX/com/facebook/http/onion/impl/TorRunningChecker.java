package com.facebook.http.onion.impl;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.util.TriState;
import org.apache.http.HttpHost;

/* compiled from: TAB_BAR */
public class TorRunningChecker extends FbAsyncTask<Void, Void, TriState> {
    private static final Class<TorRunningChecker> f23329a = TorRunningChecker.class;
    private final HttpHost f23330b;

    public TorRunningChecker(HttpHost httpHost) {
        this.f23330b = httpHost;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final java.lang.Object m24649a(java.lang.Object[] r5) {
        /*
        r4 = this;
        r0 = r4.f23330b;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = com.facebook.common.util.TriState.UNSET;
    L_0x0006:
        return r0;
    L_0x0007:
        r1 = new java.net.Socket;
        r1.<init>();
        r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r1.setSoTimeout(r0);	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r0 = new java.net.InetSocketAddress;	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r2 = r4.f23330b;	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r2 = r2.getHostName();	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r3 = r4.f23330b;	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r3 = r3.getPort();	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r0.<init>(r2, r3);	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r1.connect(r0);	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r0 = com.facebook.common.util.TriState.YES;	 Catch:{ UnknownHostException -> 0x0034, IOException -> 0x004b }
        r1.close();	 Catch:{ IOException -> 0x002b }
        goto L_0x0006;
    L_0x002b:
        r1 = move-exception;
        r2 = f23329a;
        r3 = "Failed to close socket";
        com.facebook.debug.log.BLog.a(r2, r3, r1);
        goto L_0x0006;
    L_0x0034:
        r0 = move-exception;
        r2 = f23329a;	 Catch:{ all -> 0x005b }
        r3 = "Failed to find host";
        com.facebook.debug.log.BLog.b(r2, r3, r0);	 Catch:{ all -> 0x005b }
        r0 = com.facebook.common.util.TriState.UNSET;	 Catch:{ all -> 0x005b }
        r1.close();	 Catch:{ IOException -> 0x0042 }
        goto L_0x0006;
    L_0x0042:
        r1 = move-exception;
        r2 = f23329a;
        r3 = "Failed to close socket";
        com.facebook.debug.log.BLog.a(r2, r3, r1);
        goto L_0x0006;
    L_0x004b:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0052 }
    L_0x004f:
        r0 = com.facebook.common.util.TriState.NO;
        goto L_0x0006;
    L_0x0052:
        r0 = move-exception;
        r1 = f23329a;
        r2 = "Failed to close socket";
        com.facebook.debug.log.BLog.a(r1, r2, r0);
        goto L_0x004f;
    L_0x005b:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0060 }
    L_0x005f:
        throw r0;
    L_0x0060:
        r1 = move-exception;
        r2 = f23329a;
        r3 = "Failed to close socket";
        com.facebook.debug.log.BLog.a(r2, r3, r1);
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.TorRunningChecker.a(java.lang.Object[]):java.lang.Object");
    }
}
