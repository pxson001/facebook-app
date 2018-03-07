package com.facebook.groups.events;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.constants.GroupsConstants.GroupMallType;
import com.facebook.groups.draggable.AbstractGroupsDraggableViewPagerContainerFragment;
import com.facebook.groups.events.annotation.GroupEventsNavigationHandler;
import com.facebook.groups.events.protocol.FetchGroupNameInfo.FetchGroupNameInfoString;
import com.facebook.groups.events.protocol.FetchGroupNameInfoModels.FetchGroupNameInfoModel;
import com.facebook.groups.events.view.DefaultGroupEventsViewFactory;
import com.facebook.groups.events.view.GroupEventsViewFactory;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: UPCOMING */
public class GroupEventsTabFragment extends AbstractGroupsDraggableViewPagerContainerFragment implements AnalyticsFragment {
    public static final Class f21858i = GroupEventsTabFragment.class;
    @Inject
    Lazy<FbErrorReporter> f21859a;
    private GroupEventsPagerAdapter al;
    public FetchGroupNameInfoModel am;
    private ViewPager an;
    private TabbedViewPagerIndicator ao;
    public GroupsNavigationSecondaryActionDelegate ap;
    public String aq;
    private int ar;
    @Inject
    Resources f21860b;
    @Inject
    public SecureContextHelper f21861c;
    @Inject
    DefaultGroupEventsViewFactory f21862d;
    @Inject
    @GroupEventsNavigationHandler
    GroupsNavigationHandler f21863e;
    @Inject
    public TasksManager f21864f;
    @Inject
    GraphQLQueryExecutor f21865g;
    @Inject
    @LoggedInUserId
    public Lazy<String> f21866h;

    /* compiled from: UPCOMING */
    class C31261 implements GroupsNavigationSecondaryActionDelegate {
        final /* synthetic */ GroupEventsTabFragment f21855a;

        C31261(GroupEventsTabFragment groupEventsTabFragment) {
            this.f21855a = groupEventsTabFragment;
        }

        public final Drawable m22947a() {
            return this.f21855a.f21862d.f21882a.getDrawable(2130840032);
        }

        public final String m22948b() {
            return this.f21855a.f21860b.getString(2131237823);
        }

        public final void m22949c() {
            String str;
            GroupEventsTabFragment groupEventsTabFragment = this.f21855a;
            Context ao = groupEventsTabFragment.ao();
            String str2 = groupEventsTabFragment.am_().toString();
            Long valueOf = Long.valueOf(Long.parseLong((String) groupEventsTabFragment.f21866h.get()));
            ActionMechanism actionMechanism = ActionMechanism.GROUP_PERMALINK_ACTIONS;
            String str3 = groupEventsTabFragment.aq;
            String a = groupEventsTabFragment.am.m23034a();
            GraphQLGroupVisibility l = groupEventsTabFragment.am.m23039l();
            if (groupEventsTabFragment.am.m23037j() == null) {
                str = null;
            } else {
                str = groupEventsTabFragment.am.m23037j().m23026a();
            }
            groupEventsTabFragment.f21861c.a(EventCreationNikumanActivity.m16519a(ao, str2, valueOf, actionMechanism, str3, a, l, str), 215, groupEventsTabFragment.ao());
        }

        public final boolean m22950d() {
            if (this.f21855a.am == null || this.f21855a.am.m23038k() == GraphQLGroupPostStatus.CANNOT_POST) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: UPCOMING */
    public class C31272 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupEventsTabFragment f21856a;

        public Object call() {
            GraphQlQueryString fetchGroupNameInfoString = new FetchGroupNameInfoString();
            fetchGroupNameInfoString.a("group_id", this.f21856a.aq);
            GraphQLQueryExecutor graphQLQueryExecutor = this.f21856a.f21865g;
            GraphQLRequest a = GraphQLRequest.a(fetchGroupNameInfoString).a(GraphQLCachePolicy.d);
            a.b = true;
            return graphQLQueryExecutor.a(a);
        }

        public C31272(GroupEventsTabFragment groupEventsTabFragment) {
            this.f21856a = groupEventsTabFragment;
        }
    }

    /* compiled from: UPCOMING */
    public class C31283 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupNameInfoModel>> {
        final /* synthetic */ GroupEventsTabFragment f21857a;

        public C31283(GroupEventsTabFragment groupEventsTabFragment) {
            this.f21857a = groupEventsTabFragment;
        }

        protected final void m22951a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f21857a.am = (FetchGroupNameInfoModel) graphQLResult.e;
            this.f21857a.f21863e.a(this.f21857a, this.f21857a.ap);
        }

        protected final void m22952a(Throwable th) {
            ((AbstractFbErrorReporter) this.f21857a.f21859a.get()).a(GroupEventsTabFragment.f21858i.getName(), "Unable to fetch group name information for group :" + this.f21857a.aq);
        }
    }

    /* compiled from: UPCOMING */
    public enum Tasks {
        CREATE_GROUP_EVENT
    }

    public static void m22954a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupEventsTabFragment) obj).m22953a(IdBasedSingletonScopeProvider.b(fbInjector, 494), ResourcesMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), DefaultGroupEventsViewFactory.m23043b(fbInjector), (GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(fbInjector), TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), IdBasedLazy.a(fbInjector, 4442));
    }

    private void m22953a(Lazy<FbErrorReporter> lazy, Resources resources, SecureContextHelper secureContextHelper, GroupEventsViewFactory groupEventsViewFactory, GroupsNavigationHandler groupsNavigationHandler, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<String> lazy2) {
        this.f21859a = lazy;
        this.f21860b = resources;
        this.f21861c = secureContextHelper;
        this.f21862d = groupEventsViewFactory;
        this.f21863e = groupsNavigationHandler;
        this.f21864f = tasksManager;
        this.f21865g = graphQLQueryExecutor;
        this.f21866h = lazy2;
    }

    public final void m22958c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupEventsTabFragment.class;
        m22954a((Object) this, getContext());
        this.aq = this.s.getString("group_feed_id");
        this.ar = this.s.getInt("group_mall_type", GroupMallType.WITHOUT_TABS_LEGACY.ordinal());
    }

    public final View m22955a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1229267982);
        View inflate = layoutInflater.inflate(2130904656, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -45446238, a);
        return inflate;
    }

    public final void m22957a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = (ViewPager) e(2131562677);
        this.ao = (TabbedViewPagerIndicator) e(2131562676);
        this.ap = new C31261(this);
        this.f21863e.a(this, this.f21860b.getString(2131242091), this.ap);
        this.f21864f.a(Tasks.CREATE_GROUP_EVENT, new C31272(this), new C31283(this));
    }

    public final void m22959d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2013611114);
        super.d(bundle);
        this.al = new GroupEventsPagerAdapter(s(), this.aq, this.f21860b);
        this.an.setAdapter(this.al);
        this.ao.setViewPager(this.an);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1787700385, a);
    }

    public final String am_() {
        return "group_events";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 823106269);
        super.mY_();
        this.f21864f.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -891467893, a);
    }

    public final void m22956a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 215) {
            Fragment e = this.al.e(0);
            if (e != null && (e instanceof GroupUpcomingEventsFragment)) {
                GroupUpcomingEventsFragment groupUpcomingEventsFragment = (GroupUpcomingEventsFragment) e;
                if (groupUpcomingEventsFragment.an != null) {
                    groupUpcomingEventsFragment.an.m22943c();
                    groupUpcomingEventsFragment.an.m22941a();
                }
            }
        }
    }
}
