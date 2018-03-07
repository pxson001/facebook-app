package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partitionInfo improperly configured */
public class PhonebookRelation extends PhonebookContactField {
    public static final Creator<PhonebookRelation> CREATOR = new C05221();
    public final String f8337a;

    /* compiled from: partitionInfo improperly configured */
    final class C05221 implements Creator<PhonebookRelation> {
        C05221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookRelation(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookRelation[i];
        }
    }

    public PhonebookRelation(String str, int i, String str2) {
        super(i, str2);
        this.f8337a = str;
    }

    public PhonebookRelation(Parcel parcel) {
        super(parcel);
        this.f8337a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8337a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookRelation) && Objects.equal(this.f8337a, ((PhonebookRelation) obj).f8337a);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8337a, Integer.valueOf(this.f8256i), this.f8257j});
    }
}
