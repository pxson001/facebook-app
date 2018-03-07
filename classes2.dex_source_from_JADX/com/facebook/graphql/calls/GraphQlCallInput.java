package com.facebook.graphql.calls;

import com.facebook.crudolib.params.ParamsCollectionArray;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: ro.mediatek.gemini_support */
public abstract class GraphQlCallInput implements JsonSerializable {
    private static final ParamsCollectionPool f6573c = ParamsCollectionPool.m5397a();
    public ParamsCollectionPool f6574a = f6573c;
    public ParamsCollectionMap f6575b = null;

    public final ParamsCollectionMap m11391a() {
        if (this.f6575b == null) {
            this.f6575b = this.f6574a.m5398b();
        }
        return this.f6575b;
    }

    private void m11390b(ParamsCollectionMap paramsCollectionMap, Map<String, Object> map) {
        if (paramsCollectionMap != null) {
            for (int i = 0; i < paramsCollectionMap.f3273c; i++) {
                map.put(paramsCollectionMap.m5423b(i), m11387a(paramsCollectionMap.m5426c(i)));
            }
        }
    }

    private Object m11387a(Object obj) {
        int i = 0;
        if (obj != null && (obj instanceof ParamsCollectionArray)) {
            ParamsCollectionArray paramsCollectionArray = (ParamsCollectionArray) obj;
            if (paramsCollectionArray.m11506j() <= 0 || !(paramsCollectionArray.m11501b(0) instanceof ParamsCollectionMap)) {
                List arrayList = new ArrayList(paramsCollectionArray.m11506j());
                while (i < paramsCollectionArray.m11506j()) {
                    Object b = paramsCollectionArray.m11501b(i);
                    if (b != null) {
                        arrayList.add(b.toString());
                    } else {
                        arrayList.add(null);
                    }
                    i++;
                }
                return arrayList;
            }
            List arrayList2 = new ArrayList(paramsCollectionArray.m11506j());
            for (int i2 = 0; i2 < paramsCollectionArray.m11506j(); i2++) {
                arrayList2.add((Map) m11387a(paramsCollectionArray.m11501b(i2)));
            }
            return arrayList2;
        } else if (obj == null || !(obj instanceof ParamsCollectionMap)) {
            return obj;
        } else {
            ParamsCollectionMap paramsCollectionMap = (ParamsCollectionMap) obj;
            Map treeMap = new TreeMap();
            m11390b(paramsCollectionMap, treeMap);
            return treeMap;
        }
    }

    public final Map<String, Object> m11399b() {
        Map<String, Object> treeMap = new TreeMap();
        m11390b(this.f6575b, treeMap);
        return treeMap;
    }

    public final void m11396a(String str, Integer num) {
        m11391a().m5420a(str, (Number) num);
    }

    public final void m11397a(String str, String str2) {
        m11391a().m5421a(str, str2);
    }

    public final void m11394a(String str, Double d) {
        m11391a().m5420a(str, (Number) d);
    }

    public final void m11398a(String str, List list) {
        m11388a(m11391a().m5425c(str), list);
    }

    private void m11388a(ParamsCollectionArray paramsCollectionArray, List list) {
        if (list != null && !list.isEmpty()) {
            Object obj = list.get(0);
            if (obj instanceof String) {
                for (String a : list) {
                    paramsCollectionArray.m11500a(a);
                }
            } else if (obj instanceof Enum) {
                for (Enum enumR : list) {
                    paramsCollectionArray.m11500a(enumR.toString());
                }
            } else if (obj instanceof GraphQlCallInput) {
                for (GraphQlCallInput a2 : list) {
                    paramsCollectionArray.m11502c(a2.m11391a());
                }
            } else if (obj instanceof Map) {
                for (Map a3 : list) {
                    m11392a(paramsCollectionArray.mo1634k(), a3);
                }
            } else {
                throw new IllegalArgumentException("List value type is not supported: " + obj.getClass());
            }
        }
    }

    private void m11389a(ParamsCollectionMap paramsCollectionMap, String str, Object obj) {
        if (obj != null) {
            if (obj instanceof Boolean) {
                paramsCollectionMap.m5421a(str, ((Boolean) obj).booleanValue() ? "true" : "false");
            } else if (obj instanceof Number) {
                paramsCollectionMap.m5420a(str, (Number) obj);
            } else if (obj instanceof String) {
                paramsCollectionMap.m5421a(str, (String) obj);
            } else if (obj instanceof Enum) {
                paramsCollectionMap.m5421a(str, obj.toString());
            } else if (obj instanceof GraphQlCallInput) {
                paramsCollectionMap.m5418a(str, ((GraphQlCallInput) obj).m11391a());
            } else if (obj instanceof List) {
                m11388a(paramsCollectionMap.m5425c(str), (List) obj);
            } else if (obj instanceof Map) {
                m11392a(paramsCollectionMap.m5422b(str), (Map) obj);
            } else {
                throw new IllegalArgumentException("Unexpected object value type " + obj.getClass());
            }
        }
    }

    public final void m11392a(ParamsCollectionMap paramsCollectionMap, Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            m11389a(paramsCollectionMap, (String) entry.getKey(), entry.getValue());
        }
    }

    public final String m11400m(String str) {
        Object n = m11401n(str);
        if (n == null) {
            return null;
        }
        if (n instanceof String) {
            return (String) n;
        }
        throw new IllegalArgumentException("Value is not String. Actual value type: " + n.getClass());
    }

    public final Object m11401n(String str) {
        if (this.f6575b != null) {
            for (int i = 0; i < this.f6575b.f3273c; i++) {
                if (this.f6575b.m5423b(i).equals(str)) {
                    return m11387a(this.f6575b.m5426c(i));
                }
            }
        }
        return null;
    }

    public final void m11393a(String str, GraphQlCallInput graphQlCallInput) {
        m11391a().m5418a(str, graphQlCallInput.m11391a());
    }

    public final void m11395a(String str, Enum enumR) {
        m11391a().m5421a(str, enumR.toString());
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1114a(m11399b());
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException();
    }
}
