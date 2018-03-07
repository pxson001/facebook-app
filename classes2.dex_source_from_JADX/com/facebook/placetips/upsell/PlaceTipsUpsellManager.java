package com.facebook.placetips.upsell;

import com.facebook.common.time.Clock;
import com.facebook.common.time.TimeConversions;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.LocationUpsellsModel;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.upsell.abtest.ExperimentsForPlaceTipsUpsellAbtestModule;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: marauder_runnable_experiment */
public class PlaceTipsUpsellManager {
    private final PagePresenceProvider f15104a;
    private final Lazy<Accessor> f15105b;
    public final PlaceTipsUpsellExperimentController f15106c;
    private final Clock f15107d;

    @Inject
    public PlaceTipsUpsellManager(PagePresenceProvider pagePresenceProvider, Lazy<Accessor> lazy, PlaceTipsUpsellExperimentController placeTipsUpsellExperimentController, Clock clock) {
        this.f15104a = pagePresenceProvider;
        this.f15105b = lazy;
        this.f15106c = placeTipsUpsellExperimentController;
        this.f15107d = clock;
    }

    public final boolean m21646a() {
        if (((Accessor) this.f15105b.get()).m21316f() && ((Accessor) this.f15105b.get()).m21314d()) {
            return false;
        }
        if (!this.f15106c.m21649a() || this.f15106c.m21650c() <= 0) {
            return false;
        }
        if (((Accessor) this.f15105b.get()).f14879b.mo286a(PlaceTipsSettingsPrefs.f14958e, false)) {
            return false;
        }
        int g = ((Accessor) this.f15105b.get()).m21317g();
        long a = ((Accessor) this.f15105b.get()).f14879b.mo277a(PlaceTipsSettingsPrefs.f14957d, 0);
        if (g >= this.f15106c.f15109b.mo572a(ExperimentsForPlaceTipsUpsellAbtestModule.d, 0) || this.f15107d.mo211a() - a < TimeConversions.m11976p((long) this.f15106c.f15109b.mo572a(ExperimentsForPlaceTipsUpsellAbtestModule.e, 0))) {
            return false;
        }
        return true;
    }

    @Nullable
    public final LocationUpsellsModel m21647b() {
        Optional b = this.f15104a.mo2827b();
        if (!b.isPresent()) {
            return null;
        }
        LocationUpsellsModel locationUpsellsModel;
        LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel = (LocationTriggerWithReactionUnitsModel) b.get();
        if (locationTriggerWithReactionUnitsModel.a() == null || locationTriggerWithReactionUnitsModel.a().c().isEmpty()) {
            locationUpsellsModel = null;
        } else {
            ImmutableList c = locationTriggerWithReactionUnitsModel.a().c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                locationUpsellsModel = (LocationUpsellsModel) c.get(i);
                if ("placetips-travel".equals(locationUpsellsModel.a())) {
                    break;
                }
            }
            locationUpsellsModel = null;
        }
        LocationUpsellsModel locationUpsellsModel2 = locationUpsellsModel;
        if (locationUpsellsModel2 == null) {
            return null;
        }
        if (m21646a()) {
            return locationUpsellsModel2;
        }
        return null;
    }
}
