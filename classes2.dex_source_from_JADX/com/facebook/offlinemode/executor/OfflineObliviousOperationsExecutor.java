package com.facebook.offlinemode.executor;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceShimmedMutation.AddCommentString;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory$Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.comments.OfflineCommentsExecutorHelper;
import com.facebook.offlinemode.comments.OfflineCommentsExecutorHelper.1;
import com.facebook.offlinemode.common.OfflineModeHelper;
import com.facebook.offlinemode.common.OfflineModeHelper.ProcessQueueTrigger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.OfflineModeDbHandler;
import com.facebook.offlinemode.db.PendingBlueServiceRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_type */
public class OfflineObliviousOperationsExecutor implements INeedInit {
    public static final OfflineExceptionTreatment f12412a = OfflineExceptionTreatment.NEVER_FINISH;
    public static final String f12413b = OfflineObliviousOperationsExecutor.class.getSimpleName();
    private static final Set<ErrorCode> f12414c = EnumSet.of(ErrorCode.CONNECTION_FAILURE);
    private static volatile OfflineObliviousOperationsExecutor f12415n;
    private final DefaultBlueServiceOperationFactory f12416d;
    public final OfflineModeDbHandler f12417e;
    private final BaseFbBroadcastManager f12418f;
    public final FbNetworkManager f12419g;
    private final ExecutorService f12420h;
    private final Clock f12421i;
    public final AtomicBoolean f12422j = new AtomicBoolean(false);
    public final GraphQLQueryExecutor f12423k;
    public final OfflineModeHelper f12424l;
    public final OfflineCommentsExecutorHelper f12425m;

    /* compiled from: network_type */
    public enum OfflineExceptionTreatment {
        THROW_CUSTOM_EXCEPTION,
        NEVER_FINISH,
        FAKE_SUCCESS
    }

