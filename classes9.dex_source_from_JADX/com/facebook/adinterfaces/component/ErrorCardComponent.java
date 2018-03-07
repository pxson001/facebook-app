package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesErrorViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;

/* compiled from: _64.png */
public class ErrorCardComponent implements AdInterfacesComponent<TextWithEntitiesView, AdInterfacesDataModel> {
    private AdInterfacesErrorViewController f21634a;

    public static ErrorCardComponent m22655a(InjectorLike injectorLike) {
        return new ErrorCardComponent(AdInterfacesErrorViewController.m24633b(injectorLike));
    }

    @Inject
    public ErrorCardComponent(AdInterfacesErrorViewController adInterfacesErrorViewController) {
        this.f21634a = adInterfacesErrorViewController;
    }

    public final int mo946a() {
        return 2130903116;
    }

    public final AdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> mo948b() {
        return this.f21634a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        return true;
    }

    public final ComponentType mo949c() {
        return ComponentType.ERROR_CARD;
    }
}
