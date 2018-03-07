package com.facebook.api.growth.contactimporter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonDeserializer
/* compiled from: sendQueueType */
public class UsersInviteResult implements Parcelable {
    public static final Creator<UsersInviteResult> CREATOR = new C03671();
    @JsonProperty("email")
    public final String email;
    @JsonProperty("invite_status")
    public final String inviteStatus;
    @JsonProperty("normalized_id")
    public final String normalizedId;
    @JsonProperty("uid")
    public final long userId;

    /* compiled from: sendQueueType */
    final class C03671 implements Creator<UsersInviteResult> {
        C03671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UsersInviteResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UsersInviteResult[i];
        }
    }

    public UsersInviteResult() {
        this(null, null, null, -1);
    }

    private UsersInviteResult(String str, String str2, String str3, long j) {
        this.email = str;
        this.inviteStatus = str2;
        this.normalizedId = str3;
        this.userId = j;
    }

    public UsersInviteResult(Parcel parcel) {
        this.email = parcel.readString();
        this.inviteStatus = parcel.readString();
        this.normalizedId = parcel.readString();
        this.userId = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.email);
        parcel.writeString(this.inviteStatus);
        parcel.writeString(this.normalizedId);
        parcel.writeLong(this.userId);
    }
}
