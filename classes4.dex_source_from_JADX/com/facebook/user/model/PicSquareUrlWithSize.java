package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PicSquareUrlWithSizeDeserializer.class)
@Immutable
/* compiled from: sms_takeover_ro_action */
public class PicSquareUrlWithSize implements Parcelable {
    public static final Creator<PicSquareUrlWithSize> CREATOR = new C00951();
    @JsonProperty("size")
    public final int size;
    @JsonProperty("url")
    public final String url;

    /* compiled from: sms_takeover_ro_action */
    final class C00951 implements Creator<PicSquareUrlWithSize> {
        C00951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PicSquareUrlWithSize(parcel);
        }

        public final Object[] newArray(int i) {
            return new PicSquareUrlWithSize[i];
        }
    }

    public PicSquareUrlWithSize(int i, String str) {
        this.size = i;
        this.url = (String) Preconditions.checkNotNull(str);
    }

    public PicSquareUrlWithSize(Parcel parcel) {
        this.size = parcel.readInt();
        this.url = parcel.readString();
    }

    private PicSquareUrlWithSize() {
        this.size = 0;
        this.url = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.size);
        parcel.writeString(this.url);
    }
}
