package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.C2477x748f41fb;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AccountErrorCardComponent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.AdInterfacesResultsComponent;
import com.facebook.adinterfaces.component.ValidationComponent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.FetchLocalAwarenessDataMethod;
import com.facebook.adinterfaces.ui.AdInterfacesAccountViewController;
import com.facebook.adinterfaces.ui.AdInterfacesBoostedAppFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesErrorViewController;
import com.facebook.adinterfaces.ui.AdInterfacesInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesLocalAwarenessTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesScheduleViewController;
import com.facebook.adinterfaces.ui.BoostedComponentBudgetViewController;
import com.facebook.adinterfaces.ui.BoostedComponentSummaryViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: [[contact_us_link]] */
public class LocalAwarenessObjective implements AdInterfacesObjective<AdInterfacesLocalAwarenessDataModel> {
    private final ImmutableList<AdInterfacesComponent<?, ? super AdInterfacesLocalAwarenessDataModel>> f21903g;
    private final FetchLocalAwarenessDataMethod f21904h;
    private final QeAccessor f21905i;

    public static LocalAwarenessObjective m22971b(InjectorLike injectorLike) {
        return new LocalAwarenessObjective(FetchLocalAwarenessDataMethod.m24165b(injectorLike), ValidationComponent.m22719b(injectorLike), BoostedComponentBudgetViewController.m25065b(injectorLike), AdInterfacesScheduleViewController.m24901b(injectorLike), AdInterfacesAccountViewController.m24352b(injectorLike), AccountErrorCardComponent.m22597b(injectorLike), AdInterfacesLocalAwarenessTargetingViewController.m24686d(injectorLike), AdInterfacesBoostedAppFooterViewController.m24534c(injectorLike), BoostedComponentSummaryViewController.m25084b(injectorLike), AdInterfacesErrorViewController.m24633b(injectorLike), AdInterfacesInfoViewController.m24510a(injectorLike), AdInterfacesResultsComponent.m22610b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), C2477x748f41fb.m22445b(injectorLike));
    }

    @Inject
    LocalAwarenessObjective(FetchLocalAwarenessDataMethod fetchLocalAwarenessDataMethod, ValidationComponent validationComponent, BoostedComponentBudgetViewController boostedComponentBudgetViewController, AdInterfacesScheduleViewController adInterfacesScheduleViewController, AdInterfacesAccountViewController adInterfacesAccountViewController, AccountErrorCardComponent accountErrorCardComponent, AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController, AdInterfacesBoostedAppFooterViewController adInterfacesBoostedAppFooterViewController, BoostedComponentSummaryViewController boostedComponentSummaryViewController, AdInterfacesErrorViewController adInterfacesErrorViewController, AdInterfacesInfoViewController adInterfacesInfoViewController, AdInterfacesResultsComponent adInterfacesResultsComponent, QeAccessor qeAccessor, AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        this.f21904h = fetchLocalAwarenessDataMethod;
        this.f21905i = qeAccessor;
        Iterable arrayList = new ArrayList(2);
        arrayList.add(new AdInterfacesInlineComponent(2130903127, adInterfacesNativePreviewViewController, e, ComponentType.AD_PREVIEW));
        arrayList.add(new AdInterfacesInlineComponent(2130903147, adInterfacesLocalAwarenessTargetingViewController, f, ComponentType.TARGETING));
        if (this.f21905i.a(ExperimentsForAdInterfacesModule.f21609f, false)) {
            Collections.reverse(arrayList);
        }
        this.f21903g = new Builder().c(validationComponent).c(new AdInterfacesInlineComponent(2130903121, adInterfacesInfoViewController, a, ComponentType.INFO_CARD)).c(new AdInterfacesInlineComponent(2130903116, adInterfacesErrorViewController, a, ComponentType.ERROR_CARD)).b(arrayList).c(new AdInterfacesInlineComponent(2130903107, boostedComponentBudgetViewController, f, ComponentType.BUDGET)).c(new AdInterfacesInlineComponent(2130903140, adInterfacesScheduleViewController, f, ComponentType.DURATION)).c(accountErrorCardComponent).c(new AdInterfacesInlineComponent(2130903096, adInterfacesAccountViewController, a, ComponentType.ACCOUNT)).c(adInterfacesResultsComponent).c(new AdInterfacesInlineComponent(2130903131, boostedComponentSummaryViewController, d, ComponentType.PROMOTION_DETAILS)).c(new AdInterfacesInlineComponent(2130903144, null, a, ComponentType.SPACER)).c(new AdInterfacesInlineComponent(2130903118, adInterfacesBoostedAppFooterViewController, c, ComponentType.FOOTER)).b();
    }

    public final ImmutableList<AdInterfacesComponent<?, ? super AdInterfacesLocalAwarenessDataModel>> mo968a() {
        return this.f21903g;
    }

    public final void mo969a(Intent intent, final AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21904h.m24136a(intent.getStringExtra("page_id"), ObjectiveType.LOCAL_AWARENESS, AdInterfacesIntentUtil.a(intent), new AdInterfacesDataModel$AdInterfacesDataModelCallback(this) {
            final /* synthetic */ LocalAwarenessObjective f21902b;

            public final void mo941a(BaseAdInterfacesData baseAdInterfacesData) {
                AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel = (AdInterfacesLocalAwarenessDataModel) baseAdInterfacesData;
                CreativeAdModel C = adInterfacesLocalAwarenessDataModel.mo951C();
                C.f21775h = CallToActionWrapper.fromGraphQLTypeCallToAction(C.f21774g).getUri(adInterfacesLocalAwarenessDataModel);
                adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(baseAdInterfacesData);
            }
        });
    }
}
