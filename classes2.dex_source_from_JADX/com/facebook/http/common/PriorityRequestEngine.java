package com.facebook.http.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ConstrainedListeningExecutorService;
import com.facebook.common.executors.ConstrainedListeningExecutorServiceFactory;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.common.PriorityRequestQueue.Mutator;
import com.facebook.http.common.prioritization.PrioritizationPolicy;
import com.facebook.http.common.prioritization.PrioritizationPolicyFactory;
import com.facebook.http.common.prioritization.PrioritizationPolicyFactory.1;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: recent_vpvs */
public class PriorityRequestEngine implements FbHttpRequestEngine {
    private static final Class<?> f7867a = PriorityRequestEngine.class;
    public static final RequestPriority f7868b = RequestPriority.UNNECESSARY;
    private static volatile PriorityRequestEngine f7869o;
    public final PriorityRequestQueue f7870c;
    public final FbHttpRequestExecutorAdapter f7871d;
    private final ConstrainedListeningExecutorServiceFactory f7872e;
    private final BaseFbBroadcastManager f7873f;
    public final FbDataConnectionManager f7874g;
    public final QeAccessor f7875h;
    public final FbHttpRequestProcessorLogger f7876i;
    public final FbHttpRequestDebugLogger f7877j;
    private final RequestProcessorSnapshotLogger f7878k;
    @GuardedBy("this")
    private volatile ConstrainedListeningExecutorService f7879l;
    @GuardedBy("this")
    private volatile SelfRegistrableReceiverImpl f7880m;
    public ConnectionQuality f7881n = ConnectionQuality.UNKNOWN;

    /* compiled from: recent_vpvs */
    class C04961 implements ActionReceiver {
        final /* synthetic */ PriorityRequestEngine f11885a;

