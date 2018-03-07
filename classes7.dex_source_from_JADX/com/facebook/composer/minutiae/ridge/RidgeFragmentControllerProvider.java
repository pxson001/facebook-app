package com.facebook.composer.minutiae.ridge;

import com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.event.MinutiaeEventBus;
import com.facebook.composer.minutiae.ridge.config.RidgeTooltipNuxXConfigUtil;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Provider;

/* compiled from: tid */
public class RidgeFragmentControllerProvider extends AbstractAssistedProvider<RidgeFragmentController> {
    public final RidgeFragmentController m1729a(RidgeHost ridgeHost) {
        Provider a = IdBasedProvider.a(this, 637);
        RidgeTooltipNuxXConfigUtil ridgeTooltipNuxXConfigUtil = new RidgeTooltipNuxXConfigUtil(XConfigReader.a(this), (FbResources) DownloadedFbResources.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
        ridgeTooltipNuxXConfigUtil.f1763a = IdBasedSingletonScopeProvider.a(this, 3828);
        return new RidgeFragmentController(ridgeHost, a, ridgeTooltipNuxXConfigUtil, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), RidgeAnalyticsLogger.m1552a(this), AudioFingerprintingSuggestionsCache.m1021a(this), RidgeOptInController.m1822b((InjectorLike) this), MinutiaeEventBus.m1583a(this));
    }
}
