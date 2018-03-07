package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import java.util.List;

/* compiled from: actor_id */
public class PollUploadParams implements Parcelable {
    public static final Creator<PollUploadParams> CREATOR = new C10871();
    public final String f11525a;
    public final String f11526b;
    public final List<String> f11527c;
    public final boolean f11528d;
    public final boolean f11529e;
    public final boolean f11530f;

    /* compiled from: actor_id */
    final class C10871 implements Creator {
        C10871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PollUploadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PollUploadParams[i];
        }
    }

    public PollUploadParams(Parcel parcel) {
        this.f11525a = parcel.readString();
        this.f11526b = parcel.readString();
        this.f11527c = parcel.readArrayList(String.class.getClassLoader());
        this.f11528d = ParcelUtil.m3827a(parcel);
        this.f11529e = ParcelUtil.m3827a(parcel);
        this.f11530f = ParcelUtil.m3827a(parcel);
    }

    public PollUploadParams(String str, String str2, List<String> list, boolean z, boolean z2, boolean z3) {
        this.f11525a = str;
        this.f11526b = str2;
        this.f11527c = list;
        this.f11528d = z;
        this.f11529e = z2;
        this.f11530f = z3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11525a);
        parcel.writeString(this.f11526b);
        parcel.writeList(this.f11527c);
        ParcelUtil.m3826a(parcel, this.f11528d);
        ParcelUtil.m3826a(parcel, this.f11529e);
        ParcelUtil.m3826a(parcel, this.f11530f);
    }
}
