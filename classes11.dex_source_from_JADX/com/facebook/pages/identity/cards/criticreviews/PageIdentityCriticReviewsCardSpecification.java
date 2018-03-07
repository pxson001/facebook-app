package com.facebook.pages.identity.cards.criticreviews;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.UriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQL.CriticReviewsCardQueryString;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLModels.CriticReviewsCardQueryModel;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLModels.CriticReviewsCardQueryModel.CriticReviewsReceivedModel.NodesModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_checkup_manager_empty_review_item */
public class PageIdentityCriticReviewsCardSpecification implements PageBatchFetchingCardSpecification {
    private final GraphQLImageHelper f3454a;
    private final Resources f3455b;
    private final ExecutorService f3456c;
    private final Provider<GatekeeperStore> f3457d;

    public static PageIdentityCriticReviewsCardSpecification m4529b(InjectorLike injectorLike) {
        return new PageIdentityCriticReviewsCardSpecification(GraphQLImageHelper.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2128), ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityCriticReviewsCardSpecification m4528a(InjectorLike injectorLike) {
        return m4529b(injectorLike);
    }

    @Inject
    public PageIdentityCriticReviewsCardSpecification(GraphQLImageHelper graphQLImageHelper, Provider<GatekeeperStore> provider, Resources resources, ExecutorService executorService) {
        this.f3457d = provider;
        this.f3454a = graphQLImageHelper;
        this.f3455b = resources;
        this.f3456c = executorService;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        GraphQLRequest a = m4527a(j);
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
            final /* synthetic */ PageIdentityCriticReviewsCardSpecification f3453f;

            public void onSuccess(@Nullable Object obj) {
                List list;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                List arrayList = new ArrayList();
                if (graphQLResult == null || graphQLResult.e == null || ((CriticReviewsCardQueryModel) graphQLResult.e).a() == null || ((CriticReviewsCardQueryModel) graphQLResult.e).a().a().isEmpty()) {
                    list = arrayList;
                } else {
                    for (NodesModel nodesModel : ((CriticReviewsCardQueryModel) graphQLResult.e).a().a()) {
                        Object obj2;
                        if (nodesModel.ks_() == null || nodesModel.g() == null || Strings.isNullOrEmpty(nodesModel.g().a()) || nodesModel.b() == null || UriUtil.a(nodesModel.b().a()) == null || nodesModel.kt_() == null || nodesModel.kt_().d() == null || UriUtil.a(nodesModel.kt_().d().a()) == null || UriUtil.a(nodesModel.c()) == null) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 != null) {
                            arrayList.add(nodesModel);
                        }
                    }
                    list = arrayList;
                }
                final List list2 = list;
                if (!list2.isEmpty()) {
                    pageCardsRenderScheduler2.m4244a(this.f3453f.mo79b(), new Runnable(this) {
                        final /* synthetic */ C04711 f3447b;

                        public void run() {
                            View view = pageViewPlaceHolder2.f3791d;
                            if (view == null) {
                                view = (View) this.f3447b.f3453f.mo76a(layoutInflater2, context2);
                                pageViewPlaceHolder2.m4758a(view);
                            }
                            PageIdentityCriticReviewsCardView pageIdentityCriticReviewsCardView = (PageIdentityCriticReviewsCardView) view;
                            String valueOf = String.valueOf(j2);
                            List list = list2;
                            PageIdentityCriticReviewsAdapterProvider pageIdentityCriticReviewsAdapterProvider = pageIdentityCriticReviewsCardView.f3458a;
                            PageIdentityCriticReviewsAdapter pageIdentityCriticReviewsAdapter = new PageIdentityCriticReviewsAdapter(FbUriIntentHandler.a(pageIdentityCriticReviewsAdapterProvider), ReviewsLogger.a(pageIdentityCriticReviewsAdapterProvider), (SecureContextHelper) DefaultSecureContextHelper.a(pageIdentityCriticReviewsAdapterProvider), RecyclableViewPoolManager.a(pageIdentityCriticReviewsAdapterProvider), pageIdentityCriticReviewsCardView.f3459b);
                            pageIdentityCriticReviewsAdapter.f3445f = valueOf;
                            pageIdentityCriticReviewsAdapter.f3444e = list;
                            pageIdentityCriticReviewsAdapter.kR_();
                            pageIdentityCriticReviewsCardView.f3459b.setAdapter(pageIdentityCriticReviewsAdapter);
                        }
                    });
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3456c);
        return Optional.of(b);
    }

    private GraphQLRequest<?> m4527a(long j) {
        int intValue = GraphQLImageHelper.a(this.f3455b.getDimensionPixelSize(2131432677)).intValue();
        TypedValue typedValue = new TypedValue();
        this.f3455b.getValue(2131432676, typedValue, true);
        int intValue2 = this.f3454a.f().intValue();
        GraphQLRequest a = GraphQLRequest.a((CriticReviewsCardQueryString) new CriticReviewsCardQueryString().a("page_id", String.valueOf(j)).a("profile_pic_size", Integer.valueOf(intValue)).a("review_image_width", Integer.valueOf(intValue2)).a("review_image_height", Integer.valueOf((int) (((float) intValue2) / typedValue.getFloat()))).a("reviews_count", Integer.valueOf(5)));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final boolean mo77a() {
        return ((GatekeeperStoreImpl) this.f3457d.get()).a(PagesFb4aAbTestGatekeepers.b, false);
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityCriticReviewsCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.CRITIC_REVIEWS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }
}
