package com.facebook.payments.paymentsflow.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PaymentMethodView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: pageMargin */
public class PayView extends CustomLinearLayout {
    private View f4376a;
    private PaymentMethodView f4377b;
    private TextView f4378c;
    private ProgressBar f4379d;

    public PayView(Context context) {
        super(context);
        m5363a();
    }

    public PayView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5363a();
    }

    public PayView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5363a();
    }

    private void m5363a() {
        setContentView(2130906140);
        this.f4378c = (TextView) a(2131565782);
        this.f4376a = a(2131565783);
        this.f4377b = (PaymentMethodView) a(2131565784);
        this.f4379d = (ProgressBar) a(2131559418);
        m5364b();
    }

    private void setSelectPaymentMethodClickListener(OnClickListener onClickListener) {
        this.f4376a.setOnClickListener(onClickListener);
        this.f4378c.setOnClickListener(onClickListener);
    }

    private void m5364b() {
        this.f4379d.setVisibility(0);
        this.f4376a.setVisibility(8);
        this.f4378c.setVisibility(8);
    }

    @VisibleForTesting
    void setPaymentMethod(PaymentMethod paymentMethod) {
        this.f4379d.setVisibility(8);
        if (paymentMethod != null) {
            this.f4376a.setVisibility(0);
            this.f4378c.setVisibility(8);
            this.f4377b.setPaymentMethod(paymentMethod);
            return;
        }
        this.f4376a.setVisibility(8);
        this.f4378c.setVisibility(0);
    }

    public final void m5366b(PayViewController payViewController) {
        if (payViewController.m5394e()) {
            m5364b();
        } else {
            setPaymentMethod(payViewController.f4400k);
        }
    }

    public final void m5365a(PayViewController payViewController) {
        payViewController.f4405p = this;
        setSelectPaymentMethodClickListener(payViewController.m5393d());
        m5366b(payViewController);
    }
}
