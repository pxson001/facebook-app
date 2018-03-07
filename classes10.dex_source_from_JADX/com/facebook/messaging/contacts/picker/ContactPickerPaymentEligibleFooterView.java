package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: tap_trending_gif_item */
public class ContactPickerPaymentEligibleFooterView extends CustomViewGroup {
    public TextView f1900a;

    public ContactPickerPaymentEligibleFooterView(Context context) {
        this(context, null);
    }

    private ContactPickerPaymentEligibleFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ContactPickerPaymentEligibleFooterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905675);
        this.f1900a = (TextView) getView(2131559974);
    }
}
