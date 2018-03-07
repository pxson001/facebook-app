package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WHOLESALE_SUPPLY_STORE */
public final class GraphQLPhotosphereMetadata__JsonHelper {
    public static GraphQLPhotosphereMetadata m20784a(JsonParser jsonParser) {
        GraphQLPhotosphereMetadata graphQLPhotosphereMetadata = new GraphQLPhotosphereMetadata();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("full_pano_height_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12569d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "full_pano_height_pixels", graphQLPhotosphereMetadata.a_, 0, false);
            } else if ("full_pano_width_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12570e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "full_pano_width_pixels", graphQLPhotosphereMetadata.a_, 1, false);
            } else if ("cropped_area_image_height_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12571f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "cropped_area_image_height_pixels", graphQLPhotosphereMetadata.a_, 2, false);
            } else if ("cropped_area_image_width_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12572g = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "cropped_area_image_width_pixels", graphQLPhotosphereMetadata.a_, 3, false);
            } else if ("initial_view_heading_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLPhotosphereMetadata.f12573h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "initial_view_heading_degrees", graphQLPhotosphereMetadata.a_, 4, false);
            } else if ("initial_view_pitch_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLPhotosphereMetadata.f12574i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "initial_view_pitch_degrees", graphQLPhotosphereMetadata.a_, 5, false);
            } else if ("initial_view_roll_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLPhotosphereMetadata.f12575j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "initial_view_roll_degrees", graphQLPhotosphereMetadata.a_, 6, false);
            } else if ("initial_view_vertical_fov_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLPhotosphereMetadata.f12576k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "initial_view_vertical_fov_degrees", graphQLPhotosphereMetadata.a_, 7, false);
            } else if ("cropped_area_left_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12577l = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "cropped_area_left_pixels", graphQLPhotosphereMetadata.a_, 8, false);
            } else if ("cropped_area_top_pixels".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotosphereMetadata.f12578m = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotosphereMetadata, "cropped_area_top_pixels", graphQLPhotosphereMetadata.a_, 9, false);
            }
            jsonParser.f();
        }
        return graphQLPhotosphereMetadata;
    }

    public static void m20785a(JsonGenerator jsonGenerator, GraphQLPhotosphereMetadata graphQLPhotosphereMetadata, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("full_pano_height_pixels", graphQLPhotosphereMetadata.m20769a());
        jsonGenerator.a("full_pano_width_pixels", graphQLPhotosphereMetadata.m20773j());
        jsonGenerator.a("cropped_area_image_height_pixels", graphQLPhotosphereMetadata.m20774k());
        jsonGenerator.a("cropped_area_image_width_pixels", graphQLPhotosphereMetadata.m20775l());
        jsonGenerator.a("initial_view_heading_degrees", graphQLPhotosphereMetadata.m20776m());
        jsonGenerator.a("initial_view_pitch_degrees", graphQLPhotosphereMetadata.m20777n());
        jsonGenerator.a("initial_view_roll_degrees", graphQLPhotosphereMetadata.m20778o());
        jsonGenerator.a("initial_view_vertical_fov_degrees", graphQLPhotosphereMetadata.m20779p());
        jsonGenerator.a("cropped_area_left_pixels", graphQLPhotosphereMetadata.m20780q());
        jsonGenerator.a("cropped_area_top_pixels", graphQLPhotosphereMetadata.m20781r());
        if (z) {
            jsonGenerator.g();
        }
    }
}
