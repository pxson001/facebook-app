package com.facebook.pages.identity.cards.nux;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.graphql.cards.PageIdentityNuxCardQuery.PageIdentityNuxCardQueryString;
import com.facebook.pages.data.graphql.cards.PageIdentityNuxCardQueryModels.PageIdentityNuxCardQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.cards.nux.PageIdentityNuxCardView.C04821;
import com.facebook.pages.identity.cards.nux.PageIdentityNuxCardView.C04832;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.widget.CustomViewUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_checkup_composer_step_previous */
public class PageIdentityNuxCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3537a;

    public static PageIdentityNuxCardSpecification m4568b(InjectorLike injectorLike) {
        return new PageIdentityNuxCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageIdentityNuxCardSpecification(ExecutorService executorService) {
        this.f3537a = executorService;
    }

    public static PageIdentityNuxCardSpecification m4567a(InjectorLike injectorLike) {
        return m4568b(injectorLike);
    }

    private static GraphQLRequest<?> m4566a(long j) {
        GraphQLRequest a = GraphQLRequest.a((PageIdentityNuxCardQueryString) new PageIdentityNuxCardQueryString().a("page_id", String.valueOf(j)));
        a.e = ImmutableSet.of("GraphQlPageCardTag", "GraphQLCommerceRequestTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().y()) {
            return Absent.withType();
        }
        ListenableFuture b = graphQLBatchRequest.b(m4566a(j));
        final long j2 = j;
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final Context context2 = context;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<PageIdentityNuxCardQueryModel>>(this) {
            final /* synthetic */ PageIdentityNuxCardSpecification f3529g;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    this.f3529g.m4571a((PageIdentityNuxCardQueryModel) graphQLResult.e, j2, pageViewPlaceHolder2, context2, layoutInflater2, pageHeaderData2, pageCardsRenderScheduler2);
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3537a);
        return Optional.of(b);
    }

    @VisibleForTesting
    public final void m4571a(@Nullable PageIdentityNuxCardQueryModel pageIdentityNuxCardQueryModel, long j, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, PageCardsRenderScheduler pageCardsRenderScheduler) {
        final GraphQLReactionRequestedUnit a = pageIdentityNuxCardQueryModel != null ? pageIdentityNuxCardQueryModel.a() : null;
        if ((!PageIdentityNuxCardUtil.m4576a(a) ? 1 : null) == null) {
            final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
            final LayoutInflater layoutInflater2 = layoutInflater;
            final Context context2 = context;
            final long j2 = j;
            final PageHeaderData pageHeaderData2 = pageHeaderData;
            pageCardsRenderScheduler.m4244a(mo79b(), new Runnable(this) {
                final /* synthetic */ PageIdentityNuxCardSpecification f3536g;

                public void run() {
                    View view = pageViewPlaceHolder2.f3791d;
                    if (view == null) {
                        view = (View) this.f3536g.mo76a(layoutInflater2, context2);
                        pageViewPlaceHolder2.m4758a(view);
                    }
                    view.setVisibility(0);
                    PageIdentityNuxCardView pageIdentityNuxCardView = (PageIdentityNuxCardView) view;
                    PageIdentityNuxCardViewModel a = PageIdentityNuxCardUtil.m4575a(context2, a);
                    String valueOf = String.valueOf(j2);
                    String D = pageHeaderData2.e.D();
                    Preconditions.checkNotNull(a);
                    CustomViewUtils.b(pageIdentityNuxCardView.f3550f, new ColorDrawable(a.mo85b()));
                    pageIdentityNuxCardView.f3550f.setImageResource(a.mo83a());
                    pageIdentityNuxCardView.f3550f.setContentDescription(a.mo86b(D));
                    pageIdentityNuxCardView.f3551g.setContentDescription(a.mo90e());
                    pageIdentityNuxCardView.f3552h.setText(a.mo87c());
                    pageIdentityNuxCardView.f3553i.setText(a.mo84a(D));
                    pageIdentityNuxCardView.f3554j.setText(a.mo89d());
                    pageIdentityNuxCardView.f3554j.setOnClickListener(new C04821(pageIdentityNuxCardView, a, valueOf));
                    pageIdentityNuxCardView.f3551g.setOnClickListener(new C04832(pageIdentityNuxCardView, a, valueOf));
                }
            });
        } else if (pageViewPlaceHolder.getAttachedView() != null) {
            pageViewPlaceHolder.getAttachedView().setVisibility(8);
        }
    }

    public final boolean mo77a() {
        return true;
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityNuxCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.PAGE_NUX;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }
}
