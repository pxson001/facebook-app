package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: estimated_size */
public class OrionRequestMessengerPaySender implements MessengerPaySender {
    private final PaymentCurrencyUtil f15650a;
    private final PaymentProtocolUtil f15651b;
    private final UniqueIdGenerator f15652c;
    private final Executor f15653d;
    public final AbstractFbErrorReporter f15654e;
    public final Context f15655f;
    public final Lazy<PaymentDialogsBuilder> f15656g;
    public final OrionRequestMessengerPayLogger f15657h;
    private ListenableFuture<OperationResult> f15658i;
    public MessengerPayData f15659j;
    public C17758 f15660k;

    /* compiled from: estimated_size */
    class C18331 extends ResultFutureCallback<OperationResult> {
        final /* synthetic */ OrionRequestMessengerPaySender f15648a;

        C18331(OrionRequestMessengerPaySender orionRequestMessengerPaySender) {
            this.f15648a = orionRequestMessengerPaySender;
        }

        public final void m15836a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            OrionRequestMessengerPaySender orionRequestMessengerPaySender = this.f15648a;
            orionRequestMessengerPaySender.f15657h.m15834a("p2p_request_success", orionRequestMessengerPaySender.f15659j, operationResult.c);
            orionRequestMessengerPaySender.f15660k.m15637a(null);
        }

        public final void m15835a(ServiceException serviceException) {
            OrionRequestMessengerPaySender orionRequestMessengerPaySender = this.f15648a;
            orionRequestMessengerPaySender.f15657h.m15832a("p2p_request_fail", orionRequestMessengerPaySender.f15659j);
            orionRequestMessengerPaySender.f15660k.m15636a();
            BLog.b("OrionRequestMessengerPaySender", "Failed to create a request", serviceException);
            orionRequestMessengerPaySender.f15654e.a("OrionRequestMessengerPaySender", "Attempted to create a request, but received a response with an error", serviceException);
            if (serviceException.errorCode != ErrorCode.API_ERROR) {
                PaymentConnectivityDialogFactory.a(orionRequestMessengerPaySender.f15655f, serviceException);
                return;
            }
            String a = ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c());
            orionRequestMessengerPaySender.f15656g.get();
            PaymentDialogsBuilder.m13299a(orionRequestMessengerPaySender.f15655f, orionRequestMessengerPaySender.f15655f.getString(2131240568), a, orionRequestMessengerPaySender.f15655f.getString(2131230726), new C18342(orionRequestMessengerPaySender)).show();
        }
    }

    /* compiled from: estimated_size */
    public class C18342 implements OnClickListener {
        final /* synthetic */ OrionRequestMessengerPaySender f15649a;

        public C18342(OrionRequestMessengerPaySender orionRequestMessengerPaySender) {
            this.f15649a = orionRequestMessengerPaySender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static OrionRequestMessengerPaySender m15837b(InjectorLike injectorLike) {
        return new OrionRequestMessengerPaySender(PaymentCurrencyUtil.m13192a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 8039), OrionRequestMessengerPayLogger.m15830b(injectorLike));
    }

    @Inject
    public OrionRequestMessengerPaySender(PaymentCurrencyUtil paymentCurrencyUtil, PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, FbErrorReporter fbErrorReporter, Executor executor, Context context, Lazy<PaymentDialogsBuilder> lazy, OrionRequestMessengerPayLogger orionRequestMessengerPayLogger) {
        this.f15650a = paymentCurrencyUtil;
        this.f15651b = paymentProtocolUtil;
        this.f15652c = uniqueIdGenerator;
        this.f15654e = fbErrorReporter;
        this.f15653d = executor;
        this.f15655f = context;
        this.f15656g = lazy;
        this.f15657h = orionRequestMessengerPayLogger;
    }

    public final void mo616a(C17758 c17758) {
        this.f15660k = c17758;
    }

    public final void mo614a() {
        if (this.f15658i != null) {
            this.f15658i.cancel(true);
            this.f15658i = null;
        }
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        Object obj;
        this.f15659j = messengerPayData;
        ListenableFuture listenableFuture = this.f15658i;
        if (listenableFuture == null || listenableFuture.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            String str;
            String str2;
            OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) bundle.getParcelable("orion_messenger_pay_params");
            C18331 c18331 = new C18331(this);
            PaymentProtocolUtil paymentProtocolUtil = this.f15651b;
            String bigDecimal = this.f15650a.m13201a(this.f15659j.f15462s.f15442a, this.f15659j.f15462s.f15443b).toString();
            String valueOf = String.valueOf(this.f15652c.a());
            String b = this.f15659j.f15460q.b();
            String str3 = this.f15659j.f15463t;
            String str4 = orionMessengerPayParams.f15518g;
            if (this.f15659j.f15458o == null) {
                str = null;
            } else {
                str = this.f15659j.f15458o.m13942d();
            }
            if (orionMessengerPayParams.f15517f == null) {
                str2 = null;
            } else {
                str2 = orionMessengerPayParams.f15517f.m13756d();
            }
            this.f15658i = paymentProtocolUtil.m14961a(bigDecimal, valueOf, b, str3, str4, str, str2);
            Futures.a(this.f15658i, c18331, this.f15653d);
            this.f15657h.m15832a("p2p_confirm_request", this.f15659j);
        }
    }
}
