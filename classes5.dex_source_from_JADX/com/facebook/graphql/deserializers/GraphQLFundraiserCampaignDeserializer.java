package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_permalink */
public class GraphQLFundraiserCampaignDeserializer {
    public static int m4972a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[29];
        boolean[] zArr = new boolean[3];
        boolean[] zArr2 = new boolean[2];
        double[] dArr = new double[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("amount_raised_text")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[1] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("campaign_goal_text")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("campaign_title")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("can_invite_to_campaign")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("cover_photo")) {
                    iArr[5] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("currency")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("default_share_message")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("description")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fundraiser_page")) {
                    iArr[10] = GraphQLFundraiserPageDeserializer.m4978a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_goal_amount")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("id")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("learn_more_url")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("logo_image")) {
                    iArr[14] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("matching_message")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("mobile_donate_url")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("percent_of_goal_reached")) {
                    zArr[2] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("url")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fundraiser_for_charity_text")) {
                    iArr[19] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("charity")) {
                    iArr[20] = GraphQLFundraiserCharityDeserializer.m4975a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fundraiser_page_subtitle")) {
                    iArr[21] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[22] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[24] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[25] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fundraiser_detailed_progress_text")) {
                    iArr[28] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(29);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[1]) {
            flatBufferBuilder.a(11, zArr2[1]);
        }
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[2]) {
            flatBufferBuilder.a(17, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(28, iArr[28]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4973a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4972a(jsonParser, flatBufferBuilder);
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

    public static void m4974a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("amount_raised_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("campaign_goal_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("campaign_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_invite_to_campaign");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("currency");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("default_share_message");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("fundraiser_page");
            GraphQLFundraiserPageDeserializer.m4980a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("has_goal_amount");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("learn_more_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("logo_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("matching_message");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("mobile_donate_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        double a2 = mutableFlatBuffer.a(i, 17, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("percent_of_goal_reached");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("fundraiser_for_charity_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("charity");
            GraphQLFundraiserCharityDeserializer.m4977a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("fundraiser_page_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("fundraiser_detailed_progress_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
