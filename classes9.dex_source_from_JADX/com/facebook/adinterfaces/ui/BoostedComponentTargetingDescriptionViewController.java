package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;

/* compiled from: Unsupported UserKey type. */
public class BoostedComponentTargetingDescriptionViewController extends BaseTargetingDescriptionViewController<AdInterfacesBoostedComponentDataModel> {
    public static BoostedComponentTargetingDescriptionViewController m25091a(InjectorLike injectorLike) {
        return new BoostedComponentTargetingDescriptionViewController();
    }

    protected final void mo1021a(Context context) {
        BaseAdInterfacesData baseAdInterfacesData = this.f23068b;
        Intent a = AdInterfacesIntentUtil.a(context, ObjectiveType.BOOSTED_COMPONENT_EDIT_TARGETING, Integer.valueOf(2131233951), null);
        AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) new Builder().mo950a();
        adInterfacesBoostedComponentDataModel.f21748d = baseAdInterfacesData.f21748d;
        adInterfacesBoostedComponentDataModel.f21747c = baseAdInterfacesData.f21747c;
        adInterfacesBoostedComponentDataModel.f21799d = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21799d;
        adInterfacesBoostedComponentDataModel.f21746b = baseAdInterfacesData.mo962b();
        BoostedComponentModel boostedComponentModel = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b;
        adInterfacesBoostedComponentDataModel.f21797b = boostedComponentModel;
        if (!(boostedComponentModel == null || boostedComponentModel.m23343j() == null)) {
            adInterfacesBoostedComponentDataModel.f21800e = boostedComponentModel.m23343j().m23232j();
            adInterfacesBoostedComponentDataModel.f21801f = boostedComponentModel.m23343j().m23230a();
        }
        adInterfacesBoostedComponentDataModel.f21754j = baseAdInterfacesData.f21754j;
        AdminInfoModel.Builder builder = new AdminInfoModel.Builder();
        AdAccountsModel.Builder builder2 = new AdAccountsModel.Builder();
        builder2.f21981a = ImmutableList.of(AdInterfacesDataHelper.m22806e(baseAdInterfacesData));
        builder.f21989a = builder2.m23153a();
        adInterfacesBoostedComponentDataModel.f21745a = builder.m23179a();
        adInterfacesBoostedComponentDataModel.f21759o = baseAdInterfacesData.f21759o;
        adInterfacesBoostedComponentDataModel.f21758n = baseAdInterfacesData.f21758n;
        a.putExtra("data", adInterfacesBoostedComponentDataModel);
        this.f22440b.m22429a(new IntentEvent(a, 4, true));
    }

    protected final ImmutableList<TargetingDescriptionModel> mo1022b() {
        return ((AdInterfacesBoostedComponentDataModel) this.f23068b).f21797b.m23356w().m23338a();
    }
}
