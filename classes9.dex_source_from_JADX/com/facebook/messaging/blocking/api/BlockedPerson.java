package com.facebook.messaging.blocking.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.stringformat.StringFormatUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonDeserializer
/* compiled from: onPhotoPicked() invoked without pending callback */
public class BlockedPerson implements Parcelable {
    public static final Creator<BlockedPerson> CREATOR = new C09421();
    @JsonProperty("block_time")
    private final String mBlockedDate;
    @JsonProperty("block_type")
    private final BlockType mBlockedType;
    @JsonProperty("fbid")
    private final String mFbid;
    @JsonProperty("name")
    private final String mName;

    /* compiled from: onPhotoPicked() invoked without pending callback */
    final class C09421 implements Creator<BlockedPerson> {
        C09421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BlockedPerson(parcel);
        }

        public final Object[] newArray(int i) {
            return new BlockedPerson[i];
        }
    }

    /* compiled from: onPhotoPicked() invoked without pending callback */
    public enum BlockType {
        facebook,
        messenger
    }

    public BlockedPerson() {
        this.mFbid = null;
        this.mName = null;
        this.mBlockedType = null;
        this.mBlockedDate = null;
    }

    public BlockedPerson(Parcel parcel) {
        this.mFbid = parcel.readString();
        this.mName = parcel.readString();
        this.mBlockedType = BlockType.valueOf(parcel.readString());
        this.mBlockedDate = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFbid);
        parcel.writeString(this.mName);
        parcel.writeString(this.mBlockedType.name());
        parcel.writeString(this.mBlockedDate);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("fbid %s, name %s, block_type %s, block_date %s", this.mFbid, this.mName, this.mBlockedType, this.mBlockedDate);
    }
}
