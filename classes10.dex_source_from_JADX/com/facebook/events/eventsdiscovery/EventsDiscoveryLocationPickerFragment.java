package com.facebook.events.eventsdiscovery;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.inject.FbInjector;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.LocationStatusUtil;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadAdapter;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadAdapter.ItemViewType;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadAdapter.SearchRadius;
import com.facebook.nearby.v2.typeahead.NearbyPlacesTypeaheadEditText;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesTypeaheadModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.katana.provider.AttributionIdProvider */
public class EventsDiscoveryLocationPickerFragment extends FbFragment {
    private static final CallerContext ao = CallerContext.a(EventsDiscoveryLocationPickerFragment.class);
    @Inject
    EventsDiscoveryLocationUtil f17289a;
    public Location al;
    public NearbyPlacesTypeaheadModel am;
    public String an;
    private final AbstractDisposableFutureCallback<ImmutableLocation> ap = new C24341(this);
    public final BaseTextWatcher aq = new C24352(this);
    private final OnItemClickListener ar = new C24363(this);
    private final C24374 as = new C24374(this);
    @Inject
    public EventEventLogger f17290b;
    @Inject
    public FbTitleBarSupplier f17291c;
    @Inject
    LocationStatusUtil f17292d;
    @Inject
    TasksManager f17293e;
    private BetterListView f17294f;
    public NearbyPlacesTypeaheadEditText f17295g;
    public NearbyPlacesLocationTypeaheadAdapter f17296h;
    public ProgressBar f17297i;

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    class C24341 extends AbstractDisposableFutureCallback<ImmutableLocation> {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17282a;

        C24341(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17282a = eventsDiscoveryLocationPickerFragment;
        }

        protected final void m17578a(Object obj) {
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            this.f17282a.al = immutableLocation.l();
        }

        protected final void m17579a(Throwable th) {
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    class C24352 extends BaseTextWatcher {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17283a;

        C24352(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17283a = eventsDiscoveryLocationPickerFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f17283a.f17295g.setTextColor(this.f17283a.jW_().getColor(2131361920));
            this.f17283a.am.f5217a.b = false;
            this.f17283a.am.f5217a.d = null;
            this.f17283a.am.f5217a.e = null;
            EventsDiscoveryLocationPickerFragment.m17585e(this.f17283a);
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    class C24363 implements OnItemClickListener {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17284a;

        C24363(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17284a = eventsDiscoveryLocationPickerFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ItemViewType itemViewType = ItemViewType.values()[this.f17284a.f17296h.getItemViewType(i)];
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel = this.f17284a.am.f5217a;
            if (itemViewType == ItemViewType.CURRENT_LOCATION_CELL) {
                nearbyPlacesSearchDataModel.b = true;
                if (this.f17284a.al != null) {
                    nearbyPlacesSearchDataModel.a(this.f17284a.al);
                    nearbyPlacesSearchDataModel.b = true;
                }
                nearbyPlacesSearchDataModel.d = null;
                nearbyPlacesSearchDataModel.e = null;
            } else if (itemViewType == ItemViewType.LOCATION_CELL) {
                NodeModel nodeModel = (NodeModel) this.f17284a.f17296h.getItem(i);
                nearbyPlacesSearchDataModel.d = nodeModel.j();
                nearbyPlacesSearchDataModel.e = nodeModel.l();
                nearbyPlacesSearchDataModel.f = nodeModel.k().a();
                nearbyPlacesSearchDataModel.g = nodeModel.k().j();
                nearbyPlacesSearchDataModel.b = false;
                EventEventLogger eventEventLogger = this.f17284a.f17290b;
                String j2 = nodeModel.j();
                String str = this.f17284a.an;
                HoneyClientEventFast a = eventEventLogger.f17787i.a("selected_location_filter_location", false);
                if (a.a()) {
                    a.a("event_discovery").a("page_id", j2).a("event_suggestion_token", str).b();
                }
            }
            EventsDiscoveryLocationPickerFragment.m17582a(this.f17284a, this.f17284a.am.f5217a, SearchRadius.SEARCH_RADIUS_5);
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    public class C24374 {
        public final /* synthetic */ EventsDiscoveryLocationPickerFragment f17285a;

        C24374(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17285a = eventsDiscoveryLocationPickerFragment;
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    public class C24385 implements OnActionButtonClickListener {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17286a;

        public C24385(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17286a = eventsDiscoveryLocationPickerFragment;
        }

        public final void m17580a(View view) {
            this.f17286a.f17295g.setText("");
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    public class C24396 implements OnBackPressedListener {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17287a;

        public C24396(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17287a = eventsDiscoveryLocationPickerFragment;
        }

        public final void m17581a() {
            EventsDiscoveryLocationPickerFragment.ar(this.f17287a);
            if (this.f17287a.o() != null) {
                this.f17287a.o().setResult(0);
                this.f17287a.o().finish();
            }
        }
    }

    /* compiled from: com.facebook.katana.provider.AttributionIdProvider */
    class C24407 implements FutureCallback<NearbyPlacesLocationResult> {
        final /* synthetic */ EventsDiscoveryLocationPickerFragment f17288a;

        C24407(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
            this.f17288a = eventsDiscoveryLocationPickerFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            NearbyPlacesLocationResult nearbyPlacesLocationResult = (NearbyPlacesLocationResult) obj;
            this.f17288a.f17297i.setVisibility(8);
            if (nearbyPlacesLocationResult != null) {
                this.f17288a.am.f5219c = nearbyPlacesLocationResult;
                AdapterDetour.a(this.f17288a.f17296h, 574244985);
            }
        }

        public void onFailure(Throwable th) {
            this.f17288a.f17297i.setVisibility(8);
            Toast.makeText(this.f17288a.getContext(), this.f17288a.jW_().getString(2131230759), 0).show();
        }
    }

    public static void m17584a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsDiscoveryLocationPickerFragment) obj).m17583a(EventsDiscoveryLocationUtil.m17593b(fbInjector), EventEventLogger.m18119b(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), LocationStatusUtil.a(fbInjector), TasksManager.b(fbInjector));
    }

    private void m17583a(EventsDiscoveryLocationUtil eventsDiscoveryLocationUtil, EventEventLogger eventEventLogger, FbTitleBarSupplier fbTitleBarSupplier, LocationStatusUtil locationStatusUtil, TasksManager tasksManager) {
        this.f17289a = eventsDiscoveryLocationUtil;
        this.f17290b = eventEventLogger;
        this.f17291c = fbTitleBarSupplier;
        this.f17292d = locationStatusUtil;
        this.f17293e = tasksManager;
    }

    public final void m17589c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventsDiscoveryLocationPickerFragment.class;
        m17584a((Object) this, getContext());
        this.an = this.s.getString("extra_events_discovery_suggestion_token");
        this.am = new NearbyPlacesTypeaheadModel(new NearbyPlacesSearchDataModel(this.f17292d.a(o())));
        this.f17296h = new NearbyPlacesLocationTypeaheadAdapter(getContext(), this.am, true);
        this.f17296h.f5166e = this.as;
        this.f17296h.f5164c = SearchRadius.values()[this.s.getInt("extra_location_range")];
    }

    public final View m17587a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1452501965);
        View inflate = layoutInflater.inflate(2130904149, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -741947582, a);
        return inflate;
    }

    public final void m17588a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f17294f = (BetterListView) e(2131561540);
        this.f17294f.setAdapter(this.f17296h);
        this.f17294f.setOnItemClickListener(this.ar);
        this.f17297i = (ProgressBar) e(2131561541);
        this.f17297i.setVisibility(0);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1247025160);
        super.mi_();
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) this.f17291c.get();
        View inflate = o().getLayoutInflater().inflate(2130904150, null, false);
        fb4aTitleBar.setCustomTitleView(inflate);
        fb4aTitleBar.setSearchButtonVisible(false);
        Builder a2 = TitleBarButtonSpec.a();
        a2.b = jW_().getDrawable(2130839815);
        fb4aTitleBar.setButtonSpecs(ImmutableList.of(a2.a()));
        this.f17295g = (NearbyPlacesTypeaheadEditText) inflate.findViewById(2131561542);
        this.f17295g.setInputTextListener(this.aq);
        fb4aTitleBar.setActionButtonOnClickListener(new C24385(this));
        fb4aTitleBar.setOnBackPressedListener(new C24396(this));
        this.f17289a.m17594a(ao(), this.ap, ao);
        m17585e(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 820705556, a);
    }

    public final void m17586I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 482968986);
        this.f17289a.f17307f.m4646a();
        this.f17293e.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1260965664, a);
    }

    public static void m17585e(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
        String str;
        eventsDiscoveryLocationPickerFragment.am.m4676b();
        AdapterDetour.a(eventsDiscoveryLocationPickerFragment.f17296h, 113635489);
        if (eventsDiscoveryLocationPickerFragment.am.f5217a.b) {
            str = "";
        } else {
            str = eventsDiscoveryLocationPickerFragment.f17295g.getText().toString().trim();
        }
        eventsDiscoveryLocationPickerFragment.f17289a.m17595a(str, new C24407(eventsDiscoveryLocationPickerFragment));
    }

    public static void m17582a(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment, NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, SearchRadius searchRadius) {
        Intent intent = new Intent();
        intent.putExtra("extra_location_data", nearbyPlacesSearchDataModel);
        intent.putExtra("extra_location_range", searchRadius.ordinal());
        ar(eventsDiscoveryLocationPickerFragment);
        if (eventsDiscoveryLocationPickerFragment.o() != null) {
            eventsDiscoveryLocationPickerFragment.o().setResult(-1, intent);
            eventsDiscoveryLocationPickerFragment.o().finish();
        }
    }

    public static void ar(EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment) {
        ((InputMethodManager) eventsDiscoveryLocationPickerFragment.ao().getSystemService("input_method")).hideSoftInputFromWindow(eventsDiscoveryLocationPickerFragment.f17295g.getWindowToken(), 0);
    }
}
