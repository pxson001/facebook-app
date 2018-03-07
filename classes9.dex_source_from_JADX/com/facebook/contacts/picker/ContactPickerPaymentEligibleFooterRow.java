package com.facebook.contacts.picker;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;

/* compiled from: pre_key_with_id */
public class ContactPickerPaymentEligibleFooterRow implements ContactPickerRow {
    public final String f6366a;

    public ContactPickerPaymentEligibleFooterRow(String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f6366a = str;
    }
}
