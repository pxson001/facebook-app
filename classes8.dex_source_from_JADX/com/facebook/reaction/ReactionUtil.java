package com.facebook.reaction;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.calls.EntityCardContextSurfaceInputEntityCardContextSurface;
import com.facebook.graphql.calls.GametimeMatchReactionUnitsInputTriggerData;
import com.facebook.graphql.calls.GametimeMatchReactionUnitsInputTriggerData.ReactionContext;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LocationInputStoryRenderLocation;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.calls.SizesInputSizes;
import com.facebook.graphql.enums.GraphQLReactionCoreImageTextImageSize;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.LocationAgeUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.mediafetcher.query.ReactionStoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.ReactionStoryMediaWithAttributionQuery;
import com.facebook.photos.mediafetcher.query.ReactionStoryMediaWithAttributionQueryProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionSupportedActionStyles.ReactionExpensiveConditionalActionStyleProvider;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.common.ReactionAttachmentStyleMapper;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidCacheResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionCacheResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionEmptyRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureEvent;
import com.facebook.reaction.feed.corecomponents.util.ReactionCoreComponentsUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL.ReactionMoreAttachmentsQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL.ReactionMoreComponentsQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL.ReactionQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL.ReactionSuggestedEventsQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionMoreAttachmentsResultModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionSuggestedEventsQueryModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQL.ReactionMoreSubComponentsQueryString;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreComponentsResultModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.reviews.util.helper.ReviewsImageHelper;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: browser */
public class ReactionUtil {
    private static volatile ReactionUtil f18728G;
    private final Provider<VideoDashConfig> f18729A;
    private final FetchVideoChannelParamBuilderUtil f18730B;
    private final ExecutorService f18731C;
    private final Lazy<FbErrorReporter> f18732D;
    private final ScreenUtil f18733E;
    private final UniqueIdForDeviceHolderImpl f18734F;
    private final Lazy<AppChoreographer> f18735a;
    private final Lazy<AutomaticPhotoCaptioningUtils> f18736b;
    public final Clock f18737c;
    private final Context f18738d;
    public final GraphQLQueryExecutor f18739e;
    private final GraphQLImageHelper f18740f;
    private final GraphQLStoryHelper f18741g;
    private final Lazy<FbLocationStatusUtil> f18742h;
    public final ImmutableList<String> f18743i;
    private final Provider<String> f18744j;
    private final Product f18745k;
    public final ReactionAttachmentStyleMapper f18746l;
    public final ReactionEventBus f18747m;
    private final ReactionExperimentController f18748n;
    public final ReactionPerfLogger f18749o;
    private final ReactionStoryMediaQueryProvider f18750p;
    private final ReactionStoryMediaWithAttributionQueryProvider f18751q;
    public final ReactionSupportedActionStyles f18752r;
    private final ReviewsImageHelper f18753s;
    public final ImmutableList<String> f18754t = ImmutableList.of(GraphQLReactionUnitHeaderStyle.CENTER_ALIGNED.name(), GraphQLReactionUnitHeaderStyle.DESCRIPTIVE.name(), GraphQLReactionUnitHeaderStyle.ICON.name(), GraphQLReactionUnitHeaderStyle.ICON_INLINE_ACTION.name(), GraphQLReactionUnitHeaderStyle.ICON_PIVOT.name(), GraphQLReactionUnitHeaderStyle.THIN_FACEPILE.name());
    public final TasksManager<String> f18755u;
    private final SizeAwareImageUtil f18756v;
    public final ReactionUnitComponentStyleMapper f18757w;
    private final LocationAgeUtil f18758x;
    private final QeAccessor f18759y;
    private final MessengerAppUtils f18760z;

    /* compiled from: browser */
    class ReactionCacheSuccessCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionQueryFragmentModel>> {
        final /* synthetic */ ReactionUtil f18722a;
        private String f18723b;
        private long f18724c;

        protected final void m22632a(@Nullable Object obj) {
            Object obj2;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((ReactionQueryFragmentModel) graphQLResult.e).j() == null || ((ReactionQueryFragmentModel) graphQLResult.e).j().a().isEmpty()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                this.f18722a.f18749o.a(1966095, this.f18723b);
                this.f18722a.f18747m.a(new ReactionCacheResultEvent(((ReactionQueryFragmentModel) graphQLResult.e).j(), this.f18723b, graphQLResult.clientTimeMs - this.f18724c, this.f18724c));
                return;
            }
            this.f18722a.f18749o.b(1966095, this.f18723b);
            this.f18722a.f18747m.a(new InvalidCacheResponseEvent(graphQLResult == null ? "NO_CACHE_RESULT" : "INVALID_CACHE_RESULT", this.f18723b));
        }

