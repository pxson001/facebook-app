package com.facebook.http.onion.impl;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Successful fetch w/o thread or user */
public class OrbotLauncher implements ActionReceiver {
    private static final Class<OrbotLauncher> f23364a = OrbotLauncher.class;
    private static volatile OrbotLauncher f23365j;
    public final FbTorProxy f23366b;
    public final BaseFbBroadcastManager f23367c;
    public final String f23368d;
    public final SelfRegistrableReceiverImpl f23369e;
    private String f23370f = "127.0.0.1";
    private int f23371g = 8118;
    private String f23372h = "127.0.0.1";
    private int f23373i = 9050;

    public static com.facebook.http.onion.impl.OrbotLauncher m24689a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23365j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.OrbotLauncher.class;
        monitor-enter(r1);
        r0 = f23365j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24690b(r0);	 Catch:{ all -> 0x0035 }
        f23365j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23365j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.OrbotLauncher.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.OrbotLauncher");
    }

    private static OrbotLauncher m24690b(InjectorLike injectorLike) {
        return new OrbotLauncher((Context) injectorLike.getInstance(Context.class), (BaseFbBroadcastManager) GlobalFbBroadcastManager.a(injectorLike), FbTorProxy.m24650a(injectorLike));
    }

    @Inject
    public OrbotLauncher(Context context, BaseFbBroadcastManager baseFbBroadcastManager, FbTorProxy fbTorProxy) {
        this.f23368d = context.getPackageName();
        this.f23366b = fbTorProxy;
        this.f23367c = baseFbBroadcastManager;
        this.f23369e = this.f23367c.a().a("org.torproject.android.intent.action.STATUS", this).a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r13, android.content.Intent r14, com.facebook.content.BroadcastReceiverLike r15) {
        /*
        r12 = this;
        r6 = 4;
        r5 = 3;
        r3 = 1;
        r1 = 0;
        r4 = 2;
        r0 = com.facebook.loom.logger.LogEntry.EntryType.LIFECYCLE_BROADCAST_RECEIVER_START;
        r2 = -428024054; // 0xffffffffe67cdf0a float:-2.9853767E23 double:NaN;
        r7 = com.facebook.loom.logger.Logger.a(r4, r0, r2);
        r0 = "org.torproject.android.intent.extra.STATUS";
        r0 = r14.getStringExtra(r0);
        r2 = "org.torproject.android.intent.extra.HTTP_PROXY_HOST";
        r2 = r14.getStringExtra(r2);
        r8 = "org.torproject.android.intent.extra.HTTP_PROXY_PORT";
        r9 = 8118; // 0x1fb6 float:1.1376E-41 double:4.011E-320;
        r8 = r14.getIntExtra(r8, r9);
        r9 = "org.torproject.android.intent.extra.SOCKS_PROXY_HOST";
        r9 = r14.getStringExtra(r9);
        r10 = "org.torproject.android.intent.extra.SOCKS_PROXY_PORT";
        r11 = 9050; // 0x235a float:1.2682E-41 double:4.4713E-320;
        r10 = r14.getIntExtra(r10, r11);
        if (r2 == 0) goto L_0x0036;
    L_0x0032:
        r12.f23370f = r2;
        r12.f23371g = r8;
    L_0x0036:
        if (r9 == 0) goto L_0x003c;
    L_0x0038:
        r12.f23372h = r9;
        r12.f23373i = r10;
    L_0x003c:
        r11 = 5;
        r11 = new java.lang.Object[r11];
        r11[r1] = r0;
        r11[r3] = r2;
        r2 = java.lang.Integer.valueOf(r8);
        r11[r4] = r2;
        r11[r5] = r9;
        r2 = java.lang.Integer.valueOf(r10);
        r11[r6] = r2;
        if (r0 != 0) goto L_0x0055;
    L_0x0053:
        r0 = "OFF";
    L_0x0055:
        r2 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -1796691852: goto L_0x0072;
            case -1742673238: goto L_0x0090;
            case 2527: goto L_0x0086;
            case 78159: goto L_0x0068;
            case 2099433536: goto L_0x007c;
            default: goto L_0x005d;
        };
    L_0x005d:
        r0 = r2;
    L_0x005e:
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x00a0;
            case 2: goto L_0x00a6;
            case 3: goto L_0x00ac;
            case 4: goto L_0x00ba;
            default: goto L_0x0061;
        };
    L_0x0061:
        r0 = 1577306463; // 0x5e03c95f float:2.37405644E18 double:7.792929363E-315;
        com.facebook.tools.dextr.runtime.LogUtils.e(r0, r7);
        return;
    L_0x0068:
        r3 = "OFF";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x005d;
    L_0x0070:
        r0 = r1;
        goto L_0x005e;
    L_0x0072:
        r1 = "STOPPING";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005d;
    L_0x007a:
        r0 = r3;
        goto L_0x005e;
    L_0x007c:
        r1 = "STARTING";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005d;
    L_0x0084:
        r0 = r4;
        goto L_0x005e;
    L_0x0086:
        r1 = "ON";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005d;
    L_0x008e:
        r0 = r5;
        goto L_0x005e;
    L_0x0090:
        r1 = "STARTS_DISABLED";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005d;
    L_0x0098:
        r0 = r6;
        goto L_0x005e;
    L_0x009a:
        r0 = r12.f23366b;
        r0.m24672j();
        goto L_0x0061;
    L_0x00a0:
        r0 = r12.f23366b;
        r0.m24671i();
        goto L_0x0061;
    L_0x00a6:
        r0 = r12.f23366b;
        r0.m24669g();
        goto L_0x0061;
    L_0x00ac:
        r0 = r12.f23366b;
        r1 = r12.f23370f;
        r2 = r12.f23371g;
        r3 = r12.f23372h;
        r4 = r12.f23373i;
        r0.m24661a(r1, r2, r3, r4);
        goto L_0x0061;
    L_0x00ba:
        r0 = r12.f23366b;
        r0.m24673k();
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.OrbotLauncher.onReceive(android.content.Context, android.content.Intent, com.facebook.content.BroadcastReceiverLike):void");
    }
}
