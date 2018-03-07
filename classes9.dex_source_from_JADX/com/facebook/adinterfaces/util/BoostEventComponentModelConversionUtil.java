package com.facebook.adinterfaces.util;

import com.facebook.adinterfaces.model.EventSpecModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;

/* compiled from: Unknown MessengerPayHistoryStatusViewState %s found */
public class BoostEventComponentModelConversionUtil {
    public static AdInterfacesBoostedComponentDataModel m25240a(AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel) {
        StoryPromotionInfoModel l = adInterfacesBoostEventDataModel.f21780a.m23713l();
        GraphQLBoostedComponentStatus fromString = GraphQLBoostedComponentStatus.fromString(l.m23677t().toString());
        Builder builder = new Builder(adInterfacesBoostEventDataModel);
        builder.f21790c = new EventSpecModel(adInterfacesBoostEventDataModel.f21805a, adInterfacesBoostEventDataModel.f21806b);
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
        return new AdInterfacesBoostedComponentDataModel(builder);
    }
}
