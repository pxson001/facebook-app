package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.BoostEventEditTargetingComponent;
import com.facebook.adinterfaces.component.EditTargetingFooterComponent;
import com.facebook.adinterfaces.component.EditTargetingInfoCardComponent;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [applinks]api_request_failed */
public class BoostEventEditTargetingObjective implements AdInterfacesObjective {
    private final ImmutableList<AdInterfacesComponent> f21839g;

    @Inject
    public BoostEventEditTargetingObjective(EditTargetingInfoCardComponent editTargetingInfoCardComponent, BoostEventEditTargetingComponent boostEventEditTargetingComponent, EditTargetingFooterComponent editTargetingFooterComponent) {
        this.f21839g = new Builder().c(editTargetingInfoCardComponent).c(boostEventEditTargetingComponent).c(editTargetingFooterComponent).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21839g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a((BaseAdInterfacesData) intent.getParcelableExtra("data"));
    }
}
