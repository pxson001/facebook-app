package com.facebook.events.eventsdiscovery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.widget.viewpager.CustomFragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.facebook.intent.action.ACTION_GET_NOTIFIED_PROFILE_LOADED */
public class EventsDiscoveryPagerAdapter extends CustomFragmentStatePagerAdapter {
    private List<FilterItemsModel> f17316a = new ArrayList();
    private String f17317b;
    public NearbyPlacesSearchDataModel f17318c;
    public int f17319d;
    @Nullable
    public String f17320e;
    public boolean f17321f;
    private ReactionAnalyticsParams f17322g;
    public ArrayList<String> f17323h;

    public EventsDiscoveryPagerAdapter(FragmentManager fragmentManager, String str, ReactionAnalyticsParams reactionAnalyticsParams) {
        super(fragmentManager);
        this.f17317b = str;
        this.f17322g = reactionAnalyticsParams;
    }

    public final Fragment m17603a(int i) {
        EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = new EventsDiscoveryReactionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("extra_events_discovery_suggestion_token", this.f17317b);
        if (!this.f17321f) {
            bundle.putString("extra_events_discovery_filter_time", ((FilterItemsModel) this.f17316a.get(i)).m17642j());
        }
        bundle.putParcelable("extra_events_discovery_filter_location", this.f17318c);
        bundle.putStringArrayList("extra_events_discovery_fragment_selected_category", this.f17323h);
        bundle.putInt("extra_events_discovery_filter_location_range", this.f17319d);
        bundle.putString("extra_fragment_tag", J_(i).toString());
        bundle.putParcelable("extra_reaction_analytics_params", this.f17322g);
        eventsDiscoveryReactionFragment.g(bundle);
        return eventsDiscoveryReactionFragment;
    }

    public final int m17606b() {
        return this.f17321f ? 1 : this.f17316a.size();
    }

    public final CharSequence J_(int i) {
        return this.f17321f ? this.f17320e : ((FilterItemsModel) this.f17316a.get(i)).m17641a();
    }

    public final int m17602a(Object obj) {
        return -2;
    }

    public final void m17605a(List<FilterItemsModel> list) {
        this.f17321f = false;
        this.f17316a = list;
        kR_();
    }

    public final void m17604a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, int i) {
        this.f17318c = nearbyPlacesSearchDataModel;
        this.f17319d = i;
        for (int i2 = 0; i2 < b(); i2++) {
            EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = (EventsDiscoveryReactionFragment) e(i2);
            if (eventsDiscoveryReactionFragment != null) {
                eventsDiscoveryReactionFragment.m17612a(nearbyPlacesSearchDataModel, i);
            }
        }
    }
}
