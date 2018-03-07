package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.ValidateCreateBoostedComponentMethod;
import com.facebook.adinterfaces.ui.AdInterfacesValidationViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: \d{4}([\-]\d{3})? */
public class ValidationComponent implements AdInterfacesComponent<BetterTextView, AdInterfacesDataModel> {
    private AdInterfacesValidationViewController f21648a;

    public static ValidationComponent m22719b(InjectorLike injectorLike) {
        return new ValidationComponent(new AdInterfacesValidationViewController(ValidateCreateBoostedComponentMethod.m24295a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike)));
    }

    @Inject
    ValidationComponent(AdInterfacesValidationViewController adInterfacesValidationViewController) {
        this.f21648a = adInterfacesValidationViewController;
    }

    public final int mo946a() {
        return 2130903153;
    }

    public final AdInterfacesViewController<BetterTextView, AdInterfacesDataModel> mo948b() {
        return this.f21648a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED) {
            return true;
        }
        return false;
    }

    public static ValidationComponent m22718a(InjectorLike injectorLike) {
        return m22719b(injectorLike);
    }

    public final ComponentType mo949c() {
        return ComponentType.INFO_CARD;
    }
}
