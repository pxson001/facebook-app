package com.facebook.push.nna;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushSource;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushPrefKeys;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.FacebookPushServerRegistrar.Callback;
import com.facebook.push.registration.Registrar;
import com.facebook.push.registration.RegistrarHelper;
import com.facebook.push.registration.RegistrarHelperProvider;
import com.facebook.push.registration.ServiceType;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: header rendered */
public class NNARegistrar implements Registrar {
    private static final Class<?> f11320b = NNARegistrar.class;
    private static volatile NNARegistrar f11321m;
    public final Callback f11322a = new C09961(this);
    private final FbAppType f11323c;
    private final Context f11324d;
    public final FbSharedPreferences f11325e;
    private final PushNotifAnalyticsLogger f11326f;
    private final FbNetworkManager f11327g;
    private final FacebookPushServerRegistrar f11328h;
    public final PushTokenHolder f11329i;
    public final Clock f11330j;
    public final RegistrarHelper f11331k;
    public final PushPrefKeys f11332l;

    /* compiled from: header rendered */
    class C09961 implements Callback {
        final /* synthetic */ NNARegistrar f11318a;

        C09961(NNARegistrar nNARegistrar) {
            this.f11318a = nNARegistrar;
        }

        public final void m13201a() {
            this.f11318a.f11331k.a(this.f11318a);
        }
    }

    /* compiled from: header rendered */
    public enum RegistrationStatus {
        CURRENT,
        EXPIRED,
        NONE
    }

    /* compiled from: header rendered */
    enum RegistrationType {
        REGISTER,
        UNREGISTER,
        RETRY
    }

    public static com.facebook.push.nna.NNARegistrar m13203a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11321m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.nna.NNARegistrar.class;
        monitor-enter(r1);
        r0 = f11321m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13204b(r0);	 Catch:{ all -> 0x0035 }
        f11321m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11321m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.nna.NNARegistrar.a(com.facebook.inject.InjectorLike):com.facebook.push.nna.NNARegistrar");
    }

    private static NNARegistrar m13204b(InjectorLike injectorLike) {
        return new NNARegistrar((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PushNotifAnalyticsLogger.a(injectorLike), FbNetworkManager.a(injectorLike), FacebookPushServerRegistrar.a(injectorLike), PushPreferenceSelector.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PushPrefKeysSelector.a(injectorLike), (RegistrarHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegistrarHelperProvider.class), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public NNARegistrar(Context context, FbSharedPreferences fbSharedPreferences, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FbNetworkManager fbNetworkManager, FacebookPushServerRegistrar facebookPushServerRegistrar, PushPreferenceSelector pushPreferenceSelector, Clock clock, PushPrefKeysSelector pushPrefKeysSelector, RegistrarHelperProvider registrarHelperProvider, FbAppType fbAppType) {
        this.f11324d = context;
        this.f11325e = fbSharedPreferences;
        this.f11326f = pushNotifAnalyticsLogger;
        this.f11327g = fbNetworkManager;
        this.f11328h = facebookPushServerRegistrar;
        this.f11330j = clock;
        this.f11323c = fbAppType;
        this.f11329i = pushPreferenceSelector.a(ServiceType.NNA);
        this.f11332l = pushPrefKeysSelector.a(ServiceType.NNA);
        this.f11331k = registrarHelperProvider.a(ServiceType.NNA, this.f11332l, this.f11329i);
    }

    public final void m13206a() {
        this.f11331k.a(PushServerRegistrationClientEvent.ATTEMPT.name(), null);
        this.f11331k.a();
        Intent a = m13202a(RegistrationType.REGISTER);
        this.f11325e.edit().a(this.f11332l.h(), ServiceType.NNA.name()).commit();
        try {
            if (this.f11324d.startService(a) == null) {
                this.f11331k.a(PushServerRegistrationClientEvent.MISSING_COMPONENT.name(), null);
            }
        } catch (SecurityException e) {
            this.f11331k.a(PushServerRegistrationClientEvent.FAILED.name(), e.getMessage().toLowerCase(Locale.US));
        }
    }

    final void m13207a(String str, String str2, boolean z) {
        if (z) {
            this.f11329i.h();
            this.f11331k.b(PushServerUnregistrationClientEvent.SUCCESS.name(), null);
            return;
        }
        this.f11331k.c();
        if (str2 != null) {
            this.f11329i.h();
            BLog.b(f11320b, "Registration error %s", new Object[]{str2});
            if ("SERVICE_NOT_AVAILABLE".equals(str2)) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f11324d.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    m13205c();
                }
            } else if (!"INVALID_SENDER".equals(str2)) {
                "INVALID_PARAMETERS".equals(str2);
            }
            this.f11331k.a(str2.toLowerCase(Locale.US), null);
            return;
        }
        this.f11329i.a(str, this.f11329i.b());
        this.f11331k.a(PushServerRegistrationClientEvent.SUCCESS.name(), null);
        this.f11328h.a(ServiceType.NNA, this.f11322a);
    }

    private void m13205c() {
        this.f11331k.a((PendingIntent) m13202a(RegistrationType.RETRY).getParcelableExtra("app"));
    }

    public final void m13208a(boolean z) {
        RegistrationStatus registrationStatus;
        Boolean.valueOf(z);
        if (StringUtil.a(this.f11329i.a())) {
            registrationStatus = RegistrationStatus.NONE;
        } else {
            long a = this.f11330j.a();
            long l = this.f11329i.l();
            long a2 = this.f11325e.a(this.f11332l.f, 0);
            if (a - l <= 604800000 || a - a2 <= 172800000) {
                registrationStatus = RegistrationStatus.CURRENT;
            } else {
                registrationStatus = RegistrationStatus.EXPIRED;
            }
        }
        RegistrationStatus registrationStatus2 = registrationStatus;
        registrationStatus2.toString();
        this.f11326f.a(PushSource.NNA.toString(), registrationStatus2.toString(), this.f11329i.a());
        switch (registrationStatus2) {
            case CURRENT:
                if (z) {
                    this.f11328h.a(ServiceType.NNA, this.f11322a);
                    return;
                } else {
                    this.f11328h.b(ServiceType.NNA, this.f11322a);
                    return;
                }
            case EXPIRED:
                if (!this.f11327g.d()) {
                    return;
                }
                break;
            case NONE:
                break;
            default:
                return;
        }
        m13206a();
    }

    private Intent m13202a(RegistrationType registrationType) {
        Intent intent = new Intent("com.nokia.pushnotifications.intent.REGISTER");
        if (RegistrationType.UNREGISTER.equals(registrationType)) {
            intent = new Intent("com.nokia.pushnotifications.intent.UNREGISTER");
        }
        intent.putExtra("app", PendingIntent.getBroadcast(this.f11324d, 0, new Intent(), 0));
        if (Product.MESSENGER.equals(this.f11323c.j)) {
            intent.putExtra("sender", "fb-messenger-aol");
        } else if (Product.FB4A.equals(this.f11323c.j)) {
            intent.putExtra("sender", "fb-app-aol");
        }
        intent.setPackage("com.nokia.pushnotifications.service");
        return intent;
    }
}
