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
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParamsBuilder;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: external_attachment_url */
public class MCMessengerPaySender implements MessengerPaySender {
    private PaymentCurrencyUtil f15342a;
    private PaymentProtocolUtil f15343b;
    private UniqueIdGenerator f15344c;
    private Executor f15345d;
    private AbstractFbErrorReporter f15346e;
    private Context f15347f;
    private MCMessengerPayLogger f15348g;
    private Lazy<PaymentDialogsBuilder> f15349h;
    private ListenableFuture<SendPaymentMessageResult> f15350i;
    private MessengerPayData f15351j;
    private C17758 f15352k;

    /* compiled from: external_attachment_url */
    class C17871 extends ResultFutureCallback<SendPaymentMessageResult> {
        final /* synthetic */ MCMessengerPaySender f15340a;

        C17871(MCMessengerPaySender mCMessengerPaySender) {
            this.f15340a = mCMessengerPaySender;
        }

        public final void m15687a(ServiceException serviceException) {
            MCMessengerPaySender.m15689a(this.f15340a, serviceException);
        }

        public final void m15688a(Object obj) {
            MCMessengerPaySender.m15692b(this.f15340a);
        }
    }

    /* compiled from: external_attachment_url */
    class C17882 implements OnClickListener {
        final /* synthetic */ MCMessengerPaySender f15341a;

        C17882(MCMessengerPaySender mCMessengerPaySender) {
            this.f15341a = mCMessengerPaySender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MCMessengerPaySender m15691b(InjectorLike injectorLike) {
        return new MCMessengerPaySender(PaymentCurrencyUtil.m13192a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), MCMessengerPayLogger.m15683b(injectorLike), IdBasedLazy.a(injectorLike, 8039));
    }

    @Inject
    public MCMessengerPaySender(PaymentCurrencyUtil paymentCurrencyUtil, PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, FbErrorReporter fbErrorReporter, Executor executor, Context context, MCMessengerPayLogger mCMessengerPayLogger, Lazy<PaymentDialogsBuilder> lazy) {
        this.f15342a = paymentCurrencyUtil;
        this.f15343b = paymentProtocolUtil;
        this.f15344c = uniqueIdGenerator;
        this.f15346e = fbErrorReporter;
        this.f15345d = executor;
        this.f15347f = context;
        this.f15348g = mCMessengerPayLogger;
        this.f15349h = lazy;
    }

    public final void mo616a(C17758 c17758) {
        this.f15352k = c17758;
    }

    public final void mo614a() {
        if (this.f15350i != null) {
            this.f15350i.cancel(true);
            this.f15350i = null;
        }
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        Object obj;
        this.f15351j = messengerPayData;
        ListenableFuture listenableFuture = this.f15350i;
        if (listenableFuture == null || listenableFuture.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            PaymentShippingOptionModel paymentShippingOptionModel = (PaymentShippingOptionModel) this.f15351j.f15452i.get();
            String a = this.f15342a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL, paymentShippingOptionModel.m13828g(), paymentShippingOptionModel.m13823a());
            String a2 = paymentShippingOptionModel.m13823a();
            String a3 = ((PaymentMethod) this.f15351j.f15450g.get()).a();
            PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) FlatBufferModelHelper.a(bundle, "payment_platform_context");
            String c = paymentPlatformContextModel.m13759k().m13879c();
            String a4 = ((MailingAddress) this.f15351j.f15454k.get()).mo760a();
            String b = paymentShippingOptionModel.m13825b();
            C17871 c17871 = new C17871(this);
            SendPaymentMessageParamsBuilder newBuilder = SendPaymentMessageParams.newBuilder();
            newBuilder.f14774a = a;
            SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder = newBuilder;
            sendPaymentMessageParamsBuilder.f14775b = a2;
            sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder.f14776c = a3;
            sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder.f14777d = c;
            sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder.f14779f = this.f15351j.f15465v;
            sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder.f14782i = paymentPlatformContextModel.m13756d();
            SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder;
            sendPaymentMessageParamsBuilder2.f14784k = a4;
            sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder2.f14785l = b;
            SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder3 = sendPaymentMessageParamsBuilder2;
            sendPaymentMessageParamsBuilder3.f14781h = String.valueOf(this.f15344c.a());
            this.f15350i = this.f15343b.m14944a(this.f15347f, sendPaymentMessageParamsBuilder3.m15205o(), this.f15347f.getString(2131240527));
            Futures.a(this.f15350i, c17871, this.f15345d);
            m15690a("p2p_confirm_send");
        }
    }

    public static void m15689a(MCMessengerPaySender mCMessengerPaySender, ServiceException serviceException) {
        mCMessengerPaySender.f15352k.m15636a();
        mCMessengerPaySender.m15690a("p2p_send_fail");
        BLog.b("MCMessengerPaySender", "Failed to place order", serviceException);
        mCMessengerPaySender.f15346e.a("MCMessengerPaySender", "Attempted to place order, but received a response with an error", serviceException);
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            PaymentConnectivityDialogFactory.a(mCMessengerPaySender.f15347f, serviceException);
            return;
        }
        String a = ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c());
        mCMessengerPaySender.f15349h.get();
        PaymentDialogsBuilder.m13299a(mCMessengerPaySender.f15347f, mCMessengerPaySender.f15347f.getString(2131240529), a, mCMessengerPaySender.f15347f.getString(2131230726), new C17882(mCMessengerPaySender)).show();
    }

    public static void m15692b(MCMessengerPaySender mCMessengerPaySender) {
        mCMessengerPaySender.m15690a("p2p_send_success");
        Intent intent = new Intent();
        intent.putExtra("show_card_added_nux", mCMessengerPaySender.f15351j.f15467x);
        intent.putExtra("show_pin_nux", mCMessengerPaySender.f15351j.f15466w);
        mCMessengerPaySender.f15352k.m15637a(intent);
    }

    private void m15690a(String str) {
        this.f15348g.m15685a(str, this.f15351j);
    }
}
