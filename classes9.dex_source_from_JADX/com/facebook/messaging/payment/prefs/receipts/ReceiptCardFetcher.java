package com.facebook.messaging.payment.prefs.receipts;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: groupPhotoReact */
public class ReceiptCardFetcher {
    private Executor f14006a;
    private PaymentProtocolUtil f14007b;
    public final AbstractFbErrorReporter f14008c;
    public ListenableFuture<PaymentCard> f14009d;
    public ReceiptCardFetcherListener f14010e;

    /* compiled from: groupPhotoReact */
    public interface ReceiptCardFetcherListener {
        void mo549a(@Nullable PaymentCard paymentCard);

        void mo550a(Throwable th);
    }

    /* compiled from: groupPhotoReact */
    class C15921 implements FutureCallback<PaymentCard> {
        final /* synthetic */ ReceiptCardFetcher f14005a;

        C15921(ReceiptCardFetcher receiptCardFetcher) {
            this.f14005a = receiptCardFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f14005a.f14010e.mo549a((PaymentCard) obj);
        }

        public void onFailure(Throwable th) {
            this.f14005a.f14008c.a("ReceiptCardFetcher", "Payment Method Used - failed to fetch");
            BLog.a("ReceiptCardFetcher", "Payment Method Used - failed to fetch");
            this.f14005a.f14010e.mo550a(th);
        }
    }

    public static ReceiptCardFetcher m14511b(InjectorLike injectorLike) {
        return new ReceiptCardFetcher((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ReceiptCardFetcher(Executor executor, PaymentProtocolUtil paymentProtocolUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f14006a = executor;
        this.f14007b = paymentProtocolUtil;
        this.f14008c = abstractFbErrorReporter;
    }

    public final void m14512a() {
        if (this.f14009d != null) {
            this.f14009d.cancel(true);
            this.f14009d = null;
        }
    }

    public final void m14513a(String str) {
        Object obj;
        if (this.f14009d == null || this.f14009d.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f14009d = this.f14007b.m14955a(str);
            Futures.a(this.f14009d, new C15921(this), this.f14006a);
        }
    }
}
