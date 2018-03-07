package com.facebook.catalyst.modules.persistedqueries;

import android.content.Context;
import com.facebook.common.util.StreamUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: unmodifiedFileSchemeUriKey */
public class PersistedQueriesHelper {
    PersistedQueriesHelper() {
    }

    @Nullable
    public static Map<String, String> m1048a(Context context, String str, String str2, Map<String, Object> map, @Nullable JSONObject jSONObject) {
        JSONObject a = m1049a(context, str);
        if (!a.has(str2)) {
            return null;
        }
        JSONArray jSONArray = a.getJSONArray(str2);
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            hashMap.put(jSONObject2.getString("name"), m1050a(context, jSONObject2, (Map) map, jSONObject).toString());
        }
        return hashMap;
    }

    private static JSONObject m1049a(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            JSONObject jSONObject = new JSONObject(new String(StreamUtil.a(inputStream)));
            return jSONObject;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static JSONObject m1050a(Context context, JSONObject jSONObject, Map<String, Object> map, @Nullable JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject.getJSONObject("variables");
        JSONObject jSONObject4 = new JSONObject();
        Iterator keys = jSONObject3.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            jSONObject4.put(str, m1047a(context, jSONObject3.getJSONObject(str), map));
        }
        jSONObject3 = jSONObject4;
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("priority", 0);
        jSONObject5.put("query_id", jSONObject.get("id"));
        jSONObject5.put("query_params", jSONObject3);
        if (jSONObject2 != null) {
            jSONObject5.put("rerun_param", jSONObject2);
        }
        jSONObject3 = new JSONObject();
        jSONObject3.put(jSONObject.getString("name"), jSONObject5);
        return jSONObject3;
    }

    public static Object m1047a(Context context, Object obj, Map<String, Object> map) {
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject = (JSONObject) obj;
        String string = jSONObject.getString("kind");
        String string2 = jSONObject.getString("name");
        if ("user".equals(string)) {
            if (map.containsKey(string2)) {
                return map.get(string2);
            }
            throw new RuntimeException("No user defined value for param " + string2);
        } else if ("computed".equals(string)) {
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            int i = -1;
            switch (string2.hashCode()) {
                case -1222584875:
                    if (string2.equals("Dimensions.get")) {
                        i = 0;
                        break;
                    }
                    break;
                case -72726758:
                    if (string2.equals("PixelRatio.getPixelSizeForLayoutSize")) {
                        i = 2;
                        break;
                    }
                    break;
                case 51248602:
                    if (string2.equals("PersistableOperation.ceil")) {
                        i = 4;
                        break;
                    }
                    break;
                case 280471673:
                    if (string2.equals("PersistableOperation.multiply")) {
                        i = 8;
                        break;
                    }
                    break;
                case 449492326:
                    if (string2.equals("PersistableOperation.condition")) {
                        i = 5;
                        break;
                    }
                    break;
                case 832935212:
                    if (string2.equals("PersistableOperation.add")) {
                        i = 3;
                        break;
                    }
                    break;
                case 1568168749:
                    if (string2.equals("PixelRatio.get")) {
                        i = 1;
                        break;
                    }
                    break;
                case 1591691735:
                    if (string2.equals("PersistableOperation.floor")) {
                        i = 7;
                        break;
                    }
                    break;
                case 1861361001:
                    if (string2.equals("PersistableOperation.subtract")) {
                        i = 9;
                        break;
                    }
                    break;
                case 2037977102:
                    if (string2.equals("PersistableOperation.divide")) {
                        i = 6;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    return Double.valueOf(PixelRatioQueryHelper.m1052a(context, (String) m1047a(context, jSONArray.get(0), map), (String) m1047a(context, jSONArray.get(1), map)));
                case 1:
                    return Double.valueOf(PixelRatioQueryHelper.m1051a(context));
                case 2:
                    return Long.valueOf(Math.round(PixelRatioQueryHelper.m1051a(context) * m1046a(context, jSONArray, (Map) map, 0).doubleValue()));
                case 3:
                    return Double.valueOf(m1046a(context, jSONArray, (Map) map, 0).doubleValue() + m1046a(context, jSONArray, (Map) map, 1).doubleValue());
                case 4:
                    return Double.valueOf(Math.ceil(m1046a(context, jSONArray, (Map) map, 0).doubleValue()));
                case 5:
                    string = ((JSONObject) jSONArray.get(0)).getString("name");
                    if ("FBGlobalConfig.isLowImageFidelity".equals(string)) {
                        return m1046a(context, jSONArray, (Map) map, 1);
                    }
                    throw new RuntimeException("Unknown condition type " + string);
                case 6:
                    return Double.valueOf(m1046a(context, jSONArray, (Map) map, 0).doubleValue() / m1046a(context, jSONArray, (Map) map, 1).doubleValue());
                case 7:
                    return Double.valueOf(Math.floor(m1046a(context, jSONArray, (Map) map, 0).doubleValue()));
                case 8:
                    return Double.valueOf(m1046a(context, jSONArray, (Map) map, 0).doubleValue() * m1046a(context, jSONArray, (Map) map, 1).doubleValue());
                case 9:
                    return Double.valueOf(m1046a(context, jSONArray, (Map) map, 0).doubleValue() - m1046a(context, jSONArray, (Map) map, 1).doubleValue());
                default:
                    throw new RuntimeException("Unknown query param name " + string2);
            }
        } else {
            throw new RuntimeException("Unknown query param type " + string);
        }
    }

    private static Double m1046a(Context context, JSONArray jSONArray, Map<String, Object> map, int i) {
        Object a = m1047a(context, jSONArray.get(i), map);
        if (a instanceof Integer) {
            return Double.valueOf(((Integer) a).doubleValue());
        }
        return Double.valueOf(((Double) a).doubleValue());
    }
}
