package com.facebook.composer.publish.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.composer.model.PublishMode;

/* compiled from: photo_picker_start_typing */
public class SimplePhotoUploadParams implements Parcelable {
    public static final Creator<SimplePhotoUploadParams> CREATOR = new C04911();
    public final String f8070a;
    public final long f8071b;
    public final String f8072c;
    public final String f8073d;
    public final long f8074e;
    public final PublishMode f8075f;

    /* compiled from: photo_picker_start_typing */
    final class C04911 implements Creator<SimplePhotoUploadParams> {
        C04911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePhotoUploadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePhotoUploadParams[i];
        }
    }

    public SimplePhotoUploadParams(Parcel parcel) {
        this.f8070a = parcel.readString();
        this.f8071b = parcel.readLong();
        this.f8072c = parcel.readString();
        this.f8073d = parcel.readString();
        this.f8074e = parcel.readLong();
        this.f8075f = (PublishMode) ParcelUtil.c(parcel, PublishMode.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8070a);
        parcel.writeLong(this.f8071b);
        parcel.writeString(this.f8072c);
        parcel.writeString(this.f8073d);
        parcel.writeLong(this.f8074e);
        ParcelUtil.a(parcel, this.f8075f);
    }
}
