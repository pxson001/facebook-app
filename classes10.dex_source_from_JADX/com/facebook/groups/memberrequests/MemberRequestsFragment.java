package com.facebook.groups.memberrequests;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.datautil.GroupsPagedListLoader;
import com.facebook.groups.datautil.GroupsPagedListLoader.ListLoaderDelegate;
import com.facebook.groups.datautil.GroupsPagedListLoader.ResultDescription;
import com.facebook.groups.memberrequests.DefaultMemberRequestsNavigationHandler.C32951;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequests.FetchMemberRequestsString;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TVL.createResult */
public class MemberRequestsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    MemberRequestsAdapterProvider f22942a;
    public FetchMemberRequestsModel al;
    public String am;
    public C33141 an;
    public boolean ao;
    private boolean ap;
    @Inject
    public DefaultMemberRequestsNavigationHandler f22943b;
    @Inject
    public MemberRequestsController f22944c;
    @Inject
    public GroupsPagedListLoader f22945d;
    @Inject
    GraphQLQueryExecutor f22946e;
    @Inject
    public FbUriIntentHandler f22947f;
    public MemberRequestsAdapter f22948g;
    public boolean f22949h;
    public ImmutableList<EdgesModel> f22950i;

    /* compiled from: TVL.createResult */
    public class C33141 {
        public final /* synthetic */ MemberRequestsFragment f22939a;

        public C33141(MemberRequestsFragment memberRequestsFragment) {
            this.f22939a = memberRequestsFragment;
        }
    }

    /* compiled from: TVL.createResult */
    public class C33152 implements ListLoaderDelegate<FetchMemberRequestsModel, EdgesModel> {
        final /* synthetic */ MemberRequestsFragment f22940a;

        public C33152(MemberRequestsFragment memberRequestsFragment) {
            this.f22940a = memberRequestsFragment;
        }

        public final ListenableFuture<GraphQLResult<FetchMemberRequestsModel>> m24032a(@Nullable String str, GraphQLCachePolicy graphQLCachePolicy) {
            if (this.f22940a.getContext() == null) {
                return Futures.a();
            }
            GraphQlQueryString fetchMemberRequestsString = new FetchMemberRequestsString();
            fetchMemberRequestsString.a("group_id", this.f22940a.am).a("profile_image_size", Integer.valueOf(this.f22940a.getContext().getResources().getDimensionPixelSize(2131434340))).a("group_member_requests_page_size", "10");
            if (str != null) {
                fetchMemberRequestsString.a("group_member_requests_page_cursor", str);
            }
            return this.f22940a.f22946e.a(GraphQLRequest.a(fetchMemberRequestsString).a(graphQLCachePolicy));
        }

        public final ResultDescription<EdgesModel> m24031a(GraphQLResult<FetchMemberRequestsModel> graphQLResult) {
            String str = null;
            boolean z = false;
            if (graphQLResult.e == null || ((FetchMemberRequestsModel) graphQLResult.e).m24150j() == null || ((FetchMemberRequestsModel) graphQLResult.e).m24150j().m24139k() == null) {
                return null;
            }
            boolean z2;
            PageInfoModel j = ((FetchMemberRequestsModel) graphQLResult.e).m24150j().m24139k().m24124j();
            MemberRequestsFragment memberRequestsFragment = this.f22940a;
            if (GraphQLGroupAdminType.ADMIN == ((FetchMemberRequestsModel) graphQLResult.e).m24150j().m24141m() || GraphQLGroupAdminType.MODERATOR == ((FetchMemberRequestsModel) graphQLResult.e).m24150j().m24141m()) {
                z2 = true;
            } else {
                z2 = false;
            }
            memberRequestsFragment.f22949h = z2;
            if (j != null) {
                str = j.m24116a();
            }
            if (!(j == null || j.m24118j())) {
                z = true;
            }
            this.f22940a.al = (FetchMemberRequestsModel) graphQLResult.e;
            return new ResultDescription(((FetchMemberRequestsModel) graphQLResult.e).m24150j().m24139k().m24122a(), z, str);
        }

        public final void m24033a(ImmutableList immutableList, boolean z) {
            this.f22940a.ao = z;
            this.f22940a.f22950i = immutableList;
            this.f22940a.f22948g.m24029a(this.f22940a.al, this.f22940a.f22950i, this.f22940a.f22944c, false, this.f22940a.f22949h);
        }
    }

    /* compiled from: TVL.createResult */
    class C33163 implements OnScrollListener {
        final /* synthetic */ MemberRequestsFragment f22941a;

        C33163(MemberRequestsFragment memberRequestsFragment) {
            this.f22941a = memberRequestsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            MemberRequestsFragment memberRequestsFragment = this.f22941a;
            Object obj = null;
            if (!(i2 == 0 || i3 == 0 || memberRequestsFragment.ao || (i + i2) + 3 <= i3)) {
                obj = 1;
            }
            if (obj != null) {
                this.f22941a.f22945d.b();
            }
        }
    }

    public static void m24035a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MemberRequestsFragment) obj).m24034a((MemberRequestsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemberRequestsAdapterProvider.class), DefaultMemberRequestsNavigationHandler.m24009b(fbInjector), MemberRequestsController.m24030b(fbInjector), GroupsPagedListLoader.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), FbUriIntentHandler.a(fbInjector));
    }

    private void m24034a(MemberRequestsAdapterProvider memberRequestsAdapterProvider, DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler, MemberRequestsController memberRequestsController, GroupsPagedListLoader groupsPagedListLoader, GraphQLQueryExecutor graphQLQueryExecutor, FbUriIntentHandler fbUriIntentHandler) {
        this.f22942a = memberRequestsAdapterProvider;
        this.f22943b = defaultMemberRequestsNavigationHandler;
        this.f22944c = memberRequestsController;
        this.f22945d = groupsPagedListLoader;
        this.f22946e = graphQLQueryExecutor;
        this.f22947f = fbUriIntentHandler;
    }

    public final void m24039c(Bundle bundle) {
        super.c(bundle);
        Class cls = MemberRequestsFragment.class;
        m24035a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.am = (String) bundle2.get("group_feed_id");
        this.ap = bundle2.getBoolean("groups_single_page_mode", false);
    }

    public final View m24037a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1531033817);
        View inflate = layoutInflater.inflate(2130904731, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -827015736, a);
        return inflate;
    }

    public final void m24038a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = new C33141(this);
        this.f22945d.a(new C33152(this));
        this.f22945d.a();
        boolean z = this.s.getBoolean("group_request_member_header_visible", true);
        MemberRequestsAdapterProvider memberRequestsAdapterProvider = this.f22942a;
        this.f22948g = new MemberRequestsAdapter(this.an, z, DefaultMemberRequestsNavigationHandler.m24009b(memberRequestsAdapterProvider), (UriIntentMapper) Fb4aUriIntentMapper.a(memberRequestsAdapterProvider), DefaultTimeFormatUtil.a(memberRequestsAdapterProvider), (SecureContextHelper) DefaultSecureContextHelper.a(memberRequestsAdapterProvider), ResourcesMethodAutoProvider.a(memberRequestsAdapterProvider));
        m24036c(view);
    }

    private void m24036c(View view) {
        DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22943b;
        defaultMemberRequestsNavigationHandler.f22872c = this.am;
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131242227);
            Builder a = TitleBarButtonSpec.a();
            a.b = jW_().getDrawable(2130837999);
            a = a;
            a.j = jW_().getString(2131242228);
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C32951(defaultMemberRequestsNavigationHandler, this));
        }
        BetterListView betterListView = (BetterListView) e(2131562801);
        this.f22948g.m24029a(null, null, this.f22944c, true, this.f22949h);
        betterListView.setAdapter(this.f22948g);
        betterListView.setOnScrollListener(new C33163(this));
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1438872703);
        super.mY_();
        this.f22945d.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1186206947, a);
    }

    public final String am_() {
        return "member_requests";
    }
}
