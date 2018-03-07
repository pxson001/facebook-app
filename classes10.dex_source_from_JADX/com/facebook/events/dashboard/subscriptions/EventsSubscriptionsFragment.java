package com.facebook.events.dashboard.subscriptions;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.subscriptions.EventsSubscriptionsPager.EventsSubscriptionsCallback;
import com.facebook.events.dashboard.suggestions.EventsSimpleListAdapter;
import com.facebook.events.dashboard.suggestions.EventsSimpleListAdapterProvider;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel.EventViewerSubscribedSourceProfilesModel.EventViewerSubscribedSourceProfilesNodesModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.APPINVITES_DIALOG */
public class EventsSubscriptionsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    FbTitleBarSupplier f17167a;
    public EventAnalyticsParams al;
    @Inject
    EventEventLogger f17168b;
    @Inject
    EventsSimpleListAdapterProvider f17169c;
    @Inject
    EventsSubscriptionsPager f17170d;
    @Inject
    EventGraphQLModelHelper f17171e;
    public BetterListView f17172f;
    public String f17173g;
    public boolean f17174h = true;
    public EventsSimpleListAdapter f17175i;

    /* compiled from: com.facebook.platform.action.request.APPINVITES_DIALOG */
    class C24031 implements OnScrollListener {
        final /* synthetic */ EventsSubscriptionsFragment f17163a;

        C24031(EventsSubscriptionsFragment eventsSubscriptionsFragment) {
            this.f17163a = eventsSubscriptionsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                EventsSubscriptionsFragment.m17500e(this.f17163a);
            }
        }
    }

    /* compiled from: com.facebook.platform.action.request.APPINVITES_DIALOG */
    class C24042 implements OnItemClickListener {
        final /* synthetic */ EventsSubscriptionsFragment f17164a;

        C24042(EventsSubscriptionsFragment eventsSubscriptionsFragment) {
            this.f17164a = eventsSubscriptionsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Event a = this.f17164a.f17175i.m17517a(i);
            if (a != null) {
                this.f17164a.f17168b.m18139b(a.a, this.f17164a.am_(), i, this.f17164a.al.b.e.getParamValue());
            }
        }
    }

    /* compiled from: com.facebook.platform.action.request.APPINVITES_DIALOG */
    class C24063 implements EventsSubscriptionsCallback {
        final /* synthetic */ EventsSubscriptionsFragment f17166a;

        /* compiled from: com.facebook.platform.action.request.APPINVITES_DIALOG */
        class C24051 implements Function<NodesModel, Event> {
            final /* synthetic */ C24063 f17165a;

            C24051(C24063 c24063) {
                this.f17165a = c24063;
            }

            @Nullable
            public Object apply(@Nullable Object obj) {
                EventCommonFragment eventCommonFragment = (NodesModel) obj;
                if (eventCommonFragment == null) {
                    return null;
                }
                EventGraphQLModelHelper eventGraphQLModelHelper = this.f17165a.f17166a.f17171e;
                Builder c = EventGraphQLModelHelper.m19281c(eventCommonFragment);
                if (!(eventCommonFragment.T() == null || eventCommonFragment.T().a() == null || eventCommonFragment.T().a().isEmpty())) {
                    EventViewerSubscribedSourceProfilesNodesModel eventViewerSubscribedSourceProfilesNodesModel = (EventViewerSubscribedSourceProfilesNodesModel) eventCommonFragment.T().a().get(0);
                    c.aj = eventViewerSubscribedSourceProfilesNodesModel.j();
                    c.ak = eventViewerSubscribedSourceProfilesNodesModel.k();
                }
                return c.b();
            }
        }

        C24063(EventsSubscriptionsFragment eventsSubscriptionsFragment) {
            this.f17166a = eventsSubscriptionsFragment;
        }

        public final void mo785a(@Nonnull List<NodesModel> list, int i, String str, boolean z) {
            if (this.f17166a.f17172f != null) {
                if (!list.isEmpty()) {
                    this.f17166a.f17168b.m18127a(this.f17166a.am_(), this.f17166a.al.b.e.getParamValue(), this.f17166a.al.b.f.getParamValue(), true);
                }
                this.f17166a.f17175i.m17518a(Lists.a(list, new C24051(this)));
                this.f17166a.f17173g = str;
                this.f17166a.f17174h = z;
                this.f17166a.f17175i.m17519a(this.f17166a.f17174h);
            }
        }
    }

    public static void m17499a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsSubscriptionsFragment) obj).m17498a((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), EventEventLogger.m18119b(injectorLike), (EventsSimpleListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsSimpleListAdapterProvider.class), EventsSubscriptionsPager.m17508b(injectorLike), EventGraphQLModelHelper.m19271a(injectorLike));
    }

    public final void m17503c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventsSubscriptionsFragment.class;
        m17499a(this, getContext());
        EventActionContext a = ((EventActionContext) this.s.getParcelable("extras_event_action_context")).a(ActionSource.MOBILE_SUBSCRIPTIONS_LIST);
        String string = this.s.getString("extra_ref_module");
        if (string == null) {
            string = "unknown".toString();
        }
        this.al = new EventAnalyticsParams(a, string, am_().toString(), null);
        this.f17175i = this.f17169c.m17520a(this.al);
        m17500e(this);
    }

    public final View m17502a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -802550939);
        this.f17172f = (BetterListView) layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625810)).inflate(2130904162, viewGroup, false);
        this.f17172f.setAdapter(this.f17175i);
        this.f17172f.setOnScrollListener(new C24031(this));
        this.f17172f.setOnItemClickListener(new C24042(this));
        BetterListView betterListView = this.f17172f;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2078752178, a);
        return betterListView;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1578879754);
        super.mi_();
        ((FbTitleBar) this.f17167a.get()).setTitle(getContext().getString(2131237188));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 173142873, a);
    }

    public final String am_() {
        return "event_subscriptions";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -108796894);
        this.f17170d.m17509a();
        this.f17172f = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1971616917, a);
    }

    public final void m17501I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1389336179);
        this.f17168b.m18126a(am_(), this.f17175i.m17516a(), this.al.b.e.getParamValue());
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 820660505, a);
    }

    public static void m17500e(EventsSubscriptionsFragment eventsSubscriptionsFragment) {
        int dimensionPixelSize = eventsSubscriptionsFragment.jW_().getDimensionPixelSize(2131431107);
        if (eventsSubscriptionsFragment.f17174h) {
            eventsSubscriptionsFragment.f17170d.m17510a(dimensionPixelSize, 10, eventsSubscriptionsFragment.f17173g, new C24063(eventsSubscriptionsFragment));
        }
    }

    private void m17498a(FbTitleBarSupplier fbTitleBarSupplier, EventEventLogger eventEventLogger, EventsSimpleListAdapterProvider eventsSimpleListAdapterProvider, EventsSubscriptionsPager eventsSubscriptionsPager, EventGraphQLModelHelper eventGraphQLModelHelper) {
        this.f17167a = fbTitleBarSupplier;
        this.f17168b = eventEventLogger;
        this.f17169c = eventsSimpleListAdapterProvider;
        this.f17170d = eventsSubscriptionsPager;
        this.f17171e = eventGraphQLModelHelper;
    }
}
