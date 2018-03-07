package com.facebook.messaging.payment.sync.service;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.sync.Integer_PaymentsSyncApiVersionMethodAutoProvider;
import com.facebook.messaging.payment.sync.PaymentsSyncDbHandler;
import com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler;
import com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentForcedFetch;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.PaymentSyncPayload;
import com.facebook.sync.DefaultSyncContextChecker;
import com.facebook.sync.SyncContextChecker;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.service.SyncOperationParamsUtil;
import com.facebook.sync.service.SyncOperationParamsUtil.FullRefreshParams;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: fetchApplinkForUrl */
public class PaymentsSyncServiceHandler implements BlueServiceHandler {
    private static final Class<?> f14930a = PaymentsSyncServiceHandler.class;
    private static final Object f14931l = new Object();
    private final PaymentsSyncDbHandler f14932b;
    public final PaymentsSyncConnectionHandler f14933c;
    private final PaymentsSyncPayloadHandler f14934d;
    private final Provider<Boolean> f14935e;
    private final SyncOperationParamsUtil f14936f;
    private final PaymentsSyncServiceErrorHandler f14937g;
    private final Integer f14938h;
    public final DbPaymentsPropertyUtil f14939i;
    private final Provider<ViewerContext> f14940j;
    private final DefaultSyncContextChecker f14941k;

    private static PaymentsSyncServiceHandler m15328b(InjectorLike injectorLike) {
        return new PaymentsSyncServiceHandler(PaymentsSyncDbHandler.m15225a(injectorLike), PaymentsSyncConnectionHandler.m15241a(injectorLike), PaymentsSyncPayloadHandler.m15270a(injectorLike), IdBasedProvider.a(injectorLike, 4184), SyncOperationParamsUtil.a(injectorLike), PaymentsSyncServiceErrorHandler.m15324a(injectorLike), Integer_PaymentsSyncApiVersionMethodAutoProvider.m15224b(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), IdBasedProvider.a(injectorLike, 372), DefaultSyncContextChecker.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler m15326a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14931l;	 Catch:{ all -> 0x006c }
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
        r1 = m15328b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14931l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler) r0;	 Catch:{  }
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
        r0 = f14931l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler");
    }

    @Inject
    public PaymentsSyncServiceHandler(PaymentsSyncDbHandler paymentsSyncDbHandler, PaymentsSyncConnectionHandler paymentsSyncConnectionHandler, PaymentsSyncPayloadHandler paymentsSyncPayloadHandler, Provider<Boolean> provider, SyncOperationParamsUtil syncOperationParamsUtil, PaymentsSyncServiceErrorHandler paymentsSyncServiceErrorHandler, Integer num, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, Provider<ViewerContext> provider2, SyncContextChecker syncContextChecker) {
        this.f14932b = paymentsSyncDbHandler;
        this.f14933c = paymentsSyncConnectionHandler;
        this.f14934d = paymentsSyncPayloadHandler;
        this.f14935e = provider;
        this.f14936f = syncOperationParamsUtil;
        this.f14937g = paymentsSyncServiceErrorHandler;
        this.f14938h = num;
        this.f14939i = dbPaymentsPropertyUtil;
        this.f14940j = provider2;
        this.f14941k = syncContextChecker;
    }

    public final OperationResult m15329a(OperationParams operationParams) {
        if (!this.f14941k.a()) {
            return OperationResult.a(ErrorCode.CANCELLED);
        }
        Preconditions.checkState(((Boolean) this.f14935e.get()).booleanValue(), "Payments sync protocol disabled, but got a %s operation", new Object[]{operationParams.b});
        String str = operationParams.b;
        if ("ensure_payments_sync".equals(str)) {
            return this.f14933c.a(this.f14938h.intValue(), this.f14932b, SyncOperationParamsUtil.d(operationParams), operationParams.e);
        } else if ("payments_force_full_refresh".equals(str)) {
            OperationResult a;
            FullRefreshParams c = SyncOperationParamsUtil.c(operationParams);
            if (StringUtil.a(c.b, this.f14939i.a(DbPaymentsProperties.f12849e))) {
                a = this.f14933c.m15245a(c.a, operationParams.e);
            } else {
                a = OperationResult.a;
            }
            return a;
        } else if ("payments_deltas".equals(str)) {
            return m15327b(operationParams);
        } else {
            throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }

    private OperationResult m15327b(OperationParams operationParams) {
        PaymentSyncPayload paymentSyncPayload = (PaymentSyncPayload) SyncOperationParamsUtil.a(operationParams);
        for (DeltaPaymentWrapper deltaPaymentWrapper : paymentSyncPayload.deltas) {
            if (deltaPaymentWrapper.a() == 8) {
                DeltaPaymentForcedFetch f = deltaPaymentWrapper.m16095f();
                if (f.fetchTransferFbId == null && f.fetchPaymentMethods == null) {
                    return this.f14933c.m15245a(FullRefreshReason.a(paymentSyncPayload.firstDeltaSeqId.longValue()), operationParams.f());
                }
            }
        }
        try {
            this.f14934d.m15273a(paymentSyncPayload);
            return OperationResult.a();
        } catch (Exception e) {
            return this.f14937g.a(((ViewerContext) this.f14940j.get()).a(), this.f14938h.intValue(), this.f14932b, operationParams.f(), e);
        }
    }
}
