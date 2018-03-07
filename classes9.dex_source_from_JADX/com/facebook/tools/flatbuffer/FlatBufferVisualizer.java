package com.facebook.tools.flatbuffer;

import com.facebook.flatbuffers.FlatBuffer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: android_messenger_ride_request */
public class FlatBufferVisualizer {
    private final JSONObject f20413a;
    private final String f20414b;
    public final ByteBuffer f20415c;
    private final int f20416d;
    private final Map<String, String[]> f20417e;
    private final Map<Short, String> f20418f;

    public FlatBufferVisualizer(String str, String str2, ByteBuffer byteBuffer) {
        this.f20413a = new JSONObject(str.replaceAll("(?m)^//.*", ""));
        this.f20414b = str2;
        this.f20415c = byteBuffer;
        this.f20416d = FlatBuffer.a(byteBuffer);
        Map a = m19981a(this.f20413a);
        this.f20417e = (Map) a.get("enum");
        this.f20418f = (Map) a.get("typeid");
    }

    public final JSONObject m19992a() {
        if (!FlatBufferHelper.m19979c(this.f20414b)) {
            return m19982a(this.f20416d, (JSONObject) this.f20413a.get(this.f20414b));
        }
        short a = FlatBuffer.a(this.f20415c, this.f20416d, 0, (short) 0);
        return m19982a(FlatBuffer.o(this.f20415c, this.f20416d, 1), (JSONObject) this.f20413a.get((String) this.f20418f.get(Short.valueOf(a))));
    }

