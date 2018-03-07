package com.facebook.payments.picker.model;

/* compiled from: batch_index */
public enum RowType {
    COUNTRY_SELECTOR,
    HEADER,
    EXISTING_PAYMENT_METHOD(true),
    SINGLE_ROW_DIVIDER,
    SPACED_DOUBLE_ROW_DIVIDER,
    ADD_CARD,
    ADD_PAYPAL,
    ADD_SHIPPING_ADDRESS,
    COMMERCE_COMMERCE_SIMPLE_ADD_PAYMENT_METHOD,
    SHIPPING_ADDRESS(true),
    SHIPPING_OPTION(true),
    VIEW_FULL_HISTORY,
    SECURITY_FOOTER;
    
    private final boolean mSelectable;

    private RowType(boolean z) {
        this.mSelectable = z;
    }

    public final boolean isSelectable() {
        return this.mSelectable;
    }
}
