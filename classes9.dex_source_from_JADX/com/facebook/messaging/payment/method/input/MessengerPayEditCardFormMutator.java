package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.model.Address;
import com.facebook.messaging.payment.model.PartialPaymentCard;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.payments.paymentmethods.cardform.CardFormInput;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormMutator;
import com.facebook.payments.paymentmethods.cardform.protocol.CardFormProtocolUtil;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: incoming_uri */
public class MessengerPayEditCardFormMutator extends SimpleCardFormMutator {
    public static final Class<?> f13067b = MessengerPayEditCardFormMutator.class;
    public final Context f13068c;
    public final Provider<User> f13069d;
    public final AbstractFbErrorReporter f13070e;
    public final PaymentProtocolUtil f13071f;
    public final AnalyticsLogger f13072g;
    public final Executor f13073h;

    /* compiled from: incoming_uri */
    public class C14542 extends OperationResultFutureCallback {
        final /* synthetic */ MessengerPayEditCardFormMutator f13063a;

        public C14542(MessengerPayEditCardFormMutator messengerPayEditCardFormMutator) {
            this.f13063a = messengerPayEditCardFormMutator;
        }

        protected final void m13363a(ServiceException serviceException) {
            BLog.b(MessengerPayEditCardFormMutator.f13067b, "Card failed to set to be primary", serviceException);
            this.f13063a.f13070e.a("P2P_PAYMENT_CARD_SET_PRIMARY_FAILED", "Attempted to set a paymentcard as primary, but received a response with an error", serviceException);
            if (serviceException.errorCode != ErrorCode.API_ERROR) {
                PaymentConnectivityDialogFactory.a(this.f13063a.f13068c, serviceException);
            }
        }

        protected final void m13364a(Object obj) {
            if (this.f13063a.a != null) {
                this.f13063a.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
            }
        }
    }

    /* compiled from: incoming_uri */
    public class C14564 implements OnClickListener {
        final /* synthetic */ MessengerPayEditCardFormMutator f13066a;

