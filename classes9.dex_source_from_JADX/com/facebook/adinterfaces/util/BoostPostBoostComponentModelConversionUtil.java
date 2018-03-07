package com.facebook.adinterfaces.util;

import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;

/* compiled from: Unknown CheckoutRowType seen  */
public class BoostPostBoostComponentModelConversionUtil {
    public static AdInterfacesBoostedComponentDataModel m25253a(AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        StoryPromotionInfoModel l = adInterfacesBoostPostDataModel.f21780a.m23713l();
        GraphQLBoostedComponentStatus fromString = GraphQLBoostedComponentStatus.fromString(l.m23677t().toString());
        Builder builder = new AdInterfacesBoostedComponentDataModel.Builder(adInterfacesBoostPostDataModel);
        builder.f21791d = adInterfacesBoostPostDataModel.f21781b;
        builder = builder;
        builder.f21788a = adInterfacesBoostPostDataModel.mo951C();
        builder = builder;
        builder.f21792e = adInterfacesBoostPostDataModel.f21754j.f21729i;
        builder = builder;
        builder.f21793f = adInterfacesBoostPostDataModel.f21754j.f21728h;
        builder = builder;
        BoostedComponentModel.Builder builder2 = new BoostedComponentModel.Builder();
        builder2.f22044a = l.m23664a();
        builder2 = builder2;
        builder2.f22058o = l.m23680w();
        builder2 = builder2;
        builder2.f22057n = l.m23678u();
        builder2 = builder2;
        builder2.f22047d = l.m23668k();
        BoostedComponentModel.Builder builder3 = builder2;
        builder3.f22046c = fromString;
        builder.f21789b = builder3.m23272a();
        AdInterfacesBoostedComponentDataModel.Builder builder4 = builder;
        builder4.f21740j = adInterfacesBoostPostDataModel.f21754j;
        return new AdInterfacesBoostedComponentDataModel(builder4);
    }
}
