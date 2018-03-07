package com.facebook.facecastdisplay.friendInviter;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoInvitedFriendsString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoRecentInviteesString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoInvitedFriendsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoInvitedFriendsModel.AlreadyInvitedLiveViewersModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoRecentInviteesModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoRecentInviteesModel.RecentLiveViewerInviteesModel.EdgesModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: attachMeasuredRootViewToInstance */
public class LiveVideoInviteFriendCache {
    public static final String f19047a = LiveVideoInviteFriendCache.class.getName();
    private static volatile LiveVideoInviteFriendCache f19048k;
    public final List<String> f19049b = new ArrayList();
    public final GraphQLQueryExecutor f19050c;
    public final ExecutorService f19051d;
    public final AbstractFbErrorReporter f19052e;
    public final String f19053f;
    @Nullable
    public String f19054g;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchLiveVideoInvitedFriendsModel>> f19055h;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchLiveVideoRecentInviteesModel>> f19056i;
    public ImmutableList<String> f19057j = RegularImmutableList.a;

    /* compiled from: attachMeasuredRootViewToInstance */
    public class C16581 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoInvitedFriendsModel>> {
        final /* synthetic */ LiveVideoInviteFriendCache f19045a;

        public C16581(LiveVideoInviteFriendCache liveVideoInviteFriendCache) {
            this.f19045a = liveVideoInviteFriendCache;
        }

        protected final void m22621a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                FetchLiveVideoInvitedFriendsModel fetchLiveVideoInvitedFriendsModel = (FetchLiveVideoInvitedFriendsModel) graphQLResult.e;
                if (fetchLiveVideoInvitedFriendsModel.m3704a() != null) {
                    ImmutableList a = fetchLiveVideoInvitedFriendsModel.m3704a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        AlreadyInvitedLiveViewersModel alreadyInvitedLiveViewersModel = (AlreadyInvitedLiveViewersModel) a.get(i);
                        if (alreadyInvitedLiveViewersModel.m3699j() != null) {
                            this.f19045a.f19049b.add(alreadyInvitedLiveViewersModel.m3699j());
                        }
                    }
                }
            }
        }

        protected final void m22622a(Throwable th) {
            this.f19045a.f19052e.a(LiveVideoInviteFriendCache.f19047a + "_graphFailure", "Failed to fetch invited friends for " + this.f19045a.f19054g, th);
        }
    }

    /* compiled from: attachMeasuredRootViewToInstance */
    public class C16592 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoRecentInviteesModel>> {
        final /* synthetic */ LiveVideoInviteFriendCache f19046a;

        public C16592(LiveVideoInviteFriendCache liveVideoInviteFriendCache) {
            this.f19046a = liveVideoInviteFriendCache;
        }

        protected final void m22623a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                FetchLiveVideoRecentInviteesModel fetchLiveVideoRecentInviteesModel = (FetchLiveVideoRecentInviteesModel) graphQLResult.e;
                if (fetchLiveVideoRecentInviteesModel.m3747a() != null && fetchLiveVideoRecentInviteesModel.m3747a().m3744a() != null) {
                    Builder builder = new Builder();
                    ImmutableList a = fetchLiveVideoRecentInviteesModel.m3747a().m3744a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (edgesModel.m3739a() != null) {
                            builder.c(edgesModel.m3739a().m3736j());
                        }
                    }
                    this.f19046a.f19057j = builder.b();
                }
            }
        }

        protected final void m22624a(Throwable th) {
            this.f19046a.f19052e.a(LiveVideoInviteFriendCache.f19047a + "_graphFailure", "Failed to fetch recent invitees for " + this.f19046a.f19053f, th);
        }
    }

    public static com.facebook.facecastdisplay.friendInviter.LiveVideoInviteFriendCache m22625a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19048k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecastdisplay.friendInviter.LiveVideoInviteFriendCache.class;
        monitor-enter(r1);
        r0 = f19048k;	 Catch:{ all -> 0x003a }
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
        r0 = m22626b(r0);	 Catch:{ all -> 0x0035 }
        f19048k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19048k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.friendInviter.LiveVideoInviteFriendCache.a(com.facebook.inject.InjectorLike):com.facebook.facecastdisplay.friendInviter.LiveVideoInviteFriendCache");
    }

    private static LiveVideoInviteFriendCache m22626b(InjectorLike injectorLike) {
        return new LiveVideoInviteFriendCache((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public LiveVideoInviteFriendCache(ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f19051d = executorService;
        this.f19050c = graphQLQueryExecutor;
        this.f19053f = str;
        this.f19052e = abstractFbErrorReporter;
    }

    public final void m22627a(String str) {
        if (str != null && !str.equals(this.f19054g)) {
            this.f19054g = str;
            this.f19049b.clear();
            if (this.f19055h != null) {
                this.f19055h.cancel(false);
            }
            GraphQlQueryString fetchLiveVideoInvitedFriendsString = new FetchLiveVideoInvitedFriendsString();
            fetchLiveVideoInvitedFriendsString.a("targetID", this.f19054g).a("count", Integer.valueOf(5));
            this.f19055h = this.f19050c.a(GraphQLRequest.a(fetchLiveVideoInvitedFriendsString));
            Futures.a(this.f19055h, new C16581(this), this.f19051d);
            if (this.f19056i != null) {
                this.f19056i.cancel(false);
            }
            fetchLiveVideoInvitedFriendsString = new FetchLiveVideoRecentInviteesString();
            fetchLiveVideoInvitedFriendsString.a("userID", this.f19053f);
            this.f19056i = this.f19050c.a(GraphQLRequest.a(fetchLiveVideoInvitedFriendsString));
            Futures.a(this.f19056i, new C16592(this), this.f19051d);
        }
    }
}
