package com.facebook.messaging.payment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: facepile_users */
public class PaymentHeaderSubheaderLayout extends PaymentsComponentLinearLayout {
    private final BetterTextView f15134a;
    private final BetterTextView f15135b;

    private static <T extends View> void m15505a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15506a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentHeaderSubheaderLayout(Context context) {
        this(context, null);
    }

    public PaymentHeaderSubheaderLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected PaymentHeaderSubheaderLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15505a(PaymentHeaderSubheaderLayout.class, (View) this);
        setContentView(2130906144);
        this.f15134a = (BetterTextView) a(2131559441);
        this.f15135b = (BetterTextView) a(2131565803);
    }

    public void setHeader(int i) {
        this.f15134a.setText(i);
    }

    public void setHeader(CharSequence charSequence) {
        this.f15134a.setText(charSequence);
    }

    public void setHeaderVisibility(int i) {
        this.f15134a.setVisibility(i);
    }

    public void setSubheader(int i) {
        this.f15135b.setText(i);
    }

    public void setSubheader(CharSequence charSequence) {
        this.f15135b.setText(charSequence);
    }

    public void setSubheaderVisibility(int i) {
        this.f15135b.setVisibility(i);
    }
}
