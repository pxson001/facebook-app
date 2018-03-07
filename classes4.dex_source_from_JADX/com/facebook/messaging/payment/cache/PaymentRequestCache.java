package com.facebook.messaging.payment.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.MessengerPayPrefKeys;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: internal_storage */
public class PaymentRequestCache implements IHaveUserData {
    private static final Object f10204e = new Object();
    private final FbSharedPreferences f10205a;
    private final PaymentRequestUtil f10206b;
    private final Map<String, PaymentRequest> f10207c = new HashMap();
    private ImmutableList<PaymentRequest> f10208d;

    private static PaymentRequestCache m10685b(InjectorLike injectorLike) {
        return new PaymentRequestCache((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PaymentRequestUtil.m10693a(injectorLike));
    }

    @Inject
    public PaymentRequestCache(FbSharedPreferences fbSharedPreferences, PaymentRequestUtil paymentRequestUtil) {
        this.f10205a = fbSharedPreferences;
        this.f10206b = paymentRequestUtil;
    }

    public final synchronized void m10690a(PaymentRequestModel paymentRequestModel) {
        this.f10207c.put(paymentRequestModel.lw_(), paymentRequestModel);
        if (this.f10206b.m10702d(paymentRequestModel)) {
            m10686b(paymentRequestModel);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.cache.PaymentRequestCache m10684a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10204e;	 Catch:{ all -> 0x006c }
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
        r1 = m10685b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10204e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentRequestCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.cache.PaymentRequestCache) r0;	 Catch:{  }
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
        r0 = f10204e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentRequestCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.cache.PaymentRequestCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.cache.PaymentRequestCache");
    }

    @Nullable
    public final synchronized PaymentRequestModel m10688a(String str) {
        return (PaymentRequestModel) this.f10207c.get(str);
    }

    @Nullable
    public final synchronized ImmutableList<PaymentRequest> m10689a() {
        return this.f10208d;
    }

    public final synchronized void m10691a(ImmutableList<PaymentRequest> immutableList) {
        this.f10208d = immutableList;
        int size = this.f10208d.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (this.f10206b.m10701a((PaymentRequestModel) this.f10208d.get(i))) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f10205a.edit().a(MessengerPayPrefKeys.b, i2).commit();
    }

    private synchronized void m10686b(PaymentRequestModel paymentRequestModel) {
        if (!m10687b()) {
            m10691a(this.f10206b.m10700a(this.f10208d, paymentRequestModel));
        }
    }

    @VisibleForTesting
    private synchronized boolean m10687b() {
        return this.f10208d == null;
    }

    public void clearUserData() {
        this.f10207c.clear();
        this.f10208d = null;
    }
}
