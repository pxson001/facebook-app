package com.facebook.api.feedcache.mutator;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.FeedUnitCache.MutationType;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.data.followup.FollowUpActionDecider;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.logging.StoryLikeHistoryLogger.Type;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnitItem;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleToFollowConnection;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsConnection;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsConnection;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.PropertyBag;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: cta_lead_gen_visit_offsite_click */
public class FeedUnitCacheMutator {
    public static final CallerContext f16415a = CallerContext.a(FeedUnitCacheMutator.class, "native_newsfeed");
    private static volatile FeedUnitCacheMutator f16416p;
    public final FeedUnitCache f16417b;
    private final Provider<GraphQLActorCache> f16418c;
    public final Lazy<FeedStoryMutator> f16419d;
    private final DefaultBlueServiceOperationFactory f16420e;
    private final StoryLikeHistoryLogger f16421f;
    public final AbstractFbErrorReporter f16422g;
    public final AnalyticsLogger f16423h;
    public final ErrorMessageGenerator f16424i;
    public final CommonEventsBuilder f16425j;
    private final TasksManager<String> f16426k;
    public final ModernFeedbackGraphQLGenerator f16427l;
    public final Lazy<FollowUpActionDecider> f16428m;
    private final OptimisticStoryStateCache f16429n;
    private final NewsfeedAnalyticsLogger f16430o;

