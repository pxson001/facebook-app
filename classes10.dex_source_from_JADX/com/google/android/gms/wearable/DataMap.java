package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap {
    public final HashMap<String, Object> f13145a = new HashMap();

    private static void m13249a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof Asset) {
            bundle.putParcelable(str, (Asset) obj);
        } else if (obj instanceof DataMap) {
            bundle.putParcelable(str, ((DataMap) obj).m13254a());
        } else if (obj instanceof ArrayList) {
            Object obj2;
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.isEmpty()) {
                obj2 = null;
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null) {
                        if (next instanceof Integer) {
                            obj2 = 2;
                            break;
                        } else if (next instanceof String) {
                            obj2 = 3;
                            break;
                        } else if (next instanceof DataMap) {
                            obj2 = 4;
                            break;
                        } else if (next instanceof Bundle) {
                            obj2 = 5;
                            break;
                        }
                    }
                }
                obj2 = 1;
            }
            switch (obj2) {
                case null:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 1:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 2:
                    bundle.putIntegerArrayList(str, (ArrayList) obj);
                    return;
                case 3:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 4:
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = ((ArrayList) obj).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((DataMap) it2.next()).m13254a());
                    }
                    bundle.putParcelableArrayList(str, arrayList2);
                    return;
                default:
                    return;
            }
        }
    }

    private void m13250a(String str, Object obj, String str2, ClassCastException classCastException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key ");
        stringBuilder.append(str);
        stringBuilder.append(" expected ");
        stringBuilder.append(str2);
        stringBuilder.append(" but value was a ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(".  The default value ");
        stringBuilder.append("<null>");
        stringBuilder.append(" was returned.");
        Log.w("DataMap", stringBuilder.toString());
        Log.w("DataMap", "Attempt to cast generated internal exception:", classCastException);
    }

    private static boolean m13251a(DataMap dataMap, DataMap dataMap2) {
        if (dataMap.m13253c() != dataMap2.m13253c()) {
            return false;
        }
        for (String str : dataMap.m13263b()) {
            Object b = dataMap.m13262b(str);
            Object b2 = dataMap2.m13262b(str);
            if (b instanceof Asset) {
                if (!(b2 instanceof Asset)) {
                    return false;
                }
                Asset asset = (Asset) b;
                Asset asset2 = (Asset) b2;
                boolean equals = (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.f13132e) ? asset.f13132e.equals(asset2.f13132e) : Arrays.equals(asset.f13131d, asset2.f13131d);
                if (!equals) {
                    return false;
                }
            } else if (b instanceof String[]) {
                if (!(b2 instanceof String[])) {
                    return false;
                }
                if (!Arrays.equals((String[]) b, (String[]) b2)) {
                    return false;
                }
            } else if (b instanceof long[]) {
                if (!(b2 instanceof long[])) {
                    return false;
                }
                if (!Arrays.equals((long[]) b, (long[]) b2)) {
                    return false;
                }
            } else if (b instanceof float[]) {
                if (!(b2 instanceof float[])) {
                    return false;
                }
                if (!Arrays.equals((float[]) b, (float[]) b2)) {
                    return false;
                }
            } else if (b instanceof byte[]) {
                if (!(b2 instanceof byte[])) {
                    return false;
                }
                if (!Arrays.equals((byte[]) b, (byte[]) b2)) {
                    return false;
                }
            } else if (b == null || b2 == null) {
                return b == b2;
            } else {
                if (!b.equals(b2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int m13252b(String str, int i) {
        Object obj = this.f13145a.get(str);
        if (obj != null) {
            try {
                i = ((Integer) obj).intValue();
            } catch (ClassCastException e) {
                m13250a(str, obj, "Integer", e);
            }
        }
        return i;
    }

    private int m13253c() {
        return this.f13145a.size();
    }

    public final Bundle m13254a() {
        Bundle bundle = new Bundle();
        for (String str : this.f13145a.keySet()) {
            m13249a(bundle, str, this.f13145a.get(str));
        }
        return bundle;
    }

    public final void m13255a(String str, int i) {
        this.f13145a.put(str, Integer.valueOf(i));
    }

    public final void m13256a(String str, long j) {
        this.f13145a.put(str, Long.valueOf(j));
    }

    public final void m13257a(String str, Asset asset) {
        this.f13145a.put(str, asset);
    }

    public final void m13258a(String str, String str2) {
        this.f13145a.put(str, str2);
    }

    public final void m13259a(String str, byte[] bArr) {
        this.f13145a.put(str, bArr);
    }

    public final void m13260a(String str, long[] jArr) {
        this.f13145a.put(str, jArr);
    }

    public final void m13261a(String str, String[] strArr) {
        this.f13145a.put(str, strArr);
    }

    public final <T> T m13262b(String str) {
        return this.f13145a.get(str);
    }

    public final Set<String> m13263b() {
        return this.f13145a.keySet();
    }

    public final int m13264c(String str) {
        return m13252b(str, 0);
    }

    public final void m13265c(String str, ArrayList<String> arrayList) {
        this.f13145a.put(str, arrayList);
    }

    public final String m13266d(String str) {
        Object obj = this.f13145a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            m13250a(str, obj, "String", e);
            return null;
        }
    }

    public final Asset m13267e(String str) {
        Object obj = this.f13145a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            m13250a(str, obj, "Asset", e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof DataMap) ? false : m13251a(this, (DataMap) obj);
    }

    public final DataMap m13268f(String str) {
        Object obj = this.f13145a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (DataMap) obj;
        } catch (ClassCastException e) {
            m13250a(str, obj, "DataMap", e);
            return null;
        }
    }

    public final byte[] m13269g(String str) {
        Object obj = this.f13145a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            m13250a(str, obj, "byte[]", e);
            return null;
        }
    }

    public int hashCode() {
        return this.f13145a.hashCode() * 29;
    }

    public String toString() {
        return this.f13145a.toString();
    }
}
