package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.abtest.ExperimentsForAdInterfacesExternalModule;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostTypeRadioGroupView;
import com.facebook.adinterfaces.ui.AdInterfacesEventBoostTypeRadioGroupViewController;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: ^\d+$ */
public class EventBoostTypeRadioGroupComponent implements AdInterfacesComponent<AdInterfacesBoostTypeRadioGroupView, AdInterfacesBoostEventDataModel> {
    private final QeAccessor f21635a;
    private final AdInterfacesEventBoostTypeRadioGroupViewController f21636b;

    public static EventBoostTypeRadioGroupComponent m22660a(InjectorLike injectorLike) {
        return new EventBoostTypeRadioGroupComponent(new AdInterfacesEventBoostTypeRadioGroupViewController(ResourcesMethodAutoProvider.a(injectorLike)), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostEventDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        String str;
        StoryPromotionModel storyPromotionModel = baseAdInterfacesData.f21780a;
        if (storyPromotionModel == null || storyPromotionModel.m23714m() == null) {
            str = null;
        } else {
            str = storyPromotionModel.m23714m().m23430j();
        }
        if (!Strings.isNullOrEmpty(str) && baseAdInterfacesData.f21748d == AdInterfacesStatus.INACTIVE && this.f21635a.a(ExperimentsForAdInterfacesExternalModule.a, false)) {
            return true;
        }
        return false;
    }

    @Inject
    public EventBoostTypeRadioGroupComponent(AdInterfacesEventBoostTypeRadioGroupViewController adInterfacesEventBoostTypeRadioGroupViewController, QeAccessor qeAccessor) {
        this.f21636b = adInterfacesEventBoostTypeRadioGroupViewController;
        this.f21635a = qeAccessor;
    }

    public final int mo946a() {
        return 2130903106;
    }

    public final BaseAdInterfacesViewController mo948b() {
        return this.f21636b;
    }

    public final ComponentType mo949c() {
        return ComponentType.BOOST_TYPE;
    }
}
