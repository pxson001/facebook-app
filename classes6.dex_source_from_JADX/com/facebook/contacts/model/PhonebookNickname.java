package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partition_start_offset */
public class PhonebookNickname extends PhonebookContactField {
    public static final Creator<PhonebookNickname> CREATOR = new C05191();
    public final String f8327a;

    /* compiled from: partition_start_offset */
    final class C05191 implements Creator<PhonebookNickname> {
        C05191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookNickname(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookNickname[i];
        }
    }

    public PhonebookNickname(String str, int i, String str2) {
        super(i, str2);
        this.f8327a = str;
    }

    public PhonebookNickname(Parcel parcel) {
        super(parcel);
        this.f8327a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8327a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookNickname) && Objects.equal(this.f8327a, ((PhonebookNickname) obj).f8327a);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8327a, Integer.valueOf(this.f8256i), this.f8257j});
    }
}