    public static com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor m18485a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12415n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor.class;
        monitor-enter(r1);
        r0 = f12415n;	 Catch:{ all -> 0x003a }
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
        r0 = m18492b(r0);	 Catch:{ all -> 0x0035 }
        f12415n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12415n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor");
    }

    private static OfflineObliviousOperationsExecutor m18492b(InjectorLike injectorLike) {
        return new OfflineObliviousOperationsExecutor(DefaultBlueServiceOperationFactory.m3782b(injectorLike), OfflineModeDbHandler.m18498a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbNetworkManager.m3811a(injectorLike), C0055x2995691a.m1881a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), OfflineModeHelper.m18526a(injectorLike), OfflineCommentsExecutorHelper.m18537a(injectorLike));
    }

    @Inject
    public OfflineObliviousOperationsExecutor(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, OfflineModeDbHandler offlineModeDbHandler, BaseFbBroadcastManager baseFbBroadcastManager, FbNetworkManager fbNetworkManager, ExecutorService executorService, Clock clock, GraphQLQueryExecutor graphQLQueryExecutor, OfflineModeHelper offlineModeHelper, OfflineCommentsExecutorHelper offlineCommentsExecutorHelper) {
        this.f12416d = defaultBlueServiceOperationFactory;
        this.f12417e = offlineModeDbHandler;
        this.f12418f = baseFbBroadcastManager;
        this.f12419g = fbNetworkManager;
        this.f12420h = executorService;
        this.f12421i = clock;
        this.f12423k = graphQLQueryExecutor;
        this.f12424l = offlineModeHelper;
        this.f12425m = offlineCommentsExecutorHelper;
    }

    public void init() {
        if (this.f12424l.m18532a()) {
            this.f12418f.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new 1(this)).mo503a().m3296b();
            m18491a(this, ProcessQueueTrigger.COLD_START);
        }
    }

    public static void m18491a(OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor, ProcessQueueTrigger processQueueTrigger) {
        if (offlineObliviousOperationsExecutor.f12422j.compareAndSet(false, true)) {
            ExecutorDetour.a(offlineObliviousOperationsExecutor.f12420h, new 2(offlineObliviousOperationsExecutor, processQueueTrigger), -1502101391);
        }
    }

    public static void m18493b(OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor, ProcessQueueTrigger processQueueTrigger) {
        long a = offlineObliviousOperationsExecutor.f12421i.mo211a();
        ImmutableList a2 = offlineObliviousOperationsExecutor.f12417e.m18503a();
        int size = a2.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            PendingRequest pendingRequest = (PendingRequest) a2.get(i4);
            if (pendingRequest.a(a)) {
                offlineObliviousOperationsExecutor.m18490a(pendingRequest, "offline_mode_operation_expired");
                i2++;
            } else {
                Object obj = null;
                if (pendingRequest.g > 0 && pendingRequest.f >= pendingRequest.g) {
                    obj = 1;
                }
                if (obj != null) {
                    offlineObliviousOperationsExecutor.m18490a(pendingRequest, "offline_mode_operation_retry_limit_reached");
                    i2++;
                } else if (offlineObliviousOperationsExecutor.f12419g.m3828d()) {
                    offlineObliviousOperationsExecutor.m18490a(pendingRequest, null);
                    offlineObliviousOperationsExecutor.m18488a(pendingRequest);
                    i3++;
                } else {
                    i++;
                }
            }
        }
        if (!a2.isEmpty()) {
            offlineObliviousOperationsExecutor.f12424l.m18530a(a2, i3, i2, i, processQueueTrigger, a);
        }
    }

    private void m18490a(PendingRequest pendingRequest, String str) {
        this.f12417e.m18505a(pendingRequest.b);
        if (!Strings.isNullOrEmpty(str)) {
            this.f12424l.m18531a(str, pendingRequest);
        }
    }

    public final ListenableFuture<OperationResult> m18494a(BlueServiceOperationFactory$Operation blueServiceOperationFactory$Operation) {
        Preconditions.checkNotNull(blueServiceOperationFactory$Operation);
        return m18486a(blueServiceOperationFactory$Operation, f12412a);
    }

    private ListenableFuture<OperationResult> m18486a(BlueServiceOperationFactory$Operation blueServiceOperationFactory$Operation, OfflineExceptionTreatment offlineExceptionTreatment) {
        Preconditions.checkNotNull(blueServiceOperationFactory$Operation);
        return m18487a(blueServiceOperationFactory$Operation, null, 0, PendingRequest.a, 0, m18484a(), offlineExceptionTreatment);
    }

    public final ListenableFuture<OperationResult> m18495a(BlueServiceOperationFactory$Operation blueServiceOperationFactory$Operation, long j, int i, OfflineExceptionTreatment offlineExceptionTreatment) {
        Preconditions.checkNotNull(blueServiceOperationFactory$Operation);
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(i >= 0);
        return m18487a(blueServiceOperationFactory$Operation, null, 0, j, 0, i, offlineExceptionTreatment);
    }

    private ListenableFuture<OperationResult> m18487a(BlueServiceOperationFactory$Operation blueServiceOperationFactory$Operation, @Nullable String str, long j, long j2, int i, int i2, OfflineExceptionTreatment offlineExceptionTreatment) {
        ListenableFuture a = blueServiceOperationFactory$Operation.mo3452a();
        boolean z = j <= 0;
        ListenableFuture f = SettableFuture.m1547f();
        Futures.m2458a(a, new 3(this, z, blueServiceOperationFactory$Operation, str, j, j2, i, i2, f, offlineExceptionTreatment), this.f12420h);
        return f;
    }

    @VisibleForTesting
    private ListenableFuture<?> m18488a(PendingRequest pendingRequest) {
        if (pendingRequest instanceof PendingBlueServiceRequest) {
            return m18489a((PendingBlueServiceRequest) pendingRequest);
        }
        if (pendingRequest instanceof PendingGraphQlMutationRequest) {
            pendingRequest = (PendingGraphQlMutationRequest) pendingRequest;
            ListenableFuture a = this.f12423k.m10450a((PendingGraphQlMutationRequest) pendingRequest, OfflineQueryBehavior.c);
            OfflineCommentsExecutorHelper offlineCommentsExecutorHelper = this.f12425m;
            if (pendingRequest.h == AddCommentString.class) {
                CommentCreateShimMutationFragmentModel commentCreateShimMutationFragmentModel = (CommentCreateShimMutationFragmentModel) pendingRequest.j;
                if (!(commentCreateShimMutationFragmentModel == null || commentCreateShimMutationFragmentModel.a() == null)) {
                    Futures.m2458a(a, new 1(offlineCommentsExecutorHelper, commentCreateShimMutationFragmentModel.a().m27164H()), offlineCommentsExecutorHelper.f12466a);
                }
            }
            this.f12424l.m18535b(pendingRequest);
            return a;
        }
        throw new IllegalArgumentException("Don't know how to submit a PendingRequest of type" + pendingRequest.getClass());
    }

    private ListenableFuture<OperationResult> m18489a(PendingBlueServiceRequest pendingBlueServiceRequest) {
        ListenableFuture<OperationResult> a = m18487a(BlueServiceOperationFactoryDetour.a(this.f12416d, pendingBlueServiceRequest.h, pendingBlueServiceRequest.i, 114048726), pendingBlueServiceRequest.b, pendingBlueServiceRequest.d, pendingBlueServiceRequest.e, pendingBlueServiceRequest.f, pendingBlueServiceRequest.g, f12412a);
        this.f12424l.m18535b((PendingRequest) pendingBlueServiceRequest);
        return a;
    }

    public static int m18484a() {
        return 1000;
    }
}
