package com.facebook.events.eventsdiscovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ExpandableListView;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.eventsdiscovery.EventsDiscoveryExpandableFilterAdapter.CheckBoxTypes;
import com.facebook.events.eventsdiscovery.EventsDiscoveryExpandableFilterAdapter.EventsDiscoveryFilterChild;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFragment.C24315;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventDiscoveryCategoryListModel.EventCategoryListModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadAdapter.SearchRadius;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.text.BetterButton;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.messenger.intents.IntentHandlerActivity */
public class EventsDiscoveryFilterFragment extends FbDialogFragment {
    private BetterButton aA;
    @Inject
    @FragmentChromeActivity
    public Provider<ComponentName> am;
    @Inject
    public SecureContextHelper an;
    private final C24231 ao = new C24231(this);
    public EventsDiscoveryExpandableFilterAdapter ap;
    private List<EventCategoryListModel> aq = new ArrayList();
    public HashSet<String> ar;
    private NearbyPlacesLocationResult as;
    @Nullable
    public NearbyPlacesSearchDataModel at;
    public int au = EventsDiscoveryFragment.f17272a;
    private Context av;
    public C24315 aw;
    private ExpandableListView ax;
    private FbTextView ay;
    private BetterButton az;

    /* compiled from: com.facebook.messenger.intents.IntentHandlerActivity */
    public class C24231 {
        public final /* synthetic */ EventsDiscoveryFilterFragment f17258a;

        C24231(EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment) {
            this.f17258a = eventsDiscoveryFilterFragment;
        }
    }

    /* compiled from: com.facebook.messenger.intents.IntentHandlerActivity */
    class C24242 implements OnClickListener {
        final /* synthetic */ EventsDiscoveryFilterFragment f17259a;

