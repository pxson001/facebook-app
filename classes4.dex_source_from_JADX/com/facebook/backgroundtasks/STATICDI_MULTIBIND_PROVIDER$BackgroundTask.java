package com.facebook.backgroundtasks;

import com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask;
import com.facebook.abtest.qe.sessionlessqe.SyncSessionlessQuickExperimentBackgroundTask;
import com.facebook.aldrin.task.UpdateAldrinUserStatusBackgroundTask;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.background.impl.ConfigurationBackgroundTask;
import com.facebook.confirmation.task.OpenIDConnectEmailConfirmationBackgroundTask;
import com.facebook.confirmation.task.ReadSmsConfirmAccountBackgroundTask;
import com.facebook.confirmation.task.SmsConfirmationReaderBackgroundTaskExperimental;
import com.facebook.contactlogs.ContactLogsUploadBackgroundTask;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.background.AddressBookSyncBackgroundTask;
import com.facebook.contacts.upload.ContactsUploadBackgroundTask;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.messaging.clockskew.ClockSkewCheckBackgroundTask;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.media.upload.udp.UDPReceivingBackgroundTask;
import com.facebook.messaging.media.upload.udp.UDPSendingBackgroundTask;
import com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask;
import com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask;
import com.facebook.orca.background.FetchFeaturedStickerTagsBackgroundTask;
import com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask;
import com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask;
import com.facebook.orca.background.FetchStickerPacksBackgroundTask;
import com.facebook.orca.background.FetchThreadListBackgroundTask;
import com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask;
import com.facebook.orca.background.StickerAssetCleanupBackgroundTask;
import com.facebook.orca.background.StickerAssetFlushBackgroundTask;
import com.facebook.orca.contacts.data.ContactsPreloadBackgroundTask;
import com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTask;
import com.facebook.photos.upload.retry.FailedUploadRetryTask;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.task.UpdateNewUserInfoTask;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.selfupdate.SelfUpdateStartOperationTask;
import com.facebook.stickers.background.StickersAssetsDownloadBackgroundTask;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$BackgroundTask implements MultiBindIndexedProvider<BackgroundTask>, Provider<Set<BackgroundTask>> {
    private final InjectorLike f9867a;

    public STATICDI_MULTIBIND_PROVIDER$BackgroundTask(InjectorLike injectorLike) {
        this.f9867a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9867a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<BackgroundTask>> m10272a(InjectorLike injectorLike) {
        return ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$BackgroundTask(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 29;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return SyncQuickExperimentBackgroundTask.m12634a(injector);
            case 1:
                return SyncSessionlessQuickExperimentBackgroundTask.m12652a(injector);
            case 2:
                return UpdateAldrinUserStatusBackgroundTask.m12661a(injector);
            case 3:
                return new ConfigurationBackgroundTask((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), DefaultBlueServiceOperationFactory.b(injector), (Clock) SystemClockMethodAutoProvider.a(injector));
            case 4:
                return OpenIDConnectEmailConfirmationBackgroundTask.m12674a((InjectorLike) injector);
            case 5:
                return ReadSmsConfirmAccountBackgroundTask.m12714b(injector);
            case 6:
                return SmsConfirmationReaderBackgroundTaskExperimental.m12729a((InjectorLike) injector);
            case 7:
                return ContactLogsUploadBackgroundTask.m12759a(injector);
            case 8:
                return new AddressBookSyncBackgroundTask(AddressBookPeriodicRunner.m12785a((InjectorLike) injector));
            case 9:
                return ContactsUploadBackgroundTask.m12802a(injector);
            case 10:
                return ClockSkewCheckBackgroundTask.m12853a(injector);
            case 11:
                return UDPReceivingBackgroundTask.m12873a(injector);
            case 12:
                return UDPSendingBackgroundTask.m12886a(injector);
            case 13:
                return DefaultMessagesRefreshUserInfoBackgroundTask.m12895a(injector);
            case 14:
                return FetchAutoDownloadStickersBackgroundTask.m12902a((InjectorLike) injector);
            case 15:
                return FetchFeaturedStickerTagsBackgroundTask.m12924a(injector);
            case 16:
                return FetchOutOfDateThreadsBackgroundTask.m12931a(injector);
            case 17:
                return FetchStickerKeyboardMetadataBackgroundTask.m12940a(injector);
            case 18:
                return FetchStickerPacksBackgroundTask.m12990a(injector);
            case 19:
                return FetchThreadListBackgroundTask.m13057a((InjectorLike) injector);
            case 20:
                return FetchThreadsIntoMemoryCacheBackgroundTask.m9298a((InjectorLike) injector);
            case 21:
                return StickerAssetCleanupBackgroundTask.m13064a((InjectorLike) injector);
            case 22:
                return StickerAssetFlushBackgroundTask.m13089a(injector);
            case 23:
                return new ContactsPreloadBackgroundTask(ContactsLoaderFactory.m13105a(injector), (Clock) SystemClockMethodAutoProvider.a(injector), IdBasedProvider.a(injector, 4056));
            case 24:
                return AdminedPagesPrefetchBackgroundTask.m13111a(injector);
            case 25:
                return FailedUploadRetryTask.m7372a((InjectorLike) injector);
            case 26:
                return new UpdateNewUserInfoTask((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), IdBasedProvider.a(injector, 4442), GraphQLQueryExecutor.a(injector), SimpleRegLogger.m13147b((InjectorLike) injector), RegistrationUtil.m13191b((InjectorLike) injector));
            case 27:
                return SelfUpdateStartOperationTask.m13247b(injector);
            case 28:
                return StickersAssetsDownloadBackgroundTask.m13262a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
