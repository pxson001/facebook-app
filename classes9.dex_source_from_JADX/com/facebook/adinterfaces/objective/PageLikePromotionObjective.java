package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.C2477x748f41fb;
import com.facebook.adinterfaces.component.AccountErrorCardComponent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.AdInterfacesResultsComponent;
import com.facebook.adinterfaces.component.ValidationComponent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.protocol.FetchPageLikePromotionMethod;
import com.facebook.adinterfaces.ui.AdInterfacesAccountViewController;
import com.facebook.adinterfaces.ui.AdInterfacesErrorViewController;
import com.facebook.adinterfaces.ui.AdInterfacesInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeUnifiedTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesScheduleViewController;
import com.facebook.adinterfaces.ui.BoostedComponentBudgetViewController;
import com.facebook.adinterfaces.ui.BoostedComponentSummaryViewController;
import com.facebook.adinterfaces.ui.BoostedComponentTargetingDescriptionViewController;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [[component]] */
public class PageLikePromotionObjective implements AdInterfacesObjective {
    ImmutableList<AdInterfacesComponent> f21906g;
    private FetchPageLikePromotionMethod f21907h;

    public static PageLikePromotionObjective m22974b(InjectorLike injectorLike) {
        return new PageLikePromotionObjective(FetchPageLikePromotionMethod.m24171b(injectorLike), ValidationComponent.m22719b(injectorLike), AdInterfacesInfoViewController.m24510a(injectorLike), AdInterfacesAccountViewController.m24352b(injectorLike), AccountErrorCardComponent.m22597b(injectorLike), AdInterfacesErrorViewController.m24633b(injectorLike), BoostedComponentSummaryViewController.m25084b(injectorLike), BoostedComponentTargetingDescriptionViewController.m25091a(injectorLike), BoostedComponentBudgetViewController.m25065b(injectorLike), AdInterfacesScheduleViewController.m24901b(injectorLike), AdInterfacesResultsComponent.m22610b(injectorLike), AdInterfacesPageLikeFooterViewController.m24783c(injectorLike), AdInterfacesPageLikeUnifiedTargetingViewController.m24810d(injectorLike), C2477x748f41fb.m22445b(injectorLike));
    }

    @Inject
    PageLikePromotionObjective(FetchPageLikePromotionMethod fetchPageLikePromotionMethod, ValidationComponent validationComponent, AdInterfacesInfoViewController adInterfacesInfoViewController, AdInterfacesAccountViewController adInterfacesAccountViewController, AccountErrorCardComponent accountErrorCardComponent, AdInterfacesErrorViewController adInterfacesErrorViewController, BoostedComponentSummaryViewController boostedComponentSummaryViewController, BoostedComponentTargetingDescriptionViewController boostedComponentTargetingDescriptionViewController, BoostedComponentBudgetViewController boostedComponentBudgetViewController, AdInterfacesScheduleViewController adInterfacesScheduleViewController, AdInterfacesResultsComponent adInterfacesResultsComponent, AdInterfacesPageLikeFooterViewController adInterfacesPageLikeFooterViewController, AdInterfacesPageLikeUnifiedTargetingViewController adInterfacesPageLikeUnifiedTargetingViewController, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        this.f21907h = fetchPageLikePromotionMethod;
        this.f21906g = new Builder().c(validationComponent).c(new AdInterfacesInlineComponent(2130903121, adInterfacesInfoViewController, a, ComponentType.INFO_CARD)).c(new AdInterfacesInlineComponent(2130903116, adInterfacesErrorViewController, a, ComponentType.ERROR_CARD)).c(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, e, ComponentType.AD_PREVIEW)).c(adInterfacesResultsComponent).c(new AdInterfacesInlineComponent(2130903131, boostedComponentSummaryViewController, d, ComponentType.PROMOTION_DETAILS)).c(new AdInterfacesInlineComponent(2130903148, boostedComponentTargetingDescriptionViewController, d, ComponentType.TARGETING_DESCRIPTION)).c(new AdInterfacesInlineComponent(2130903151, adInterfacesPageLikeUnifiedTargetingViewController, f, ComponentType.TARGETING)).c(new AdInterfacesInlineComponent(2130903107, boostedComponentBudgetViewController, f, ComponentType.BUDGET)).c(new AdInterfacesInlineComponent(2130903140, adInterfacesScheduleViewController, f, ComponentType.DURATION)).c(accountErrorCardComponent).c(new AdInterfacesInlineComponent(2130903096, adInterfacesAccountViewController, a, ComponentType.ACCOUNT)).c(new AdInterfacesInlineComponent(2130903118, adInterfacesPageLikeFooterViewController, c, ComponentType.FOOTER)).c(new AdInterfacesInlineComponent(2130903144, null, a, ComponentType.SPACER)).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21906g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21907h.m24136a(intent.getStringExtra("page_id"), ObjectiveType.PAGE_LIKE, AdInterfacesIntentUtil.a(intent), adInterfacesDataModel$AdInterfacesDataModelCallback);
    }
}
