package com.facebook.pages.identity.cards.service;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestedUnits;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: plugin_state */
public class PageIdentityServiceCardSpecification implements PageBatchFetchingCardSpecification {
    public final QeAccessor f3712a;
    public final ReactionSessionManager f3713b;
    private final ReactionUtil f3714c;
    private final ExecutorService f3715d;
    private final Lazy<FbErrorReporter> f3716e;
    public final Lazy<PagesAnalytics> f3717f;
    private final Provider<GatekeeperStore> f3718g;
    public long f3719h;
    public String f3720i;
    public boolean f3721j = false;
    public boolean f3722k = false;
    private String f3723l;
    public final Surface f3724m = Surface.ANDROID_PAGE_SINGLE_CARD;
    private final ImmutableList<RequestedUnits> f3725n = ImmutableList.of(RequestedUnits.SERVICES);
    public ReactionQueryParams f3726o;

    public static PageIdentityServiceCardSpecification m4713b(InjectorLike injectorLike) {
        return new PageIdentityServiceCardSpecification(IdBasedSingletonScopeProvider.a(injectorLike, 2128), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ReactionSessionManager.a(injectorLike), ReactionUtil.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 8930));
    }

    public static PageIdentityServiceCardSpecification m4712a(InjectorLike injectorLike) {
        return m4713b(injectorLike);
    }

    @Inject
    public PageIdentityServiceCardSpecification(Provider<GatekeeperStore> provider, QeAccessor qeAccessor, ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil, ExecutorService executorService, Lazy<FbErrorReporter> lazy, Lazy<PagesAnalytics> lazy2) {
        this.f3718g = provider;
        this.f3712a = qeAccessor;
        this.f3713b = reactionSessionManager;
        this.f3714c = reactionUtil;
        this.f3715d = executorService;
        this.f3716e = lazy;
        this.f3717f = lazy2;
    }

    public final boolean mo77a() {
        return ((GatekeeperStoreImpl) this.f3718g.get()).a(PagesFb4aAbTestGatekeepers.f, false);
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityServiceCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.SERVICE;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<ListenableFuture<GraphQLResult<ReactionQueryFragmentModel>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().z()) {
            return Absent.withType();
        }
        this.f3721j = pageHeaderData.a(Permission.CREATE_CONTENT);
        this.f3722k = pageHeaderData.a(Permission.BASIC_ADMIN);
        this.f3719h = j;
        this.f3720i = pageHeaderData.g().D();
        this.f3723l = SafeUUIDGenerator.a().toString();
        this.f3726o = new ReactionQueryParams().a(Long.valueOf(this.f3719h)).b(Long.valueOf(this.f3719h)).b(this.f3725n);
        GraphQLRequest d = m4714d();
        if (d == null) {
            ((AbstractFbErrorReporter) this.f3716e.get()).a("pages.identity.cards.service.PageIdentityServiceCardSpecification", "Invalid GraphQL request to fetch Reaction data.");
            return Absent.withType();
        }
        d.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(d);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<ReactionQueryFragmentModel>>(this) {
            final /* synthetic */ PageIdentityServiceCardSpecification f3711e;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    final ReactionSession a = this.f3711e.f3713b.a(this.f3711e.f3726o, ((ReactionQueryFragmentModel) graphQLResult.e).j(), this.f3711e.f3724m);
                    pageCardsRenderScheduler2.m4244a(this.f3711e.mo79b(), new Runnable(this) {
                        final /* synthetic */ C05081 f3706b;

                        public void run() {
                            if (pageViewPlaceHolder2.f3791d == null) {
                                PageIdentityServiceCardView pageIdentityServiceCardView = (PageIdentityServiceCardView) this.f3706b.f3711e.mo76a(layoutInflater2, context2);
                                pageIdentityServiceCardView.f3732e = this.f3706b.f3711e.f3721j;
                                if (pageIdentityServiceCardView.m4722a(Long.toString(this.f3706b.f3711e.f3719h), this.f3706b.f3711e.f3720i, a)) {
                                    PageIdentityServiceCardSpecification pageIdentityServiceCardSpecification = this.f3706b.f3711e;
                                    boolean z = false;
                                    if (pageIdentityServiceCardSpecification.f3722k || pageIdentityServiceCardSpecification.f3712a.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.l, false)) {
                                        z = true;
                                    }
                                    if (z) {
                                        pageViewPlaceHolder2.m4758a(pageIdentityServiceCardView);
                                        ((PagesAnalytics) this.f3706b.f3711e.f3717f.get()).b(this.f3706b.f3711e.f3719h);
                                    }
                                }
                            }
                        }
                    });
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3715d);
        return Optional.of(b);
    }

    private GraphQLRequest<ReactionQueryFragmentModel> m4714d() {
        return this.f3714c.b(this.f3726o, this.f3723l, this.f3724m);
    }
}
