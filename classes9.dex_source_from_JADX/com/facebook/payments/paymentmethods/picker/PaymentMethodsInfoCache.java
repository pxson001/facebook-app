package com.facebook.payments.paymentmethods.picker;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.locale.Country;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.protocol.GetPaymentMethodsInfoMethod;
import com.facebook.payments.paymentmethods.picker.protocol.GetPaymentMethodsInfoParams;
import com.facebook.payments.paymentmethods.picker.protocol.GetPaymentMethodsInfoParamsBuilder;
import com.facebook.payments.paymentmethods.picker.protocol.PickerProtocolUtil;
import com.facebook.payments.paymentmethods.picker.protocol.PickerProtocolUtil.C22121;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Objects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

@UserScoped
/* compiled from: boosted_component_edit */
public class PaymentMethodsInfoCache extends ForwardingLoadingCache<CacheKey, PaymentMethodsInfo> {
    private static final Object f18737d = new Object();
    private final LoadingCache<CacheKey, PaymentMethodsInfo> f18738a;
    private final ListeningExecutorService f18739b;
    private final DefaultAndroidThreadUtil f18740c;

    /* compiled from: boosted_component_edit */
    public class CacheKey {
        public final PaymentItemType f18733a;
        public final String f18734b;
        public final JSONObject f18735c;
        public final Country f18736d;

        public CacheKey(PaymentItemType paymentItemType, String str, @Nullable JSONObject jSONObject, @Nullable Country country) {
            this.f18733a = paymentItemType;
            this.f18734b = str;
            this.f18735c = jSONObject;
            this.f18736d = country;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            if (this.f18733a.equals(cacheKey.f18733a) && this.f18734b.equals(cacheKey.f18734b) && Objects.equal(this.f18736d, cacheKey.f18736d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f18733a, this.f18734b, this.f18736d});
        }
    }

    private static PaymentMethodsInfoCache m18733b(InjectorLike injectorLike) {
        return new PaymentMethodsInfoCache(new PickerProtocolUtil(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GetPaymentMethodsInfoMethod.m18858b(injectorLike)), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    public final /* synthetic */ Object m18740c(Object obj) {
        return m18735a((CacheKey) obj);
    }

    protected final /* synthetic */ Cache m18741d() {
        return m18743f();
    }

    protected final /* synthetic */ Object m18742e() {
        return m18743f();
    }

    @Inject
    public PaymentMethodsInfoCache(final PickerProtocolUtil pickerProtocolUtil, ListeningExecutorService listeningExecutorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f18739b = listeningExecutorService;
        this.f18740c = defaultAndroidThreadUtil;
        this.f18738a = CacheBuilder.newBuilder().a(10, TimeUnit.MINUTES).a(new CacheLoader<CacheKey, PaymentMethodsInfo>(this) {
            final /* synthetic */ PaymentMethodsInfoCache f18730b;

            public final Object m18731a(Object obj) {
                CacheKey cacheKey = (CacheKey) obj;
                PickerProtocolUtil pickerProtocolUtil = pickerProtocolUtil;
                PaymentItemType paymentItemType = cacheKey.f18733a;
                String str = cacheKey.f18734b;
                JSONObject jSONObject = cacheKey.f18735c;
                Country country = cacheKey.f18736d;
                GetPaymentMethodsInfoParamsBuilder getPaymentMethodsInfoParamsBuilder = new GetPaymentMethodsInfoParamsBuilder();
                getPaymentMethodsInfoParamsBuilder.f18860a = paymentItemType;
                getPaymentMethodsInfoParamsBuilder = getPaymentMethodsInfoParamsBuilder;
                getPaymentMethodsInfoParamsBuilder.f18861b = str;
                getPaymentMethodsInfoParamsBuilder = getPaymentMethodsInfoParamsBuilder;
                getPaymentMethodsInfoParamsBuilder.f18862c = jSONObject;
                getPaymentMethodsInfoParamsBuilder = getPaymentMethodsInfoParamsBuilder;
                getPaymentMethodsInfoParamsBuilder.f18863d = country;
                return (PaymentMethodsInfo) FutureDetour.a(Futures.a(pickerProtocolUtil.f18867b.a(new GetPaymentMethodsInfoParams(getPaymentMethodsInfoParamsBuilder)), new C22121(pickerProtocolUtil), pickerProtocolUtil.f18866a), 1667248415);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache m18732a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18737d;	 Catch:{ all -> 0x006c }
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
        r1 = m18733b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18737d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache) r0;	 Catch:{  }
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
        r0 = f18737d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache.a(com.facebook.inject.InjectorLike):com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache");
    }

    protected final LoadingCache<CacheKey, PaymentMethodsInfo> m18743f() {
        return this.f18738a;
    }

    public final ListenableFuture<PaymentMethodsInfo> m18737a(PaymentItemType paymentItemType, String str, @Nullable JSONObject jSONObject, @Nullable Country country) {
        return m18734b(new CacheKey(paymentItemType, str, jSONObject, country));
    }

    public final ListenableFuture<PaymentMethodsInfo> m18736a(PaymentItemType paymentItemType, String str, @Nullable Country country) {
        return m18737a(paymentItemType, str, null, country);
    }

    private ListenableFuture<PaymentMethodsInfo> m18734b(final CacheKey cacheKey) {
        PaymentMethodsInfo paymentMethodsInfo = (PaymentMethodsInfo) a(cacheKey);
        if (paymentMethodsInfo != null) {
            return Futures.a(paymentMethodsInfo);
        }
        return this.f18739b.a(new Callable<PaymentMethodsInfo>(this) {
            final /* synthetic */ PaymentMethodsInfoCache f18732b;

            public Object call() {
                return this.f18732b.m18735a(cacheKey);
            }
        });
    }

    public final ListenableFuture<PaymentMethodsInfo> m18739b(PaymentItemType paymentItemType, String str, @Nullable JSONObject jSONObject, @Nullable Country country) {
        CacheKey cacheKey = new CacheKey(paymentItemType, str, jSONObject, country);
        b(cacheKey);
        return m18734b(cacheKey);
    }

    public final ListenableFuture<PaymentMethodsInfo> m18738b(PaymentItemType paymentItemType, String str) {
        return m18739b(paymentItemType, str, null, null);
    }

    public final PaymentMethodsInfo m18735a(CacheKey cacheKey) {
        this.f18740c.b("Calling this method may trigger synchronous loading, so it should not be done on UI thread");
        return (PaymentMethodsInfo) super.c(cacheKey);
    }
}
