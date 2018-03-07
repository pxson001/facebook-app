package com.facebook.groups.editsettings.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.GroupEditSettingsIntentBuilder;
import com.facebook.groups.editsettings.adapter.GroupEditSettingsAdapter;
import com.facebook.groups.editsettings.adapter.GroupEditSettingsAdapterProvider;
import com.facebook.groups.editsettings.annotation.EditGroupSettingsNavigationHandler;
import com.facebook.groups.editsettings.protocol.FetchGroupSettings.FetchGroupSettingsString;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager;
import com.facebook.groups.editsettings.view.GroupEditSettingsViewManager;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: Unexpected Type */
public class GroupEditSettingsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    GroupEditSettingsAdapterProvider f21657a;
    public FetchGroupSettingsModel al;
    public GroupEditSettingsAdapter am;
    @Inject
    public GroupEditSettingsIntentBuilder f21658b;
    @Inject
    public SecureContextHelper f21659c;
    @Inject
    GraphQLQueryExecutor f21660d;
    @Inject
    TasksManager f21661e;
    @Inject
    Resources f21662f;
    @Inject
    @EditGroupSettingsNavigationHandler
    GroupsNavigationHandler f21663g;
    @Inject
    Lazy<GroupsCoverPhotoHandler> f21664h;
    @Inject
    DefaultEditSettingsViewManager f21665i;

    /* compiled from: Unexpected Type */
    public class C31001 {
        public final /* synthetic */ GroupEditSettingsFragment f21654a;

        C31001(GroupEditSettingsFragment groupEditSettingsFragment) {
            this.f21654a = groupEditSettingsFragment;
        }
    }

    /* compiled from: Unexpected Type */
    class C31012 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupEditSettingsFragment f21655a;

        public Object call() {
            GraphQlQueryString fetchGroupSettingsString = new FetchGroupSettingsString();
            fetchGroupSettingsString.a("group_id", this.f21655a.s.getString("group_feed_id")).a("purpose_pog_size", Integer.valueOf(this.f21655a.jW_().getDimensionPixelSize(2131434292))).a("purpose_default_cover_photo_size", Integer.valueOf(this.f21655a.jW_().getDimensionPixelSize(2131434292)));
            GraphQLQueryExecutor graphQLQueryExecutor = this.f21655a.f21660d;
            GraphQLRequest a = GraphQLRequest.a(fetchGroupSettingsString).a(GraphQLCachePolicy.d);
            a.b = true;
            return graphQLQueryExecutor.a(a);
        }

        C31012(GroupEditSettingsFragment groupEditSettingsFragment) {
            this.f21655a = groupEditSettingsFragment;
        }
    }

    /* compiled from: Unexpected Type */
    class C31023 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupSettingsModel>> {
        final /* synthetic */ GroupEditSettingsFragment f21656a;

        C31023(GroupEditSettingsFragment groupEditSettingsFragment) {
            this.f21656a = groupEditSettingsFragment;
        }

        protected final void m22618a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            GroupEditSettingsController groupEditSettingsController = this.f21656a.am.f21586a;
            FetchGroupSettingsModel fetchGroupSettingsModel = (FetchGroupSettingsModel) graphQLResult.e;
            if (fetchGroupSettingsModel != null) {
                Set a = Sets.a();
                a.add(fetchGroupSettingsModel.m22807r());
                groupEditSettingsController.f21527h.a(groupEditSettingsController.f21531l, fetchGroupSettingsModel.m22807r(), new GraphQLResult(fetchGroupSettingsModel, graphQLResult.freshness, graphQLResult.clientTimeMs, a));
            }
            GroupEditSettingsFragment groupEditSettingsFragment = this.f21656a;
            FetchGroupSettingsModel fetchGroupSettingsModel2 = (FetchGroupSettingsModel) graphQLResult.e;
            if (fetchGroupSettingsModel2 != null) {
                groupEditSettingsFragment.al = fetchGroupSettingsModel2;
                GroupEditSettingsAdapter groupEditSettingsAdapter = groupEditSettingsFragment.am;
                groupEditSettingsAdapter.f21586a.m22536a(fetchGroupSettingsModel2, groupEditSettingsAdapter.f21608w);
                GroupEditSettingsAdapter.m22576c(groupEditSettingsAdapter, fetchGroupSettingsModel2);
            }
        }

        protected final void m22619a(Throwable th) {
        }
    }

    public static void m22621a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupEditSettingsFragment) obj).m22620a((GroupEditSettingsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupEditSettingsAdapterProvider.class), GroupEditSettingsIntentBuilder.m22546b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 6876), DefaultEditSettingsViewManager.m22884b(injectorLike));
    }

    public final void m22627c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupEditSettingsFragment.class;
        m22621a((Object) this, getContext());
    }

    public final View m22624a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1962905028);
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21665i;
        View inflate = layoutInflater.inflate(2130903873, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1155719492, a);
        return inflate;
    }

    public final void m22626a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f21663g.a(this, this.f21662f.getString(2131242127), null);
        BetterListView betterListView = (BetterListView) view.findViewById(2131560941);
        this.am = this.f21657a.m22585a(new C31001(this));
        betterListView.setAdapter(this.am);
        m22622e();
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 463390682);
        super.mY_();
        this.f21661e.c();
        GroupEditSettingsAdapter groupEditSettingsAdapter = this.am;
        GroupEditSettingsController groupEditSettingsController = groupEditSettingsAdapter.f21586a;
        if (groupEditSettingsController.f21529j == groupEditSettingsAdapter.f21608w) {
            groupEditSettingsController.f21529j = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1086358777, a);
    }

    public final void m22623G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -599087326);
        super.G();
        m22622e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 296699932, a);
    }

    public final void m22625a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1964 && i2 == -1 && intent.getExtras() != null && intent.hasExtra(EditGalleryIpcBundle.a)) {
            ((GroupsCoverPhotoHandler) this.f21664h.get()).a(this.s.getString("group_feed_id"), ((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a)).b);
        }
    }

    public final String am_() {
        return "group_info_settings";
    }

    private void m22620a(GroupEditSettingsAdapterProvider groupEditSettingsAdapterProvider, GroupEditSettingsIntentBuilder groupEditSettingsIntentBuilder, SecureContextHelper secureContextHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Resources resources, GroupsNavigationHandler groupsNavigationHandler, Lazy<GroupsCoverPhotoHandler> lazy, GroupEditSettingsViewManager groupEditSettingsViewManager) {
        this.f21657a = groupEditSettingsAdapterProvider;
        this.f21658b = groupEditSettingsIntentBuilder;
        this.f21659c = secureContextHelper;
        this.f21660d = graphQLQueryExecutor;
        this.f21661e = tasksManager;
        this.f21662f = resources;
        this.f21663g = groupsNavigationHandler;
        this.f21664h = lazy;
        this.f21665i = groupEditSettingsViewManager;
    }

    private void m22622e() {
        if (!this.L) {
            this.f21661e.a("FETCH_GROUP_SETTINGS", new C31012(this), new C31023(this));
        }
    }
}
