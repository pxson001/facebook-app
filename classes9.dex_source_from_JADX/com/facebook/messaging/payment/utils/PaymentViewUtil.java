package com.facebook.messaging.payment.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PartialPaymentCard;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import javax.inject.Inject;

/* compiled from: extra_shipping_address_params */
public class PaymentViewUtil {
    private final Context f15183a;
    private final MessagingDateUtil f15184b;

    public static PaymentViewUtil m15542b(InjectorLike injectorLike) {
        return new PaymentViewUtil((Context) injectorLike.getInstance(Context.class), MessagingDateUtil.a(injectorLike));
    }

    @Inject
    public PaymentViewUtil(Context context, MessagingDateUtil messagingDateUtil) {
        this.f15183a = context;
        this.f15184b = messagingDateUtil;
    }

    public final void m15543a(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.f15183a, 2130968655));
    }

    public final void m15545a(FloatingLabelTextView floatingLabelTextView, int i, long j) {
        m15544a(floatingLabelTextView, i, 0, j);
    }

    public final void m15544a(FloatingLabelTextView floatingLabelTextView, int i, int i2, long j) {
        Object obj;
        if (j > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            CharSequence string;
            floatingLabelTextView.setHint(i);
            if (i2 != 0) {
                string = this.f15183a.getString(i2, new Object[]{this.f15184b.d(j)});
            } else {
                string = this.f15184b.d(j);
            }
            floatingLabelTextView.setText(string);
            floatingLabelTextView.setVisibility(0);
            return;
        }
        floatingLabelTextView.setVisibility(8);
    }

    public static String m15541a(Context context, PaymentCard paymentCard) {
        if (paymentCard instanceof PartialPaymentCard) {
            return context.getString(2131240416, new Object[]{paymentCard.f13207f, "", paymentCard.m13503e()});
        }
        Object[] objArr = new Object[3];
        objArr[0] = paymentCard.f13207f;
        objArr[1] = paymentCard.mo522g().cardType.isPresent() ? context.getString(((Integer) paymentCard.mo522g().cardType.get()).intValue()) : "";
        objArr[2] = paymentCard.m13503e();
        return context.getString(2131240416, objArr);
    }
}
