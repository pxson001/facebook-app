package com.facebook.contacts.picker;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: prepay_disclaimer */
public class ContactPickerFilterResult {
    public final Type f6307a;
    @Nullable
    public final CharSequence f6308b;
    @Nullable
    public final ImmutableList<RowResult> f6309c;
    public final int f6310d;

    /* compiled from: prepay_disclaimer */
    public class RowResult {
        public final ImmutableList<ContactPickerRow> f6305a;
        public final String f6306b;

        public RowResult(ImmutableList<ContactPickerRow> immutableList, @Nullable String str) {
            this.f6305a = immutableList;
            this.f6306b = str;
        }
    }

    /* compiled from: prepay_disclaimer */
    public enum Type {
        OK,
        EMPTY_CONSTRAINT,
        EXCEPTION
    }

    public static ContactPickerFilterResult m6726a(CharSequence charSequence) {
        return new ContactPickerFilterResult(Type.EMPTY_CONSTRAINT, charSequence, null);
    }

    public static ContactPickerFilterResult m6728b(CharSequence charSequence) {
        return new ContactPickerFilterResult(Type.EXCEPTION, charSequence, null);
    }

    public static ContactPickerFilterResult m6727a(CharSequence charSequence, ImmutableList<ContactPickerRow> immutableList) {
        Preconditions.checkNotNull(immutableList);
        return new ContactPickerFilterResult(Type.OK, charSequence, ImmutableList.of(new RowResult(immutableList, null)));
    }

    public static ContactPickerFilterResult m6729b(CharSequence charSequence, ImmutableList<RowResult> immutableList) {
        return new ContactPickerFilterResult(Type.OK, charSequence, immutableList);
    }

    private ContactPickerFilterResult(Type type, @Nullable CharSequence charSequence, @Nullable ImmutableList<RowResult> immutableList) {
        int i = 0;
        this.f6307a = type;
        this.f6308b = charSequence;
        this.f6309c = immutableList;
        if (immutableList != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                i2 += ((RowResult) immutableList.get(i3)).f6305a.size();
            }
            i = i2;
        }
        this.f6310d = i;
    }

    public final Type m6730a() {
        return this.f6307a;
    }

    @Nullable
    public final CharSequence m6731b() {
        return this.f6308b;
    }

    public final int m6732c() {
        return this.f6310d;
    }

    public final ImmutableList<ContactPickerRow> m6733e() {
        if (this.f6309c == null || this.f6309c.isEmpty()) {
            return RegularImmutableList.a;
        }
        if (this.f6309c.size() == 1) {
            return ((RowResult) this.f6309c.get(0)).f6305a;
        }
        Builder builder = ImmutableList.builder();
        int size = this.f6309c.size();
        for (int i = 0; i < size; i++) {
            builder.b(((RowResult) this.f6309c.get(i)).f6305a);
        }
        return builder.b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State: ").append(this.f6307a).append(", ");
        stringBuilder.append("Constraints: ").append(this.f6308b);
        if (this.f6309c != null) {
            stringBuilder.append(", Count: ").append(this.f6309c.size());
        }
        return stringBuilder.toString();
    }
}
