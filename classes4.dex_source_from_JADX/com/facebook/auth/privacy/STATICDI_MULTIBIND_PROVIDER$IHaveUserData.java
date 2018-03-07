package com.facebook.auth.privacy;

import android.content.Context;
import com.facebook.abtest.qe.AutoQEUserDataCleanup;
import com.facebook.abtest.qe.db.QuickExperimentDbSupplier;
import com.facebook.abtest.qe.log.RecentUIDsUtil;
import com.facebook.abtest.qe.multiprocess.QuickExperimentBroadcastManager;
import com.facebook.abtest.qe.service.QuickExperimentUserDataDbCleaner;
import com.facebook.analytics.db.AnalyticsDatabaseSupplier;
import com.facebook.api.feedcache.OmnistoreUpdateInitializer;
import com.facebook.api.feedcache.db.FeedDbCacheCleaner;
import com.facebook.api.feedcache.resync.NewsFeedCacheSyncInitializer;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.auth.component.persistent.RecentUserIdsManager;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.db.BookmarkDatabaseCleaner;
import com.facebook.browser.liteclient.BrowserLiteClientDataManager;
import com.facebook.browser.prefetch.BrowserPrefetchCacheManager;
import com.facebook.common.diagnostics.LogcatFbSdcardLogger;
import com.facebook.composer.publish.cache.db.ComposerDatabaseSupplier;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore;
import com.facebook.composer.savedsession.ComposerSavedSessionStore;
import com.facebook.compost.publish.cache.draftstory.CompostDraftDatabaseSupplier;
import com.facebook.connections.db.ConnectionsDatabaseCleaner;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.data.ContactsDatabaseCleaner;
import com.facebook.contacts.omnistore.UserTranscription;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.events.data.EventsDatabaseCleaner;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.facerec.manager.LocalSuggestionsStore;
import com.facebook.feedback.ui.OfflineCommentCache;
import com.facebook.friends.navigator.FriendingNavigator.FriendingNavigatorUserDataCleanup;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.module.TraceCleaner;
import com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messaging.attribution.ReplyTokenHelper;
import com.facebook.messaging.audio.playback.AudioCache;
import com.facebook.messaging.database.threads.ThreadsDatabaseCleaner;
import com.facebook.messaging.emoji.storage.MessagingEmojiCache;
import com.facebook.messaging.emoji.storage.MessagingEmojiDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDatabaseCleaner;
import com.facebook.messaging.payment.pin.database.PaymentPinDatabaseCleaner;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.messaging.sms.database.SmsTakeoverDatabaseSupplier;
import com.facebook.messaging.tincan.TincanDeviceIdHolder;
import com.facebook.nearby.data.db.NearbyTilesDatabaseSupplier;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsConnectionControllerManager;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.offlinemode.db.OfflineModeDatabaseSupplier;
import com.facebook.omnistore.module.OmnistoreComponentManager;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.db.AdminedPagesDatabaseSupplier;
import com.facebook.pages.data.cache.PagesInfoCache;
import com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger;
import com.facebook.photos.data.cache.PhotoSetCache;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.db.PhotosDatabaseCleaner;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.places.db.PlacesDbCleanser;
import com.facebook.placetips.presence.PresenceResetListener;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache;
import com.facebook.rtc.fbwebrtc.WebrtcLogoutHandler;
import com.facebook.rtc.models.RecentCallsCleaner;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import com.facebook.search.module.TypeaheadQueryCacheSupplierMethodAutoProvider;
import com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier;
import com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier;
import com.facebook.sessionedcompactdisk.SessionManager;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.profilemedia.optimistic.OptimisticProfileMediaStore;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.userstatus.db.UserStatusDatabaseCleaner;
import com.facebook.vault.db.VaultImageDatabaseCleaner;
import com.facebook.vault.service.VaultManager;
import com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher;
import com.facebook.xconfig.core.XConfigStorage;
import com.facebook.xconfig.sync.XStorageCleaner;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$IHaveUserData implements MultiBindIndexedProvider<IHaveUserData>, Provider<Set<IHaveUserData>> {
    private final InjectorLike f1388a;

    public STATICDI_MULTIBIND_PROVIDER$IHaveUserData(InjectorLike injectorLike) {
        this.f1388a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1388a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 86;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AutoQEUserDataCleanup.a(injector);
            case 1:
                return new QuickExperimentUserDataDbCleaner(QuickExperimentDbSupplier.m1374a(injector), QuickExperimentBroadcastManager.m1383b(injector), RecentUIDsUtil.a(injector));
            case 2:
                return AnalyticsDatabaseSupplier.m1291a(injector);
            case 3:
                return OmnistoreUpdateInitializer.m8321a(injector);
            case 4:
                return FeedDbCacheCleaner.a(injector);
            case 5:
                return NewsFeedCacheSyncInitializer.m7809b(injector);
            case 6:
                return TabBarStateManager.a(injector);
            case 7:
                return BookmarkClient.a(injector);
            case 8:
                return BookmarkDatabaseCleaner.m8391a((InjectorLike) injector);
            case 9:
                return new BrowserLiteClientDataManager((Context) injector.getInstance(Context.class, ForAppContext.class));
            case 10:
                return BrowserPrefetchCacheManager.a(injector);
            case 11:
                return LogcatFbSdcardLogger.m7648a((InjectorLike) injector);
            case 12:
                return ComposerDatabaseSupplier.m850a(injector);
            case 13:
                return PendingStoryStore.a(injector);
            case 14:
                return CompostDraftStoryStore.a(injector);
            case 15:
                return RecentlyUploadedStoryStore.a(injector);
            case 16:
                return ComposerSavedSessionStore.a(injector);
            case 17:
                return CompostDraftDatabaseSupplier.a(injector);
            case 18:
                return ConnectionsDatabaseCleaner.a(injector);
            case 19:
                return AddressBookPeriodicRunner.m12785a((InjectorLike) injector);
            case 20:
                return ContactsDatabaseCleaner.a(injector);
            case 21:
                return UserTranscription.a(injector);
            case 22:
                return ContactsUploadRunner.a(injector);
            case 23:
                return EventsDatabaseCleaner.a(injector);
            case 24:
                return EventFeedPager.b(injector);
            case 25:
                return LocalSuggestionsStore.b(injector);
            case 26:
                return OfflineCommentCache.a(injector);
            case 27:
                return FriendingNavigatorUserDataCleanup.a(injector);
            case 28:
                return GraphCursorDatabase.m8126a((InjectorLike) injector);
            case 29:
                return GraphQLDiskCacheImpl.a(injector);
            case 30:
                return GroupsFeedPager.b(injector);
            case 31:
                return InterstitialManager.a(injector);
            case 32:
                return new TraceCleaner((Context) injector.getInstance(Context.class));
            case 33:
                return IdentityGrowthMegaphoneStoryData.a(injector);
            case 34:
                return MegaphoneStore.a(injector);
            case 35:
                return ReplyTokenHelper.a(injector);
            case 36:
                return AudioCache.a(injector);
            case 37:
                return ThreadsDatabaseCleaner.a(injector);
            case 38:
                return MessagingEmojiCache.a(injector);
            case 39:
                return MessagingEmojiDatabaseSupplier.a(injector);
            case 40:
                return PaymentsDatabaseCleaner.a(injector);
            case 41:
                return PaymentPinDatabaseCleaner.a(injector);
            case 42:
                return RecentMessagesTracker.a(injector);
            case 43:
                return SmsTakeoverDatabaseSupplier.a(injector);
            case 44:
                return TincanDeviceIdHolder.a(injector);
            case 45:
                return StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injector);
            case 46:
                return NearbyTilesDatabaseSupplier.a(injector);
            case 47:
                return GraphQLNotificationsContentProviderHelper.m7861a((InjectorLike) injector);
            case 48:
                return NotificationsConnectionControllerManager.m7962a(injector);
            case 49:
                return SystemTrayNotificationManager.m12194a((InjectorLike) injector);
            case 50:
                return OfflineModeDatabaseSupplier.a(injector);
            case 51:
                return OmnistoreComponentManager.getInstance__com_facebook_omnistore_module_OmnistoreComponentManager__INJECTED_BY_TemplateInjector(injector);
            case 52:
                return AdminedPagesRamCache.m13121a((InjectorLike) injector);
            case 53:
                return AdminedPagesDatabaseSupplier.m13665a(injector);
            case 54:
                return PagesInfoCache.a(injector);
            case 55:
                return PhotosEvictionLogger.m3148a((InjectorLike) injector);
            case 56:
                return PhotoSetCache.a(injector);
            case 57:
                return FetchDefaultTagSuggestions.a(injector);
            case 58:
                return PhotosDatabaseCleaner.a(injector);
            case 59:
                return PandoraStoryMemoryCache.a(injector);
            case 60:
                return PlacesDbCleanser.a(injector);
            case 61:
                return PresenceResetListener.m3931b(injector);
            case 62:
                return NewsFeedPrefetcher.m7399a((InjectorLike) injector);
            case 63:
                return PrivacyOptionsCache.m2371a((InjectorLike) injector);
            case 64:
                return QuickPromotionCounters.a(injector);
            case 65:
                return RedSpaceOptimisticBadgeStore.a(injector);
            case 66:
                return RedSpaceTabUnseenCountFetcher.a(injector);
            case 67:
                return RedSpaceFriendsCollection.a(injector);
            case 68:
                return RedSpaceMemoryFriendsCache.a(injector);
            case 69:
                return WebrtcLogoutHandler.a(injector);
            case 70:
                return RecentCallsCleaner.a(injector);
            case 71:
                return SkywalkerSubscriptionConnector.a(injector);
            case 72:
                return Saved2DatabaseProvider.a(injector);
            case 73:
                return DefaultSearchNullStateListSupplier.a(injector);
            case 74:
                return VideoScopedNullStateSupplier.m9696a((InjectorLike) injector);
            case 75:
                return SessionManager.a(injector);
            case 76:
                return TimelineUserDataCleaner.a(injector);
            case 77:
                return OptimisticProfileMediaStore.b(injector);
            case 78:
                return OptimisticProfileVideoStore.a(injector);
            case 79:
                return ImageCache.m13718a((InjectorLike) injector);
            case 80:
                return TypeaheadQueryCacheSupplierMethodAutoProvider.a(injector);
            case 81:
                return UserStatusDatabaseCleaner.a(injector);
            case 82:
                return VaultImageDatabaseCleaner.a(injector);
            case 83:
                return VaultManager.m9796a(injector);
            case 84:
                return VideoHomeMetadataFetcher.a(injector);
            case 85:
                return new XStorageCleaner(IdBasedProvider.a(injector, 4443), XConfigStorage.a(injector), RecentUserIdsManager.b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