    private JSONObject m19982a(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!str.equals("_typeId_")) {
                JSONObject jSONObject3 = (JSONObject) jSONObject.get(str);
                String str2 = (String) jSONObject3.get("type");
                int intValue = ((Integer) jSONObject3.get("index")).intValue();
                if (FlatBufferHelper.m19979c(str2)) {
                    if (FlatBufferHelper.m19977a(jSONObject3)) {
                        m19988d(i, intValue, jSONObject2, str);
                    } else {
                        m19986c(i, intValue, jSONObject2, str);
                    }
                } else if (FlatBufferHelper.m19975a(str2)) {
                    if (FlatBufferHelper.m19977a(jSONObject3)) {
                        m19985b(intValue, str2, i, jSONObject2, str);
                    } else {
                        m19983a(intValue, str2, i, jSONObject2, str);
                    }
                } else if (!FlatBufferHelper.m19976a(str2, this.f20413a)) {
                    Object obj;
                    JSONObject jSONObject4 = this.f20413a;
                    if (FlatBufferHelper.m19975a(str2) || FlatBufferHelper.m19976a(str2, jSONObject4) || FlatBufferHelper.m19978b(str2)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        if (FlatBufferHelper.m19977a(jSONObject3)) {
                            m19991f(intValue, str2, i, jSONObject2, str);
                        } else {
                            m19990e(intValue, str2, i, jSONObject2, str);
                        }
                    } else if (FlatBufferHelper.m19978b(str2)) {
                        if (FlatBufferHelper.m19977a(jSONObject3)) {
                            m19984b(intValue, i, jSONObject2, str);
                        } else {
                            jSONObject2.put(str, FlatBuffer.b(this.f20415c, i, intValue));
                        }
                    }
                } else if (FlatBufferHelper.m19977a(jSONObject3)) {
                    m19989d(intValue, str2, i, jSONObject2, str);
                } else {
                    m19987c(intValue, str2, i, jSONObject2, str);
                }
            }
        }
        return jSONObject2;
    }

    private void m19983a(int i, String str, int i2, JSONObject jSONObject, String str2) {
        Boolean valueOf;
        ByteBuffer byteBuffer = this.f20415c;
        byte b = (byte) -1;
        switch (str.hashCode()) {
            case 73679:
                if (str.equals("Int")) {
                    b = (byte) 3;
                    break;
                }
                break;
            case 2086184:
                if (str.equals("Byte")) {
                    b = (byte) 4;
                    break;
                }
                break;
            case 2374300:
                if (str.equals("Long")) {
                    b = (byte) 6;
                    break;
                }
                break;
            case 2606829:
                if (str.equals("Time")) {
                    b = (byte) 7;
                    break;
                }
                break;
            case 67973692:
                if (str.equals("Float")) {
                    b = (byte) 2;
                    break;
                }
                break;
            case 79860828:
                if (str.equals("Short")) {
                    b = (byte) 5;
                    break;
                }
                break;
            case 1729365000:
                if (str.equals("Boolean")) {
                    b = (byte) 0;
                    break;
                }
                break;
            case 2052876273:
                if (str.equals("Double")) {
                    b = (byte) 1;
                    break;
                }
                break;
        }
        switch (b) {
            case (byte) 0:
                valueOf = Boolean.valueOf(FlatBuffer.a(byteBuffer, i2, i));
                break;
            case (byte) 1:
            case (byte) 2:
                valueOf = Double.valueOf(FlatBuffer.a(byteBuffer, i2, i, 0.0d));
                break;
            case (byte) 3:
                valueOf = Integer.valueOf(FlatBuffer.a(byteBuffer, i2, i, 0));
                break;
            case (byte) 4:
                valueOf = Byte.valueOf(FlatBuffer.a(byteBuffer, i2, i, (byte) 0));
                break;
            case (byte) 5:
                valueOf = Short.valueOf(FlatBuffer.a(byteBuffer, i2, i, (short) 0));
                break;
            case (byte) 6:
            case (byte) 7:
                valueOf = Long.valueOf(FlatBuffer.a(byteBuffer, i2, i, 0));
                break;
            default:
                valueOf = null;
                break;
        }
        jSONObject.put(str2, valueOf);
    }

    private void m19985b(int i, String str, int i2, JSONObject jSONObject, String str2) {
        ByteBuffer byteBuffer = this.f20415c;
        Object obj = -1;
        switch (str.hashCode()) {
            case 73679:
                if (str.equals("Int")) {
                    obj = 3;
                    break;
                }
                break;
            case 2086184:
                if (str.equals("Byte")) {
                    obj = 4;
                    break;
                }
                break;
            case 2374300:
                if (str.equals("Long")) {
                    obj = 6;
                    break;
                }
                break;
            case 2606829:
                if (str.equals("Time")) {
                    obj = 7;
                    break;
                }
                break;
            case 67973692:
                if (str.equals("Float")) {
                    obj = 2;
                    break;
                }
                break;
            case 79860828:
                if (str.equals("Short")) {
                    obj = 5;
                    break;
                }
                break;
            case 1729365000:
                if (str.equals("Boolean")) {
                    obj = null;
                    break;
                }
                break;
            case 2052876273:
                if (str.equals("Double")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                Object obj2;
                int o = FlatBuffer.o(byteBuffer, i2, i);
                if (o != 0) {
                    int b = FlatBuffer.b(byteBuffer, o);
                    int i3 = o + 4;
                    Object obj3 = new boolean[b];
                    for (int i4 = 0; i4 < b; i4++) {
                        obj3[i4] = byteBuffer.get((i4 * 1) + i3) != (byte) 0;
                    }
                    obj2 = obj3;
                } else {
                    obj2 = null;
                }
                obj = obj2;
                break;
            case 1:
            case 2:
                obj = FlatBuffer.h(byteBuffer, i2, i);
                break;
            case 3:
                obj = FlatBuffer.f(byteBuffer, i2, i);
                break;
            case 4:
                obj = FlatBuffer.d(byteBuffer, i2, i);
                break;
            case 5:
                obj = FlatBuffer.e(byteBuffer, i2, i);
                break;
            case 6:
            case 7:
                obj = FlatBuffer.g(byteBuffer, i2, i);
                break;
            default:
                obj = null;
                break;
        }
        jSONObject.put(str2, obj);
    }

    private void m19987c(int i, String str, int i2, JSONObject jSONObject, String str2) {
        int a = FlatBuffer.a(this.f20415c, i2, i, (short) -1);
        if (a != (short) -1) {
            jSONObject.put(str2, m19980a(str, a));
        }
    }

    private void m19989d(int i, String str, int i2, JSONObject jSONObject, String str2) {
        short[] e = FlatBuffer.e(this.f20415c, i2, i);
        if (e != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < e.length; i3++) {
                if (e[i3] != (short) -1) {
                    jSONArray.put(m19980a(str, e[i3]));
                }
            }
            jSONObject.put(str2, jSONArray);
        }
    }

    private void m19984b(int i, int i2, JSONObject jSONObject, String str) {
        Object obj;
        ByteBuffer byteBuffer = this.f20415c;
        int o = FlatBuffer.o(byteBuffer, i2, i);
        if (o != 0) {
            int b = FlatBuffer.b(byteBuffer, o);
            int i3 = o + 4;
            obj = new String[b];
            for (int i4 = 0; i4 < b; i4++) {
                int i5 = (i4 * 4) + i3;
                int i6 = byteBuffer.getInt(i5);
                if (i6 == 0) {
                    obj[i4] = null;
                } else {
                    obj[i4] = FlatBuffer.a(byteBuffer, i5 + i6);
                }
            }
        } else {
            obj = null;
        }
        jSONObject.put(str, obj);
    }

    private void m19990e(int i, String str, int i2, JSONObject jSONObject, String str2) {
        int o = FlatBuffer.o(this.f20415c, i2, i);
        if (o != 0) {
            jSONObject.put(str2, m19982a(o, (JSONObject) this.f20413a.get(str)));
        }
    }

    private void m19991f(int i, String str, int i2, JSONObject jSONObject, String str2) {
        int o = FlatBuffer.o(this.f20415c, i2, i);
        if (o != 0) {
            int i3 = o + 4;
            int[] f = FlatBuffer.f(this.f20415c, i2, i);
            JSONArray jSONArray = new JSONArray();
            if (f != null) {
                for (o = 0; o < f.length; o++) {
                    jSONArray.put(m19982a((o * 4) + (f[o] + i3), (JSONObject) this.f20413a.get(str)));
                }
            } else {
                String format = String.format("%s: cannot parse flatbuffer data with field name: %s to output. Cannot obtain its array reference.", new Object[]{getClass().getSimpleName(), str2});
                System.out.println(format);
                jSONArray.put(format);
            }
            jSONObject.put(str2, jSONArray);
        }
    }

    private void m19986c(int i, int i2, JSONObject jSONObject, String str) {
        int o = FlatBuffer.o(this.f20415c, i, i2);
        if (o != 0) {
            jSONObject.put(str, m19982a(FlatBuffer.o(this.f20415c, o, 1), (JSONObject) this.f20413a.get((String) this.f20418f.get(Short.valueOf(FlatBuffer.a(this.f20415c, o, 0, (short) -1))))));
        }
    }

    private void m19988d(int i, int i2, JSONObject jSONObject, String str) {
        int o = FlatBuffer.o(this.f20415c, i, i2);
        if (o != 0) {
            int i3 = o + 4;
            int[] f = FlatBuffer.f(this.f20415c, i, i2);
            JSONArray jSONArray = new JSONArray();
            if (f != null) {
                for (int i4 = 0; i4 < f.length; i4++) {
                    short a = FlatBuffer.a(this.f20415c, (f[i4] + i3) + (i4 * 4), 0, (short) 0);
                    jSONArray.put(m19982a(FlatBuffer.o(this.f20415c, (f[i4] + i3) + (i4 * 4), 1), (JSONObject) this.f20413a.get((String) this.f20418f.get(Short.valueOf(a)))));
                }
            } else {
                String format = String.format("%s: cannot parse flatbuffer data with field name: %s to output. Cannot obtain its array reference.", new Object[]{getClass().getSimpleName(), str});
                System.out.println(format);
                jSONArray.put(format);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    @Nullable
    private String m19980a(String str, int i) {
        try {
            return ((String[]) this.f20417e.get(str))[i];
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(new StringWriter()));
            System.out.println(String.format("%s: %s is not enum type or array index %d out of bound.\n%s", new Object[]{getClass().getSimpleName(), str, Integer.valueOf(i), r1.toString()}));
            return null;
        }
    }

    private static Map<String, Map> m19981a(JSONObject jSONObject) {
        Map<String, Map> hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(str);
            if (jSONObject2.has("_isEnum_") && jSONObject2.getBoolean("_isEnum_")) {
                Object obj = new String[15];
                Iterator keys2 = jSONObject2.keys();
                Object obj2 = obj;
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    if (!str2.equals("_isEnum_")) {
                        int i = jSONObject2.getInt(str2);
                        while (obj2.length <= i) {
                            Object obj3 = new String[(obj2.length * 2)];
                            for (int i2 = 0; i2 < obj2.length; i2++) {
                                obj3[i2] = obj2[i2];
                            }
                            obj2 = obj3;
                        }
                        if (obj2[i] != null) {
                            throw new JSONException("enum value cannot share the same ordinal number");
                        }
                        obj2[i] = str2;
                    }
                    obj2 = obj2;
                }
                hashMap2.put(str, obj2);
            } else if (jSONObject2.has("_typeId_")) {
                hashMap3.put(Short.valueOf(((Number) jSONObject2.get("_typeId_")).shortValue()), str);
            }
        }
        hashMap.put("enum", hashMap2);
        hashMap.put("typeid", hashMap3);
        return hashMap;
    }
}
