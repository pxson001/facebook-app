package com.facebook.messaging.payment.sync.connection;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentPlatformContextsCache;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.database.handler.CacheInsertPaymentCardHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.method.FetchPaymentPinMethod;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod;
import com.facebook.messaging.payment.protocol.request.FetchPaymentRequestsMethod;
import com.facebook.messaging.payment.protocol.sync.FetchIrisSequenceIdMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentPlatformContextsMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentTransactionMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod;
import com.facebook.messaging.payment.service.model.cards.FetchPaymentCardsResult;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.sync.FetchIrisSequenceIdResult;
import com.facebook.messaging.payment.service.model.transactions.FetchPaymentTransactionParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreThreads (DSH). */
public class PaymentsSyncWebFetcher {
    private static final Object f14831q = new Object();
    private final DbInsertPaymentPinHandler f14832a;
    private final PaymentTransactionCache f14833b;
    public final PaymentRequestCache f14834c;
    public final CacheInsertPaymentCardHandler f14835d;
    public final DbInsertPaymentTransactionsHandler f14836e;
    public final DbInsertPaymentRequestsHandler f14837f;
    public final PaymentPlatformContextsCache f14838g;
    private final FetchPaymentPinMethod f14839h;
    private final FetchPaymentCardsMethod f14840i;
    private final FetchPaymentTransactionMethod f14841j;
    private final FetchTransactionListMethod f14842k;
    private final FetchPaymentRequestsMethod f14843l;
    private final FetchIrisSequenceIdMethod f14844m;
    private final FetchPaymentPlatformContextsMethod f14845n;
    public final PaymentsBroadcaster f14846o;
    private final ApiMethodRunnerImpl f14847p;

