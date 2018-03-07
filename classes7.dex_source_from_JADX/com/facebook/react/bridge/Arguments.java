package com.facebook.react.bridge;

import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: growth_add_contactpoint_success */
public class Arguments {
    public static WritableArray m13384a() {
        return new WritableNativeArray();
    }

    public static WritableMap m13388b() {
        return new WritableNativeMap();
    }

    public static WritableNativeArray m13387a(Object[] objArr) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Object obj : objArr) {
            if (obj == null) {
                writableNativeArray.pushNull();
            } else {
                Class cls = obj.getClass();
                if (cls == Boolean.class) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (cls == Integer.class) {
                    writableNativeArray.pushDouble(((Integer) obj).doubleValue());
                } else if (cls == Double.class) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (cls == Float.class) {
                    writableNativeArray.pushDouble(((Float) obj).doubleValue());
                } else if (cls == String.class) {
                    writableNativeArray.pushString(obj.toString());
                } else if (cls == WritableNativeMap.class) {
                    writableNativeArray.mo689a((WritableNativeMap) obj);
                } else if (cls == WritableNativeArray.class) {
                    writableNativeArray.mo688a((WritableNativeArray) obj);
                } else {
                    throw new RuntimeException("Cannot convert argument of type " + cls);
                }
            }
        }
        return writableNativeArray;
    }

    private static WritableArray m13385a(Object obj) {
        int i = 0;
        WritableArray a = m13384a();
        int length;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            length = strArr.length;
            while (i < length) {
                a.pushString(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            length = bundleArr.length;
            while (i < length) {
                a.mo689a(m13386a(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            length = iArr.length;
            while (i < length) {
                a.pushInt(iArr[i]);
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            length = fArr.length;
            while (i < length) {
                a.pushDouble((double) fArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            length = dArr.length;
            while (i < length) {
                a.pushDouble(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            length = zArr.length;
            while (i < length) {
                a.pushBoolean(zArr[i]);
                i++;
            }
        } else {
            throw new IllegalArgumentException("Unknown array type " + obj.getClass());
        }
        return a;
    }

    public static WritableMap m13386a(Bundle bundle) {
        WritableMap b = m13388b();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                b.putNull(str);
            } else if (obj.getClass().isArray()) {
                b.mo695a(str, m13385a(obj));
            } else if (obj instanceof String) {
                b.putString(str, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    b.putInt(str, ((Integer) obj).intValue());
                } else {
                    b.putDouble(str, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                b.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                b.mo696a(str, m13386a((Bundle) obj));
            } else {
                throw new IllegalArgumentException("Could not convert " + obj.getClass());
            }
        }
        return b;
    }

    @Nullable
    public static Bundle m13383a(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator a = readableMap.mo679a();
        if (!a.hasNextKey()) {
            return null;
        }
        Bundle bundle = new Bundle();
        while (a.hasNextKey()) {
            String nextKey = a.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    bundle.putString(nextKey, null);
                    break;
                case Boolean:
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    bundle.putBundle(nextKey, m13383a(readableMap.mo680b(nextKey)));
                    break;
                case Array:
                    throw new UnsupportedOperationException("Arrays aren't supported yet.");
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + nextKey + ".");
            }
        }
        return bundle;
    }
}
