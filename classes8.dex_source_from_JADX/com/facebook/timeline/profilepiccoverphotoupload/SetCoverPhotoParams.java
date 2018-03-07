package com.facebook.timeline.profilepiccoverphotoupload;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bitmaps.Dimension;
import com.google.common.base.Objects;

/* compiled from: mScheduleTime */
public class SetCoverPhotoParams implements Parcelable {
    public static final Creator<SetCoverPhotoParams> CREATOR = new C09591();
    public final long f9245a;
    public final RectF f9246b;
    public final Dimension f9247c;
    public final String f9248d;
    public final long f9249e;

    /* compiled from: mScheduleTime */
    final class C09591 implements Creator<SetCoverPhotoParams> {
        C09591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetCoverPhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetCoverPhotoParams[i];
        }
    }

    public SetCoverPhotoParams(long j, String str, RectF rectF, Dimension dimension, long j2) {
        this.f9248d = str;
        this.f9245a = j;
        this.f9246b = rectF;
        this.f9247c = dimension;
        this.f9249e = j2;
    }

    public SetCoverPhotoParams(Parcel parcel) {
        this.f9245a = parcel.readLong();
        this.f9248d = parcel.readString();
        this.f9246b = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.f9247c = new Dimension(parcel.readInt(), parcel.readInt());
        this.f9249e = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9245a);
        parcel.writeString(this.f9248d);
        parcel.writeParcelable(this.f9246b, i);
        parcel.writeInt(this.f9247c.b);
        parcel.writeInt(this.f9247c.a);
        parcel.writeLong(this.f9249e);
    }

    public final float m11014d() {
        return this.f9246b.centerX();
    }

    public final float m11015e() {
        return this.f9246b.centerY();
    }

    public final boolean m11016h() {
        return this.f9249e != 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("method", "SetCoverPhotoMethod").add("profileId", this.f9245a).add("photoFilePath", this.f9248d).add("normalizedBounds", this.f9246b).add("uncroppedDimensions", this.f9247c).add("photoId", this.f9249e).toString();
    }
}
