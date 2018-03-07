package com.facebook.xconfig.core;

import com.facebook.analytics.AndroidReliabilityXConfig;
import com.facebook.analytics.DataUsageXConfig;
import com.facebook.api.feed.xconfig.AsyncFeedXConfig;
import com.facebook.api.feed.xconfig.FeedClientXConfig;
import com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.ufiservices.config.FeedbackPrefetchPolicyXConfig;
import com.facebook.assetdownload.AssetDownloadXConfigMethodAutoProvider;
import com.facebook.attribution.AttributionIdXConfig;
import com.facebook.backgroundworklog.performanceobserver.BackgroundWorkObserverXConfig;
import com.facebook.browser.prefetch.config.BrowserPrefetchConfig;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.appstate.configs.FloatingWindowTimeoutXConfig;
import com.facebook.composer.minutiae.MinutiaeModule;
import com.facebook.composer.minutiae.ridge.config.RidgeXConfig;
import com.facebook.contacts.background.configs.ContactsReliabilityCheckXConfig;
import com.facebook.contextual.validation.ContextualConfigValidationXConfigMethodAutoProvider;
import com.facebook.credentials.AuthTokenXConfig;
import com.facebook.deeplinking.config.DeepLinkingConfig;
import com.facebook.device_id.DeviceIdXConfig;
import com.facebook.devicebasedlogin.logging.DeviceBasedLoginXConfig;
import com.facebook.dialtone.DialtoneWhitelistXConfig;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherXConfig;
import com.facebook.fbtrace.FbTraceXConfig;
import com.facebook.feed.sponsored.SponsoredFeedValidationXConfig;
import com.facebook.feed.xconfig.BackToBackPTRXConfig;
import com.facebook.feed.xconfig.FeedUnitInvalidateTimeXConfig;
import com.facebook.feed.xconfig.VpvStrippedTrackingDataXConfig;
import com.facebook.feed.xconfig.VpvWaterFallXConfig;
import com.facebook.friending.profileshare.xconfig.ProfileShareXConfig;
import com.facebook.http.common.RequestSamplingConfig;
import com.facebook.http.executors.liger.CertVerificationLoggerXConfig;
import com.facebook.http.observer.DataConnectionXConfig;
import com.facebook.http.onion.prefs.OnionRewriteXConfig;
import com.facebook.http.onion.prefs.OrbotSignaturesXConfig;
import com.facebook.imagepipeline.instrumentation.ImagePipelineLoggingXConfig;
import com.facebook.imagepipeline.module.ProgressiveJpegXConfig;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.location.foreground.ForegroundLocationFrameworkXConfig;
import com.facebook.location.foreground.GeoPixelXConfig;
import com.facebook.loom.module.LoomXConfig;
import com.facebook.malware.scanner.MalwareScannerXConfig;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLoggerXConfig;
import com.facebook.messaging.business.commerceui.config.WifiNotificationXConfig;
import com.facebook.messaging.business.promotion.config.AdsImpressionLoggingXConfig;
import com.facebook.messaging.business.ride.config.BusinessRideXConfig;
import com.facebook.messaging.customthreads.CustomThreadThemesXConfig;
import com.facebook.messaging.customthreads.CustomThreadsXConfig;
import com.facebook.messaging.media.upload.config.MediaUploadXConfig;
import com.facebook.messaging.particles.FloatingHeartStickersXConfig;
import com.facebook.messaging.particles.SnowFallStickersXConfig;
import com.facebook.messaging.requestrouting.RequestRoutingXConfig;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageXConfig;
import com.facebook.messaging.sms.defaultapp.config.CarrierXConfig;
import com.facebook.orca.background.StickerAssetFlushXConfig;
import com.facebook.orca.threadview.seenheads.configs.SeenHeadsMaxGroupSizeXConfig;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLoggingXConfig;
import com.facebook.photos.upload.module.UploadQualityXConfig;
import com.facebook.presence.configs.DisableGenericPresenceTimerXConfig;
import com.facebook.presence.configs.PresenceLruCacheXConfig;
import com.facebook.privacy.checkup.abtest.PrivacyCheckupMobileXConfig;
import com.facebook.privacy.checkup.photofeed.PhotoPrivacyFeedXConfig;
import com.facebook.push.c2dm.configs.GcmTokenRefreshXConfig;
import com.facebook.richdocument.config.InstantArticlesXConfig;
import com.facebook.rtc.fbwebrtc.xconfig.VoipConfig;
import com.facebook.rtc.voicemail.RtcVoicemailConfig;
import com.facebook.saved.gating.feature.SaverInfoXConfig;
import com.facebook.ssl.reporter.RootCAReporterXConfig;
import com.facebook.stickers.service.DownloadPreviewStickerPacksXConfig;
import com.facebook.trace.DebugTraceXConfig;
import com.facebook.ui.browser.config.BrowserConfig;
import com.facebook.ui.browser.config.BrowserPerfConfig;
import com.facebook.ui.browser.config.SSOConfig;
import com.facebook.ui.typeahead.SearchTypeaheadConfig;
import com.facebook.video.abtest.VideoDashXConfig;
import com.facebook.video.engine.ErrorSamplingXConfig;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBarXConfig;
import com.facebook.zero.token.ZeroTokenXConfig;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$XConfig implements MultiBindIndexedProvider<XConfig>, Provider<Set<XConfig>> {
    private final InjectorLike f1633a;

    public STATICDI_MULTIBIND_PROVIDER$XConfig(InjectorLike injectorLike) {
        this.f1633a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1633a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 78;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AndroidReliabilityXConfig();
            case 1:
                return new DataUsageXConfig();
            case 2:
                return new AsyncFeedXConfig();
            case 3:
                return new FeedClientXConfig();
            case 4:
                return FeedOffScreenAdsFetchXConfig.a(injector);
            case 5:
                return new FreshFeedConfig();
            case 6:
                return NewsFeedXConfig.a(injector);
            case 7:
                return new FeedbackPrefetchPolicyXConfig();
            case 8:
                return AssetDownloadXConfigMethodAutoProvider.m1924a(injector);
            case 9:
                return new AttributionIdXConfig();
            case 10:
                return new BackgroundWorkObserverXConfig();
            case 11:
                return BrowserPrefetchConfig.m1927a(injector);
            case 12:
                return new BugReportingXConfig();
            case 13:
                return new FloatingWindowTimeoutXConfig();
            case 14:
                return MinutiaeModule.m1929a();
            case 15:
                return new RidgeXConfig();
            case 16:
                return new ContactsReliabilityCheckXConfig();
            case 17:
                return ContextualConfigValidationXConfigMethodAutoProvider.m1930a(injector);
            case 18:
                return new AuthTokenXConfig();
            case 19:
                return new DeepLinkingConfig();
            case 20:
                return new DeviceIdXConfig();
            case 21:
                return new DeviceBasedLoginXConfig();
            case 22:
                return new DialtoneWhitelistXConfig();
            case 23:
                return DialtoneManualSwitcherXConfig.a(injector);
            case 24:
                return new FbTraceXConfig();
            case 25:
                return new SponsoredFeedValidationXConfig();
            case 26:
                return new BackToBackPTRXConfig();
            case 27:
                return new FeedUnitInvalidateTimeXConfig();
            case 28:
                return new VpvStrippedTrackingDataXConfig();
            case 29:
                return new VpvWaterFallXConfig();
            case 30:
                return ProfileShareXConfig.m1937a(injector);
            case 31:
                return new RequestSamplingConfig();
            case 32:
                return new CertVerificationLoggerXConfig();
            case 33:
                return new DataConnectionXConfig();
            case 34:
                return new OnionRewriteXConfig();
            case 35:
                return new OrbotSignaturesXConfig();
            case 36:
                return new ImagePipelineLoggingXConfig();
            case 37:
                return new ProgressiveJpegXConfig();
            case 38:
                return new ForegroundLocationFrameworkXConfig();
            case 39:
                return new GeoPixelXConfig();
            case 40:
                return new LoomXConfig();
            case 41:
                return new MalwareScannerXConfig();
            case 42:
                return new AggregatedReliabilityLoggerXConfig();
            case 43:
                return WifiNotificationXConfig.m1944a(injector);
            case 44:
                return new AdsImpressionLoggingXConfig();
            case 45:
                return new BusinessRideXConfig();
            case 46:
                return new CustomThreadThemesXConfig();
            case 47:
                return new CustomThreadsXConfig();
            case 48:
                return MediaUploadXConfig.m1947a(injector);
            case 49:
                return new FloatingHeartStickersXConfig();
            case 50:
                return new SnowFallStickersXConfig();
            case 51:
                return new RequestRoutingXConfig();
            case 52:
                return new SendAsMessageXConfig();
            case 53:
                return new CarrierXConfig();
            case 54:
                return new StickerAssetFlushXConfig();
            case 55:
                return new SeenHeadsMaxGroupSizeXConfig();
            case 56:
                return new CreativeEditingAnalyticsLoggingXConfig();
            case 57:
                return new UploadQualityXConfig();
            case 58:
                return new DisableGenericPresenceTimerXConfig();
            case 59:
                return new PresenceLruCacheXConfig();
            case 60:
                return new PrivacyCheckupMobileXConfig();
            case 61:
                return new PhotoPrivacyFeedXConfig();
            case 62:
                return new GcmTokenRefreshXConfig();
            case 63:
                return new InstantArticlesXConfig();
            case 64:
                return VoipConfig.m1949a(injector);
            case 65:
                return new RtcVoicemailConfig();
            case 66:
                return new SaverInfoXConfig();
            case 67:
                return new RootCAReporterXConfig();
            case 68:
                return new DownloadPreviewStickerPacksXConfig();
            case 69:
                return DebugTraceXConfig.m9764a(injector);
            case 70:
                return BrowserConfig.m1951a(injector);
            case 71:
                return new BrowserPerfConfig();
            case 72:
                return SSOConfig.m1953a(injector);
            case 73:
                return SearchTypeaheadConfig.m1954b(injector);
            case 74:
                return new VideoDashXConfig();
            case 75:
                return new ErrorSamplingXConfig();
            case 76:
                return FrameRateProgressBarXConfig.a(injector);
            case 77:
                return new ZeroTokenXConfig();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
