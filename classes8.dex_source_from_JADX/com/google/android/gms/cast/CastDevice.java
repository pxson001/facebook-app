package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new zzb();
    public String f9971a;
    public final int f9972b;
    public String f9973c;
    private Inet4Address f9974d;
    public String f9975e;
    public String f9976f;
    public String f9977g;
    public int f9978h;
    public List<WebImage> f9979i;
    public int f9980j;
    public int f9981k;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4) {
        this.f9972b = i;
        this.f9973c = str;
        this.f9971a = str2;
        if (this.f9971a != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.f9971a);
                if (byName instanceof Inet4Address) {
                    this.f9974d = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.f9974d = null;
            }
        }
        this.f9975e = str3;
        this.f9976f = str4;
        this.f9977g = str5;
        this.f9978h = i2;
        this.f9979i = list;
        this.f9980j = i3;
        this.f9981k = i4;
    }

    public static CastDevice m11767b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return this.f9973c == null ? castDevice.f9973c == null : zzf.m11922a(this.f9973c, castDevice.f9973c) && zzf.m11922a(this.f9974d, castDevice.f9974d) && zzf.m11922a(this.f9976f, castDevice.f9976f) && zzf.m11922a(this.f9975e, castDevice.f9975e) && zzf.m11922a(this.f9977g, castDevice.f9977g) && this.f9978h == castDevice.f9978h && zzf.m11922a(this.f9979i, castDevice.f9979i) && this.f9980j == castDevice.f9980j && this.f9981k == castDevice.f9981k;
    }

    public int hashCode() {
        return this.f9973c == null ? 0 : this.f9973c.hashCode();
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.f9975e, this.f9973c});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f9972b);
        zzb.a(parcel, 2, this.f9973c, false);
        zzb.a(parcel, 3, this.f9971a, false);
        zzb.a(parcel, 4, this.f9975e, false);
        zzb.a(parcel, 5, this.f9976f, false);
        zzb.a(parcel, 6, this.f9977g, false);
        zzb.a(parcel, 7, this.f9978h);
        zzb.c(parcel, 8, Collections.unmodifiableList(this.f9979i), false);
        zzb.a(parcel, 9, this.f9980j);
        zzb.a(parcel, 10, this.f9981k);
        zzb.c(parcel, a);
    }
}
