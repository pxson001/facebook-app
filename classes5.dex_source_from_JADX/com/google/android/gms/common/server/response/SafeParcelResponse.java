package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int f6625a;
    private final Parcel f6626b;
    private final int f6627c = 2;
    private final FieldMappingDictionary f6628d;
    private final String f6629e;
    private int f6630f;
    private int f6631g;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.f6625a = i;
        this.f6626b = (Parcel) zzx.a(parcel);
        this.f6628d = fieldMappingDictionary;
        if (this.f6628d == null) {
            this.f6629e = null;
        } else {
            this.f6629e = this.f6628d.f6624d;
        }
        this.f6630f = 2;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> m12424a(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).f6609f), entry);
        }
        return hashMap;
    }

    public static void m12425a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
            case 3:
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(zznu.m12892a(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzni.m12889a((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzni.m12890b((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                zznv.m12894a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m12426a(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.f6606c) {
            case 0:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, Integer.valueOf(zza.m12217e(parcel, i))));
                return;
            case 1:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, zza.m12220i(parcel, i)));
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, Long.valueOf(zza.m12218g(parcel, i))));
                return;
            case 3:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, Float.valueOf(zza.m12221j(parcel, i))));
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, Double.valueOf(zza.m12222l(parcel, i))));
                return;
            case 5:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, zza.m12223m(parcel, i)));
                return;
            case 6:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, Boolean.valueOf(zza.m12212b(parcel, i))));
                return;
            case 7:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, zza.m12224n(parcel, i)));
                return;
            case 8:
            case 9:
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, zza.m12227q(parcel, i)));
                return;
            case 10:
                Bundle p = zza.m12226p(parcel, i);
                HashMap hashMap = new HashMap();
                for (String str : p.keySet()) {
                    hashMap.put(str, p.getString(str));
                }
                m12427a(stringBuilder, (Field) field, FastJsonResponse.m12412a(field, hashMap));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.f6606c);
        }
    }

    private void m12427a(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.f6605b) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                m12425a(stringBuilder, field.f6604a, arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        m12425a(stringBuilder, field.f6604a, obj);
    }

    private void m12428a(StringBuilder stringBuilder, String str, Field<?, ?> field, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if ((field.f6614k != null ? 1 : null) != null) {
            m12426a(stringBuilder, field, parcel, i);
        } else {
            m12430b(stringBuilder, field, parcel, i);
        }
    }

    private void m12429a(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap a = m12424a(map);
        stringBuilder.append('{');
        int b = zza.m12210b(parcel);
        Object obj = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.m12206a(parcel);
            Entry entry = (Entry) a.get(Integer.valueOf(zza.m12205a(a2)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m12428a(stringBuilder, (String) entry.getKey(), (Field) entry.getValue(), parcel, a2);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.zza("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    private void m12430b(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        if (field.f6607d) {
            stringBuilder.append("[");
            switch (field.f6606c) {
                case 0:
                    int[] s = zza.m12229s(parcel, i);
                    int length = s.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 != 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(Integer.toString(s[i2]));
                    }
                    break;
                case 1:
                    zznh.m12886a(stringBuilder, zza.m12231u(parcel, i));
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    zznh.m12885a(stringBuilder, zza.m12230t(parcel, i));
                    break;
                case 3:
                    zznh.m12884a(stringBuilder, zza.m12232v(parcel, i));
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    zznh.m12883a(stringBuilder, zza.m12233w(parcel, i));
                    break;
                case 5:
                    zznh.m12886a(stringBuilder, zza.m12234x(parcel, i));
                    break;
                case 6:
                    zznh.m12888a(stringBuilder, zza.m12228r(parcel, i));
                    break;
                case 7:
                    zznh.m12887a(stringBuilder, zza.m12235y(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] C = zza.m12203C(parcel, i);
                    int length2 = C.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (i3 > 0) {
                            stringBuilder.append(",");
                        }
                        C[i3].setDataPosition(0);
                        m12429a(stringBuilder, field.m12411l(), C[i3]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.f6606c) {
            case 0:
                stringBuilder.append(zza.m12217e(parcel, i));
                return;
            case 1:
                stringBuilder.append(zza.m12220i(parcel, i));
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                stringBuilder.append(zza.m12218g(parcel, i));
                return;
            case 3:
                stringBuilder.append(zza.m12221j(parcel, i));
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                stringBuilder.append(zza.m12222l(parcel, i));
                return;
            case 5:
                stringBuilder.append(zza.m12223m(parcel, i));
                return;
            case 6:
                stringBuilder.append(zza.m12212b(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(zznu.m12892a(zza.m12224n(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzni.m12889a(zza.m12227q(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzni.m12890b(zza.m12227q(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle p = zza.m12226p(parcel, i);
                Set<String> keySet = p.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i4 = 1;
                for (String str : keySet) {
                    if (i4 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(zznu.m12892a(p.getString(str))).append("\"");
                    i4 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel B = zza.m12202B(parcel, i);
                B.setDataPosition(0);
                m12429a(stringBuilder, field.m12411l(), B);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public final Map<String, Field<?, ?>> mo797a() {
        return this.f6628d == null ? null : this.f6628d.m12423a(this.f6629e);
    }

    protected final Object mo798b() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected final boolean mo799c() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        return 0;
    }

    public final Parcel mo800e() {
        switch (this.f6630f) {
            case 0:
                this.f6631g = zzb.m12237a(this.f6626b);
                break;
            case 1:
                break;
        }
        zzb.m12258c(this.f6626b, this.f6631g);
        this.f6630f = 2;
        return this.f6626b;
    }

    public final FieldMappingDictionary mo801f() {
        switch (this.f6627c) {
            case 0:
                return null;
            case 1:
                return this.f6628d;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return this.f6628d;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f6627c);
        }
    }

    public String toString() {
        zzx.a(this.f6628d, "Cannot convert to JSON on client side.");
        Parcel e = mo800e();
        e.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m12429a(stringBuilder, this.f6628d.m12423a(this.f6629e), e);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6625a);
        Parcel e = mo800e();
        if (e != null) {
            int b = zzb.m12255b(parcel, 2);
            parcel.appendFrom(e, 0, e.dataSize());
            zzb.m12258c(parcel, b);
        } else if (null != null) {
            zzb.m12256b(parcel, 2, 0);
        }
        zzb.m12245a(parcel, 3, mo801f(), i, false);
        zzb.m12258c(parcel, a);
    }
}
