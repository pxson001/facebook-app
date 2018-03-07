package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: passed in null objects for both pending and uploaded story objects */
public class PhonebookEmailAddress extends PhonebookContactField {
    public static final Creator<PhonebookEmailAddress> CREATOR = new C05161();
    public final String f8321a;
    public final String f8322b;

    /* compiled from: passed in null objects for both pending and uploaded story objects */
    final class C05161 implements Creator<PhonebookEmailAddress> {
        C05161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookEmailAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookEmailAddress[i];
        }
    }

    public PhonebookEmailAddress(String str, int i, String str2) {
        this(str, i, str2, null);
    }

    public PhonebookEmailAddress(String str, int i, String str2, String str3) {
        super(i, str2);
        this.f8321a = str;
        this.f8322b = str3;
    }

    public PhonebookEmailAddress(Parcel parcel) {
        super(parcel);
        this.f8321a = parcel.readString();
        this.f8322b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8321a);
        parcel.writeString(this.f8322b);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookEmailAddress) && Objects.equal(this.f8321a, ((PhonebookEmailAddress) obj).f8321a) && Objects.equal(this.f8322b, ((PhonebookEmailAddress) obj).f8322b);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8321a, Integer.valueOf(this.f8256i), this.f8257j, this.f8322b});
    }
}
