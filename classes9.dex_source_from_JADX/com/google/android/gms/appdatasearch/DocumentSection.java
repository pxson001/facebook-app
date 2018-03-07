package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int f20541a = Integer.parseInt("-1");
    private static final RegisterSectionInfo f20542g;
    public final int f20543b;
    public final String f20544c;
    public final RegisterSectionInfo f20545d;
    public final int f20546e;
    public final byte[] f20547f;

    static {
        zza com_google_android_gms_appdatasearch_RegisterSectionInfo_zza = new zza("SsbContext");
        com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20563c = true;
        com_google_android_gms_appdatasearch_RegisterSectionInfo_zza = com_google_android_gms_appdatasearch_RegisterSectionInfo_zza;
        com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20562b = "blob";
        com_google_android_gms_appdatasearch_RegisterSectionInfo_zza = com_google_android_gms_appdatasearch_RegisterSectionInfo_zza;
        int i = 0;
        int[] iArr = null;
        if (com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20568h != null) {
            iArr = new int[com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20568h.cardinality()];
            int nextSetBit = com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20568h.nextSetBit(0);
            while (nextSetBit >= 0) {
                int i2 = i + 1;
                iArr[i] = nextSetBit;
                nextSetBit = com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20568h.nextSetBit(nextSetBit + 1);
                i = i2;
            }
        }
        f20542g = new RegisterSectionInfo(com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20561a, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20562b, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20563c, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20564d, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20565e, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20566f, (Feature[]) com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20567g.toArray(new Feature[com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20567g.size()]), iArr, com_google_android_gms_appdatasearch_RegisterSectionInfo_zza.f20569i);
    }

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        boolean z = i2 == f20541a || zzh.m20080a(i2) != null;
        zzx.b(z, "Invalid section type " + i2);
        this.f20543b = i;
        this.f20544c = str;
        this.f20545d = registerSectionInfo;
        this.f20546e = i2;
        this.f20547f = bArr;
        String str2 = (this.f20546e == f20541a || zzh.m20080a(this.f20546e) != null) ? (this.f20544c == null || this.f20547f == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.f20546e;
        String str3 = str2;
        if (str3 != null) {
            throw new IllegalArgumentException(str3);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20544c, false);
        zzb.a(parcel, 1000, this.f20543b);
        zzb.a(parcel, 3, this.f20545d, i, false);
        zzb.a(parcel, 4, this.f20546e);
        zzb.a(parcel, 5, this.f20547f, false);
        zzb.c(parcel, a);
    }
}
