package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partitionStartOffset */
public class PhonebookPhoneNumber extends PhonebookContactField {
    public static final Creator<PhonebookPhoneNumber> CREATOR = new C05211();
    public final String f8335a;
    public final String f8336b;

    /* compiled from: partitionStartOffset */
    final class C05211 implements Creator<PhonebookPhoneNumber> {
        C05211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookPhoneNumber(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookPhoneNumber[i];
        }
    }

    public PhonebookPhoneNumber(String str, int i, String str2) {
        this(str, i, str2, null);
    }

    public PhonebookPhoneNumber(String str, int i, String str2, String str3) {
        super(i, str2);
        this.f8335a = str;
        this.f8336b = str3;
    }

    public PhonebookPhoneNumber(Parcel parcel) {
        super(parcel);
        this.f8335a = parcel.readString();
        this.f8336b = parcel.readString();
    }

    public final String m12111a() {
        if (this.f8256i == 1) {
            return "home";
        }
        if (this.f8256i == 3) {
            return "work";
        }
        if (this.f8256i == 2) {
            return "mobile";
        }
        if (this.f8256i == 5) {
            return "fax_home";
        }
        if (this.f8256i == 4) {
            return "fax_work";
        }
        if (this.f8256i == 13) {
            return "fax_other";
        }
        if (this.f8256i == 6) {
            return "pager";
        }
        return "other";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8335a);
        parcel.writeString(this.f8336b);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookPhoneNumber) && Objects.equal(this.f8335a, ((PhonebookPhoneNumber) obj).f8335a) && Objects.equal(this.f8336b, ((PhonebookPhoneNumber) obj).f8336b);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8335a, Integer.valueOf(this.f8256i), this.f8257j, this.f8336b});
    }
}
