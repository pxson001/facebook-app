package com.facebook.payments.checkout.recyclerview;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.payments.ui.PaymentsComponentFrameLayout;
import com.facebook.widget.text.BetterButton;
import javax.annotation.Nullable;

/* compiled from: cannot read exif */
public class PayButtonCheckoutView extends PaymentsComponentFrameLayout {
    private BetterButton f18536a;
    private ProgressBar f18537b;
    private View f18538c;

    public PayButtonCheckoutView(Context context) {
        super(context);
        m18554g();
    }

    public PayButtonCheckoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18554g();
    }

    public PayButtonCheckoutView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18554g();
    }

    private void m18554g() {
        setContentView(2130903569);
        this.f18536a = (BetterButton) c(2131560316);
        this.f18537b = (ProgressBar) c(2131559418);
        this.f18538c = c(2131560317);
        ViewCompat.g(this.f18537b, (float) getResources().getDimensionPixelOffset(2131433380));
        ViewCompat.g(this.f18538c, (float) getResources().getDimensionPixelOffset(2131433380));
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f18536a.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f18536a.setOnClickListener(onClickListener);
    }

    public void setPayButtonText(CharSequence charSequence) {
        this.f18536a.setText(charSequence);
    }

    public void setPayButtonText(@StringRes int i) {
        this.f18536a.setText(i);
    }

    public final void m18555a() {
        this.f18536a.setAlpha(0.4f);
        this.f18537b.setVisibility(0);
    }

    public final void m18556b() {
        this.f18536a.setAlpha(1.0f);
        this.f18537b.setVisibility(8);
    }

    public final void m18557e() {
        this.f18536a.setAlpha(0.4f);
        this.f18538c.setVisibility(0);
    }

    public final void m18558f() {
        this.f18536a.setAlpha(1.0f);
        this.f18538c.setVisibility(8);
    }
}
