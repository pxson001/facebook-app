package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    public final int f6600a;
    public final HashMap<String, Integer> f6601b;
    public final HashMap<Integer, String> f6602c;
    private final ArrayList<Entry> f6603d;

    public final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        public final int f6597a;
        public final String f6598b;
        public final int f6599c;

        Entry(int i, String str, int i2) {
            this.f6597a = i;
            this.f6598b = str;
            this.f6599c = i2;
        }

        public Entry(String str, int i) {
            this.f6597a = 1;
            this.f6598b = str;
            this.f6599c = i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int a = zzb.m12237a(parcel);
            zzb.m12241a(parcel, 1, this.f6597a);
            zzb.m12247a(parcel, 2, this.f6598b, false);
            zzb.m12241a(parcel, 3, this.f6599c);
            zzb.m12258c(parcel, a);
        }
    }

    public StringToIntConverter() {
        this.f6600a = 1;
        this.f6601b = new HashMap();
        this.f6602c = new HashMap();
        this.f6603d = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.f6600a = i;
        this.f6601b = new HashMap();
        this.f6602c = new HashMap();
        this.f6603d = null;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = entry.f6598b;
            int i2 = entry.f6599c;
            this.f6601b.put(str, Integer.valueOf(i2));
            this.f6602c.put(Integer.valueOf(i2), str);
        }
    }

    public final Object mo796a(Object obj) {
        String str = (String) this.f6602c.get((Integer) obj);
        return (str == null && this.f6601b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6600a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6601b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.f6601b.get(str)).intValue()));
        }
        zzb.m12259c(parcel, 2, arrayList, false);
        zzb.m12258c(parcel, a);
    }
}
