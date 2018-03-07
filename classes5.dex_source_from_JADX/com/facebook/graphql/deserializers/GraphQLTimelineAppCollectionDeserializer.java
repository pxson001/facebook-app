package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_android_finch_edit */
public class GraphQLTimelineAppCollectionDeserializer {
    public static int m6066a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[20];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("add_item_action_info")) {
                    iArr[0] = GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6074a(jsonParser, flatBufferBuilder);
                } else if (i.equals("added_item_state_info")) {
                    iArr[1] = GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6074a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_section")) {
                    iArr[2] = GraphQLTimelineAppSectionDeserializer.m6080a(jsonParser, flatBufferBuilder);
                } else if (i.equals("application")) {
                    iArr[3] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("curation_nux_message")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("curation_url")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("mediaset")) {
                    iArr[8] = GraphQLMediaSetDeserializer.m5355a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("new_item_default_privacy")) {
                    iArr[10] = GraphQLPrivacyOptionDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("rating_title")) {
                    iArr[11] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("remove_item_action_info")) {
                    iArr[12] = GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6074a(jsonParser, flatBufferBuilder);
                } else if (i.equals("saved_dashboard_section")) {
                    iArr[14] = GraphQLSavedDashboardSectionDeserializer.m5859a(jsonParser, flatBufferBuilder);
                } else if (i.equals("style_list")) {
                    iArr[15] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLTimelineAppCollectionStyle.class);
                } else if (i.equals("supports_suggestions")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("tracking")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("view_collection_prompt")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(20);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[0]) {
            flatBufferBuilder.a(16, zArr2[0]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        return flatBufferBuilder.d();
    }

    public static int m6069b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m6066a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m6067a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6066a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m6068a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m6070b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m6070b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("add_item_action_info");
            GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("added_item_state_info");
            GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("app_section");
            GraphQLTimelineAppSectionDeserializer.m6082a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("curation_nux_message");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("curation_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("mediaset");
            GraphQLMediaSetDeserializer.m5357a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("new_item_default_privacy");
            GraphQLPrivacyOptionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("rating_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("remove_item_action_info");
            GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("saved_dashboard_section");
            GraphQLSavedDashboardSectionDeserializer.m5861a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("style_list");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 15), jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("supports_suggestions");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("view_collection_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        jsonGenerator.g();
    }
}
