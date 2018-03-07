package com.facebook.messaging.payment.thread;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: failed writing trace event */
public class TransactionDollarAmountPaymentBubbleViewController implements PaymentBubbleViewController<CustomLinearLayout> {
    public final PaymentCurrencyUtil f15059a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, final Listener listener) {
        String a;
        String str;
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) view;
        DollarIconEditText dollarIconEditText = (DollarIconEditText) customLinearLayout.findViewById(2131565034);
        Message message = paymentViewParams.f15021b;
        if (message.B != null) {
            a = this.f15059a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, message.B.d, message.B.e);
            str = message.B.e;
        } else {
            a = this.f15059a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, this.f15059a.m13204b(message.u.c.a, message.u.c.b), message.u.c.b);
            str = message.u.c.b;
        }
        dollarIconEditText.m15482a(str, a);
        dollarIconEditText.setContentDescription(str + a);
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        if (paymentTransaction != null) {
            Object obj;
            int i = paymentViewParams.f15026g;
            if (paymentViewParams.f15021b.B != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                switch (paymentTransaction.f13234g) {
                    case R_COMPLETED:
                    case S_COMPLETED:
                    case S_SENT:
                        dollarIconEditText.setColor(i);
                        break;
                    default:
                        dollarIconEditText.m15483b();
                        break;
                }
            }
            dollarIconEditText.setColor(i);
        } else {
            dollarIconEditText.m15483b();
        }
        customLinearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TransactionDollarAmountPaymentBubbleViewController f15057b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1766177977);
                listener.m15384a();
                Logger.a(2, EntryType.UI_INPUT_END, -1615853233, a);
            }
        });
    }

    @Inject
    public TransactionDollarAmountPaymentBubbleViewController(PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15059a = paymentCurrencyUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return true;
    }
}
