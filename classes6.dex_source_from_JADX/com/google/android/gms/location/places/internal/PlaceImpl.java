package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzl CREATOR = new zzl();
    public final int f6517a;
    public final boolean f6518b;
    private final String f6519c;
    public final Bundle f6520d;
    @Deprecated
    private final PlaceLocalization f6521e;
    private final LatLng f6522f;
    private final float f6523g;
    private final LatLngBounds f6524h;
    public final String f6525i;
    private final Uri f6526j;
    private final boolean f6527k;
    private final float f6528l;
    private final int f6529m;
    public final long f6530n;
    private final List<Integer> f6531o;
    private final List<Integer> f6532p;
    private final String f6533q;
    private final String f6534r;
    private final String f6535s;
    private final String f6536t;
    private final List<String> f6537u;
    private final Map<Integer, String> f6538v;
    private final TimeZone f6539w;
    public Locale f6540x;
    public zzp f6541y;

    public class zza {
        private int f6498a = 0;
        public String f6499b;
        private Bundle f6500c;
        public String f6501d;
        public LatLng f6502e;
        public float f6503f;
        public LatLngBounds f6504g;
        private String f6505h;
        public Uri f6506i;
        public boolean f6507j;
        public float f6508k;
        public int f6509l;
        private long f6510m;
        public List<Integer> f6511n;
        public String f6512o;
        public String f6513p;
        private String f6514q;
        public List<String> f6515r;
        public boolean f6516s;

        public final PlaceImpl m8979a() {
            return new PlaceImpl(this.f6498a, this.f6499b, this.f6511n, Collections.emptyList(), this.f6500c, this.f6501d, this.f6512o, this.f6513p, this.f6514q, this.f6515r, this.f6502e, this.f6503f, this.f6504g, this.f6505h, this.f6506i, this.f6507j, this.f6508k, this.f6509l, this.f6510m, this.f6516s, PlaceLocalization.m8999a(this.f6501d, this.f6512o, this.f6513p, this.f6514q, this.f6515r));
        }
    }

    PlaceImpl(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i2, long j, boolean z2, PlaceLocalization placeLocalization) {
        List emptyList;
        this.f6517a = i;
        this.f6519c = str;
        this.f6532p = Collections.unmodifiableList(list);
        this.f6531o = list2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f6520d = bundle;
        this.f6533q = str2;
        this.f6534r = str3;
        this.f6535s = str4;
        this.f6536t = str5;
        if (list3 == null) {
            emptyList = Collections.emptyList();
        }
        this.f6537u = emptyList;
        this.f6522f = latLng;
        this.f6523g = f;
        this.f6524h = latLngBounds;
        if (str6 == null) {
            str6 = "UTC";
        }
        this.f6525i = str6;
        this.f6526j = uri;
        this.f6527k = z;
        this.f6528l = f2;
        this.f6529m = i2;
        this.f6530n = j;
        this.f6538v = Collections.unmodifiableMap(new HashMap());
        this.f6539w = null;
        this.f6540x = null;
        this.f6518b = z2;
        this.f6521e = placeLocalization;
    }

    private void m8980a(String str) {
        if (this.f6518b && this.f6541y != null) {
            this.f6541y.m9105a(this.f6519c, str);
        }
    }

    public final Object m8981a() {
        return this;
    }

    public final LatLng mo491b() {
        m8980a("getLatLng");
        return this.f6522f;
    }

    public final String m8983c() {
        m8980a("getId");
        return this.f6519c;
    }

    public final List<Integer> m8984d() {
        m8980a("getPlaceTypes");
        return this.f6532p;
    }

    public final int describeContents() {
        return 0;
    }

    public final List<Integer> m8985e() {
        m8980a("getTypesDeprecated");
        return this.f6531o;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) obj;
        return this.f6519c.equals(placeImpl.f6519c) && zzw.a(this.f6540x, placeImpl.f6540x) && this.f6530n == placeImpl.f6530n;
    }

    public final String m8986f() {
        m8980a("getName");
        return this.f6533q;
    }

    public final String m8987g() {
        m8980a("getAddress");
        return this.f6534r;
    }

    public final float m8988h() {
        m8980a("getLevelNumber");
        return this.f6523g;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6519c, this.f6540x, Long.valueOf(this.f6530n)});
    }

    public final LatLngBounds m8989i() {
        m8980a("getViewport");
        return this.f6524h;
    }

    public final Uri m8990j() {
        m8980a("getWebsiteUri");
        return this.f6526j;
    }

    public final String m8991k() {
        m8980a("getPhoneNumber");
        return this.f6535s;
    }

    public final String m8992l() {
        m8980a("getRegularOpenHours");
        return this.f6536t;
    }

    public final List<String> m8993m() {
        m8980a("getAttributions");
        return this.f6537u;
    }

    public final boolean m8994n() {
        m8980a("isPermanentlyClosed");
        return this.f6527k;
    }

    public final float m8995o() {
        m8980a("getRating");
        return this.f6528l;
    }

    public final int m8996p() {
        m8980a("getPriceLevel");
        return this.f6529m;
    }

    @Deprecated
    public final PlaceLocalization m8997t() {
        m8980a("getLocalization");
        return this.f6521e;
    }

    public final String toString() {
        return zzw.a(this).a("id", this.f6519c).a("placeTypes", this.f6532p).a("locale", this.f6540x).a("name", this.f6533q).a("address", this.f6534r).a("phoneNumber", this.f6535s).a("latlng", this.f6522f).a("viewport", this.f6524h).a("websiteUri", this.f6526j).a("isPermanentlyClosed", Boolean.valueOf(this.f6527k)).a("priceLevel", Integer.valueOf(this.f6529m)).a("timestampSecs", Long.valueOf(this.f6530n)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, m8983c(), false);
        zzb.a(parcel, 2, this.f6520d, false);
        zzb.a(parcel, 3, m8997t(), i, false);
        zzb.a(parcel, 4, mo491b(), i, false);
        zzb.a(parcel, 5, m8988h());
        zzb.a(parcel, 6, m8989i(), i, false);
        zzb.a(parcel, 7, this.f6525i, false);
        zzb.a(parcel, 8, m8990j(), i, false);
        zzb.a(parcel, 9, m8994n());
        zzb.a(parcel, 10, m8995o());
        zzb.a(parcel, 11, m8996p());
        zzb.a(parcel, 12, this.f6530n);
        zzb.a(parcel, 13, m8985e(), false);
        zzb.a(parcel, 14, m8987g(), false);
        zzb.a(parcel, 15, m8991k(), false);
        zzb.b(parcel, 17, m8993m(), false);
        zzb.a(parcel, 16, m8992l(), false);
        zzb.a(parcel, 1000, this.f6517a);
        zzb.a(parcel, 19, m8986f(), false);
        zzb.a(parcel, 18, this.f6518b);
        zzb.a(parcel, 20, m8984d(), false);
        zzb.c(parcel, a);
    }
}
