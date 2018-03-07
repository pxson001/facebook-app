package com.facebook.groups.fb4a.addtogroups;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.datautil.GroupsPagedListLoader;
import com.facebook.groups.datautil.GroupsPagedListLoader.ListLoaderDelegate;
import com.facebook.groups.datautil.GroupsPagedListLoader.ResultDescription;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroups.FetchUserGroupsForProfileAddToGroupsString;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroupsModels.FetchUserGroupsForProfileAddToGroupsModel;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroupsModels.FetchUserGroupsForProfileAddToGroupsModel.GroupsModel.EdgesModel;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroupsModels.FetchUserGroupsForProfileAddToGroupsModel.GroupsModel.PageInfoModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.facebook.groups.memberpicker.protocol.MultipleMemberAdder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Set;
import java.util.Vector;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: x^ */
public class FB4AAddToGroupsFragment extends FbFragment implements CanHandleBackPressed {
    private static final String am = FB4AAddToGroupsFragment.class.getName();
    @Inject
    Toaster f256a;
    ImmutableList<EdgesModel> al;
    public String an;
    public String ao;
    public BetterListView ap;
    public FB4AAddToGroupsListAdapter aq;
    public boolean ar = false;
    public boolean as;
    @Inject
    public FB4AAddToGroupsController f257b;
    @Inject
    public FB4AAddToGroupsListAdapterProvider f258c;
    @Inject
    public GroupsPagedListLoader f259d;
    @Inject
    GraphQLQueryExecutor f260e;
    @Inject
    MultipleMemberAdder f261f;
    @Inject
    AbstractFbErrorReporter f262g;
    @Inject
    @LoggedInUserId
    Provider<String> f263h;
    @Inject
    @ForUiThread
    ListeningExecutorService f264i;

    /* compiled from: x^ */
    public class C00431 implements OnClickListener {
        final /* synthetic */ FB4AAddToGroupsFragment f247a;

        public C00431(FB4AAddToGroupsFragment fB4AAddToGroupsFragment) {
            this.f247a = fB4AAddToGroupsFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f247a.as = true;
            this.f247a.o().onBackPressed();
        }
    }

    /* compiled from: x^ */
    public class C00442 implements OnClickListener {
        final /* synthetic */ FB4AAddToGroupsFragment f248a;

        public C00442(FB4AAddToGroupsFragment fB4AAddToGroupsFragment) {
            this.f248a = fB4AAddToGroupsFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: x^ */
    public class C00463 extends OnToolbarButtonListener {
        final /* synthetic */ FB4AAddToGroupsFragment f253a;

        public C00463(FB4AAddToGroupsFragment fB4AAddToGroupsFragment) {
            this.f253a = fB4AAddToGroupsFragment;
        }

        public final void m299a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (!this.f253a.ar) {
                final Set<String> a = this.f253a.f257b.m295a();
                if (a.isEmpty()) {
                    this.f253a.f256a.b(new ToastBuilder(2131237827));
                    return;
                }
                this.f253a.f256a.b(new ToastBuilder(2131237826));
                final Vector vector = new Vector();
                final Vector vector2 = new Vector();
                for (String str : a) {
                    vector2.add(str);
                    Futures.a(this.f253a.f261f.a(str, ImmutableList.of(this.f253a.an), null), new AbstractDisposableFutureCallback<GraphQLResult<GroupAddMembersMutationModel>>(this) {
                        final /* synthetic */ C00463 f252d;

                        protected final void m297a(Object obj) {
                            FB4AAddToGroupsFragment.m303a(this.f252d.f253a, vector, vector2, a);
                        }

                        protected final void m298a(Throwable th) {
                            vector.add("");
                            FB4AAddToGroupsFragment.m303a(this.f252d.f253a, vector, vector2, a);
                        }
                    }, this.f253a.f264i);
                }
            }
        }
    }

    /* compiled from: x^ */
    public class C00474 implements OnScrollListener {
        final /* synthetic */ FB4AAddToGroupsFragment f254a;

        public C00474(FB4AAddToGroupsFragment fB4AAddToGroupsFragment) {
            this.f254a = fB4AAddToGroupsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Object obj = null;
            if (!(i == 0 || i2 == 0 || i3 == 0 || (i + i2) + 3 <= i3)) {
                obj = 1;
            }
            if (obj != null) {
                this.f254a.f259d.b();
            }
        }
    }

    /* compiled from: x^ */
    public class C00485 implements ListLoaderDelegate<FetchUserGroupsForProfileAddToGroupsModel, EdgesModel> {
        final /* synthetic */ FB4AAddToGroupsFragment f255a;

        public final ListenableFuture<GraphQLResult<FetchUserGroupsForProfileAddToGroupsModel>> m301a(@Nullable String str, GraphQLCachePolicy graphQLCachePolicy) {
            GraphQlQueryString fetchUserGroupsForProfileAddToGroupsString = new FetchUserGroupsForProfileAddToGroupsString();
            fetchUserGroupsForProfileAddToGroupsString.a("inviting_user_id", (String) this.f255a.f263h.get());
            fetchUserGroupsForProfileAddToGroupsString.a("cover_photo_height", "64");
            fetchUserGroupsForProfileAddToGroupsString.a("cover_photo_width", "64");
            fetchUserGroupsForProfileAddToGroupsString.a("friend_id", this.f255a.an);
            fetchUserGroupsForProfileAddToGroupsString.a("add_to_groups_page_cursor", str);
            fetchUserGroupsForProfileAddToGroupsString.a("add_to_groups_page_size", "20");
            return this.f255a.f260e.a(GraphQLRequest.a(fetchUserGroupsForProfileAddToGroupsString).a(graphQLCachePolicy));
        }

