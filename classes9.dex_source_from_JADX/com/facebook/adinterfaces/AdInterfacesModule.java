package com.facebook.adinterfaces;

import android.annotation.SuppressLint;
import com.facebook.adinterfaces.annotations.ForBoostEvent;
import com.facebook.adinterfaces.annotations.ForBoostPost;
import com.facebook.adinterfaces.annotations.ForBoostPostBoostComponent;
import com.facebook.adinterfaces.annotations.ForBoostedComponent;
import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewControllerProvider;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewControllerProvider;
import com.facebook.adinterfaces.ui.BoostPostPromotionDetailsViewControllerProvider;
import com.facebook.adinterfaces.ui.preview.AdInterfacesBoostEventPreviewFetcher;
import com.facebook.adinterfaces.ui.preview.AdInterfacesBoostedComponentPreviewFetcher;
import com.facebook.adinterfaces.util.BoostEventMutationHelper;
import com.facebook.adinterfaces.util.BoostPostBoostComponentMutationHelper;
import com.facebook.adinterfaces.util.BoostPostMutationHelper;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: accountId */
public class AdInterfacesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForBoostedComponent
    @SuppressLint({"ProviderUsage"})
    static AdInterfacesNativePreviewViewController m22442a(AdInterfacesBoostedComponentPreviewFetcher adInterfacesBoostedComponentPreviewFetcher, AdInterfacesNativePreviewViewControllerProvider adInterfacesNativePreviewViewControllerProvider) {
        return adInterfacesNativePreviewViewControllerProvider.m24772a(adInterfacesBoostedComponentPreviewFetcher);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ForBoostEvent
    public static AdInterfacesNativePreviewViewController m22441a(AdInterfacesBoostEventPreviewFetcher adInterfacesBoostEventPreviewFetcher, AdInterfacesNativePreviewViewControllerProvider adInterfacesNativePreviewViewControllerProvider) {
        return adInterfacesNativePreviewViewControllerProvider.m24772a(adInterfacesBoostEventPreviewFetcher);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ForBoostEvent
    public static PromotionDetailsComponent m22438a(BoostPostPromotionDetailsViewControllerProvider boostPostPromotionDetailsViewControllerProvider, BoostEventMutationHelper boostEventMutationHelper) {
        return new PromotionDetailsComponent(boostPostPromotionDetailsViewControllerProvider.m25061a(boostEventMutationHelper));
    }

    @ProviderMethod
    @ForBoostPost
    @SuppressLint({"ProviderUsage"})
    public static PromotionDetailsComponent m22440a(BoostPostPromotionDetailsViewControllerProvider boostPostPromotionDetailsViewControllerProvider, BoostPostMutationHelper boostPostMutationHelper) {
        return new PromotionDetailsComponent(boostPostPromotionDetailsViewControllerProvider.m25061a(boostPostMutationHelper));
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ForBoostPostBoostComponent
    public static PromotionDetailsComponent m22439a(BoostPostPromotionDetailsViewControllerProvider boostPostPromotionDetailsViewControllerProvider, BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper) {
        return new PromotionDetailsComponent(boostPostPromotionDetailsViewControllerProvider.m25061a(boostPostBoostComponentMutationHelper));
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ForBoostEvent
    public static BoostPostFooterComponent m22435a(AdInterfacesBoostPostFooterViewControllerProvider adInterfacesBoostPostFooterViewControllerProvider, BoostEventMutationHelper boostEventMutationHelper) {
        return new BoostPostFooterComponent(adInterfacesBoostPostFooterViewControllerProvider.m24509a(boostEventMutationHelper));
    }

    @ProviderMethod
    @ForBoostPost
    @SuppressLint({"ProviderUsage"})
    public static BoostPostFooterComponent m22437a(AdInterfacesBoostPostFooterViewControllerProvider adInterfacesBoostPostFooterViewControllerProvider, BoostPostMutationHelper boostPostMutationHelper) {
        return new BoostPostFooterComponent(adInterfacesBoostPostFooterViewControllerProvider.m24509a(boostPostMutationHelper));
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ForBoostPostBoostComponent
    public static BoostPostFooterComponent m22436a(AdInterfacesBoostPostFooterViewControllerProvider adInterfacesBoostPostFooterViewControllerProvider, BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper) {
        return new BoostPostFooterComponent(adInterfacesBoostPostFooterViewControllerProvider.m24509a(boostPostBoostComponentMutationHelper));
    }
}
