package com.facebook.internal;

import com.facebook.FacebookRequestError.Category;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SEND_SKIPPED_HAS_FLOWER_BORDER */
public final class FacebookRequestErrorClassification {
    private static FacebookRequestErrorClassification f23981g;
    private final Map<Integer, Set<Integer>> f23982a;
    private final Map<Integer, Set<Integer>> f23983b;
    private final Map<Integer, Set<Integer>> f23984c;
    private final String f23985d;
    private final String f23986e;
    private final String f23987f;

    /* compiled from: SEND_SKIPPED_HAS_FLOWER_BORDER */
    final class C34451 extends HashMap<Integer, Set<Integer>> {
        C34451() {
            put(Integer.valueOf(2), null);
            put(Integer.valueOf(4), null);
            put(Integer.valueOf(9), null);
            put(Integer.valueOf(17), null);
            put(Integer.valueOf(341), null);
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_FLOWER_BORDER */
    final class C34462 extends HashMap<Integer, Set<Integer>> {
        C34462() {
            put(Integer.valueOf(102), null);
            put(Integer.valueOf(190), null);
        }
    }

    private FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.f23982a = map;
        this.f23983b = map2;
        this.f23984c = map3;
        this.f23985d = str;
        this.f23986e = str2;
        this.f23987f = str3;
    }

    public final String m25265a(Category category) {
        switch (category) {
            case OTHER:
                return this.f23985d;
            case LOGIN_RECOVERABLE:
                return this.f23987f;
            case TRANSIENT:
                return this.f23986e;
            default:
                return null;
        }
    }

    public final Category m25264a(int i, int i2, boolean z) {
        if (z) {
            return Category.TRANSIENT;
        }
        Set set;
        if (this.f23982a != null && this.f23982a.containsKey(Integer.valueOf(i))) {
            set = (Set) this.f23982a.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return Category.OTHER;
            }
        }
        if (this.f23984c != null && this.f23984c.containsKey(Integer.valueOf(i))) {
            set = (Set) this.f23984c.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return Category.LOGIN_RECOVERABLE;
            }
        }
        if (this.f23983b != null && this.f23983b.containsKey(Integer.valueOf(i))) {
            set = (Set) this.f23983b.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return Category.TRANSIENT;
            }
        }
        return Category.OTHER;
    }

    public static synchronized FacebookRequestErrorClassification m25260a() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            if (f23981g == null) {
                f23981g = m25263b();
            }
            facebookRequestErrorClassification = f23981g;
        }
        return facebookRequestErrorClassification;
    }

    private static FacebookRequestErrorClassification m25263b() {
        return new FacebookRequestErrorClassification(null, new C34451(), new C34462(), null, null, null);
    }

    private static Map<Integer, Set<Integer>> m25262a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            return null;
        }
        Map<Integer, Set<Integer>> hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("code");
                if (optInt != 0) {
                    Object obj;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                        obj = null;
                    } else {
                        Set hashSet = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            int optInt2 = optJSONArray2.optInt(i2);
                            if (optInt2 != 0) {
                                hashSet.add(Integer.valueOf(optInt2));
                            }
                        }
                        obj = hashSet;
                    }
                    hashMap.put(Integer.valueOf(optInt), obj);
                }
            }
        }
        return hashMap;
    }

    public static FacebookRequestErrorClassification m25261a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        Map map = null;
        Map map2 = null;
        Map map3 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    if (optString.equalsIgnoreCase("other")) {
                        str3 = optJSONObject.optString("recovery_message", null);
                        map3 = m25262a(optJSONObject);
                    } else if (optString.equalsIgnoreCase("transient")) {
                        str2 = optJSONObject.optString("recovery_message", null);
                        map2 = m25262a(optJSONObject);
                    } else if (optString.equalsIgnoreCase("login_recoverable")) {
                        str = optJSONObject.optString("recovery_message", null);
                        map = m25262a(optJSONObject);
                    }
                }
            }
        }
        return new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
    }
}
