package com.facebook.payments.checkout.statemachine;

import android.content.Context;
import com.facebook.messaging.payment.pin.PaymentPinConfirmActivity;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.checkout.CheckoutStyleAssociation;
import com.facebook.payments.checkout.SimpleCheckoutDataMutator;
import com.facebook.payments.checkout.SimpleCheckoutManager;
import com.facebook.payments.checkout.SimpleCheckoutSender;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.model.SendPaymentCheckoutResult;
import com.facebook.payments.checkout.model.SimpleCheckoutData;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutSubScreenParamsGenerator;
import com.facebook.payments.confirmation.ConfirmationActivity;
import com.facebook.payments.confirmation.ConfirmationCommonParams;
import com.facebook.payments.confirmation.ConfirmationCommonParamsBuilder;
import com.facebook.payments.confirmation.ConfirmationStyle;
import com.facebook.payments.decorator.PaymentsDecoratorAnimation;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.decorator.PaymentsDecoratorParams.Builder;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.UnmodifiableIterator;
import javax.inject.Inject;

/* compiled from: caller_camp_presence */
public class SimpleCheckoutStateMachineHandler {
    public final Context f18582a;
    public final SimpleCheckoutManager f18583b;
    public SimpleCheckoutDataMutator f18584c;
    public SimplePaymentsComponentCallback f18585d;
    public CheckoutData f18586e;
    public SendPaymentCheckoutResult f18587f;

    /* compiled from: caller_camp_presence */
    public class C21531 {
        final /* synthetic */ SimpleCheckoutStateMachineHandler f18580a;

        public C21531(SimpleCheckoutStateMachineHandler simpleCheckoutStateMachineHandler) {
            this.f18580a = simpleCheckoutStateMachineHandler;
        }

        public final void m18602a() {
            SimpleCheckoutStateMachineHandler.m18607g(this.f18580a);
        }

        public final void m18603a(SendPaymentCheckoutResult sendPaymentCheckoutResult) {
            this.f18580a.f18587f = sendPaymentCheckoutResult;
            SimpleCheckoutStateMachineHandler.m18608h(this.f18580a);
        }
    }

    public final void m18611a(CheckoutData checkoutData) {
        this.f18586e = (SimpleCheckoutData) checkoutData;
        this.f18584c = this.f18583b.m18492b(this.f18586e.mo717a().mo627a().f18459a);
    }

    @Inject
    public SimpleCheckoutStateMachineHandler(Context context, SimpleCheckoutManager simpleCheckoutManager) {
        this.f18582a = context;
        this.f18583b = simpleCheckoutManager;
    }

