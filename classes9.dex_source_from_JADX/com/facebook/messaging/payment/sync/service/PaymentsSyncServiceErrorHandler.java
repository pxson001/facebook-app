package com.facebook.messaging.payment.sync.service;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.sync.connection.PaymentsSyncConnectionHandler;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncErrorRecoveryHandler;
import com.facebook.sync.service.SyncServiceErrorHandler;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: fetchDeliveryReceipts */
public class PaymentsSyncServiceErrorHandler extends SyncServiceErrorHandler {
    private static final Object f14929a = new Object();

    private static PaymentsSyncServiceErrorHandler m15325b(InjectorLike injectorLike) {
        return new PaymentsSyncServiceErrorHandler(PaymentsSyncConnectionHandler.m15241a(injectorLike), SyncConnectionStateManager.a(injectorLike), SyncErrorRecoveryHandler.a(injectorLike), SyncErrorReporter.a(injectorLike), IdBasedProvider.a(injectorLike, 4346));
    }

    @Inject
    public PaymentsSyncServiceErrorHandler(PaymentsSyncConnectionHandler paymentsSyncConnectionHandler, SyncConnectionStateManager syncConnectionStateManager, SyncErrorRecoveryHandler syncErrorRecoveryHandler, SyncErrorReporter syncErrorReporter, Provider<Boolean> provider) {
        super(paymentsSyncConnectionHandler, syncConnectionStateManager, syncErrorRecoveryHandler, syncErrorReporter, provider);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler m15324a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14929a;	 Catch:{ all -> 0x006c }
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
        r1 = m15325b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14929a;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler) r0;	 Catch:{  }
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
        r0 = f14929a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.service.PaymentsSyncServiceErrorHandler");
    }
}
