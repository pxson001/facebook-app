package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.BoostPostFooterComponent_ForBoostEventMethodAutoProvider;
import com.facebook.adinterfaces.C2476xfbb65f57;
import com.facebook.adinterfaces.PromotionDetailsComponent_ForBoostEventMethodAutoProvider;
import com.facebook.adinterfaces.component.AccountComponent;
import com.facebook.adinterfaces.component.AccountErrorCardComponent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.AdInterfacesResultsComponent;
import com.facebook.adinterfaces.component.BoostEventTargetingComponent;
import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.component.DurationStepperComponent;
import com.facebook.adinterfaces.component.ErrorCardComponent;
import com.facebook.adinterfaces.component.EventBoostTypeRadioGroupComponent;
import com.facebook.adinterfaces.component.InfoCardComponent;
import com.facebook.adinterfaces.component.InsightsSummaryComponent;
import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.component.SpacerComponent;
import com.facebook.adinterfaces.component.TargetingDescriptionComponent;
import com.facebook.adinterfaces.component.TotalBudgetComponent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [applinks] skipped_because_data_not_ready */
public class BoostEventObjective implements AdInterfacesObjective {
    private ImmutableList<AdInterfacesComponent> f21840g;
    private BoostPostDataFetcher f21841h;

    public static BoostEventObjective m22917b(InjectorLike injectorLike) {
        return new BoostEventObjective(BoostPostDataFetcher.m22923a(injectorLike), ErrorCardComponent.m22655a(injectorLike), EventBoostTypeRadioGroupComponent.m22660a(injectorLike), BoostEventTargetingComponent.m22620a(injectorLike), TotalBudgetComponent.m22713a(injectorLike), DurationStepperComponent.m22638a(injectorLike), AccountComponent.m22591a(injectorLike), SpacerComponent.m22703a(injectorLike), C2476xfbb65f57.m22443a(injectorLike), BoostPostFooterComponent_ForBoostEventMethodAutoProvider.m22518a(injectorLike), PromotionDetailsComponent_ForBoostEventMethodAutoProvider.m22585a(injectorLike), InsightsSummaryComponent.m22689a(injectorLike), AccountErrorCardComponent.m22596a(injectorLike), TargetingDescriptionComponent.m22708a(injectorLike), AdInterfacesResultsComponent.m22609a(injectorLike), InfoCardComponent.m22670a(injectorLike));
    }

    @Inject
    BoostEventObjective(BoostPostDataFetcher boostPostDataFetcher, ErrorCardComponent errorCardComponent, EventBoostTypeRadioGroupComponent eventBoostTypeRadioGroupComponent, BoostEventTargetingComponent boostEventTargetingComponent, TotalBudgetComponent totalBudgetComponent, DurationStepperComponent durationStepperComponent, AccountComponent accountComponent, SpacerComponent spacerComponent, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController, BoostPostFooterComponent boostPostFooterComponent, PromotionDetailsComponent promotionDetailsComponent, InsightsSummaryComponent insightsSummaryComponent, AccountErrorCardComponent accountErrorCardComponent, TargetingDescriptionComponent targetingDescriptionComponent, AdInterfacesResultsComponent adInterfacesResultsComponent, InfoCardComponent infoCardComponent) {
        this.f21841h = boostPostDataFetcher;
        this.f21840g = new Builder().c(errorCardComponent).c(infoCardComponent).c(eventBoostTypeRadioGroupComponent).c(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, e, ComponentType.AD_PREVIEW)).c(insightsSummaryComponent).c(adInterfacesResultsComponent).c(promotionDetailsComponent).c(boostEventTargetingComponent).c(targetingDescriptionComponent).c(totalBudgetComponent).c(durationStepperComponent).c(accountErrorCardComponent).c(accountComponent).c(spacerComponent).c(boostPostFooterComponent).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21840g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        String stringExtra = intent.getStringExtra("storyId");
        String stringExtra2 = intent.getStringExtra("legacyStoryId");
        String stringExtra3 = intent.getStringExtra("promotion_target_id");
        this.f21841h.m22926a(intent.getStringExtra("page_id"), stringExtra, stringExtra2, stringExtra3, AdInterfacesIntentUtil.a(intent), adInterfacesDataModel$AdInterfacesDataModelCallback);
    }
}
