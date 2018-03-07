package com.facebook.placetips.upsell;

import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.LocationUpsellsModel;
import com.facebook.placetips.presence.PagePresenceManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: marauder_tier */
public class PlaceTipsUpsellManagerCacheWrapper {
    public final PlaceTipsUpsellManager f15102a;
    @Nullable
    private LocationUpsellsModel f15103b;

    public static PlaceTipsUpsellManagerCacheWrapper m21643b(InjectorLike injectorLike) {
        return new PlaceTipsUpsellManagerCacheWrapper(new PlaceTipsUpsellManager(PagePresenceManager.m21206a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3022), PlaceTipsUpsellExperimentController.m21648b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike)));
    }

    @Inject
    public PlaceTipsUpsellManagerCacheWrapper(PlaceTipsUpsellManager placeTipsUpsellManager) {
        this.f15102a = placeTipsUpsellManager;
    }

    @Nullable
    public final synchronized LocationUpsellsModel m21644b() {
        LocationUpsellsModel locationUpsellsModel;
        if (this.f15103b == null || !this.f15102a.m21646a()) {
            this.f15103b = this.f15102a.m21647b();
            locationUpsellsModel = this.f15103b;
        } else {
            locationUpsellsModel = this.f15103b;
        }
        return locationUpsellsModel;
    }

    public final synchronized void m21645c() {
        this.f15103b = null;
    }
}
