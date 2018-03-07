package com.facebook.messaging.payment.value.input.checkout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderResult;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParams;
import com.facebook.payments.checkout.SimpleCheckoutSender;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ephemeral_lifetime_micros */
public class MCheckoutSender extends SimpleCheckoutSender {
    public static final String f15713b = MessengerCommerceCheckoutSender.class.getSimpleName();
    public final Context f15714c;
    private final AnalyticsLogger f15715d;
    private final Executor f15716e;
    private final PaymentProtocolUtil f15717f;
    private final UniqueIdGenerator f15718g;
    public final AbstractFbErrorReporter f15719h;
    private final PaymentDialogsBuilder f15720i;
    private final Provider<User> f15721j;
    private ListenableFuture<MoneyPennyPlaceOrderResult> f15722k;

    /* compiled from: ephemeral_lifetime_micros */
    public class C18472 implements OnClickListener {
        final /* synthetic */ MCheckoutSender f15711a;

        public C18472(MCheckoutSender mCheckoutSender) {
            this.f15711a = mCheckoutSender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MCheckoutSender m15898c(InjectorLike injectorLike) {
        return new MCheckoutSender((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentDialogsBuilder.m13301a(injectorLike), IdBasedProvider.a(injectorLike, 3596));
    }

    @Inject
    public MCheckoutSender(Context context, AnalyticsLogger analyticsLogger, Executor executor, PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, FbErrorReporter fbErrorReporter, PaymentDialogsBuilder paymentDialogsBuilder, Provider<User> provider) {
        this.f15714c = context;
        this.f15715d = analyticsLogger;
        this.f15716e = executor;
        this.f15717f = paymentProtocolUtil;
        this.f15718g = uniqueIdGenerator;
        this.f15719h = fbErrorReporter;
        this.f15720i = paymentDialogsBuilder;
        this.f15721j = provider;
    }

    public final ListenableFuture mo631a(CheckoutData checkoutData) {
        if (!SimpleCheckoutSender.m15895a(this.f15722k)) {
            return this.f15722k;
        }
        String a = ((PaymentMethod) checkoutData.mo728l().get()).a();
        final MoneyPennyItemParams moneyPennyItemParams = ((MCheckoutParams) checkoutData.mo717a()).f15702b;
        this.f15722k = this.f15717f.m14947a(this.f15714c, moneyPennyItemParams.f15482f, a, checkoutData.mo721e(), this.f15718g.a(), moneyPennyItemParams.f15477a, ((User) this.f15721j.get()).a, null);
        m15897a(this, "p2p_confirm_send", moneyPennyItemParams);
        Futures.a(this.f15722k, new ResultFutureCallback<MoneyPennyPlaceOrderResult>(this) {
            final /* synthetic */ MCheckoutSender f15710b;

            protected final void m15894a(Object obj) {
                MoneyPennyPlaceOrderResult moneyPennyPlaceOrderResult = (MoneyPennyPlaceOrderResult) obj;
                MCheckoutSender.m15897a(this.f15710b, "p2p_send_success", moneyPennyItemParams);
                this.f15710b.f15712a.m18603a(moneyPennyPlaceOrderResult);
            }

            protected final void m15893a(ServiceException serviceException) {
                MCheckoutSender.m15897a(this.f15710b, "p2p_send_fail", moneyPennyItemParams);
                SimpleCheckoutSender simpleCheckoutSender = this.f15710b;
                simpleCheckoutSender.f15712a.m18602a();
                BLog.b(MCheckoutSender.f15713b, "Failed to place order", serviceException);
                simpleCheckoutSender.f15719h.a(MCheckoutSender.f15713b, "Attempted to place order, but received a response with an error", serviceException);
                if (serviceException.errorCode != ErrorCode.API_ERROR) {
                    PaymentConnectivityDialogFactory.a(simpleCheckoutSender.f15714c, serviceException);
                    return;
                }
                PaymentDialogsBuilder.m13299a(simpleCheckoutSender.f15714c, simpleCheckoutSender.f15714c.getString(2131240529), ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c()), simpleCheckoutSender.f15714c.getString(2131230726), new C18472(simpleCheckoutSender)).show();
            }
        }, this.f15716e);
        return this.f15722k;
    }

    public static void m15897a(MCheckoutSender mCheckoutSender, String str, MoneyPennyItemParams moneyPennyItemParams) {
        mCheckoutSender.f15715d.a(P2pPaymentsLogEvent.d(str, "mp_pay").o(String.valueOf(moneyPennyItemParams.f15477a)).a(moneyPennyItemParams.f15482f).a);
    }
}
