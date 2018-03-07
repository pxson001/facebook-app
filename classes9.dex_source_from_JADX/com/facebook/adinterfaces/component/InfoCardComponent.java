package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;

/* compiled from: ^0.* */
public class InfoCardComponent implements AdInterfacesComponent<TextWithEntitiesView, AdInterfacesDataModel> {
    private AdInterfacesBoostPostInfoViewController f21638a;

    public static InfoCardComponent m22670a(InjectorLike injectorLike) {
        return new InfoCardComponent(new AdInterfacesBoostPostInfoViewController(AdInterfacesHelper.m25227a(injectorLike)));
    }

    @Inject
    public InfoCardComponent(AdInterfacesBoostPostInfoViewController adInterfacesBoostPostInfoViewController) {
        this.f21638a = adInterfacesBoostPostInfoViewController;
    }

    public final int mo946a() {
        return 2130903121;
    }

    public final AdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> mo948b() {
        return this.f21638a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        return true;
    }

    public final ComponentType mo949c() {
        return ComponentType.INFO_CARD;
    }
}
