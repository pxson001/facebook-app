package com.facebook.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import org.json.JSONArray;

/* compiled from: publish_share */
public class JSONUtil {
    public static boolean m13455a(@Nullable JsonNode jsonNode) {
        return (jsonNode == null || jsonNode.m5205q()) ? false : true;
    }

    public static String m13458b(@Nullable JsonNode jsonNode) {
        return m13454a(jsonNode, null);
    }

    public static String m13454a(@Nullable JsonNode jsonNode, @Nullable String str) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return str;
        }
        if (jsonNode.m5203o()) {
            return jsonNode.mo728s();
        }
        if (jsonNode.m5201m()) {
            return jsonNode.mo1282v().toString();
        }
        return str;
    }

    public static long m13459c(JsonNode jsonNode) {
        return m13450a(jsonNode, 0);
    }

    public static long m13450a(@Nullable JsonNode jsonNode, long j) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return j;
        }
        if (jsonNode.m5203o()) {
            try {
                return Long.parseLong(jsonNode.mo728s());
            } catch (NumberFormatException e) {
                return j;
            }
        } else if (jsonNode.m5201m()) {
            return jsonNode.mo1284x();
        } else {
            return j;
        }
    }

    public static int m13460d(@Nullable JsonNode jsonNode) {
        return m13449a(jsonNode, 0);
    }

    public static int m13449a(@Nullable JsonNode jsonNode, int i) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return i;
        }
        if (jsonNode.m5203o()) {
            try {
                return Integer.parseInt(jsonNode.mo728s());
            } catch (NumberFormatException e) {
                return i;
            }
        } else if (jsonNode.m5201m()) {
            return jsonNode.mo1283w();
        } else {
            return i;
        }
    }

    public static double m13461e(JsonNode jsonNode) {
        return m13447a(jsonNode, 0.0d);
    }

    private static double m13447a(JsonNode jsonNode, double d) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return d;
        }
        if (jsonNode.m5203o()) {
            try {
                return Double.parseDouble(jsonNode.mo728s());
            } catch (NumberFormatException e) {
                return d;
            }
        } else if (jsonNode.m5201m()) {
            return jsonNode.mo1285y();
        } else {
            return d;
        }
    }

    public static float m13462f(JsonNode jsonNode) {
        return m13448a(jsonNode, 0.0f);
    }

    public static float m13448a(@Nullable JsonNode jsonNode, float f) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return f;
        }
        if (jsonNode.m5203o()) {
            try {
                return Float.parseFloat(jsonNode.mo728s());
            } catch (NumberFormatException e) {
                return f;
            }
        } else if (jsonNode.m5201m()) {
            return jsonNode.mo1282v().floatValue();
        } else {
            return f;
        }
    }

    public static boolean m13463g(JsonNode jsonNode) {
        return m13456a(jsonNode, false);
    }

    public static boolean m13456a(@Nullable JsonNode jsonNode, boolean z) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return z;
        }
        if (jsonNode.m5204p()) {
            return jsonNode.mo1647u();
        }
        if (jsonNode.m5203o()) {
            String s = jsonNode.mo728s();
            return "on".equals(s) || "1".equals(s) || "true".equals(s);
        } else if (jsonNode.m5201m()) {
            return jsonNode.mo1283w() != 0;
        } else {
            return z;
        }
    }

    public static ImmutableList<String> m13453a(JSONArray jSONArray) {
        ArrayList a = Lists.m1297a(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            a.add(jSONArray.getString(i));
        }
        return ImmutableList.copyOf((Collection) a);
    }

    public static ObjectNode m13452a(Map<String, String> map) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                objectNode.m5137a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return objectNode;
    }

    public static ObjectNode m13451a(List<String> list) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        int size = list.size();
        if (!(list == null || list.isEmpty())) {
            for (int i = 0; i < size; i += 2) {
                objectNode.m5137a((String) list.get(i), (String) list.get(i + 1));
            }
        }
        return objectNode;
    }

    public static ArrayNode m13457b(List<String> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        for (String h : list) {
            arrayNode.m13394h(h);
        }
        return arrayNode;
    }
}
