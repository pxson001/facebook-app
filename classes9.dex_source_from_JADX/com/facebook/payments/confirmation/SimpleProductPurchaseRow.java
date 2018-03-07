package com.facebook.payments.confirmation;

/* compiled from: cached_csc_token */
public class SimpleProductPurchaseRow implements ConfirmationRow {
    public final String f18639a;

    public SimpleProductPurchaseRow(String str) {
        this.f18639a = str;
    }

    public final ConfirmationRowType mo733a() {
        return ConfirmationRowType.PRODUCT_PURCHASE_SECTION;
    }
}
