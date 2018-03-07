package com.facebook.messaging.payment.value.input.checkout;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: enter_fullscreen_button */
public class MDescriptionCheckoutView extends CustomViewGroup implements PaymentsComponentView {
    private BetterTextView f15736a;

    public MDescriptionCheckoutView(Context context) {
        super(context);
        m15915a();
    }

    public MDescriptionCheckoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15915a();
    }

    public MDescriptionCheckoutView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15915a();
    }

    private void m15915a() {
        setContentView(2130905149);
        this.f15736a = (BetterTextView) getView(2131559627);
    }

    public void setText(@StringRes int i) {
        this.f15736a.setText(i);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}
