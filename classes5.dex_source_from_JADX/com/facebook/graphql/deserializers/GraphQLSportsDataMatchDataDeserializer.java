package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: more_bar_menu */
public class GraphQLSportsDataMatchDataDeserializer {
    public static int m5924a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[34];
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[2];
        int[] iArr2 = new int[5];
        long[] jArr = new long[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("active_team_with_ball")) {
                    iArr[0] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("away_team")) {
                    iArr[1] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("away_team_fan_count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("away_team_market")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("away_team_name")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("away_team_primary_color")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("away_team_score")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("broadcast_network")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("clock")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("facts")) {
                    iArr[10] = GraphQLSportsDataMatchToFactsConnectionDeserializer.m5930a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fan_favorite")) {
                    iArr[11] = GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5933a(jsonParser, flatBufferBuilder);
                } else if (i.equals("home_team")) {
                    iArr[12] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("home_team_fan_count")) {
                    zArr[2] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("home_team_market")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("home_team_name")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("home_team_primary_color")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("home_team_score")) {
                    zArr[3] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("period")) {
                    zArr[4] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("scheduled_start_time")) {
                    zArr[5] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("sports_data_cover_photo")) {
                    iArr[22] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sports_data_fallback_photo")) {
                    iArr[23] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sports_subtitle")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("status")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("status_text")) {
                    iArr[26] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("updated_time")) {
                    zArr[6] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("url")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_can_vote_fan_favorite")) {
                    zArr[7] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("match_page")) {
                    iArr[32] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_match_started")) {
                    zArr[8] = true;
                    zArr2[1] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(34);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, iArr2[0], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, iArr2[1], 0);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[2]) {
            flatBufferBuilder.a(13, iArr2[2], 0);
        }
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[3]) {
            flatBufferBuilder.a(17, iArr2[3], 0);
        }
        flatBufferBuilder.b(19, iArr[19]);
        if (zArr[4]) {
            flatBufferBuilder.a(20, iArr2[4], 0);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(21, jArr[0], 0);
        }
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        if (zArr[6]) {
            flatBufferBuilder.a(27, jArr[1], 0);
        }
        flatBufferBuilder.b(28, iArr[28]);
        if (zArr[7]) {
            flatBufferBuilder.a(29, zArr2[0]);
        }
        flatBufferBuilder.b(32, iArr[32]);
        if (zArr[8]) {
            flatBufferBuilder.a(33, zArr2[1]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5925a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5924a(jsonParser, flatBufferBuilder);
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

    public static void m5926a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("active_team_with_ball");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("away_team");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 2, 0);
        if (g != 0) {
            jsonGenerator.a("away_team_fan_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("away_team_market");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("away_team_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("away_team_primary_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.a(i, 6, 0);
        if (g != 0) {
            jsonGenerator.a("away_team_score");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("broadcast_network");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("clock");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("facts");
            GraphQLSportsDataMatchToFactsConnectionDeserializer.m5932a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("fan_favorite");
            GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5935a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("home_team");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 13, 0);
        if (g != 0) {
            jsonGenerator.a("home_team_fan_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("home_team_market");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("home_team_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("home_team_primary_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        g = mutableFlatBuffer.a(i, 17, 0);
        if (g != 0) {
            jsonGenerator.a("home_team_score");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        g = mutableFlatBuffer.a(i, 20, 0);
        if (g != 0) {
            jsonGenerator.a("period");
            jsonGenerator.b(g);
        }
        long a = mutableFlatBuffer.a(i, 21, 0);
        if (a != 0) {
            jsonGenerator.a("scheduled_start_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("sports_data_cover_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("sports_data_fallback_photo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("sports_subtitle");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("status");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("status_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 26));
        }
        a = mutableFlatBuffer.a(i, 27, 0);
        if (a != 0) {
            jsonGenerator.a("updated_time");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        boolean a2 = mutableFlatBuffer.a(i, 29);
        if (a2) {
            jsonGenerator.a("viewer_can_vote_fan_favorite");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("match_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 33);
        if (a2) {
            jsonGenerator.a("has_match_started");
            jsonGenerator.a(a2);
        }
        jsonGenerator.g();
    }
}
