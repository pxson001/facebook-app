package com.facebook.facecast.protocol;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.facecast.protocol.FetchLiveVideoFeedbackQuery.FetchLiveVideoFeedbackQueryString;
import com.facebook.facecast.protocol.FetchLiveVideoFeedbackQueryModels.FetchLiveVideoFeedbackQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bookmark_remove_from_favorites */
public class FacecastVideoFeedbackLoader {
    public static final String f18771a = FacecastVideoFeedbackLoader.class.getName();
    public final String f18772b;
    public final AbstractFbErrorReporter f18773c;
    public final VideoFeedbackLoaderListener f18774d;
    public final GraphQLQueryExecutor f18775e;
    public final ScheduledExecutorService f18776f;
    public GraphQLQueryFuture<GraphQLResult<FetchLiveVideoFeedbackQueryModel>> f18777g;
    public int f18778h = 0;

    /* compiled from: bookmark_remove_from_favorites */
    public interface VideoFeedbackLoaderListener {
        void mo1425a(@Nullable GraphQLFeedback graphQLFeedback);
    }

    /* compiled from: bookmark_remove_from_favorites */
    class C16261 implements Runnable {
        final /* synthetic */ FacecastVideoFeedbackLoader f18769a;

        public void run() {
            GraphQlQueryString fetchLiveVideoFeedbackQueryString = new FetchLiveVideoFeedbackQueryString();
            fetchLiveVideoFeedbackQueryString.a("targetID", this.f18769a.f18772b);
            this.f18769a.f18777g = this.f18769a.f18775e.a(GraphQLRequest.a(fetchLiveVideoFeedbackQueryString));
            Futures.a(this.f18769a.f18777g, new FetchFeedbackCallback(this.f18769a), this.f18769a.f18776f);
        }

        C16261(FacecastVideoFeedbackLoader facecastVideoFeedbackLoader) {
            this.f18769a = facecastVideoFeedbackLoader;
        }
    }

    /* compiled from: bookmark_remove_from_favorites */
    class FetchFeedbackCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoFeedbackQueryModel>> {
        final /* synthetic */ FacecastVideoFeedbackLoader f18770a;

        public FetchFeedbackCallback(FacecastVideoFeedbackLoader facecastVideoFeedbackLoader) {
            this.f18770a = facecastVideoFeedbackLoader;
        }

        protected final void m22312a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchLiveVideoFeedbackQueryModel) graphQLResult.e).m22386a() == null || ((FetchLiveVideoFeedbackQueryModel) graphQLResult.e).m22386a().m22379a() == null) {
                String str = FacecastVideoFeedbackLoader.f18771a;
                if (this.f18770a.f18777g != null && !this.f18770a.f18777g.isCancelled()) {
                    FacecastVideoFeedbackLoader.m22314a(this.f18770a, 5);
                    return;
                }
                return;
            }
            GraphQLFeedback graphQLFeedback;
            BaseFeedbackFieldsModel a = ((FetchLiveVideoFeedbackQueryModel) graphQLResult.e).m22386a().m22379a();
            if (a == null) {
                graphQLFeedback = null;
            } else {
                GraphQLPage graphQLPage;
                Builder builder = new Builder();
                builder.d = a.b();
                builder.b(a.c());
                builder.f = a.d();
                builder.g = a.bT_();
                builder.h = a.g();
                builder.f(a.bU_());
                builder.k = a.bV_();
                builder.n = a.j();
                builder.j(a.k());
                builder.v = a.l();
                builder.m(a.m());
                builder.A = a.n();
                builder.G = a.o();
                ViewerActsAsPage p = a.p();
                if (p == null) {
                    graphQLPage = null;
                } else {
                    GraphQLImage graphQLImage;
                    GraphQLPage.Builder builder2 = new GraphQLPage.Builder();
                    builder2.Z = p.b();
                    builder2.aF = p.c();
                    DefaultImageFields d = p.d();
                    if (d == null) {
                        graphQLImage = null;
                    } else {
                        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
                        builder3.d = d.a();
                        builder3.g = d.b();
                        builder3.h = d.c();
                        graphQLImage = builder3.a();
                    }
                    builder2.bv = graphQLImage;
                    graphQLPage = builder2.a();
                }
                builder.P = graphQLPage;
                graphQLFeedback = builder.a();
            }
            this.f18770a.f18774d.mo1425a(graphQLFeedback);
        }

        protected final void m22313a(Throwable th) {
            this.f18770a.f18773c.a(FacecastVideoFeedbackLoader.f18771a + "_graphFailure", "Failed to fetch video feedback " + this.f18770a.f18772b, th);
            if (this.f18770a.f18778h < 5) {
                FacecastVideoFeedbackLoader facecastVideoFeedbackLoader = this.f18770a;
                facecastVideoFeedbackLoader.f18778h++;
                FacecastVideoFeedbackLoader.m22314a(this.f18770a, 5);
            }
        }
    }

    @Inject
    public FacecastVideoFeedbackLoader(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ScheduledExecutorService scheduledExecutorService, @Assisted String str, @Assisted VideoFeedbackLoaderListener videoFeedbackLoaderListener) {
        this.f18773c = abstractFbErrorReporter;
        this.f18775e = graphQLQueryExecutor;
        this.f18776f = scheduledExecutorService;
        this.f18772b = str;
        this.f18774d = videoFeedbackLoaderListener;
    }

    public static void m22314a(FacecastVideoFeedbackLoader facecastVideoFeedbackLoader, int i) {
        facecastVideoFeedbackLoader.f18776f.schedule(new C16261(facecastVideoFeedbackLoader), (long) i, TimeUnit.SECONDS);
    }
}
