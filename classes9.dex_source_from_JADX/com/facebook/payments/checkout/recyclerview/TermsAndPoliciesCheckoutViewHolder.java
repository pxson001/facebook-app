package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: campaign_group */
public class TermsAndPoliciesCheckoutViewHolder extends PaymentsComponentViewHolder<TermsAndPoliciesCheckoutView, TermsAndPoliciesCheckoutRow> {
    private SimplePaymentsComponentCallback f18564l;

    public final void m18592a(PaymentsComponentRow paymentsComponentRow) {
        TermsAndPoliciesCheckoutRow termsAndPoliciesCheckoutRow = (TermsAndPoliciesCheckoutRow) paymentsComponentRow;
        TermsAndPoliciesCheckoutView termsAndPoliciesCheckoutView = (TermsAndPoliciesCheckoutView) this.a;
        termsAndPoliciesCheckoutView.setPaymentsComponentCallback(this.f18564l);
        termsAndPoliciesCheckoutView.m18591a(termsAndPoliciesCheckoutRow.f18559a, termsAndPoliciesCheckoutRow.f18560b);
    }

    public TermsAndPoliciesCheckoutViewHolder(TermsAndPoliciesCheckoutView termsAndPoliciesCheckoutView) {
        super(termsAndPoliciesCheckoutView);
    }

    public final void m18593a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18564l = simplePaymentsComponentCallback;
    }
}
