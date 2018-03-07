package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.cards.ValidatePaymentCardBinResult;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormViewController;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initConferenceUserStates encounters null user list */
public class MessengerPayAddCardFormViewController extends SimpleCardFormViewController {
    public final Context f13021a;
    private final PaymentProtocolUtil f13022b;
    private final Executor f13023c;
    public String f13024d;
    private ListenableFuture<ValidatePaymentCardBinResult> f13025e;
    public SimplePaymentsComponentCallback f13026f;
    public final Listener f13027g = new C14481(this);

    /* compiled from: initConferenceUserStates encounters null user list */
    class C14481 implements Listener {
        final /* synthetic */ MessengerPayAddCardFormViewController f13019a;

        C14481(MessengerPayAddCardFormViewController messengerPayAddCardFormViewController) {
            this.f13019a = messengerPayAddCardFormViewController;
        }

        public final void m13326a() {
            MessengerPayAddCardFormViewController.m13332b(this.f13019a);
        }

        public final void m13327b() {
            MessengerPayAddCardFormViewController.m13332b(this.f13019a);
            if (this.f13019a.f13026f != null) {
                this.f13019a.f13026f.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/android/1528535330720775")));
            }
        }

        public final void m13328c() {
            MessengerPayAddCardFormViewController.m13332b(this.f13019a);
        }
    }

    /* compiled from: initConferenceUserStates encounters null user list */
    class C14492 extends ResultFutureCallback<ValidatePaymentCardBinResult> {
        final /* synthetic */ MessengerPayAddCardFormViewController f13020a;

        C14492(MessengerPayAddCardFormViewController messengerPayAddCardFormViewController) {
            this.f13020a = messengerPayAddCardFormViewController;
        }

        protected final void m13329a(ServiceException serviceException) {
            this.f13020a.f13024d = null;
            MessengerPayAddCardFormViewController messengerPayAddCardFormViewController = this.f13020a;
            if (serviceException.errorCode == ErrorCode.API_ERROR) {
                ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
                switch (apiErrorResult.a()) {
                    case 10064:
                    case 10065:
                    case 10066:
                        String a = ApiErrorResult.a(apiErrorResult.c());
                        if (messengerPayAddCardFormViewController.f13026f != null) {
                            Builder builder = new Builder(messengerPayAddCardFormViewController.f13021a.getString(2131240289), messengerPayAddCardFormViewController.f13021a.getString(2131240525));
                            builder.d = a;
                            builder = builder;
                            builder.c = messengerPayAddCardFormViewController.f13021a.getString(2131240291);
                            builder = builder;
                            builder.f = true;
                            PaymentsConfirmDialogFragment b = PaymentsConfirmDialogFragment.b(builder.a());
                            b.am = messengerPayAddCardFormViewController.f13027g;
                            messengerPayAddCardFormViewController.f13026f.a(b);
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Inject
    public MessengerPayAddCardFormViewController(Context context, PaymentProtocolUtil paymentProtocolUtil, Executor executor) {
        this.f13021a = context;
        this.f13022b = paymentProtocolUtil;
        this.f13023c = executor;
    }

    public final void m13334a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f13026f = simplePaymentsComponentCallback;
    }

    @Nullable
    public final ListenableFuture m13333a(CardFormParams cardFormParams, String str) {
        if (((MessengerPayCardFormParams) cardFormParams).f13032e) {
            return null;
        }
        String b = PaymentMethodInputFormattingUtils.b(str);
        if (b.length() < 6) {
            m13331a();
            return this.f13025e;
        }
        b = b.substring(0, 6);
        if (b.equals(this.f13024d)) {
            return this.f13025e;
        }
        m13331a();
        this.f13025e = this.f13022b.m14963b(b);
        this.f13024d = b;
        Futures.a(this.f13025e, new C14492(this), this.f13023c);
        return this.f13025e;
    }

    private void m13331a() {
        if (this.f13025e != null) {
            this.f13025e.cancel(true);
            this.f13025e = null;
        }
    }

    public static void m13332b(MessengerPayAddCardFormViewController messengerPayAddCardFormViewController) {
        messengerPayAddCardFormViewController.f13024d = null;
        if (messengerPayAddCardFormViewController.f13026f != null) {
            messengerPayAddCardFormViewController.f13026f.a(new PaymentsComponentAction(Action.RESET));
        }
    }
}
