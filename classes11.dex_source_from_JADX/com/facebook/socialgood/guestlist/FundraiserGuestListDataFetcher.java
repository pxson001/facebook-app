package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.socialgood.guestlist.FundraiserGuestList.FundraiserDonorsConnectionQueryString;
import com.facebook.socialgood.guestlist.FundraiserGuestList.FundraiserInvitedUsersConnectionQueryString;
import com.facebook.socialgood.guestlist.FundraiserGuestList.FundraiserNonDonorsConnectionQueryString;
import com.facebook.socialgood.guestlist.FundraiserGuestList.FundraiserSharersConnectionQueryString;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserDonorsConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserDonorsConnectionQueryModel.DonorsModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserInvitedUsersConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserInvitedUsersConnectionQueryModel.InvitedUsersModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserInvitedUsersConnectionQueryModel.InvitedUsersModel.EdgesModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserSharersConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserSharersConnectionQueryModel.SharersModel;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: PAST */
public class FundraiserGuestListDataFetcher implements FutureCallback<GraphQLResult> {
    @Inject
    private GraphQLQueryExecutor f12620a;
    @Inject
    @ForUiThread
    private ListeningScheduledExecutorService f12621b;
    @Inject
    private AnalyticsLogger f12622c;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> f12623d = UltralightRuntime.b;
    @Inject
    @LoggedInUserId
    private Provider<String> f12624e;
    @Inject
    public Context f12625f;
    private ListenableFuture<GraphQLResult> f12626g = null;
    private PageState f12627h = PageState.INITIAL;
    public String f12628i = null;
    public String f12629j;
    public FundraiserGuestListTab f12630k;
    private FundraiserGuestListDataFetcherListener f12631l;
    private boolean f12632m;

    /* compiled from: PAST */
    public interface FundraiserGuestListDataFetcherListener {
        void mo362a(ImmutableList<FundraiserGuestListUser> immutableList);
    }

    /* compiled from: PAST */
    public enum PageState {
        INITIAL,
        PAGING,
        ERROR,
        COMPLETE
    }