    public static com.facebook.api.feedcache.mutator.FeedUnitCacheMutator m20504a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16416p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.mutator.FeedUnitCacheMutator.class;
        monitor-enter(r1);
        r0 = f16416p;	 Catch:{ all -> 0x003a }
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
        r0 = m20508b(r0);	 Catch:{ all -> 0x0035 }
        f16416p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16416p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.mutator.FeedUnitCacheMutator.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.mutator.FeedUnitCacheMutator");
    }

    private static FeedUnitCacheMutator m20508b(InjectorLike injectorLike) {
        return new FeedUnitCacheMutator(FeedUnitCache.a(injectorLike), IdBasedLazy.a(injectorLike, 994), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 262), StoryLikeHistoryLogger.m22799a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ErrorMessageGenerator.b(injectorLike), CommonEventsBuilder.b(injectorLike), TasksManager.b(injectorLike), ModernFeedbackGraphQLGenerator.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1314), OptimisticStoryStateCache.a(injectorLike), NewsfeedAnalyticsLogger.b(injectorLike));
    }

    @Inject
    public FeedUnitCacheMutator(FeedUnitCache feedUnitCache, Lazy<FeedStoryMutator> lazy, BlueServiceOperationFactory blueServiceOperationFactory, Provider<GraphQLActorCache> provider, StoryLikeHistoryLogger storyLikeHistoryLogger, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, ErrorMessageGenerator errorMessageGenerator, CommonEventsBuilder commonEventsBuilder, TasksManager tasksManager, ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator, Lazy<FollowUpActionDecider> lazy2, OptimisticStoryStateCache optimisticStoryStateCache, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger) {
        this.f16417b = feedUnitCache;
        this.f16419d = lazy;
        this.f16420e = blueServiceOperationFactory;
        this.f16418c = provider;
        this.f16421f = storyLikeHistoryLogger;
        this.f16422g = fbErrorReporter;
        this.f16423h = analyticsLogger;
        this.f16424i = errorMessageGenerator;
        this.f16425j = commonEventsBuilder;
        this.f16426k = tasksManager;
        this.f16427l = modernFeedbackGraphQLGenerator;
        this.f16428m = lazy2;
        this.f16429n = optimisticStoryStateCache;
        this.f16430o = newsfeedAnalyticsLogger;
    }

    public final void m20511a(FeedProps<GraphQLStory> feedProps) {
        if (feedProps != null) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (graphQLStory != null && graphQLStory.z()) {
                GraphQLActor a = ((GraphQLActorCacheImpl) this.f16418c.get()).a();
                boolean z = !graphQLStory.B();
                String j = graphQLStory.l().j();
                if (j == null) {
                    throw new RuntimeException("Like a story with no feedback id is not supported yet");
                }
                m20505a(this, j, z, null, Type.EVENT);
                FeedProps a2 = ((FeedStoryMutator) this.f16419d.get()).a(feedProps, a, z);
                GraphQLStory graphQLStory2 = (GraphQLStory) a2.a;
                FeedProps b = feedProps.b(graphQLStory2);
                FeedUnit f = StoryProps.f(a2);
                if (f == null) {
                    this.f16422g.b("FeedUnitCacheMutator", "Feedbackable should either be a FeedUnit or it's root should be a FeedUnit");
                } else if (f.g() == null) {
                    this.f16417b.a(f);
                } else {
                    this.f16417b.b(f);
                }
                if (f != null && z && (f instanceof GraphQLStory)) {
                    ((FollowUpActionDecider) this.f16428m.get()).a(FeedProps.c((GraphQLStory) f), GraphQLFollowUpFeedUnitActionType.LIKE, f16415a);
                }
                GraphQLFeedback l = graphQLStory2.l();
                if (l.z_() == null && l.j() == null) {
                    this.f16422g.a("like_attempt_empty_feedback", (("empty feedback for type " + graphQLStory2.getClass() + " " + graphQLStory2.toString() + " " + l.toString()) + " id=" + graphQLStory2.a()) + " pubstate=" + this.f16429n.a(graphQLStory2));
                    return;
                }
                m20505a(this, l.j(), z, null, Type.ATTEMPT);
                this.f16423h.a(CommonEventsBuilder.a("newsfeed_story_like", l.j(), String.valueOf(l.y_()), "native_newsfeed"));
                m20506a(b, l, a, graphQLStory);
            }
        }
    }

    public static void m20505a(FeedUnitCacheMutator feedUnitCacheMutator, String str, boolean z, String str2, Type type) {
        feedUnitCacheMutator.f16421f.m22801a(str, feedUnitCacheMutator, z, str2, type);
    }

    private void m20506a(FeedProps<GraphQLStory> feedProps, GraphQLFeedback graphQLFeedback, GraphQLActor graphQLActor, GraphQLStory graphQLStory) {
        Builder newBuilder = FeedbackLoggingParams.newBuilder();
        newBuilder.a = TrackableFeedProps.a(feedProps);
        Builder builder = newBuilder;
        builder.b = "newsfeed_ufi";
        builder.c = FeedPerfLogger.x();
        this.f16430o.a(graphQLStory, newBuilder);
        final String j = graphQLFeedback.j();
        final boolean y_ = graphQLFeedback.y_();
        TogglePostLikeParams.Builder a = TogglePostLikeParams.a();
        a.b = graphQLFeedback.y_();
        a = a;
        a.c = graphQLActor;
        a = a;
        a.d = newBuilder.a();
        TogglePostLikeParams.Builder builder2 = a;
        builder2.e = graphQLFeedback;
        final TogglePostLikeParams a2 = builder2.a();
        final FeedProps<GraphQLStory> feedProps2 = feedProps;
        final GraphQLActor graphQLActor2 = graphQLActor;
        final GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
        this.f16426k.a("task_key_newsfeed_set_like_" + graphQLFeedback.j() + "_" + System.nanoTime(), new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ FeedUnitCacheMutator f16408b;

            public Object call() {
                return this.f16408b.f16427l.a(a2);
            }
        }, new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ FeedUnitCacheMutator f16414f;

            public final void m20502a(Object obj) {
                FeedUnitCacheMutator.m20505a(this.f16414f, j, y_, null, Type.SUCCESS);
            }

            protected final void m20503a(Throwable th) {
                this.f16414f.f16422g.a("toggle_like_fail", th);
                if (th instanceof ServiceException) {
                    Object obj;
                    ServiceException serviceException = (ServiceException) th;
                    if (serviceException.errorCode == ErrorCode.API_ERROR || serviceException.errorCode == ErrorCode.HTTP_400_AUTHENTICATION || serviceException.errorCode == ErrorCode.HTTP_400_OTHER || serviceException.errorCode == ErrorCode.HTTP_500_CLASS || serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        FeedUnitCacheMutator.m20505a(this.f16414f, j, y_, th.getMessage(), Type.FAILURE);
                        return;
                    }
                }
                FeedUnit f = StoryProps.f(((FeedStoryMutator) this.f16414f.f16419d.get()).a(feedProps2, graphQLActor2, !graphQLFeedback2.y_()));
                if (f == null) {
                    this.f16414f.f16422g.b("FeedUnitCacheMutator", "Feedbackable should either be a FeedUnit or it's root should be a FeedUnit");
                } else {
                    this.f16414f.f16417b.b(f);
                }
                AnalyticsLogger analyticsLogger = this.f16414f.f16423h;
                CommonEventsBuilder commonEventsBuilder = this.f16414f.f16425j;
                analyticsLogger.a(CommonEventsBuilder.a("newsfeed_story_like_fail", graphQLFeedback2.j(), String.valueOf(graphQLFeedback2.y_()), "native_newsfeed"));
                FeedUnitCacheMutator.m20505a(this.f16414f, j, y_, this.f16414f.f16424i.a(ServiceException.a(th), true, true), Type.FAILURE);
                this.f16414f.f16417b.a(f, MutationType.LIKE, th);
            }
        });
    }

    public final void m20515a(String str, String str2) {
        FeedUnit d = this.f16417b.d(str);
        if (d != null) {
            FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
            GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) d;
            ImmutableList l = graphQLGroupsYouShouldCreateFeedUnit.l();
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = (GraphQLGroupsYouShouldCreateFeedUnitItem) l.get(i);
                if (!graphQLGroupsYouShouldCreateFeedUnitItem.p().equals(str2)) {
                    builder.c(graphQLGroupsYouShouldCreateFeedUnitItem);
                }
            }
            GraphQLGroupsYouShouldCreateFeedUnit.Builder builder2 = new GraphQLGroupsYouShouldCreateFeedUnit.Builder();
            graphQLGroupsYouShouldCreateFeedUnit.h();
            builder2.d = graphQLGroupsYouShouldCreateFeedUnit.g();
            builder2.e = graphQLGroupsYouShouldCreateFeedUnit.S_();
            builder2.f = graphQLGroupsYouShouldCreateFeedUnit.T_();
            builder2.g = graphQLGroupsYouShouldCreateFeedUnit.o();
            builder2.h = graphQLGroupsYouShouldCreateFeedUnit.p();
            builder2.i = graphQLGroupsYouShouldCreateFeedUnit.q();
            builder2.j = graphQLGroupsYouShouldCreateFeedUnit.r();
            builder2.k = graphQLGroupsYouShouldCreateFeedUnit.s();
            builder2.l = graphQLGroupsYouShouldCreateFeedUnit.k();
            BaseModel.Builder.a(builder2, graphQLGroupsYouShouldCreateFeedUnit);
            builder2.m = (PropertyBag) graphQLGroupsYouShouldCreateFeedUnit.U_().clone();
            GraphQLGroupsYouShouldCreateFeedUnit.Builder builder3 = builder2;
            builder3.f = feedStoryMutator.i.a();
            builder3 = builder3;
            builder3.i = builder.b();
            GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit2 = new GraphQLGroupsYouShouldCreateFeedUnit(builder3);
            if (graphQLGroupsYouShouldCreateFeedUnit2 != null) {
                this.f16417b.a(graphQLGroupsYouShouldCreateFeedUnit2);
                this.f16417b.b(graphQLGroupsYouShouldCreateFeedUnit2);
            }
        }
    }

    public final void m20514a(GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit, String str) {
        FeedUnit feedUnit;
        m20507a(str);
        if (groupsYouShouldJoinFeedUnit instanceof GraphQLGroupsYouShouldJoinFeedUnit) {
            FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
            GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) groupsYouShouldJoinFeedUnit;
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList a = ScrollableItemListFeedUnitImpl.a(graphQLGroupsYouShouldJoinFeedUnit);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem = (GraphQLGroupsYouShouldJoinFeedUnitItem) a.get(i);
                if (!(graphQLGroupsYouShouldJoinFeedUnitItem.m() == null || Objects.equal(graphQLGroupsYouShouldJoinFeedUnitItem.m().I(), str))) {
                    builder.c(graphQLGroupsYouShouldJoinFeedUnitItem);
                }
            }
            ImmutableList b = builder.b();
            GraphQLGroupsYouShouldJoinFeedUnit.Builder builder2 = new GraphQLGroupsYouShouldJoinFeedUnit.Builder();
            graphQLGroupsYouShouldJoinFeedUnit.h();
            builder2.d = graphQLGroupsYouShouldJoinFeedUnit.g();
            builder2.e = graphQLGroupsYouShouldJoinFeedUnit.S_();
            builder2.f = graphQLGroupsYouShouldJoinFeedUnit.T_();
            builder2.g = graphQLGroupsYouShouldJoinFeedUnit.l();
            builder2.h = graphQLGroupsYouShouldJoinFeedUnit.o();
            builder2.i = graphQLGroupsYouShouldJoinFeedUnit.p();
            builder2.j = graphQLGroupsYouShouldJoinFeedUnit.q();
            builder2.k = graphQLGroupsYouShouldJoinFeedUnit.r();
            builder2.l = graphQLGroupsYouShouldJoinFeedUnit.k();
            BaseModel.Builder.a(builder2, graphQLGroupsYouShouldJoinFeedUnit);
            builder2.m = (PropertyBag) graphQLGroupsYouShouldJoinFeedUnit.U_().clone();
            GraphQLGroupsYouShouldJoinFeedUnit.Builder builder3 = builder2;
            builder3.i = b;
            builder3 = builder3;
            builder3.g = b;
            builder3 = builder3;
            builder3.f = feedStoryMutator.i.a();
            GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit2 = (GraphQLGroupsYouShouldJoinFeedUnit) FeedUnitMutator.a(new GraphQLGroupsYouShouldJoinFeedUnit(builder3)).b(FeedStoryMutator.a(graphQLGroupsYouShouldJoinFeedUnit.s().c, str)).a();
            VisibleItemHelper.a(graphQLGroupsYouShouldJoinFeedUnit2, FeedStoryMutator.a(b.size(), graphQLGroupsYouShouldJoinFeedUnit.ac_()));
            feedUnit = graphQLGroupsYouShouldJoinFeedUnit2;
        } else {
            feedUnit = ((FeedStoryMutator) this.f16419d.get()).a((GraphQLPaginatedGroupsYouShouldJoinFeedUnit) groupsYouShouldJoinFeedUnit, str);
        }
        this.f16417b.d(feedUnit);
        this.f16417b.b(feedUnit);
    }

    private void m20507a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("blacklistGroupsYouShouldJoinParamsKey", str);
        BlueServiceOperationFactoryDetour.a(this.f16420e, "group_blacklist_groups_you_should_join", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(FeedUnitCacheMutator.class), -762407086).a();
    }

    public final void m20513a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, String str) {
        m20507a(str);
        FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = ScrollableItemListFeedUnitImpl.a(graphQLSaleGroupsNearYouFeedUnit);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) a.get(i);
            if (!(graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j() == null || Objects.equal(graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j().I(), str))) {
                builder.c(graphQLSaleGroupsNearYouFeedUnitGroupsEdge);
            }
        }
        ImmutableList b = builder.b();
        GraphQLSaleGroupsNearYouFeedUnit.Builder a2 = GraphQLSaleGroupsNearYouFeedUnit.Builder.a(graphQLSaleGroupsNearYouFeedUnit);
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.Builder a3 = GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.Builder.a(graphQLSaleGroupsNearYouFeedUnit.o());
        a3.d = b;
        a2.d = a3.a();
        a2 = a2;
        a2.g = feedStoryMutator.i.a();
        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit2 = (GraphQLSaleGroupsNearYouFeedUnit) FeedUnitMutator.a(a2.a()).b(FeedStoryMutator.a(graphQLSaleGroupsNearYouFeedUnit.u().c, str)).a();
        VisibleItemHelper.a(graphQLSaleGroupsNearYouFeedUnit2, FeedStoryMutator.a(b.size(), graphQLSaleGroupsNearYouFeedUnit.ac_()));
        FeedUnit feedUnit = graphQLSaleGroupsNearYouFeedUnit2;
        if (feedUnit != null) {
            this.f16417b.d(feedUnit);
            this.f16417b.b(feedUnit);
        }
    }

    @Nullable
    public final GraphQLPeopleYouMayInviteFeedUnit m20509a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit, String str) {
        FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList l = graphQLPeopleYouMayInviteFeedUnit.l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) l.get(i);
            if (!StringUtil.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge.k(), str)) {
                builder.c(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
            }
        }
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder a = GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder.a(graphQLPeopleYouMayInviteFeedUnit.u());
        a.d = builder.b();
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection a2 = a.a();
        GraphQLPeopleYouMayInviteFeedUnit.Builder a3 = GraphQLPeopleYouMayInviteFeedUnit.Builder.a(graphQLPeopleYouMayInviteFeedUnit);
        a3.f = a2;
        GraphQLPeopleYouMayInviteFeedUnit.Builder builder2 = a3;
        builder2.n = feedStoryMutator.i.a();
        GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit2 = (GraphQLPeopleYouMayInviteFeedUnit) FeedUnitMutator.a(builder2.a()).b(FeedStoryMutator.a(graphQLPeopleYouMayInviteFeedUnit.U().c, str)).a();
        VisibleItemHelper.a(graphQLPeopleYouMayInviteFeedUnit2, graphQLPeopleYouMayInviteFeedUnit.ac_());
        if (!IsValidUtil.a(graphQLPeopleYouMayInviteFeedUnit2)) {
            graphQLPeopleYouMayInviteFeedUnit2 = null;
        }
        FeedUnit feedUnit = graphQLPeopleYouMayInviteFeedUnit2;
        if (feedUnit != null) {
            this.f16417b.d(feedUnit);
            this.f16417b.b(feedUnit);
        }
        return feedUnit;
    }

    public final GraphQLPeopleYouShouldFollowFeedUnit m20510a(GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit, String str) {
        FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
        ImmutableList a = graphQLPeopleYouShouldFollowFeedUnit.q().a();
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Object obj = (GraphQLPeopleYouShouldFollowFeedUnitItem) a.get(i);
            if (obj.k().equals(str)) {
                GraphQLUser m = obj.m();
                GraphQLUser.Builder builder2 = new GraphQLUser.Builder();
                m.h();
                builder2.d = m.j();
                builder2.e = m.k();
                builder2.f = m.bx();
                builder2.g = m.l();
                builder2.h = m.m();
                builder2.i = m.n();
                builder2.j = m.by();
                builder2.k = m.o();
                builder2.l = m.p();
                builder2.m = m.q();
                builder2.n = m.r();
                builder2.o = m.s();
                builder2.p = m.t();
                builder2.q = m.u();
                builder2.r = m.v();
                builder2.s = m.w();
                builder2.t = m.x();
                builder2.u = m.y();
                builder2.v = m.z();
                builder2.w = m.A();
                builder2.x = m.B();
                builder2.y = m.bw();
                builder2.z = m.C();
                builder2.A = m.D();
                builder2.B = m.E();
                builder2.C = m.F();
                builder2.D = m.G();
                builder2.E = m.H();
                builder2.F = m.I();
                builder2.G = m.J();
                builder2.H = m.K();
                builder2.I = m.L();
                builder2.J = m.M();
                builder2.K = m.N();
                builder2.L = m.bD();
                builder2.M = m.O();
                builder2.N = m.P();
                builder2.O = m.Q();
                builder2.P = m.R();
                builder2.Q = m.S();
                builder2.R = m.T();
                builder2.S = m.U();
                builder2.T = m.V();
                builder2.U = m.W();
                builder2.V = m.X();
                builder2.W = m.bC();
                builder2.X = m.Y();
                builder2.Y = m.Z();
                builder2.Z = m.aa();
                builder2.aa = m.ab();
                builder2.ab = m.ac();
                builder2.ac = m.ad();
                builder2.ad = m.ae();
                builder2.ae = m.af();
                builder2.af = m.ag();
                builder2.ag = m.ah();
                builder2.ah = m.ai();
                builder2.ai = m.aj();
                builder2.aj = m.ak();
                builder2.ak = m.al();
                builder2.al = m.am();
                builder2.am = m.an();
                builder2.an = m.ao();
                builder2.ao = m.ap();
                builder2.ap = m.bA();
                builder2.aq = m.aq();
                builder2.ar = m.ar();
                builder2.as = m.as();
                builder2.at = m.at();
                builder2.au = m.au();
                builder2.av = m.av();
                builder2.aw = m.aw();
                builder2.ax = m.ax();
                builder2.ay = m.ay();
                builder2.az = m.az();
                builder2.aA = m.aA();
                builder2.aB = m.aB();
                builder2.aC = m.aC();
                builder2.aD = m.aD();
                builder2.aE = m.aE();
                builder2.aF = m.aF();
                builder2.aG = m.aG();
                builder2.aH = m.aH();
                builder2.aI = m.aI();
                builder2.aJ = m.aJ();
                builder2.aK = m.aK();
                builder2.aL = m.bF();
                builder2.aM = m.aL();
                builder2.aN = m.aM();
                builder2.aO = m.aN();
                builder2.aP = m.aO();
                builder2.aQ = m.aP();
                builder2.aR = m.aQ();
                builder2.aS = m.bB();
                builder2.aT = m.aR();
                builder2.aU = m.aS();
                builder2.aV = m.aT();
                builder2.aW = m.aU();
                builder2.aX = m.aV();
                builder2.aY = m.aW();
                builder2.aZ = m.aX();
                builder2.ba = m.aY();
                builder2.bb = m.aZ();
                builder2.bc = m.ba();
                builder2.bd = m.bb();
                builder2.be = m.bc();
                builder2.bf = m.bE();
                builder2.bg = m.bz();
                builder2.bh = m.bd();
                builder2.bi = m.be();
                builder2.bj = m.bf();
                builder2.bk = m.bg();
                builder2.bl = m.bh();
                builder2.bm = m.bi();
                builder2.bn = m.bj();
                builder2.bo = m.bk();
                builder2.bp = m.bl();
                builder2.bq = m.bm();
                builder2.br = m.bn();
                builder2.bs = m.bo();
                builder2.bt = m.bp();
                builder2.bu = m.bq();
                builder2.bv = m.br();
                builder2.bw = m.bs();
                builder2.bx = m.bt();
                builder2.by = m.bu();
                builder2.bz = m.bv();
                BaseModel.Builder.a(builder2, m);
                GraphQLUser.Builder builder3 = builder2;
                builder3.ac = true;
                m = builder3.a();
                GraphQLPeopleYouShouldFollowFeedUnitItem.Builder builder4 = new GraphQLPeopleYouShouldFollowFeedUnitItem.Builder();
                obj.h();
                builder4.d = obj.j();
                builder4.e = obj.l();
                builder4.f = obj.k();
                builder4.g = obj.m();
                BaseModel.Builder.a(builder4, obj);
                builder4.h = (PropertyBag) obj.U_().clone();
                GraphQLPeopleYouShouldFollowFeedUnitItem.Builder builder5 = builder4;
                builder5.g = m;
                obj = new GraphQLPeopleYouShouldFollowFeedUnitItem(builder5);
            }
            builder.c(obj);
        }
        GraphQLPeopleToFollowConnection q = graphQLPeopleYouShouldFollowFeedUnit.q();
        GraphQLPeopleToFollowConnection.Builder builder6 = new GraphQLPeopleToFollowConnection.Builder();
        q.h();
        builder6.d = q.a();
        BaseModel.Builder.a(builder6, q);
        GraphQLPeopleToFollowConnection.Builder builder7 = builder6;
        builder7.d = builder.b();
        q = new GraphQLPeopleToFollowConnection(builder7);
        GraphQLPeopleYouShouldFollowFeedUnit.Builder a2 = GraphQLPeopleYouShouldFollowFeedUnit.Builder.a(graphQLPeopleYouShouldFollowFeedUnit);
        a2.h = q;
        GraphQLPeopleYouShouldFollowFeedUnit.Builder builder8 = a2;
        builder8.f = feedStoryMutator.i.a();
        GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit2 = new GraphQLPeopleYouShouldFollowFeedUnit(builder8);
        if (!IsValidUtil.a(graphQLPeopleYouShouldFollowFeedUnit2)) {
            graphQLPeopleYouShouldFollowFeedUnit2 = null;
        }
        GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit3 = graphQLPeopleYouShouldFollowFeedUnit2;
        if (graphQLPeopleYouShouldFollowFeedUnit3 != null) {
            this.f16417b.a(graphQLPeopleYouShouldFollowFeedUnit3);
            this.f16417b.b(graphQLPeopleYouShouldFollowFeedUnit3);
        }
        return graphQLPeopleYouShouldFollowFeedUnit3;
    }

    public final void m20512a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit, GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge) {
        FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f16419d.get();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList l = graphQLPeopleYouMayInviteFeedUnit.l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge2 = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) l.get(i);
            if (StringUtil.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge2.k(), graphQLPeopleYouMayInviteFeedUnitContactsEdge.k())) {
                builder.c(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
            } else {
                builder.c(graphQLPeopleYouMayInviteFeedUnitContactsEdge2);
            }
        }
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder a = GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder.a(graphQLPeopleYouMayInviteFeedUnit.u());
        a.d = builder.b();
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection a2 = a.a();
        GraphQLPeopleYouMayInviteFeedUnit.Builder a3 = GraphQLPeopleYouMayInviteFeedUnit.Builder.a(graphQLPeopleYouMayInviteFeedUnit);
        a3.f = a2;
        GraphQLPeopleYouMayInviteFeedUnit.Builder builder2 = a3;
        builder2.n = feedStoryMutator.i.a();
        GraphQLPeopleYouMayInviteFeedUnit a4 = builder2.a();
        VisibleItemHelper.a(a4, graphQLPeopleYouMayInviteFeedUnit.ac_());
        if (!IsValidUtil.a(a4)) {
            a4 = null;
        }
        FeedUnit feedUnit = a4;
        if (feedUnit != null) {
            this.f16417b.d(feedUnit);
            this.f16417b.b(feedUnit);
        }
    }
}
