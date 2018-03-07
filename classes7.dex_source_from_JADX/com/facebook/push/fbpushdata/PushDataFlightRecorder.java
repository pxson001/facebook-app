package com.facebook.push.fbpushdata;

import com.facebook.common.collect.RingBuffer;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.Boolean_IsInternalBuildMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hero_image */
public class PushDataFlightRecorder {
    private static volatile PushDataFlightRecorder f11290d;
    public final Boolean f11291a;
    public final MonotonicClock f11292b;
    private final RingBuffer<FlightRecorderEvent> f11293c = new RingBuffer(20);

    /* compiled from: hero_image */
    class PushFlightRecorderEvent implements FlightRecorderEvent {
        final /* synthetic */ PushDataFlightRecorder f11286a;
        private final long f11287b;
        private final String f11288c;
        private final String f11289d;

        public PushFlightRecorderEvent(PushDataFlightRecorder pushDataFlightRecorder, String str, String str2) {
            this.f11286a = pushDataFlightRecorder;
            this.f11287b = pushDataFlightRecorder.f11292b.now();
            this.f11288c = str;
            this.f11289d = str2;
        }

        public long getStartTime() {
            return this.f11287b;
        }

        public final String m13186a() {
            return "[" + this.f11288c + "] " + this.f11289d;
        }
    }

    public static com.facebook.push.fbpushdata.PushDataFlightRecorder m13187a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11290d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbpushdata.PushDataFlightRecorder.class;
        monitor-enter(r1);
        r0 = f11290d;	 Catch:{ all -> 0x003a }
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
        r0 = m13188b(r0);	 Catch:{ all -> 0x0035 }
        f11290d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11290d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbpushdata.PushDataFlightRecorder.a(com.facebook.inject.InjectorLike):com.facebook.push.fbpushdata.PushDataFlightRecorder");
    }

    private static PushDataFlightRecorder m13188b(InjectorLike injectorLike) {
        return new PushDataFlightRecorder(Boolean_IsInternalBuildMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PushDataFlightRecorder(Boolean bool, MonotonicClock monotonicClock) {
        this.f11291a = bool;
        this.f11292b = monotonicClock;
    }

    public final void m13189a(String str, String str2) {
        if (this.f11291a.booleanValue()) {
            this.f11293c.a(new PushFlightRecorderEvent(this, str, str2));
        }
    }
}
