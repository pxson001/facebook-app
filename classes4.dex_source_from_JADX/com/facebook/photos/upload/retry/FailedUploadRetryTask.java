package com.facebook.photos.upload.retry;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.service.UploadServiceQueue;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: noauth_get_release_info */
public class FailedUploadRetryTask extends AbstractBackgroundTask {
    private static volatile FailedUploadRetryTask f7069g;
    @GuardedBy("this")
    private long f7070a = -1;
    private volatile boolean f7071b = false;
    @GuardedBy("this")
    private UploadManager f7072c = null;
    private final Lazy<Executor> f7073d;
    private final Clock f7074e;
    private final GatekeeperStoreImpl f7075f;

    public static com.facebook.photos.upload.retry.FailedUploadRetryTask m7372a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7069g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.retry.FailedUploadRetryTask.class;
        monitor-enter(r1);
        r0 = f7069g;	 Catch:{ all -> 0x003a }
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
        r0 = m7373b(r0);	 Catch:{ all -> 0x0035 }
        f7069g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7069g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.retry.FailedUploadRetryTask.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.retry.FailedUploadRetryTask");
    }

    private static FailedUploadRetryTask m7373b(InjectorLike injectorLike) {
        return new FailedUploadRetryTask(IdBasedSingletonScopeProvider.b(injectorLike, 3863), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FailedUploadRetryTask(Lazy<Executor> lazy, Clock clock, GatekeeperStore gatekeeperStore) {
        super("FailedUploadRetryTask");
        this.f7073d = lazy;
        this.f7074e = clock;
        this.f7075f = gatekeeperStore;
    }

    public final synchronized void m7375a(UploadManager uploadManager) {
        this.f7072c = uploadManager;
    }

    public final synchronized void m7374a(long j) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = this.f7070a == -1 || j < this.f7070a;
            this.f7070a = j;
            if (this.f7070a == -1) {
                z = false;
            }
            this.f7071b = z;
            if (this.f7071b && z2) {
                m7388g();
            }
        }
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(UploadServiceQueue.class);
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final synchronized long mo593f() {
        return this.f7070a;
    }

    public final boolean mo595i() {
        boolean z = false;
        if (!this.f7075f.a(641, false)) {
            return this.f7071b;
        }
        synchronized (this) {
            if (this.f7071b && this.f7070a <= this.f7074e.a()) {
                z = true;
            }
        }
        return z;
    }

    public final synchronized ListenableFuture<BackgroundResult> mo596j() {
        if (this.f7072c != null) {
            m7374a(-1);
            ExecutorDetour.a((Executor) this.f7073d.get(), new 1(this, this.f7072c), 62208824);
        }
        return null;
    }
}
