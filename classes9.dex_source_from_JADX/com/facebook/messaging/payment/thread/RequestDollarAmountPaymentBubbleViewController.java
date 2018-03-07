package com.facebook.messaging.payment.thread;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: failed_fetch_pinned_threads */
public class RequestDollarAmountPaymentBubbleViewController implements PaymentBubbleViewController<CustomLinearLayout> {
    public final PaymentCurrencyUtil f15043a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, final Listener listener) {
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) view;
        DollarIconEditText dollarIconEditText = (DollarIconEditText) customLinearLayout.findViewById(2131565034);
        Message message = paymentViewParams.f15021b;
        dollarIconEditText.m15482a(message.C.e, this.f15043a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, message.C.d, message.C.e));
        dollarIconEditText.m15483b();
        customLinearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RequestDollarAmountPaymentBubbleViewController f15042b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -309271828);
                listener.m15384a();
                Logger.a(2, EntryType.UI_INPUT_END, 408103668, a);
            }
        });
    }

    @Inject
    public RequestDollarAmountPaymentBubbleViewController(PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15043a = paymentCurrencyUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return true;
    }
}