    public static FundraiserGuestListDataFetcher m13043b(InjectorLike injectorLike) {
        FundraiserGuestListDataFetcher fundraiserGuestListDataFetcher = new FundraiserGuestListDataFetcher();
        fundraiserGuestListDataFetcher.m13040a(GraphQLQueryExecutor.a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedProvider.a(injectorLike, 4442), (Context) injectorLike.getInstance(Context.class));
        return fundraiserGuestListDataFetcher;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            HoneyClientEvent d = SocialGoodLogHelper.d(this.f12629j);
            if (this.f12630k != null) {
                d.b("guest_list_tab_load_failure", this.f12630k.toString());
            }
            this.f12622c.a(d);
            this.f12627h = PageState.ERROR;
            return;
        }
        this.f12628i = m13039a(graphQLResult.e);
        this.f12627h = this.f12628i == null ? PageState.COMPLETE : PageState.PAGING;
        this.f12626g = null;
    }

    public final void m13046a(String str, FundraiserGuestListTab fundraiserGuestListTab, FundraiserGuestListDataFetcherListener fundraiserGuestListDataFetcherListener, boolean z) {
        this.f12629j = str;
        this.f12630k = fundraiserGuestListTab;
        this.f12631l = fundraiserGuestListDataFetcherListener;
        this.f12632m = z;
    }

    public final void m13045a() {
        if (this.f12626g == null && this.f12627h != PageState.COMPLETE && this.f12627h != PageState.ERROR) {
            TypedGraphQlQueryString fundraiserInvitedUsersConnectionQueryString;
            switch (this.f12630k) {
                case INVITED:
                    fundraiserInvitedUsersConnectionQueryString = new FundraiserInvitedUsersConnectionQueryString();
                    break;
                case SHARED:
                    fundraiserInvitedUsersConnectionQueryString = new FundraiserSharersConnectionQueryString();
                    break;
                case DONATED:
                    fundraiserInvitedUsersConnectionQueryString = new FundraiserDonorsConnectionQueryString();
                    break;
                case NOT_DONATED:
                    fundraiserInvitedUsersConnectionQueryString = new FundraiserNonDonorsConnectionQueryString();
                    break;
                default:
                    fundraiserInvitedUsersConnectionQueryString = null;
                    break;
            }
            TypedGraphQlQueryString typedGraphQlQueryString = fundraiserInvitedUsersConnectionQueryString;
            if (typedGraphQlQueryString != null) {
                GraphQLRequest a = GraphQLRequest.a(typedGraphQlQueryString);
                GraphQlQueryParamSet graphQlQueryParamSet = new GraphQlQueryParamSet();
                graphQlQueryParamSet.a("campaignID", this.f12629j).a("numConnections", Integer.valueOf(10)).a("profile_image_size", Integer.valueOf(this.f12625f.getResources().getDimensionPixelSize(2131434506)));
                if (this.f12628i != null) {
                    graphQlQueryParamSet.a("afterCursor", this.f12628i);
                }
                this.f12626g = this.f12620a.a(a.a(graphQlQueryParamSet));
                Futures.a(this.f12626g, this, this.f12621b);
                return;
            }
            this.f12627h = PageState.COMPLETE;
        }
    }

    public void onFailure(Throwable th) {
        HoneyClientEvent d = SocialGoodLogHelper.d(this.f12629j);
        if (this.f12630k != null) {
            d.b("guest_list_tab_load_failure", this.f12630k.toString());
        }
        this.f12622c.a(d);
        ((AbstractFbErrorReporter) this.f12623d.get()).a("guest_list_tab_load_failure", th);
        this.f12627h = PageState.ERROR;
    }

    private String m13039a(Object obj) {
        switch (this.f12630k) {
            case INVITED:
                return m13036a(((FundraiserInvitedUsersConnectionQueryModel) obj).m13125j());
            case SHARED:
                return m13038a(((FundraiserSharersConnectionQueryModel) obj).m13162j());
            case DONATED:
                return m13035a(((FundraiserDonorsConnectionQueryModel) obj).m13097j());
            case NOT_DONATED:
                return m13037a(((FundraiserNonDonorsConnectionQueryModel) obj).m13146j());
            default:
                return null;
        }
    }

    private String m13036a(InvitedUsersModel invitedUsersModel) {
        if (invitedUsersModel == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = invitedUsersModel.m13115a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (!(edgesModel == null || edgesModel.m13111a() == null || TextUtils.isEmpty(edgesModel.m13111a().m13075m()) || !m13042a(edgesModel.m13111a().m13072j()))) {
                builder.c(new FundraiserGuestListUser(edgesModel.m13111a(), m13044b(edgesModel.m13111a().m13072j())));
            }
        }
        m13041a(builder.b());
        return invitedUsersModel.m13116j() == null ? null : invitedUsersModel.m13116j().a();
    }

    private String m13038a(SharersModel sharersModel) {
        if (sharersModel == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = sharersModel.m13153a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FundraiserConnectionsFragmentModel fundraiserConnectionsFragmentModel = (FundraiserConnectionsFragmentModel) a.get(i);
            if (!(fundraiserConnectionsFragmentModel == null || TextUtils.isEmpty(fundraiserConnectionsFragmentModel.m13075m()) || !m13042a(fundraiserConnectionsFragmentModel.m13072j()))) {
                builder.c(new FundraiserGuestListUser(fundraiserConnectionsFragmentModel, m13044b(fundraiserConnectionsFragmentModel.m13072j())));
            }
        }
        m13041a(builder.b());
        return sharersModel.m13154j() == null ? null : sharersModel.m13154j().a();
    }

    private String m13035a(DonorsModel donorsModel) {
        if (donorsModel == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = donorsModel.m13087a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            DonorsModel.EdgesModel edgesModel = (DonorsModel.EdgesModel) a.get(i);
            if (!(edgesModel == null || edgesModel.m13083a() == null || TextUtils.isEmpty(edgesModel.m13083a().m13075m()) || !m13042a(edgesModel.m13083a().m13072j()))) {
                builder.c(new FundraiserGuestListUser(edgesModel.m13083a(), m13044b(edgesModel.m13083a().m13072j())));
            }
        }
        m13041a(builder.b());
        return donorsModel.m13088j() == null ? null : donorsModel.m13088j().a();
    }

    private void m13040a(GraphQLQueryExecutor graphQLQueryExecutor, ListeningScheduledExecutorService listeningScheduledExecutorService, AnalyticsLogger analyticsLogger, com.facebook.inject.Lazy<FbErrorReporter> lazy, Provider<String> provider, Context context) {
        this.f12620a = graphQLQueryExecutor;
        this.f12621b = listeningScheduledExecutorService;
        this.f12622c = analyticsLogger;
        this.f12623d = lazy;
        this.f12624e = provider;
        this.f12625f = context;
    }

    private String m13037a(FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel invitedUsersModel) {
        if (invitedUsersModel == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = invitedUsersModel.m13136a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel edgesModel = (FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel) a.get(i);
            if (!(edgesModel == null || edgesModel.m13132a() == null || TextUtils.isEmpty(edgesModel.m13132a().m13075m()) || !m13042a(edgesModel.m13132a().m13072j()))) {
                builder.c(new FundraiserGuestListUser(edgesModel.m13132a(), m13044b(edgesModel.m13132a().m13072j())));
            }
        }
        m13041a(builder.b());
        return invitedUsersModel.m13137j() == null ? null : invitedUsersModel.m13137j().a();
    }

    private boolean m13042a(String str) {
        return this.f12632m || !m13044b(str);
    }

    private boolean m13044b(String str) {
        if (this.f12624e.get() == null) {
            return false;
        }
        return ((String) this.f12624e.get()).equals(str);
    }

    private void m13041a(ImmutableList<FundraiserGuestListUser> immutableList) {
        this.f12631l.mo362a(immutableList);
    }
}
