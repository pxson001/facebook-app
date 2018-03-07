package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel;
import com.facebook.adinterfaces.ui.AdInterfacesConversionPixelViewController;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerAdapterProvider;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerView;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: __android_retval */
public class ConversionPixelComponent implements AdInterfacesComponent<AdInterfacesSpinnerView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesConversionPixelViewController f21629a;

    public static ConversionPixelComponent m22633a(InjectorLike injectorLike) {
        return new ConversionPixelComponent(new AdInterfacesConversionPixelViewController((AdInterfacesSpinnerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesSpinnerAdapterProvider.class)));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        StoryPromotionInfoModel l = baseAdInterfacesData.f21780a.m23713l();
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        boolean n = l.m23671n();
        boolean z = l.m23673p() != null;
        switch (adInterfacesStatus) {
            case INACTIVE:
            case NEVER_BOOSTED:
                return n;
            case ACTIVE:
            case PAUSED:
            case EXTENDABLE:
            case PENDING:
                return z;
            default:
                return false;
        }
    }

    @Inject
    public ConversionPixelComponent(AdInterfacesConversionPixelViewController adInterfacesConversionPixelViewController) {
        this.f21629a = adInterfacesConversionPixelViewController;
    }

    public final int mo946a() {
        return 2130903111;
    }

    public final BaseAdInterfacesViewController mo948b() {
        return this.f21629a;
    }

    public final ComponentType mo949c() {
        return ComponentType.CONVERSION_PIXEL;
    }
}
