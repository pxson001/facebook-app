package com.facebook.messaging.payment.sync.connection;

import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.sync.PaymentsSyncDbHandler;
import com.facebook.messaging.payment.sync.model.PaymentsSyncPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.analytics.SyncAnalyticsLogger;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.connection.SyncConnectionHandler;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncConnectionStateManager.QueueKey;
import com.facebook.sync.connection.SyncErrorRecoveryHandler;
import com.facebook.sync.connection.SyncMqttPublisher.CreateQueueResult;
import com.facebook.sync.connection.SyncQueueTrackerImpl;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.prefs.SyncDebugOverlaySettingsTags;
import com.facebook.sync.util.ExponentialBackoffHelperFactory;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: fetchMoreThreads deprecated (GQL) */
public class PaymentsSyncConnectionHandler extends SyncConnectionHandler {
    private static final Class<?> f14811a = PaymentsSyncConnectionHandler.class;
    private static final Object f14812o = new Object();
    private final PaymentsSyncMqttPublisher f14813b;
    private final PaymentsSyncDbHandler f14814c;
    private final PaymentsSyncWebFetcher f14815d;
    private final Clock f14816e;
    private final FbSharedPreferences f14817f;
    private final DbPaymentsPropertyUtil f14818g;
    private final SyncAnalyticsLogger f14819h;
    private final SyncConnectionStateManager f14820i;
    private final SyncErrorReporter f14821j;
    private final SyncErrorRecoveryHandler f14822k;
    private final String f14823l;
    private final SyncQueueTrackerImpl f14824m;
    private final ExecutorService f14825n;

    /* compiled from: fetchMoreThreads deprecated (GQL) */
    class C17151 implements Runnable {
        final /* synthetic */ PaymentsSyncConnectionHandler f14810a;

        C17151(PaymentsSyncConnectionHandler paymentsSyncConnectionHandler) {
            this.f14810a = paymentsSyncConnectionHandler;
        }

        public void run() {
            this.f14810a.e();
        }
    }

    private static PaymentsSyncConnectionHandler m15242b(InjectorLike injectorLike) {
        return new PaymentsSyncConnectionHandler(DebugOverlayController.a(injectorLike), ExponentialBackoffHelperFactory.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), PaymentsSyncMqttPublisher.m15250a(injectorLike), PaymentsSyncDbHandler.m15225a(injectorLike), PaymentsSyncWebFetcher.m15255a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), SyncAnalyticsLogger.a(injectorLike), SyncConnectionStateManager.a(injectorLike), SyncErrorReporter.a(injectorLike), SyncErrorRecoveryHandler.a(injectorLike), String_ViewerContextUserIdMethodAutoProvider.a(injectorLike), SyncQueueTrackerImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4345));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler m15241a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f14812o;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m15242b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14812o;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f14812o;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler");
    }

    @Inject
    public PaymentsSyncConnectionHandler(DebugOverlayController debugOverlayController, ExponentialBackoffHelperFactory exponentialBackoffHelperFactory, ScheduledExecutorService scheduledExecutorService, PaymentsSyncMqttPublisher paymentsSyncMqttPublisher, PaymentsSyncDbHandler paymentsSyncDbHandler, PaymentsSyncWebFetcher paymentsSyncWebFetcher, Clock clock, FbSharedPreferences fbSharedPreferences, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, SyncAnalyticsLogger syncAnalyticsLogger, SyncConnectionStateManager syncConnectionStateManager, SyncErrorReporter syncErrorReporter, SyncErrorRecoveryHandler syncErrorRecoveryHandler, String str, SyncQueueTrackerImpl syncQueueTrackerImpl, ExecutorService executorService, Provider<Boolean> provider) {
        super(syncErrorRecoveryHandler, paymentsSyncMqttPublisher, syncConnectionStateManager, syncAnalyticsLogger, debugOverlayController, clock, exponentialBackoffHelperFactory, scheduledExecutorService, str, paymentsSyncDbHandler, provider);
        this.f14813b = paymentsSyncMqttPublisher;
        this.f14814c = paymentsSyncDbHandler;
        this.f14815d = paymentsSyncWebFetcher;
        this.f14816e = clock;
        this.f14818g = dbPaymentsPropertyUtil;
        this.f14817f = fbSharedPreferences;
        this.f14819h = syncAnalyticsLogger;
        this.f14820i = syncConnectionStateManager;
        this.f14821j = syncErrorReporter;
        this.f14822k = syncErrorRecoveryHandler;
        this.f14823l = str;
        this.f14824m = syncQueueTrackerImpl;
        this.f14825n = executorService;
        m15243f();
    }

    private void m15243f() {
        this.f14824m.a(b(), this);
        ExecutorDetour.a(this.f14825n, new C17151(this), -1628345599);
    }

    public final void m15246e() {
        if (!this.f14824m.d() && this.f14813b.a(this.f14824m)) {
            this.f14824m.c();
        }
    }

    public final OperationResult m15245a(FullRefreshReason fullRefreshReason, @Nullable CallerContext callerContext) {
        this.f14819h.a(IrisQueueTypes.PAYMENTS_QUEUE_TYPE, fullRefreshReason);
        this.f14824m.a(b());
        long a = m15240a(this.f14815d.m15258a());
        if (a < 0) {
            SyncErrorReporter syncErrorReporter = this.f14821j;
            IrisQueueTypes irisQueueTypes = IrisQueueTypes.PAYMENTS_QUEUE_TYPE;
            ImmutableMap immutableMap = RegularImmutableBiMap.a;
            StringBuilder append = new StringBuilder("Invalid sequence id from fetch: ").append("-1").append(". queue_type = ").append(irisQueueTypes.apiString);
            Iterator it = immutableMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                append.append(", ").append((String) entry.getKey()).append(" = ").append((String) entry.getValue());
            }
            String stringBuilder = append.toString();
            syncErrorReporter.b.a(SyncDebugOverlaySettingsTags.b, stringBuilder);
            syncErrorReporter.a.a("sync_invalid_seq_id_from_fetch", stringBuilder);
            m15244g();
            return OperationResult.a(ErrorCode.API_ERROR, "Invalid sequence ID from paymets fetch");
        }
        MqttResponse a2 = this.f14813b.m15252a(a, null);
        if (!a2.a) {
            BLog.b(f14811a, "Error connecting to MQTT for create queue.", a2.d);
            return a2.a();
        } else if (((CreateQueueResult) a2.b).a) {
            String str = ((CreateQueueResult) a2.b).b;
            Long.valueOf(a);
            this.f14818g.b(DbPaymentsProperties.f12849e, str);
            this.f14818g.b(DbPaymentsProperties.f12850f, a);
            this.f14822k.d(this.f14814c);
            this.f14820i.a(QueueKey.a(this.f14823l, IrisQueueTypes.PAYMENTS_QUEUE_TYPE), a2.e);
            this.f14824m.a(b(), this);
            return OperationResult.a;
        } else {
            BLog.b(f14811a, "API Error w/ create queue: %s.", new Object[]{((CreateQueueResult) a2.b).c});
            m15244g();
            return OperationResult.a(ErrorCode.API_ERROR, ((CreateQueueResult) a2.b).c);
        }
    }

    private static long m15240a(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    private void m15244g() {
        this.f14817f.edit().a(PaymentsSyncPrefKeys.b, this.f14816e.a()).commit();
    }
}
