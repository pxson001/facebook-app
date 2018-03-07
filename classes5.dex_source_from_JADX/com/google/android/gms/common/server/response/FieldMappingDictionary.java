package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6621a;
    public final HashMap<String, Map<String, Field<?, ?>>> f6622b;
    private final ArrayList<Entry> f6623c = null;
    public final String f6624d;

    public class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        public final int f6615a;
        public final String f6616b;
        public final ArrayList<FieldMapPair> f6617c;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.f6615a = i;
            this.f6616b = str;
            this.f6617c = arrayList;
        }

        public Entry(String str, Map<String, Field<?, ?>> map) {
            ArrayList arrayList;
            this.f6615a = 1;
            this.f6616b = str;
            if (map == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : map.keySet()) {
                    arrayList2.add(new FieldMapPair(str2, (Field) map.get(str2)));
                }
                arrayList = arrayList2;
            }
            this.f6617c = arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = zzb.m12237a(parcel);
            zzb.m12241a(parcel, 1, this.f6615a);
            zzb.m12247a(parcel, 2, this.f6616b, false);
            zzb.m12259c(parcel, 3, this.f6617c, false);
            zzb.m12258c(parcel, a);
        }
    }

    public class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();
        public final int f6618a;
        public final String f6619b;
        public final Field<?, ?> f6620c;

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.f6618a = i;
            this.f6619b = str;
            this.f6620c = field;
        }

        public FieldMapPair(String str, Field<?, ?> field) {
            this.f6618a = 1;
            this.f6619b = str;
            this.f6620c = field;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = zzb.m12237a(parcel);
            zzb.m12241a(parcel, 1, this.f6618a);
            zzb.m12247a(parcel, 2, this.f6619b, false);
            zzb.m12245a(parcel, 3, this.f6620c, i, false);
            zzb.m12258c(parcel, a);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.f6621a = i;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = (Entry) arrayList.get(i2);
            String str2 = entry.f6616b;
            HashMap hashMap2 = new HashMap();
            int size2 = entry.f6617c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                FieldMapPair fieldMapPair = (FieldMapPair) entry.f6617c.get(i3);
                hashMap2.put(fieldMapPair.f6619b, fieldMapPair.f6620c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f6622b = hashMap;
        this.f6624d = (String) zzx.a(str);
        m12422d();
    }

    private void m12422d() {
        for (String str : this.f6622b.keySet()) {
            Map map = (Map) this.f6622b.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).f6613j = this;
            }
        }
    }

    public final Map<String, Field<?, ?>> m12423a(String str) {
        return (Map) this.f6622b.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f6622b.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.f6622b.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6621a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6622b.keySet()) {
            arrayList.add(new Entry(str, (Map) this.f6622b.get(str)));
        }
        zzb.m12259c(parcel, 2, arrayList, false);
        zzb.m12247a(parcel, 3, this.f6624d, false);
        zzb.m12258c(parcel, a);
    }
}
