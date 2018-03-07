package com.facebook.messaging.payment.value.input;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.messaging.model.payment.SentPayment;
import com.facebook.messaging.model.payment.SentPaymentBuilder;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import java.math.BigDecimal;
import javax.inject.Inject;

/* compiled from: event_name */
public class OrionMessengerPaySender implements MessengerPaySender {
    private final PaymentCurrencyUtil f15526a;
    private final CompositeMessengerPayLogger f15527b;
    private MessengerPayData f15528c;
    private C17758 f15529d;

    @Inject
    public OrionMessengerPaySender(PaymentCurrencyUtil paymentCurrencyUtil, CompositeMessengerPayLogger compositeMessengerPayLogger) {
        this.f15526a = paymentCurrencyUtil;
        this.f15527b = compositeMessengerPayLogger;
    }

    public final void mo616a(C17758 c17758) {
        this.f15529d = c17758;
    }

    public final void mo614a() {
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        boolean z;
        String str = null;
        this.f15528c = messengerPayData;
        OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) bundle.getParcelable("orion_messenger_pay_params");
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        Intent intent = new Intent();
        intent.putExtra("show_card_added_nux", this.f15528c.f15467x);
        intent.putExtra("show_pin_nux", this.f15528c.f15466w);
        String str2 = this.f15528c.f15462s.f15442a;
        String str3 = this.f15528c.f15462s.f15443b;
        BigDecimal a = this.f15526a.m13201a(str2, str3);
        long m = ((PaymentCard) this.f15528c.f15449f.get()).m13511m();
        String b = this.f15528c.f15460q.b();
        str2 = orionMessengerPayParams.f15517f != null ? orionMessengerPayParams.f15517f.m13756d() : null;
        SentPaymentBuilder newBuilder = SentPayment.newBuilder();
        newBuilder.a = a.toString();
        SentPaymentBuilder sentPaymentBuilder = newBuilder;
        sentPaymentBuilder.b = str3;
        SentPaymentBuilder sentPaymentBuilder2 = sentPaymentBuilder;
        sentPaymentBuilder2.c = m;
        sentPaymentBuilder2 = sentPaymentBuilder2;
        sentPaymentBuilder2.d = b;
        sentPaymentBuilder2 = sentPaymentBuilder2;
        sentPaymentBuilder2.f = this.f15528c.f15465v;
        sentPaymentBuilder2 = sentPaymentBuilder2;
        sentPaymentBuilder2.e = this.f15528c.f15463t;
        sentPaymentBuilder2 = sentPaymentBuilder2;
        if (orionMessengerPayParams.f15515d.equals("")) {
            z = false;
        } else {
            z = true;
        }
        sentPaymentBuilder2.g = z;
        sentPaymentBuilder2 = sentPaymentBuilder2;
        sentPaymentBuilder2.h = str2;
        SentPaymentBuilder sentPaymentBuilder3 = sentPaymentBuilder2;
        sentPaymentBuilder3.j = orionMessengerPayParams.f15518g;
        sentPaymentBuilder3 = sentPaymentBuilder3;
        sentPaymentBuilder3.i = this.f15527b.m15565a(messengerPayType);
        SentPaymentBuilder sentPaymentBuilder4 = sentPaymentBuilder3;
        if (this.f15528c.f15458o != null) {
            str = this.f15528c.f15458o.m13942d();
        }
        sentPaymentBuilder4.k = str;
        SentPayment l = sentPaymentBuilder4.l();
        intent.putExtra("recipient_id", this.f15528c.f15460q.b());
        intent.putExtra("sent_payment", l);
        intent.putExtra("thread_key", orionMessengerPayParams.f15514c);
        this.f15529d.m15637a(intent);
    }
}
