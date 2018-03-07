package com.facebook.messaging.payment.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: integration_strategy */
public class PaymentTransactionCache implements IHaveUserData {
    private static final Object f12837c = new Object();
    @VisibleForTesting
    final Map<String, PaymentTransaction> f12838a = new HashMap();
    @VisibleForTesting
    final Map<Long, PaymentTransaction> f12839b = new HashMap();

    private static PaymentTransactionCache m13186b() {
        return new PaymentTransactionCache();
    }

    public final synchronized void m13190a(PaymentTransaction paymentTransaction) {
        this.f12838a.put(paymentTransaction.m13520b(), paymentTransaction);
    }

    @Nullable
    public final synchronized PaymentTransaction m13187a(String str) {
        return (PaymentTransaction) this.f12838a.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.cache.PaymentTransactionCache m13184a(com.facebook.inject.InjectorLike r7) {
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
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f12837c;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m13186b();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f12837c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentTransactionCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.payment.cache.PaymentTransactionCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f12837c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentTransactionCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.cache.PaymentTransactionCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.cache.PaymentTransactionCache");
    }

    public final synchronized void m13189a(long j, PaymentTransaction paymentTransaction) {
        this.f12839b.put(Long.valueOf(j), paymentTransaction);
    }

    public final synchronized Optional<PaymentTransaction> m13188a(long j) {
        return Optional.fromNullable(this.f12839b.get(Long.valueOf(j)));
    }

    public void clearUserData() {
        m13185a();
    }

    private synchronized void m13185a() {
        this.f12838a.clear();
        this.f12839b.clear();
    }
}
