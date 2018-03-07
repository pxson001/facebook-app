package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> f23975a;

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    public interface Setter {
        void mo1037a(Bundle bundle, String str, Object obj);
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34361 implements Setter {
        C34361() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34372 implements Setter {
        C34372() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34383 implements Setter {
        C34383() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34394 implements Setter {
        C34394() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34405 implements Setter {
        C34405() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34416 implements Setter {
        C34416() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            throw new IllegalArgumentException("Unexpected type from JSON");
        }
    }

    /* compiled from: SEND_SKIPPED_PAYMENT_MESSAGE */
    final class C34427 implements Setter {
        C34427() {
        }

        public final void mo1037a(Bundle bundle, String str, Object obj) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    arrayList.add((String) obj2);
                    i++;
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }
    }

    static {
        Map hashMap = new HashMap();
        f23975a = hashMap;
        hashMap.put(Boolean.class, new C34361());
        f23975a.put(Integer.class, new C34372());
        f23975a.put(Long.class, new C34383());
        f23975a.put(Double.class, new C34394());
        f23975a.put(String.class, new C34405());
        f23975a.put(String[].class, new C34416());
        f23975a.put(JSONArray.class, new C34427());
    }

    public static Bundle m25252a(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(str, m25252a((JSONObject) obj));
                } else {
                    Setter setter = (Setter) f23975a.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.mo1037a(bundle, str, obj);
                }
            }
        }
        return bundle;
    }
}
