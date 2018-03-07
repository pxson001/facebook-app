package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_sender_incentives_redeem */
public class UploadBulkContactFieldMatch implements Parcelable {
    public static final Creator<UploadBulkContactFieldMatch> CREATOR = new C05501();
    private final MatchType f8473a;
    private final ValueType f8474b;

    /* compiled from: p2p_sender_incentives_redeem */
    final class C05501 implements Creator<UploadBulkContactFieldMatch> {
        C05501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkContactFieldMatch(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkContactFieldMatch[i];
        }
    }

    /* compiled from: p2p_sender_incentives_redeem */
    public enum MatchType {
        HARD,
        SOFT
    }

    /* compiled from: p2p_sender_incentives_redeem */
    public enum ValueType {
        NAME,
        EMAIL,
        PHONE,
        EMAIL_PUBLIC_HASH,
        PHONE_PUBLIC_HASH
    }

    public UploadBulkContactFieldMatch(MatchType matchType, ValueType valueType) {
        this.f8473a = matchType;
        this.f8474b = valueType;
    }

    public UploadBulkContactFieldMatch(Parcel parcel) {
        this.f8473a = (MatchType) Enum.valueOf(MatchType.class, parcel.readString());
        this.f8474b = (ValueType) Enum.valueOf(ValueType.class, parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8473a.toString());
        parcel.writeString(this.f8474b.toString());
    }

    public String toString() {
        return super.toString() + " match type: " + this.f8473a + " value type: " + this.f8474b;
    }
}
