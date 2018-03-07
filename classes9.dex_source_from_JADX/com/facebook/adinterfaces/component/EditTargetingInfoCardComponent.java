package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesEditTargetingInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;

/* compiled from: _ROWID_ */
public class EditTargetingInfoCardComponent implements AdInterfacesComponent<TextWithEntitiesView, AdInterfacesDataModel> {
    private AdInterfacesEditTargetingInfoViewController f21633a;

    public static EditTargetingInfoCardComponent m22650b(InjectorLike injectorLike) {
        return new EditTargetingInfoCardComponent(AdInterfacesEditTargetingInfoViewController.m24627a(injectorLike));
    }

    @Inject
    EditTargetingInfoCardComponent(AdInterfacesEditTargetingInfoViewController adInterfacesEditTargetingInfoViewController) {
        this.f21633a = adInterfacesEditTargetingInfoViewController;
    }

    public final int mo946a() {
        return 2130903121;
    }

    public final AdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> mo948b() {
        return this.f21633a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        return true;
    }

    public final ComponentType mo949c() {
        return ComponentType.INFO_CARD;
    }
}
