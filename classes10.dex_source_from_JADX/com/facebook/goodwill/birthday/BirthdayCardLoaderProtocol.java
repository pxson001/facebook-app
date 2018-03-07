package com.facebook.goodwill.birthday;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGoodwillHappyBirthdayCard;
import com.facebook.graphql.model.GraphQLGoodwillHappyBirthdayStoriesConnection;
import com.facebook.graphql.model.GraphQLGoodwillHappyBirthdayStoriesEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WEBVIEW_BANNER_90 */
public class BirthdayCardLoaderProtocol {
    public final Function<GraphQLResult<GraphQLViewer>, BirthdayCardStories> f21038a = new C29941(this);
    public final Function<GraphQLResult<GraphQLViewer>, BirthdayCardStories> f21039b = new C29952(this);
    public final Executor f21040c;
    public GraphQLQueryExecutor f21041d;
    public int f21042e;

    /* compiled from: WEBVIEW_BANNER_90 */
    class C29941 implements Function<GraphQLResult<GraphQLViewer>, BirthdayCardStories> {
        final /* synthetic */ BirthdayCardLoaderProtocol f21036a;

        C29941(BirthdayCardLoaderProtocol birthdayCardLoaderProtocol) {
            this.f21036a = birthdayCardLoaderProtocol;
        }

        public Object apply(@Nullable Object obj) {
            return BirthdayCardLoaderProtocol.m22018a(this.f21036a, (GraphQLResult) obj, true);
        }
    }

    /* compiled from: WEBVIEW_BANNER_90 */
    class C29952 implements Function<GraphQLResult<GraphQLViewer>, BirthdayCardStories> {
        final /* synthetic */ BirthdayCardLoaderProtocol f21037a;

        C29952(BirthdayCardLoaderProtocol birthdayCardLoaderProtocol) {
            this.f21037a = birthdayCardLoaderProtocol;
        }

        public Object apply(@Nullable Object obj) {
            return BirthdayCardLoaderProtocol.m22018a(this.f21037a, (GraphQLResult) obj, false);
        }
    }

    public static BirthdayCardLoaderProtocol m22019b(InjectorLike injectorLike) {
        return new BirthdayCardLoaderProtocol((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    static /* synthetic */ BirthdayCardStories m22018a(BirthdayCardLoaderProtocol birthdayCardLoaderProtocol, GraphQLResult graphQLResult, boolean z) {
        BirthdayCardStories birthdayCardStories;
        if (graphQLResult == null || graphQLResult.e == null || ((GraphQLViewer) graphQLResult.e).u() == null || ((GraphQLViewer) graphQLResult.e).u().j() == null || ((GraphQLViewer) graphQLResult.e).u().j().a() == null) {
            birthdayCardStories = null;
        } else {
            Builder builder = ImmutableList.builder();
            GraphQLGoodwillHappyBirthdayStoriesConnection j = ((GraphQLViewer) graphQLResult.e).u().j();
            for (int i = 0; i < j.a().size(); i++) {
                GraphQLStory a = ((GraphQLGoodwillHappyBirthdayStoriesEdge) j.a().get(i)).a();
                String c = a.c();
                GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
                builder2.i = a;
                GraphQLFeedUnitEdge.Builder builder3 = builder2;
                builder3.f = c;
                builder.c(builder3.a());
            }
            ImmutableList b = builder.b();
            if (z) {
                GraphQLGoodwillHappyBirthdayCard u = ((GraphQLViewer) graphQLResult.e).u();
                birthdayCardStories = new BirthdayCardStories(b, new BirthdayCardResources(u.m().a(), u.l(), u.k().b(), u.k().a(), u.k().c(), ((GraphQLStoryActionLink) u.a().get(0)).aB(), ((GraphQLStoryActionLink) u.a().get(0)).aE()), j.j());
            } else {
                birthdayCardStories = new BirthdayCardStories(b, null, j.j());
            }
        }
        return birthdayCardStories;
    }

    @Inject
    public BirthdayCardLoaderProtocol(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f21040c = executorService;
        this.f21041d = graphQLQueryExecutor;
    }
}
