package com.facebook.messaging.payment.value.input.pagescommerce;

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
import com.facebook.messaging.payment.service.model.pay.SendPaymentBankDetails;
import com.facebook.messaging.payment.service.model.pay.SendPaymentBarCodeDetails;
import com.facebook.messaging.payment.service.model.pay.SendPaymentParams;
import com.facebook.messaging.payment.service.model.pay.SendPaymentParamsBuilder;
import com.facebook.messaging.payment.service.model.pay.SendPaymentResult;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.facebook.messaging.payment.value.input.MCMessengerPayLogger;
import com.facebook.messaging.payment.value.input.MessengerPayData;
import com.facebook.messaging.payment.value.input.MessengerPaySender;
import com.facebook.payments.confirmation.ConfirmationActivity;
import com.facebook.payments.confirmation.ConfirmationCommonParams;
import com.facebook.payments.confirmation.ConfirmationCommonParamsBuilder;
import com.facebook.payments.confirmation.ConfirmationStyle;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: emoji_color_pref */
public class PagesCommerceMessengerPaySender implements MessengerPaySender {
    private final PaymentCurrencyUtil f15811a;
    private final PaymentProtocolUtil f15812b;
    private final Executor f15813c;
    private final AbstractFbErrorReporter f15814d;
    private final Context f15815e;
    private final MCMessengerPayLogger f15816f;
    private UniqueIdGenerator f15817g;
    private final Lazy<PaymentDialogsBuilder> f15818h;
    private ListenableFuture<SendPaymentResult> f15819i;
    private MessengerPayData f15820j;
    private C17758 f15821k;
    private String f15822l;

    /* compiled from: emoji_color_pref */
    class C18601 extends ResultFutureCallback<SendPaymentResult> {
        final /* synthetic */ PagesCommerceMessengerPaySender f15808a;

        C18601(PagesCommerceMessengerPaySender pagesCommerceMessengerPaySender) {
            this.f15808a = pagesCommerceMessengerPaySender;
        }

        public final void m15998a(Object obj) {
            PagesCommerceMessengerPaySender.m16000a(this.f15808a, (SendPaymentResult) obj);
        }

        public final void m15997a(ServiceException serviceException) {
            PagesCommerceMessengerPaySender.m15999a(this.f15808a, serviceException);
        }
    }

    /* compiled from: emoji_color_pref */
    class C18612 implements OnClickListener {
        final /* synthetic */ PagesCommerceMessengerPaySender f15809a;

