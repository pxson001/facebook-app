package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler;
import com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel.Builder;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentRequestStatus;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.PaymentRequestStatus;
import com.facebook.sync.delta.DeltaWithSequenceId;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchGroupThreads */
public class DeltaPaymentRequestStatusHandler extends PaymentsDeltaHandler {
    private static final Class<?> f14894a = DeltaPaymentRequestStatusHandler.class;
    private static final Object f14895h = new Object();
    private final PaymentsBroadcaster f14896b;
    private final PaymentRequestUtil f14897c;
    private final DbFetchPaymentTransactionHandler f14898d;
    private final DbFetchPaymentRequestHandler f14899e;
    private final DbInsertPaymentRequestsHandler f14900f;
    private final PaymentRequestCache f14901g;

    private static DeltaPaymentRequestStatusHandler m15303b(InjectorLike injectorLike) {
        return new DeltaPaymentRequestStatusHandler(PaymentsBroadcaster.m15003a(injectorLike), PaymentRequestUtil.a(injectorLike), DbFetchPaymentTransactionHandler.m13242a(injectorLike), DbFetchPaymentRequestHandler.m13234a(injectorLike), DbInsertPaymentRequestsHandler.m13258a(injectorLike), PaymentRequestCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler m15302a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14895h;	 Catch:{ all -> 0x006c }
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
        r1 = m15303b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14895h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler) r0;	 Catch:{  }
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
        r0 = f14895h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaPaymentRequestStatusHandler");
    }

    @Inject
    public DeltaPaymentRequestStatusHandler(PaymentsBroadcaster paymentsBroadcaster, PaymentRequestUtil paymentRequestUtil, DbFetchPaymentTransactionHandler dbFetchPaymentTransactionHandler, DbFetchPaymentRequestHandler dbFetchPaymentRequestHandler, DbInsertPaymentRequestsHandler dbInsertPaymentRequestsHandler, PaymentRequestCache paymentRequestCache) {
        this.f14896b = paymentsBroadcaster;
        this.f14897c = paymentRequestUtil;
        this.f14898d = dbFetchPaymentTransactionHandler;
        this.f14899e = dbFetchPaymentRequestHandler;
        this.f14900f = dbInsertPaymentRequestsHandler;
        this.f14901g = paymentRequestCache;
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        DeltaPaymentRequestStatus i = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16098i();
        PaymentRequestModel a = this.f14899e.m13240a(i.requestFbId.longValue());
        GraphQLPeerToPeerPaymentRequestStatus valueOf = GraphQLPeerToPeerPaymentRequestStatus.valueOf((String) PaymentRequestStatus.f15973b.get(i.newStatus));
        Builder builder = new Builder();
        builder.f13366d = a.lw_();
        builder = builder;
        builder.f13368f = valueOf;
        builder = builder;
        builder.f13363a = a.m13811b();
        Builder builder2 = builder;
        builder2.f13364b = a.m13812c();
        builder2 = builder2;
        builder2.f13365c = a.m13813d();
        builder2 = builder2;
        builder2.f13367e = a.m13814g();
        builder = builder2;
        builder.f13369g = a.ly_();
        builder = builder;
        builder.f13370h = a.m13815j();
        builder = builder;
        builder.f13371i = a.m13816k();
        builder2 = builder;
        if (i.transferFbId != null) {
            PaymentTransaction a2 = this.f14898d.m13245a(i.transferFbId.longValue());
            if (a2 != null) {
                builder2.f13372j = a2.m13532p();
            }
        }
        if (i.timestampMs != null) {
            builder2.f13373k = TimeUnit.MILLISECONDS.toSeconds(i.timestampMs.longValue());
        }
        PaymentRequestModel a3 = builder2.m13795a();
        if (this.f14897c.d(a3)) {
            this.f14900f.m13261a(a3);
        } else if (this.f14897c.e(a3)) {
            this.f14900f.m13263b(a3);
        }
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "payment_request", a3);
        return bundle;
    }

    public final void m15305a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        PaymentRequestModel paymentRequestModel = (PaymentRequestModel) FlatBufferModelHelper.a(bundle, "payment_request");
        if (paymentRequestModel != null) {
            this.f14901g.a(paymentRequestModel);
            this.f14896b.m15008a(paymentRequestModel.lw_());
        }
    }
}
