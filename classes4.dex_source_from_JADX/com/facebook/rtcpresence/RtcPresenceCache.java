package com.facebook.rtcpresence;

import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.UserKey;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: session_id is not null */
public class RtcPresenceCache {
    private static volatile RtcPresenceCache f2528b;
    @GuardedBy("this")
    private final TrackedLruCache<UserKey, RtcPresenceState> f2529a;

    public static com.facebook.rtcpresence.RtcPresenceCache m2815a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2528b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtcpresence.RtcPresenceCache.class;
        monitor-enter(r1);
        r0 = f2528b;	 Catch:{ all -> 0x003a }
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
        r0 = m2816b(r0);	 Catch:{ all -> 0x0035 }
        f2528b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2528b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtcpresence.RtcPresenceCache.a(com.facebook.inject.InjectorLike):com.facebook.rtcpresence.RtcPresenceCache");
    }

    private static RtcPresenceCache m2816b(InjectorLike injectorLike) {
        return new RtcPresenceCache(FactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RtcPresenceCache(Factory factory) {
        this.f2529a = factory.a(200, "rtc_presence");
    }

    public final synchronized void m2818a(UserKey userKey, RtcPresenceState rtcPresenceState) {
        this.f2529a.a(userKey, rtcPresenceState);
    }

    public final synchronized RtcPresenceState m2817a(UserKey userKey) {
        RtcPresenceState rtcPresenceState;
        if (userKey != null) {
            rtcPresenceState = (RtcPresenceState) this.f2529a.a(userKey);
        } else {
            rtcPresenceState = null;
        }
        return rtcPresenceState;
    }
}
