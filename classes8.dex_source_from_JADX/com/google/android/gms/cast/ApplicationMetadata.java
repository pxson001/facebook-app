package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new zza();
    public String f9941a;
    public String f9942b;
    public List<WebImage> f9943c;
    public List<String> f9944d;
    public String f9945e;
    public Uri f9946f;
    public final int f9947g;

    private ApplicationMetadata() {
        this.f9947g = 1;
        this.f9943c = new ArrayList();
        this.f9944d = new ArrayList();
    }

    ApplicationMetadata(int i, String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.f9947g = i;
        this.f9941a = str;
        this.f9942b = str2;
        this.f9943c = list;
        this.f9944d = list2;
        this.f9945e = str3;
        this.f9946f = uri;
    }

    public final String m11734b() {
        return this.f9941a;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.m11922a(this.f9941a, applicationMetadata.f9941a) && zzf.m11922a(this.f9943c, applicationMetadata.f9943c) && zzf.m11922a(this.f9942b, applicationMetadata.f9942b) && zzf.m11922a(this.f9944d, applicationMetadata.f9944d) && zzf.m11922a(this.f9945e, applicationMetadata.f9945e) && zzf.m11922a(this.f9946f, applicationMetadata.f9946f);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f9947g), this.f9941a, this.f9942b, this.f9943c, this.f9944d, this.f9945e, this.f9946f});
    }

    public final String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder("applicationId: ").append(this.f9941a).append(", name: ").append(this.f9942b).append(", images.count: ").append(this.f9943c == null ? 0 : this.f9943c.size()).append(", namespaces.count: ");
        if (this.f9944d != null) {
            i = this.f9944d.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.f9945e).append(", senderAppLaunchUrl: ").append(this.f9946f).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f9947g);
        zzb.a(parcel, 2, this.f9941a, false);
        zzb.a(parcel, 3, this.f9942b, false);
        zzb.c(parcel, 4, this.f9943c, false);
        zzb.b(parcel, 5, this.f9944d, false);
        zzb.a(parcel, 6, this.f9945e, false);
        zzb.a(parcel, 7, this.f9946f, i, false);
        zzb.c(parcel, a);
    }
}