        C18612(PagesCommerceMessengerPaySender pagesCommerceMessengerPaySender) {
            this.f15809a = pagesCommerceMessengerPaySender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: emoji_color_pref */
    /* synthetic */ class C18623 {
        static final /* synthetic */ int[] f15810a = new int[PaymentMethodType.values().length];

        static {
            try {
                f15810a[PaymentMethodType.PAY_OVER_COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15810a[PaymentMethodType.NET_BANKING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15810a[PaymentMethodType.CREDIT_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static PagesCommerceMessengerPaySender m16002b(InjectorLike injectorLike) {
        return new PagesCommerceMessengerPaySender(PaymentCurrencyUtil.m13192a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), MCMessengerPayLogger.m15683b(injectorLike), UniqueIdGenerator.a(injectorLike), IdBasedLazy.a(injectorLike, 8039));
    }

    @Inject
    public PagesCommerceMessengerPaySender(PaymentCurrencyUtil paymentCurrencyUtil, PaymentProtocolUtil paymentProtocolUtil, FbErrorReporter fbErrorReporter, Executor executor, Context context, MCMessengerPayLogger mCMessengerPayLogger, UniqueIdGenerator uniqueIdGenerator, Lazy<PaymentDialogsBuilder> lazy) {
        this.f15811a = paymentCurrencyUtil;
        this.f15812b = paymentProtocolUtil;
        this.f15814d = fbErrorReporter;
        this.f15813c = executor;
        this.f15815e = context;
        this.f15816f = mCMessengerPayLogger;
        this.f15817g = uniqueIdGenerator;
        this.f15818h = lazy;
    }

    public final void mo616a(C17758 c17758) {
        this.f15821k = c17758;
    }

    public final void mo614a() {
        if (this.f15819i != null) {
            this.f15819i.cancel(true);
            this.f15819i = null;
        }
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        Object obj;
        this.f15820j = messengerPayData;
        ListenableFuture listenableFuture = this.f15819i;
        if (listenableFuture == null || listenableFuture.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            PaymentShippingOptionModel paymentShippingOptionModel = (PaymentShippingOptionModel) this.f15820j.f15452i.get();
            String bigDecimal = this.f15811a.m13200a(this.f15811a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL, paymentShippingOptionModel.m13828g(), paymentShippingOptionModel.m13823a())).toString();
            String a = paymentShippingOptionModel.m13823a();
            PaymentMethod paymentMethod = (PaymentMethod) this.f15820j.f15450g.get();
            String a2 = paymentMethod.b().equals(PaymentMethodType.CREDIT_CARD) ? paymentMethod.a() : null;
            String c = ((PaymentPlatformContextModel) FlatBufferModelHelper.a(bundle, "payment_platform_context")).m13759k().m13879c();
            String a3 = ((MailingAddress) this.f15820j.f15454k.get()).mo760a();
            String b = paymentShippingOptionModel.m13825b();
            String str = this.f15820j.f15464u;
            this.f15822l = bundle.getString("invoice_id");
            C18601 c18601 = new C18601(this);
            SendPaymentParamsBuilder sendPaymentParamsBuilder = new SendPaymentParamsBuilder();
            sendPaymentParamsBuilder.f14688a = PaymentItemType.NMOR_PAGES_COMMERCE;
            sendPaymentParamsBuilder = sendPaymentParamsBuilder;
            sendPaymentParamsBuilder.f14692e = "sale";
            sendPaymentParamsBuilder = sendPaymentParamsBuilder;
            sendPaymentParamsBuilder.f14689b = bigDecimal;
            SendPaymentParamsBuilder sendPaymentParamsBuilder2 = sendPaymentParamsBuilder;
            sendPaymentParamsBuilder2.f14694g = str;
            sendPaymentParamsBuilder2 = sendPaymentParamsBuilder2;
            sendPaymentParamsBuilder2.f14690c = a;
            sendPaymentParamsBuilder2 = sendPaymentParamsBuilder2;
            sendPaymentParamsBuilder2.f14691d = a2;
            SendPaymentParamsBuilder sendPaymentParamsBuilder3 = sendPaymentParamsBuilder2;
            sendPaymentParamsBuilder3.f14693f = c;
            sendPaymentParamsBuilder3 = sendPaymentParamsBuilder3;
            sendPaymentParamsBuilder3.f14695h = this.f15820j.f15465v;
            sendPaymentParamsBuilder3 = sendPaymentParamsBuilder3;
            sendPaymentParamsBuilder3.f14696i = a3;
            SendPaymentParamsBuilder sendPaymentParamsBuilder4 = sendPaymentParamsBuilder3;
            sendPaymentParamsBuilder4.f14697j = b;
            SendPaymentParamsBuilder sendPaymentParamsBuilder5 = sendPaymentParamsBuilder4;
            sendPaymentParamsBuilder5.f14698k = paymentMethod;
            sendPaymentParamsBuilder5 = sendPaymentParamsBuilder5;
            sendPaymentParamsBuilder5.f14699l = this.f15822l;
            sendPaymentParamsBuilder5 = sendPaymentParamsBuilder5;
            sendPaymentParamsBuilder5.f14701n = String.valueOf(this.f15817g.a());
            this.f15819i = this.f15812b.m14943a(this.f15815e, new SendPaymentParams(sendPaymentParamsBuilder5), this.f15815e.getString(2131240527));
            Futures.a(this.f15819i, c18601, this.f15813c);
            m16001a("p2p_confirm_send");
        }
    }

    public static void m15999a(PagesCommerceMessengerPaySender pagesCommerceMessengerPaySender, ServiceException serviceException) {
        pagesCommerceMessengerPaySender.f15821k.m15636a();
        pagesCommerceMessengerPaySender.m16001a("p2p_send_fail");
        BLog.b("PagesCommerceMessengerPaySender", "Failed to place order", serviceException);
        pagesCommerceMessengerPaySender.f15814d.a("PagesCommerceMessengerPaySender", "Attempted to place order, but received a response with an error", serviceException);
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            PaymentConnectivityDialogFactory.a(pagesCommerceMessengerPaySender.f15815e, serviceException);
            return;
        }
        String a = ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c());
        pagesCommerceMessengerPaySender.f15818h.get();
        PaymentDialogsBuilder.m13299a(pagesCommerceMessengerPaySender.f15815e, pagesCommerceMessengerPaySender.f15815e.getString(2131240529), a, pagesCommerceMessengerPaySender.f15815e.getString(2131230726), new C18612(pagesCommerceMessengerPaySender)).show();
    }

    public static void m16000a(PagesCommerceMessengerPaySender pagesCommerceMessengerPaySender, SendPaymentResult sendPaymentResult) {
        switch (C18623.f15810a[((PaymentMethod) pagesCommerceMessengerPaySender.f15820j.f15450g.get()).b().ordinal()]) {
            case 1:
                SendPaymentBarCodeDetails a = sendPaymentResult.m15188a().m15191a();
                Preconditions.checkNotNull(a);
                pagesCommerceMessengerPaySender.f15821k.m15638a(BankWebViewActivity.m15978a(pagesCommerceMessengerPaySender.f15815e, pagesCommerceMessengerPaySender.f15815e.getString(2131238337), a.m15184a(), null), 22, true);
                return;
            case 2:
                SendPaymentBankDetails b = sendPaymentResult.m15188a().m15192b();
                Preconditions.checkNotNull(b);
                pagesCommerceMessengerPaySender.f15821k.m15638a(BankWebViewActivity.m15978a(pagesCommerceMessengerPaySender.f15815e, b.m15181e(), b.m15179c(), b.m15180d()), 21, false);
                return;
            default:
                pagesCommerceMessengerPaySender.m16003b();
                return;
        }
    }

    private void m16003b() {
        m16001a("p2p_send_success");
        ConfirmationCommonParamsBuilder newBuilder = ConfirmationCommonParams.newBuilder();
        newBuilder.f18596a = ConfirmationStyle.PAGES_COMMERCE;
        newBuilder = newBuilder;
        newBuilder.f18598c = this.f15822l;
        newBuilder = newBuilder;
        newBuilder.f18597b = false;
        this.f15821k.m15638a(ConfirmationActivity.m18613a(this.f15815e, newBuilder.m18623d()), 23, true);
    }

    private void m16001a(String str) {
        this.f15816f.m15685a(str, this.f15820j);
    }
}
