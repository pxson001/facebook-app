package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzta;
import com.google.android.gms.internal.zztj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzu extends zzc {
    private final String f6559c = "SafeDataBufferRef";

    public zzu(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private byte[] m9000a(String str, byte[] bArr) {
        return (!a(str) || g(str)) ? bArr : f(str);
    }

    public final float m9001a(String str, float f) {
        return (!a(str) || g(str)) ? f : this.a.e(str, this.b, this.c);
    }

    public final int m9002a(String str, int i) {
        return (!a(str) || g(str)) ? i : b(str);
    }

    protected final <E extends SafeParcelable> E m9003a(String str, Creator<E> creator) {
        byte[] a = m9000a(str, null);
        return a == null ? null : com.google.android.gms.common.internal.safeparcel.zzc.a(a, creator);
    }

    public final String m9004a(String str, String str2) {
        return (!a(str) || g(str)) ? str2 : d(str);
    }

    public final <E extends SafeParcelable> List<E> m9005a(String str, Creator<E> creator, List<E> list) {
        byte[] a = m9000a(str, null);
        if (a == null) {
            return list;
        }
        try {
            zzta a2 = zzta.m8828a(a);
            if (a2.f6284e == null) {
                return list;
            }
            List<E> arrayList = new ArrayList(a2.f6284e.length);
            for (byte[] a3 : a2.f6284e) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.a(a3, creator));
            }
            return arrayList;
        } catch (zztj e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    public final List<Integer> m9006a(String str, List<Integer> list) {
        byte[] a = m9000a(str, null);
        if (a == null) {
            return list;
        }
        try {
            zzta a2 = zzta.m8828a(a);
            if (a2.f6283d == null) {
                return list;
            }
            List<Integer> arrayList = new ArrayList(a2.f6283d.length);
            for (int valueOf : a2.f6283d) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (zztj e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected final boolean m9007a(String str, boolean z) {
        return (!a(str) || g(str)) ? z : this.a.d(str, this.b, this.c);
    }

    protected final List<String> m9008b(String str, List<String> list) {
        byte[] a = m9000a(str, null);
        if (a != null) {
            try {
                zzta a2 = zzta.m8828a(a);
                if (a2.f6282c != null) {
                    list = Arrays.asList(a2.f6282c);
                }
            } catch (zztj e) {
                if (Log.isLoggable("SafeDataBufferRef", 6)) {
                    Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
                }
            }
        }
        return list;
    }
}
