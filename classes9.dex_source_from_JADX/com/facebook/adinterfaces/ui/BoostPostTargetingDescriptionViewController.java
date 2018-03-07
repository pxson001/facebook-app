package com.facebook.adinterfaces.ui;

import android.content.Context;
import com.facebook.adinterfaces.EditTargetingIntentHelper;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel;
import com.google.common.collect.ImmutableList;

/* compiled from: Unsupported launch mode for PaymentPinRequireActivity */
public class BoostPostTargetingDescriptionViewController extends BaseTargetingDescriptionViewController<AdInterfacesBoostPostDataModel> {
    protected final void mo1021a(Context context) {
        this.f22440b.m22429a(new IntentEvent(EditTargetingIntentHelper.m22520a(context, this.f23068b), 4, true));
    }

    protected final ImmutableList<TargetingDescriptionModel> mo1022b() {
        return ((AdInterfacesBoostPostDataModel) this.f23068b).f21780a.m23713l().m23679v().m23662a();
    }
}
