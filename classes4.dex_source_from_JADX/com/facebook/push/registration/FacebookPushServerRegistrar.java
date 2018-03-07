package com.facebook.push.registration;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.abtest.ExperimentsForPushAbTestModule;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.fbpushtoken.RegisterPushTokenNoUserParams;
import com.facebook.push.fbpushtoken.RegisterPushTokenParams;
import com.facebook.push.fbpushtoken.RegisterPushTokenResult;
import com.facebook.push.fbpushtoken.UnregisterPushTokenMethod;
import com.facebook.push.fbpushtoken.UnregisterPushTokenParams;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: installed */
public class FacebookPushServerRegistrar {
    public static final Class<?> f10282a = FacebookPushServerRegistrar.class;
    private static volatile FacebookPushServerRegistrar f10283s;
    private final Context f10284b;
    private final DefaultBlueServiceOperationFactory f10285c;
    private final AbstractSingleMethodRunner f10286d;
    private final UnregisterPushTokenMethod f10287e;
    private final Provider<String> f10288f;
    private final UniqueIdForDeviceHolderImpl f10289g;
    private final FbNetworkManager f10290h;
    private final PushPreferenceSelector f10291i;
    private final PushNotifAnalyticsLogger f10292j;
    private final FbAlarmManagerImpl f10293k;
    private final PushNotificationPreferences f10294l;
    private final Clock f10295m;
    public final Product f10296n;
    private final FbAppType f10297o;
    private final ListeningExecutorService f10298p;
    private final Provider<TriState> f10299q;
    private final QeAccessor f10300r;

    /* compiled from: installed */
    public interface Callback {
        void mo802a();
    }

    /* compiled from: installed */
    public class LocalBroadcastReceiver extends DynamicSecureBroadcastReceiver {
        public LocalBroadcastReceiver() {
            super("com.facebook.push.registration.ACTION_ALARM", new 1());
        }
    }

