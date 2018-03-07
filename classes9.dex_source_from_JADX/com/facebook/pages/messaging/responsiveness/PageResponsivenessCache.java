package com.facebook.pages.messaging.responsiveness;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.util.BasePagesTrackedLruCache;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: ccu_contacts_upload_succeeded_event */
public class PageResponsivenessCache implements IHaveUserData {
    private static volatile PageResponsivenessCache f18434d;
    private final PageResponsivenessContext f18435a = new PageResponsivenessContext(PageResponseTimespan.NONE, false);
    private final BasePagesTrackedLruCache<String, PageResponsivenessContext> f18436b;
    private final Clock f18437c;

    public static com.facebook.pages.messaging.responsiveness.PageResponsivenessCache m18419a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18434d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.messaging.responsiveness.PageResponsivenessCache.class;
        monitor-enter(r1);
        r0 = f18434d;	 Catch:{ all -> 0x003a }
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
        r0 = m18420b(r0);	 Catch:{ all -> 0x0035 }
        f18434d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18434d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.messaging.responsiveness.PageResponsivenessCache.a(com.facebook.inject.InjectorLike):com.facebook.pages.messaging.responsiveness.PageResponsivenessCache");
    }

    private static PageResponsivenessCache m18420b(InjectorLike injectorLike) {
        return new PageResponsivenessCache(FactoryMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageResponsivenessCache(Factory factory, Clock clock) {
        this.f18437c = clock;
        this.f18436b = new BasePagesTrackedLruCache(factory, this.f18437c, 128);
    }

    public final synchronized boolean m18422a(String str) {
        return this.f18436b.a(str, m18418a()) != null;
    }

    @Nullable
    public final synchronized PageResponsivenessContext m18423b(String str) {
        PageResponsivenessContext pageResponsivenessContext;
        pageResponsivenessContext = (PageResponsivenessContext) this.f18436b.a(str, m18418a());
        if (pageResponsivenessContext == null || this.f18435a.equals(pageResponsivenessContext)) {
            pageResponsivenessContext = null;
        }
        return pageResponsivenessContext;
    }

    public final synchronized void m18421a(String str, PageResponsivenessContext pageResponsivenessContext) {
        if (pageResponsivenessContext == null) {
            pageResponsivenessContext = this.f18435a;
        }
        this.f18436b.a(str, pageResponsivenessContext);
    }

    public void clearUserData() {
        this.f18436b.a();
    }

    private long m18418a() {
        return this.f18437c.a() - 180000;
    }
}
