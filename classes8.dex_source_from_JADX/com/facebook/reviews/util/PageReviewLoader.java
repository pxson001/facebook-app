package com.facebook.reviews.util;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsInterfaces.PageOverallStarRating;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRating.FetchPageOverallRatingString;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRatingGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRatingGraphQLRequest.C06711;
import com.facebook.reviews.util.protocol.graphql.FetchSingleViewerReviewGraphQL.FetchSingleViewerReviewGraphQLString;
import com.facebook.reviews.util.protocol.graphql.FetchSingleViewerReviewGraphQLModels.FetchSingleViewerReviewGraphQLModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profiles_selected_count */
public class PageReviewLoader {
    private static volatile PageReviewLoader f4967d;
    private final TasksManager<String> f4968a;
    private final FetchPageOverallRatingGraphQLRequest f4969b;
    private final GraphQLQueryExecutor f4970c;

    /* compiled from: profiles_selected_count */
    public interface LoadPageOverallStarRatingCallback {
        void mo1176a();

        void mo1177a(PageOverallStarRatingModel pageOverallStarRatingModel);
    }

    /* compiled from: profiles_selected_count */
    public interface LoadSingleReviewCallback {
        void m4897a();

        void m4898a(ReviewBasicFields reviewBasicFields);
    }

    public static com.facebook.reviews.util.PageReviewLoader m4899a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4967d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.util.PageReviewLoader.class;
        monitor-enter(r1);
        r0 = f4967d;	 Catch:{ all -> 0x003a }
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
        r0 = m4900b(r0);	 Catch:{ all -> 0x0035 }
        f4967d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4967d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.util.PageReviewLoader.a(com.facebook.inject.InjectorLike):com.facebook.reviews.util.PageReviewLoader");
    }

    private static PageReviewLoader m4900b(InjectorLike injectorLike) {
        return new PageReviewLoader(TasksManager.b(injectorLike), new FetchPageOverallRatingGraphQLRequest(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public PageReviewLoader(TasksManager tasksManager, FetchPageOverallRatingGraphQLRequest fetchPageOverallRatingGraphQLRequest, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f4968a = tasksManager;
        this.f4969b = fetchPageOverallRatingGraphQLRequest;
        this.f4970c = graphQLQueryExecutor;
    }

    public final void m4902a(String str, final LoadSingleReviewCallback loadSingleReviewCallback) {
        final GraphQLQueryFuture a = this.f4970c.a(GraphQLRequest.a((FetchSingleViewerReviewGraphQLString) new FetchSingleViewerReviewGraphQLString().a("page_id", str)));
        this.f4968a.a("task_key_load_single_viewer_review" + str, new Callable<ListenableFuture<GraphQLResult<FetchSingleViewerReviewGraphQLModel>>>(this) {
            final /* synthetic */ PageReviewLoader f4962b;

            public Object call() {
                return a;
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchSingleViewerReviewGraphQLModel>>(this) {
            final /* synthetic */ PageReviewLoader f4964b;

            protected final void m4891a(Object obj) {
                ReviewBasicFields reviewBasicFields;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    reviewBasicFields = null;
                } else {
                    reviewBasicFields = ((FetchSingleViewerReviewGraphQLModel) graphQLResult.e).m4968a();
                }
                loadSingleReviewCallback.m4898a(reviewBasicFields);
            }

            protected final void m4892a(Throwable th) {
                loadSingleReviewCallback.m4897a();
            }
        });
    }

    public final void m4901a(String str, final LoadPageOverallStarRatingCallback loadPageOverallStarRatingCallback) {
        TasksManager tasksManager = this.f4968a;
        String str2 = "task_key_load_overall_rating" + str;
        FetchPageOverallRatingGraphQLRequest fetchPageOverallRatingGraphQLRequest = this.f4969b;
        tasksManager.a(str2, Futures.a(fetchPageOverallRatingGraphQLRequest.f5008a.a(GraphQLRequest.a((FetchPageOverallRatingString) new FetchPageOverallRatingString().a("page_id", str))), new C06711(fetchPageOverallRatingGraphQLRequest), fetchPageOverallRatingGraphQLRequest.f5009b), new AbstractDisposableFutureCallback<PageOverallStarRating>(this) {
            final /* synthetic */ PageReviewLoader f4966b;

            protected final void m4893a(Object obj) {
                loadPageOverallStarRatingCallback.mo1177a((PageOverallStarRatingModel) obj);
            }

            protected final void m4894a(Throwable th) {
                loadPageOverallStarRatingCallback.mo1176a();
            }
        });
    }
}
