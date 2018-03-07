package com.facebook.places.checkin.composerflows;

import com.facebook.checkin.abtest.CheckinAbTestGatekeepers;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.protocol.PlacePickerCache;
import com.facebook.places.common.PlacesPrefKeys;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: seek_video */
public class PeopleToPlaceController {
    private final PrefKey f3524a = ((PrefKey) PlacesPrefKeys.a.a("tag_people_to_place_time_of_last_skip"));
    private final PrefKey f3525b = ((PrefKey) PlacesPrefKeys.a.a("tag_people_to_place_consecutive_num_times_skipped"));
    public final PlacesFlowsStore f3526c;
    private final PlacePickerCache f3527d;
    public final CheckinAbTestGatekeepers f3528e;
    public SearchResults f3529f;
    private final FutureCallback<SearchResults> f3530g = new C04481(this);

    /* compiled from: seek_video */
    class C04481 implements FutureCallback<SearchResults> {
        final /* synthetic */ PeopleToPlaceController f3523a;

        C04481(PeopleToPlaceController peopleToPlaceController) {
            this.f3523a = peopleToPlaceController;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f3523a.f3529f = (SearchResults) obj;
        }

        public void onFailure(Throwable th) {
        }
    }

    public static PeopleToPlaceController m3460b(InjectorLike injectorLike) {
        return new PeopleToPlaceController(PlacesFlowsStore.m3462b(injectorLike), PlacePickerCache.a(injectorLike), CheckinAbTestGatekeepers.b(injectorLike));
    }

    @Inject
    public PeopleToPlaceController(PlacesFlowsStore placesFlowsStore, PlacePickerCache placePickerCache, CheckinAbTestGatekeepers checkinAbTestGatekeepers) {
        this.f3526c = placesFlowsStore;
        this.f3526c.m3465a(this.f3525b, this.f3524a);
        this.f3527d = placePickerCache;
        this.f3527d.a(this.f3530g);
        this.f3528e = checkinAbTestGatekeepers;
    }
}
