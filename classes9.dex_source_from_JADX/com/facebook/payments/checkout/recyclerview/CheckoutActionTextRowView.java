package com.facebook.payments.checkout.recyclerview;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.payments.ui.PaymentsComponentViewGroup;
import javax.annotation.Nullable;

/* compiled from: canonical_presence_doublestale */
public class CheckoutActionTextRowView extends PaymentsComponentViewGroup {
    private TextView f18525a;

    public CheckoutActionTextRowView(Context context) {
        super(context);
        m18540a();
    }

    public CheckoutActionTextRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18540a();
    }

    public CheckoutActionTextRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18540a();
    }

    private void m18540a() {
        setContentView(2130903567);
        this.f18525a = (TextView) getView(2131558966);
    }

    public void setText(@StringRes int i) {
        this.f18525a.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f18525a.setText(charSequence);
    }
}
