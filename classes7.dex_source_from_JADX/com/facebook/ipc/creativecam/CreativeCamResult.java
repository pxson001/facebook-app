package com.facebook.ipc.creativecam;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import javax.annotation.Nullable;

/* compiled from: placeholder of time domain transforms not zeroed out */
public class CreativeCamResult implements Parcelable {
    public static final Creator<CreativeCamResult> CREATOR = new C05551();
    @Nullable
    private final Uri f6181a;
    @Nullable
    public final Uri f6182b;
    @Nullable
    public final CreativeEditingData f6183c;

    /* compiled from: placeholder of time domain transforms not zeroed out */
    final class C05551 implements Creator<CreativeCamResult> {
        C05551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeCamResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeCamResult[i];
        }
    }

    /* compiled from: placeholder of time domain transforms not zeroed out */
    public class Builder {
        @Nullable
        public Uri f6178a;
        @Nullable
        public Uri f6179b;
        @Nullable
        public CreativeEditingData f6180c;

        public final CreativeCamResult m8046a() {
            return new CreativeCamResult(this.f6178a, this.f6179b, this.f6180c);
        }
    }

    public CreativeCamResult(@Nullable Uri uri, @Nullable Uri uri2, @Nullable CreativeEditingData creativeEditingData) {
        this.f6181a = uri;
        this.f6182b = uri2;
        this.f6183c = creativeEditingData;
    }

    public CreativeCamResult(Parcel parcel) {
        this.f6181a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f6182b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f6183c = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6181a, i);
        parcel.writeParcelable(this.f6182b, i);
        parcel.writeParcelable(this.f6183c, i);
    }
}
