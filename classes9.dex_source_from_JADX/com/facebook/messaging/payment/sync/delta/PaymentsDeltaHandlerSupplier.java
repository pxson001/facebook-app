package com.facebook.messaging.payment.sync.delta;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentEnableHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentMethodHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentNoOpHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPinCodeHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaPlatformItemInterestHandler;
import com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.delta.DeltaHandlerSupplier;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreThreads */
public class PaymentsDeltaHandlerSupplier implements DeltaHandlerSupplier<PaymentsPrefetchedSyncData, DeltaPaymentWrapper> {
    private static final Object f14850j = new Object();
    private final Lazy<DeltaNewTransferHandler> f14851a;
    private final Lazy<DeltaPaymentMethodHandler> f14852b;
    private final Lazy<DeltaTransferStatusHandler> f14853c;
    private final Lazy<DeltaPinCodeHandler> f14854d;
    private final Lazy<DeltaPaymentNoOpHandler> f14855e;
    private final Lazy<DeltaNewPaymentRequestHandler> f14856f;
    private final Lazy<DeltaPaymentRequestStatusHandler> f14857g;
    private final Lazy<DeltaPlatformItemInterestHandler> f14858h;
    private final Lazy<DeltaPaymentEnableHandler> f14859i;

    private static PaymentsDeltaHandlerSupplier m15265b(InjectorLike injectorLike) {
        return new PaymentsDeltaHandlerSupplier(IdBasedLazy.a(injectorLike, 8163), IdBasedLazy.a(injectorLike, 8165), IdBasedLazy.a(injectorLike, 8170), IdBasedLazy.a(injectorLike, 8168), IdBasedLazy.a(injectorLike, 8166), IdBasedLazy.a(injectorLike, 8162), IdBasedLazy.a(injectorLike, 8167), IdBasedLazy.a(injectorLike, 8169), IdBasedLazy.a(injectorLike, 8164));
    }

    @Inject
    public PaymentsDeltaHandlerSupplier(Lazy<DeltaNewTransferHandler> lazy, Lazy<DeltaPaymentMethodHandler> lazy2, Lazy<DeltaTransferStatusHandler> lazy3, Lazy<DeltaPinCodeHandler> lazy4, Lazy<DeltaPaymentNoOpHandler> lazy5, Lazy<DeltaNewPaymentRequestHandler> lazy6, Lazy<DeltaPaymentRequestStatusHandler> lazy7, Lazy<DeltaPlatformItemInterestHandler> lazy8, Lazy<DeltaPaymentEnableHandler> lazy9) {
        this.f14851a = lazy;
        this.f14852b = lazy2;
        this.f14853c = lazy3;
        this.f14854d = lazy4;
        this.f14855e = lazy5;
        this.f14856f = lazy6;
        this.f14857g = lazy7;
        this.f14858h = lazy8;
        this.f14859i = lazy9;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier m15264a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14850j;	 Catch:{ all -> 0x006c }
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
        r1 = m15265b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14850j;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier) r0;	 Catch:{  }
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
        r0 = f14850j;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier");
    }

    public final PaymentsDeltaHandler m15266a(DeltaPaymentWrapper deltaPaymentWrapper) {
        switch (deltaPaymentWrapper.setField_) {
            case 1:
                return (PaymentsDeltaHandler) this.f14851a.get();
            case 2:
                return (PaymentsDeltaHandler) this.f14853c.get();
            case 3:
            case 4:
            case 5:
                return (PaymentsDeltaHandler) this.f14852b.get();
            case 6:
                return (PaymentsDeltaHandler) this.f14854d.get();
            case 7:
                return (PaymentsDeltaHandler) this.f14855e.get();
            case 8:
                return (PaymentsDeltaHandler) this.f14855e.get();
            case 9:
                return (PaymentsDeltaHandler) this.f14859i.get();
            case 10:
                return (PaymentsDeltaHandler) this.f14856f.get();
            case 11:
                return (PaymentsDeltaHandler) this.f14857g.get();
            case 12:
                return (PaymentsDeltaHandler) this.f14858h.get();
            default:
                throw new RuntimeException(StringFormatUtil.formatStrLocaleSafe("Unsupported payment delta type: %s", Integer.valueOf(deltaPaymentWrapper.setField_)));
        }
    }
}
