package com.facebook.places.checkin.composerflows;

import com.facebook.checkin.abtest.CheckinAbTestGatekeepers;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.places.common.PlacesPrefKeys;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: see_page_likes_tap */
public class PlaceToPeopleController {
    private final PrefKey f3531a = ((PrefKey) PlacesPrefKeys.a.a("place_to_people_time_of_last_skip"));
    private final PrefKey f3532b = ((PrefKey) PlacesPrefKeys.a.a("place_to_people_consecutive_num_times_skipped"));
    public PlacesFlowsStore f3533c;
    public CheckinAbTestGatekeepers f3534d;
    private PerfTestConfig f3535e;

    public static PlaceToPeopleController m3461b(InjectorLike injectorLike) {
        return new PlaceToPeopleController(PlacesFlowsStore.m3462b(injectorLike), CheckinAbTestGatekeepers.b(injectorLike), PerfTestConfig.a(injectorLike));
    }

    @Inject
    public PlaceToPeopleController(PlacesFlowsStore placesFlowsStore, CheckinAbTestGatekeepers checkinAbTestGatekeepers, PerfTestConfig perfTestConfig) {
        this.f3533c = placesFlowsStore;
        this.f3534d = checkinAbTestGatekeepers;
        this.f3535e = perfTestConfig;
        this.f3533c.m3465a(this.f3532b, this.f3531a);
    }
}
