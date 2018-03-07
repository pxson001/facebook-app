package com.facebook.account.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountCandidateContactPointDeserializer.class)
/* compiled from: local_content_food_photos_header_enabled */
public class AccountCandidateContactPoint implements Parcelable {
    public static final Creator<AccountCandidateContactPoint> CREATOR = new C10891();
    @JsonProperty("type")
    private String contactType;
    @JsonProperty("display")
    private String displayContactInfo;
    @JsonProperty("id")
    private String id;

    /* compiled from: local_content_food_photos_header_enabled */
    final class C10891 implements Creator<AccountCandidateContactPoint> {
        C10891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountCandidateContactPoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountCandidateContactPoint[i];
        }
    }

    public AccountCandidateContactPoint() {
        this.id = null;
        this.displayContactInfo = null;
        this.contactType = null;
    }

    public AccountCandidateContactPoint(Parcel parcel) {
        this.id = parcel.readString();
        this.displayContactInfo = parcel.readString();
        this.contactType = parcel.readString();
    }

    public final String m12079a() {
        return this.id;
    }

    public final String m12080b() {
        return this.displayContactInfo;
    }

    public final String m12081c() {
        return this.contactType;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.displayContactInfo);
        parcel.writeString(this.contactType);
    }
}
