package com.facebook.messaging.media.mediapicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mCanSend */
public final class MediaPickerEnvironment implements Parcelable {
    public static final Creator<MediaPickerEnvironment> CREATOR = new C13111();
    public static final MediaPickerEnvironment f11677a = new MediaPickerEnvironment(false, true, true, null, null);
    public final boolean f11678b;
    public final boolean f11679c;
    public final boolean f11680d;
    final ThreadKey f11681e;
    final String f11682f;

    /* compiled from: mCanSend */
    final class C13111 implements Creator<MediaPickerEnvironment> {
        C13111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaPickerEnvironment(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaPickerEnvironment[i];
        }
    }

    /* compiled from: mCanSend */
    public class Builder {
        public boolean f11672a;
        public boolean f11673b;
        public boolean f11674c;
        public ThreadKey f11675d;
        public String f11676e;

        public Builder() {
            this(MediaPickerEnvironment.f11677a);
        }

        private Builder(MediaPickerEnvironment mediaPickerEnvironment) {
            this.f11672a = false;
            this.f11673b = true;
            this.f11674c = true;
            this.f11672a = mediaPickerEnvironment.f11678b;
            this.f11673b = mediaPickerEnvironment.f11679c;
            this.f11674c = mediaPickerEnvironment.f11680d;
        }
    }

    private MediaPickerEnvironment(boolean z, boolean z2, boolean z3, @Nullable ThreadKey threadKey, @Nullable String str) {
        this.f11678b = z;
        this.f11679c = z2;
        this.f11680d = z3;
        this.f11681e = threadKey;
        this.f11682f = str;
    }

    public MediaPickerEnvironment(Builder builder) {
        this.f11678b = builder.f11672a;
        this.f11679c = builder.f11673b;
        this.f11680d = builder.f11674c;
        this.f11681e = builder.f11675d;
        this.f11682f = builder.f11676e;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f11678b);
        ParcelUtil.a(parcel, this.f11679c);
        ParcelUtil.a(parcel, this.f11680d);
        parcel.writeParcelable(this.f11681e, i);
        parcel.writeString(this.f11682f);
    }

    public MediaPickerEnvironment(Parcel parcel) {
        this.f11678b = ParcelUtil.a(parcel);
        this.f11679c = ParcelUtil.a(parcel);
        this.f11680d = ParcelUtil.a(parcel);
        this.f11681e = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f11682f = parcel.readString();
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("singleMediaItemOnly", this.f11678b).add("supportVideo", this.f11679c).add("sendInstantly", this.f11680d).add("threadKey", this.f11681e).add("pendingOfflineThreadingId", this.f11682f).toString();
    }
}
