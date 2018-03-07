package com.facebook.pages.identity.cards.postsbyothers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQL.PostsByOthersCardQueryString;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQLModels.PostsByOthersCardQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: price_list */
public class PageIdentityPostsByOthersCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3625a;

    public static PageIdentityPostsByOthersCardSpecification m4657b(InjectorLike injectorLike) {
        return new PageIdentityPostsByOthersCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4655a(context);
    }

    public static PageIdentityPostsByOthersCardSpecification m4656a(InjectorLike injectorLike) {
        return m4657b(injectorLike);
    }

    @Inject
    public PageIdentityPostsByOthersCardSpecification(ExecutorService executorService) {
        this.f3625a = executorService;
    }

    private static GraphQLRequest<?> m4654a(long j) {
        GraphQLRequest a = GraphQLRequest.a((PostsByOthersCardQueryString) new PostsByOthersCardQueryString().a("page_id", String.valueOf(j)));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4655a(Context context) {
        return new PageIdentityPostsByOthersCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.POST_BY_OTHERS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        final FetchPageHeaderQueryModel g = pageHeaderData.g();
        if (!g.y()) {
            return Absent.withType();
        }
        GraphQLRequest a = m4654a(j);
        if (a == null) {
            return Absent.withType();
        }
        a.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(a);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final long j2 = j;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ PageIdentityPostsByOthersCardSpecification f3624g;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    Object obj2;
                    final PostsByOthersCardQueryModel postsByOthersCardQueryModel = (PostsByOthersCardQueryModel) graphQLResult.e;
                    PageIdentityPostsByOthersCardSpecification pageIdentityPostsByOthersCardSpecification = this.f3624g;
                    if (g.y() && postsByOthersCardQueryModel.j() && postsByOthersCardQueryModel.a() != null && postsByOthersCardQueryModel.a().a()) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        pageCardsRenderScheduler2.m4244a(this.f3624g.mo79b(), new Runnable(this) {
                            final /* synthetic */ C04961 f3617b;

                            public void run() {
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) PageIdentityPostsByOthersCardSpecification.m4655a(context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                ((PageIdentityPostsByOthersCardView) view).m4666a(j2, g, postsByOthersCardQueryModel);
                            }
                        });
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3625a);
        return Optional.of(b);
    }
}
