package com.facebook.groups.events;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventRsvpMutation;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.groups.events.GroupEventsController.GroupEventsControllerListener;
import com.facebook.groups.events.view.DefaultGroupEventsViewFactory;
import com.facebook.groups.widget.groupeventrow.GroupEventRsvpViewListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: UPDATE_EXPLICIT_APPROVAL */
public abstract class GroupEventsBaseFragment extends FbFragment {
    @Inject
    GroupEventsPagedListLoaderProvider f21817a;
    public boolean al;
    private String am;
    public GroupEventsPagedListLoader an;
    public GroupEventsAdapter ao;
    private final GroupEventRsvpViewListener ap = new C31161(this);
    private final GroupEventsControllerListener aq = new C31172(this);
    @Inject
    GroupEventsAdapterProvider f21818b;
    @Inject
    GroupEventsController f21819c;
    @Inject
    Resources f21820d;
    @Inject
    GroupEventUpdateRsvpMenuHelper f21821e;
    @Inject
    DefaultGroupEventsViewFactory f21822f;
    public View f21823g;
    public BetterTextView f21824h;
    public GroupEventsFragmentViewFactory f21825i;

    /* compiled from: UPDATE_EXPLICIT_APPROVAL */
    class C31161 implements GroupEventRsvpViewListener {
        final /* synthetic */ GroupEventsBaseFragment f21813a;

        C31161(GroupEventsBaseFragment groupEventsBaseFragment) {
            this.f21813a = groupEventsBaseFragment;
        }

        public final void mo958a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
            m22906a(event, graphQLEventGuestStatus, true);
        }

        public final void mo960b(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
            m22906a(event, graphQLEventGuestStatus, false);
        }

        public final void mo959a(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus) {
            EventRsvpMutation a = EventRsvpMutation.a(event, graphQLEventWatchStatus);
            this.f21813a.an.m22942a(a, true);
            this.f21813a.f21819c.m22937a(a, graphQLEventWatchStatus);
        }

        public final void mo961b(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus) {
            EventRsvpMutation a = EventRsvpMutation.a(event, graphQLEventWatchStatus);
            this.f21813a.an.m22942a(a, false);
            this.f21813a.f21819c.m22937a(a, graphQLEventWatchStatus);
        }

        public final void mo957a() {
            AdapterDetour.a(this.f21813a.ao, 1485644091);
        }

