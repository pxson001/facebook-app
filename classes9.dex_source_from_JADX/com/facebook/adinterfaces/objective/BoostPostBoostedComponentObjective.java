package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.C2477x748f41fb;
import com.facebook.adinterfaces.C2488xa95e6eb5;
import com.facebook.adinterfaces.C2506xb8391df6;
import com.facebook.adinterfaces.component.AccountComponent;
import com.facebook.adinterfaces.component.AccountErrorCardComponent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.AdInterfacesResultsComponent;
import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.component.BoostPostTargetingComponent;
import com.facebook.adinterfaces.component.DurationStepperComponent;
import com.facebook.adinterfaces.component.ErrorCardComponent;
import com.facebook.adinterfaces.component.InfoCardComponent;
import com.facebook.adinterfaces.component.InsightsSummaryComponent;
import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.component.SpacerComponent;
import com.facebook.adinterfaces.component.TargetingDescriptionComponent;
import com.facebook.adinterfaces.component.TotalBudgetComponent;
import com.facebook.adinterfaces.component.ValidationComponent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [^?]+)(\?.*)? */
public class BoostPostBoostedComponentObjective implements AdInterfacesObjective {
    private ImmutableList<AdInterfacesComponent> f21842g;
    private BoostPostDataFetcher f21843h;

    public static BoostPostBoostedComponentObjective m22920b(InjectorLike injectorLike) {
        return new BoostPostBoostedComponentObjective(ValidationComponent.m22718a(injectorLike), BoostPostDataFetcher.m22923a(injectorLike), ErrorCardComponent.m22655a(injectorLike), BoostPostTargetingComponent.m22626a(injectorLike), TotalBudgetComponent.m22713a(injectorLike), DurationStepperComponent.m22638a(injectorLike), AccountComponent.m22591a(injectorLike), SpacerComponent.m22703a(injectorLike), C2477x748f41fb.m22444a(injectorLike), C2488xa95e6eb5.m22519a(injectorLike), C2506xb8391df6.m22586a(injectorLike), InsightsSummaryComponent.m22689a(injectorLike), AccountErrorCardComponent.m22596a(injectorLike), TargetingDescriptionComponent.m22708a(injectorLike), AdInterfacesResultsComponent.m22609a(injectorLike), InfoCardComponent.m22670a(injectorLike));
    }

    @Inject
    BoostPostBoostedComponentObjective(ValidationComponent validationComponent, BoostPostDataFetcher boostPostDataFetcher, ErrorCardComponent errorCardComponent, BoostPostTargetingComponent boostPostTargetingComponent, TotalBudgetComponent totalBudgetComponent, DurationStepperComponent durationStepperComponent, AccountComponent accountComponent, SpacerComponent spacerComponent, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController, BoostPostFooterComponent boostPostFooterComponent, PromotionDetailsComponent promotionDetailsComponent, InsightsSummaryComponent insightsSummaryComponent, AccountErrorCardComponent accountErrorCardComponent, TargetingDescriptionComponent targetingDescriptionComponent, AdInterfacesResultsComponent adInterfacesResultsComponent, InfoCardComponent infoCardComponent) {
        this.f21843h = boostPostDataFetcher;
        this.f21842g = new Builder().c(validationComponent).c(errorCardComponent).c(infoCardComponent).c(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, e, ComponentType.AD_PREVIEW)).c(insightsSummaryComponent).c(adInterfacesResultsComponent).c(promotionDetailsComponent).c(boostPostTargetingComponent).c(targetingDescriptionComponent).c(totalBudgetComponent).c(durationStepperComponent).c(accountErrorCardComponent).c(accountComponent).c(spacerComponent).c(boostPostFooterComponent).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21842g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        String stringExtra = intent.getStringExtra("storyId");
        String stringExtra2 = intent.getStringExtra("legacyStoryId");
        this.f21843h.m22925a(intent.getStringExtra("page_id"), stringExtra, stringExtra2, AdInterfacesIntentUtil.a(intent), adInterfacesDataModel$AdInterfacesDataModelCallback);
    }
}