        public C14564(MessengerPayEditCardFormMutator messengerPayEditCardFormMutator) {
            this.f13066a = messengerPayEditCardFormMutator;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MessengerPayEditCardFormMutator m13369c(InjectorLike injectorLike) {
        return new MessengerPayEditCardFormMutator((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3596), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), CardFormProtocolUtil.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerPayEditCardFormMutator(Context context, Provider<User> provider, FbErrorReporter fbErrorReporter, PaymentProtocolUtil paymentProtocolUtil, AnalyticsLogger analyticsLogger, CardFormProtocolUtil cardFormProtocolUtil, Executor executor) {
        super(context, executor, cardFormProtocolUtil);
        this.f13068c = context;
        this.f13069d = provider;
        this.f13070e = fbErrorReporter;
        this.f13071f = paymentProtocolUtil;
        this.f13072g = analyticsLogger;
        this.f13073h = executor;
    }

    public final ListenableFuture m13370a(final CardFormParams cardFormParams, final CardFormInput cardFormInput) {
        boolean z;
        PaymentCard paymentCard = (PaymentCard) cardFormParams.a().d;
        PaymentProtocolUtil paymentProtocolUtil = this.f13071f;
        String a = paymentCard.m13499a();
        int i = cardFormInput.c;
        int i2 = cardFormInput.d;
        String str = cardFormInput.e;
        String str2 = cardFormInput.f;
        if (paymentCard.f13208g) {
            z = false;
        } else {
            z = true;
        }
        ListenableFuture a2 = paymentProtocolUtil.m14957a(a, i, i2, str, str2, z);
        Futures.a(a2, new ResultFutureCallback<String>(this) {
            final /* synthetic */ MessengerPayEditCardFormMutator f13062c;

            protected final void m13361a(ServiceException serviceException) {
                this.f13062c.a(serviceException);
            }

            protected final void m13362a(Object obj) {
                MessengerPayEditCardFormMutator.m13368b(this.f13062c, cardFormParams, cardFormInput);
            }
        }, this.f13073h);
        return a2;
    }

    protected final String m13372a(ApiErrorResult apiErrorResult) {
        return this.f13068c.getString(2131240295);
    }

    public final ListenableFuture m13371a(CardFormParams cardFormParams, PaymentsComponentAction paymentsComponentAction) {
        String a = paymentsComponentAction.a("extra_mutation", null);
        if ("action_set_primary".equals(a)) {
            String a2 = paymentsComponentAction.a("payment_card_id", null);
            Preconditions.checkNotNull(a2);
            ListenableFuture a3 = this.f13071f.m14942a(Long.parseLong(a2), ((User) this.f13069d.get()).a, null);
            Futures.a(a3, new C14542(this), this.f13073h);
            return a3;
        } else if ("action_delete_payment_card".equals(a)) {
            return m13367b(paymentsComponentAction);
        } else {
            return super.a(cardFormParams, paymentsComponentAction);
        }
    }

    public static void m13368b(MessengerPayEditCardFormMutator messengerPayEditCardFormMutator, CardFormParams cardFormParams, CardFormInput cardFormInput) {
        if (messengerPayEditCardFormMutator.a != null) {
            PaymentCard paymentCard = (PaymentCard) cardFormParams.a().d;
            Object partialPaymentCard = new PartialPaymentCard(paymentCard.f13202a, paymentCard.m13503e(), cardFormInput.c, cardFormInput.d + 2000, new Address(cardFormInput.f), paymentCard.m13512q(), true, true);
            Parcelable intent = new Intent();
            intent.putExtra("partial_payment_card", partialPaymentCard);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_activity_result_data", intent);
            messengerPayEditCardFormMutator.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
        }
    }

    private ListenableFuture<OperationResult> m13367b(PaymentsComponentAction paymentsComponentAction) {
        this.f13072g.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_remove_card"));
        final PaymentCard paymentCard = (PaymentCard) paymentsComponentAction.a("payment_card");
        Preconditions.checkNotNull(paymentCard);
        ListenableFuture<OperationResult> a = this.f13071f.m14941a(paymentCard.f13202a);
        Futures.a(a, new OperationResultFutureCallback(this) {
            final /* synthetic */ MessengerPayEditCardFormMutator f13065b;

            protected final void m13365a(ServiceException serviceException) {
                MessengerPayEditCardFormMutator messengerPayEditCardFormMutator = this.f13065b;
                PaymentCard paymentCard = paymentCard;
                BLog.b(MessengerPayEditCardFormMutator.f13067b, "Card failed to delete", serviceException);
                messengerPayEditCardFormMutator.f13070e.a(MessengerPayEditCardFormMutator.f13067b.getSimpleName(), "Attempted to delete a paymentcard, but received a response with an error", serviceException);
                if (serviceException.errorCode != ErrorCode.API_ERROR) {
                    messengerPayEditCardFormMutator.f13072g.a(P2pPaymentsLogEvent.d("p2p_remove_card_fail", "p2p_settings").d(paymentCard.f13207f).k(serviceException.getMessage()).a);
                    PaymentConnectivityDialogFactory.a(messengerPayEditCardFormMutator.f13068c, serviceException);
                    return;
                }
                ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
                CharSequence a = ApiErrorResult.a(apiErrorResult.c());
                messengerPayEditCardFormMutator.f13072g.a(P2pPaymentsLogEvent.d("p2p_remove_card_fail", "p2p_settings").d(paymentCard.f13207f).k(a).a);
                new FbAlertDialogBuilder(messengerPayEditCardFormMutator.f13068c).a(apiErrorResult.a() == 10058 ? messengerPayEditCardFormMutator.f13068c.getString(2131240435) : messengerPayEditCardFormMutator.f13068c.getString(2131240434)).b(a).a(2131230726, new C14564(messengerPayEditCardFormMutator)).b();
            }

            protected final void m13366a(Object obj) {
                MessengerPayEditCardFormMutator messengerPayEditCardFormMutator = this.f13065b;
                messengerPayEditCardFormMutator.f13072g.a(P2pPaymentsLogEvent.d("p2p_remove_card_success", "p2p_settings").d(paymentCard.f13207f).a);
                if (messengerPayEditCardFormMutator.a != null) {
                    messengerPayEditCardFormMutator.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
                }
            }
        }, this.f13073h);
        return a;
    }
}
