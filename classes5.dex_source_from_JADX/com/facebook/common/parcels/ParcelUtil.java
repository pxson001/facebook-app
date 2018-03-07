package com.facebook.common.parcels;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.TriState;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: show_mark_as_sold_button */
public class ParcelUtil {
    public static void m3826a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean m3827a(Parcel parcel) {
        return parcel.readInt() == 1;
    }

    public static <T> void m3825a(Parcel parcel, @Nullable Set<T> set) {
        if (set == null) {
            parcel.writeList(null);
            return;
        }
        List a = Lists.a();
        a.addAll(set);
        parcel.writeList(a);
    }

    public static <T> Set<T> m3829b(Parcel parcel) {
        Iterable readArrayList = parcel.readArrayList(List.class.getClassLoader());
        return readArrayList == null ? null : Sets.b(readArrayList);
    }

    public static void m3823a(Parcel parcel, @Nullable Map<String, String> map) {
        List a = Lists.a();
        List a2 = Lists.a();
        if (map == null) {
            parcel.writeStringList(a);
            parcel.writeStringList(a2);
            return;
        }
        for (String str : map.keySet()) {
            a.add(str);
            a2.add(map.get(str));
        }
        parcel.writeStringList(a);
        parcel.writeStringList(a2);
    }

    public static void m3821a(Parcel parcel, @Nullable Long l) {
        if (l == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l.longValue());
    }

    @Nullable
    public static Long m3833e(Parcel parcel) {
        if (parcel.readInt() == 1) {
            return Long.valueOf(parcel.readLong());
        }
        return null;
    }

    public static void m3819a(Parcel parcel, @Nullable Boolean bool) {
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        m3826a(parcel, bool.booleanValue());
    }

    @Nullable
    public static Boolean m3834f(Parcel parcel) {
        if (parcel.readInt() == 1) {
            return Boolean.valueOf(m3827a(parcel));
        }
        return null;
    }

    public static void m3818a(Parcel parcel, @Nullable TriState triState) {
        if (triState == null) {
            parcel.writeInt(0);
            parcel.writeInt(0);
        } else if (triState == TriState.UNSET) {
            parcel.writeInt(0);
            parcel.writeInt(1);
        } else if (triState == TriState.YES) {
            parcel.writeInt(1);
            parcel.writeInt(1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(0);
        }
    }

    @Nullable
    public static TriState m3835g(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (readInt == 0) {
            if (readInt2 == 0) {
                return null;
            }
            return TriState.UNSET;
        } else if (readInt2 == 0) {
            return TriState.NO;
        } else {
            return TriState.YES;
        }
    }

    public static void m3830b(Parcel parcel, Map<String, String> map) {
        List a = Lists.a();
        List a2 = Lists.a();
        parcel.readStringList(a);
        parcel.readStringList(a2);
        for (int i = 0; i < a.size(); i++) {
            map.put(a.get(i), a2.get(i));
        }
    }

    public static <V extends Parcelable> void m3832c(Parcel parcel, @Nullable Map<String, V> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        Bundle bundle = new Bundle();
        List a = Lists.a();
        Set<Entry> entrySet = map.entrySet();
        parcel.writeInt(entrySet.size());
        for (Entry entry : entrySet) {
            String str = (String) entry.getKey();
            a.add(str);
            bundle.putParcelable(str, (Parcelable) entry.getValue());
        }
        parcel.writeStringList(a);
        parcel.writeBundle(bundle);
    }

    public static <V extends Parcelable> void m3824a(Parcel parcel, Map<String, V> map, Class<V> cls) {
        if (parcel.readInt() != -1) {
            List<String> a = Lists.a();
            parcel.readStringList(a);
            Bundle readBundle = parcel.readBundle(cls.getClassLoader());
            if (map != null && readBundle != null && !readBundle.isEmpty()) {
                for (String str : a) {
                    map.put(str, readBundle.getParcelable(str));
                }
            }
        }
    }

    public static <T> ImmutableList<T> m3817a(Parcel parcel, Creator<T> creator) {
        Collection a = Lists.a();
        parcel.readTypedList(a, creator);
        return ImmutableList.copyOf(a);
    }

    public static ImmutableList<String> m3836h(Parcel parcel) {
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        return ImmutableList.copyOf(arrayList);
    }

    public static <T extends Parcelable> T m3828b(Parcel parcel, Class<T> cls) {
        return parcel.readParcelable(cls.getClassLoader());
    }

    public static <T extends Enum<T>> void m3820a(Parcel parcel, T t) {
        if (t == null) {
            parcel.writeString(null);
        } else {
            parcel.writeString(t.name());
        }
    }

    public static <T extends Enum<T>> T m3831c(Parcel parcel, Class<T> cls) {
        String readString = parcel.readString();
        if (readString == null) {
            return null;
        }
        return Enum.valueOf(cls, readString);
    }

    public static JsonNode m3837i(Parcel parcel) {
        return new ObjectMapper().a(parcel.readString());
    }

    public static void m3822a(Parcel parcel, @Nullable List<String> list) {
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeStringList(list);
    }

    @Nullable
    public static ImmutableList<String> m3838j(Parcel parcel) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return m3836h(parcel);
    }
}
