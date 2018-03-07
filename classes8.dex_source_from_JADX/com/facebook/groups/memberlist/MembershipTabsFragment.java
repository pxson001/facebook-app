package com.facebook.groups.memberlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.fb4a.memberpicker.FB4AGroupsAddMemberIntentProvider;
import com.facebook.groups.memberlist.annotation.GroupMembershipNavHandler;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEventBus;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEventSubscriber;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberListHeader.FetchGroupMemberListHeaderString;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberListHeaderModels.FetchGroupMemberListHeaderModel;
import com.facebook.groups.memberlist.view.DefaultGroupMembershipViewFactory;
import com.facebook.groups.memberlist.view.GroupMembershipViewFactory;
import com.facebook.groups.memberpicker.GroupsAddMemberIntentProvider;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: extra_media_container_type */
public class MembershipTabsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    Resources f14420a;
    @Inject
    Lazy<Toaster> al;
    public FetchGroupMemberListHeaderModel am;
    public GroupsNavigationSecondaryActionDelegate an;
    private GroupAdminMemberEventSubscriber ao;
    public MembershipPagerAdapter ap;
    private ViewPager aq;
    private TabbedViewPagerIndicator ar;
    public String as;
    @Inject
    SecureContextHelper f14421b;
    @Inject
    @LoggedInUserId
    String f14422c;
    @Inject
    GroupMemberUpdateEventBus f14423d;
    @Inject
    @GroupMembershipNavHandler
    GroupsNavigationHandler f14424e;
    @Inject
    DefaultGroupMembershipViewFactory f14425f;
    @Inject
    GroupsAddMemberIntentProvider f14426g;
    @Inject
    public TasksManager f14427h;
    @Inject
    GraphQLQueryExecutor f14428i;

    /* compiled from: extra_media_container_type */
    class C15731 implements GroupsNavigationSecondaryActionDelegate {
        final /* synthetic */ MembershipTabsFragment f14416a;

        C15731(MembershipTabsFragment membershipTabsFragment) {
            this.f14416a = membershipTabsFragment;
        }

        public final Drawable mo879a() {
            return this.f14416a.f14425f.f14555a.getDrawable(2130840032);
        }

        public final String mo880b() {
            return this.f14416a.f14420a.getString(2131237944);
        }

        public final void mo881c() {
            GroupsAddMemberIntentProvider groupsAddMemberIntentProvider = this.f14416a.f14426g;
            String str = this.f14416a.as;
            this.f14416a.s.getString("group_visibility");
            this.f14416a.s.getString("group_url");
            this.f14416a.f14421b.a(groupsAddMemberIntentProvider.mo883a(str, this.f14416a.getContext()), this.f14416a.getContext());
        }

        public final boolean mo882d() {
            return this.f14416a.s.getBoolean("is_viewer_joined");
        }
    }

    /* compiled from: extra_media_container_type */
    class C15742 extends GroupAdminMemberEventSubscriber {
        final /* synthetic */ MembershipTabsFragment f14417a;

        C15742(MembershipTabsFragment membershipTabsFragment) {
            this.f14417a = membershipTabsFragment;
        }

        public final void m15963b(FbEvent fbEvent) {
            GroupAdminMemberEvent groupAdminMemberEvent = (GroupAdminMemberEvent) fbEvent;
            if (groupAdminMemberEvent.f14430a.equals(this.f14417a.as) && groupAdminMemberEvent.f14431b.equals(this.f14417a.f14422c)) {
                MembershipPagerAdapter membershipPagerAdapter = this.f14417a.ap;
                membershipPagerAdapter.f14414b.putString("group_admin_type", groupAdminMemberEvent.f14432c.toString());
                Bundle bundle = this.f14417a.s;
                if (bundle != null) {
                    bundle.putString("group_admin_type", groupAdminMemberEvent.f14432c.toString());
                }
            }
        }
    }

    /* compiled from: extra_media_container_type */
    public class C15753 implements Callable<ListenableFuture> {
        final /* synthetic */ MembershipTabsFragment f14418a;

        public Object call() {
            GraphQlQueryString fetchGroupMemberListHeaderString = new FetchGroupMemberListHeaderString();
            fetchGroupMemberListHeaderString.a("group_id", this.f14418a.as);
            return this.f14418a.f14428i.a(GraphQLRequest.a(fetchGroupMemberListHeaderString).a(GraphQLCachePolicy.d));
        }

        public C15753(MembershipTabsFragment membershipTabsFragment) {
            this.f14418a = membershipTabsFragment;
        }
    }

    /* compiled from: extra_media_container_type */
    public class C15764 extends AbstractDisposableFutureCallback {
        final /* synthetic */ MembershipTabsFragment f14419a;

        public C15764(MembershipTabsFragment membershipTabsFragment) {
            this.f14419a = membershipTabsFragment;
        }

        protected final void m15964a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f14419a.am = (FetchGroupMemberListHeaderModel) graphQLResult.e;
            if (this.f14419a.am == null || this.f14419a.am.m16186m() == null) {
                MembershipTabsFragment.as(this.f14419a);
                return;
            }
            boolean z;
            this.f14419a.s.putString("group_visibility", this.f14419a.am.m16186m().toString());
            this.f14419a.s.putString("group_url", this.f14419a.am.m16183j());
            this.f14419a.s.putString("group_admin_type", this.f14419a.am.m16184k().toString());
            Bundle bundle = this.f14419a.s;
            String str = "is_viewer_joined";
            if (this.f14419a.am.m16185l() == GraphQLGroupJoinState.MEMBER) {
                z = true;
            } else {
                z = false;
            }
            bundle.putBoolean(str, z);
            this.f14419a.f14424e.mo895a(this.f14419a, this.f14419a.an);
            MembershipTabsFragment.m15968e(this.f14419a);
        }

        protected final void m15965a(Throwable th) {
            MembershipTabsFragment.as(this.f14419a);
        }
    }

    public static void m15967a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MembershipTabsFragment) obj).m15966a(ResourcesMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), GroupMemberUpdateEventBus.m15974a(fbInjector), DefaultGroupsNavigationHandler.m17162a(fbInjector), DefaultGroupMembershipViewFactory.m16393b(fbInjector), (GroupsAddMemberIntentProvider) FB4AGroupsAddMemberIntentProvider.b(fbInjector), TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), IdBasedLazy.a(fbInjector, 3588));
    }

    private void m15966a(Resources resources, SecureContextHelper secureContextHelper, String str, GroupMemberUpdateEventBus groupMemberUpdateEventBus, GroupsNavigationHandler groupsNavigationHandler, GroupMembershipViewFactory groupMembershipViewFactory, GroupsAddMemberIntentProvider groupsAddMemberIntentProvider, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<Toaster> lazy) {
        this.f14420a = resources;
        this.f14421b = secureContextHelper;
        this.f14422c = str;
        this.f14423d = groupMemberUpdateEventBus;
        this.f14424e = groupsNavigationHandler;
        this.f14425f = groupMembershipViewFactory;
        this.f14426g = groupsAddMemberIntentProvider;
        this.f14427h = tasksManager;
        this.f14428i = graphQLQueryExecutor;
        this.al = lazy;
    }

    public final void m15971c(Bundle bundle) {
        super.c(bundle);
        Class cls = MembershipTabsFragment.class;
        m15967a((Object) this, getContext());
        this.as = this.s.getString("group_feed_id");
    }

    public final View m15969a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -883091472);
        View inflate = layoutInflater.inflate(2130905206, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 816557236, a);
        return inflate;
    }

    public final void m15970a(View view, Bundle bundle) {
        Object obj;
        super.a(view, bundle);
        this.aq = (ViewPager) e(2131563793);
        this.ar = (TabbedViewPagerIndicator) e(2131563792);
        if (this.s.containsKey("group_admin_type") && this.s.containsKey("is_viewer_joined") && this.s.containsKey("group_visibility") && this.s.containsKey("group_url")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f14427h.a("fetch_memberlist_header", new C15753(this), new C15764(this));
        } else {
            m15968e(this);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 546237966);
        super.mY_();
        this.f14427h.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1211058763, a);
    }

    public final void m15972d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 544497947);
        super.d(bundle);
        this.an = new C15731(this);
        this.f14424e.mo896a(this, this.f14420a.getString(2131239495), this.an);
        this.ao = new C15742(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1349579060, a);
    }

    public static void m15968e(MembershipTabsFragment membershipTabsFragment) {
        membershipTabsFragment.ap = new MembershipPagerAdapter(membershipTabsFragment.s(), membershipTabsFragment.s, membershipTabsFragment.f14420a);
        membershipTabsFragment.aq.setAdapter(membershipTabsFragment.ap);
        membershipTabsFragment.ar.setViewPager(membershipTabsFragment.aq);
    }

    public static void as(MembershipTabsFragment membershipTabsFragment) {
        ((Toaster) membershipTabsFragment.al.get()).b(new ToastBuilder(membershipTabsFragment.f14420a.getString(2131237824)));
        membershipTabsFragment.o().onBackPressed();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 602893003);
        super.mi_();
        this.f14423d.a(this.ao);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2054701334, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1006363550);
        super.mj_();
        this.f14423d.b(this.ao);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1096163969, a);
    }

    public final String am_() {
        return "group_mall_membership_tabs";
    }
}
