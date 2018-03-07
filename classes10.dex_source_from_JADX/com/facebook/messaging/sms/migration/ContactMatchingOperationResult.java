package com.facebook.messaging.sms.migration;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: qrcode_import_loaded */
public class ContactMatchingOperationResult {
    public static final ContactMatchingOperationResult f4122a = new ContactMatchingOperationResult(RegularImmutableList.a, RegularImmutableList.a);
    public final ImmutableList<SMSMatchedContactRow> f4123b;
    public final ImmutableList<SMSLocalContactRow> f4124c;

    public ContactMatchingOperationResult(ImmutableList<SMSMatchedContactRow> immutableList, ImmutableList<SMSLocalContactRow> immutableList2) {
        this.f4123b = immutableList;
        this.f4124c = immutableList2;
    }
}
