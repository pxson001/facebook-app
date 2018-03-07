package com.facebook.contacts.picker;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: prepay */
public final class ContactPickerFilterRowIdentifier {
    private final String f6311a;

    public ContactPickerFilterRowIdentifier(@Nonnull String str) {
        this.f6311a = (String) Preconditions.checkNotNull(str);
    }

    public static String m6734a(String str, String str2) {
        return StringFormatUtil.a("%s:%s", new Object[]{str, str2});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactPickerFilterRowIdentifier)) {
            return false;
        }
        return Objects.equal(this.f6311a, ((ContactPickerFilterRowIdentifier) obj).f6311a);
    }

    public final int hashCode() {
        return this.f6311a.hashCode();
    }
}
