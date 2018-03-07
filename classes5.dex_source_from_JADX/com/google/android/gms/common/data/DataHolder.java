package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public static final zza f6474l = new C05651(new String[0], null);
    public Bundle f6475a;
    int[] f6476b;
    public int f6477c;
    boolean f6478d;
    public final int f6479e;
    public final String[] f6480f;
    public final CursorWindow[] f6481g;
    public final int f6482h;
    public final Bundle f6483i;
    public Object f6484j;
    private boolean f6485k;

    public class zza {
        public final String[] f6468a;
        public final ArrayList<HashMap<String, Object>> f6469b = new ArrayList();
        private final String f6470c;
        private final HashMap<Object, Integer> f6471d;
        private boolean f6472e;
        private String f6473f;

        public zza(String[] strArr, String str) {
            this.f6468a = (String[]) zzx.a(strArr);
            this.f6470c = str;
            this.f6471d = new HashMap();
            this.f6472e = false;
            this.f6473f = null;
        }
    }

    final class C05651 extends zza {
        C05651(String[] strArr, String str) {
            super(strArr, str);
        }
    }

    public class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f6478d = false;
        this.f6485k = true;
        this.f6479e = i;
        this.f6480f = strArr;
        this.f6481g = cursorWindowArr;
        this.f6482h = i2;
        this.f6483i = bundle;
    }

    public DataHolder(zza com_google_android_gms_common_data_DataHolder_zza, int i, Bundle bundle) {
        this(com_google_android_gms_common_data_DataHolder_zza.f6468a, m12158a(com_google_android_gms_common_data_DataHolder_zza, -1), i, bundle);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.f6478d = false;
        this.f6485k = true;
        this.f6479e = 1;
        this.f6480f = (String[]) zzx.a(strArr);
        this.f6481g = (CursorWindow[]) zzx.a(cursorWindowArr);
        this.f6482h = i;
        this.f6483i = bundle;
        m12163a();
    }

    private void m12157a(String str, int i) {
        if (this.f6475a == null || !this.f6475a.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (m12160i()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f6477c) {
            throw new CursorIndexOutOfBoundsException(i, this.f6477c);
        }
    }

    private static CursorWindow[] m12158a(zza com_google_android_gms_common_data_DataHolder_zza, int i) {
        int i2 = 0;
        if (com_google_android_gms_common_data_DataHolder_zza.f6468a.length == 0) {
            return new CursorWindow[0];
        }
        List subList = (i < 0 || i >= com_google_android_gms_common_data_DataHolder_zza.f6469b.size()) ? com_google_android_gms_common_data_DataHolder_zza.f6469b : com_google_android_gms_common_data_DataHolder_zza.f6469b.subList(0, i);
        int size = subList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f6468a.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f6468a.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) subList.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < com_google_android_gms_common_data_DataHolder_zza.f6468a.length && z; i7++) {
                    String str = com_google_android_gms_common_data_DataHolder_zza.f6468a[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f6468a.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                while (i2 < size2) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder m12159b(int i) {
        return new DataHolder(f6474l, i, null);
    }

    private boolean m12160i() {
        boolean z;
        synchronized (this) {
            z = this.f6478d;
        }
        return z;
    }

    public final int m12161a(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.f6477c;
        zzx.a(z);
        while (i2 < this.f6476b.length) {
            if (i < this.f6476b[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.f6476b.length ? i2 - 1 : i2;
    }

    public final long m12162a(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].getLong(i, this.f6475a.getInt(str));
    }

    public final void m12163a() {
        int i;
        int i2 = 0;
        this.f6475a = new Bundle();
        for (i = 0; i < this.f6480f.length; i++) {
            this.f6475a.putInt(this.f6480f[i], i);
        }
        this.f6476b = new int[this.f6481g.length];
        i = 0;
        while (i2 < this.f6481g.length) {
            this.f6476b[i2] = i;
            i += this.f6481g[i2].getNumRows() - (i - this.f6481g[i2].getStartPosition());
            i2++;
        }
        this.f6477c = i;
    }

    public final int m12164b(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].getInt(i, this.f6475a.getInt(str));
    }

    public final String m12165c(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].getString(i, this.f6475a.getInt(str));
    }

    public final boolean m12166d(String str, int i, int i2) {
        m12157a(str, i);
        return Long.valueOf(this.f6481g[i2].getLong(i, this.f6475a.getInt(str))).longValue() == 1;
    }

    public final int describeContents() {
        return 0;
    }

    public final float m12167e(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].getFloat(i, this.f6475a.getInt(str));
    }

    public final byte[] m12168f(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].getBlob(i, this.f6475a.getInt(str));
    }

    protected final void finalize() {
        try {
            if (this.f6485k && this.f6481g.length > 0 && !m12160i()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.f6484j == null ? "internal object: " + toString() : this.f6484j.toString()) + ")");
                m12171h();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final int m12169g() {
        return this.f6477c;
    }

    public final boolean m12170g(String str, int i, int i2) {
        m12157a(str, i);
        return this.f6481g[i2].isNull(i, this.f6475a.getInt(str));
    }

    public final void m12171h() {
        synchronized (this) {
            if (!this.f6478d) {
                this.f6478d = true;
                for (CursorWindow close : this.f6481g) {
                    close.close();
                }
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.zzb.m12237a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.m12253a(parcel, 1, this.f6480f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12241a(parcel, 1000, this.f6479e);
        com.google.android.gms.common.internal.safeparcel.zzb.m12252a(parcel, 2, (Parcelable[]) this.f6481g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12241a(parcel, 3, this.f6482h);
        com.google.android.gms.common.internal.safeparcel.zzb.m12243a(parcel, 4, this.f6483i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12258c(parcel, a);
    }
}
