package com.facebook.photos.upload.event;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.operation.UploadOperation;
import javax.annotation.Nullable;

/* compiled from: toplevel */
public class MediaUploadFailedEvent extends BaseMediaUploadEvent implements Parcelable {
    public static final Creator<MediaUploadFailedEvent> CREATOR = new 1();
    @Nullable
    public final Intent f2396a;
    public final boolean f2397b;
    public final boolean f2398c;

    public MediaUploadFailedEvent(UploadOperation uploadOperation, @Nullable Intent intent, boolean z, boolean z2) {
        super(uploadOperation, Status.UPLOAD_FAILED, -1);
        this.f2396a = intent;
        this.f2397b = z;
        this.f2398c = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2399a, i);
        parcel.writeString(this.f2400b.name());
        parcel.writeInt(this.f2401c);
        if (this.f2396a != null) {
            ParcelUtil.a(parcel, true);
            parcel.writeParcelable(this.f2396a, i);
        } else {
            ParcelUtil.a(parcel, false);
        }
        ParcelUtil.a(parcel, this.f2397b);
        ParcelUtil.a(parcel, this.f2398c);
    }

    public int describeContents() {
        return 0;
    }

    public MediaUploadFailedEvent(Parcel parcel) {
        super((UploadOperation) parcel.readParcelable(UploadOperation.class.getClassLoader()), Status.valueOf(parcel.readString()), parcel.readInt());
        this.f2396a = ParcelUtil.a(parcel) ? (Intent) parcel.readParcelable(Intent.class.getClassLoader()) : null;
        this.f2397b = ParcelUtil.a(parcel);
        this.f2398c = ParcelUtil.a(parcel);
    }
}
