package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.delta.DeltaWithSequenceId;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMediaItems failed */
public class DeltaPaymentEnableHandler extends PaymentsDeltaHandler {
    private static final Object f14886d = new Object();
    private final GatekeeperWriter f14887a;
    private final DbPaymentsPropertyUtil f14888b;
    private final PaymentsBroadcaster f14889c;

    private static DeltaPaymentEnableHandler m15291b(InjectorLike injectorLike) {
        return new DeltaPaymentEnableHandler((GatekeeperWriter) GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike));
    }

    @Inject
    public DeltaPaymentEnableHandler(GatekeeperWriter gatekeeperWriter, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, PaymentsBroadcaster paymentsBroadcaster) {
        this.f14887a = gatekeeperWriter;
        this.f14888b = dbPaymentsPropertyUtil;
        this.f14889c = paymentsBroadcaster;
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        boolean booleanValue = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16096g().enabled.booleanValue();
        this.f14887a.e().a(1037, booleanValue).a();
        this.f14888b.a(DbPaymentsProperties.f12854j, TriState.valueOf(booleanValue));
        this.f14889c.m15009a(booleanValue);
        Bundle bundle = new Bundle();
        bundle.putParcelable("newPaymentsResult", null);
        return bundle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler m15290a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14886d;	 Catch:{ all -> 0x006c }
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
        r1 = m15291b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14886d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler) r0;	 Catch:{  }
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
        r0 = f14886d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler");
    }

    public final void m15293a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
    }
}
