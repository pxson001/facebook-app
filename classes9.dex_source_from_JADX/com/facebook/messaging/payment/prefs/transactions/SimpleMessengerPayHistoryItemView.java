package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friending/suggestion/{#%s}/{%s} */
public class SimpleMessengerPayHistoryItemView extends CustomLinearLayout {
    @Inject
    public PaymentCurrencyUtil f14414a;
    private MessengerPayHistoryItemViewCommonParams f14415b;

    private static <T extends View> void m14802a(Class<T> cls, T t) {
        m14803a((Object) t, t.getContext());
    }

    private static void m14803a(Object obj, Context context) {
        ((SimpleMessengerPayHistoryItemView) obj).f14414a = PaymentCurrencyUtil.m13192a(FbInjector.get(context));
    }

    public SimpleMessengerPayHistoryItemView(Context context) {
        this(context, null);
    }

    public SimpleMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected SimpleMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14802a(SimpleMessengerPayHistoryItemView.class, (View) this);
        setContentView(2130907106);
    }

    public void setMessengerPayHistoryItemViewCommonParams(MessengerPayHistoryItemViewCommonParams messengerPayHistoryItemViewCommonParams) {
        this.f14415b = messengerPayHistoryItemViewCommonParams;
        m14800a();
        m14804b();
        m14805c();
    }

    private void m14800a() {
        ((SimpleVariableTextLayoutView) findViewById(2131560124)).setText(this.f14415b.f14339b);
    }

    private void m14804b() {
        CharSequence a;
        String a2 = this.f14414a.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, this.f14415b.f14340c.m13469d(), this.f14415b.f14340c.m13467b());
        if (this.f14415b.f14342e) {
            a = StringFormatUtil.a("- %s", new Object[]{a2});
        } else {
            Object obj = a2;
        }
        ((FbTextView) findViewById(2131566208)).setText(a);
    }

    private void m14801a(PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f14414a = paymentCurrencyUtil;
    }

    private void m14805c() {
        MessengerPayHistoryStatusTextView messengerPayHistoryStatusTextView = (MessengerPayHistoryStatusTextView) findViewById(2131565033);
        MessengerPayHistoryStatusViewParams messengerPayHistoryStatusViewParams = this.f14415b.f14341d;
        messengerPayHistoryStatusTextView.setTypeface(messengerPayHistoryStatusViewParams.f14383a);
        messengerPayHistoryStatusTextView.setMessengerPayHistoryStatusState(messengerPayHistoryStatusViewParams.f14384b);
        if (StringUtil.a(messengerPayHistoryStatusViewParams.f14385c)) {
            messengerPayHistoryStatusTextView.setVisibility(8);
            return;
        }
        messengerPayHistoryStatusTextView.setText(messengerPayHistoryStatusViewParams.f14385c);
        messengerPayHistoryStatusTextView.setVisibility(0);
    }
}
