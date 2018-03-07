package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SouvenirMetadataDeserializer.class)
@Immutable
@JsonSerialize(using = SouvenirMetadataSerializer.class)
/* compiled from: ROTATED_CCW */
public class SouvenirMetadata implements Parcelable {
    public static final Creator<SouvenirMetadata> CREATOR = new C20941();
    @JsonProperty("end_date")
    final long mEndDate;
    @JsonProperty("local_id")
    final String mId;
    @JsonProperty("shareability_score")
    final float mShareabilityScore;
    @JsonProperty("start_date")
    final long mStartDate;
    @JsonProperty("title")
    @Nullable
    final String mTitle;

    /* compiled from: ROTATED_CCW */
    final class C20941 implements Creator<SouvenirMetadata> {
        C20941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirMetadata[i];
        }
    }

    /* compiled from: ROTATED_CCW */
    public class Builder {
        @Nullable
        public String f24063a;
        @Nullable
        public String f24064b;
        public long f24065c;
        public long f24066d;
        private float f24067e = -1.0f;

        public final SouvenirMetadata m26168a() {
            return new SouvenirMetadata((String) Preconditions.checkNotNull(this.f24063a), this.f24064b, this.f24065c, this.f24066d, this.f24067e);
        }
    }

    public final String m26169a() {
        return this.mId;
    }

    @Nullable
    public final String m26170b() {
        return this.mTitle;
    }

    public final long m26171c() {
        return this.mStartDate;
    }

    public final long m26172d() {
        return this.mEndDate;
    }

    public String toString() {
        return String.format(Locale.US, "Souvenir(%s)", new Object[]{this.mId});
    }

    private SouvenirMetadata() {
        this.mId = null;
        this.mTitle = null;
        this.mStartDate = -1;
        this.mEndDate = -1;
        this.mShareabilityScore = -1.0f;
    }

    public SouvenirMetadata(Parcel parcel) {
        this.mId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mStartDate = parcel.readLong();
        this.mEndDate = parcel.readLong();
        this.mShareabilityScore = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mStartDate);
        parcel.writeLong(this.mEndDate);
        parcel.writeFloat(this.mShareabilityScore);
    }

    private SouvenirMetadata(String str, @Nullable String str2, long j, long j2, float f) {
        this.mId = str;
        this.mTitle = str2;
        this.mStartDate = j;
        this.mEndDate = j2;
        this.mShareabilityScore = f;
    }
}
