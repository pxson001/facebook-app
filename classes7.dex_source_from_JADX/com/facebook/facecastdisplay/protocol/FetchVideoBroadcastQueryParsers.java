package com.facebook.facecastdisplay.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: sticker_picker_closed */
public class FetchVideoBroadcastQueryParsers {

    /* compiled from: sticker_picker_closed */
    public final class VideoBroadcastFragmentParser {
        public static int m4025a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[8];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("atom_size")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("bitrate")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("broadcast_status")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                    } else if (i.equals("hdAtomSize")) {
                        zArr[2] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("hdBitrate")) {
                        zArr[3] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_live_streaming")) {
                        zArr[4] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("live_viewer_count")) {
                        zArr[5] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("live_viewer_count_read_only")) {
                        zArr[6] = true;
                        iArr2[5] = jsonParser.E();
                    } else if (i.equals("playableUrlHdString")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playableUrlRtmpString")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[7] = true;
                        iArr2[6] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playlist")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("preferredPlayableUrlString")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, iArr2[1], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[2]) {
                flatBufferBuilder.a(3, iArr2[2], 0);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(4, iArr2[3], 0);
            }
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[4]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(7, iArr2[4], 0);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(8, iArr2[5], 0);
            }
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            if (zArr[7]) {
                flatBufferBuilder.a(11, iArr2[6], 0);
            }
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            return flatBufferBuilder.d();
        }

        public static void m4026a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("atom_size");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("bitrate");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("broadcast_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("hdAtomSize");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("hdBitrate");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            boolean a2 = mutableFlatBuffer.a(i, 6);
            if (a2) {
                jsonGenerator.a("is_live_streaming");
                jsonGenerator.a(a2);
            }
            a = mutableFlatBuffer.a(i, 7, 0);
            if (a != 0) {
                jsonGenerator.a("live_viewer_count");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 8, 0);
            if (a != 0) {
                jsonGenerator.a("live_viewer_count_read_only");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("playableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("playableUrlRtmpString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            a = mutableFlatBuffer.a(i, 11, 0);
            if (a != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("playlist");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("preferredPlayableUrlString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            jsonGenerator.g();
        }
    }
}