    public final void m18610a() {
        switch (this.f18586e.mo727k()) {
            case PREPARE_CHECKOUT:
                if (this.f18586e.mo718b()) {
                    m18608h(this);
                    return;
                }
                return;
            case VERIFY_PAYMENT_METHOD:
                m18605c();
                return;
            case PROCESSING_VERIFY_PAYMENT_METHOD:
            case PROCESSING_CHECK_PIN:
            case PROCESSING_SEND_PAYMENT:
                return;
            case CHECK_PIN:
                m18606d();
                return;
            case SEND_PAYMENT:
                SimpleCheckoutSender simpleCheckoutSender;
                m18608h(this);
                SimpleCheckoutManager simpleCheckoutManager = this.f18583b;
                CheckoutStyle checkoutStyle = this.f18586e.mo717a().mo627a().f18459a;
                if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
                    simpleCheckoutSender = (SimpleCheckoutSender) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15729g.get();
                } else {
                    simpleCheckoutSender = (SimpleCheckoutSender) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15729g.get();
                }
                SimpleCheckoutSender simpleCheckoutSender2 = simpleCheckoutSender;
                simpleCheckoutSender2.f15712a = new C21531(this);
                this.f18585d.a(simpleCheckoutSender2.mo631a(this.f18586e));
                return;
            case FINISH:
                boolean z;
                Preconditions.checkNotNull(this.f18587f);
                SimpleCheckoutSubScreenParamsGenerator d = this.f18583b.m18493d(this.f18586e.mo717a().mo627a().f18459a);
                CheckoutData checkoutData = this.f18586e;
                SendPaymentCheckoutResult sendPaymentCheckoutResult = this.f18587f;
                ConfirmationCommonParamsBuilder newBuilder = ConfirmationCommonParams.newBuilder();
                newBuilder.f18596a = ConfirmationStyle.SIMPLE;
                newBuilder = newBuilder;
                newBuilder.f18598c = sendPaymentCheckoutResult.mo598a();
                ConfirmationCommonParamsBuilder confirmationCommonParamsBuilder = newBuilder;
                if (checkoutData.mo720d().a().isPresent()) {
                    z = false;
                } else {
                    z = true;
                }
                confirmationCommonParamsBuilder.f18597b = z;
                this.f18585d.a(ConfirmationActivity.m18613a(this.f18582a, confirmationCommonParamsBuilder.m18623d()));
                this.f18585d.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
                return;
            default:
                throw new IllegalStateException("Invalid state found + " + this.f18586e.mo727k());
        }
    }

    private void m18605c() {
        PaymentMethod paymentMethod = (PaymentMethod) this.f18586e.mo728l().get();
        if (paymentMethod.b() == PaymentMethodType.CREDIT_CARD && ((CreditCard) paymentMethod).j()) {
            m18608h(this);
            CreditCard creditCard = (CreditCard) paymentMethod;
            SimpleCheckoutSubScreenParamsGenerator d = this.f18583b.m18493d(this.f18586e.mo717a().mo627a().f18459a);
            CheckoutData checkoutData = this.f18586e;
            CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
            newBuilder.b = checkoutData.mo717a().mo627a().f18460b.toString();
            CardFormAnalyticsParams c = newBuilder.c();
            Builder a = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
            a.a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
            PaymentsDecoratorParams c2 = a.c();
            CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
            newBuilder2.c = c2;
            CardFormStyleParams e = newBuilder2.e();
            CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
            newBuilder3.a = CardFormStyle.SIMPLE;
            newBuilder3 = newBuilder3;
            newBuilder3.d = creditCard;
            newBuilder3 = newBuilder3;
            newBuilder3.e = checkoutData.mo717a().mo627a().f18460b;
            newBuilder3 = newBuilder3;
            newBuilder3.b = c;
            CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder3;
            cardFormCommonParamsBuilder.c = e;
            this.f18585d.a(CardFormActivity.a(this.f18582a, cardFormCommonParamsBuilder.f()), 106);
            return;
        }
        m18609i();
    }

    private void m18606d() {
        if (this.f18586e.mo720d().a().isPresent()) {
            m18608h(this);
            this.f18585d.a(PaymentPinConfirmActivity.m14132a(this.f18582a), 105);
            return;
        }
        m18609i();
    }

    public static void m18607g(SimpleCheckoutStateMachineHandler simpleCheckoutStateMachineHandler) {
        simpleCheckoutStateMachineHandler.f18584c.m15940a(simpleCheckoutStateMachineHandler.f18586e, false);
        simpleCheckoutStateMachineHandler.f18584c.m15933a(simpleCheckoutStateMachineHandler.f18586e, CheckoutStateMachineState.PREPARE_CHECKOUT);
    }

    public static void m18608h(SimpleCheckoutStateMachineHandler simpleCheckoutStateMachineHandler) {
        simpleCheckoutStateMachineHandler.f18584c.m15933a(simpleCheckoutStateMachineHandler.f18586e, m18604a(simpleCheckoutStateMachineHandler.f18583b.m18494g(simpleCheckoutStateMachineHandler.f18586e.mo717a().mo627a().f18459a).m18612a(simpleCheckoutStateMachineHandler.f18586e), simpleCheckoutStateMachineHandler.f18586e.mo727k()));
    }

    private void m18609i() {
        ImmutableSortedMap a = this.f18583b.m18494g(this.f18586e.mo717a().mo627a().f18459a).m18612a(this.f18586e);
        this.f18584c.m15933a(this.f18586e, m18604a(a, m18604a(a, this.f18586e.mo727k())));
    }

    @VisibleForTesting
    private static CheckoutStateMachineState m18604a(ImmutableSortedMap<Integer, CheckoutStateMachineState> immutableSortedMap, CheckoutStateMachineState checkoutStateMachineState) {
        UnmodifiableIterator it = immutableSortedMap.c.iterator();
        while (it.hasNext()) {
            if (immutableSortedMap.get(it.next()) == checkoutStateMachineState) {
                return (CheckoutStateMachineState) immutableSortedMap.get(it.next());
            }
        }
        throw new IllegalStateException("No more states, reached end of state machine: " + checkoutStateMachineState);
    }
}
