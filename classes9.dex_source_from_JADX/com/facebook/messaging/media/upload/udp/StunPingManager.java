package com.facebook.messaging.media.upload.udp;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_read_receipt_time */
public class StunPingManager {
    private static volatile StunPingManager f12142g;
    private final BlockingByteBufferQueue f12143a;
    private final Clock f12144b;
    private final StunPingData f12145c = new StunPingData(this);
    public Random f12146d = new Random();
    private String f12147e;
    private AtomicLong f12148f;

    /* compiled from: last_read_receipt_time */
    public class StunPingData {
        public final int f12137a;
        public final long f12138b;
        public String f12139c;
        public String f12140d;
        final /* synthetic */ StunPingManager f12141e;

        public StunPingData(StunPingManager stunPingManager) {
            this(stunPingManager, stunPingManager.f12146d.nextInt(), stunPingManager.f12146d.nextLong());
        }

        private StunPingData(StunPingManager stunPingManager, int i, long j) {
            this.f12141e = stunPingManager;
            this.f12137a = i;
            this.f12138b = j;
            this.f12139c = null;
            this.f12140d = null;
        }

        public int hashCode() {
            return (this.f12137a ^ ((int) this.f12138b)) ^ ((int) (this.f12138b >> 32));
        }

        public boolean equals(Object obj) {
            if (obj.getClass() != StunPingData.class) {
                return false;
            }
            StunPingData stunPingData = (StunPingData) obj;
            if (this.f12137a == stunPingData.f12137a && this.f12138b == stunPingData.f12138b) {
                return true;
            }
            return false;
        }

        public final boolean m12652a() {
            return (this.f12138b == 0 || this.f12137a == 0 || StringUtil.a(this.f12139c) || StringUtil.a(this.f12140d)) ? false : true;
        }
    }

    public static com.facebook.messaging.media.upload.udp.StunPingManager m12653a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12142g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.udp.StunPingManager.class;
        monitor-enter(r1);
        r0 = f12142g;	 Catch:{ all -> 0x003a }
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
        r0 = m12654b(r0);	 Catch:{ all -> 0x0035 }
        f12142g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12142g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.StunPingManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.StunPingManager");
    }

    private static StunPingManager m12654b(InjectorLike injectorLike) {
        return new StunPingManager(BlockingByteBufferQueue_UDPOutgoingPacketQueueMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StunPingManager(BlockingByteBufferQueue blockingByteBufferQueue, Clock clock) {
        this.f12143a = blockingByteBufferQueue;
        this.f12144b = clock;
        StringBuilder stringBuilder = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            stringBuilder.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.f12146d.nextInt(36)));
        }
        this.f12147e = stringBuilder.toString();
        this.f12148f = new AtomicLong(0);
    }

    public final boolean m12656a() {
        return this.f12144b.a() > this.f12148f.get() && m12657b();
    }

    public final boolean m12657b() {
        boolean z = false;
        synchronized (this.f12145c) {
            if (this.f12145c.m12652a()) {
                StunPingBuilder stunPingBuilder = new StunPingBuilder();
                stunPingBuilder.m12650a(this.f12145c).m12642a(UDPByteBufferBuilder.m12661a());
                try {
                    this.f12143a.a(stunPingBuilder.m12651a());
                    this.f12148f.set(this.f12144b.a() + 500);
                    z = true;
                } catch (Throwable e) {
                    BLog.b(StunPingManager.class, "Unable to build stun ping", e);
                }
            }
        }
        return z;
    }

    public final void m12655a(String str, String str2) {
        synchronized (this.f12145c) {
            this.f12145c.f12139c = str + ":" + this.f12147e;
            this.f12145c.f12140d = str2;
        }
    }
}
