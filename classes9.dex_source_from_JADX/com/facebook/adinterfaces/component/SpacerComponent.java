package com.facebook.adinterfaces.component;

import android.view.View;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;

/* compiled from: \d{5}[\-]?\d{3} */
public class SpacerComponent implements AdInterfacesComponent<View, AdInterfacesDataModel> {
    public static SpacerComponent m22703a(InjectorLike injectorLike) {
        return new SpacerComponent();
    }

    public final int mo946a() {
        return 2130903144;
    }

    public final AdInterfacesViewController<View, AdInterfacesDataModel> mo948b() {
        return null;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        return true;
    }

    public final ComponentType mo949c() {
        return null;
    }
}
