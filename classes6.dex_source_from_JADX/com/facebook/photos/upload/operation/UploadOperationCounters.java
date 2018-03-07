package com.facebook.photos.upload.operation;

import android.os.Parcel;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: glVertexAttribPointer */
public class UploadOperationCounters {
    public long f13806a;
    public long f13807b;
    public long f13808c;
    public int f13809d;
    public int f13810e;
    public int f13811f;
    public int f13812g;
    public int f13813h;
    public int f13814i;
    public boolean f13815j;

    public UploadOperationCounters(long j) {
        this.f13806a = j;
        this.f13807b = j;
        this.f13808c = j;
        this.f13809d = 0;
        this.f13810e = 0;
        this.f13811f = 0;
        this.f13812g = 0;
        this.f13813h = 0;
        this.f13814i = 0;
        this.f13815j = true;
    }

    public UploadOperationCounters(Parcel parcel) {
        this.f13806a = parcel.readLong();
        this.f13807b = parcel.readLong();
        this.f13808c = parcel.readLong();
        this.f13809d = parcel.readInt();
        this.f13810e = parcel.readInt();
        this.f13811f = parcel.readInt();
        this.f13812g = parcel.readInt();
        this.f13813h = parcel.readInt();
        this.f13814i = parcel.readInt();
        this.f13815j = ParcelUtil.a(parcel);
    }

    public final void m21554a() {
        this.f13810e += this.f13809d;
        this.f13809d = 0;
    }

    public final long m21555f() {
        return this.f13808c;
    }
}
