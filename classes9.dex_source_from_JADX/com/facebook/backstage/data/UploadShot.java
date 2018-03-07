package com.facebook.backstage.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.google.common.base.Strings;
import java.util.TimeZone;

/* compiled from: resized_width */
public class UploadShot implements Parcelable, MediaItem {
    public static final Creator<UploadShot> CREATOR = new C05471();
    public final MediaType f5145a;
    public final String f5146b;
    public final String f5147c;
    public final String f5148d;
    public final UploadType f5149e;
    private final long f5150f;
    public final TimezoneDate f5151g;
    public final String f5152h;
    public String f5153i;
    public volatile int f5154j = 0;
    public volatile long f5155k = 1000;

    /* compiled from: resized_width */
    final class C05471 implements Creator<UploadShot> {
        C05471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadShot(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadShot[i];
        }
    }

    /* compiled from: resized_width */
    public enum UploadType {
        STACK,
        REPLY_FROM_THREAD,
        REPLY_FROM_STACK
    }

    public UploadShot(String str, String str2, MediaType mediaType, long j, String str3, String str4) {
        this.f5147c = str;
        this.f5153i = str2;
        this.f5145a = mediaType;
        this.f5146b = str3;
        this.f5150f = j;
        this.f5151g = new TimezoneDate(this.f5150f, (long) TimeZone.getDefault().getRawOffset());
        this.f5148d = "file://" + this.f5147c;
        this.f5152h = str4;
        if (!Strings.isNullOrEmpty(this.f5152h)) {
            this.f5149e = UploadType.REPLY_FROM_THREAD;
        } else if (Strings.isNullOrEmpty(this.f5146b)) {
            this.f5149e = UploadType.STACK;
        } else {
            this.f5149e = UploadType.REPLY_FROM_STACK;
        }
    }

    protected UploadShot(Parcel parcel) {
        this.f5147c = parcel.readString();
        this.f5153i = parcel.readString();
        this.f5145a = parcel.readInt() == 0 ? MediaType.PHOTO : MediaType.VIDEO;
        this.f5146b = parcel.readString();
        this.f5148d = parcel.readString();
        this.f5154j = parcel.readInt();
        this.f5155k = parcel.readLong();
        this.f5150f = parcel.readLong();
        this.f5152h = parcel.readString();
        this.f5151g = new TimezoneDate(this.f5150f, (long) TimeZone.getDefault().getRawOffset());
        if (!Strings.isNullOrEmpty(this.f5152h)) {
            this.f5149e = UploadType.REPLY_FROM_THREAD;
        } else if (Strings.isNullOrEmpty(this.f5146b)) {
            this.f5149e = UploadType.STACK;
        } else {
            this.f5149e = UploadType.REPLY_FROM_STACK;
        }
    }

    public final String m4920a() {
        return this.f5147c;
    }

    public final String m4921b() {
        return this.f5153i;
    }

    public final MediaType m4922c() {
        return this.f5145a;
    }

    public final String m4923d() {
        return this.f5146b;
    }

    public final long m4928j() {
        return this.f5150f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5147c);
        parcel.writeString(this.f5153i);
        parcel.writeInt(this.f5145a == MediaType.PHOTO ? 0 : 1);
        parcel.writeString(this.f5146b);
        parcel.writeString(this.f5148d);
        parcel.writeInt(this.f5154j);
        parcel.writeLong(this.f5155k);
        parcel.writeLong(this.f5150f);
        parcel.writeString(this.f5152h);
    }

    public final boolean mo172g() {
        return this.f5145a == MediaType.VIDEO;
    }

    public final String mo173h() {
        return this.f5153i;
    }

    public final String mo174i() {
        return mo172g() ? this.f5148d : null;
    }

    public final String mo171f() {
        return this.f5148d;
    }
}
