package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.FBStepperWithLabel;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesDurationStepperViewController;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: __android_injected_function_ */
public class DurationStepperComponent implements AdInterfacesComponent<FBStepperWithLabel, AdInterfacesDataModel> {
    private AdInterfacesDurationStepperViewController f21630a;

    public static DurationStepperComponent m22638a(InjectorLike injectorLike) {
        return new DurationStepperComponent(new AdInterfacesDurationStepperViewController(ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public DurationStepperComponent(AdInterfacesDurationStepperViewController adInterfacesDurationStepperViewController) {
        this.f21630a = adInterfacesDurationStepperViewController;
    }

    public final int mo946a() {
        return 2130903115;
    }

    public final BaseAdInterfacesViewController mo948b() {
        return this.f21630a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (AdInterfacesDataHelper.m22811g(baseAdInterfacesData) && baseAdInterfacesData.f21748d == AdInterfacesStatus.INACTIVE) {
            return true;
        }
        return false;
    }

    public final ComponentType mo949c() {
        return ComponentType.DURATION;
    }
}