        private void m22906a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus, boolean z) {
            EventRsvpMutation a = EventRsvpMutation.a(event, graphQLEventGuestStatus);
            this.f21813a.an.m22942a(a, z);
            this.f21813a.f21819c.m22936a(a, graphQLEventGuestStatus);
        }
    }

    /* compiled from: UPDATE_EXPLICIT_APPROVAL */
    class C31172 implements GroupEventsControllerListener {
        final /* synthetic */ GroupEventsBaseFragment f21814a;

        C31172(GroupEventsBaseFragment groupEventsBaseFragment) {
            this.f21814a = groupEventsBaseFragment;
        }

        public final void mo962a(EventRsvpMutation eventRsvpMutation) {
            this.f21814a.an.m22942a(eventRsvpMutation.c(), true);
        }
    }

    /* compiled from: UPDATE_EXPLICIT_APPROVAL */
    public class C31183 {
        public final /* synthetic */ GroupEventsBaseFragment f21815a;

        C31183(GroupEventsBaseFragment groupEventsBaseFragment) {
            this.f21815a = groupEventsBaseFragment;
        }

        public final void m22914a(ImmutableList<Event> immutableList, boolean z) {
            Object obj;
            GroupEventsAdapter groupEventsAdapter = this.f21815a.ao;
            if (immutableList != null) {
                groupEventsAdapter.f21807j = immutableList;
                if (z) {
                    AdapterDetour.a(groupEventsAdapter, 1033663184);
                }
            }
            if (this.f21815a.ao.f21807j.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                GroupEventsBaseFragment.m22924a(this.f21815a, true);
                return;
            }
            GroupEventsBaseFragment groupEventsBaseFragment = this.f21815a;
            if (groupEventsBaseFragment.f21823g != null) {
                groupEventsBaseFragment.f21823g.setVisibility(8);
            }
            groupEventsBaseFragment.e(groupEventsBaseFragment.f21825i.mo964b()).setVisibility(0);
        }

        public final void m22915a(boolean z) {
            GroupEventsAdapter groupEventsAdapter = this.f21815a.ao;
            if (z != groupEventsAdapter.f21808k) {
                groupEventsAdapter.f21808k = z;
                AdapterDetour.a(groupEventsAdapter, 2013201730);
            }
        }
    }

    /* compiled from: UPDATE_EXPLICIT_APPROVAL */
    class C31194 implements OnScrollListener {
        final /* synthetic */ GroupEventsBaseFragment f21816a;

        C31194(GroupEventsBaseFragment groupEventsBaseFragment) {
            this.f21816a = groupEventsBaseFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f21816a.al) {
                Object obj = null;
                if (!this.f21816a.ao.isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 3 > i3) {
                    obj = 1;
                }
                if (obj != null) {
                    GroupEventsBaseFragment.at(this.f21816a);
                }
            }
        }
    }

    /* compiled from: UPDATE_EXPLICIT_APPROVAL */
    public interface GroupEventsFragmentViewFactory {
        int mo963a();

        int mo964b();

        int mo965c();

        int mo966d();

        int mo967e();

        int mo968f();

        int mo969g();

        int mo970h();
    }

    public static void m22926a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupEventsBaseFragment) obj).m22925a((GroupEventsPagedListLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupEventsPagedListLoaderProvider.class), (GroupEventsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupEventsAdapterProvider.class), GroupEventsController.m22935b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), new GroupEventUpdateRsvpMenuHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)), DefaultGroupEventsViewFactory.m23043b(injectorLike));
    }

    protected abstract GroupEventsFragmentViewFactory mo971b();

    protected abstract TimeframeInputTimeframe mo972e();

    private void m22925a(GroupEventsPagedListLoaderProvider groupEventsPagedListLoaderProvider, GroupEventsAdapterProvider groupEventsAdapterProvider, GroupEventsController groupEventsController, Resources resources, GroupEventUpdateRsvpMenuHelper groupEventUpdateRsvpMenuHelper, DefaultGroupEventsViewFactory defaultGroupEventsViewFactory) {
        this.f21817a = groupEventsPagedListLoaderProvider;
        this.f21818b = groupEventsAdapterProvider;
        this.f21819c = groupEventsController;
        this.f21820d = resources;
        this.f21821e = groupEventUpdateRsvpMenuHelper;
        this.f21822f = defaultGroupEventsViewFactory;
    }

    public final void m22930c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupEventsBaseFragment.class;
        m22926a((Object) this, getContext());
        this.f21825i = mo971b();
        this.am = this.s.getString("group_feed_id");
        GroupEventsAdapterProvider groupEventsAdapterProvider = this.f21818b;
        TimeframeInputTimeframe e = mo972e();
        this.ao = new GroupEventsAdapter(e, (EventActionButtonStateSelectorProvider) groupEventsAdapterProvider.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), this.ap, (SecureContextHelper) DefaultSecureContextHelper.a(groupEventsAdapterProvider), IdBasedProvider.a(groupEventsAdapterProvider, 12), EventsDashboardTimeFormatUtil.a(groupEventsAdapterProvider), ResourcesMethodAutoProvider.a(groupEventsAdapterProvider), FbUriIntentHandler.a(groupEventsAdapterProvider));
        this.an = this.f21817a.m22944a(this.am, new C31183(this), mo972e());
    }

    public final View m22927a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 274092804);
        View inflate = layoutInflater.inflate(this.f21825i.mo963a(), viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -798352594, a);
        return inflate;
    }

    public final void m22932g(boolean z) {
        this.al = z;
    }

    public final void m22928a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f21819c.f21837f = this.aq;
        BetterListView betterListView = (BetterListView) e(this.f21825i.mo964b());
        betterListView.setAdapter(this.ao);
        betterListView.setStickyHeaderEnabled(true);
        betterListView.setOnScrollListener(new C31194(this));
        at(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1144577203);
        super.mY_();
        this.f21819c.m22938b(this.aq);
        GroupEventsPagedListLoader groupEventsPagedListLoader = this.an;
        groupEventsPagedListLoader.m22943c();
        groupEventsPagedListLoader.f21845e.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1640987983, a);
    }

    public static void m22924a(GroupEventsBaseFragment groupEventsBaseFragment, boolean z) {
        if (groupEventsBaseFragment.f21823g == null) {
            LayoutInflater.from(groupEventsBaseFragment.getContext()).inflate(groupEventsBaseFragment.f21825i.mo966d(), (ViewGroup) groupEventsBaseFragment.e(groupEventsBaseFragment.f21825i.mo965c()), true);
            groupEventsBaseFragment.f21823g = groupEventsBaseFragment.e(groupEventsBaseFragment.f21825i.mo967e());
            groupEventsBaseFragment.f21824h = (BetterTextView) groupEventsBaseFragment.e(groupEventsBaseFragment.f21825i.mo968f());
        }
        if (z) {
            groupEventsBaseFragment.f21824h.setText(groupEventsBaseFragment.f21825i.mo969g());
        } else {
            groupEventsBaseFragment.f21824h.setText(groupEventsBaseFragment.f21825i.mo970h());
        }
        groupEventsBaseFragment.f21823g.setVisibility(0);
        groupEventsBaseFragment.e(groupEventsBaseFragment.f21825i.mo964b()).setVisibility(8);
    }

    public static void at(GroupEventsBaseFragment groupEventsBaseFragment) {
        groupEventsBaseFragment.an.m22941a();
    }
}
