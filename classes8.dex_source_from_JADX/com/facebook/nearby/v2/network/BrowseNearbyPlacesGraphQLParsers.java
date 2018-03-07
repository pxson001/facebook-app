package com.facebook.nearby.v2.network;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLRedirectionReason;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser.ValueParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.StoryParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBTextWithEntitiesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: device_data_ready */
public class BrowseNearbyPlacesGraphQLParsers {

    /* compiled from: device_data_ready */
    public final class BrowseNearbyPlacesFullImageFragmentParser {
        public static int m18324a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[3];
            int[] iArr2 = new int[2];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("height")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("name")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("scale")) {
                        zArr[1] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("uri")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("width")) {
                        zArr[2] = true;
                        iArr2[1] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[1]) {
                flatBufferBuilder.a(2, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[2]) {
                flatBufferBuilder.a(4, iArr2[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m18325a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("height");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            double a2 = mutableFlatBuffer.a(i, 2, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("scale");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class FullAlbumFragmentParser {

        /* compiled from: device_data_ready */
        public final class TitleParser {
            public static int m18326a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("text")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18327a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18328a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[1] = TitleParser.m18326a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class GeoRectangleFragmentParser {
        public static int m18329a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[4];
            double[] dArr = new double[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("east")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("north")) {
                        zArr[1] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("south")) {
                        zArr[2] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("west")) {
                        zArr[3] = true;
                        dArr[3] = jsonParser.G();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            if (zArr[0]) {
                flatBufferBuilder.a(0, dArr[0], 0.0d);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, dArr[1], 0.0d);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, dArr[2], 0.0d);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(3, dArr[3], 0.0d);
            }
            return flatBufferBuilder.d();
        }

        public static void m18330a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            double a = mutableFlatBuffer.a(i, 0, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("east");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("north");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("south");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("west");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPagePlaceInfoFragmentParser {

        /* compiled from: device_data_ready */
        public final class AddressParser {
            public static int m18331a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("city")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("street")) {
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

            public static void m18332a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("city");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("street");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class HoursParser {
            public static int m18336b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                long[] jArr = new long[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("end")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("start")) {
                            zArr[1] = true;
                            jArr[1] = jsonParser.F();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, jArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, jArr[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m18333a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18336b(jsonParser, flatBufferBuilder)));
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

            public static void m18335a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18334a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m18334a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                long a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("end");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("start");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class LocationParser {
            public static int m18337a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("latitude")) {
                            zArr[0] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("longitude")) {
                            zArr[1] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("timezone")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, dArr[0], 0.0d);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m18338a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                double a = mutableFlatBuffer.a(i, 0, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("latitude");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("longitude");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class OverallStarRatingParser {
            public static int m18339a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[3];
                int[] iArr = new int[2];
                double[] dArr = new double[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("rating_count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("scale")) {
                            zArr[1] = true;
                            iArr[1] = jsonParser.E();
                        } else if (i.equals("value")) {
                            zArr[2] = true;
                            dArr[0] = jsonParser.G();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, iArr[1], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(2, dArr[0], 0.0d);
                }
                return flatBufferBuilder.d();
            }

            public static void m18340a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("rating_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("scale");
                    jsonGenerator.b(a);
                }
                double a2 = mutableFlatBuffer.a(i, 2, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("value");
                    jsonGenerator.a(a2);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class PageLikersParser {
            public static int m18341a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m18342a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class PageVisitsParser {
            public static int m18343a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m18344a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class PlaceOpenStatusParser {
            public static int m18345a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("text")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18346a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: device_data_ready */
        public final class RatersParser {
            public static int m18347a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m18348a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m18349a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[30];
            boolean[] zArr = new boolean[7];
            boolean[] zArr2 = new boolean[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = AddressParser.m18331a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_claim")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_rate")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("category_names")) {
                        iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_type")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                    } else if (i.equals("does_viewer_like")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("expressed_as_place")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("hours")) {
                        iArr[7] = HoursParser.m18333a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_owned")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("location")) {
                        iArr[10] = LocationParser.m18337a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("name")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("overall_star_rating")) {
                        iArr[12] = OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_likers")) {
                        iArr[13] = PageLikersParser.m18341a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_visits")) {
                        iArr[14] = PageVisitsParser.m18343a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("permanently_closed_status")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLPermanentlyClosedStatus.fromString(jsonParser.o()));
                    } else if (i.equals("place_open_status")) {
                        iArr[16] = PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_open_status_type")) {
                        iArr[17] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("place_type")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("price_range_description")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profilePicture50")) {
                        iArr[20] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profilePicture74")) {
                        iArr[21] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture_is_silhouette")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("raters")) {
                        iArr[23] = RatersParser.m18347a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("redirection_info")) {
                        iArr[24] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("short_category_names")) {
                        iArr[25] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_show_reviews_on_profile")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("super_category_type")) {
                        iArr[27] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                    } else if (i.equals("viewer_profile_permissions")) {
                        iArr[28] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_saved_state")) {
                        iArr[29] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(30);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, zArr2[1]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(6, zArr2[3]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[4]) {
                flatBufferBuilder.a(9, zArr2[4]);
            }
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
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
            if (zArr[5]) {
                flatBufferBuilder.a(22, zArr2[5]);
            }
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            if (zArr[6]) {
                flatBufferBuilder.a(26, zArr2[6]);
            }
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            return flatBufferBuilder.d();
        }

        public static void m18350a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("address");
                AddressParser.m18332a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_claim");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_viewer_rate");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("category_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("does_viewer_like");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("expressed_as_place");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("hours");
                HoursParser.m18335a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("is_owned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18338a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("overall_star_rating");
                OverallStarRatingParser.m18340a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("page_likers");
                PageLikersParser.m18342a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("page_visits");
                PageVisitsParser.m18344a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("permanently_closed_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("place_open_status");
                PlaceOpenStatusParser.m18346a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("place_open_status_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("price_range_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("profilePicture50");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("profilePicture74");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 22);
            if (a) {
                jsonGenerator.a("profile_picture_is_silhouette");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("raters");
                RatersParser.m18348a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("redirection_info");
                RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 25) != 0) {
                jsonGenerator.a("short_category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 25), jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 26);
            if (a) {
                jsonGenerator.a("should_show_reviews_on_profile");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("super_category_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("viewer_profile_permissions");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 28), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("viewer_saved_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 29));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesFriendsWhoVisitedFragmentParser {

        /* compiled from: device_data_ready */
        public final class FriendsWhoVisitedParser {

            /* compiled from: device_data_ready */
            public final class EdgesParser {

                /* compiled from: device_data_ready */
                public final class NodeParser {
                    public static int m18351a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
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

                    public static void m18352a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18353b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m18351a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m18354b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m18352a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: device_data_ready */
            public final class SocialContextParser {

                /* compiled from: device_data_ready */
                public final class RangesParser {
                    public static int m18356b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        boolean[] zArr = new boolean[2];
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("length")) {
                                    zArr[0] = true;
                                    iArr[0] = jsonParser.E();
                                } else if (i.equals("offset")) {
                                    zArr[1] = true;
                                    iArr[1] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(2);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, iArr[0], 0);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(1, iArr[1], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m18355a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("length");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.a(i, 1, 0);
                        if (a != 0) {
                            jsonGenerator.a("offset");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18357a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("ranges")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(RangesParser.m18356b(jsonParser, flatBufferBuilder)));
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
                            } else if (i.equals("text")) {
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

                public static void m18358a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("ranges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            RangesParser.m18355a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                        }
                        jsonGenerator.e();
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18359a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m18353b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr3 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr3, true);
                            }
                            iArr[1] = i2;
                        } else if (i.equals("social_context")) {
                            iArr[2] = SocialContextParser.m18357a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m18360a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                        EdgesParser.m18354b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("social_context");
                    SocialContextParser.m18358a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18361a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("friends_who_visited")) {
                        iArr[0] = FriendsWhoVisitedParser.m18359a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesHugeResultCellPageInformationFragmentParser {
        public static int m18362a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[35];
            boolean[] zArr = new boolean[7];
            boolean[] zArr2 = new boolean[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = AddressParser.m18331a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_claim")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_rate")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("category_names")) {
                        iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_type")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                    } else if (i.equals("does_viewer_like")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("expressed_as_place")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("friends_who_visited")) {
                        iArr[7] = FriendsWhoVisitedParser.m18359a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hours")) {
                        iArr[8] = HoursParser.m18333a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_owned")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("location")) {
                        iArr[11] = LocationParser.m18337a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("name")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("overall_star_rating")) {
                        iArr[13] = OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_likers")) {
                        iArr[14] = PageLikersParser.m18341a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_visits")) {
                        iArr[15] = PageVisitsParser.m18343a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("permanently_closed_status")) {
                        iArr[16] = flatBufferBuilder.a(GraphQLPermanentlyClosedStatus.fromString(jsonParser.o()));
                    } else if (i.equals("place_open_status")) {
                        iArr[17] = PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_open_status_type")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("place_type")) {
                        iArr[19] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("price_range_description")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profilePicture50")) {
                        iArr[21] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profilePicture74")) {
                        iArr[22] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_photo")) {
                        iArr[23] = ProfilePhotoParser.m18388a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture_is_silhouette")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("raters")) {
                        iArr[25] = RatersParser.m18347a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("recommendationsByViewerFriends")) {
                        iArr[26] = NearbyRecommendationsConnectionFragmentParser.m18395a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("redirection_info")) {
                        iArr[27] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("representative_place_photos")) {
                        iArr[28] = Photo320FragmentParser.m18404a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("short_category_names")) {
                        iArr[29] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_show_reviews_on_profile")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("spotlight_locals_snippets")) {
                        iArr[31] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("super_category_type")) {
                        iArr[32] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                    } else if (i.equals("viewer_profile_permissions")) {
                        iArr[33] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_saved_state")) {
                        iArr[34] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(35);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, zArr2[1]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(6, zArr2[3]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[4]) {
                flatBufferBuilder.a(10, zArr2[4]);
            }
            flatBufferBuilder.b(11, iArr[11]);
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
            if (zArr[5]) {
                flatBufferBuilder.a(24, zArr2[5]);
            }
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            if (zArr[6]) {
                flatBufferBuilder.a(30, zArr2[6]);
            }
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            return flatBufferBuilder.d();
        }

        public static void m18363a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("address");
                AddressParser.m18332a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_claim");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_viewer_rate");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("category_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("does_viewer_like");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("expressed_as_place");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("friends_who_visited");
                FriendsWhoVisitedParser.m18360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("hours");
                HoursParser.m18335a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("is_owned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18338a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("overall_star_rating");
                OverallStarRatingParser.m18340a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("page_likers");
                PageLikersParser.m18342a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("page_visits");
                PageVisitsParser.m18344a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("permanently_closed_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 16));
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("place_open_status");
                PlaceOpenStatusParser.m18346a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("place_open_status_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 19));
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("price_range_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("profilePicture50");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("profilePicture74");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m18389a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 24);
            if (a) {
                jsonGenerator.a("profile_picture_is_silhouette");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("raters");
                RatersParser.m18348a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("recommendationsByViewerFriends");
                NearbyRecommendationsConnectionFragmentParser.m18396a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("redirection_info");
                RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("representative_place_photos");
                Photo320FragmentParser.m18405a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("short_category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 29), jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 30);
            if (a) {
                jsonGenerator.a("should_show_reviews_on_profile");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("spotlight_locals_snippets");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 31), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("super_category_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 32));
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("viewer_profile_permissions");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 33), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("viewer_saved_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 34));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesHugeResultsSearchQueryV2Parser {
        public static MutableFlatBuffer m18364a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("browse_places")) {
                        iArr[0] = NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.m18372a(jsonParser, flatBufferBuilder);
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

    /* compiled from: device_data_ready */
    public final class NearbyPlacesNewBrowsePaginationInfoParser {

        /* compiled from: device_data_ready */
        public final class PageInfoParser {
            public static int m18365a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("end_cursor")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("has_next_page")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                return flatBufferBuilder.d();
            }

            public static void m18366a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("end_cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("has_next_page");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18367a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("page_info")) {
                        iArr[0] = PageInfoParser.m18365a(jsonParser, flatBufferBuilder);
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

    /* compiled from: device_data_ready */
    public final class NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser {

        /* compiled from: device_data_ready */
        public final class EdgesParser {

            /* compiled from: device_data_ready */
            public final class NodeParser {
                public static int m18368a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[35];
                    boolean[] zArr = new boolean[7];
                    boolean[] zArr2 = new boolean[7];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("address")) {
                                iArr[0] = AddressParser.m18331a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("can_viewer_claim")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("can_viewer_rate")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("category_names")) {
                                iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("category_type")) {
                                iArr[4] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                            } else if (i.equals("does_viewer_like")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("expressed_as_place")) {
                                zArr[3] = true;
                                zArr2[3] = jsonParser.H();
                            } else if (i.equals("friends_who_visited")) {
                                iArr[7] = FriendsWhoVisitedParser.m18359a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("hours")) {
                                iArr[8] = HoursParser.m18333a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[9] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("is_owned")) {
                                zArr[4] = true;
                                zArr2[4] = jsonParser.H();
                            } else if (i.equals("location")) {
                                iArr[11] = LocationParser.m18337a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("name")) {
                                iArr[12] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("overall_star_rating")) {
                                iArr[13] = OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_likers")) {
                                iArr[14] = PageLikersParser.m18341a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_visits")) {
                                iArr[15] = PageVisitsParser.m18343a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permanently_closed_status")) {
                                iArr[16] = flatBufferBuilder.a(GraphQLPermanentlyClosedStatus.fromString(jsonParser.o()));
                            } else if (i.equals("place_open_status")) {
                                iArr[17] = PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("place_open_status_type")) {
                                iArr[18] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                            } else if (i.equals("place_type")) {
                                iArr[19] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                            } else if (i.equals("price_range_description")) {
                                iArr[20] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("profilePicture50")) {
                                iArr[21] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profilePicture74")) {
                                iArr[22] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_photo")) {
                                iArr[23] = ProfilePhotoParser.m18388a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_picture_is_silhouette")) {
                                zArr[5] = true;
                                zArr2[5] = jsonParser.H();
                            } else if (i.equals("raters")) {
                                iArr[25] = RatersParser.m18347a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("recommendationsByViewerFriends")) {
                                iArr[26] = NearbyRecommendationsConnectionFragmentParser.m18395a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("redirection_info")) {
                                iArr[27] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("representative_place_photos")) {
                                iArr[28] = Photo320FragmentParser.m18404a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("short_category_names")) {
                                iArr[29] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("should_show_reviews_on_profile")) {
                                zArr[6] = true;
                                zArr2[6] = jsonParser.H();
                            } else if (i.equals("spotlight_locals_snippets")) {
                                iArr[31] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("super_category_type")) {
                                iArr[32] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                            } else if (i.equals("viewer_profile_permissions")) {
                                iArr[33] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("viewer_saved_state")) {
                                iArr[34] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(35);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, zArr2[1]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    if (zArr[2]) {
                        flatBufferBuilder.a(5, zArr2[2]);
                    }
                    if (zArr[3]) {
                        flatBufferBuilder.a(6, zArr2[3]);
                    }
                    flatBufferBuilder.b(7, iArr[7]);
                    flatBufferBuilder.b(8, iArr[8]);
                    flatBufferBuilder.b(9, iArr[9]);
                    if (zArr[4]) {
                        flatBufferBuilder.a(10, zArr2[4]);
                    }
                    flatBufferBuilder.b(11, iArr[11]);
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
                    if (zArr[5]) {
                        flatBufferBuilder.a(24, zArr2[5]);
                    }
                    flatBufferBuilder.b(25, iArr[25]);
                    flatBufferBuilder.b(26, iArr[26]);
                    flatBufferBuilder.b(27, iArr[27]);
                    flatBufferBuilder.b(28, iArr[28]);
                    flatBufferBuilder.b(29, iArr[29]);
                    if (zArr[6]) {
                        flatBufferBuilder.a(30, zArr2[6]);
                    }
                    flatBufferBuilder.b(31, iArr[31]);
                    flatBufferBuilder.b(32, iArr[32]);
                    flatBufferBuilder.b(33, iArr[33]);
                    flatBufferBuilder.b(34, iArr[34]);
                    return flatBufferBuilder.d();
                }

                public static void m18369a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("address");
                        AddressParser.m18332a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    boolean a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("can_viewer_claim");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("can_viewer_rate");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("category_names");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("category_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                    }
                    a = mutableFlatBuffer.a(i, 5);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 6);
                    if (a) {
                        jsonGenerator.a("expressed_as_place");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("friends_who_visited");
                        FriendsWhoVisitedParser.m18360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("hours");
                        HoursParser.m18335a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 9) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                    }
                    a = mutableFlatBuffer.a(i, 10);
                    if (a) {
                        jsonGenerator.a("is_owned");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 11);
                    if (g != 0) {
                        jsonGenerator.a("location");
                        LocationParser.m18338a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 12) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                    }
                    g = mutableFlatBuffer.g(i, 13);
                    if (g != 0) {
                        jsonGenerator.a("overall_star_rating");
                        OverallStarRatingParser.m18340a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 14);
                    if (g != 0) {
                        jsonGenerator.a("page_likers");
                        PageLikersParser.m18342a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 15);
                    if (g != 0) {
                        jsonGenerator.a("page_visits");
                        PageVisitsParser.m18344a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 16) != 0) {
                        jsonGenerator.a("permanently_closed_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 16));
                    }
                    g = mutableFlatBuffer.g(i, 17);
                    if (g != 0) {
                        jsonGenerator.a("place_open_status");
                        PlaceOpenStatusParser.m18346a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 18) != 0) {
                        jsonGenerator.a("place_open_status_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                    }
                    if (mutableFlatBuffer.g(i, 19) != 0) {
                        jsonGenerator.a("place_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                    }
                    if (mutableFlatBuffer.g(i, 20) != 0) {
                        jsonGenerator.a("price_range_description");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 20));
                    }
                    g = mutableFlatBuffer.g(i, 21);
                    if (g != 0) {
                        jsonGenerator.a("profilePicture50");
                        BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 22);
                    if (g != 0) {
                        jsonGenerator.a("profilePicture74");
                        BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 23);
                    if (g != 0) {
                        jsonGenerator.a("profile_photo");
                        ProfilePhotoParser.m18389a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 24);
                    if (a) {
                        jsonGenerator.a("profile_picture_is_silhouette");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 25);
                    if (g != 0) {
                        jsonGenerator.a("raters");
                        RatersParser.m18348a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 26);
                    if (g != 0) {
                        jsonGenerator.a("recommendationsByViewerFriends");
                        NearbyRecommendationsConnectionFragmentParser.m18396a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 27);
                    if (g != 0) {
                        jsonGenerator.a("redirection_info");
                        RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 28);
                    if (g != 0) {
                        jsonGenerator.a("representative_place_photos");
                        Photo320FragmentParser.m18405a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 29) != 0) {
                        jsonGenerator.a("short_category_names");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 29), jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 30);
                    if (a) {
                        jsonGenerator.a("should_show_reviews_on_profile");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 31) != 0) {
                        jsonGenerator.a("spotlight_locals_snippets");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 31), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 32) != 0) {
                        jsonGenerator.a("super_category_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 32));
                    }
                    if (mutableFlatBuffer.g(i, 33) != 0) {
                        jsonGenerator.a("viewer_profile_permissions");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 33), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 34) != 0) {
                        jsonGenerator.a("viewer_saved_state");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 34));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18370b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = NodeParser.m18368a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18371b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m18369a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m18372a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("display_region_hint")) {
                        iArr[0] = GeoRectangleFragmentParser.m18329a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(EdgesParser.m18370b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[1] = i2;
                    } else if (i.equals("page_info")) {
                        iArr[2] = PageInfoParser.m18365a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tracking")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static void m18373a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("display_region_hint");
                GeoRectangleFragmentParser.m18330a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    EdgesParser.m18371b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("page_info");
                PageInfoParser.m18366a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesOldBrowseOldResultConnectionFragmentParser {

        /* compiled from: device_data_ready */
        public final class EdgesParser {

            /* compiled from: device_data_ready */
            public final class NodeParser {
                public static int m18374a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[31];
                    boolean[] zArr = new boolean[7];
                    boolean[] zArr2 = new boolean[7];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("address")) {
                                iArr[0] = AddressParser.m18331a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("can_viewer_claim")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("can_viewer_rate")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("category_names")) {
                                iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("category_type")) {
                                iArr[4] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                            } else if (i.equals("does_viewer_like")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("expressed_as_place")) {
                                zArr[3] = true;
                                zArr2[3] = jsonParser.H();
                            } else if (i.equals("friends_who_visited")) {
                                iArr[7] = FriendsWhoVisitedParser.m18385a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("hours")) {
                                iArr[8] = HoursParser.m18333a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[9] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("is_owned")) {
                                zArr[4] = true;
                                zArr2[4] = jsonParser.H();
                            } else if (i.equals("location")) {
                                iArr[11] = LocationParser.m18337a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("name")) {
                                iArr[12] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("overall_star_rating")) {
                                iArr[13] = OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_likers")) {
                                iArr[14] = PageLikersParser.m18341a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_visits")) {
                                iArr[15] = PageVisitsParser.m18343a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permanently_closed_status")) {
                                iArr[16] = flatBufferBuilder.a(GraphQLPermanentlyClosedStatus.fromString(jsonParser.o()));
                            } else if (i.equals("place_open_status")) {
                                iArr[17] = PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("place_open_status_type")) {
                                iArr[18] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                            } else if (i.equals("place_type")) {
                                iArr[19] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                            } else if (i.equals("price_range_description")) {
                                iArr[20] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("profilePicture50")) {
                                iArr[21] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profilePicture74")) {
                                iArr[22] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_picture_is_silhouette")) {
                                zArr[5] = true;
                                zArr2[5] = jsonParser.H();
                            } else if (i.equals("raters")) {
                                iArr[24] = RatersParser.m18347a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("redirection_info")) {
                                iArr[25] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("short_category_names")) {
                                iArr[26] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("should_show_reviews_on_profile")) {
                                zArr[6] = true;
                                zArr2[6] = jsonParser.H();
                            } else if (i.equals("super_category_type")) {
                                iArr[28] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                            } else if (i.equals("viewer_profile_permissions")) {
                                iArr[29] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("viewer_saved_state")) {
                                iArr[30] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(31);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, zArr2[1]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    if (zArr[2]) {
                        flatBufferBuilder.a(5, zArr2[2]);
                    }
                    if (zArr[3]) {
                        flatBufferBuilder.a(6, zArr2[3]);
                    }
                    flatBufferBuilder.b(7, iArr[7]);
                    flatBufferBuilder.b(8, iArr[8]);
                    flatBufferBuilder.b(9, iArr[9]);
                    if (zArr[4]) {
                        flatBufferBuilder.a(10, zArr2[4]);
                    }
                    flatBufferBuilder.b(11, iArr[11]);
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
                    if (zArr[5]) {
                        flatBufferBuilder.a(23, zArr2[5]);
                    }
                    flatBufferBuilder.b(24, iArr[24]);
                    flatBufferBuilder.b(25, iArr[25]);
                    flatBufferBuilder.b(26, iArr[26]);
                    if (zArr[6]) {
                        flatBufferBuilder.a(27, zArr2[6]);
                    }
                    flatBufferBuilder.b(28, iArr[28]);
                    flatBufferBuilder.b(29, iArr[29]);
                    flatBufferBuilder.b(30, iArr[30]);
                    return flatBufferBuilder.d();
                }

                public static void m18375a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("address");
                        AddressParser.m18332a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    boolean a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("can_viewer_claim");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("can_viewer_rate");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("category_names");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("category_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                    }
                    a = mutableFlatBuffer.a(i, 5);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 6);
                    if (a) {
                        jsonGenerator.a("expressed_as_place");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("friends_who_visited");
                        FriendsWhoVisitedParser.m18386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("hours");
                        HoursParser.m18335a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 9) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                    }
                    a = mutableFlatBuffer.a(i, 10);
                    if (a) {
                        jsonGenerator.a("is_owned");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 11);
                    if (g != 0) {
                        jsonGenerator.a("location");
                        LocationParser.m18338a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 12) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                    }
                    g = mutableFlatBuffer.g(i, 13);
                    if (g != 0) {
                        jsonGenerator.a("overall_star_rating");
                        OverallStarRatingParser.m18340a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 14);
                    if (g != 0) {
                        jsonGenerator.a("page_likers");
                        PageLikersParser.m18342a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 15);
                    if (g != 0) {
                        jsonGenerator.a("page_visits");
                        PageVisitsParser.m18344a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 16) != 0) {
                        jsonGenerator.a("permanently_closed_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 16));
                    }
                    g = mutableFlatBuffer.g(i, 17);
                    if (g != 0) {
                        jsonGenerator.a("place_open_status");
                        PlaceOpenStatusParser.m18346a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 18) != 0) {
                        jsonGenerator.a("place_open_status_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                    }
                    if (mutableFlatBuffer.g(i, 19) != 0) {
                        jsonGenerator.a("place_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                    }
                    if (mutableFlatBuffer.g(i, 20) != 0) {
                        jsonGenerator.a("price_range_description");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 20));
                    }
                    g = mutableFlatBuffer.g(i, 21);
                    if (g != 0) {
                        jsonGenerator.a("profilePicture50");
                        BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 22);
                    if (g != 0) {
                        jsonGenerator.a("profilePicture74");
                        BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 23);
                    if (a) {
                        jsonGenerator.a("profile_picture_is_silhouette");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 24);
                    if (g != 0) {
                        jsonGenerator.a("raters");
                        RatersParser.m18348a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 25);
                    if (g != 0) {
                        jsonGenerator.a("redirection_info");
                        RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 26) != 0) {
                        jsonGenerator.a("short_category_names");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 26), jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 27);
                    if (a) {
                        jsonGenerator.a("should_show_reviews_on_profile");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 28) != 0) {
                        jsonGenerator.a("super_category_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 28));
                    }
                    if (mutableFlatBuffer.g(i, 29) != 0) {
                        jsonGenerator.a("viewer_profile_permissions");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 29), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 30) != 0) {
                        jsonGenerator.a("viewer_saved_state");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 30));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18376b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = NodeParser.m18374a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18377b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m18375a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m18378a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("cache_radius")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("display_region_hint")) {
                        iArr[1] = GeoRectangleFragmentParser.m18329a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(EdgesParser.m18376b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr3 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr3, true);
                        }
                        iArr[2] = i2;
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m18379a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("cache_radius");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 1);
            if (a != 0) {
                jsonGenerator.a("display_region_hint");
                GeoRectangleFragmentParser.m18330a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 2);
            if (a != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    EdgesParser.m18377b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesOldBrowseOldResultsSearchQueryParser {
        public static MutableFlatBuffer m18380a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("places")) {
                        iArr[0] = NearbyPlacesOldBrowseOldResultConnectionFragmentParser.m18378a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("search_session_key")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser {

        /* compiled from: device_data_ready */
        public final class FriendsWhoVisitedParser {

            /* compiled from: device_data_ready */
            public final class EdgesParser {

                /* compiled from: device_data_ready */
                public final class NodeParser {
                    public static int m18381a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[4];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("profilePicture32")) {
                                    iArr[2] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profilePicture50")) {
                                    iArr[3] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        flatBufferBuilder.b(2, iArr[2]);
                        flatBufferBuilder.b(3, iArr[3]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18382a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        int g = mutableFlatBuffer.g(i, 2);
                        if (g != 0) {
                            jsonGenerator.a("profilePicture32");
                            BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 3);
                        if (g != 0) {
                            jsonGenerator.a("profilePicture50");
                            BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18383b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m18381a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m18384b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m18382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18385a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m18383b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr3 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr3, true);
                            }
                            iArr[1] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m18386a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                        EdgesParser.m18384b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18387a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("friends_who_visited")) {
                        iArr[0] = FriendsWhoVisitedParser.m18385a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyPlacesPageProfilePhotoParser {

        /* compiled from: device_data_ready */
        public final class ProfilePhotoParser {
            public static int m18388a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18389a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18390a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile_photo")) {
                        iArr[1] = ProfilePhotoParser.m18388a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class NearbyRecommendationsConnectionFragmentParser {

        /* compiled from: device_data_ready */
        public final class EdgesParser {

            /* compiled from: device_data_ready */
            public final class NodeParser {
                public static int m18391a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[7];
                    boolean[] zArr = new boolean[2];
                    int[] iArr2 = new int[1];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("creation_time")) {
                                zArr[0] = true;
                                jArr[0] = jsonParser.F();
                            } else if (i.equals("creator")) {
                                iArr[1] = CreatorParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("page_rating")) {
                                zArr[1] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("privacy_scope")) {
                                iArr[4] = SelectedPrivacyOptionFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("story")) {
                                iArr[5] = StoryParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("value")) {
                                iArr[6] = ValueParser.a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(7);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, jArr[0], 0);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    if (zArr[1]) {
                        flatBufferBuilder.a(3, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    return flatBufferBuilder.d();
                }

                public static void m18392a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    long a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("creation_time");
                        jsonGenerator.a(a);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("creator");
                        CreatorParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    g = mutableFlatBuffer.a(i, 3, 0);
                    if (g != 0) {
                        jsonGenerator.a("page_rating");
                        jsonGenerator.b(g);
                    }
                    g = mutableFlatBuffer.g(i, 4);
                    if (g != 0) {
                        jsonGenerator.a("privacy_scope");
                        SelectedPrivacyOptionFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 5);
                    if (g != 0) {
                        jsonGenerator.a("story");
                        StoryParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("value");
                        ValueParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18393b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = NodeParser.m18391a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18394b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m18392a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m18395a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("count")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(EdgesParser.m18393b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr3 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr3, true);
                        }
                        iArr[1] = i2;
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static void m18396a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("count");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 1);
            if (a != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    EdgesParser.m18394b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class PageTWEFragmentParser {

        /* compiled from: device_data_ready */
        public final class RedirectionInfoParser {

            /* compiled from: device_data_ready */
            public final class NodeParser {
                public static int m18397a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("id")) {
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

                public static void m18398a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18401b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = NodeParser.m18397a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("reason")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLRedirectionReason.fromString(jsonParser.o()));
                        } else if (i.equals("url")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static int m18399a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18401b(jsonParser, flatBufferBuilder)));
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

            public static void m18400a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18402b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18402b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m18398a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("reason");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18403a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("redirection_info")) {
                        iArr[1] = RedirectionInfoParser.m18399a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: device_data_ready */
    public final class Photo320FragmentParser {
        public static int m18406b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[4];
            boolean[] zArr2 = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("album")) {
                        iArr[0] = AlbumParser.m18408a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_add_tags")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[1] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("focus")) {
                        iArr[3] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[5] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image320")) {
                        iArr[6] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_disturbing")) {
                        zArr[2] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("message")) {
                        iArr[8] = FBTextWithEntitiesParser.m6469a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("modified_time")) {
                        zArr[3] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, jArr[0], 0);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[2]) {
                flatBufferBuilder.a(7, zArr2[1]);
            }
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[3]) {
                flatBufferBuilder.a(9, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m18404a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m18406b(jsonParser, flatBufferBuilder)));
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

        public static void m18405a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m18407b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m18407b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_add_tags");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 2, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("image");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("image320");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("is_disturbing");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("message");
                FBTextWithEntitiesParser.m6470a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 9, 0);
            if (a2 != 0) {
                jsonGenerator.a("modified_time");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: device_data_ready */
    public final class PhotoWithoutSizedImagesFragmentParser {

        /* compiled from: device_data_ready */
        public final class AlbumParser {
            public static int m18408a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[1] = TitleParser.m18326a(jsonParser, flatBufferBuilder);
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

            public static void m18409a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m18327a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m18410a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[4];
            boolean[] zArr2 = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("album")) {
                        iArr[0] = AlbumParser.m18408a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_add_tags")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[1] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[4] = BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_disturbing")) {
                        zArr[2] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("message")) {
                        iArr[6] = FBTextWithEntitiesParser.m6469a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("modified_time")) {
                        zArr[3] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, jArr[0], 0);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[3]) {
                flatBufferBuilder.a(7, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m18411a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_add_tags");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 2, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("image");
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("is_disturbing");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("message");
                FBTextWithEntitiesParser.m6470a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 7, 0);
            if (a2 != 0) {
                jsonGenerator.a("modified_time");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }
}
