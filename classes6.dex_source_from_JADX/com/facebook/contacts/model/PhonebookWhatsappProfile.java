package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partitionEndOffset */
public class PhonebookWhatsappProfile implements Parcelable {
    public static final Creator<PhonebookWhatsappProfile> CREATOR = new C05241();
    public final String f8339a;
    public final String f8340b;

    /* compiled from: partitionEndOffset */
    final class C05241 implements Creator<PhonebookWhatsappProfile> {
        C05241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookWhatsappProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookWhatsappProfile[i];
        }
    }

    public PhonebookWhatsappProfile(String str, String str2) {
        this.f8339a = str;
        this.f8340b = str2;
    }

    public PhonebookWhatsappProfile(Parcel parcel) {
        this.f8339a = parcel.readString();
        this.f8340b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8339a);
        parcel.writeString(this.f8340b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhonebookWhatsappProfile)) {
            return false;
        }
        PhonebookWhatsappProfile phonebookWhatsappProfile = (PhonebookWhatsappProfile) obj;
        if (Objects.equal(this.f8339a, phonebookWhatsappProfile.f8339a) && Objects.equal(this.f8340b, phonebookWhatsappProfile.f8340b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8339a, this.f8340b});
    }
}
