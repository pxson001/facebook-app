package com.facebook.orca.threadview;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.banner.BannerNotificationController;
import com.facebook.common.banner.BannerNotificationPrioritizer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.banner.MuteThreadWarningNotification;
import com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.connectivity.ConnectionStatusNotification_ConnectionStatusForThreadViewFragmentMethodAutoProvider;
import com.facebook.messaging.events.banner.EventReminderNotification;
import com.facebook.messaging.groups.banner.GroupJoinRequestNotificationProvider;
import com.facebook.messaging.groups.namingbar.GroupNamingBarBanner;
import com.facebook.messaging.invites.quickinvites.InviteToMessengerBannerNotification;
import com.facebook.messaging.payment.thread.banner.IncomingPaymentRequestBannerManager;
import com.facebook.messaging.payment.thread.banner.IncomingPaymentRequestBannerNotification;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerManager;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerNotification;
import com.facebook.messaging.users.MessengerInviteEligibilityChecker;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.cache.UserCache;
import com.facebook.user.module.UserNameUtil;

/* compiled from: memorialization/has_seen_manage_nux */
public class ThreadViewMessagesFragmentBannerNotificationControllerProvider extends AbstractAssistedProvider<ThreadViewMessagesFragmentBannerNotificationController> {
    public final ThreadViewMessagesFragmentBannerNotificationController m7765a(LayoutInflater layoutInflater) {
        return new ThreadViewMessagesFragmentBannerNotificationController((Context) getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), AnalyticsLoggerMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), UserNameUtil.a(this), IdBasedSingletonScopeProvider.b(this, 2360), (BannerNotificationPrioritizer) ThreadViewMessagesFragmentBannerNotificationPrioritizer.m7767a((InjectorLike) this), BannerNotificationController.a(this), EventReminderNotification.m2193a((InjectorLike) this), MuteThreadWarningNotification.a(this), InviteToMessengerBannerNotification.m2980a((InjectorLike) this), ConnectionStatusNotification_ConnectionStatusForThreadViewFragmentMethodAutoProvider.a(this), GroupNamingBarBanner.m2497a((InjectorLike) this), PaymentPlatformContextBannerNotification.a(this), IncomingPaymentRequestBannerNotification.a(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this), IdBasedProvider.a(this, 4162), ThreadRecipientUtil.a(this), layoutInflater, ContactsCache.a(this), DefaultAndroidThreadUtil.a(this), BannerTriggersOmnistoreComponent.a(this), PaymentPlatformContextBannerManager.a(this), IncomingPaymentRequestBannerManager.a(this), MessengerInviteEligibilityChecker.a(this), IdBasedProvider.a(this, 4239), DefaultAppChoreographer.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), IdBasedProvider.a(this, 4161), UserCache.a(this), (GroupJoinRequestNotificationProvider) getOnDemandAssistedProviderForStaticDi(GroupJoinRequestNotificationProvider.class));
    }
}
