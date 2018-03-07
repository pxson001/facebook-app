package com.facebook.graphql.modelutil;

import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import java.util.Iterator;

/* compiled from: ready */
public class SerializerHelpers {
    public static void m4182a(Iterator<String> it, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        while (it.hasNext()) {
            jsonGenerator.b((String) it.next());
        }
        jsonGenerator.e();
    }

    public static void m4184b(Iterator<Integer> it, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        while (it.hasNext()) {
            jsonGenerator.b(((Integer) it.next()).intValue());
        }
        jsonGenerator.e();
    }

    public static void m4185c(Iterator<Long> it, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        while (it.hasNext()) {
            jsonGenerator.a(((Long) it.next()).longValue());
        }
        jsonGenerator.e();
    }

    public static void m4180a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, JsonGenerator jsonGenerator) {
        String b = mutableFlatBuffer.b(i, i2);
        if (ObjectType.a(b) != 0) {
            m4181a(b, jsonGenerator);
            return;
        }
        BLog.a("SerializerHelpers", "Unrecognized graphql object type: %s", new Object[]{b});
        jsonGenerator.h();
    }

    public static void m4183b(MutableFlatBuffer mutableFlatBuffer, int i, int i2, JsonGenerator jsonGenerator) {
        GraphQLObjectType graphQLObjectType = (GraphQLObjectType) mutableFlatBuffer.d(i, i2, GraphQLObjectType.class);
        if (graphQLObjectType == null) {
            BLog.a("SerializerHelpers", "Missing graphql object type");
            jsonGenerator.h();
            return;
        }
        String e = graphQLObjectType.e();
        if (ObjectType.a(e) != 0) {
            m4181a(e, jsonGenerator);
            return;
        }
        BLog.a("SerializerHelpers", "Unrecognized graphql object type: %s", new Object[]{e});
        jsonGenerator.h();
    }

    private static void m4181a(String str, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        jsonGenerator.a("name", str);
        jsonGenerator.g();
    }
}
