package com.facebook.push.fbns;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.FacebookPushServerRegistrar.Callback;
import com.facebook.push.registration.Registrar;
import com.facebook.push.registration.Registrar.TokenStatus;
import com.facebook.push.registration.RegistrarHelper;
import com.facebook.push.registration.RegistrarHelperProvider;
import com.facebook.push.registration.ServiceType;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: image_height */
public class FbnsRegistrar implements Registrar {
    private static final Class<?> f10493b = FbnsRegistrar.class;
    public final Callback f10494a = new C04761(this);
    private final PushNotifAnalyticsLogger f10495c;
    private final FacebookPushServerRegistrar f10496d;
    public final PushTokenHolder f10497e;
    public final RegistrarHelper f10498f;
    private final FacebookNotificationService f10499g;
    private final Provider<String> f10500h;
    public final ExecutorService f10501i;

    /* compiled from: image_height */
    class C04761 implements Callback {
        final /* synthetic */ FbnsRegistrar f10514a;

        C04761(FbnsRegistrar fbnsRegistrar) {
            this.f10514a = fbnsRegistrar;
        }

        public final void mo802a() {
            this.f10514a.f10498f.m10935a(this.f10514a);
        }
    }

    public static FbnsRegistrar m11045b(InjectorLike injectorLike) {
        return new FbnsRegistrar(PushNotifAnalyticsLogger.m10876a(injectorLike), FacebookPushServerRegistrar.m10784a(injectorLike), PushPreferenceSelector.m10869a(injectorLike), PushPrefKeysSelector.m10873a(injectorLike), (RegistrarHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegistrarHelperProvider.class), new FacebookNotificationService((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike)), IdBasedProvider.a(injectorLike, 4442), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FbnsRegistrar(PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FacebookPushServerRegistrar facebookPushServerRegistrar, PushPreferenceSelector pushPreferenceSelector, PushPrefKeysSelector pushPrefKeysSelector, RegistrarHelperProvider registrarHelperProvider, FacebookNotificationService facebookNotificationService, Provider<String> provider, ExecutorService executorService) {
        this.f10495c = pushNotifAnalyticsLogger;
        this.f10496d = facebookPushServerRegistrar;
        this.f10499g = facebookNotificationService;
        this.f10500h = provider;
        this.f10501i = executorService;
        this.f10497e = pushPreferenceSelector.m10871a(ServiceType.FBNS);
        this.f10498f = registrarHelperProvider.m10868a(ServiceType.FBNS, pushPrefKeysSelector.m10875a(ServiceType.FBNS), this.f10497e);
    }

    public final void mo799a() {
        this.f10498f.m10936a(PushServerRegistrationClientEvent.ATTEMPT.name(), null);
        FacebookNotificationService facebookNotificationService = this.f10499g;
        CharSequence a = facebookNotificationService.f10509c.a(facebookNotificationService.f10512f, null);
        if (StringUtil.a(a)) {
            a = "fbns" + SecureHashUtil.a(facebookNotificationService.f10511e.a() + facebookNotificationService.f10510d.c());
            facebookNotificationService.f10509c.edit().a(facebookNotificationService.f10512f, a).commit();
        }
        this.f10497e.m10911a((String) a, ServiceType.FBNS);
        this.f10498f.m10936a(PushServerRegistrationClientEvent.SUCCESS.name(), null);
        this.f10496d.m10797a(ServiceType.FBNS, this.f10494a);
    }

    public static void m11044a(FbnsRegistrar fbnsRegistrar, String str) {
        fbnsRegistrar.f10498f.m10938b(PushServerUnregistrationClientEvent.ATTEMPT.name(), str);
        if (fbnsRegistrar.f10496d.m10798a(ServiceType.FBNS)) {
            fbnsRegistrar.f10497e.m10918h();
            fbnsRegistrar.f10498f.m10938b(PushServerUnregistrationClientEvent.SUCCESS.name(), str);
            return;
        }
        fbnsRegistrar.f10498f.m10938b(PushServerUnregistrationClientEvent.FAILED.name(), str);
    }

    public final void m11047a(boolean z) {
        if (!StringUtil.a((CharSequence) this.f10500h.get())) {
            TokenStatus tokenStatus;
            if (StringUtil.a(this.f10497e.m10910a())) {
                tokenStatus = TokenStatus.NONE;
            } else if (this.f10497e.m10914c()) {
                tokenStatus = TokenStatus.UPGRADED;
            } else {
                tokenStatus = TokenStatus.CURRENT;
            }
            TokenStatus tokenStatus2 = tokenStatus;
            this.f10495c.m10880a(ServiceType.FBNS.name(), tokenStatus2.name(), this.f10497e.m10910a());
            switch (tokenStatus2) {
                case CURRENT:
                    if (z) {
                        this.f10496d.m10797a(ServiceType.FBNS, this.f10494a);
                        return;
                    } else {
                        this.f10496d.m10799b(ServiceType.FBNS, this.f10494a);
                        return;
                    }
                case UPGRADED:
                case NONE:
                    mo799a();
                    return;
                default:
                    throw new IllegalStateException(tokenStatus2.name());
            }
        }
    }
}
