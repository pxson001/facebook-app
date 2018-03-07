package com.facebook.adinterfaces;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel.Builder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.google.common.collect.ImmutableList;

/* compiled from: abcdefghijklmnopqrstuvwxyz */
public class EditTargetingIntentHelper {
    public static Intent m22520a(Context context, BaseAdInterfacesData baseAdInterfacesData) {
        ObjectiveType objectiveType = baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_EVENT ? ObjectiveType.BOOST_EVENT_EDIT_TARGETING : ObjectiveType.BOOST_POST_EDIT_TARGETING;
        Intent a = AdInterfacesIntentUtil.a(context, objectiveType, Integer.valueOf(2131233951), baseAdInterfacesData.f21755k);
        Parcelable b = new Builder().mo961b();
        b.f21748d = baseAdInterfacesData.f21748d;
        b.f21746b = objectiveType;
        b.f21754j = baseAdInterfacesData.f21754j;
        AdminInfoModel.Builder builder = new AdminInfoModel.Builder();
        AdAccountsModel.Builder builder2 = new AdAccountsModel.Builder();
        builder2.f21981a = ImmutableList.of(AdInterfacesDataHelper.m22806e(baseAdInterfacesData));
        builder.f21989a = builder2.m23153a();
        b.f21745a = builder.m23179a();
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        b.f21780a = adInterfacesBoostPostDataModel.f21780a;
        b.f21781b = adInterfacesBoostPostDataModel.f21781b;
        b.f21782c = adInterfacesBoostPostDataModel.f21782c;
        b.f21784e = adInterfacesBoostPostDataModel.f21784e;
        a.putExtra("data", b);
        return a;
    }
}
