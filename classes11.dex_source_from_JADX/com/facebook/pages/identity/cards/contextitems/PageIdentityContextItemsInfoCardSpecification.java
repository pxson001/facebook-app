package com.facebook.pages.identity.cards.contextitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences.Fb4aSecondaryCardsSequenceDefinition;
import com.facebook.pages.common.sequencelogger.PagesSequenceLoggerHelper;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQL.PageInfoCardContextItemQueryString;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLModels.PageInfoCardContextItemQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.pages.identity.common.PagesCardCacheKeySerializer;
import com.facebook.pages.identity.common.PagesCardCacheKeySerializerProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.OnDispatchDrawListener;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_checkup_manager_empty_section_header */
public class PageIdentityContextItemsInfoCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3402a;
    private final Resources f3403b;
    public final PagesSequenceLoggerHelper f3404c;
    private final PagesCardCacheKeySerializerProvider f3405d;
    public final Provider<GatekeeperStore> f3406e;

    public static PageIdentityContextItemsInfoCardSpecification m4507b(InjectorLike injectorLike) {
        return new PageIdentityContextItemsInfoCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), PagesSequenceLoggerHelper.b(injectorLike), (PagesCardCacheKeySerializerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesCardCacheKeySerializerProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 2128));
    }

    public static PageIdentityContextItemsInfoCardSpecification m4506a(InjectorLike injectorLike) {
        return m4507b(injectorLike);
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4505a(context);
    }

    private GraphQLRequest<PageInfoCardContextItemQueryModel> m4504a(long j) {
        GraphQLRequest a = GraphQLRequest.a((PageInfoCardContextItemQueryString) new PageInfoCardContextItemQueryString().a("page_id", String.valueOf(j)).a("context_items_source", "newsfeed").a("context_items_source_id", "").a("context_item_icon_size", String.valueOf(this.f3403b.getDimensionPixelSize(2131429771))).a("scale", GraphQlQueryDefaults.a()).a("context_items_card_limit", String.valueOf(this.f3403b.getInteger(2131492916)))).a(new PagesCardCacheKeySerializer("page_id", "0"));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(2419200).a(RequestPriority.INTERACTIVE);
    }

    @Inject
    public PageIdentityContextItemsInfoCardSpecification(ExecutorService executorService, Resources resources, PagesSequenceLoggerHelper pagesSequenceLoggerHelper, PagesCardCacheKeySerializerProvider pagesCardCacheKeySerializerProvider, Provider<GatekeeperStore> provider) {
        this.f3402a = executorService;
        this.f3403b = resources;
        this.f3404c = pagesSequenceLoggerHelper;
        this.f3405d = pagesCardCacheKeySerializerProvider;
        this.f3406e = provider;
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4505a(Context context) {
        return new PageIdentityContextItemsInfoCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.CONTEXT_ITEMS_INFO_CARD;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<ListenableFuture<GraphQLResult<PageInfoCardContextItemQueryModel>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        ListenableFuture b = graphQLBatchRequest.b(m4504a(j).a(graphQLCachePolicy));
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        final long j2 = j;
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        Futures.a(b, new FutureCallback<GraphQLResult<PageInfoCardContextItemQueryModel>>(this) {
            final /* synthetic */ PageIdentityContextItemsInfoCardSpecification f3401g;

            public void onSuccess(@Nullable Object obj) {
                final GraphQLResult graphQLResult = (GraphQLResult) obj;
                pageCardsRenderScheduler2.m4244a(this.f3401g.mo79b(), new Runnable(this) {
                    final /* synthetic */ C04611 f3394b;

                    /* compiled from: privacy_checkup_manager_empty_section_header */
                    class C04591 implements OnDispatchDrawListener {
                        final /* synthetic */ C04601 f3392a;

                        /* compiled from: privacy_checkup_manager_empty_section_header */
                        class C04581 implements Runnable {
                            final /* synthetic */ C04591 f3391a;

                            C04581(C04591 c04591) {
                                this.f3391a = c04591;
                            }

                            public void run() {
                                pageCardsRenderScheduler2.m4243a();
                            }
                        }

                        C04591(C04601 c04601) {
                            this.f3392a = c04601;
                        }

                        public final boolean m4503a() {
                            Object obj;
                            boolean z;
                            this.f3392a.f3394b.f3401g.f3404c.b("PageLoadFirstCard", PageSequences.f);
                            this.f3392a.f3394b.f3401g.f3404c.b("PageCreateToFirstCardLoad", PageSequences.f);
                            PagesSequenceLoggerHelper pagesSequenceLoggerHelper = this.f3392a.f3394b.f3401g.f3404c;
                            Fb4aSecondaryCardsSequenceDefinition fb4aSecondaryCardsSequenceDefinition = PageSequences.f;
                            Builder builder = new Builder();
                            String str = "PageCardsSchedulingEnabled";
                            if (((GatekeeperStoreImpl) this.f3392a.f3394b.f3401g.f3406e.get()).a(PagesFb4aAbTestGatekeepers.d, false)) {
                                obj = "1";
                            } else {
                                obj = "0";
                            }
                            builder = builder.b(str, obj);
                            str = "FirstCardCached";
                            if (DataFreshnessResult.FROM_SERVER.equals(graphQLResult.freshness)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            builder = builder.b(str, String.valueOf(z));
                            str = "PageServicesCardEnabled";
                            if (((GatekeeperStoreImpl) this.f3392a.f3394b.f3401g.f3406e.get()).a(PagesFb4aAbTestGatekeepers.f, false)) {
                                obj = "1";
                            } else {
                                obj = "0";
                            }
                            pagesSequenceLoggerHelper.a(fb4aSecondaryCardsSequenceDefinition, builder.b(str, obj).b());
                            HandlerDetour.a(new Handler(Looper.getMainLooper()), new C04581(this), -1955364718);
                            return true;
                        }
                    }

                    public void run() {
                        View view = pageViewPlaceHolder2.f3791d;
                        if (view == null) {
                            View view2 = (View) PageIdentityContextItemsInfoCardSpecification.m4505a(context2);
                            pageViewPlaceHolder2.m4758a(view2);
                            view = view2;
                        }
                        if (graphQLResult == null || graphQLResult.e == null || ((PageInfoCardContextItemQueryModel) graphQLResult.e).j() == null) {
                            pageCardsRenderScheduler2.m4243a();
                            this.f3394b.f3401g.f3404c.c("PageLoadFirstCard", PageSequences.f);
                            this.f3394b.f3401g.f3404c.c("PageCreateToFirstCardLoad", PageSequences.f);
                            this.f3394b.f3401g.f3404c.c(PageSequences.f);
                            return;
                        }
                        String str;
                        ((PageSecondaryCardView) view).m3357a(new C04591(this));
                        PageIdentityContextItemsInfoCardView pageIdentityContextItemsInfoCardView = (PageIdentityContextItemsInfoCardView) view;
                        long j = j2;
                        if (pageHeaderData2 == null || pageHeaderData2.e == null) {
                            str = null;
                        } else {
                            str = pageHeaderData2.e.D();
                        }
                        pageIdentityContextItemsInfoCardView.m4519a(j, str, (PageInfoCardContextItemQueryModel) graphQLResult.e);
                    }
                });
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3402a);
        return Optional.of(b);
    }
}
