package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: new_pin */
public class GraphQLPlaceDeserializer {
    public static int m5638a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[48];
        boolean[] zArr = new boolean[13];
        boolean[] zArr2 = new boolean[7];
        Enum[] enumArr = new Enum[6];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("address")) {
                    iArr[1] = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_claim")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_rate")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("category_icon")) {
                    iArr[5] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_names")) {
                    iArr[6] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_type")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLPageCategoryType.fromString(jsonParser.o());
                } else if (i.equals("city")) {
                    iArr[8] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("contextual_name")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("does_viewer_like")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("expressed_as_place")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("friends_who_visited")) {
                    iArr[12] = GraphQLFriendsWhoVisitedConnectionDeserializer.m4962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("full_name")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hours")) {
                    iArr[14] = GraphQLTimeRangeDeserializer.m6065b(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_owned")) {
                    zArr[5] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("location")) {
                    iArr[17] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_bounding_box")) {
                    iArr[18] = GraphQLGeoRectangleDeserializer.m4993a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("overall_star_rating")) {
                    iArr[20] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[21] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_visits")) {
                    iArr[22] = GraphQLPageVisitsConnectionDeserializer.m5533a(jsonParser, flatBufferBuilder);
                } else if (i.equals("permanently_closed_status")) {
                    zArr[6] = true;
                    enumArr[1] = GraphQLPermanentlyClosedStatus.fromString(jsonParser.o());
                } else if (i.equals("placeProfilePicture")) {
                    iArr[24] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_topic_id")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("place_type")) {
                    zArr[7] = true;
                    enumArr[2] = GraphQLPlaceType.fromString(jsonParser.o());
                } else if (i.equals("price_range_description")) {
                    iArr[27] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profilePicture50")) {
                    iArr[28] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture74")) {
                    iArr[29] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[30] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[31] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[8] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("raters")) {
                    iArr[33] = GraphQLPageStarRatersConnectionDeserializer.m5521a(jsonParser, flatBufferBuilder);
                } else if (i.equals("redirection_info")) {
                    iArr[34] = GraphQLRedirectionInfoDeserializer.m5802b(jsonParser, flatBufferBuilder);
                } else if (i.equals("representative_place_photos")) {
                    iArr[35] = GraphQLPhotoDeserializer.m5604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("saved_collection")) {
                    iArr[36] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_category_names")) {
                    iArr[37] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_show_reviews_on_profile")) {
                    zArr[9] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("spotlight_locals_snippets")) {
                    iArr[39] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("super_category_type")) {
                    zArr[10] = true;
                    enumArr[3] = GraphQLPageSuperCategoryType.fromString(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[41] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_profile_permissions")) {
                    iArr[42] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[11] = true;
                    enumArr[4] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("websites")) {
                    iArr[44] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_visits")) {
                    iArr[45] = GraphQLViewerVisitsConnectionDeserializer.m6202a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status")) {
                    iArr[46] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status_type")) {
                    zArr[12] = true;
                    enumArr[5] = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(48);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[1]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[2]) {
            flatBufferBuilder.a(7, enumArr[0]);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[3]) {
            flatBufferBuilder.a(10, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[3]);
        }
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[5]) {
            flatBufferBuilder.a(16, zArr2[4]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        if (zArr[6]) {
            flatBufferBuilder.a(23, enumArr[1]);
        }
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        if (zArr[7]) {
            flatBufferBuilder.a(26, enumArr[2]);
        }
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        if (zArr[8]) {
            flatBufferBuilder.a(32, zArr2[5]);
        }
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        if (zArr[9]) {
            flatBufferBuilder.a(38, zArr2[6]);
        }
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[10]) {
            flatBufferBuilder.a(40, enumArr[3]);
        }
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        if (zArr[11]) {
            flatBufferBuilder.a(43, enumArr[4]);
        }
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        if (zArr[12]) {
            flatBufferBuilder.a(47, enumArr[5]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5639a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5638a(jsonParser, flatBufferBuilder);
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

    public static void m5640a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("address");
            GraphQLStreetAddressDeserializer.m5996a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("can_viewer_claim");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_viewer_rate");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("category_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 6), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 7, (short) 0) != (short) 0) {
            jsonGenerator.a("category_type");
            jsonGenerator.b(((GraphQLPageCategoryType) mutableFlatBuffer.a(i, 7, GraphQLPageCategoryType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("city");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("contextual_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("expressed_as_place");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("friends_who_visited");
            GraphQLFriendsWhoVisitedConnectionDeserializer.m4964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("full_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("hours");
            GraphQLTimeRangeDeserializer.m6064a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("is_owned");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangleDeserializer.m4995a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnectionDeserializer.m5535a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 23, (short) 0) != (short) 0) {
            jsonGenerator.a("permanently_closed_status");
            jsonGenerator.b(((GraphQLPermanentlyClosedStatus) mutableFlatBuffer.a(i, 23, GraphQLPermanentlyClosedStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("place_topic_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        if (mutableFlatBuffer.a(i, 26, (short) 0) != (short) 0) {
            jsonGenerator.a("place_type");
            jsonGenerator.b(((GraphQLPlaceType) mutableFlatBuffer.a(i, 26, GraphQLPlaceType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 27) != 0) {
            jsonGenerator.a("price_range_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 27));
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("profilePicture74");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 32);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("raters");
            GraphQLPageStarRatersConnectionDeserializer.m5523a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("redirection_info");
            GraphQLRedirectionInfoDeserializer.m5801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("representative_place_photos");
            GraphQLPhotoDeserializer.m5603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("short_category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 37), jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 38);
        if (a) {
            jsonGenerator.a("should_show_reviews_on_profile");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("spotlight_locals_snippets");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 39), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 40, (short) 0) != (short) 0) {
            jsonGenerator.a("super_category_type");
            jsonGenerator.b(((GraphQLPageSuperCategoryType) mutableFlatBuffer.a(i, 40, GraphQLPageSuperCategoryType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 41) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 41));
        }
        if (mutableFlatBuffer.g(i, 42) != 0) {
            jsonGenerator.a("viewer_profile_permissions");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 42), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 43, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 43, GraphQLSavedState.class)).name());
        }
        if (mutableFlatBuffer.g(i, 44) != 0) {
            jsonGenerator.a("websites");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 44), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("viewer_visits");
            GraphQLViewerVisitsConnectionDeserializer.m6204a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("place_open_status");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 47, (short) 0) != (short) 0) {
            jsonGenerator.a("place_open_status_type");
            jsonGenerator.b(((GraphQLPageOpenHoursDisplayDecisionEnum) mutableFlatBuffer.a(i, 47, GraphQLPageOpenHoursDisplayDecisionEnum.class)).name());
        }
        jsonGenerator.g();
    }
}
