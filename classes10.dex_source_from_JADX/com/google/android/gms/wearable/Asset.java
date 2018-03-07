package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new zze();
    public final int f13128a;
    public ParcelFileDescriptor f13129b;
    public Uri f13130c;
    public byte[] f13131d;
    public String f13132e;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.f13128a = i;
        this.f13131d = bArr;
        this.f13132e = str;
        this.f13129b = parcelFileDescriptor;
        this.f13130c = uri;
    }

    public static Asset m13224a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset m13225a(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset m13226a(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public final byte[] m13227a() {
        return this.f13131d;
    }

    public final String m13228b() {
        return this.f13132e;
    }

    public final ParcelFileDescriptor m13229c() {
        return this.f13129b;
    }

    public final Uri m13230d() {
        return this.f13130c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return zzw.a(this.f13131d, asset.f13131d) && zzw.a(this.f13132e, asset.f13132e) && zzw.a(this.f13129b, asset.f13129b) && zzw.a(this.f13130c, asset.f13130c);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f13131d, this.f13132e, this.f13129b, this.f13130c});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.f13132e == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.f13132e);
        }
        if (this.f13131d != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.f13131d.length);
        }
        if (this.f13129b != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.f13129b);
        }
        if (this.f13130c != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.f13130c);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13128a);
        zzb.a(parcel, 2, this.f13131d, false);
        zzb.a(parcel, 3, this.f13132e, false);
        zzb.a(parcel, 4, this.f13129b, i2, false);
        zzb.a(parcel, 5, this.f13130c, i2, false);
        zzb.c(parcel, a);
    }
}
