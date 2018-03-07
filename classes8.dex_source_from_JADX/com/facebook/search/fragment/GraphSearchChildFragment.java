package com.facebook.search.fragment;

import android.support.v4.app.Fragment;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;

/* compiled from: TimeToLowResProfilePicUri */
public interface GraphSearchChildFragment {

    /* compiled from: TimeToLowResProfilePicUri */
    public interface OnResultClickListener {
        void mo1193a();

        void mo1194a(GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit);

        void mo1195a(GraphSearchQuery graphSearchQuery, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit);

        void mo1196a(KeywordTypeaheadUnit keywordTypeaheadUnit);

        void mo1197a(NearbyTypeaheadUnit nearbyTypeaheadUnit);

        void mo1198a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit);

        void mo1199a(SeeMoreResultPageUnit seeMoreResultPageUnit);

        void mo1200a(ShortcutTypeaheadUnit shortcutTypeaheadUnit);

        void mo1201a(TrendingTypeaheadUnit trendingTypeaheadUnit);

        boolean mo1202a(LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent);
    }

    void mo1190a(OnResultClickListener onResultClickListener);

    boolean mo1191a(boolean z);

    Fragment mo1192b();
}