        C04961(PriorityRequestEngine priorityRequestEngine) {
            this.f11885a = priorityRequestEngine;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1121794231);
            PriorityRequestEngine priorityRequestEngine = this.f11885a;
            if (priorityRequestEngine.f7875h.mo596a(ExperimentsForHttpQeModule.aU, false)) {
                ConnectionQuality c = priorityRequestEngine.f7874g.m3801c();
                if (c != priorityRequestEngine.f7881n) {
                    PrioritizationPolicy a2;
                    QeAccessor qeAccessor = priorityRequestEngine.f7875h;
                    switch (1.a[c.ordinal()]) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            a2 = PrioritizationPolicyFactory.m12501a(qeAccessor.mo581a(ExperimentsForHttpQeModule.aM, "5:10:15:15"), "5:10:15:15");
                            break;
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            a2 = PrioritizationPolicyFactory.m12501a(qeAccessor.mo581a(ExperimentsForHttpQeModule.aO, "5:10:15:15"), "5:10:15:15");
                            break;
                        case 3:
                            a2 = PrioritizationPolicyFactory.m12501a(qeAccessor.mo581a(ExperimentsForHttpQeModule.aP, "5:5:10:10"), "5:5:10:10");
                            break;
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            a2 = PrioritizationPolicyFactory.m12501a(qeAccessor.mo581a(ExperimentsForHttpQeModule.aR, "5:5:10:10"), "5:5:10:10");
                            break;
                        default:
                            a2 = null;
                            break;
                    }
                    PrioritizationPolicy prioritizationPolicy = a2;
                    if (prioritizationPolicy != null) {
                        priorityRequestEngine.f7870c.m12507a(prioritizationPolicy);
                        priorityRequestEngine.f7881n = c;
                    }
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -397096516, a);
        }
    }

    /* compiled from: recent_vpvs */
    public class ExecuteRequestsRunnable implements Runnable {
        final /* synthetic */ PriorityRequestEngine f11891a;

        public ExecuteRequestsRunnable(PriorityRequestEngine priorityRequestEngine) {
            this.f11891a = priorityRequestEngine;
        }

        public void run() {
            while (true) {
                try {
                    PriorityRequestHolder b = this.f11891a.f7870c.m12508b();
                    Preconditions.checkNotNull(b);
                    try {
                        m17397a(b);
                    } finally {
                        this.f11891a.f7870c.m12509b(b);
                    }
                } catch (InterruptedException e) {
                }
            }
        }

        private void m17397a(PriorityRequestHolder priorityRequestHolder) {
            try {
                this.f11891a.f7876i.m12386a(priorityRequestHolder.f11888c);
                this.f11891a.f7877j.m12478a(priorityRequestHolder.f11888c);
                FutureDetour.a(priorityRequestHolder.f11886a, this.f11891a.f7871d.m12286a(priorityRequestHolder.f11888c), -1671099007);
            } catch (Throwable th) {
                priorityRequestHolder.f11886a.mo222a(th);
            }
        }
    }

    /* compiled from: recent_vpvs */
    public class ModuleChangeMutator implements Mutator {
        public final /* synthetic */ PriorityRequestEngine f14086a;
        public String f14087b;
        private String f14088c;

        public ModuleChangeMutator(PriorityRequestEngine priorityRequestEngine, @Nullable String str, @Nullable String str2) {
            this.f14086a = priorityRequestEngine;
            this.f14087b = str;
            this.f14088c = str2;
        }

        public final void mo2700a(List<PriorityRequestHolder> list, List<FbHttpRequest<?>> list2) {
            if (!StringUtil.m3589a(this.f14087b)) {
                Preconditions.checkNotNull(this.f14087b);
                for (PriorityRequestHolder priorityRequestHolder : list) {
                    if (this.f14087b.equals(FbHttpUtils.a(priorityRequestHolder.f11888c))) {
                        this.f14086a.f7877j.m12479a(priorityRequestHolder.f11888c, PriorityRequestEngine.f7868b);
                        this.f14086a.f7870c.m12503a(priorityRequestHolder.f11888c);
                        priorityRequestHolder.f11888c.f7693j.m11636a(PriorityRequestEngine.f7868b, false);
                        this.f14086a.f7870c.m12505a(priorityRequestHolder.m17396b(PriorityRequestEngine.f7868b));
                    }
                }
            }
            if (!StringUtil.m3589a(this.f14088c)) {
                m20379b(this.f14088c, list);
            }
        }

        private void m20379b(String str, List<PriorityRequestHolder> list) {
            Preconditions.checkNotNull(str);
            for (PriorityRequestHolder priorityRequestHolder : list) {
                if (this.f14088c.equals(FbHttpUtils.a(priorityRequestHolder.f11888c))) {
                    this.f14086a.f7870c.m12503a(priorityRequestHolder.f11888c);
                    PriorityRequestHolder b = priorityRequestHolder.m17396b(null);
                    this.f14086a.f7877j.m12479a(priorityRequestHolder.f11888c, b.m17395a());
                    priorityRequestHolder.f11888c.f7693j.m11636a(b.m17395a(), false);
                    this.f14086a.f7870c.m12505a(b);
                }
            }
        }
    }

    public static com.facebook.http.common.PriorityRequestEngine m12446a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7869o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.PriorityRequestEngine.class;
        monitor-enter(r1);
        r0 = f7869o;	 Catch:{ all -> 0x003a }
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
        r0 = m12447b(r0);	 Catch:{ all -> 0x0035 }
        f7869o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7869o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.PriorityRequestEngine.a(com.facebook.inject.InjectorLike):com.facebook.http.common.PriorityRequestEngine");
    }

    private static PriorityRequestEngine m12447b(InjectorLike injectorLike) {
        return new PriorityRequestEngine((PriorityRequestQueueProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PriorityRequestQueueProvider.class), FbHttpRequestExecutorAdapter.m12274a(injectorLike), ConstrainedListeningExecutorServiceFactory.m2127a(injectorLike), FbHttpRequestProcessorLogger.m12382a(injectorLike), FbHttpRequestDebugLogger.m12470a(injectorLike), RequestProcessorSnapshotLogger.m12483a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public PriorityRequestEngine(PriorityRequestQueueProvider priorityRequestQueueProvider, FbHttpRequestExecutorAdapter fbHttpRequestExecutorAdapter, ConstrainedListeningExecutorServiceFactory constrainedListeningExecutorServiceFactory, FbHttpRequestProcessorLogger fbHttpRequestProcessorLogger, FbHttpRequestDebugLogger fbHttpRequestDebugLogger, RequestProcessorSnapshotLogger requestProcessorSnapshotLogger, BaseFbBroadcastManager baseFbBroadcastManager, FbDataConnectionManager fbDataConnectionManager, QeAccessor qeAccessor) {
        this.f7870c = priorityRequestQueueProvider.m12469a(PrioritizationPolicyFactory.m12501a(qeAccessor.mo581a(ExperimentsForHttpQeModule.aN, "5:10:15:20"), "5:10:15:20"));
        this.f7871d = fbHttpRequestExecutorAdapter;
        this.f7872e = constrainedListeningExecutorServiceFactory;
        this.f7876i = fbHttpRequestProcessorLogger;
        this.f7877j = fbHttpRequestDebugLogger;
        this.f7878k = requestProcessorSnapshotLogger;
        this.f7873f = baseFbBroadcastManager;
        this.f7874g = fbDataConnectionManager;
        this.f7875h = qeAccessor;
    }

    public final <T> ListenableFuture<T> mo1693a(FbHttpRequest<T> fbHttpRequest) {
        m12450i();
        PriorityRequestHolder priorityRequestHolder = new PriorityRequestHolder(fbHttpRequest);
        this.f7877j.m12480a((FbHttpRequest) fbHttpRequest, priorityRequestHolder.f11886a);
        this.f7870c.m12505a(priorityRequestHolder);
        m12448g();
        return priorityRequestHolder.f11886a;
    }

    public final boolean mo1698b(FbHttpRequest<?> fbHttpRequest) {
        this.f7877j.m12481b((FbHttpRequest) fbHttpRequest);
        PriorityRequestHolder a = this.f7870c.m12503a((FbHttpRequest) fbHttpRequest);
        if (a != null) {
            a.f11886a.cancel(false);
            return true;
        } else if (this.f7875h.mo596a(ExperimentsForHttpQeModule.bf, false)) {
            try {
                fbHttpRequest.m12236i().m11639c();
                return true;
            } catch (IOException e) {
                return false;
            }
        } else {
            this.f7877j.m12479a((FbHttpRequest) fbHttpRequest, RequestPriority.UNNECESSARY);
            fbHttpRequest.m12236i().m11636a(RequestPriority.UNNECESSARY, this.f7871d.m12289b());
            return true;
        }
    }

    public final void mo1695a(FbHttpRequest<?> fbHttpRequest, RequestPriority requestPriority) {
        this.f7877j.m12479a((FbHttpRequest) fbHttpRequest, requestPriority);
        PriorityRequestHolder a = this.f7870c.m12503a((FbHttpRequest) fbHttpRequest);
        if (a != null) {
            a.f11888c.f7693j.m11636a(requestPriority, false);
            this.f7870c.m12505a(new PriorityRequestHolder(a, requestPriority));
        } else if (fbHttpRequest.m12235h() == requestPriority) {
            this.f7877j.m12482c(fbHttpRequest);
        } else {
            fbHttpRequest.f7693j.m11636a(requestPriority, this.f7871d.m12289b());
        }
    }

    public final void mo1696a(@Nullable String str, @Nullable String str2) {
        if (!StringUtil.m3590a(str, str2)) {
            this.f7870c.m12506a(new ModuleChangeMutator(this, str, str2));
        }
    }

    public final void mo1694a() {
        this.f7870c.m12506a(new AbortRequestsMutator(this));
    }

    public final RequestProcessorSnapshot mo1697b() {
        return this.f7870c.m12510c();
    }

    public final String mo1699c() {
        RequestProcessorSnapshot c = this.f7870c.m12510c();
        ArrayList arrayList = c.a;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (((FbHttpRequest) arrayList.get(i)).m12244r()) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f7867a.getSimpleName()).append(": in-flight(").append(String.valueOf(c.a.size())).append("), queued(").append(String.valueOf(c.b.size())).append("), in-flight sublimited(").append(String.valueOf(i2)).append("), running threads(").append(String.valueOf(m12449h().mo301b())).append("), waiting runnables(").append(String.valueOf(m12449h().mo299a())).append(")\n");
        return stringBuilder.toString();
    }

    public final String mo1700d() {
        return f7867a.getSimpleName();
    }

    public final String mo1701e() {
        return this.f7871d.m12287a();
    }

    private void m12448g() {
        if (m12449h().mo301b() < this.f7870c.m12504a().f7920d) {
            ExecutorDetour.a(m12449h(), new ExecuteRequestsRunnable(this), -1524369960);
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private ConstrainedListeningExecutorService m12449h() {
        if (this.f7879l == null) {
            synchronized (this) {
                if (this.f7879l == null) {
                    this.f7879l = (ConstrainedListeningExecutorService) Preconditions.checkNotNull(this.f7872e.m2129a("NetworkDispatch", 20, 200, 10));
                }
            }
        }
        return this.f7879l;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void m12450i() {
        if (this.f7880m == null) {
            synchronized (this) {
                if (this.f7880m == null) {
                    this.f7880m = this.f7873f.m2951a().mo506a(FbDataConnectionManager.f1876a, new C04961(this)).mo503a();
                    this.f7880m.m3296b();
                }
            }
        }
    }
}
