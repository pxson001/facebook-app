package com.facebook.vault.momentsupsell.data;

import com.facebook.common.collect.WeakHashSets;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.internal.Objects;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: threads AS t */
public class MomentsAppInfoStore {
    public static final Class<?> f1715a = MomentsAppInfoStore.class;
    private static volatile MomentsAppInfoStore f1716g;
    public final MomentsUpsellQueryHelper f1717b;
    public final ExecutorService f1718c;
    public final DefaultAndroidThreadUtil f1719d;
    public final Set<MomentsAppInfoStoreListener> f1720e = WeakHashSets.a();
    @Nullable
    public MomentsAppInfo f1721f;

    /* compiled from: threads AS t */
    public class QueryFutureCallback implements FutureCallback<MomentsAppInfo> {
        final /* synthetic */ MomentsAppInfoStore f1714a;

        public QueryFutureCallback(MomentsAppInfoStore momentsAppInfoStore) {
            this.f1714a = momentsAppInfoStore;
        }

        public void onSuccess(@Nullable Object obj) {
            MomentsAppInfo momentsAppInfo = (MomentsAppInfo) obj;
            if (momentsAppInfo != null) {
                MomentsAppInfoStore momentsAppInfoStore = this.f1714a;
                momentsAppInfoStore.f1719d.a();
                if (!Objects.a(momentsAppInfoStore.f1721f, momentsAppInfo)) {
                    momentsAppInfoStore.f1721f = momentsAppInfo;
                    momentsAppInfoStore.f1719d.a();
                    for (MomentsAppInfoStoreListener momentsAppInfoStoreListener : momentsAppInfoStore.f1720e) {
                        if (momentsAppInfoStoreListener != null) {
                            momentsAppInfoStoreListener.a();
                        }
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.a(MomentsAppInfoStore.f1715a, "Failed to load Moments app info.", th);
        }
    }

    public static com.facebook.vault.momentsupsell.data.MomentsAppInfoStore m1747a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1716g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.momentsupsell.data.MomentsAppInfoStore.class;
        monitor-enter(r1);
        r0 = f1716g;	 Catch:{ all -> 0x003a }
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
        r0 = m1748b(r0);	 Catch:{ all -> 0x0035 }
        f1716g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1716g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.momentsupsell.data.MomentsAppInfoStore.a(com.facebook.inject.InjectorLike):com.facebook.vault.momentsupsell.data.MomentsAppInfoStore");
    }

    private static MomentsAppInfoStore m1748b(InjectorLike injectorLike) {
        return new MomentsAppInfoStore(MomentsUpsellQueryHelper.m1752a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public MomentsAppInfoStore(MomentsUpsellQueryHelper momentsUpsellQueryHelper, ExecutorService executorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f1717b = momentsUpsellQueryHelper;
        this.f1718c = executorService;
        this.f1719d = defaultAndroidThreadUtil;
    }

    public final void m1750a(MomentsAppInfoStoreListener momentsAppInfoStoreListener) {
        this.f1719d.a();
        this.f1720e.add(momentsAppInfoStoreListener);
    }

    public final void m1751b(MomentsAppInfoStoreListener momentsAppInfoStoreListener) {
        this.f1719d.a();
        this.f1720e.remove(momentsAppInfoStoreListener);
    }

    @Nullable
    public final MomentsAppInfo m1749a() {
        this.f1719d.a();
        if (this.f1721f == null || this.f1717b.m1760a(this.f1721f)) {
            Futures.a(this.f1717b.m1759a(), new QueryFutureCallback(this), this.f1718c);
        }
        return this.f1721f;
    }
}
