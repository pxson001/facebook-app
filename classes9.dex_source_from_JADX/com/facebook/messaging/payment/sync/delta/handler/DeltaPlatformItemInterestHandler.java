package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentPlatformContextsCache;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentPlatformContextsMethod;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.delta.DeltaWithSequenceId;
import java.util.ArrayList;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchGroupInviteLink */
public class DeltaPlatformItemInterestHandler extends PaymentsDeltaHandler {
    private static final Object f14905f = new Object();
    private final PaymentPlatformContextsCache f14906a;
    private final FetchPaymentPlatformContextsMethod f14907b;
    private final AbstractFbErrorReporter f14908c;
    private final PaymentsBroadcaster f14909d;
    private final ApiMethodRunnerImpl f14910e;

    private static DeltaPlatformItemInterestHandler m15311b(InjectorLike injectorLike) {
        return new DeltaPlatformItemInterestHandler(PaymentPlatformContextsCache.m13170a(injectorLike), FetchPaymentPlatformContextsMethod.m15118a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), ApiMethodRunnerImpl.a(injectorLike));
    }

    @Inject
    public DeltaPlatformItemInterestHandler(PaymentPlatformContextsCache paymentPlatformContextsCache, FetchPaymentPlatformContextsMethod fetchPaymentPlatformContextsMethod, AbstractFbErrorReporter abstractFbErrorReporter, PaymentsBroadcaster paymentsBroadcaster, ApiMethodRunnerImpl apiMethodRunnerImpl) {
        this.f14906a = paymentPlatformContextsCache;
        this.f14907b = fetchPaymentPlatformContextsMethod;
        this.f14908c = abstractFbErrorReporter;
        this.f14909d = paymentsBroadcaster;
        this.f14910e = apiMethodRunnerImpl;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler m15310a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14905f;	 Catch:{ all -> 0x006c }
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
        r1 = m15311b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14905f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler) r0;	 Catch:{  }
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
        r0 = f14905f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler");
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        return null;
    }

    public final void m15313a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        try {
            this.f14906a.m13173a((ArrayList) this.f14910e.a(this.f14907b, null));
            this.f14909d.m15014f();
        } catch (Exception e) {
            this.f14908c.b("DeltaPlatformItemInterestHandler", "Failed to fetch payment platform contexts for the user");
        }
    }
}
