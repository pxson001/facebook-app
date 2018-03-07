package com.facebook.events.eventsdiscovery;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventDiscoveryCategoryListModel.EventCategoryListModel;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Builder;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.ui.date.EventsCalendarDatePickerActivity;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadAdapter.SearchRadius;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
public class EventsDiscoveryFragment extends FbFragment {
    public static final int f17272a = SearchRadius.SEARCH_RADIUS_5.ordinal();
    private static final Class<?> am = EventsDiscoveryFragment.class;
    public FbTextView aA;
    public String aB;
    public int aC = f17272a;
    public int aD = -1;
    public int aE = this.aD;
    public List<FilterItemsModel> aF = new ArrayList();
    private boolean aG;
    @Nullable
    public NearbyPlacesSearchDataModel aH;
    private ReactionAnalyticsParams aI;
    public List<EventCategoryListModel> aJ;
    public HashMap<String, String> aK = new HashMap();
    public HashSet<String> aL;
    @Nullable
    NearbyPlacesLocationResult al;
    private final C24271 an = new C24271(this);
    private final C24282 ao = new C24282(this);
    private final FutureCallback<NearbyPlacesLocationResult> ap = new C24293(this);
    private final OnTabClickListener aq = new C24304(this);
    private final C24315 ar = new C24315(this);
    public EventsDiscoveryPagerAdapter as;
    private ViewPager at;
    private TabbedViewPagerIndicator au;
    public String av;
    public String aw;
    @Nullable
    private String ax;
    public Fb4aTitleBar ay;
    public FbTextView az;
    @Inject
    public Provider<TimeFormatUtil> f17273b;
    @Inject
    @FragmentChromeActivity
    Provider<ComponentName> f17274c;
    @Inject
    EventsDiscoveryPager f17275d;
    @Inject
    EventEventLogger f17276e;
    @Inject
    public FbTitleBarSupplier f17277f;
    @Inject
    SecureContextHelper f17278g;
    @Inject
    public GatekeeperStoreImpl f17279h;
    @Inject
    EventsDiscoveryLocationUtil f17280i;

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    public class C24271 {
        final /* synthetic */ EventsDiscoveryFragment f17265a;

        C24271(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17265a = eventsDiscoveryFragment;
        }

        public final void m17557a(List<EventDiscoverSuggestionFiltersModel> list) {
            for (EventDiscoverSuggestionFiltersModel eventDiscoverSuggestionFiltersModel : list) {
                if ("time".equals(eventDiscoverSuggestionFiltersModel.m17647j())) {
                    this.f17265a.aF.addAll(eventDiscoverSuggestionFiltersModel.m17646a());
                    Builder builder = new Builder();
                    builder.f17331a = this.f17265a.getContext().getResources().getString(2131241892);
                    this.f17265a.aF.add(builder.m17636a());
                    EventsDiscoveryFragment.m17564a(this.f17265a, false);
                }
            }
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    public class C24282 {
        final /* synthetic */ EventsDiscoveryFragment f17266a;

        C24282(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17266a = eventsDiscoveryFragment;
        }

        public final void m17558a(List<EventCategoryListModel> list) {
            this.f17266a.aJ = list;
            for (EventCategoryListModel eventCategoryListModel : list) {
                this.f17266a.aK.put(eventCategoryListModel.m17628a(), eventCategoryListModel.m17629j());
            }
            if (!this.f17266a.aL.isEmpty()) {
                EventsDiscoveryFragment.at(this.f17266a);
            }
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    class C24293 implements FutureCallback<NearbyPlacesLocationResult> {
        final /* synthetic */ EventsDiscoveryFragment f17267a;

        C24293(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17267a = eventsDiscoveryFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            NearbyPlacesLocationResult nearbyPlacesLocationResult = (NearbyPlacesLocationResult) obj;
            if (nearbyPlacesLocationResult != null) {
                this.f17267a.al = nearbyPlacesLocationResult;
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    class C24304 implements OnTabClickListener {
        final /* synthetic */ EventsDiscoveryFragment f17268a;

        C24304(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17268a = eventsDiscoveryFragment;
        }

        public final void m17559a(int i, int i2) {
            if (i == this.f17268a.aF.size() - 1 && i2 == i) {
                EventsDiscoveryFragment.aq(this.f17268a);
            }
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    public class C24315 {
        public final /* synthetic */ EventsDiscoveryFragment f17269a;

        C24315(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17269a = eventsDiscoveryFragment;
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    class C24326 extends SimpleOnPageChangeListener {
        final /* synthetic */ EventsDiscoveryFragment f17270a;

        C24326(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17270a = eventsDiscoveryFragment;
        }

        public final void m17560a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            if (i == this.f17270a.aF.size() - 1) {
                EventsDiscoveryFragment.aq(this.f17270a);
            } else {
                EventEventLogger eventEventLogger = this.f17270a.f17276e;
                String j = ((FilterItemsModel) this.f17270a.aF.get(i)).m17642j();
                String str = this.f17270a.aB;
                HoneyClientEventFast a = eventEventLogger.f17787i.a("selected_time_filter", false);
                if (a.a()) {
                    a.a("event_discovery").a("time_token", j).a("event_suggestion_token", str).b();
                }
                EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = (EventsDiscoveryReactionFragment) this.f17270a.as.e(this.f17270a.aD);
                if (eventsDiscoveryReactionFragment != null) {
                    eventsDiscoveryReactionFragment.aX();
                }
            }
            this.f17270a.aE = this.f17270a.aD;
            this.f17270a.aD = i;
        }
    }

    /* compiled from: com.facebook.messaging.mutators.ThreadNotificationsDialogActivity */
    public class C24337 implements OnActionButtonClickListener {
        final /* synthetic */ EventsDiscoveryFragment f17271a;

        public C24337(EventsDiscoveryFragment eventsDiscoveryFragment) {
            this.f17271a = eventsDiscoveryFragment;
        }

        public final void m17561a(View view) {
            EventsDiscoveryFragment.as(this.f17271a);
        }
    }

    private static <T extends InjectableComponentWithContext> void m17565a(Class<T> cls, T t) {
        m17566a((Object) t, t.getContext());
    }

    private static void m17566a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsDiscoveryFragment) obj).m17568a(IdBasedSingletonScopeProvider.a(fbInjector, 610), IdBasedProvider.a(fbInjector, 12), new EventsDiscoveryPager(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector)), EventEventLogger.m18119b(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), EventsDiscoveryLocationUtil.m17593b(fbInjector));
    }

    private void m17568a(Provider<TimeFormatUtil> provider, Provider<ComponentName> provider2, EventsDiscoveryPager eventsDiscoveryPager, EventEventLogger eventEventLogger, FbTitleBarSupplier fbTitleBarSupplier, SecureContextHelper secureContextHelper, GatekeeperStore gatekeeperStore, EventsDiscoveryLocationUtil eventsDiscoveryLocationUtil) {
        this.f17273b = provider;
        this.f17274c = provider2;
        this.f17275d = eventsDiscoveryPager;
        this.f17276e = eventEventLogger;
        this.f17277f = fbTitleBarSupplier;
        this.f17278g = secureContextHelper;
        this.f17279h = gatekeeperStore;
        this.f17280i = eventsDiscoveryLocationUtil;
    }

    public final void m17575c(Bundle bundle) {
        super.c(bundle);
        m17565a(EventsDiscoveryFragment.class, (InjectableComponentWithContext) this);
        this.aB = mt_().getString("extra_events_discovery_suggestion_token");
        this.av = mt_().getString("extra_events_discovery_title");
        this.ax = mt_().getString("extra_events_discovery_single_tab_title");
        String string = mt_().getString("extra_events_discovery_subtitle");
        if (StringUtil.a(string)) {
            string = jW_().getString(2131241890);
        }
        this.aw = string;
        this.aI = (ReactionAnalyticsParams) mt_().getParcelable("extra_reaction_analytics_params");
        this.as = new EventsDiscoveryPagerAdapter(s(), this.aB, this.aI);
        if (bundle != null) {
            this.aG = true;
            this.aD = bundle.getInt("extra_events_discovery_fragment_current_tab_position");
            this.aE = bundle.getInt("extra_events_discovery_fragment_previous_tab_position");
            this.aw = bundle.getString("extra_events_discovery_fragment_subtitle");
            this.aC = bundle.getInt("extra_events_discovery_fragment_range_index");
            this.aH = (NearbyPlacesSearchDataModel) bundle.getParcelable("extra_events_discovery_fragment_location_data");
            this.aJ = FlatBufferModelHelper.b(bundle, "extra_events_discovery_fragment_category_filters");
            this.aL = new HashSet(bundle.getStringArrayList("extra_events_discovery_fragment_selected_category"));
            this.al = (NearbyPlacesLocationResult) bundle.getParcelable("extra_events_discovery_fragment_location_filters");
            return;
        }
        this.f17275d.m17601a(this.ao);
        this.f17280i.m17595a("", this.ap);
        this.aL = new HashSet();
        try {
            this.aL = m17563a(this.aB);
        } catch (Throwable e) {
            BLog.b(am, "error parse categories", e);
        }
    }

    public final View m17572a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1621417181);
        View inflate = layoutInflater.inflate(2130904148, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1151052030, a);
        return inflate;
    }

    public final void m17574a(View view, Bundle bundle) {
        int i;
        super.a(view, bundle);
        this.at = (ViewPager) e(2131561539);
        this.at.setAdapter(this.as);
        this.au = (TabbedViewPagerIndicator) e(2131561538);
        this.ay = (Fb4aTitleBar) this.f17277f.get();
        View inflate = o().getLayoutInflater().inflate(2130904151, null, false);
        this.ay.setCustomTitleView(inflate);
        this.aA = (FbTextView) inflate.findViewById(2131561543);
        this.aA.setText(this.av);
        this.az = (FbTextView) inflate.findViewById(2131561544);
        this.az.setText(this.aw);
        this.ay.setSearchButtonVisible(false);
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        Resources jW_ = jW_();
        if (this.f17279h.a(645, false)) {
            i = 2130840103;
        } else {
            i = 2130839970;
        }
        a.b = jW_.getDrawable(i);
        this.ay.setButtonSpecs(ImmutableList.of(a.a()));
        this.ay.setActionButtonOnClickListener(new C24337(this));
        if (!StringUtil.a(this.ax)) {
            EventsDiscoveryPagerAdapter eventsDiscoveryPagerAdapter = this.as;
            String str = this.ax;
            eventsDiscoveryPagerAdapter.f17321f = true;
            eventsDiscoveryPagerAdapter.f17320e = str;
            eventsDiscoveryPagerAdapter.kR_();
            this.au.setViewPager(this.at);
        } else if (bundle != null) {
            this.aF = FlatBufferModelHelper.b(bundle, "extra_events_discovery_fragment_time_filters");
            m17564a(this, true);
        } else {
            this.f17275d.m17600a(this.an);
        }
        this.au.l = new C24326(this);
        this.au.m = this.aq;
        this.f17276e.m18144c(this.aI.c, this.aI.d, this.aB);
    }

    public final void m17573a(int i, int i2, Intent intent) {
        if (this.f17279h.a(645, false) || i != 101) {
            if (i2 == -1 && i == 102) {
                String stringBuilder;
                Calendar calendar = (Calendar) intent.getSerializableExtra("extra_start_time");
                Calendar calendar2 = (Calendar) intent.getSerializableExtra("extra_end_time");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(((TimeFormatUtil) this.f17273b.get()).a(TimeFormatStyle.SHORT_DATE_STYLE, calendar.getTimeInMillis()));
                if (calendar2 == null) {
                    stringBuilder = stringBuilder2.toString();
                } else {
                    stringBuilder2.append(" - ");
                    stringBuilder2.append(((TimeFormatUtil) this.f17273b.get()).a(TimeFormatStyle.SHORT_DATE_STYLE, calendar2.getTimeInMillis()));
                    stringBuilder = stringBuilder2.toString();
                }
                String str = stringBuilder;
                String b = m17569b(calendar, calendar2);
                Builder builder = new Builder();
                builder.f17331a = str;
                builder = builder;
                builder.f17332b = b;
                this.aF.set(this.aF.size() - 1, builder.m17636a());
                this.as.m17605a(this.aF);
                this.au.b();
            } else if (i2 == 0 && i == 102) {
                au();
            }
        } else if (i2 != -1 && this.aG) {
            this.as.m17604a(this.aH, SearchRadius.values()[this.aC].getValue());
        } else if (i2 == -1) {
            this.aH = (NearbyPlacesSearchDataModel) intent.getParcelableExtra("extra_location_data");
            this.aC = intent.getIntExtra("extra_location_range", f17272a);
            at(this);
            this.as.m17604a(this.aH, SearchRadius.values()[this.aC].getValue());
        }
    }

    public final void m17576e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("extra_events_discovery_fragment_current_tab_position", this.aD);
        bundle.putInt("extra_events_discovery_fragment_previous_tab_position", this.aE);
        bundle.putString("extra_events_discovery_fragment_subtitle", this.aw);
        bundle.putInt("extra_events_discovery_fragment_range_index", this.aC);
        bundle.putParcelable("extra_events_discovery_fragment_location_data", this.aH);
        FlatBufferModelHelper.a(bundle, "extra_events_discovery_fragment_time_filters", this.aF);
        FlatBufferModelHelper.a(bundle, "extra_events_discovery_fragment_category_filters", this.aJ);
        bundle.putStringArrayList("extra_events_discovery_fragment_selected_category", new ArrayList(this.aL));
        bundle.putParcelable("extra_events_discovery_fragment_location_filters", this.al);
    }

    public final void m17571I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1900332014);
        EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = (EventsDiscoveryReactionFragment) this.as.e(this.aD);
        if (eventsDiscoveryReactionFragment != null) {
            eventsDiscoveryReactionFragment.aX();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -387152078, a);
    }

    private void m17570e() {
        Intent component = new Intent().setComponent((ComponentName) this.f17274c.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_DISCOVERY_LOCATION_PICKER_FRAGMENT.ordinal());
        component.putExtra("extra_location_range", this.aC);
        component.putExtra("extra_events_discovery_suggestion_token", this.aB);
        this.f17278g.a(component, 101, (Activity) ContextUtils.a(getContext(), Activity.class));
        EventsDiscoveryPagerAdapter eventsDiscoveryPagerAdapter = this.as;
        for (int i = 0; i < eventsDiscoveryPagerAdapter.b(); i++) {
            EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = (EventsDiscoveryReactionFragment) eventsDiscoveryPagerAdapter.e(i);
            if (eventsDiscoveryReactionFragment != null) {
                eventsDiscoveryReactionFragment.az = true;
            }
        }
    }

    public static void aq(EventsDiscoveryFragment eventsDiscoveryFragment) {
        Calendar instance = Calendar.getInstance();
        instance.set(12, 0);
        instance.add(11, 1);
        Intent a = EventsCalendarDatePickerActivity.m19545a(eventsDiscoveryFragment.ao(), instance, null, false);
        a.putExtra("extra_calendar_picker_title", eventsDiscoveryFragment.getContext().getResources().getString(2131241892));
        a.putExtra("extra_enable_time_picker", false);
        eventsDiscoveryFragment.f17278g.a(a, 102, (Activity) ContextUtils.a(eventsDiscoveryFragment.getContext(), Activity.class));
    }

    private void m17567a(String str, List<FilterItemsModel> list, boolean z) {
        if (!z) {
            String str2 = (String) new JSONObject(str).get("time");
            if (!StringUtil.a(str2)) {
                int i = 0;
                while (i < list.size()) {
                    FilterItemsModel filterItemsModel = (FilterItemsModel) list.get(i);
                    if (filterItemsModel == null || StringUtil.a(filterItemsModel.m17642j()) || !filterItemsModel.m17642j().equals(str2)) {
                        i++;
                    } else {
                        this.aD = i;
                        return;
                    }
                }
            }
        }
    }

    private static HashSet<String> m17563a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashSet<String> hashSet = new HashSet();
        if (jSONObject.has("event_categories")) {
            JSONArray jSONArray = (JSONArray) jSONObject.get("event_categories");
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
        }
        return hashSet;
    }

