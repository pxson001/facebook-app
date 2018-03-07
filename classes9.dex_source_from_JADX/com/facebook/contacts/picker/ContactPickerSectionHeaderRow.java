package com.facebook.contacts.picker;

/* compiled from: pre_key */
public class ContactPickerSectionHeaderRow implements ContactIndexablePickerRow {
    public final String f6375a;
    private final String f6376b;

    public ContactPickerSectionHeaderRow(String str) {
        this(str, null);
    }

    private ContactPickerSectionHeaderRow(String str, String str2) {
        this.f6375a = str;
        this.f6376b = str2;
    }

    public final String mo258a() {
        return this.f6376b;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("header: ").append(this.f6375a);
        if (this.f6376b != null) {
            append.append(", key: ").append(this.f6376b);
        }
        return append.toString();
    }
}
