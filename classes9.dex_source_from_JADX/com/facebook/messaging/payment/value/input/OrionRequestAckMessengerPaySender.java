package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParamsBuilder;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.messaging.payment.utils.PaymentRiskFlowHelper;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.math.BigDecimal;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: event name must match accumulator name */
public class OrionRequestAckMessengerPaySender implements MessengerPaySender {
    private final PaymentCurrencyUtil f15601a;
    private final PaymentProtocolUtil f15602b;
    private final UniqueIdGenerator f15603c;
    private final Executor f15604d;
    public final AbstractFbErrorReporter f15605e;
    public final Context f15606f;
    public final OrionRequestAckMessengerPayLogger f15607g;
    public final PaymentRiskFlowHelper f15608h;
    public final Lazy<PaymentDialogsBuilder> f15609i;
    private ListenableFuture<SendPaymentMessageResult> f15610j;
    public MessengerPayData f15611k;
    public C17758 f15612l;

    /* compiled from: event name must match accumulator name */
    public class C18262 implements OnClickListener {
        final /* synthetic */ OrionRequestAckMessengerPaySender f15600a;

        public C18262(OrionRequestAckMessengerPaySender orionRequestAckMessengerPaySender) {
            this.f15600a = orionRequestAckMessengerPaySender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static OrionRequestAckMessengerPaySender m15817b(InjectorLike injectorLike) {
        return new OrionRequestAckMessengerPaySender(PaymentCurrencyUtil.m13192a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), OrionRequestAckMessengerPayLogger.m15811b(injectorLike), PaymentRiskFlowHelper.m15536b(injectorLike), IdBasedLazy.a(injectorLike, 8039));
    }

    @Inject
    public OrionRequestAckMessengerPaySender(PaymentCurrencyUtil paymentCurrencyUtil, PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, FbErrorReporter fbErrorReporter, Executor executor, Context context, OrionRequestAckMessengerPayLogger orionRequestAckMessengerPayLogger, PaymentRiskFlowHelper paymentRiskFlowHelper, Lazy<PaymentDialogsBuilder> lazy) {
        this.f15601a = paymentCurrencyUtil;
        this.f15602b = paymentProtocolUtil;
        this.f15603c = uniqueIdGenerator;
        this.f15605e = fbErrorReporter;
        this.f15604d = executor;
        this.f15606f = context;
        this.f15607g = orionRequestAckMessengerPayLogger;
        this.f15608h = paymentRiskFlowHelper;
        this.f15609i = lazy;
    }

    public final void mo616a(C17758 c17758) {
        this.f15612l = c17758;
    }

    public final void mo614a() {
        if (this.f15610j != null) {
            this.f15610j.cancel(true);
            this.f15610j = null;
        }
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        Object obj;
        this.f15611k = messengerPayData;
        ListenableFuture listenableFuture = this.f15610j;
        if (listenableFuture == null || listenableFuture.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            String str = this.f15611k.f15462s.f15442a;
            String str2 = this.f15611k.f15462s.f15443b;
            BigDecimal a = this.f15601a.m13201a(str, str2);
            String valueOf = String.valueOf(((PaymentCard) this.f15611k.f15449f.get()).f13202a);
            String b = this.f15611k.f15460q.b();
            final PaymentRequestModel paymentRequestModel = (PaymentRequestModel) FlatBufferModelHelper.a(bundle, "payment_request");
            C18251 c18251 = new ResultFutureCallback<SendPaymentMessageResult>(this) {
                final /* synthetic */ OrionRequestAckMessengerPaySender f15599b;

                public final void m15816a(Object obj) {
                    SendPaymentMessageResult sendPaymentMessageResult = (SendPaymentMessageResult) obj;
                    this.f15599b.f15607g.m15813a("p2p_send_success", paymentRequestModel);
                    if (PaymentRiskFlowHelper.m15535a(sendPaymentMessageResult)) {
                        this.f15599b.f15608h.m15537a(sendPaymentMessageResult.m15207b(), this.f15599b.f15611k.f15460q.b(), this.f15599b.f15606f);
                    }
                    OrionRequestAckMessengerPaySender orionRequestAckMessengerPaySender = this.f15599b;
                    Intent intent = new Intent();
                    intent.putExtra("show_card_added_nux", orionRequestAckMessengerPaySender.f15611k.f15467x);
                    intent.putExtra("show_pin_nux", orionRequestAckMessengerPaySender.f15611k.f15466w);
                    orionRequestAckMessengerPaySender.f15612l.m15637a(intent);
                }

                public final void m15815a(ServiceException serviceException) {
                    this.f15599b.f15607g.m15813a("p2p_send_fail", paymentRequestModel);
                    OrionRequestAckMessengerPaySender orionRequestAckMessengerPaySender = this.f15599b;
                    orionRequestAckMessengerPaySender.f15612l.m15636a();
                    BLog.b("OrionRequestAckMessengerPaySender", "Failed to pay request", serviceException);
                    orionRequestAckMessengerPaySender.f15605e.a("OrionRequestAckMessengerPaySender", "Attempted to pay a request, but received a response with an error", serviceException);
                    if (serviceException.errorCode != ErrorCode.API_ERROR) {
                        PaymentConnectivityDialogFactory.a(orionRequestAckMessengerPaySender.f15606f, serviceException);
                        return;
                    }
                    String a = ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c());
                    orionRequestAckMessengerPaySender.f15609i.get();
                    PaymentDialogsBuilder.m13299a(orionRequestAckMessengerPaySender.f15606f, orionRequestAckMessengerPaySender.f15606f.getString(2131240562), a, orionRequestAckMessengerPaySender.f15606f.getString(2131230726), new C18262(orionRequestAckMessengerPaySender)).show();
                }
            };
            SendPaymentMessageParamsBuilder newBuilder = SendPaymentMessageParams.newBuilder();
            newBuilder.f14774a = a.toString();
            SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder = newBuilder;
            sendPaymentMessageParamsBuilder.f14775b = str2;
            SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder2.f14776c = valueOf;
            sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder2.f14777d = b;
            sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder2.f14779f = this.f15611k.f15465v;
            sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder2.f14786m = paymentRequestModel.lw_();
            sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder2.f14781h = String.valueOf(this.f15603c.a());
            this.f15610j = this.f15602b.m14944a(this.f15606f, sendPaymentMessageParamsBuilder2.m15205o(), this.f15606f.getString(2131240561));
            Futures.a(this.f15610j, c18251, this.f15604d);
            this.f15607g.m15813a("p2p_confirm_send", paymentRequestModel);
        }
    }
}
