package com.facebook.placetips.settings;

import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;

/* compiled from: rectangles */
class PlaceTipsRuntimeSettingsManager$1 implements Runnable {
    final /* synthetic */ GravitySettingsGraphQlFragmentModel f3542a;
    final /* synthetic */ GravitySettingsGraphQlFragmentModel f3543b;
    final /* synthetic */ PlaceTipsRuntimeSettingsManager f3544c;

    PlaceTipsRuntimeSettingsManager$1(PlaceTipsRuntimeSettingsManager placeTipsRuntimeSettingsManager, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel2) {
        this.f3544c = placeTipsRuntimeSettingsManager;
        this.f3542a = gravitySettingsGraphQlFragmentModel;
        this.f3543b = gravitySettingsGraphQlFragmentModel2;
    }

    public void run() {
        PlaceTipsRuntimeSettingsManager.b(this.f3544c, this.f3542a, this.f3543b);
    }
}
