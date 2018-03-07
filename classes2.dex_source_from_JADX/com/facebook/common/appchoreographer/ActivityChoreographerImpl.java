package com.facebook.common.appchoreographer;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: quick_promotion_ego_imp */
public class ActivityChoreographerImpl {
    private static final Class<?> f8351a = ActivityChoreographerImpl.class;
    private static volatile ActivityChoreographerImpl f8352h;
    private final DefaultAppChoreographer f8353b;
    private final DefaultAndroidThreadUtil f8354c;
    private final ScheduledExecutorService f8355d;
    @GuardedBy("ui-thread")
    private Class<?> f8356e;
    @GuardedBy("ui-thread")
    private SettableFuture<Boolean> f8357f;
    @GuardedBy("ui-thread")
    public Future<?> f8358g;

    public static com.facebook.common.appchoreographer.ActivityChoreographerImpl m12864a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8352h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.appchoreographer.ActivityChoreographerImpl.class;
        monitor-enter(r1);
        r0 = f8352h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12866b(r0);	 Catch:{ all -> 0x0035 }
        f8352h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8352h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appchoreographer.ActivityChoreographerImpl.a(com.facebook.inject.InjectorLike):com.facebook.common.appchoreographer.ActivityChoreographerImpl");
    }

    private static ActivityChoreographerImpl m12866b(InjectorLike injectorLike) {
        return new ActivityChoreographerImpl(DefaultAppChoreographer.m1621a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    @Inject
    public ActivityChoreographerImpl(DefaultAppChoreographer defaultAppChoreographer, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ScheduledExecutorService scheduledExecutorService) {
        this.f8353b = defaultAppChoreographer;
        this.f8354c = defaultAndroidThreadUtil;
        this.f8355d = scheduledExecutorService;
    }

    public final void m12867a(Class<?> cls) {
        if (this.f8354c.m1659c()) {
            m12865a();
            SettableFuture f = SettableFuture.m1547f();
            this.f8356e = cls;
            if (this.f8357f != null) {
                FutureDetour.a(this.f8357f, Boolean.valueOf(false), -541917327);
            }
            this.f8357f = f;
            this.f8353b.m1637a(this.f8357f);
            this.f8358g = this.f8355d.schedule(new 1(this, cls), 5, TimeUnit.SECONDS);
        }
    }

    public final void m12868b(Class<?> cls) {
        this.f8354c.m1649a();
        m12865a();
        if (this.f8358g != null) {
            this.f8358g.cancel(false);
            this.f8358g = null;
        }
        if (this.f8357f != null) {
            FutureDetour.a(this.f8357f, Boolean.valueOf(true), 1797208587);
            this.f8357f = null;
            if (!Objects.equal(this.f8356e, cls)) {
                BLog.a(f8351a, "stopTrackingActivityLaunch called for %s while tracking %s.", new Object[]{cls, this.f8356e});
            }
            this.f8356e = null;
        }
    }

    private void m12865a() {
        boolean z;
        boolean z2 = true;
        if (this.f8356e == null) {
            z = true;
        } else {
            z = false;
        }
        if (z != (this.f8357f == null)) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }
}
