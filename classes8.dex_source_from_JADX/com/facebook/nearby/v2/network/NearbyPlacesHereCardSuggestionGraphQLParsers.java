package com.facebook.nearby.v2.network;

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
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.BrowseNearbyPlacesFullImageFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.AddressParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.HoursParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.LocationParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.OverallStarRatingParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PageLikersParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PageVisitsParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PlaceOpenStatusParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.RatersParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesPageProfilePhotoParser.ProfilePhotoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyRecommendationsConnectionFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.PageTWEFragmentParser.RedirectionInfoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.Photo320FragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: destination_entity_id */
public class NearbyPlacesHereCardSuggestionGraphQLParsers {

    /* compiled from: destination_entity_id */
    public final class FBNearbyPlacesHereCardHugeResultCellQueryParser {

        /* compiled from: destination_entity_id */
        public final class SuggestionsParser {

            /* compiled from: destination_entity_id */
            public final class EdgesParser {

                /* compiled from: destination_entity_id */
                public final class NodeParser {
                    public static int m18488a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[36];
                        boolean[] zArr = new boolean[7];
                        boolean[] zArr2 = new boolean[7];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("address")) {
                                    iArr[1] = AddressParser.m18331a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("can_viewer_claim")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("can_viewer_rate")) {
                                    zArr[1] = true;
                                    zArr2[1] = jsonParser.H();
                                } else if (i.equals("category_names")) {
                                    iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("category_type")) {
                                    iArr[5] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                                } else if (i.equals("does_viewer_like")) {
                                    zArr[2] = true;
                                    zArr2[2] = jsonParser.H();
                                } else if (i.equals("expressed_as_place")) {
                                    zArr[3] = true;
                                    zArr2[3] = jsonParser.H();
                                } else if (i.equals("friends_who_visited")) {
                                    iArr[8] = FriendsWhoVisitedParser.m18359a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("hours")) {
                                    iArr[9] = HoursParser.m18333a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
                                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("is_owned")) {
                                    zArr[4] = true;
                                    zArr2[4] = jsonParser.H();
                                } else if (i.equals("location")) {
                                    iArr[12] = LocationParser.m18337a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("name")) {
                                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("overall_star_rating")) {
                                    iArr[14] = OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("page_likers")) {
                                    iArr[15] = PageLikersParser.m18341a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("page_visits")) {
                                    iArr[16] = PageVisitsParser.m18343a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("permanently_closed_status")) {
                                    iArr[17] = flatBufferBuilder.a(GraphQLPermanentlyClosedStatus.fromString(jsonParser.o()));
                                } else if (i.equals("place_open_status")) {
                                    iArr[18] = PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("place_open_status_type")) {
                                    iArr[19] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                                } else if (i.equals("place_type")) {
                                    iArr[20] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                                } else if (i.equals("price_range_description")) {
                                    iArr[21] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("profilePicture50")) {
                                    iArr[22] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profilePicture74")) {
                                    iArr[23] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profile_photo")) {
                                    iArr[24] = ProfilePhotoParser.m18388a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profile_picture_is_silhouette")) {
                                    zArr[5] = true;
                                    zArr2[5] = jsonParser.H();
                                } else if (i.equals("raters")) {
                                    iArr[26] = RatersParser.m18347a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("recommendationsByViewerFriends")) {
                                    iArr[27] = NearbyRecommendationsConnectionFragmentParser.m18395a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("redirection_info")) {
                                    iArr[28] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("representative_place_photos")) {
                                    iArr[29] = Photo320FragmentParser.m18404a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("short_category_names")) {
                                    iArr[30] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("should_show_reviews_on_profile")) {
                                    zArr[6] = true;
                                    zArr2[6] = jsonParser.H();
                                } else if (i.equals("spotlight_locals_snippets")) {
                                    iArr[32] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("super_category_type")) {
                                    iArr[33] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                                } else if (i.equals("viewer_profile_permissions")) {
                                    iArr[34] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("viewer_saved_state")) {
                                    iArr[35] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(36);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(2, zArr2[0]);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(3, zArr2[1]);
                        }
                        flatBufferBuilder.b(4, iArr[4]);
                        flatBufferBuilder.b(5, iArr[5]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(6, zArr2[2]);
                        }
                        if (zArr[3]) {
                            flatBufferBuilder.a(7, zArr2[3]);
                        }
                        flatBufferBuilder.b(8, iArr[8]);
                        flatBufferBuilder.b(9, iArr[9]);
                        flatBufferBuilder.b(10, iArr[10]);
                        if (zArr[4]) {
                            flatBufferBuilder.a(11, zArr2[4]);
                        }
                        flatBufferBuilder.b(12, iArr[12]);
                        flatBufferBuilder.b(13, iArr[13]);
                        flatBufferBuilder.b(14, iArr[14]);
                        flatBufferBuilder.b(15, iArr[15]);
                        flatBufferBuilder.b(16, iArr[16]);
                        flatBufferBuilder.b(17, iArr[17]);
                        flatBufferBuilder.b(18, iArr[18]);
                        flatBufferBuilder.b(19, iArr[19]);
                        flatBufferBuilder.b(20, iArr[20]);
                        flatBufferBuilder.b(21, iArr[21]);
                        flatBufferBuilder.b(22, iArr[22]);
                        flatBufferBuilder.b(23, iArr[23]);
                        flatBufferBuilder.b(24, iArr[24]);
                        if (zArr[5]) {
                            flatBufferBuilder.a(25, zArr2[5]);
                        }
                        flatBufferBuilder.b(26, iArr[26]);
                        flatBufferBuilder.b(27, iArr[27]);
                        flatBufferBuilder.b(28, iArr[28]);
                        flatBufferBuilder.b(29, iArr[29]);
                        flatBufferBuilder.b(30, iArr[30]);
                        if (zArr[6]) {
                            flatBufferBuilder.a(31, zArr2[6]);
                        }
                        flatBufferBuilder.b(32, iArr[32]);
                        flatBufferBuilder.b(33, iArr[33]);
                        flatBufferBuilder.b(34, iArr[34]);
                        flatBufferBuilder.b(35, iArr[35]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18489a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("address");
                            AddressParser.m18332a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        boolean a = mutableFlatBuffer.a(i, 2);
                        if (a) {
                            jsonGenerator.a("can_viewer_claim");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 3);
                        if (a) {
                            jsonGenerator.a("can_viewer_rate");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("category_names");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 5) != 0) {
                            jsonGenerator.a("category_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                        }
                        a = mutableFlatBuffer.a(i, 6);
                        if (a) {
                            jsonGenerator.a("does_viewer_like");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 7);
                        if (a) {
                            jsonGenerator.a("expressed_as_place");
                            jsonGenerator.a(a);
                        }
                        g = mutableFlatBuffer.g(i, 8);
                        if (g != 0) {
                            jsonGenerator.a("friends_who_visited");
                            FriendsWhoVisitedParser.m18360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 9);
                        if (g != 0) {
                            jsonGenerator.a("hours");
                            HoursParser.m18335a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 10) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                        }
                        a = mutableFlatBuffer.a(i, 11);
                        if (a) {
                            jsonGenerator.a("is_owned");
                            jsonGenerator.a(a);
                        }
                        g = mutableFlatBuffer.g(i, 12);
                        if (g != 0) {
                            jsonGenerator.a("location");
                            LocationParser.m18338a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 13) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                        }
                        g = mutableFlatBuffer.g(i, 14);
                        if (g != 0) {
                            jsonGenerator.a("overall_star_rating");
                            OverallStarRatingParser.m18340a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 15);
                        if (g != 0) {
                            jsonGenerator.a("page_likers");
                            PageLikersParser.m18342a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 16);
                        if (g != 0) {
                            jsonGenerator.a("page_visits");
                            PageVisitsParser.m18344a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 17) != 0) {
                            jsonGenerator.a("permanently_closed_status");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 17));
                        }
                        g = mutableFlatBuffer.g(i, 18);
                        if (g != 0) {
                            jsonGenerator.a("place_open_status");
                            PlaceOpenStatusParser.m18346a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 19) != 0) {
                            jsonGenerator.a("place_open_status_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                        }
                        if (mutableFlatBuffer.g(i, 20) != 0) {
                            jsonGenerator.a("place_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 20));
                        }
                        if (mutableFlatBuffer.g(i, 21) != 0) {
                            jsonGenerator.a("price_range_description");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                        }
                        g = mutableFlatBuffer.g(i, 22);
                        if (g != 0) {
                            jsonGenerator.a("profilePicture50");
                            BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 23);
                        if (g != 0) {
                            jsonGenerator.a("profilePicture74");
                            BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 24);
                        if (g != 0) {
                            jsonGenerator.a("profile_photo");
                            ProfilePhotoParser.m18389a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        a = mutableFlatBuffer.a(i, 25);
                        if (a) {
                            jsonGenerator.a("profile_picture_is_silhouette");
                            jsonGenerator.a(a);
                        }
                        g = mutableFlatBuffer.g(i, 26);
                        if (g != 0) {
                            jsonGenerator.a("raters");
                            RatersParser.m18348a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 27);
                        if (g != 0) {
                            jsonGenerator.a("recommendationsByViewerFriends");
                            NearbyRecommendationsConnectionFragmentParser.m18396a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 28);
                        if (g != 0) {
                            jsonGenerator.a("redirection_info");
                            RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 29);
                        if (g != 0) {
                            jsonGenerator.a("representative_place_photos");
                            Photo320FragmentParser.m18405a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 30) != 0) {
                            jsonGenerator.a("short_category_names");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 30), jsonGenerator);
                        }
                        a = mutableFlatBuffer.a(i, 31);
                        if (a) {
                            jsonGenerator.a("should_show_reviews_on_profile");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 32) != 0) {
                            jsonGenerator.a("spotlight_locals_snippets");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 32), jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 33) != 0) {
                            jsonGenerator.a("super_category_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 33));
                        }
                        if (mutableFlatBuffer.g(i, 34) != 0) {
                            jsonGenerator.a("viewer_profile_permissions");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 34), jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 35) != 0) {
                            jsonGenerator.a("viewer_saved_state");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 35));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18490b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m18488a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("response_id")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    return flatBufferBuilder.d();
                }

                public static void m18491b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m18489a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("response_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18492a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m18490b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18493a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m18491b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18494a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("suggestions")) {
                        iArr[0] = SuggestionsParser.m18492a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
