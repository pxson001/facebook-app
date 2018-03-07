package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.BoostPostFooterComponentMethodAutoProvider;
import com.facebook.adinterfaces.C2477x748f41fb;
import com.facebook.adinterfaces.PromotionDetailsComponentMethodAutoProvider;
import com.facebook.adinterfaces.annotations.ForBoostPost;
import com.facebook.adinterfaces.component.AccountComponent;
import com.facebook.adinterfaces.component.AccountErrorCardComponent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.AdInterfacesResultsComponent;
import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.component.BoostPostTargetingComponent;
import com.facebook.adinterfaces.component.ConversionPixelComponent;
import com.facebook.adinterfaces.component.DurationStepperComponent;
import com.facebook.adinterfaces.component.ErrorCardComponent;
import com.facebook.adinterfaces.component.InfoCardComponent;
import com.facebook.adinterfaces.component.InsightsSummaryComponent;
import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.component.SpacerComponent;
import com.facebook.adinterfaces.component.TargetingDescriptionComponent;
import com.facebook.adinterfaces.component.TotalBudgetComponent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPacingViewController;
import com.facebook.graphql.enums.GraphQLAdsApiPacingType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: [[resend_code_link]] */
public class BoostPostObjective implements AdInterfacesObjective {
    private static final AdInterfacesComponentStatus f21866i;
    private static final AdInterfacesComponentStatus f21867j = new C25261();
    private final BoostPostDataFetcher f21868g;
    private final ImmutableList<AdInterfacesComponent> f21869h;

    /* compiled from: [[resend_code_link]] */
    final class C25261 implements AdInterfacesComponentStatus {
        C25261() {
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            if (baseAdInterfacesData == null || !AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
                return false;
            }
            switch (baseAdInterfacesData.f21748d) {
                case INACTIVE:
                case NEVER_BOOSTED:
                    if (((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a.m23712k().m23701a().m23697j() != GraphQLAdsApiPacingType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public static BoostPostObjective m22936b(InjectorLike injectorLike) {
        return new BoostPostObjective(BoostPostDataFetcher.m22923a(injectorLike), ErrorCardComponent.m22655a(injectorLike), InfoCardComponent.m22670a(injectorLike), BoostPostTargetingComponent.m22626a(injectorLike), TotalBudgetComponent.m22713a(injectorLike), InsightsSummaryComponent.m22689a(injectorLike), AccountErrorCardComponent.m22596a(injectorLike), AccountComponent.m22591a(injectorLike), ConversionPixelComponent.m22633a(injectorLike), TargetingDescriptionComponent.m22708a(injectorLike), SpacerComponent.m22703a(injectorLike), AdInterfacesResultsComponent.m22609a(injectorLike), C2477x748f41fb.m22444a(injectorLike), DurationStepperComponent.m22638a(injectorLike), PromotionDetailsComponentMethodAutoProvider.m22584a(injectorLike), BoostPostFooterComponentMethodAutoProvider.m22517a(injectorLike), AdInterfacesPacingViewController.m24774a(injectorLike));
    }

    static {
        AdInterfacesComponentStatusBuilder newBuilder = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder.f21829b = true;
        AdInterfacesComponentStatusBuilder adInterfacesComponentStatusBuilder = newBuilder;
        adInterfacesComponentStatusBuilder.f21828a = ImmutableList.of(AdInterfacesStatus.INACTIVE, AdInterfacesStatus.NEVER_BOOSTED, AdInterfacesStatus.ACTIVE, AdInterfacesStatus.PAUSED, AdInterfacesStatus.REJECTED, AdInterfacesStatus.EXTENDABLE, AdInterfacesStatus.PENDING, AdInterfacesStatus.ERROR, AdInterfacesStatus.CREATING, AdInterfacesStatus.FINISHED);
        f21866i = adInterfacesComponentStatusBuilder.m22909a();
    }

    @Inject
    BoostPostObjective(BoostPostDataFetcher boostPostDataFetcher, ErrorCardComponent errorCardComponent, InfoCardComponent infoCardComponent, BoostPostTargetingComponent boostPostTargetingComponent, TotalBudgetComponent totalBudgetComponent, InsightsSummaryComponent insightsSummaryComponent, AccountErrorCardComponent accountErrorCardComponent, AccountComponent accountComponent, ConversionPixelComponent conversionPixelComponent, TargetingDescriptionComponent targetingDescriptionComponent, SpacerComponent spacerComponent, AdInterfacesResultsComponent adInterfacesResultsComponent, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController, DurationStepperComponent durationStepperComponent, @ForBoostPost PromotionDetailsComponent promotionDetailsComponent, @ForBoostPost BoostPostFooterComponent boostPostFooterComponent, @ForBoostPost AdInterfacesPacingViewController adInterfacesPacingViewController) {
        this.f21868g = boostPostDataFetcher;
        this.f21869h = new Builder().c(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, f21866i, ComponentType.AD_PREVIEW)).c(insightsSummaryComponent).c(errorCardComponent).c(infoCardComponent).c(adInterfacesResultsComponent).c(promotionDetailsComponent).c(boostPostTargetingComponent).c(targetingDescriptionComponent).c(totalBudgetComponent).c(durationStepperComponent).c(new AdInterfacesInlineComponent(2130903129, adInterfacesPacingViewController, f21867j, ComponentType.PACING)).c(accountErrorCardComponent).c(accountComponent).c(conversionPixelComponent).c(spacerComponent).c(boostPostFooterComponent).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21869h;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        String stringExtra = intent.getStringExtra("storyId");
        String stringExtra2 = intent.getStringExtra("legacyStoryId");
        this.f21868g.m22925a(intent.getStringExtra("page_id"), stringExtra, stringExtra2, AdInterfacesIntentUtil.a(intent), adInterfacesDataModel$AdInterfacesDataModelCallback);
    }
}
