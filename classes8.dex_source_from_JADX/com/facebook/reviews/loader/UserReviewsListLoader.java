package com.facebook.reviews.loader;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.VerticalInputVerticalName;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reviews.adapter.SingleReviewSection;
import com.facebook.reviews.controller.UserReviewsListController;
import com.facebook.reviews.event.ReviewEvents.UserPlaceToReviewEvent;
import com.facebook.reviews.event.ReviewEvents.UserReviewEvent;
import com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler;
import com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler.C23232;
import com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler.C23243;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlacesToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UpdatedPageReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel.Builder;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel.ReviewStoryModel;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.protocol.graphql.FetchPlacesToReviewGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchSingleReviewGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchUpdatedPlaceReviewContextQueryRequest;
import com.facebook.reviews.util.protocol.graphql.FetchUpdatedUserReviewForPageGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviews.FetchSingleReviewQueryString;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviews.FetchUpdatedPlaceToReviewQueryString;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviews.FetchUserReviewsQueryString;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsModels.FetchSingleReviewQueryModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
public class UserReviewsListLoader {
    private static volatile UserReviewsListLoader f21705g;
    public final Lazy<FetchPlacesToReviewGraphQLRequest> f21706a;
    public final Lazy<FetchSingleReviewGraphQLRequest> f21707b;
    public final Lazy<FetchUpdatedUserReviewForPageGraphQLRequest> f21708c;
    private final Lazy<FetchUpdatedPlaceReviewContextQueryRequest> f21709d;
    public final Lazy<FetchUserReviewsGraphQLRequest> f21710e;
    public final TasksManager<String> f21711f;

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public interface LoadUserReviewsCallback {
        void mo1170a(UserReviewsModel userReviewsModel);

        void mo1171e();
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public class C23352 implements Callable<ListenableFuture<GraphQLResult<PlacesToReviewModel>>> {
        final /* synthetic */ String f21689a;
        final /* synthetic */ int f21690b;
        final /* synthetic */ String f21691c;
        final /* synthetic */ UserReviewsListLoader f21692d;

        public C23352(UserReviewsListLoader userReviewsListLoader, String str, int i, String str2) {
            this.f21692d = userReviewsListLoader;
            this.f21689a = str;
            this.f21690b = i;
            this.f21691c = str2;
        }

        public Object call() {
            return ((FetchPlacesToReviewGraphQLRequest) this.f21692d.f21706a.get()).m4961a(this.f21689a, this.f21690b, this.f21691c);
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public class C23363 extends ResultFutureCallback<GraphQLResult<PlacesToReviewModel>> {
        final /* synthetic */ UserReviewsListController f21693a;
        final /* synthetic */ UserReviewsListLoader f21694b;

        public C23363(UserReviewsListLoader userReviewsListLoader, UserReviewsListController userReviewsListController) {
            this.f21694b = userReviewsListLoader;
            this.f21693a = userReviewsListController;
        }

        protected final void m25203a(Object obj) {
            this.f21693a.m25098a((PlacesToReviewModel) ((GraphQLResult) obj).e);
        }

        protected final void m25202a(ServiceException serviceException) {
            this.f21693a.m25101d();
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public class C23374 implements Callable<ListenableFuture<GraphQLResult<UserReviewsModel>>> {
        final /* synthetic */ String f21695a;
        final /* synthetic */ int f21696b;
        final /* synthetic */ String f21697c;
        final /* synthetic */ UserReviewsListLoader f21698d;

        public C23374(UserReviewsListLoader userReviewsListLoader, String str, int i, String str2) {
            this.f21698d = userReviewsListLoader;
            this.f21695a = str;
            this.f21696b = i;
            this.f21697c = str2;
        }

        public Object call() {
            FetchUserReviewsGraphQLRequest fetchUserReviewsGraphQLRequest = (FetchUserReviewsGraphQLRequest) this.f21698d.f21710e.get();
            String str = this.f21695a;
            int i = this.f21696b;
            String str2 = this.f21697c;
            GraphQlQueryString fetchUserReviewsQueryString = new FetchUserReviewsQueryString();
            fetchUserReviewsQueryString.a("user_id", str).a("after_cursor", str2).a("review_vertical", VerticalInputVerticalName.PLACES).a("review_profile_pic_size", fetchUserReviewsGraphQLRequest.f5020b.m4924b()).a("review_cover_pic_size", fetchUserReviewsGraphQLRequest.f5020b.m4925c()).a("count", String.valueOf(i));
            return fetchUserReviewsGraphQLRequest.f5019a.a(GraphQLRequest.a(fetchUserReviewsQueryString));
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public class C23385 extends ResultFutureCallback<GraphQLResult<UserReviewsModel>> {
        final /* synthetic */ LoadUserReviewsCallback f21699a;
        final /* synthetic */ UserReviewsListLoader f21700b;

        public C23385(UserReviewsListLoader userReviewsListLoader, LoadUserReviewsCallback loadUserReviewsCallback) {
            this.f21700b = userReviewsListLoader;
            this.f21699a = loadUserReviewsCallback;
        }

        protected final void m25205a(Object obj) {
            UserReviewsModel userReviewsModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            LoadUserReviewsCallback loadUserReviewsCallback = this.f21699a;
            if (graphQLResult != null) {
                userReviewsModel = (UserReviewsModel) graphQLResult.e;
            } else {
                userReviewsModel = null;
            }
            loadUserReviewsCallback.mo1170a(userReviewsModel);
        }

        protected final void m25204a(ServiceException serviceException) {
            this.f21699a.mo1171e();
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIFICATION_TAP */
    public class C23396 extends ResultFutureCallback<GraphQLResult<UpdatedPageReviewModel>> {
        final /* synthetic */ C23232 f21701a;
        final /* synthetic */ UserReviewsListLoader f21702b;

        public C23396(UserReviewsListLoader userReviewsListLoader, C23232 c23232) {
            this.f21702b = userReviewsListLoader;
            this.f21701a = c23232;
        }

        protected final void m25207a(Object obj) {
            UpdatedPageReviewModel updatedPageReviewModel;
            GraphQLStory graphQLStory;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            C23232 c23232 = this.f21701a;
            if (graphQLResult != null) {
                updatedPageReviewModel = (UpdatedPageReviewModel) graphQLResult.e;
            } else {
                updatedPageReviewModel = null;
            }
            UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler = c23232.f21639c;
            String str = c23232.f21637a;
            ReviewWithFeedback reviewWithFeedback = c23232.f21638b;
            Builder builder = new Builder();
            builder.b = ReviewWithFeedbackModel.a(reviewWithFeedback);
            Builder builder2 = builder;
            ReviewStoryModel.Builder builder3 = new ReviewStoryModel.Builder();
            if (updatedPageReviewModel.a() == null) {
                graphQLStory = null;
            } else {
                graphQLStory = updatedPageReviewModel.a().a();
            }
            builder3.a = graphQLStory;
            builder2.a = builder3.a();
            userReviewsListComposerLauncherAndHandler.f21645c.a(new UserReviewEvent(0, str, builder2.a()));
        }

        protected final void m25206a(ServiceException serviceException) {
        }
    }

    public static com.facebook.reviews.loader.UserReviewsListLoader m25210a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21705g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.loader.UserReviewsListLoader.class;
        monitor-enter(r1);
        r0 = f21705g;	 Catch:{ all -> 0x003a }
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
        r0 = m25213b(r0);	 Catch:{ all -> 0x0035 }
        f21705g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21705g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.loader.UserReviewsListLoader.a(com.facebook.inject.InjectorLike):com.facebook.reviews.loader.UserReviewsListLoader");
    }

    private static UserReviewsListLoader m25213b(InjectorLike injectorLike) {
        return new UserReviewsListLoader(IdBasedLazy.a(injectorLike, 10290), IdBasedLazy.a(injectorLike, 10291), IdBasedLazy.a(injectorLike, 10293), IdBasedLazy.a(injectorLike, 10292), IdBasedLazy.a(injectorLike, 10294), TasksManager.b(injectorLike));
    }

    public final void m25215a(String str, int i, UserReviewsListController userReviewsListController) {
        m25212a((Optional) Absent.INSTANCE, str, i, null, userReviewsListController);
    }

    @Inject
    public UserReviewsListLoader(Lazy<FetchPlacesToReviewGraphQLRequest> lazy, Lazy<FetchSingleReviewGraphQLRequest> lazy2, Lazy<FetchUpdatedUserReviewForPageGraphQLRequest> lazy3, Lazy<FetchUpdatedPlaceReviewContextQueryRequest> lazy4, Lazy<FetchUserReviewsGraphQLRequest> lazy5, TasksManager tasksManager) {
        this.f21706a = lazy;
        this.f21707b = lazy2;
        this.f21708c = lazy3;
        this.f21709d = lazy4;
        this.f21710e = lazy5;
        this.f21711f = tasksManager;
    }

    public final void m25217a(String str, String str2, int i, UserReviewsListController userReviewsListController, UserReviewsListController userReviewsListController2) {
        m25212a(Optional.of(str), str2, i, userReviewsListController, userReviewsListController2);
    }

    private void m25212a(final Optional<String> optional, String str, int i, final LoadSingleReviewCallback loadSingleReviewCallback, final LoadPlacesToReviewsCallback loadPlacesToReviewsCallback) {
        ListenableFuture a;
        ListenableFuture[] listenableFutureArr = new ListenableFuture[2];
        if (optional.isPresent()) {
            FetchSingleReviewGraphQLRequest fetchSingleReviewGraphQLRequest = (FetchSingleReviewGraphQLRequest) this.f21707b.get();
            String str2 = (String) optional.get();
            GraphQlQueryString fetchSingleReviewQueryString = new FetchSingleReviewQueryString();
            fetchSingleReviewQueryString.a("review_id", str2);
            a = fetchSingleReviewGraphQLRequest.f5013a.a(GraphQLRequest.a(fetchSingleReviewQueryString));
        } else {
            a = Futures.a(null);
        }
        listenableFutureArr[0] = a;
        listenableFutureArr[1] = m25211a(str, i);
        this.f21711f.a("key_load_more_places_to_review" + str, Futures.a(listenableFutureArr), new AbstractDisposableFutureCallback<List<GraphQLResult>>(this) {
            final /* synthetic */ UserReviewsListLoader f21688d;

            protected final void m25200a(Object obj) {
                boolean z;
                PlacesToReviewModel placesToReviewModel;
                List list = (List) obj;
                if (list.size() == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                UserReviewsListLoader userReviewsListLoader = this.f21688d;
                Optional optional = optional;
                GraphQLResult graphQLResult = (GraphQLResult) list.get(0);
                UserReviewsListController userReviewsListController = loadSingleReviewCallback;
                if (optional.isPresent()) {
                    ReviewWithFeedback reviewWithFeedback;
                    if (graphQLResult == null) {
                        reviewWithFeedback = null;
                    } else {
                        FetchSingleReviewQueryModel fetchSingleReviewQueryModel = (FetchSingleReviewQueryModel) graphQLResult.e;
                    }
                    SingleReviewSection singleReviewSection = userReviewsListController.f21532q;
                    singleReviewSection.f21360a = Optional.fromNullable(reviewWithFeedback);
                    singleReviewSection.f21361b = Optional.fromNullable(reviewWithFeedback == null ? null : reviewWithFeedback.m5014l());
                    singleReviewSection.f21362c.a(ReviewsGraphQLHelper.m4919d(reviewWithFeedback));
                    AdapterDetour.a(userReviewsListController.f21533r, -1393456521);
                }
                UserReviewsListLoader userReviewsListLoader2 = this.f21688d;
                graphQLResult = (GraphQLResult) list.get(1);
                UserReviewsListController userReviewsListController2 = loadPlacesToReviewsCallback;
                if (graphQLResult == null) {
                    placesToReviewModel = null;
                } else {
                    placesToReviewModel = (PlacesToReviewModel) graphQLResult.e;
                }
                userReviewsListController2.m25098a(placesToReviewModel);
            }

            protected final void m25201a(Throwable th) {
                optional.isPresent();
                loadPlacesToReviewsCallback.m25101d();
            }
        });
    }

    private ListenableFuture<GraphQLResult<PlacesToReviewModel>> m25211a(String str, int i) {
        return ((FetchPlacesToReviewGraphQLRequest) this.f21706a.get()).m4961a(str, i, null);
    }

    public final void m25216a(String str, final C23243 c23243) {
        TasksManager tasksManager = this.f21711f;
        String str2 = "key_load_updated_place_to_review" + str;
        FetchUpdatedPlaceReviewContextQueryRequest fetchUpdatedPlaceReviewContextQueryRequest = (FetchUpdatedPlaceReviewContextQueryRequest) this.f21709d.get();
        GraphQlQueryString fetchUpdatedPlaceToReviewQueryString = new FetchUpdatedPlaceToReviewQueryString();
        fetchUpdatedPlaceToReviewQueryString.a("page_id", str).a("review_profile_pic_size", fetchUpdatedPlaceReviewContextQueryRequest.f5016b.m4924b());
        tasksManager.a(str2, fetchUpdatedPlaceReviewContextQueryRequest.f5015a.a(GraphQLRequest.a(fetchUpdatedPlaceToReviewQueryString)), new ResultFutureCallback<GraphQLResult<PlaceToReviewModel>>(this) {
            final /* synthetic */ UserReviewsListLoader f21704b;

            protected final void m25209a(Object obj) {
                PlaceToReviewModel placeToReviewModel;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                C23243 c23243 = c23243;
                if (graphQLResult != null) {
                    placeToReviewModel = (PlaceToReviewModel) graphQLResult.e;
                } else {
                    placeToReviewModel = null;
                }
                c23243.f21641b.f21645c.a(new UserPlaceToReviewEvent(0, c23243.f21640a, placeToReviewModel));
            }

            protected final void m25208a(ServiceException serviceException) {
            }
        });
    }

    public final void m25214a() {
        this.f21711f.c();
    }
}
