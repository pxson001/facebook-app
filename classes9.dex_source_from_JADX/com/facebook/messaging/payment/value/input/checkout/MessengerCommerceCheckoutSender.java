package com.facebook.messaging.payment.value.input.checkout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParamsBuilder;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.payments.checkout.SimpleCheckoutSender;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: endFillColor */
public class MessengerCommerceCheckoutSender extends SimpleCheckoutSender {
    public static final String f15768b = MessengerCommerceCheckoutSender.class.getSimpleName();
    public final Context f15769c;
    private final AnalyticsLogger f15770d;
    private final Executor f15771e;
    private final PaymentProtocolUtil f15772f;
    private final UniqueIdGenerator f15773g;
    public final AbstractFbErrorReporter f15774h;
    private final PaymentDialogsBuilder f15775i;
    private final PaymentCurrencyUtil f15776j;
    private ListenableFuture<SendPaymentMessageResult> f15777k;

    /* compiled from: endFillColor */
    public class C18552 implements OnClickListener {
        final /* synthetic */ MessengerCommerceCheckoutSender f15767a;

        public C18552(MessengerCommerceCheckoutSender messengerCommerceCheckoutSender) {
            this.f15767a = messengerCommerceCheckoutSender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MessengerCommerceCheckoutSender m15956c(InjectorLike injectorLike) {
        return new MessengerCommerceCheckoutSender((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentDialogsBuilder.m13301a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public MessengerCommerceCheckoutSender(Context context, AnalyticsLogger analyticsLogger, Executor executor, PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, AbstractFbErrorReporter abstractFbErrorReporter, PaymentDialogsBuilder paymentDialogsBuilder, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15769c = context;
        this.f15770d = analyticsLogger;
        this.f15771e = executor;
        this.f15772f = paymentProtocolUtil;
        this.f15773g = uniqueIdGenerator;
        this.f15774h = abstractFbErrorReporter;
        this.f15775i = paymentDialogsBuilder;
        this.f15776j = paymentCurrencyUtil;
    }

    public final ListenableFuture mo631a(CheckoutData checkoutData) {
        if (!SimpleCheckoutSender.m15895a(this.f15777k)) {
            return this.f15777k;
        }
        PaymentShippingOptionModel paymentShippingOptionModel = ((MessengerCommerceShippingOption) checkoutData.mo724h().get()).f15783a;
        String a = this.f15776j.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL, paymentShippingOptionModel.m13828g(), paymentShippingOptionModel.m13823a());
        String a2 = paymentShippingOptionModel.m13823a();
        String a3 = ((PaymentMethod) checkoutData.mo728l().get()).a();
        PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) checkoutData.mo726j();
        String c = paymentPlatformContextModel.m13759k().m13879c();
        String a4 = ((MailingAddress) checkoutData.mo722f().get()).mo760a();
        String b = paymentShippingOptionModel.m13825b();
        SendPaymentMessageParamsBuilder newBuilder = SendPaymentMessageParams.newBuilder();
        newBuilder.f14774a = a;
        SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder = newBuilder;
        sendPaymentMessageParamsBuilder.f14775b = a2;
        sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder.f14776c = a3;
        sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder.f14777d = c;
        sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder.f14779f = checkoutData.mo721e();
        sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder.f14782i = paymentPlatformContextModel.m13756d();
        sendPaymentMessageParamsBuilder = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder.f14784k = a4;
        SendPaymentMessageParamsBuilder sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder;
        sendPaymentMessageParamsBuilder2.f14785l = b;
        sendPaymentMessageParamsBuilder2 = sendPaymentMessageParamsBuilder2;
        sendPaymentMessageParamsBuilder2.f14781h = String.valueOf(this.f15773g.a());
        this.f15777k = this.f15772f.m14944a(this.f15769c, sendPaymentMessageParamsBuilder2.m15205o(), null);
        final PaymentPlatformItemModel g = paymentPlatformContextModel.m13757g();
        m15955a(this, "p2p_confirm_send", g);
        Futures.a(this.f15777k, new ResultFutureCallback<SendPaymentMessageResult>(this) {
            final /* synthetic */ MessengerCommerceCheckoutSender f15766b;

            protected final void m15954a(Object obj) {
                SendPaymentMessageResult sendPaymentMessageResult = (SendPaymentMessageResult) obj;
                MessengerCommerceCheckoutSender.m15955a(this.f15766b, "p2p_send_success", g);
                this.f15766b.f15712a.m18603a(sendPaymentMessageResult);
            }

            protected final void m15953a(ServiceException serviceException) {
                MessengerCommerceCheckoutSender.m15955a(this.f15766b, "p2p_send_fail", g);
                SimpleCheckoutSender simpleCheckoutSender = this.f15766b;
                simpleCheckoutSender.f15712a.m18602a();
                BLog.b(MessengerCommerceCheckoutSender.f15768b, "Failed to place order", serviceException);
                simpleCheckoutSender.f15774h.a(MessengerCommerceCheckoutSender.f15768b, "Attempted to place order, but received a response with an error", serviceException);
                if (serviceException.errorCode != ErrorCode.API_ERROR) {
                    PaymentConnectivityDialogFactory.a(simpleCheckoutSender.f15769c, serviceException);
                    return;
                }
                PaymentDialogsBuilder.m13299a(simpleCheckoutSender.f15769c, simpleCheckoutSender.f15769c.getString(2131240529), ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c()), simpleCheckoutSender.f15769c.getString(2131230726), new C18552(simpleCheckoutSender)).show();
            }
        }, this.f15771e);
        return this.f15777k;
    }

    public static void m15955a(MessengerCommerceCheckoutSender messengerCommerceCheckoutSender, String str, PaymentPlatformItemModel paymentPlatformItemModel) {
        messengerCommerceCheckoutSender.f15770d.a(P2pPaymentsLogEvent.d(str, "mc_pay").o(paymentPlatformItemModel.m13779b()).a(messengerCommerceCheckoutSender.f15776j.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, paymentPlatformItemModel.lu_().m13691a(), paymentPlatformItemModel.lu_().m13695b())).a);
    }
}
