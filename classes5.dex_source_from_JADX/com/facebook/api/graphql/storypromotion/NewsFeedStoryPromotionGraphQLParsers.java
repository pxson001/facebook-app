package com.facebook.api.graphql.storypromotion;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: target_entity_type */
public class NewsFeedStoryPromotionGraphQLParsers {

    /* compiled from: target_entity_type */
    public final class SponsoredDataFieldsParser {
        public static int m2971a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[14];
            boolean[] zArr = new boolean[12];
            boolean[] zArr2 = new boolean[9];
            int[] iArr2 = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("impression_logging_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_demo_ad")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_eligible_for_invalidation")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("is_group_mall_ad")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_non_connected_page_post")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("min_sponsored_gap")) {
                        zArr[4] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("should_log_full_view")) {
                        zArr[5] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("show_ad_preferences")) {
                        zArr[6] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("show_sponsored_label")) {
                        zArr[7] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("third_party_click_tracking_url")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("third_party_impression_logging_needed")) {
                        zArr[8] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("uses_remarketing")) {
                        zArr[9] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("viewability_duration")) {
                        zArr[10] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("viewability_percentage")) {
                        zArr[11] = true;
                        iArr2[2] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(3, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(4, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(6, zArr2[4]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(7, zArr2[5]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(8, zArr2[6]);
            }
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[8]) {
                flatBufferBuilder.a(10, zArr2[7]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(11, zArr2[8]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(12, iArr2[1], 0);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(13, iArr2[2], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m2972a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("impression_logging_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_demo_ad");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("is_eligible_for_invalidation");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("is_group_mall_ad");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("is_non_connected_page_post");
                jsonGenerator.a(a);
            }
            int a2 = mutableFlatBuffer.a(i, 5, 0);
            if (a2 != 0) {
                jsonGenerator.a("min_sponsored_gap");
                jsonGenerator.b(a2);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("should_log_full_view");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("show_ad_preferences");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("show_sponsored_label");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("third_party_click_tracking_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("third_party_impression_logging_needed");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("uses_remarketing");
                jsonGenerator.a(a);
            }
            a2 = mutableFlatBuffer.a(i, 12, 0);
            if (a2 != 0) {
                jsonGenerator.a("viewability_duration");
                jsonGenerator.b(a2);
            }
            a2 = mutableFlatBuffer.a(i, 13, 0);
            if (a2 != 0) {
                jsonGenerator.a("viewability_percentage");
                jsonGenerator.b(a2);
            }
            jsonGenerator.g();
        }
    }
}
