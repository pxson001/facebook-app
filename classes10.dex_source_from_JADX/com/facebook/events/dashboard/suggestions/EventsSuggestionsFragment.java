package com.facebook.events.dashboard.suggestions;

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
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager.EventsSuggestionsCallback;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.SuggestedEventCutModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED */
public class EventsSuggestionsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    FbTitleBarSupplier f17205a;
    public EventAnalyticsParams al;
    @Inject
    EventEventLogger f17206b;
    @Inject
    EventsSimpleListAdapterProvider f17207c;
    @Inject
    EventsSuggestionsPager f17208d;
    @Inject
    EventGraphQLModelHelper f17209e;
    @Inject
    PerformanceLogger f17210f;
    public BetterListView f17211g;
    public SuggestedEventCutModel f17212h;
    public EventsSimpleListAdapter f17213i;

    /* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED */
    class C24121 implements OnScrollListener {
        final /* synthetic */ EventsSuggestionsFragment f17201a;

        C24121(EventsSuggestionsFragment eventsSuggestionsFragment) {
            this.f17201a = eventsSuggestionsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                EventsSuggestionsFragment.m17528e(this.f17201a);
            }
        }
    }

    /* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED */
    class C24132 implements OnItemClickListener {
        final /* synthetic */ EventsSuggestionsFragment f17202a;

        C24132(EventsSuggestionsFragment eventsSuggestionsFragment) {
            this.f17202a = eventsSuggestionsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Event a = this.f17202a.f17213i.m17517a(i);
            if (a != null) {
                this.f17202a.f17206b.m18139b(a.a, this.f17202a.am_(), i, this.f17202a.al.b.e.getParamValue());
            }
        }
    }

    /* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED */
    class C24153 implements EventsSuggestionsCallback {
        final /* synthetic */ EventsSuggestionsFragment f17204a;

        /* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED */
        class C24141 implements Function<EventCommonFragment, Event> {
            final /* synthetic */ C24153 f17203a;

            C24141(C24153 c24153) {
                this.f17203a = c24153;
            }

            @Nullable
            public Object apply(@Nullable Object obj) {
                EventCommonFragment eventCommonFragment = (EventCommonFragment) obj;
                if (eventCommonFragment == null) {
                    return null;
                }
                EventGraphQLModelHelper eventGraphQLModelHelper = this.f17203a.f17204a.f17209e;
                Builder c = EventGraphQLModelHelper.m19281c(eventCommonFragment);
                if (eventCommonFragment.P() != null) {
                    Object a = eventCommonFragment.P().a();
                    if (!StringUtil.a(a)) {
                        c.ai = a;
                    }
                }
                return c.b();
            }
        }

        C24153(EventsSuggestionsFragment eventsSuggestionsFragment) {
            this.f17204a = eventsSuggestionsFragment;
        }

        public final void mo784a(SuggestedEventCutModel suggestedEventCutModel) {
            if (this.f17204a.f17211g != null) {
                if (this.f17204a.f17212h == null) {
                    this.f17204a.f17210f.c(393231, "EventsSuggestionsFragment");
                    this.f17204a.f17206b.m18127a(this.f17204a.am_(), this.f17204a.al.b.e.getParamValue(), this.f17204a.al.b.f.getParamValue(), true);
                }
                this.f17204a.f17212h = suggestedEventCutModel;
                this.f17204a.f17213i.m17518a(Lists.a(suggestedEventCutModel.c().a(), new C24141(this)));
                if (!suggestedEventCutModel.c().b().b()) {
                    this.f17204a.f17213i.m17519a(false);
                }
            }
        }

        public final void mo783a() {
            if (this.f17204a.f17212h == null) {
                this.f17204a.f17210f.f(393231, "EventsSuggestionsFragment");
                this.f17204a.f17206b.m18127a(this.f17204a.am_(), this.f17204a.al.b.e.getParamValue(), this.f17204a.al.b.f.getParamValue(), false);
            }
        }
    }

    public static void m17527a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsSuggestionsFragment) obj).m17526a((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), EventEventLogger.m18119b(injectorLike), (EventsSimpleListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsSimpleListAdapterProvider.class), EventsSuggestionsPager.m17540b(injectorLike), EventGraphQLModelHelper.m19271a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    public static Bundle m17525a(String str, String str2, EventActionContext eventActionContext, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("events_suggestions_cut_diplay_name", str2);
        bundle.putString("events_suggestions_cut_type", str);
        bundle.putParcelable("extras_event_action_context", eventActionContext);
        bundle.putString("extra_ref_module", str3);
        return bundle;
    }

    public final void m17531c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventsSuggestionsFragment.class;
        m17527a(this, getContext());
        EventActionContext a = ((EventActionContext) this.s.getParcelable("extras_event_action_context")).a(ActionSource.MOBILE_SUGGESTIONS_LIST);
        String string = this.s.getString("extra_ref_module");
        if (string == null) {
            string = "unknown".toString();
        }
        this.al = new EventAnalyticsParams(a, string, am_().toString(), null);
        this.f17213i = this.f17207c.m17520a(this.al);
        this.f17210f.d(393231, "EventsSuggestionsFragment");
        m17528e(this);
    }

    public final View m17530a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 808023211);
        this.f17211g = (BetterListView) layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625810)).inflate(2130904162, viewGroup, false);
        this.f17211g.setAdapter(this.f17213i);
        this.f17211g.setOnScrollListener(new C24121(this));
        this.f17211g.setOnItemClickListener(new C24132(this));
        BetterListView betterListView = this.f17211g;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 789109507, a);
        return betterListView;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -98108849);
        super.mi_();
        if (this.s == null || StringUtil.a(this.s.getString("events_suggestions_cut_diplay_name"))) {
            ((FbTitleBar) this.f17205a.get()).setTitle(getContext().getString(2131237155));
        } else {
            ((FbTitleBar) this.f17205a.get()).setTitle(this.s.getString("events_suggestions_cut_diplay_name"));
        }
        LogUtils.f(1246767460, a);
    }

    public final String am_() {
        return "event_suggestions";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1339200426);
        this.f17208d.m17541a();
        this.f17211g = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -972071346, a);
    }

    public final void m17529I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1657384926);
        this.f17206b.m18126a(am_(), this.f17213i.m17516a(), this.al.b.e.getParamValue());
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -998937874, a);
    }

    public static void m17528e(EventsSuggestionsFragment eventsSuggestionsFragment) {
        int dimensionPixelSize = eventsSuggestionsFragment.jW_().getDimensionPixelSize(2131431107);
        if (eventsSuggestionsFragment.f17212h == null || eventsSuggestionsFragment.f17212h.c().b().b()) {
            eventsSuggestionsFragment.f17208d.m17542a(dimensionPixelSize, 10, eventsSuggestionsFragment.aq(), eventsSuggestionsFragment.f17212h == null ? null : eventsSuggestionsFragment.f17212h.c().b().a(), new C24153(eventsSuggestionsFragment));
        }
    }

    private void m17526a(FbTitleBarSupplier fbTitleBarSupplier, EventEventLogger eventEventLogger, EventsSimpleListAdapterProvider eventsSimpleListAdapterProvider, EventsSuggestionsPager eventsSuggestionsPager, EventGraphQLModelHelper eventGraphQLModelHelper, PerformanceLogger performanceLogger) {
        this.f17205a = fbTitleBarSupplier;
        this.f17206b = eventEventLogger;
        this.f17207c = eventsSimpleListAdapterProvider;
        this.f17208d = eventsSuggestionsPager;
        this.f17209e = eventGraphQLModelHelper;
        this.f17210f = performanceLogger;
    }

    private String aq() {
        if (this.s != null && !StringUtil.a(this.s.getString("events_suggestions_cut_type"))) {
            return this.s.getString("events_suggestions_cut_type");
        }
        throw new IllegalArgumentException("Cannot load suggestions fragment without cut type.");
    }
}
