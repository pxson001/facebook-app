package com.facebook.selfupdate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: rapid_reporting_fb4a */
public class AppUpdateLoggerFbImpl {
    private final ObjectMapper f8238a;
    private final SelfUpdateLogger f8239b;

    @Inject
    public AppUpdateLoggerFbImpl(ObjectMapper objectMapper, SelfUpdateLogger selfUpdateLogger) {
        this.f8238a = objectMapper;
        this.f8239b = selfUpdateLogger;
    }

    public final void m12752a(String str, @Nullable JSONObject jSONObject) {
        this.f8239b.m12757a(str, m12750a(jSONObject));
    }

    public final void m12753a(String str, @Nullable JSONObject jSONObject, @Nullable Throwable th) {
        this.f8239b.m12756a(str + " " + String.valueOf(jSONObject), th);
    }

    private Map<String, ?> m12750a(JSONObject jSONObject) {
        Map<String, ?> hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String str = (String) keys.next();
                    Object obj = jSONObject.get(str);
                    if (obj instanceof JSONObject) {
                        hashMap.put(str, m12751b((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        hashMap.put(str, m12749a((JSONArray) obj));
                    } else if (obj == JSONObject.NULL || obj == null) {
                        hashMap.put(str, NullNode.I());
                    } else if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number)) {
                        hashMap.put(str, obj);
                    } else {
                        throw new IllegalArgumentException("Unexpected value in json: " + String.valueOf(obj));
                    }
                } catch (Throwable e) {
                    throw new IllegalArgumentException("org.json exception", e);
                }
            }
        }
        return hashMap;
    }

    private ObjectNode m12751b(JSONObject jSONObject) {
        ObjectNode e = this.f8238a.m6668e();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONObject) {
                e.m5143c(str, m12751b((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                e.m5143c(str, m12749a((JSONArray) obj));
            } else if (obj == JSONObject.NULL || obj == null) {
                e.m5152l(str);
            } else if (obj instanceof String) {
                e.m5137a(str, (String) obj);
            } else if (obj instanceof Boolean) {
                e.m5131a(str, (Boolean) obj);
            } else if (obj instanceof Double) {
                e.m5132a(str, (Double) obj);
            } else if (obj instanceof Long) {
                e.m5135a(str, (Long) obj);
            } else if (!((obj instanceof Integer) || (obj instanceof Short))) {
                throw new IllegalArgumentException("Unexpected value in json: " + String.valueOf(obj));
            }
        }
        return e;
    }

    private ArrayNode m12749a(JSONArray jSONArray) {
        ArrayNode f = this.f8238a.m6669f();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                f.m13381a(m12751b((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                f.m13381a(m12749a((JSONArray) obj));
            } else if (obj == JSONObject.NULL || obj == null) {
                f.m13376J();
            } else if (obj instanceof String) {
                f.m13394h((String) obj);
            } else if (obj instanceof Boolean) {
                f.m13383a((Boolean) obj);
            } else if (obj instanceof Double) {
                f.m13384a((Double) obj);
            } else if (obj instanceof Long) {
                f.m13386a((Long) obj);
            } else if (!((obj instanceof Integer) || (obj instanceof Short))) {
                throw new IllegalArgumentException("Unexpected value in json: " + String.valueOf(obj));
            }
        }
        return f;
    }
}