        C24242(EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment) {
            this.f17259a = eventsDiscoveryFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -809423868);
            for (int i = 0; i < this.f17259a.ap.getGroupCount(); i++) {
                this.f17259a.ap.m17551a(i, null);
            }
            LogUtils.a(1866412664, a);
        }
    }

    /* compiled from: com.facebook.messenger.intents.IntentHandlerActivity */
    class C24253 implements OnClickListener {
        final /* synthetic */ EventsDiscoveryFilterFragment f17260a;

        C24253(EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment) {
            this.f17260a = eventsDiscoveryFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -443917459);
            this.f17260a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 295167659, a);
        }
    }

    /* compiled from: com.facebook.messenger.intents.IntentHandlerActivity */
    class C24264 implements OnClickListener {
        final /* synthetic */ EventsDiscoveryFilterFragment f17261a;

        C24264(EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment) {
            this.f17261a = eventsDiscoveryFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -881338832);
            this.f17261a.ar = this.f17261a.ap.f17249c;
            this.f17261a.at = this.f17261a.ap.f17251e;
            C24315 c24315 = this.f17261a.aw;
            HashSet hashSet = this.f17261a.ar;
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel = this.f17261a.at;
            int i = this.f17261a.au;
            c24315.f17269a.aL = hashSet;
            c24315.f17269a.aH = nearbyPlacesSearchDataModel;
            c24315.f17269a.aC = i;
            EventsDiscoveryPagerAdapter eventsDiscoveryPagerAdapter = c24315.f17269a.as;
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel2 = c24315.f17269a.aH;
            int value = SearchRadius.values()[c24315.f17269a.aC].getValue();
            List arrayList = new ArrayList(c24315.f17269a.aL);
            eventsDiscoveryPagerAdapter.f17318c = nearbyPlacesSearchDataModel2;
            eventsDiscoveryPagerAdapter.f17319d = value;
            eventsDiscoveryPagerAdapter.f17323h = arrayList;
            for (int i2 = 0; i2 < eventsDiscoveryPagerAdapter.b(); i2++) {
                EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = (EventsDiscoveryReactionFragment) eventsDiscoveryPagerAdapter.e(i2);
                if (eventsDiscoveryReactionFragment != null) {
                    eventsDiscoveryReactionFragment.m17613a(nearbyPlacesSearchDataModel2, value, arrayList);
                }
            }
            EventsDiscoveryFragment.at(c24315.f17269a);
            this.f17261a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -204272364, a);
        }
    }

    public static void m17553a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment = (EventsDiscoveryFilterFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 12);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        eventsDiscoveryFilterFragment.am = a;
        eventsDiscoveryFilterFragment.an = secureContextHelper;
    }

    public static EventsDiscoveryFilterFragment m17552a(List<EventCategoryListModel> list, HashSet<String> hashSet, NearbyPlacesLocationResult nearbyPlacesLocationResult, NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, int i, OnFilterValuesSelectedListener onFilterValuesSelectedListener) {
        EventsDiscoveryFilterFragment eventsDiscoveryFilterFragment = new EventsDiscoveryFilterFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "extra_events_discovery_fragment_category_filters", list);
        bundle.putStringArrayList("extra_events_discovery_fragment_selected_category", new ArrayList(hashSet));
        bundle.putParcelable("extra_events_discovery_fragment_location_filters", nearbyPlacesLocationResult);
        FlatBufferModelHelper.a(bundle, "extra_events_discovery_fragment_selected_location", nearbyPlacesSearchDataModel);
        bundle.putInt("extra_events_discovery_fragment_range_index", i);
        eventsDiscoveryFilterFragment.g(bundle);
        eventsDiscoveryFilterFragment.aw = onFilterValuesSelectedListener;
        return eventsDiscoveryFilterFragment;
    }

    public final void m17556a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -182009710);
        super.a(bundle);
        Class cls = EventsDiscoveryFilterFragment.class;
        m17553a(this, getContext());
        a(2, 2131626574);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.aq = ImmutableList.copyOf(FlatBufferModelHelper.b(bundle2, "extra_events_discovery_fragment_category_filters"));
            this.ar = new HashSet(bundle2.getStringArrayList("extra_events_discovery_fragment_selected_category"));
            this.as = (NearbyPlacesLocationResult) bundle2.getParcelable("extra_events_discovery_fragment_location_filters");
            this.at = (NearbyPlacesSearchDataModel) FlatBufferModelHelper.a(bundle2, "extra_events_discovery_fragment_selected_location");
            this.au = bundle2.getInt("extra_events_discovery_fragment_range_index");
        }
        this.av = new ContextThemeWrapper(getContext(), 2131624473);
        this.ap = new EventsDiscoveryExpandableFilterAdapter(this.av, this.aq, this.ar, this.as, this.at, this.ao);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 476470212, a);
    }

    public final View m17554a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -35521977);
        Window window = this.f.getWindow();
        window.setGravity(80);
        window.setLayout(-1, -2);
        View inflate = LayoutInflater.from(this.av).inflate(2130904145, viewGroup, true);
        this.ax = (ExpandableListView) FindViewUtil.b(inflate, 2131561532);
        this.ax.setAdapter(this.ap);
        EmptyListViewItem emptyListViewItem = new EmptyListViewItem(this.av);
        emptyListViewItem.setBackgroundColor(jW_().getColor(2131362101));
        emptyListViewItem.setLayoutParams(new LayoutParams(-1, jW_().getDimensionPixelSize(2131434212)));
        emptyListViewItem.setVisibility(0);
        this.ax.addFooterView(emptyListViewItem);
        this.ay = (FbTextView) FindViewUtil.b(inflate, 2131561531);
        this.ay.setOnClickListener(new C24242(this));
        this.az = (BetterButton) FindViewUtil.b(inflate, 2131560414);
        this.az.setOnClickListener(new C24253(this));
        this.aA = (BetterButton) FindViewUtil.b(inflate, 2131561534);
        this.aA.setOnClickListener(new C24264(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1632697827, a);
        return inflate;
    }

    public final void m17555a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 101) {
            this.at = (NearbyPlacesSearchDataModel) intent.getParcelableExtra("extra_location_data");
            this.au = intent.getIntExtra("extra_location_range", EventsDiscoveryFragment.f17272a);
            int intValue = ((Integer) this.ap.f17254h.get(Integer.valueOf(2131558815))).intValue();
            if (this.at != null) {
                if (this.at.b) {
                    this.at.e = EventsDiscoveryFragment.m17562a(jW_(), this.au);
                }
                this.ap.m17551a(intValue, new EventsDiscoveryFilterChild(this.at.d, this.at.e, true, CheckBoxTypes.SINGLE_SELECTION));
                this.ap.f17251e = this.at;
            }
        }
    }
}
