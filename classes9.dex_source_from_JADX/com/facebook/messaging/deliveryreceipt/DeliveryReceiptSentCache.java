package com.facebook.messaging.deliveryreceipt;

import android.support.v4.util.LruCache;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

@UserScoped
/* compiled from: mark_type */
public class DeliveryReceiptSentCache extends LruCache<ThreadKey, Long> {
    private static final Object f10856a = new Object();

    private static DeliveryReceiptSentCache m11279e() {
        return new DeliveryReceiptSentCache();
    }

    @Inject
    public DeliveryReceiptSentCache() {
        super(200);
    }

    public final synchronized void m11280a(ThreadKey threadKey, long j) {
        Long l = (Long) a(threadKey);
        if (l == null || j > l.longValue()) {
            a(threadKey, Long.valueOf(j));
        }
    }

    public final boolean m11281b(ThreadKey threadKey, long j) {
        Long l = (Long) a(threadKey);
        return l != null && l.longValue() >= j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache m11278a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10856a;	 Catch:{ all -> 0x006b }
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
        r1 = m11279e();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f10856a;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache) r0;	 Catch:{  }
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
        r0 = f10856a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.deliveryreceipt.DeliveryReceiptSentCache");
    }
}
