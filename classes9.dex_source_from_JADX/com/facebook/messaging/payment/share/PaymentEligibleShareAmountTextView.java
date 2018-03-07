package com.facebook.messaging.payment.share;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.utils.PaymentTextUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchPaymentCards */
public class PaymentEligibleShareAmountTextView extends CustomLinearLayout {
    @Inject
    PaymentCurrencyUtil f14796a;
    @Inject
    PaymentTextUtils f14797b;
    private BetterTextView f14798c;

    private static <T extends View> void m15220a(Class<T> cls, T t) {
        m15221a((Object) t, t.getContext());
    }

    private static void m15221a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentEligibleShareAmountTextView) obj).m15219a(PaymentCurrencyUtil.m13192a(injectorLike), PaymentTextUtils.m15538b(injectorLike));
    }

    public PaymentEligibleShareAmountTextView(Context context) {
        this(context, null);
    }

    public PaymentEligibleShareAmountTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentEligibleShareAmountTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15218a();
    }

    public void setAmount(Amount amount) {
        setupTextView(amount);
        m15222b();
    }

    private void m15218a() {
        m15220a(PaymentEligibleShareAmountTextView.class, (View) this);
        setContentView(2130905840);
        this.f14798c = (BetterTextView) findViewById(2131565100);
    }

    private void setupTextView(Amount amount) {
        Object a = this.f14796a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, amount.m13469d(), amount.m13467b());
        this.f14798c.setText(a);
        this.f14798c.setTextSize(0, (float) this.f14797b.m15539a(a.length()));
    }

    private void m15219a(PaymentCurrencyUtil paymentCurrencyUtil, PaymentTextUtils paymentTextUtils) {
        this.f14796a = paymentCurrencyUtil;
        this.f14797b = paymentTextUtils;
    }

    private void m15222b() {
        Drawable drawable = getResources().getDrawable(2130842539);
        BetterTextView betterTextView = this.f14798c;
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        layerDrawable.setLayerInset(0, 0, 0, 0, (((int) betterTextView.getTextSize()) - drawable.getIntrinsicHeight()) / 2);
        betterTextView.setCompoundDrawablesWithIntrinsicBounds(layerDrawable, null, null, null);
    }
}
