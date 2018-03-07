package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partner_name */
public class PhonebookEvent extends PhonebookContactField {
    public static final Creator<PhonebookEvent> CREATOR = new C05171();
    public final String f8323a;

    /* compiled from: partner_name */
    final class C05171 implements Creator<PhonebookEvent> {
        C05171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookEvent(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookEvent[i];
        }
    }

    public PhonebookEvent(String str, int i, String str2) {
        super(i, str2);
        this.f8323a = str;
    }

    public PhonebookEvent(Parcel parcel) {
        super(parcel);
        this.f8323a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8323a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookEvent) && Objects.equal(this.f8323a, ((PhonebookEvent) obj).f8323a);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8323a, Integer.valueOf(this.f8256i), this.f8257j});
    }
}