    private static PaymentsSyncWebFetcher m15256b(InjectorLike injectorLike) {
        return new PaymentsSyncWebFetcher(DbInsertPaymentPinHandler.m14248a(injectorLike), PaymentTransactionCache.m13184a(injectorLike), PaymentRequestCache.a(injectorLike), CacheInsertPaymentCardHandler.m13222a(injectorLike), DbInsertPaymentTransactionsHandler.m13264a(injectorLike), DbInsertPaymentRequestsHandler.m13258a(injectorLike), PaymentPlatformContextsCache.m13170a(injectorLike), FetchPaymentPinMethod.m14308a(injectorLike), FetchPaymentCardsMethod.m15026a(injectorLike), FetchPaymentTransactionMethod.m15123a(injectorLike), FetchTransactionListMethod.m15128a(injectorLike), FetchPaymentRequestsMethod.m15077a(injectorLike), FetchIrisSequenceIdMethod.m15092a(injectorLike), FetchPaymentPlatformContextsMethod.m15118a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), ApiMethodRunnerImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher m15255a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14831q;	 Catch:{ all -> 0x006c }
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
        r1 = m15256b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14831q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher) r0;	 Catch:{  }
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
        r0 = f14831q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher");
    }

    @Inject
    public PaymentsSyncWebFetcher(DbInsertPaymentPinHandler dbInsertPaymentPinHandler, PaymentTransactionCache paymentTransactionCache, PaymentRequestCache paymentRequestCache, CacheInsertPaymentCardHandler cacheInsertPaymentCardHandler, DbInsertPaymentTransactionsHandler dbInsertPaymentTransactionsHandler, DbInsertPaymentRequestsHandler dbInsertPaymentRequestsHandler, PaymentPlatformContextsCache paymentPlatformContextsCache, FetchPaymentPinMethod fetchPaymentPinMethod, FetchPaymentCardsMethod fetchPaymentCardsMethod, FetchPaymentTransactionMethod fetchPaymentTransactionMethod, FetchTransactionListMethod fetchTransactionListMethod, FetchPaymentRequestsMethod fetchPaymentRequestsMethod, FetchIrisSequenceIdMethod fetchIrisSequenceIdMethod, FetchPaymentPlatformContextsMethod fetchPaymentPlatformContextsMethod, PaymentsBroadcaster paymentsBroadcaster, ApiMethodRunnerImpl apiMethodRunnerImpl) {
        this.f14832a = dbInsertPaymentPinHandler;
        this.f14833b = paymentTransactionCache;
        this.f14834c = paymentRequestCache;
        this.f14835d = cacheInsertPaymentCardHandler;
        this.f14838g = paymentPlatformContextsCache;
        this.f14836e = dbInsertPaymentTransactionsHandler;
        this.f14837f = dbInsertPaymentRequestsHandler;
        this.f14839h = fetchPaymentPinMethod;
        this.f14840i = fetchPaymentCardsMethod;
        this.f14841j = fetchPaymentTransactionMethod;
        this.f14842k = fetchTransactionListMethod;
        this.f14843l = fetchPaymentRequestsMethod;
        this.f14844m = fetchIrisSequenceIdMethod;
        this.f14845n = fetchPaymentPlatformContextsMethod;
        this.f14846o = paymentsBroadcaster;
        this.f14847p = apiMethodRunnerImpl;
    }

    public final String m15258a() {
        String c = m15257c();
        Batch a = this.f14847p.a();
        Builder a2 = BatchOperation.a(this.f14839h, null);
        a2.c = "fetchPaymentPin";
        a.a(a2.a());
        a2 = BatchOperation.a(this.f14842k, new FetchTransactionListParams(FetchTransactionListParams.f14744a, 50));
        a2.c = "fetchTransactionListMethod";
        a.a(a2.a());
        a2 = BatchOperation.a(this.f14845n, null);
        a2.c = "fetchPaymentPlatformContextsMethod";
        a.a(a2.a());
        a2 = BatchOperation.a(this.f14843l, new FetchPaymentRequestsParams(QueryType.INCOMING));
        a2.c = "fetchPaymentRequestsMethod";
        a.a(a2.a());
        a.a("fetchAllforSync", CallerContext.a(getClass()));
        this.f14832a.m14251a((PaymentPin) a.a("fetchPaymentPin"));
        ImmutableList immutableList = ((FetchTransactionListResult) a.a("fetchTransactionListMethod")).f14748a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f14836e.m13270b((PaymentTransaction) immutableList.get(i));
        }
        this.f14838g.m13173a((ArrayList) a.a("fetchPaymentPlatformContextsMethod"));
        this.f14846o.m15014f();
        FetchPaymentRequestsResult fetchPaymentRequestsResult = (FetchPaymentRequestsResult) a.a("fetchPaymentRequestsMethod");
        this.f14837f.m13262a(fetchPaymentRequestsResult.m15195a());
        this.f14834c.a(fetchPaymentRequestsResult.m15195a());
        m15260b();
        return c;
    }

    public final void m15260b() {
        FetchPaymentCardsResult fetchPaymentCardsResult = (FetchPaymentCardsResult) this.f14847p.a(this.f14840i, null);
        if (fetchPaymentCardsResult.f14635b != null) {
            this.f14835d.m13225a(fetchPaymentCardsResult.f14635b);
        } else {
            this.f14835d.m13224a();
        }
        this.f14835d.m13226a(fetchPaymentCardsResult.f14636c);
        this.f14846o.m15011c();
    }

    public final void m15259a(String str) {
        PaymentTransaction paymentTransaction = (PaymentTransaction) this.f14847p.a(this.f14841j, new FetchPaymentTransactionParams(str, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA));
        this.f14836e.m13270b(paymentTransaction);
        this.f14833b.m13190a(paymentTransaction);
        this.f14846o.m15007a(paymentTransaction.f13234g, Long.parseLong(paymentTransaction.f13229b));
    }

    @VisibleForTesting
    private String m15257c() {
        return ((FetchIrisSequenceIdResult) this.f14847p.a(this.f14844m, null)).m15196a();
    }
}
