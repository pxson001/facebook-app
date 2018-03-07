package com.facebook.messaging.media.upload.udp;

import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_delivered_receipt_message_id */
public class UDPPacketManager {
    private static volatile UDPPacketManager f12198g;
    private final UDPSendingBackgroundTask f12199a;
    private final UDPReceivingBackgroundTask f12200b;
    private final BackgroundTaskManager f12201c;
    private final StunPingManager f12202d;
    private final AtomicBoolean f12203e = new AtomicBoolean(false);
    private DatagramSocket f12204f;

    public static com.facebook.messaging.media.upload.udp.UDPPacketManager m12702a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12198g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.udp.UDPPacketManager.class;
        monitor-enter(r1);
        r0 = f12198g;	 Catch:{ all -> 0x003a }
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
        r0 = m12704b(r0);	 Catch:{ all -> 0x0035 }
        f12198g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12198g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPPacketManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.UDPPacketManager");
    }

    private static UDPPacketManager m12704b(InjectorLike injectorLike) {
        return new UDPPacketManager(UDPSendingBackgroundTask.a(injectorLike), UDPReceivingBackgroundTask.a(injectorLike), BackgroundTaskManager.a(injectorLike), StunPingManager.m12653a(injectorLike));
    }

    @Inject
    public UDPPacketManager(UDPSendingBackgroundTask uDPSendingBackgroundTask, UDPReceivingBackgroundTask uDPReceivingBackgroundTask, BackgroundTaskManager backgroundTaskManager, StunPingManager stunPingManager) {
        this.f12199a = uDPSendingBackgroundTask;
        this.f12200b = uDPReceivingBackgroundTask;
        this.f12201c = backgroundTaskManager;
        this.f12202d = stunPingManager;
    }

    private void m12703a(String str, int i) {
        if (!this.f12203e.getAndSet(true)) {
            this.f12204f = new DatagramSocket();
            this.f12204f.setSoTimeout(20000);
            this.f12199a.c = this.f12204f;
            this.f12200b.f = this.f12204f;
        }
        UDPSendingBackgroundTask uDPSendingBackgroundTask = this.f12199a;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (uDPSendingBackgroundTask.d.get() == null || !((SocketAddress) uDPSendingBackgroundTask.d.get()).equals(inetSocketAddress)) {
            uDPSendingBackgroundTask.d.set(inetSocketAddress);
        }
    }

    public final void m12705a(UDPServerConfig uDPServerConfig) {
        this.f12202d.m12655a(uDPServerConfig.f12207a, uDPServerConfig.f12208b);
        try {
            m12703a(uDPServerConfig.f12209c, uDPServerConfig.f12210d);
            this.f12202d.m12657b();
        } catch (Throwable e) {
            BLog.b(UDPPacketManager.class, "Unable to update socket destination address", e);
        } catch (Throwable e2) {
            BLog.b(UDPPacketManager.class, "Unable to send stun ping to new address", e2);
        }
        this.f12201c.a();
    }
}
