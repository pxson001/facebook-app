package com.facebook.messaging.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: p2p_csc_success */
public class AudioAttachmentData implements Parcelable {
    public static final Creator<AudioAttachmentData> CREATOR = new C08531();
    public final long f7702a;
    public final Uri f7703b;
    private final boolean f7704c;

    /* compiled from: p2p_csc_success */
    final class C08531 implements Creator<AudioAttachmentData> {
        C08531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AudioAttachmentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AudioAttachmentData[i];
        }
    }

    public AudioAttachmentData(long j, @Nullable Uri uri, boolean z) {
        this.f7702a = j;
        this.f7703b = uri;
        this.f7704c = z;
    }

    public AudioAttachmentData(Parcel parcel) {
        this.f7702a = parcel.readLong();
        this.f7703b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f7704c = parcel.readInt() > 0;
    }

    public final long m7998a() {
        return this.f7702a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AudioAttachmentData)) {
            return false;
        }
        AudioAttachmentData audioAttachmentData = (AudioAttachmentData) obj;
        if (this.f7702a == audioAttachmentData.f7702a && Objects.equal(this.f7703b, audioAttachmentData.f7703b) && this.f7704c == audioAttachmentData.f7704c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f7702a), this.f7703b, Boolean.valueOf(this.f7704c)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7702a);
        parcel.writeParcelable(this.f7703b, i);
        parcel.writeInt(this.f7704c ? 1 : 0);
    }
}
