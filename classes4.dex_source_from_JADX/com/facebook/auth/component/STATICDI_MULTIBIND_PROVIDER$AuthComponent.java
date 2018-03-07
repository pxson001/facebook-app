package com.facebook.auth.component;

import android.content.Context;
import com.facebook.analytics.immediateactiveseconds.AuthComponentMethodAutoProvider;
import com.facebook.auth.login.FbAppUserDataCleaner;
import com.facebook.auth.login.PreferencesCleaner;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.bootstrapcache.core.BootstrapCache;
import com.facebook.bootstrapcache.core.BootstrapCacheAuthComponent;
import com.facebook.common.errorreporting.persisteduid.UserIdFileTrigger;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.conditionalworker.ConditionalWorkerManager;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.crypto.module.LoggedInUserCrypto$AuthListener;
import com.facebook.device_id.UniqueDeviceIdBroadcastSender;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.katana.authlogin.AccountManagerAuthComponent;
import com.facebook.katana.platform.FacebookAuthenticationUtils;
import com.facebook.katana.service.AppSessionAuthComponent;
import com.facebook.messaging.login.RemoteLogoutStateCleaner;
import com.facebook.messaging.sms.SmsTakeoverAuthComponent;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.orca.app.MessagesDefaultProcessDataModule;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.notify.MessagesNotificationManager;
import com.facebook.orca.notify.NotificationsUserDataCleaner;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushInitializer;
import com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber;
import com.facebook.push.mqtt.service.MqttPushServiceManager;
import com.facebook.rti.orca.FbnsLiteInitializer;
import com.facebook.rti.orca.MqttLiteInitializer;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$AuthComponent implements MultiBindIndexedProvider<AuthComponent>, Provider<Set<AuthComponent>> {
    private final InjectorLike f1298a;

    public STATICDI_MULTIBIND_PROVIDER$AuthComponent(InjectorLike injectorLike) {
        this.f1298a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1298a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<AuthComponent>> m1526a(InjectorLike injectorLike) {
        return ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$AuthComponent(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public static Set<AuthComponent> m1527b(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$AuthComponent(injectorLike));
    }

    public final int size() {
        return 22;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AuthComponentMethodAutoProvider.m1617a(injector);
            case 1:
                return com.facebook.analytics.timespent.AuthComponentMethodAutoProvider.m1620a(injector);
            case 2:
                return FbAppUserDataCleaner.m1623a(injector);
            case 3:
                return PreferencesCleaner.m1627a(injector);
            case 4:
                return new BootstrapCacheAuthComponent(BootstrapCache.m1634b((InjectorLike) injector));
            case 5:
                return UserIdFileTrigger.m1646a((InjectorLike) injector);
            case 6:
                return ConditionalWorkerManager.m8492a((InjectorLike) injector);
            case 7:
                return LoggedInUserCrypto$AuthListener.m1653a((InjectorLike) injector);
            case 8:
                return UniqueDeviceIdBroadcastSender.m1129b(injector);
            case 9:
                return new AccountManagerAuthComponent((Context) injector.getInstance(Context.class, ForAppContext.class), FacebookAuthenticationUtils.m1661a(injector), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(injector));
            case 10:
                return new AppSessionAuthComponent((Context) injector.getInstance(Context.class, ForAppContext.class));
            case 11:
                return new RemoteLogoutStateCleaner((FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            case 12:
                return new SmsTakeoverAuthComponent((Context) injector.getInstance(Context.class), Handler_ForNonUiThreadMethodAutoProvider.b(injector), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector), SmsDefaultAppManager.m1673a((InjectorLike) injector), Boolean_IsWorkBuildMethodAutoProvider.a(injector));
            case 13:
                return MessagesDefaultProcessDataModule.m28a(OrcaDataManager.a(injector));
            case 14:
                return new NotificationsUserDataCleaner(MessagesNotificationManager.m10507a((InjectorLike) injector), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            case 15:
                return UploadManager.m7304a((InjectorLike) injector);
            case 16:
                return PushInitializer.m10633a((InjectorLike) injector);
            case 17:
                return ClientSubscriptionAutoSubscriber.m7773a((InjectorLike) injector);
            case 18:
                return MqttPushServiceManager.m11221a((InjectorLike) injector);
            case 19:
                return FbnsLiteInitializer.a(injector);
            case 20:
                return MqttLiteInitializer.a(injector);
            case 21:
                return DefaultXAnalyticsProvider.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
