package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: payload_attachment_format */
public class PhonebookContactField implements Parcelable {
    public static final Creator<PhonebookContactField> CREATOR = new C05141();
    public final int f8256i;
    public final String f8257j;

    /* compiled from: payload_attachment_format */
    final class C05141 implements Creator<PhonebookContactField> {
        C05141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookContactField(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookContactField[i];
        }
    }

    public PhonebookContactField(int i, String str) {
        this.f8256i = i;
        this.f8257j = str;
    }

    public PhonebookContactField(Parcel parcel) {
        this.f8256i = parcel.readInt();
        this.f8257j = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8256i);
        parcel.writeString(this.f8257j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhonebookContactField)) {
            return false;
        }
        PhonebookContactField phonebookContactField = (PhonebookContactField) obj;
        if (this.f8256i == phonebookContactField.f8256i && Objects.equal(this.f8257j, phonebookContactField.f8257j)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f8256i), this.f8257j});
    }
}
