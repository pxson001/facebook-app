package com.facebook.ipc.media.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: THEATRE */
public final class LocalMediaData implements Parcelable, HasMediaData {
    public static final Creator<LocalMediaData> CREATOR = new C13531();
    @JsonProperty("date_taken")
    public final long mDateTaken;
    @JsonProperty("display_name")
    public final String mDisplayName;
    @JsonProperty(a = true, value = "media_data")
    final MediaData mMediaData;
    @JsonProperty("media_store_id")
    public final long mMediaStoreId;

    /* compiled from: THEATRE */
    final class C13531 implements Creator<LocalMediaData> {
        C13531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocalMediaData(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocalMediaData[i];
        }
    }

    /* compiled from: THEATRE */
    public class Builder {
        @Nullable
        public MediaData f14097a = null;
        public long f14098b;
        public String f14099c = "";
        public long f14100d = -1;

        public final Builder m23471a(MediaData mediaData) {
            this.f14097a = (MediaData) Preconditions.checkNotNull(mediaData);
            return this;
        }

        public final Builder m23472a(String str) {
            this.f14099c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final LocalMediaData m23473a() {
            return new LocalMediaData(this);
        }
    }

    public final String toString() {
        return String.format(Locale.US, "{LocalMediaData: %s, %d}", new Object[]{this.mMediaData, Long.valueOf(this.mMediaStoreId)});
    }

    public final MediaData mo1281b() {
        return this.mMediaData;
    }

    public final long m23475d() {
        return this.mMediaStoreId;
    }

    public LocalMediaData(Builder builder) {
        this.mMediaData = (MediaData) Preconditions.checkNotNull(builder.f14097a);
        this.mDateTaken = builder.f14098b;
        this.mDisplayName = builder.f14099c;
        this.mMediaStoreId = builder.f14100d;
    }

    public final Builder m23476e() {
        Builder a = new Builder().m23471a(this.mMediaData);
        a.f14098b = this.mDateTaken;
        a = a.m23472a(this.mDisplayName);
        a.f14100d = this.mMediaStoreId;
        return a;
    }

    private LocalMediaData() {
        this.mMediaData = null;
        this.mDateTaken = 0;
        this.mDisplayName = "";
        this.mMediaStoreId = -1;
    }

    public LocalMediaData(Parcel parcel) {
        this.mMediaData = (MediaData) parcel.readParcelable(MediaData.class.getClassLoader());
        this.mDateTaken = parcel.readLong();
        this.mDisplayName = parcel.readString();
        this.mMediaStoreId = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mMediaData, i);
        parcel.writeLong(this.mDateTaken);
        parcel.writeString(this.mDisplayName);
        parcel.writeLong(this.mMediaStoreId);
    }
}
