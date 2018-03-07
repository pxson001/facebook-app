package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.EditTargetingComponent;
import com.facebook.adinterfaces.component.EditTargetingFooterComponent;
import com.facebook.adinterfaces.component.EditTargetingInfoCardComponent;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [[terms_and_policies]] */
public class BoostPostEditTargetingObjective implements AdInterfacesObjective {
    ImmutableList<AdInterfacesComponent> f21855g;

    @Inject
    public BoostPostEditTargetingObjective(EditTargetingInfoCardComponent editTargetingInfoCardComponent, EditTargetingComponent editTargetingComponent, EditTargetingFooterComponent editTargetingFooterComponent) {
        this.f21855g = new Builder().c(editTargetingInfoCardComponent).c(editTargetingComponent).c(editTargetingFooterComponent).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21855g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a((BaseAdInterfacesData) intent.getParcelableExtra("data"));
    }
}
