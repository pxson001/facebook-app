package com.facebook.heisman;

import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQL.ImageOverlayCameraTitleQueryString;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQL.ImageOverlayUriQueryString;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLInterfaces.ImageOverlayCameraTitleFields;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: valid_story_types */
public class ProfilePictureOverlayCameraQueryExecutor {
    private static final CallerContext f699e = CallerContext.a(ProfilePictureOverlayCameraQueryExecutor.class, "timeline");
    private static volatile ProfilePictureOverlayCameraQueryExecutor f700i;
    @Inject
    volatile Provider<SwipeableOverlaysRequestFactory> f701a = UltralightRuntime.a;
    @Inject
    volatile Provider<QeAccessor> f702b = UltralightRuntime.a;
    @Inject
    volatile Provider<ImageOverlayQueryBuilder> f703c = UltralightRuntime.a;
    @Inject
    @LoggedInUserId
    public volatile Provider<String> f704d = UltralightRuntime.a;
    @Inject
    private GraphQLBatchRequestProvider f705f;
    @Inject
    public SelfProfilePictureQueryBuilder f706g;
    @Inject
    private GraphQLQueryExecutor f707h;

    /* compiled from: valid_story_types */
    class C00871 implements Function<GraphQLResult<ImageOverlayFieldsModel>, ImageOverlayFieldsModel> {
        final /* synthetic */ ProfilePictureOverlayCameraQueryExecutor f698a;

        C00871(ProfilePictureOverlayCameraQueryExecutor profilePictureOverlayCameraQueryExecutor) {
            this.f698a = profilePictureOverlayCameraQueryExecutor;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ImageOverlayValidator.b((ImageOverlayFieldsModel) graphQLResult.e)) {
                return (ImageOverlayFieldsModel) graphQLResult.e;
            }
            throw new IllegalArgumentException(StringFormatUtil.a("Invalid image overlay: %s", new Object[]{ImageOverlayValidator.c((ImageOverlayFieldsModel) graphQLResult.e)}));
        }
    }

    public static com.facebook.heisman.ProfilePictureOverlayCameraQueryExecutor m765a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f700i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayCameraQueryExecutor.class;
        monitor-enter(r1);
        r0 = f700i;	 Catch:{ all -> 0x003a }
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
        r0 = m771b(r0);	 Catch:{ all -> 0x0035 }
        f700i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f700i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayCameraQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayCameraQueryExecutor");
    }

    private static ProfilePictureOverlayCameraQueryExecutor m771b(InjectorLike injectorLike) {
        ProfilePictureOverlayCameraQueryExecutor profilePictureOverlayCameraQueryExecutor = new ProfilePictureOverlayCameraQueryExecutor();
        profilePictureOverlayCameraQueryExecutor.m770a(IdBasedSingletonScopeProvider.a(injectorLike, 7172), IdBasedSingletonScopeProvider.a(injectorLike, 3219), IdBasedSingletonScopeProvider.a(injectorLike, 7159), IdBasedProvider.a(injectorLike, 4442), (GraphQLBatchRequestProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLBatchRequestProvider.class), SelfProfilePictureQueryBuilder.m807a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
        return profilePictureOverlayCameraQueryExecutor;
    }

    private void m770a(Provider<SwipeableOverlaysRequestFactory> provider, Provider<QeAccessor> provider2, Provider<ImageOverlayQueryBuilder> provider3, Provider<String> provider4, GraphQLBatchRequestProvider graphQLBatchRequestProvider, SelfProfilePictureQueryBuilder selfProfilePictureQueryBuilder, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f701a = provider;
        this.f702b = provider2;
        this.f703c = provider3;
        this.f704d = provider4;
        this.f705f = graphQLBatchRequestProvider;
        this.f706g = selfProfilePictureQueryBuilder;
        this.f707h = graphQLQueryExecutor;
    }

    public final ProfilePictureOverlayCameraFetchFutures m772a(@Nullable ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel, ImageOverlayFieldsModel imageOverlayFieldsModel) {
        GraphQLBatchRequest a = GraphQLBatchRequestProvider.a("ProfilePictureOverlayCamera");
        String str = (String) this.f704d.get();
        SelfProfilePictureQueryBuilder selfProfilePictureQueryBuilder = this.f706g;
        GraphQLRequest a2 = GraphQLRequest.a(SelfProfilePictureQueryBuilder.m808a(str, GraphQLStoryHelper.a()));
        a2.e = Sets.a(new String[]{"ProfileImageRequest"});
        a2 = a2;
        m769a(a2);
        ListenableFuture b = a.b(a2);
        ListenableFuture a3 = m767a(imageOverlayFieldsModel, a);
        ListenableFuture a4 = m768a(imageOverlayFieldsModel.c(), a);
        ListenableFuture a5 = m766a(imageOverlayCameraTitleFieldsModel, imageOverlayFieldsModel.c(), a);
        this.f707h.a(a);
        return new ProfilePictureOverlayCameraFetchFutures(b, a3, a4, a5);
    }

    private ListenableFuture<ImageOverlayFieldsModel> m767a(ImageOverlayFieldsModel imageOverlayFieldsModel, GraphQLBatchRequest graphQLBatchRequest) {
        if (ImageOverlayValidator.b(imageOverlayFieldsModel)) {
            return Futures.a(imageOverlayFieldsModel);
        }
        ImageOverlayQueryBuilder imageOverlayQueryBuilder = (ImageOverlayQueryBuilder) this.f703c.get();
        GraphQLRequest a = GraphQLRequest.a((ImageOverlayUriQueryString) new ImageOverlayUriQueryString().a("image_overlay_id", imageOverlayFieldsModel.c()).a("image_high_width", imageOverlayQueryBuilder.f603a.x()));
        m769a(a);
        return Futures.a(graphQLBatchRequest.b(a), new C00871(this), DirectExecutor.INSTANCE);
    }

    private static ListenableFuture<GraphQLResult<ImageOverlayCameraTitleFieldsModel>> m766a(@Nullable ImageOverlayCameraTitleFields imageOverlayCameraTitleFields, String str, GraphQLBatchRequest graphQLBatchRequest) {
        if (imageOverlayCameraTitleFields != null) {
            return Futures.a(new GraphQLResult(ImageOverlayCameraTitleFieldsModel.a(imageOverlayCameraTitleFields), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0));
        }
        GraphQLRequest a = GraphQLRequest.a((ImageOverlayCameraTitleQueryString) new ImageOverlayCameraTitleQueryString().a("image_overlay_id", str));
        m769a(a);
        return graphQLBatchRequest.b(a);
    }

    @Nullable
    private ListenableFuture<GraphQLResult<ImageOverlayWithSwipeableOverlaysModel>> m768a(String str, GraphQLBatchRequest graphQLBatchRequest) {
        if (((QeAccessor) this.f702b.get()).a(ExperimentsForProfilePictureOverlayAbTestModule.c, false)) {
            return graphQLBatchRequest.b(((SwipeableOverlaysRequestFactory) this.f701a.get()).a(str));
        }
        return null;
    }

    public static void m769a(GraphQLRequest<?> graphQLRequest) {
        GraphQLRequest a = graphQLRequest.a(RequestPriority.INTERACTIVE);
        a.f = f699e;
        a.a(GraphQLCachePolicy.a).a(3600);
    }
}