        public C00485(FB4AAddToGroupsFragment fB4AAddToGroupsFragment) {
            this.f255a = fB4AAddToGroupsFragment;
        }

        public final ResultDescription<EdgesModel> m300a(GraphQLResult<FetchUserGroupsForProfileAddToGroupsModel> graphQLResult) {
            String str = null;
            boolean z = false;
            if (graphQLResult.e == null || ((FetchUserGroupsForProfileAddToGroupsModel) graphQLResult.e).m354j() == null) {
                return null;
            }
            PageInfoModel j = ((FetchUserGroupsForProfileAddToGroupsModel) graphQLResult.e).m354j().m345j();
            if (j != null) {
                str = j.m338a();
            }
            if (!(j == null || j.m340j())) {
                z = true;
            }
            return new ResultDescription(((FetchUserGroupsForProfileAddToGroupsModel) graphQLResult.e).m354j().m344a(), z, str);
        }

        public final void m302a(ImmutableList immutableList, boolean z) {
            this.f255a.al = immutableList;
            this.f255a.aq.m322a(this.f255a.an, this.f255a.al, this.f255a.f257b, false);
        }
    }

    public static void m305a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4AAddToGroupsFragment) obj).m304a(Toaster.b(fbInjector), new FB4AAddToGroupsController(), (FB4AAddToGroupsListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FB4AAddToGroupsListAdapterProvider.class), GroupsPagedListLoader.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), MultipleMemberAdder.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), IdBasedProvider.a(fbInjector, 4442), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m304a(Toaster toaster, FB4AAddToGroupsController fB4AAddToGroupsController, FB4AAddToGroupsListAdapterProvider fB4AAddToGroupsListAdapterProvider, GroupsPagedListLoader groupsPagedListLoader, GraphQLQueryExecutor graphQLQueryExecutor, MultipleMemberAdder multipleMemberAdder, FbErrorReporter fbErrorReporter, Provider<String> provider, ListeningExecutorService listeningExecutorService) {
        this.f256a = toaster;
        this.f257b = fB4AAddToGroupsController;
        this.f258c = fB4AAddToGroupsListAdapterProvider;
        this.f259d = groupsPagedListLoader;
        this.f260e = graphQLQueryExecutor;
        this.f261f = multipleMemberAdder;
        this.f262g = fbErrorReporter;
        this.f263h = provider;
        this.f264i = listeningExecutorService;
    }

    public final void m308c(Bundle bundle) {
        super.c(bundle);
        Class cls = FB4AAddToGroupsFragment.class;
        m305a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.an = bundle2.getString("com.facebook.katana.profile.id");
        this.ao = bundle2.getString("profile_name");
    }

    public final View m306a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1622843706);
        View inflate = layoutInflater.inflate(2130903171, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 350875061, a);
        return inflate;
    }

    public final void m307a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f259d.a(new C00485(this));
        this.f259d.a();
        this.ap = (BetterListView) e(2131559373);
        FB4AAddToGroupsListAdapterProvider fB4AAddToGroupsListAdapterProvider = this.f258c;
        this.aq = new FB4AAddToGroupsListAdapter(this.ap, kO_(), ResourcesMethodAutoProvider.a(fB4AAddToGroupsListAdapterProvider), (SecureContextHelper) DefaultSecureContextHelper.a(fB4AAddToGroupsListAdapterProvider));
        this.aq.m322a(this.an, null, this.f257b, true);
        this.ap.setAdapter(this.aq);
        this.ap.setOnScrollListener(new C00474(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1805406147);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131237825);
            Builder a2 = TitleBarButtonSpec.a();
            a2.g = jW_().getString(2131237835);
            a2 = a2;
            a2.h = -2;
            hasTitleBar.a(a2.a());
            hasTitleBar.a(new C00463(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 91551011, a);
    }

    public final boolean O_() {
        if (this.as) {
            return false;
        }
        if (this.f257b != null) {
            int size = this.f257b.m295a().size();
            if (size <= 0) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.a(true);
            builder.a(b(2131237836));
            builder.b(jW_().getQuantityString(2131689699, size, new Object[]{this.ao}));
            builder.a(b(2131237837), new C00431(this));
            builder.b(b(2131237838), new C00442(this));
            builder.a().show();
            return true;
        }
        this.f262g.b(am, "onBackPressed is called before onFragmentCreate");
        return false;
    }

    public static void m303a(FB4AAddToGroupsFragment fB4AAddToGroupsFragment, Vector vector, Vector vector2, Set set) {
        if (!vector2.isEmpty()) {
            vector2.remove(vector2.size() - 1);
        }
        if (vector2.isEmpty()) {
            fB4AAddToGroupsFragment.ar = false;
            if (!fB4AAddToGroupsFragment.y) {
                return;
            }
            if (vector.isEmpty()) {
                fB4AAddToGroupsFragment.f256a.b(new ToastBuilder(2131237830));
                fB4AAddToGroupsFragment.as = true;
                fB4AAddToGroupsFragment.o().onBackPressed();
            } else if (vector.size() == set.size()) {
                fB4AAddToGroupsFragment.f256a.b(new ToastBuilder(2131237831));
            } else {
                fB4AAddToGroupsFragment.f256a.b(new ToastBuilder(2131237832));
            }
        }
    }
}
