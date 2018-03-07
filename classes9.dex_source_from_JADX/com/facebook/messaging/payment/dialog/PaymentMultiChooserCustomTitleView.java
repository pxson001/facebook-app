package com.facebook.messaging.payment.dialog;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: initial_mqtt_push_state */
public class PaymentMultiChooserCustomTitleView extends CustomLinearLayout {
    public final BetterTextView f13004a;
    public final BetterTextView f13005b;

    public PaymentMultiChooserCustomTitleView(Context context) {
        this(context, null);
    }

    private PaymentMultiChooserCustomTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PaymentMultiChooserCustomTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906147);
        this.f13004a = (BetterTextView) a(2131558927);
        this.f13005b = (BetterTextView) a(2131558926);
    }
}
