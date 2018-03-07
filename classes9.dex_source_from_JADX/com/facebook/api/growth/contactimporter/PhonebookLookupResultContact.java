package com.facebook.api.growth.contactimporter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
/* compiled from: send_confirmation_code_result */
public class PhonebookLookupResultContact implements Parcelable {
    public static final Creator<PhonebookLookupResultContact> CREATOR = new C03641();
    @JsonProperty("email")
    public final String email;
    @JsonProperty("is_friend")
    public final boolean isFriend;
    @JsonProperty("mutual_friends")
    public final int mutualFriends;
    @JsonProperty("name")
    public String name;
    @JsonProperty("native_name")
    public final String nativeName;
    @JsonProperty("ordinal")
    public final long ordinal;
    @JsonProperty("cell")
    public final String phone;
    @JsonProperty("pic_square_with_logo")
    public final String profilePic;
    @JsonProperty("record_id")
    public final long recordId;
    @JsonProperty("uid")
    public final long userId;

    /* compiled from: send_confirmation_code_result */
    final class C03641 implements Creator<PhonebookLookupResultContact> {
        C03641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookLookupResultContact(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookLookupResultContact[i];
        }
    }

    public PhonebookLookupResultContact() {
        this(null, -1, null, null, -1, false, null, 0, null, 0);
    }

    private PhonebookLookupResultContact(String str, long j, String str2, String str3, long j2, boolean z, String str4, long j3, String str5, int i) {
        this.name = str;
        this.recordId = j;
        this.email = str2;
        this.phone = str3;
        this.userId = j2;
        this.isFriend = z;
        this.profilePic = str4;
        this.ordinal = j3;
        this.nativeName = str5;
        this.mutualFriends = i;
    }

    public PhonebookLookupResultContact(Parcel parcel) {
        this.name = parcel.readString();
        this.recordId = parcel.readLong();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.userId = parcel.readLong();
        this.isFriend = parcel.readByte() != (byte) 0;
        this.profilePic = parcel.readString();
        this.ordinal = parcel.readLong();
        this.nativeName = parcel.readString();
        this.mutualFriends = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.recordId);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeLong(this.userId);
        parcel.writeByte(this.isFriend ? (byte) 1 : (byte) 0);
        parcel.writeString(this.profilePic);
        parcel.writeLong(this.ordinal);
        parcel.writeString(this.nativeName);
        parcel.writeInt(this.mutualFriends);
    }
}
