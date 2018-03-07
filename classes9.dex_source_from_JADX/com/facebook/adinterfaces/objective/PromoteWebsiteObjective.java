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
import com.facebook.adinterfaces.protocol.FetchPromoteWebsiteMethod;
import com.facebook.adinterfaces.ui.AdInterfacesAccountViewController;
import com.facebook.adinterfaces.ui.AdInterfacesErrorViewController;
import com.facebook.adinterfaces.ui.AdInterfacesInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeUnifiedTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesScheduleViewController;
import com.facebook.adinterfaces.ui.AdInterfacesUrlViewController;
import com.facebook.adinterfaces.ui.BoostedComponentBudgetViewController;
import com.facebook.adinterfaces.ui.BoostedComponentSummaryViewController;
import com.facebook.adinterfaces.ui.BoostedComponentTargetingDescriptionViewController;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [TT;[I)[ */
public class PromoteWebsiteObjective implements AdInterfacesObjective {
    private final FetchPromoteWebsiteMethod f21912g;
    private final ImmutableList<AdInterfacesComponent> f21913h;

    public static PromoteWebsiteObjective m22983b(InjectorLike injectorLike) {
        return new PromoteWebsiteObjective(FetchPromoteWebsiteMethod.m24225a(injectorLike), ValidationComponent.m22718a(injectorLike), AdInterfacesUrlViewController.m24977a(injectorLike), AdInterfacesInfoViewController.m24512b(injectorLike), AdInterfacesAccountViewController.m24341a(injectorLike), AccountErrorCardComponent.m22596a(injectorLike), AdInterfacesErrorViewController.m24631a(injectorLike), BoostedComponentSummaryViewController.m25082a(injectorLike), BoostedComponentTargetingDescriptionViewController.m25091a(injectorLike), BoostedComponentBudgetViewController.m25064a(injectorLike), AdInterfacesScheduleViewController.m24896a(injectorLike), AdInterfacesPageLikeFooterViewController.m24782a(injectorLike), AdInterfacesResultsComponent.m22609a(injectorLike), C2477x748f41fb.m22444a(injectorLike), AdInterfacesPageLikeUnifiedTargetingViewController.m24809b(injectorLike));
    }

    @Inject
    PromoteWebsiteObjective(FetchPromoteWebsiteMethod fetchPromoteWebsiteMethod, ValidationComponent validationComponent, AdInterfacesUrlViewController adInterfacesUrlViewController, AdInterfacesInfoViewController adInterfacesInfoViewController, AdInterfacesAccountViewController adInterfacesAccountViewController, AccountErrorCardComponent accountErrorCardComponent, AdInterfacesErrorViewController adInterfacesErrorViewController, BoostedComponentSummaryViewController boostedComponentSummaryViewController, BoostedComponentTargetingDescriptionViewController boostedComponentTargetingDescriptionViewController, BoostedComponentBudgetViewController boostedComponentBudgetViewController, AdInterfacesScheduleViewController adInterfacesScheduleViewController, AdInterfacesPageLikeFooterViewController adInterfacesPageLikeFooterViewController, AdInterfacesResultsComponent adInterfacesResultsComponent, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController, AdInterfacesPageLikeUnifiedTargetingViewController adInterfacesPageLikeUnifiedTargetingViewController) {
        this.f21912g = fetchPromoteWebsiteMethod;
        this.f21913h = new Builder().c(validationComponent).c(new AdInterfacesInlineComponent(2130903121, adInterfacesInfoViewController, a, ComponentType.INFO_CARD)).c(new AdInterfacesInlineComponent(2130903116, adInterfacesErrorViewController, a, ComponentType.ERROR_CARD)).c(new AdInterfacesInlineComponent(2130903154, adInterfacesUrlViewController, f, ComponentType.WEBSITE_URL)).c(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, e, ComponentType.AD_PREVIEW)).c(adInterfacesResultsComponent).c(new AdInterfacesInlineComponent(2130903131, boostedComponentSummaryViewController, d, ComponentType.PROMOTION_DETAILS)).c(new AdInterfacesInlineComponent(2130903148, boostedComponentTargetingDescriptionViewController, d, ComponentType.TARGETING_DESCRIPTION)).c(new AdInterfacesInlineComponent(2130903151, adInterfacesPageLikeUnifiedTargetingViewController, f, ComponentType.TARGETING)).c(new AdInterfacesInlineComponent(2130903107, boostedComponentBudgetViewController, f, ComponentType.BUDGET)).c(new AdInterfacesInlineComponent(2130903140, adInterfacesScheduleViewController, f, ComponentType.DURATION)).c(accountErrorCardComponent).c(new AdInterfacesInlineComponent(2130903096, adInterfacesAccountViewController, a, ComponentType.ACCOUNT)).c(new AdInterfacesInlineComponent(2130903118, adInterfacesPageLikeFooterViewController, c, ComponentType.FOOTER)).c(new AdInterfacesInlineComponent(2130903144, null, a, ComponentType.SPACER)).b();
    }

    public final ImmutableList mo968a() {
        return this.f21913h;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21912g.m24136a(intent.getStringExtra("page_id"), ObjectiveType.PROMOTE_WEBSITE, AdInterfacesIntentUtil.a(intent), adInterfacesDataModel$AdInterfacesDataModelCallback);
    }
}