    private static String m17569b(Calendar calendar, @Nullable Calendar calendar2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        String format = simpleDateFormat.format(calendar.getTime());
        if (calendar2 == null) {
            return format;
        }
        String format2 = simpleDateFormat.format(calendar2.getTime());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", format);
            jSONObject.put("end", format2);
        } catch (Throwable e) {
            BLog.b(am, "Error build time range", e);
        }
        return jSONObject.toString();
    }

    public static void m17564a(EventsDiscoveryFragment eventsDiscoveryFragment, boolean z) {
        eventsDiscoveryFragment.as.m17605a(eventsDiscoveryFragment.aF);
        eventsDiscoveryFragment.au.setViewPager(eventsDiscoveryFragment.at);
        try {
            eventsDiscoveryFragment.m17567a(eventsDiscoveryFragment.aB, eventsDiscoveryFragment.aF, z);
        } catch (Throwable e) {
            BLog.b(am, "Error parse suggestionToken", e);
        }
        eventsDiscoveryFragment.at.a(eventsDiscoveryFragment.aD, false);
    }

    public static void as(EventsDiscoveryFragment eventsDiscoveryFragment) {
        if (eventsDiscoveryFragment.f17279h.a(645, false)) {
            EventsDiscoveryFilterFragment.m17552a(eventsDiscoveryFragment.aJ, eventsDiscoveryFragment.aL, eventsDiscoveryFragment.al, eventsDiscoveryFragment.aH, eventsDiscoveryFragment.aC, eventsDiscoveryFragment.ar).a(eventsDiscoveryFragment.kO_(), "filter_fragment_tag");
            return;
        }
        EventEventLogger eventEventLogger = eventsDiscoveryFragment.f17276e;
        String str = "event_discovery";
        String str2 = "discover_list";
        String str3 = "surface";
        String str4 = eventsDiscoveryFragment.aB;
        HoneyClientEventFast a = eventEventLogger.f17787i.a("tapped_location_filter", true);
        if (a.a()) {
            a.a(str).a("action_source", str2).a("action_mechanism", str3).a("event_suggestion_token", str4).b();
        }
        eventsDiscoveryFragment.m17570e();
    }

    public static void at(EventsDiscoveryFragment eventsDiscoveryFragment) {
        CharSequence a;
        Object obj;
        if (eventsDiscoveryFragment.aH == null) {
            obj = eventsDiscoveryFragment.aw;
        } else if (eventsDiscoveryFragment.aH.b) {
            a = m17562a(eventsDiscoveryFragment.jW_(), eventsDiscoveryFragment.aC);
        } else if (!StringUtil.a(eventsDiscoveryFragment.aH.e)) {
            obj = eventsDiscoveryFragment.aH.e;
        } else {
            return;
        }
        if (eventsDiscoveryFragment.aL.size() == 1) {
            eventsDiscoveryFragment.aA.setText((String) eventsDiscoveryFragment.aK.get((String) Iterables.d(eventsDiscoveryFragment.aL)));
        } else {
            eventsDiscoveryFragment.aA.setText(eventsDiscoveryFragment.jW_().getString(2131241900));
        }
        Object a2 = EventsDiscoveryExpandableFilterAdapter.m17546a(eventsDiscoveryFragment.getContext(), eventsDiscoveryFragment.aL);
        if (!StringUtil.a(a2)) {
            a = a + " • " + a2;
        }
        eventsDiscoveryFragment.az.setText(a);
    }

    public static String m17562a(Resources resources, int i) {
        return resources.getString(2131241890) + " • " + resources.getQuantityString(2131689805, SearchRadius.values()[i].getValue(), new Object[]{Integer.valueOf(SearchRadius.values()[i].getValue())});
    }

    private void au() {
        this.at.a(this.aE, false);
        this.au.b();
    }
}
