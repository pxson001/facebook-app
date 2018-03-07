package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partner */
public class PhonebookInstantMessaging extends PhonebookContactField {
    public static final Creator<PhonebookInstantMessaging> CREATOR = new C05181();
    public final String f8324a;
    public final String f8325b;
    public final String f8326c;

    /* compiled from: partner */
    final class C05181 implements Creator<PhonebookInstantMessaging> {
        C05181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookInstantMessaging(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookInstantMessaging[i];
        }
    }

    public PhonebookInstantMessaging(String str, int i, String str2, String str3, String str4) {
        super(i, str2);
        this.f8324a = str;
        this.f8325b = str3;
        this.f8326c = str4;
    }

    public PhonebookInstantMessaging(Parcel parcel) {
        super(parcel);
        this.f8324a = parcel.readString();
        this.f8325b = parcel.readString();
        this.f8326c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8324a);
        parcel.writeString(this.f8325b);
        parcel.writeString(this.f8326c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookInstantMessaging) && Objects.equal(this.f8324a, ((PhonebookInstantMessaging) obj).f8324a) && Objects.equal(this.f8325b, ((PhonebookInstantMessaging) obj).f8325b) && Objects.equal(this.f8326c, ((PhonebookInstantMessaging) obj).f8326c);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8324a, Integer.valueOf(this.f8256i), this.f8257j, this.f8325b, this.f8326c});
    }
}