        public ReactionCacheSuccessCallback(ReactionUtil reactionUtil, String str) {
            this.f18722a = reactionUtil;
            this.f18723b = str;
            this.f18724c = reactionUtil.f18737c.a();
        }

        protected final void m22633a(Throwable th) {
            this.f18722a.f18749o.a(1966095, this.f18723b, "NonCancellationFailure");
            this.f18722a.f18749o.b(1966095, this.f18723b);
            this.f18722a.f18747m.a(new RequestNonCancellationFailureEvent(th, this.f18723b));
        }
    }

    /* compiled from: browser */
    class ReactionSuccessCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionQueryFragmentModel>> {
        final /* synthetic */ ReactionUtil f18725a;
        private String f18726b;
        private long f18727c;

        protected final void m22634a(Object obj) {
            String str;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((ReactionQueryFragmentModel) graphQLResult.e).j() == null) {
                str = "ERROR_INVALID_RESPONSE";
            } else if (((ReactionQueryFragmentModel) graphQLResult.e).j().a().isEmpty()) {
                str = "NO_UNITS_RETURNED";
            } else {
                str = "SUCCESS";
            }
            String str2 = str;
            if ("SUCCESS".equals(str2)) {
                short s;
                if (DataFreshnessResult.FROM_SERVER.equals(graphQLResult.freshness)) {
                    s = (short) 27;
                } else {
                    s = (short) 25;
                }
                this.f18725a.f18749o.a.a(1966088, this.f18726b.hashCode(), s);
                this.f18725a.f18749o.a(1966088, this.f18726b);
                this.f18725a.f18749o.a(1966094, this.f18726b);
                this.f18725a.f18747m.a(new ReactionResultEvent(((ReactionQueryFragmentModel) graphQLResult.e).j(), this.f18726b, graphQLResult.clientTimeMs - this.f18727c, this.f18727c));
                return;
            }
            this.f18725a.f18749o.b(1966088, this.f18726b);
            this.f18725a.f18749o.b(1966094, this.f18726b);
            this.f18725a.f18747m.a(new InvalidResponseEvent(str2, this.f18726b));
        }

        public ReactionSuccessCallback(ReactionUtil reactionUtil, @Nonnull String str) {
            this.f18725a = reactionUtil;
            this.f18726b = str;
            this.f18727c = reactionUtil.f18737c.a();
        }

        protected final void m22635a(Throwable th) {
            this.f18725a.f18749o.b(1966088, this.f18726b);
            this.f18725a.f18749o.b(1966094, this.f18726b);
            this.f18725a.f18747m.a(new RequestNonCancellationFailureEvent(th, this.f18726b));
        }
    }

    public static com.facebook.reaction.ReactionUtil m22637a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18728G;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.ReactionUtil.class;
        monitor-enter(r1);
        r0 = f18728G;	 Catch:{ all -> 0x003a }
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
        r0 = m22642b(r0);	 Catch:{ all -> 0x0035 }
        f18728G = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18728G;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.ReactionUtil.a(com.facebook.inject.InjectorLike):com.facebook.reaction.ReactionUtil");
    }

    private static ReactionUtil m22642b(InjectorLike injectorLike) {
        return new ReactionUtil(IdBasedSingletonScopeProvider.b(injectorLike, 470), IdBasedLazy.a(injectorLike, 99), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 2483), GraphQLQueryExecutor.a(injectorLike), GraphQLImageHelper.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), GraphQLStoryHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), ReactionAttachmentStyleMapper.m22863a(injectorLike), ReactionEventBus.m22919a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionPerfLogger.a(injectorLike), (ReactionStoryMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionStoryMediaQueryProvider.class), (ReactionStoryMediaWithAttributionQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionStoryMediaWithAttributionQueryProvider.class), ReactionSupportedActionStyles.m22625a(injectorLike), ReviewsImageHelper.m4921a(injectorLike), TasksManager.a(injectorLike), SizeAwareImageUtil.a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike), LocationAgeUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MessengerAppUtils.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), FetchVideoChannelParamBuilderUtil.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), ScreenUtil.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike));
    }

    public final void m22664a(String str, DisposableFutureCallback<GraphQLResult<ReactionMoreSubComponentsResultModel>> disposableFutureCallback, int i, String str2, ReactionSession reactionSession) {
        boolean z;
        Surface surface = reactionSession.f18660c;
        ReactionQueryParams reactionQueryParams = reactionSession.f18682y;
        if (reactionQueryParams != null) {
            z = reactionQueryParams.f18619A;
        } else {
            z = false;
        }
        GraphQlQueryString graphQlQueryString = (ReactionMoreSubComponentsQueryString) new ReactionMoreSubComponentsQueryString().a("reaction_component_id", str2).a("reaction_after_cursor", str).a("topic_feeds_enabled", Boolean.valueOf(z)).a("reaction_result_count", Integer.toString(i));
        m22659a(graphQlQueryString, surface);
        this.f18755u.a(str2, this.f18739e.a(GraphQLRequest.a(graphQlQueryString)), disposableFutureCallback);
    }

    @Inject
    public ReactionUtil(Lazy<AppChoreographer> lazy, Lazy<AutomaticPhotoCaptioningUtils> lazy2, Clock clock, Context context, Lazy<FbLocationStatusUtil> lazy3, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, Product product, GraphQLStoryHelper graphQLStoryHelper, Provider<String> provider, ReactionAttachmentStyleMapper reactionAttachmentStyleMapper, ReactionEventBus reactionEventBus, ReactionExperimentController reactionExperimentController, ReactionPerfLogger reactionPerfLogger, ReactionStoryMediaQueryProvider reactionStoryMediaQueryProvider, ReactionStoryMediaWithAttributionQueryProvider reactionStoryMediaWithAttributionQueryProvider, ReactionSupportedActionStyles reactionSupportedActionStyles, ReviewsImageHelper reviewsImageHelper, TasksManager tasksManager, SizeAwareImageUtil sizeAwareImageUtil, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, LocationAgeUtil locationAgeUtil, QeAccessor qeAccessor, MessengerAppUtils messengerAppUtils, Provider<VideoDashConfig> provider2, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, ExecutorService executorService, Lazy<FbErrorReporter> lazy4, ScreenUtil screenUtil, UniqueIdForDeviceHolder uniqueIdForDeviceHolder) {
        this.f18735a = lazy;
        this.f18736b = lazy2;
        this.f18737c = clock;
        this.f18738d = context;
        this.f18739e = graphQLQueryExecutor;
        this.f18745k = product;
        this.f18748n = reactionExperimentController;
        this.f18742h = lazy3;
        this.f18740f = graphQLImageHelper;
        this.f18741g = graphQLStoryHelper;
        this.f18744j = provider;
        this.f18749o = reactionPerfLogger;
        this.f18746l = reactionAttachmentStyleMapper;
        this.f18747m = reactionEventBus;
        this.f18753s = reviewsImageHelper;
        this.f18750p = reactionStoryMediaQueryProvider;
        this.f18751q = reactionStoryMediaWithAttributionQueryProvider;
        this.f18752r = reactionSupportedActionStyles;
        this.f18760z = messengerAppUtils;
        this.f18730B = fetchVideoChannelParamBuilderUtil;
        this.f18755u = tasksManager;
        this.f18756v = sizeAwareImageUtil;
        this.f18757w = reactionUnitComponentStyleMapper;
        this.f18758x = locationAgeUtil;
        this.f18759y = qeAccessor;
        this.f18743i = ImmutableList.of(GraphQLReactionUnitStyle.FLUSH_TO_BOTTOM.name(), GraphQLReactionUnitStyle.PLACEHOLDER.name(), GraphQLReactionUnitStyle.STORY.name(), GraphQLReactionUnitStyle.UNIT_STACK.name(), GraphQLReactionUnitStyle.VERTICAL_COMPONENTS.name(), GraphQLReactionUnitStyle.VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND.name());
        this.f18729A = provider2;
        this.f18731C = executorService;
        this.f18732D = lazy4;
        this.f18733E = screenUtil;
        this.f18734F = uniqueIdForDeviceHolder;
    }

    public final void m22665a(String str, String str2, int i, CallerContext callerContext, DisposableFutureCallback disposableFutureCallback) {
        this.f18755u.a(str2, this.f18739e.a(new ReactionStoryMediaWithAttributionQuery(new IdQueryParam(str2), callerContext, MediaMetadataUtil.a(this.f18751q)).a(i, str).a(GraphQLCachePolicy.d)), disposableFutureCallback);
    }

    public final void m22660a(ReactionQueryParams reactionQueryParams, String str, Surface surface) {
        reactionQueryParams.f18620a = null;
        this.f18749o.a(1966088, str, surface);
        if (ReactionSurfaceUtil.m4784k(surface)) {
            this.f18749o.a(1966094, str, surface);
        }
        m22647c(reactionQueryParams, str, surface);
    }

    private void m22639a(ReactionQueryParams reactionQueryParams, ListenableFuture<GraphQLResult<ReactionQueryFragmentModel>> listenableFuture) {
        if (reactionQueryParams.f18634o == RequestPriority.INTERACTIVE) {
            ((DefaultAppChoreographer) this.f18735a.get()).a(listenableFuture);
        }
    }

    public final void m22662a(ReactionQueryParams reactionQueryParams, String str, Surface surface, GraphQLCachePolicy graphQLCachePolicy, long j, @Nullable GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        reactionQueryParams.f18620a = null;
        this.f18749o.a(1966088, str, surface);
        m22645b(reactionQueryParams, str, surface, graphQLCachePolicy, j, graphQLCacheKeySerializer);
    }

    final void m22658a(GraphQLBatchRequest graphQLBatchRequest, int i, ReactionQueryParams reactionQueryParams, String str, Surface surface, @Nullable DisposableFutureCallback disposableFutureCallback, @Nullable ExecutorService executorService, boolean z, long j, @Nullable GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        reactionQueryParams.f18620a = null;
        this.f18749o.a(1966088, str, surface);
        if (m22651e(reactionQueryParams, str, surface)) {
            GraphQLRequest d = m22648d(reactionQueryParams, str, surface);
            d.y = i;
            if (z) {
                GraphQLRequest a = d.a(GraphQLCachePolicy.d);
                a.b = true;
                a.a(j);
                if (graphQLCacheKeySerializer != null) {
                    d.a(graphQLCacheKeySerializer);
                }
            }
            ListenableFuture b = graphQLBatchRequest.b(d);
            m22639a(reactionQueryParams, b);
            Futures.a(b, new ReactionSuccessCallback(this, str), this.f18731C);
            if (!(disposableFutureCallback == null || executorService == null)) {
                Futures.a(b, disposableFutureCallback, executorService);
            }
            this.f18739e.a(graphQLBatchRequest);
            this.f18747m.a(new ReactionRequestEvent(str, reactionQueryParams));
            return;
        }
        ((AbstractFbErrorReporter) this.f18732D.get()).b(ReactionUtil.class.getSimpleName(), "Invalid query params when adding initial Reaction request into batch request. The batch request is not sent.");
    }

    public final void m22661a(ReactionQueryParams reactionQueryParams, String str, Surface surface, long j, @Nullable GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        if (m22651e(reactionQueryParams, str, surface)) {
            this.f18749o.a(1966095, str, surface);
            GraphQLRequest d = m22648d(reactionQueryParams, str, surface);
            GraphQLRequest a = d.a(GraphQLCachePolicy.b);
            a.b = true;
            a.a(j);
            if (graphQLCacheKeySerializer != null) {
                d.a(graphQLCacheKeySerializer);
            }
            this.f18755u.a(str, this.f18739e.a(d), new ReactionCacheSuccessCallback(this, str));
            this.f18747m.a(new ReactionRequestEvent(str, reactionQueryParams));
        }
    }

    public final boolean m22666a(ReactionSession reactionSession) {
        if (reactionSession == null || !reactionSession.f18673p || reactionSession.f18674q) {
            return false;
        }
        ReactionQueryParams reactionQueryParams = reactionSession.f18682y;
        String g = reactionSession.m22563g();
        if (reactionQueryParams == null || g == null) {
            reactionSession.f18673p = false;
            return false;
        }
        reactionSession.f18674q = true;
        reactionQueryParams.f18620a = g;
        m22647c(reactionQueryParams, reactionSession.f18658a, reactionSession.f18660c);
        return true;
    }

    public final void m22663a(String str, DisposableFutureCallback<GraphQLResult<ReactionMoreAttachmentsResultModel>> disposableFutureCallback, int i, String str2, Surface surface) {
        GraphQlQueryString graphQlQueryString = (ReactionMoreAttachmentsQueryString) FetchReactionGraphQL.c().a("reaction_story_id", str2).a("reaction_after_cursor", str).a("reaction_result_count", Integer.toString(i));
        m22659a(graphQlQueryString, surface);
        this.f18755u.a(str2, this.f18739e.a(GraphQLRequest.a(graphQlQueryString)), disposableFutureCallback);
    }

    public final void m22657a(DisposableFutureCallback disposableFutureCallback, String str, Surface surface, String str2, @Nullable ReactionQueryParams reactionQueryParams) {
        ReactionQueryParams reactionQueryParams2;
        if (reactionQueryParams == null) {
            reactionQueryParams2 = new ReactionQueryParams();
            reactionQueryParams2.f18640u = str2;
            reactionQueryParams2 = reactionQueryParams2;
        } else {
            reactionQueryParams.f18640u = str2;
            reactionQueryParams2 = reactionQueryParams;
        }
        this.f18755u.a(str2, this.f18739e.a(m22648d(reactionQueryParams2, str, surface)), disposableFutureCallback);
    }

    public final void m22669b(String str, String str2, int i, CallerContext callerContext, DisposableFutureCallback disposableFutureCallback) {
        this.f18755u.a(str2, this.f18739e.a(this.f18750p.a(new IdQueryParam(str2), callerContext).a(i, str).a(GraphQLCachePolicy.d)), disposableFutureCallback);
    }

    @Nullable
    public final GraphQLRequest<ReactionQueryFragmentModel> m22667b(ReactionQueryParams reactionQueryParams, String str, Surface surface) {
        return m22651e(reactionQueryParams, str, surface) ? m22648d(reactionQueryParams, str, surface) : null;
    }

    private void m22647c(ReactionQueryParams reactionQueryParams, String str, Surface surface) {
        if (m22651e(reactionQueryParams, str, surface)) {
            ListenableFuture a = this.f18739e.a(m22648d(reactionQueryParams, str, surface));
            m22639a(reactionQueryParams, a);
            this.f18755u.a(str, a, new ReactionSuccessCallback(this, str));
            this.f18747m.a(new ReactionRequestEvent(str, reactionQueryParams));
        }
    }

    private void m22645b(ReactionQueryParams reactionQueryParams, String str, Surface surface, GraphQLCachePolicy graphQLCachePolicy, long j, @Nullable GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        if (m22651e(reactionQueryParams, str, surface)) {
            GraphQLRequest d = m22648d(reactionQueryParams, str, surface);
            d.a(graphQLCachePolicy);
            d.b = true;
            d.a(j);
            if (graphQLCacheKeySerializer != null) {
                d.a(graphQLCacheKeySerializer);
            }
            this.f18755u.a(str, this.f18739e.a(d), new ReactionSuccessCallback(this, str));
            this.f18747m.a(new ReactionRequestEvent(str, reactionQueryParams));
        }
    }

    private Integer m22638a() {
        return GraphQLImageHelper.a(this.f18738d.getResources().getDimensionPixelSize(2131431427));
    }

    private Integer m22643b() {
        return Integer.valueOf((int) (Float.valueOf((float) m22646c().intValue()).floatValue() / 1.9f));
    }

    private Integer m22646c() {
        return this.f18740f.f();
    }

    private Integer m22649d() {
        return Integer.valueOf((int) (Float.valueOf((float) m22650e().intValue()).floatValue() / 1.7777778f));
    }

    private Integer m22650e() {
        return this.f18740f.f();
    }

    public final void m22656a(DisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> disposableFutureCallback, int i, @Nullable String str, Surface surface, ObjectNode objectNode, String str2) {
        final int i2 = i;
        final String str3 = str;
        final ObjectNode objectNode2 = objectNode;
        final Surface surface2 = surface;
        this.f18755u.a("suggestedEvents" + str2, new Callable<ListenableFuture<GraphQLResult<ReactionSuggestedEventsQueryModel>>>(this) {
            final /* synthetic */ ReactionUtil f18721e;

            public Object call() {
                GraphQlQueryString reactionSuggestedEventsQueryString = new ReactionSuggestedEventsQueryString();
                reactionSuggestedEventsQueryString.a("reaction_result_count", Integer.valueOf(i2));
                reactionSuggestedEventsQueryString.a("reaction_after_cursor", str3);
                reactionSuggestedEventsQueryString.a("suggestion_context", objectNode2.toString());
                this.f18721e.m22659a(reactionSuggestedEventsQueryString, surface2);
                reactionSuggestedEventsQueryString.a("reaction_context", this.f18721e.m22655a(surface2));
                reactionSuggestedEventsQueryString.a("reaction_paginated_components_count", Integer.valueOf(3));
                return this.f18721e.f18739e.a(GraphQLRequest.a(reactionSuggestedEventsQueryString).a(GraphQLCachePolicy.c));
            }
        }, disposableFutureCallback);
    }

    public final String m22655a(Surface surface) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        m22640a(objectNode, "unit_styles", this.f18743i);
        m22640a(objectNode, "action_styles", this.f18752r.m22626a(surface));
        m22640a(objectNode, "component_styles", this.f18757w.m22893a());
        m22640a(objectNode, "story_attachment_styles", this.f18746l.m22866a());
        m22640a(objectNode, "story_header_styles", this.f18754t);
        objectNode.a("surface", surface.toString());
        objectNode.a("request_type", RequestType.NORMAL.toString());
        return objectNode.toString();
    }

    private static void m22640a(ObjectNode objectNode, String str, ImmutableList<String> immutableList) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayNode.h((String) immutableList.get(i));
        }
        objectNode.c(str, arrayNode);
    }

    @VisibleForTesting
    private GraphQLRequest<ReactionQueryFragmentModel> m22648d(ReactionQueryParams reactionQueryParams, String str, Surface surface) {
        long j;
        ReactionTriggerInputTriggerData a = reactionQueryParams.m22523a(this.f18758x);
        a.a("subject_id", (String) this.f18744j.get());
        a.a("surface", surface);
        GraphQlQueryString reactionQueryString = new ReactionQueryString();
        m22659a(reactionQueryString, surface);
        GraphQlQueryString a2 = reactionQueryString.a("reaction_trigger_data", a).a("reaction_after_cursor", reactionQueryParams.f18620a);
        String str2 = "reaction_result_count";
        if (reactionQueryParams.f18621b > 0) {
            j = reactionQueryParams.f18621b;
        } else {
            j = 500;
        }
        a2.a(str2, Long.valueOf(j)).a("topic_feeds_enabled", Boolean.valueOf(reactionQueryParams.f18619A)).a("reaction_session_id", str).a("automatic_photo_captioning_enabled", Boolean.toString(((AutomaticPhotoCaptioningUtils) this.f18736b.get()).a())).a("enable_download", Boolean.toString(this.f18759y.a(ExperimentsForVideoAbTestModule.cW, false)));
        if (reactionQueryParams.f18628i != null) {
            reactionQueryString.a("action_location", reactionQueryParams.f18628i);
        }
        if (this.f18729A != null && ((VideoDashConfig) this.f18729A.get()).b()) {
            reactionQueryString.a("scrubbing", "MPEG_DASH");
        }
        GraphQLRequest<ReactionQueryFragmentModel> a3 = GraphQLRequest.a(reactionQueryString).a(GraphQLCachePolicy.c);
        if (reactionQueryParams.f18634o != null) {
            a3.a(reactionQueryParams.f18634o);
        }
        if (!reactionQueryParams.f18645z.isEmpty()) {
            a3.e = reactionQueryParams.f18645z;
        }
        a3.f = CallerContext.a(getClass(), reactionQueryParams.f18642w, reactionQueryParams.f18643x, reactionQueryParams.f18644y);
        return a3;
    }

    public final GametimeMatchReactionUnitsInputTriggerData m22654a(Surface surface, String str, String str2) {
        ReactionContext.Surface valueOf = ReactionContext.Surface.valueOf(surface.toString());
        ReactionContext reactionContext = new ReactionContext();
        reactionContext.a("request_type", ReactionContext.RequestType.NORMAL);
        GraphQlCallInput graphQlCallInput = reactionContext;
        graphQlCallInput.a("surface", valueOf);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.a("session_id", str2);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("unit_styles", this.f18743i);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("story_header_styles", this.f18754t);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("story_attachment_styles", this.f18746l.m22866a());
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("action_styles", this.f18752r.m22626a(surface));
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("component_styles", this.f18757w.m22893a());
        graphQlCallInput2 = graphQlCallInput2;
        GametimeMatchReactionUnitsInputTriggerData gametimeMatchReactionUnitsInputTriggerData = new GametimeMatchReactionUnitsInputTriggerData();
        gametimeMatchReactionUnitsInputTriggerData.a("page_id", str);
        graphQlCallInput = gametimeMatchReactionUnitsInputTriggerData;
        graphQlCallInput.a("reaction_context", graphQlCallInput2);
        return graphQlCallInput;
    }

    public final void m22659a(GraphQlQueryString graphQlQueryString, Surface surface) {
        Resources resources = this.f18738d.getResources();
        int intValue = GraphQLImageHelper.a(resources.getDimensionPixelSize(2131431381)).intValue();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431374);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131431429);
        int intValue2 = GraphQLImageHelper.a(resources.getDimensionPixelSize(2131431430)).intValue();
        int i = resources.getDisplayMetrics().widthPixels / 2;
        int intValue3 = GraphQLImageHelper.a((int) (((float) resources.getDisplayMetrics().widthPixels) * 0.6666667f)).intValue();
        i = GraphQLImageHelper.a(i).intValue();
        int max = Math.max(resources.getDisplayMetrics().heightPixels / 2, resources.getDisplayMetrics().widthPixels / 2);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(2131431374);
        int c = this.f18733E.c();
        graphQlQueryString.a("reaction_aggregated_units_count", Integer.valueOf(10)).a("reaction_client_capabilities", m22652f()).a("reaction_core_component_image_sizes", m22653g()).a("reaction_critic_review_thumbnail_height", m22643b()).a("reaction_critic_review_thumbnail_width", m22646c()).a("reaction_icon_scale", GraphQlQueryDefaults.a()).a("place_question_photo_size", Integer.valueOf(max)).a("image_height", m22649d()).a("image_width", m22650e()).a("reaction_info_row_icon_size", Integer.valueOf(dimensionPixelSize)).a("media_type", this.f18740f.a()).a("profile_image_size", m22638a()).a("reaction_facepile_profile_pic_size", Integer.valueOf(intValue)).a("reaction_friend_inviter_profile_image_size", Integer.valueOf(intValue3)).a("reaction_paginated_components_count", Integer.valueOf(5)).a("reaction_product_item_image_size", Integer.valueOf(i)).a("reaction_profile_image_size_medium", Integer.valueOf(dimensionPixelSize2)).a("reaction_profile_image_size_small", Integer.toString(intValue2)).a("profile_pic_media_type", this.f18740f.b()).a("reaction_profile_pic_media_type", this.f18740f.b()).a("reaction_profile_pic_size", m22638a()).a("reaction_review_profile_pic_size", this.f18753s.m4923a()).a("reaction_supported_unit_header_styles", this.f18754t).a("reaction_supported_unit_styles", this.f18743i).a("reaction_context_items_surface", EntityCardContextSurfaceInputEntityCardContextSurface.PLACE_TIPS).a("reaction_context_items_source", EntityCardContextSurfaceInputEntityCardContextSurface.PLACE_TIPS).a("reaction_context_items_source_id", "").a("reaction_context_items_row_limit", Integer.valueOf(10)).a("reaction_page_surface_context_items_row_limit", Integer.valueOf(3)).a("context_item_icon_size", Integer.toString(dimensionPixelSize3)).a("scale", GraphQlQueryDefaults.a()).a("profile_picture_size", Float.valueOf(TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()))).a("angora_attachment_cover_image_size", this.f18741g.r()).a("angora_attachment_profile_image_size", this.f18741g.s()).a("image_large_aspect_height", this.f18741g.z()).a("image_large_aspect_width", this.f18741g.y()).a("device_id", this.f18734F.a()).a("default_image_scale", GraphQlQueryDefaults.a()).a("review_character_count", Integer.valueOf(100)).a("page_service_image_width", Integer.valueOf(c)).a("screen_width", Integer.valueOf((int) (((float) c) / this.f18733E.b()))).a("page_service_image_height", Integer.valueOf((int) (((float) c) / 1.0f)));
        LocationInputStoryRenderLocation b = m22641b(surface);
        if (b != null) {
            graphQlQueryString.a("feed_story_attachments_location", b);
        }
        m22644b(graphQlQueryString, surface);
        this.f18756v.a(graphQlQueryString);
        this.f18730B.a(graphQlQueryString);
    }

    private static LocationInputStoryRenderLocation m22641b(Surface surface) {
        if (ReactionSurfaceUtil.m4784k(surface)) {
            return LocationInputStoryRenderLocation.LOCAL_SEARCH_RESULTS_PAGE;
        }
        if (ReactionSurfaceUtil.m4786m(surface)) {
            return LocationInputStoryRenderLocation.FUNDRAISER_PAGE;
        }
        if (ReactionSurfaceUtil.m4788q(surface)) {
            return LocationInputStoryRenderLocation.VIDEO_CHANNEL;
        }
        return null;
    }

    private ImmutableList<String> m22652f() {
        Builder builder = ImmutableList.builder();
        if (((FbLocationStatusUtil) this.f18742h.get()).b().a == State.OKAY) {
            builder.c("LOCATION_BACKGROUND");
            builder.c("LOCATION_FOREGROUND");
        }
        if (this.f18760z.b()) {
            builder.c("MESSENGER");
        }
        return builder.b();
    }

    private SizesInputSizes m22653g() {
        SizesInputSizes sizesInputSizes = new SizesInputSizes();
        sizesInputSizes.a("EXTRA_SMALL", Integer.valueOf(m22636a(GraphQLReactionCoreImageTextImageSize.EXTRA_SMALL)));
        GraphQlCallInput graphQlCallInput = sizesInputSizes;
        graphQlCallInput.a("SMALL", Integer.valueOf(m22636a(GraphQLReactionCoreImageTextImageSize.SMALL)));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("MEDIUM", Integer.valueOf(m22636a(GraphQLReactionCoreImageTextImageSize.MEDIUM)));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("LARGE", Integer.valueOf(m22636a(GraphQLReactionCoreImageTextImageSize.LARGE)));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("EXTRA_LARGE", Integer.valueOf(m22636a(GraphQLReactionCoreImageTextImageSize.EXTRA_LARGE)));
        return graphQlCallInput;
    }

    private int m22636a(GraphQLReactionCoreImageTextImageSize graphQLReactionCoreImageTextImageSize) {
        return this.f18738d.getResources().getDimensionPixelSize(ReactionCoreComponentsUtil.m4767a(graphQLReactionCoreImageTextImageSize));
    }

    private boolean m22651e(ReactionQueryParams reactionQueryParams, String str, Surface surface) {
        if (str == null) {
            return false;
        }
        Object obj;
        if (reactionQueryParams.f18624e == null && CollectionUtil.a(reactionQueryParams.f18625f) && CollectionUtil.a(reactionQueryParams.f18627h) && reactionQueryParams.f18628i == null && ((reactionQueryParams.f18629j == null || reactionQueryParams.f18630k == null) && reactionQueryParams.f18631l == null && Strings.isNullOrEmpty(reactionQueryParams.f18632m) && Strings.isNullOrEmpty(reactionQueryParams.f18636q) && CollectionUtil.a(reactionQueryParams.f18637r) && reactionQueryParams.f18639t == null)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || ReactionSurfaceUtil.m4776b(surface)) {
            return true;
        }
        this.f18747m.a(new ReactionEmptyRequestEvent(str));
        return false;
    }

    private void m22644b(GraphQlQueryString graphQlQueryString, Surface surface) {
        if (this.f18745k != Product.FB4A) {
            graphQlQueryString.a("reaction_supported_action_styles", this.f18752r.m22626a(surface)).a("reaction_supported_component_styles", this.f18757w.m22893a()).a("reaction_supported_attachment_styles", this.f18746l.m22866a());
            return;
        }
        ReactionSupportedActionStyles reactionSupportedActionStyles = this.f18752r;
        Object obj = null;
        if (reactionSupportedActionStyles.f18715a != null) {
            for (ReactionExpensiveConditionalActionStyleProvider a : reactionSupportedActionStyles.f18715a) {
                if (a.mo1113a(surface)) {
                    obj = 1;
                    break;
                }
            }
        }
        if (obj != null) {
            graphQlQueryString.a("reaction_supported_action_styles", this.f18752r.m22626a(surface));
        }
    }

    public final void m22668b(String str, DisposableFutureCallback<GraphQLResult<ReactionMoreComponentsResultModel>> disposableFutureCallback, int i, String str2, Surface surface) {
        GraphQlQueryString graphQlQueryString = (ReactionMoreComponentsQueryString) new ReactionMoreComponentsQueryString().a("reaction_component_id", str2).a("reaction_after_cursor", str).a("reaction_result_count", Integer.toString(i));
        m22659a(graphQlQueryString, surface);
        this.f18755u.a(str2, this.f18739e.a(GraphQLRequest.a(graphQlQueryString)), disposableFutureCallback);
    }
}
