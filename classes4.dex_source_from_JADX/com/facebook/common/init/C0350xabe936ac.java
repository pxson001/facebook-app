package com.facebook.common.init;

import android.content.Context;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheObserverManager;
import com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.analytics.ClientPeriodicEventReporterManager;
import com.facebook.analytics.ExecutorsTasksLogger;
import com.facebook.analytics.NetworkDataCategorizer;
import com.facebook.analytics.anrwatchdog.ANRDetectorController;
import com.facebook.analytics.appstatelogger.AppStateLoggerEnabler;
import com.facebook.analytics.cpuspindetector.CpuSpinCheckerController;
import com.facebook.analytics.powermetrics.PowerMetricsController;
import com.facebook.analytics.reporters.AppStateReporter;
import com.facebook.analytics.service.AnalyticsEventUploaderInitializer;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.appinvites.installtracking.AppInvitesInstallTracker;
import com.facebook.apptab.state.abtest.NavigationExperimentSyncer;
import com.facebook.auth.sign.ApkSignatureVerifier;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.bookmark.db.BookmarkDatabaseCleaner;
import com.facebook.clashmanagement.api.ClashUnitInitiallizer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.dextricksdi.DexOptimizationKickoffThing;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.memory.MemoryDumpScheduler;
import com.facebook.common.gcinitopt.GcOptimizerGKHelper;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.compactdiskmodule.DiskCacheExperimentInit;
import com.facebook.compactdiskmodule.DiskSizeCalculatorInit;
import com.facebook.compactdiskmodule.ExperimentManagerMethodAutoProvider;
import com.facebook.compactdiskmodule.ExperimentUpdaterInit;
import com.facebook.compactdiskmodule.LazyDispatcherInit;
import com.facebook.compactdiskmodule.LazyDispatcherMethodAutoProvider;
import com.facebook.compactdiskmodule.StoreManagerFactoryMethodAutoProvider;
import com.facebook.conditionalworker.ConditionalWorkerManager;
import com.facebook.contacts.properties.CollationChangedTracker;
import com.facebook.cookiesync.CookieSyncer;
import com.facebook.database.olddbcleaner.OldDatabasesCleaner;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.feed.data.CrashLoopCounter;
import com.facebook.feed.util.MegaSoundEventsSubscriber;
import com.facebook.friends.navigator.FriendingNavigator$InitOnBoot;
import com.facebook.friendsharing.souvenirs.manager.SouvenirManager.InitOnBoot;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.executor.OfflineMutationsManager;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.interstitial.manager.InterstitialDataCleaner;
import com.facebook.katana.notification.impl.AppBadgingInitializer;
import com.facebook.katana.ringtone.RingtoneRegister;
import com.facebook.loom.module.ConfigProviderInitializer;
import com.facebook.loom.module.NotificationControls;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorInitializer;
import com.facebook.messaging.connectivity.WifiBroadcastReceiverEnabler;
import com.facebook.messaging.contacts.loader.ContactListsCacheListener;
import com.facebook.messaging.newphoto.NewPhotoBroadcastReceiverInitializer;
import com.facebook.messaging.photoreminders.omnistore.PhotoRemindersOmnistoreSubscriptionInitializer;
import com.facebook.messaging.send.client.SendFailureNotificationsCleaner;
import com.facebook.messaging.tincan.messenger.AttachmentUploadRetryColStartTrigger;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.messengerwear.support.MessengerWearDetectionInit;
import com.facebook.nogms.NoGmsGatekeeperInit;
import com.facebook.notifications.lockscreenservice.LockMessageLoader;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.omnistore.module.OmnistoreComponentManager;
import com.facebook.orca.notify.MessengerLauncherBadgesController;
import com.facebook.orca.notify.UnreadThreadsBadgeCountCalculator;
import com.facebook.orca.threadlist.ThreadsPreloadInitializer;
import com.facebook.orca.threadview.SendStatesExperienceInitializer;
import com.facebook.oxygen.preloads.integration.dogfooding.AuthListener;
import com.facebook.oxygen.preloads.integration.tosacceptance.TosAcceptedListener;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifest;
import com.facebook.powermanagement.RadioPowerManagerInstaller;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.PresenceAfterUILoadedInitializer;
import com.facebook.push.crossapp.PackageRemovedReceiverInitializer;
import com.facebook.push.crossapp.PendingReportedPackages;
import com.facebook.quickpromotion.event.QuickPromotionEventManager;
import com.facebook.resources.impl.loading.SimpleDownloadManager;
import com.facebook.rtc.campon.RtcCamperStore;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.voicemail.VoicemailHandler;
import com.facebook.saved.intentfilter.ExternalSaveActivity$InitOnBoot;
import com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier;
import com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier;
import com.facebook.selfupdate.AppUpdateLibInitializer;
import com.facebook.sync.SyncInitializer;
import com.facebook.timeline.profilevideo.ProfileVideoShareActivity$InitOnBoot;
import com.facebook.timeline.stagingground.ProfilePictureShareActivity;
import com.facebook.trace.DebugTraceInit;
import com.facebook.trace.DebugTraceUploader;
import com.facebook.trace.DebugTraceXConfigListener;
import com.facebook.ui.browser.logging.BrowserCoreFeatureLogger;
import com.facebook.ui.media.cache.FileCacheDelayedWorkerScheduler;
import com.facebook.vault.service.VaultManager;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.facebook.webrtc.WebrtcManager;
import com.facebook.xanalytics.provider.XAnalyticsLowPriorityInit;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.zero.iptest.ZeroIPTestInitializer;
import com.facebook.zero.iptest.ZeroIPTestScheduler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0350xabe936ac implements MultiBindIndexedProvider<INeedInit>, Provider<Set<INeedInit>> {
    private final InjectorLike f7335a;

    public C0350xabe936ac(InjectorLike injectorLike) {
        this.f7335a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7335a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 90;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return QuickExperimentMemoryCacheObserverManager.a(injector);
            case 1:
                return QuickExperimentReportDataSupplier.a(injector);
            case 2:
                return AldrinUserStatusManager.m8301a((InjectorLike) injector);
            case 3:
                return ClientPeriodicEventReporterManager.a(injector);
            case 4:
                return ExecutorsTasksLogger.m8310a(injector);
            case 5:
                return NetworkDataCategorizer.b(injector);
            case 6:
                return new ANRDetectorController(IdBasedProvider.a(injector, 4780), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injector), AppStateManager.a(injector), IdBasedProvider.a(injector, 630), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), XConfigReader.a(injector));
            case 7:
                return AppStateLoggerEnabler.a(injector);
            case 8:
                return CpuSpinCheckerController.m8323b(injector);
            case 9:
                return PowerMetricsController.m8343b(injector);
            case 10:
                return AppStateReporter.m8356b(injector);
            case 11:
                return AnalyticsEventUploaderInitializer.m8359a(injector);
            case 12:
                return FeedDbMutationService.a(injector);
            case 13:
                return AppInvitesInstallTracker.m8364b(injector);
            case 14:
                return NavigationExperimentSyncer.m8375a(injector);
            case 15:
                return ApkSignatureVerifier.m8388b(injector);
            case 16:
                return BackgroundTaskManager.a(injector);
            case 17:
                return BookmarkDatabaseCleaner.m8391a((InjectorLike) injector);
            case 18:
                return ClashUnitInitiallizer.m8394a(injector);
            case 19:
                return DexOptimizationKickoffThing.m8404a((InjectorLike) injector);
            case 20:
                return MemoryDumpScheduler.m8409a(injector);
            case 21:
                return new GcOptimizerGKHelper((Context) injector.getInstance(Context.class, ForAppContext.class), GatekeeperStoreImplMethodAutoProvider.a(injector));
            case 22:
                return FbDataConnectionManager.a(injector);
            case 23:
                return new DiskCacheExperimentInit(IdBasedProvider.a(injector, 650), StoreManagerFactoryMethodAutoProvider.m8425a(injector));
            case 24:
                return DiskSizeCalculatorInit.m8491b(injector);
            case 25:
                return new ExperimentUpdaterInit(ExperimentManagerMethodAutoProvider.m8477a(injector));
            case 26:
                return new LazyDispatcherInit(LazyDispatcherMethodAutoProvider.m8471a(injector));
            case 27:
                return ConditionalWorkerManager.m8492a((InjectorLike) injector);
            case 28:
                return CollationChangedTracker.m8546b(injector);
            case 29:
                return CookieSyncer.m8587b((InjectorLike) injector);
            case 30:
                return OldDatabasesCleaner.m8589a((InjectorLike) injector);
            case 31:
                return DeviceConditionHelper.a(injector);
            case 32:
                return ResourceManager.a(injector);
            case 33:
                return Fb4aReactInstanceManager.m8595a(injector);
            case 34:
                return CrashLoopCounter.a(injector);
            case 35:
                return MegaSoundEventsSubscriber.a(injector);
            case 36:
                return FriendingNavigator$InitOnBoot.m8652a(injector);
            case 37:
                return InitOnBoot.m8656b(injector);
            case 38:
                return OfflineMutationsManager.m8657a((InjectorLike) injector);
            case 39:
                return InterstitialDataCleaner.m8667a((InjectorLike) injector);
            case 40:
                return AppBadgingInitializer.m8670a((InjectorLike) injector);
            case 41:
                return RingtoneRegister.m8704b(injector);
            case 42:
                return new ConfigProviderInitializer();
            case 43:
                return NotificationControls.m8709a((InjectorLike) injector);
            case 44:
                return AggregatedReliabilityLogger.m8724a((InjectorLike) injector);
            case 45:
                return ConnectionStatusMonitorInitializer.m8742a(injector);
            case 46:
                return WifiBroadcastReceiverEnabler.m8811b(injector);
            case 47:
                return ContactListsCacheListener.m8812a(injector);
            case 48:
                return NewPhotoBroadcastReceiverInitializer.m8814a(injector);
            case 49:
                return com.facebook.messaging.photoreminders.NewPhotoBroadcastReceiverInitializer.m8818a(injector);
            case 50:
                return PhotoRemindersOmnistoreSubscriptionInitializer.m8845b(injector);
            case 51:
                return new SendFailureNotificationsCleaner((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), SystemClockMethodAutoProvider.a(injector));
            case 52:
                return AttachmentUploadRetryColStartTrigger.m8848b((InjectorLike) injector);
            case 53:
                return ThriftUtil.a(injector);
            case 54:
                return MessengerWearDetectionInit.m9224a((InjectorLike) injector);
            case 55:
                return NoGmsGatekeeperInit.m9234a(injector);
            case 56:
                return LockMessageLoader.m9236a((InjectorLike) injector);
            case 57:
                return OfflineObliviousOperationsExecutor.a(injector);
            case 58:
                return OmnistoreComponentManager.getInstance__com_facebook_omnistore_module_OmnistoreComponentManager__INJECTED_BY_TemplateInjector(injector);
            case 59:
                return MessengerLauncherBadgesController.m9281a((InjectorLike) injector);
            case 60:
                return UnreadThreadsBadgeCountCalculator.m9286a(injector);
            case 61:
                return ThreadsPreloadInitializer.m9295a(injector);
            case 62:
                return SendStatesExperienceInitializer.m9310a(injector);
            case 63:
                return AuthListener.m9312a((InjectorLike) injector);
            case 64:
                return TosAcceptedListener.m9370a(injector);
            case 65:
                return PlatformWebDialogsManifest.m9372a((InjectorLike) injector);
            case 66:
                return RadioPowerManagerInstaller.m9414a(injector);
            case 67:
                return PresenceAfterUILoadedInitializer.m9416a(injector);
            case 68:
                return PackageRemovedReceiverInitializer.m9418a((InjectorLike) injector);
            case 69:
                return PendingReportedPackages.m9421a((InjectorLike) injector);
            case 70:
                return QuickPromotionEventManager.m9425a(injector);
            case 71:
                return SimpleDownloadManager.m9428a((InjectorLike) injector);
            case 72:
                return RtcCamperStore.m9441a((InjectorLike) injector);
            case 73:
                return WebrtcLoggingHandler.m9451a((InjectorLike) injector);
            case 74:
                return VoicemailHandler.m9510a((InjectorLike) injector);
            case 75:
                return ExternalSaveActivity$InitOnBoot.m9554b(injector);
            case 76:
                return DefaultSearchNullStateListSupplier.a(injector);
            case 77:
                return VideoScopedNullStateSupplier.m9696a((InjectorLike) injector);
            case 78:
                return new AppUpdateLibInitializer(IdBasedSingletonScopeProvider.b(injector, 305));
            case 79:
                return SyncInitializer.m9744a(injector);
            case 80:
                return ProfileVideoShareActivity$InitOnBoot.m9752b(injector);
            case 81:
                return ProfilePictureShareActivity.InitOnBoot.m9754b(injector);
            case 82:
                return new DebugTraceInit(DebugTraceXConfigListener.m9755a((InjectorLike) injector), DebugTraceUploader.m9770a((InjectorLike) injector));
            case 83:
                return BrowserCoreFeatureLogger.m9793b(injector);
            case 84:
                return FileCacheDelayedWorkerScheduler.m9794a(injector);
            case 85:
                return VaultManager.m9796a(injector);
            case 86:
                return VideoServerMethodAutoProvider.a(injector);
            case 87:
                return WebrtcManager.m9858a((InjectorLike) injector);
            case 88:
                return XAnalyticsLowPriorityInit.m9878a(injector);
            case 89:
                return new ZeroIPTestInitializer(ZeroIPTestScheduler.m9906a(injector), IdBasedProvider.a(injector, 4393));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
