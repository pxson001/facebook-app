package com.facebook.payments.checkout.recyclerview;

import android.net.Uri;

/* compiled from: can have at most one child */
public class TermsAndPoliciesCheckoutRow implements CheckoutRow {
    public final String f18559a;
    public final Uri f18560b;

    public TermsAndPoliciesCheckoutRow(String str, Uri uri) {
        this.f18559a = str;
        this.f18560b = uri;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.TERMS_AND_POLICIES;
    }

    public final boolean mo636b() {
        return true;
    }

    public final boolean mo637c() {
        return false;
    }
}
