package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsEngagementViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.SegmentedBarInfoView;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ^.*/ */
public class InsightsCardEngagementComponent implements AdInterfacesComponent<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesInsightsEngagementViewController f21640a;

    public static InsightsCardEngagementComponent m22679b(InjectorLike injectorLike) {
        return new InsightsCardEngagementComponent(new AdInterfacesInsightsEngagementViewController(AdInterfacesDataHelper.m22789a(injectorLike)));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        StoryPromotionModel storyPromotionModel = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a;
        if (storyPromotionModel.m23707a().m23643j() == null || storyPromotionModel.m23707a().m23645l() == null || storyPromotionModel.m23707a().m23644k() == null) {
            return false;
        }
        return true;
    }

    @Inject
    InsightsCardEngagementComponent(AdInterfacesInsightsEngagementViewController adInterfacesInsightsEngagementViewController) {
        this.f21640a = adInterfacesInsightsEngagementViewController;
    }

    public final int mo946a() {
        return 2130903122;
    }

    public final AdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21640a;
    }

    public final ComponentType mo949c() {
        return ComponentType.INSIGHTS_ENGAGEMENT;
    }
}