    public static com.facebook.push.registration.FacebookPushServerRegistrar m10784a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10283s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.registration.FacebookPushServerRegistrar.class;
        monitor-enter(r1);
        r0 = f10283s;	 Catch:{ all -> 0x003a }
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
        r0 = m10791b(r0);	 Catch:{ all -> 0x0035 }
        f10283s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10283s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.registration.FacebookPushServerRegistrar.a(com.facebook.inject.InjectorLike):com.facebook.push.registration.FacebookPushServerRegistrar");
    }

    private static FacebookPushServerRegistrar m10791b(InjectorLike injectorLike) {
        return new FacebookPushServerRegistrar((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UnregisterPushTokenMethod.m10894a(injectorLike), IdBasedProvider.a(injectorLike, 4442), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), PushPreferenceSelector.m10869a(injectorLike), PushNotifAnalyticsLogger.m10876a(injectorLike), FbAlarmManagerImpl.a(injectorLike), PushNotificationPreferences.m10897a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 751), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FacebookPushServerRegistrar(Context context, BlueServiceOperationFactory blueServiceOperationFactory, SingleMethodRunner singleMethodRunner, UnregisterPushTokenMethod unregisterPushTokenMethod, Provider<String> provider, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, FbNetworkManager fbNetworkManager, PushPreferenceSelector pushPreferenceSelector, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FbAlarmManager fbAlarmManager, PushNotificationPreferences pushNotificationPreferences, Clock clock, Product product, FbAppType fbAppType, ListeningExecutorService listeningExecutorService, Provider<TriState> provider2, QeAccessor qeAccessor) {
        this.f10284b = context;
        this.f10285c = blueServiceOperationFactory;
        this.f10286d = singleMethodRunner;
        this.f10287e = unregisterPushTokenMethod;
        this.f10288f = provider;
        this.f10289g = uniqueIdForDeviceHolder;
        this.f10290h = fbNetworkManager;
        this.f10291i = pushPreferenceSelector;
        this.f10292j = pushNotifAnalyticsLogger;
        this.f10293k = fbAlarmManager;
        this.f10294l = pushNotificationPreferences;
        this.f10295m = clock;
        this.f10296n = product;
        this.f10297o = fbAppType;
        this.f10298p = listeningExecutorService;
        this.f10299q = provider2;
        this.f10300r = qeAccessor;
    }

    private boolean m10792b() {
        return StringUtil.a((CharSequence) this.f10288f.get());
    }

    public final void m10797a(ServiceType serviceType, Callback callback) {
        boolean asBoolean = ((TriState) this.f10299q.get()).asBoolean(false);
        boolean b = m10792b();
        if (b) {
            Object obj;
            if (Product.FB4A == this.f10296n || Product.MESSENGER == this.f10296n) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null || !asBoolean) {
                m10786a(this, serviceType, PushServerRegistrationClientEvent.AUTH_NO_USER);
                return;
            }
        }
        PushTokenHolder a = this.f10291i.m10871a(serviceType);
        if (StringUtil.a(a.m10910a())) {
            BLog.a(f10282a, "Registration id is empty for %s, should not register with facebook", new Object[]{serviceType.name()});
            m10786a(this, serviceType, PushServerRegistrationClientEvent.NO_TOKEN);
            return;
        }
        if ("change".equals(this.f10300r.a(Liveness.Live, ExperimentsForPushAbTestModule.f10517a, "time")) && !a.m10924p()) {
            return;
        }
        if (b && asBoolean) {
            m10787a(serviceType, a);
        } else {
            m10788a(serviceType, a, callback);
        }
    }

    private void m10788a(ServiceType serviceType, PushTokenHolder pushTokenHolder, Callback callback) {
        boolean z = (pushTokenHolder.m10920k() && ((String) this.f10288f.get()).equals(pushTokenHolder.m10919i())) ? false : true;
        Parcelable registerPushTokenParams = new RegisterPushTokenParams(pushTokenHolder.m10915e(), pushTokenHolder.m10910a(), this.f10289g.a(), z, pushTokenHolder.f10366e.b(), this.f10294l.m10899a(), this.f10294l.m10900b(), pushTokenHolder.m10917g());
        Bundle bundle = new Bundle();
        bundle.putParcelable("registerPushTokenParams", registerPushTokenParams);
        m10789a("register_push", bundle, serviceType, callback);
    }

    private void m10787a(ServiceType serviceType, PushTokenHolder pushTokenHolder) {
        RegisterPushTokenNoUserParams registerPushTokenNoUserParams = new RegisterPushTokenNoUserParams(pushTokenHolder.m10917g(), pushTokenHolder.m10910a(), this.f10297o.c() + "|" + this.f10297o.e(), this.f10289g.a());
        Bundle bundle = new Bundle();
        bundle.putParcelable("registerPushTokenNoUserParams", registerPushTokenNoUserParams);
        m10789a("register_push_no_user", bundle, serviceType, null);
    }

    private void m10789a(final String str, Bundle bundle, final ServiceType serviceType, final Callback callback) {
        m10786a(this, serviceType, PushServerRegistrationClientEvent.ATTEMPT);
        m10793c(serviceType);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f10285c, str, bundle, 1417660725).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ FacebookPushServerRegistrar f10535d;

            public void onSuccess(Object obj) {
                this.f10535d.m10796a(serviceType, (OperationResult) obj, callback);
            }

            public void onFailure(Throwable th) {
                BLog.b(FacebookPushServerRegistrar.f10282a, "RegisterPushToken %s failed %s", new Object[]{str, th.getMessage()});
                FacebookPushServerRegistrar.m10794d(this.f10535d, serviceType);
                FacebookPushServerRegistrar facebookPushServerRegistrar = this.f10535d;
                ServiceType serviceType = serviceType;
                FacebookPushServerRegistrar facebookPushServerRegistrar2 = this.f10535d;
                FacebookPushServerRegistrar.m10786a(facebookPushServerRegistrar, serviceType, (Object) FacebookPushServerRegistrar.m10785a(th));
            }
        }, this.f10298p);
    }

    @VisibleForTesting
    public final void m10796a(ServiceType serviceType, OperationResult operationResult, Callback callback) {
        m10794d(this, serviceType);
        RegisterPushTokenResult registerPushTokenResult = (RegisterPushTokenResult) operationResult.k();
        Boolean.valueOf(registerPushTokenResult.f11022a);
        if (!registerPushTokenResult.f11022a) {
            m10786a(this, serviceType, PushServerRegistrationClientEvent.SERVER_FAILED);
        } else if (callback == null || !registerPushTokenResult.f11023b) {
            PushTokenHolder a = this.f10291i.m10871a(serviceType);
            TriState triState = TriState.YES;
            String str = (String) a.f10364c.get();
            String a2 = a.m10910a();
            int hashCode = Objects.hashCode(new Object[]{triState, str, a2});
            Integer.valueOf(hashCode);
            a.f10363b.edit().putBoolean(a.f10367f.f10380i, true).a(a.f10367f.f10382k, a.f10368g.a()).a(a.f10367f.f10373b, str).a(a.f10367f.f10381j, hashCode).commit();
            m10786a(this, serviceType, PushServerRegistrationClientEvent.SUCCESS);
        } else {
            m10786a(this, serviceType, PushServerRegistrationClientEvent.INVALID_TOKEN);
            callback.mo802a();
        }
    }

    public final boolean m10798a(ServiceType serviceType) {
        PushTokenHolder a = this.f10291i.m10871a(serviceType);
        String a2 = a.m10910a();
        if (StringUtil.a(a2)) {
            serviceType.name();
            return true;
        }
        this.f10292j.m10885b(PushServerUnregistrationClientEvent.ATTEMPT.name(), a2);
        try {
            this.f10286d.a(this.f10287e, new UnregisterPushTokenParams(a2));
            this.f10292j.m10885b(PushServerUnregistrationClientEvent.SUCCESS.name(), a2);
            a.m10922n();
            return true;
        } catch (Exception e) {
            this.f10292j.m10885b(PushServerUnregistrationClientEvent.FAILED.name(), a2);
            return false;
        }
    }

    public final void m10799b(ServiceType serviceType, Callback callback) {
        RegistrationStatus b = m10790b(serviceType);
        b.name();
        if (b != RegistrationStatus.CURRENT) {
            this.f10292j.m10883a(b.name(), this.f10291i.m10871a(serviceType).m10910a(), serviceType.name(), m10792b());
        }
        switch (2.a[b.ordinal()]) {
            case 1:
                return;
            case 2:
                if (this.f10290h.d()) {
                    m10797a(serviceType, callback);
                    return;
                }
                return;
            case 3:
                m10797a(serviceType, callback);
                return;
            case 4:
                m10797a(serviceType, callback);
                return;
            default:
                BLog.a(f10282a, "unexpected facebook registration status: " + b);
                return;
        }
    }

    private RegistrationStatus m10790b(ServiceType serviceType) {
        PushTokenHolder a = this.f10291i.m10871a(serviceType);
        if (!a.m10920k()) {
            return RegistrationStatus.NONE;
        }
        if (!"change".equals(this.f10300r.a(Liveness.Live, ExperimentsForPushAbTestModule.f10517a, "time"))) {
            Object i = a.m10919i();
            String str = (String) this.f10288f.get();
            Object obj = (StringUtil.a(i) && StringUtil.a(str)) ? 1 : null;
            if (obj == null && !i.equals(str)) {
                return RegistrationStatus.WRONG_USER;
            }
            if (this.f10295m.a() - a.m10923o() > this.f10300r.a(Liveness.Live, ExperimentsForPushAbTestModule.f10518b, 24) * 3600000) {
                return RegistrationStatus.EXPIRED;
            }
            if (a.m10914c()) {
                return RegistrationStatus.EXPIRED;
            }
            return RegistrationStatus.CURRENT;
        } else if (a.m10924p()) {
            return RegistrationStatus.EXPIRED;
        } else {
            return RegistrationStatus.CURRENT;
        }
    }

    public static String m10785a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder(PushServerRegistrationClientEvent.FAILED.name());
        if (th instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) th;
            stringBuilder.append('_').append(serviceException.errorCode.toString());
            ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.k();
            if (apiErrorResult != null) {
                stringBuilder.append('_').append(apiErrorResult.m10832a());
            }
        } else {
            stringBuilder.append("_").append(th.getClass().getSimpleName()).append("_").append(th.getMessage());
        }
        return stringBuilder.toString();
    }

    public static void m10786a(FacebookPushServerRegistrar facebookPushServerRegistrar, ServiceType serviceType, Object obj) {
        facebookPushServerRegistrar.f10292j.m10887b(obj.toString(), facebookPushServerRegistrar.f10291i.m10871a(serviceType).m10910a(), serviceType.name(), facebookPushServerRegistrar.m10792b());
    }

    private void m10793c(ServiceType serviceType) {
        long a = this.f10295m.a() + 10800000;
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f10293k;
        PendingIntent e = m10795e(serviceType);
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(1, a, e);
        } else {
            fbAlarmManagerImpl.a.setExact(1, a, e);
        }
    }

    public static void m10794d(FacebookPushServerRegistrar facebookPushServerRegistrar, ServiceType serviceType) {
        facebookPushServerRegistrar.f10293k.a(facebookPushServerRegistrar.m10795e(serviceType));
    }

    private PendingIntent m10795e(ServiceType serviceType) {
        Intent intent = new Intent(this.f10284b, LocalBroadcastReceiver.class);
        intent.setAction("com.facebook.push.registration.ACTION_ALARM");
        intent.putExtra("serviceType", serviceType.name());
        return PendingIntent.getBroadcast(this.f10284b, -1, intent, 134217728);
    }
}
