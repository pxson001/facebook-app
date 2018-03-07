package com.facebook.pages.identity.cards.commerce;

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
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQL.PageIdentityCommerceCardQueryString;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel;
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

/* compiled from: privacy_checkup_profile_step_next */
public class PageIdentityCommerceCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3357a;
    private int f3358b = 0;

    public static PageIdentityCommerceCardSpecification m4470b(InjectorLike injectorLike) {
        return new PageIdentityCommerceCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4468a(context);
    }

    @Inject
    public PageIdentityCommerceCardSpecification(ExecutorService executorService) {
        this.f3357a = executorService;
    }

    public static PageIdentityCommerceCardSpecification m4469a(InjectorLike injectorLike) {
        return m4470b(injectorLike);
    }

    public final boolean mo77a() {
        return true;
    }

    private GraphQLRequest<?> m4467a(long j) {
        GraphQLRequest a = GraphQLRequest.a((PageIdentityCommerceCardQueryString) new PageIdentityCommerceCardQueryString().a("page_id", String.valueOf(j)).a("product_item_image_size", Integer.valueOf(this.f3358b / 2)));
        a.e = ImmutableSet.of("GraphQlPageCardTag", "GraphQLCommerceRequestTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public static PageSecondaryCardView m4468a(Context context) {
        return new PageIdentityCommerceCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.COMMERCE;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().y()) {
            return Absent.withType();
        }
        this.f3358b = context.getResources().getDisplayMetrics().widthPixels;
        GraphQLRequest a = m4467a(j);
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
            final /* synthetic */ PageIdentityCommerceCardSpecification f3356f;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    boolean z;
                    Object obj2;
                    final PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel = (PageIdentityCommerceCardQueryModel) graphQLResult.e;
                    if (pageIdentityCommerceCardQueryModel == null || pageIdentityCommerceCardQueryModel.j() == null || pageIdentityCommerceCardQueryModel.j().j().a().isEmpty()) {
                        z = false;
                    } else if (PageIdentityCommerceCardViewHelper.m4486c(pageIdentityCommerceCardQueryModel.j().j())) {
                        z = PageIdentityCommerceCardViewHelper.m4487c(pageIdentityCommerceCardQueryModel);
                    } else {
                        z = true;
                    }
                    if (z) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        pageCardsRenderScheduler2.m4244a(this.f3356f.mo79b(), new Runnable(this) {
                            final /* synthetic */ C04521 f3350b;

                            public void run() {
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) PageIdentityCommerceCardSpecification.m4468a(context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                view.setVisibility(0);
                                ((PageIdentityCommerceCardView) view).m4481a(j2, pageIdentityCommerceCardQueryModel);
                            }
                        });
                    } else if (pageViewPlaceHolder2.f3791d != null) {
                        pageViewPlaceHolder2.f3791d.setVisibility(8);
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3357a);
        return Optional.of(b);
    }
}
