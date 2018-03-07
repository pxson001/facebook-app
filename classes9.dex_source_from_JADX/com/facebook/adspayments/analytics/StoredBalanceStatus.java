package com.facebook.adspayments.analytics;

import com.facebook.common.hasvalue.HasValue;
import com.facebook.common.hasvalue.HasValueUtil;
import com.google.common.base.MoreObjects;

/* compiled from: senderFbId */
public enum StoredBalanceStatus implements HasValue<String> {
    UNKNOWN("unknown"),
    PREPAY("prepay"),
    POSTPAY("postpay"),
    NEW_USER("new_user");
    
    private final String mValue;

    private StoredBalanceStatus(String str) {
        this.mValue = str;
    }

    public static StoredBalanceStatus of(String str) {
        return (StoredBalanceStatus) MoreObjects.firstNonNull(HasValueUtil.a(values(), str), UNKNOWN);
    }

    public final String getValue() {
        return this.mValue;
    }

    public final boolean isLockedIntoPrepay() {
        return this == PREPAY;
    }

    public final boolean isNUX() {
        return this == NEW_USER;
    }

    public final boolean isPUX() {
        return (this == NEW_USER || this == UNKNOWN) ? false : true;
    }

    public final String toString() {
        return getValue();
    }
}
