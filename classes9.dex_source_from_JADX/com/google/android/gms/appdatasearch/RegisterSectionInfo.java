package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    public final int f20570a;
    public final String f20571b;
    public final String f20572c;
    public final boolean f20573d;
    public final int f20574e;
    public final boolean f20575f;
    public final String f20576g;
    public final Feature[] f20577h;
    public final int[] f20578i;
    public final String f20579j;

    public final class zza {
        public final String f20561a;
        public String f20562b;
        public boolean f20563c;
        public int f20564d = 1;
        public boolean f20565e;
        public String f20566f;
        public final List<Feature> f20567g = new ArrayList();
        public BitSet f20568h;
        public String f20569i;

        public zza(String str) {
            this.f20561a = str;
        }
    }

    RegisterSectionInfo(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this.f20570a = i;
        this.f20571b = str;
        this.f20572c = str2;
        this.f20573d = z;
        this.f20574e = i2;
        this.f20575f = z2;
        this.f20576g = str3;
        this.f20577h = featureArr;
        this.f20578i = iArr;
        this.f20579j = str4;
    }

    public RegisterSectionInfo(String str, String str2, boolean z, int i, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20571b, false);
        zzb.a(parcel, 1000, this.f20570a);
        zzb.a(parcel, 2, this.f20572c, false);
        zzb.a(parcel, 3, this.f20573d);
        zzb.a(parcel, 4, this.f20574e);
        zzb.a(parcel, 5, this.f20575f);
        zzb.a(parcel, 6, this.f20576g, false);
        zzb.a(parcel, 7, this.f20577h, i, false);
        zzb.a(parcel, 8, this.f20578i, false);
        zzb.a(parcel, 11, this.f20579j, false);
        zzb.c(parcel, a);
    }
}
