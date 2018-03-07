package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partitionInfo */
public class PhonebookWebsite extends PhonebookContactField {
    public static final Creator<PhonebookWebsite> CREATOR = new C05231();
    public final String f8338a;

    /* compiled from: partitionInfo */
    final class C05231 implements Creator<PhonebookWebsite> {
        C05231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookWebsite(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookWebsite[i];
        }
    }

    public PhonebookWebsite(String str, int i, String str2) {
        super(i, str2);
        this.f8338a = str;
    }

    public PhonebookWebsite(Parcel parcel) {
        super(parcel);
        this.f8338a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8338a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookWebsite) && Objects.equal(this.f8338a, ((PhonebookWebsite) obj).f8338a);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8338a, Integer.valueOf(this.f8256i), this.f8257j});
    }
}
