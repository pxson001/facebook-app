package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLParsers.CoverPhotoParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: recent_unread */
public final class ContactGraphQLParsers$ContactParser {

    /* compiled from: recent_unread */
    public final class NameEntriesParser {

        /* compiled from: recent_unread */
        public final class PrimaryFieldParser {

            /* compiled from: recent_unread */
            public final class ValueParser {
                public static int m3990a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m3991a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m3988a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("value")) {
                            iArr[1] = ValueParser.m3990a(jsonParser, flatBufferBuilder);
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

            public static void m3989a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.m4183b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("value");
                    ValueParser.m3991a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m3986b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("primary_field")) {
                        iArr[0] = PrimaryFieldParser.m3988a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static int m3985a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m3986b(jsonParser, flatBufferBuilder)));
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

        public static void m3987b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("primary_field");
                PrimaryFieldParser.m3989a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: recent_unread */
    public final class RepresentedProfileParser {

        /* compiled from: recent_unread */
        public final class BirthdateParser {
            public static int m3994a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("day")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("month")) {
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

            public static void m3995a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("day");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("month");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m3992a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[20];
            boolean[] zArr = new boolean[11];
            boolean[] zArr2 = new boolean[7];
            long[] jArr = new long[1];
            double[] dArr = new double[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("birthdate")) {
                        iArr[1] = BirthdateParser.m3994a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_see_viewer_montage_thread")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_message")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("communicationRank")) {
                        zArr[2] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("cover_photo")) {
                        iArr[5] = CoverPhotoParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("current_city")) {
                        iArr[6] = CurrentCityParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friendship_status")) {
                        iArr[7] = flatBufferBuilder.a(GraphQLFriendshipStatus.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_memorialized")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_message_blocked_by_viewer")) {
                        zArr[4] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_messenger_user")) {
                        zArr[5] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("is_mobile_pushable")) {
                        zArr[6] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_partial")) {
                        zArr[7] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("messenger_install_time")) {
                        zArr[8] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("messenger_invite_priority")) {
                        zArr[9] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("montage_thread_fbid")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name_search_tokens")) {
                        iArr[17] = DeserializerHelpers.m2034a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subscribe_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLSubscribeStatus.fromString(jsonParser.o()));
                    } else if (i.equals("withTaggingRank")) {
                        zArr[10] = true;
                        dArr[2] = jsonParser.G();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(20);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(3, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(4, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[3]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(10, zArr2[3]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(11, zArr2[4]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(12, zArr2[5]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(13, zArr2[6]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(14, jArr[0], 0);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(15, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            if (zArr[10]) {
                flatBufferBuilder.a(19, dArr[2], 0.0d);
            }
            return flatBufferBuilder.d();
        }

        public static void m3993a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.m4183b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("birthdate");
                BirthdateParser.m3995a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_see_viewer_montage_thread");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("can_viewer_message");
                jsonGenerator.a(a);
            }
            double a2 = mutableFlatBuffer.a(i, 4, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("communicationRank");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                CoverPhotoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("current_city");
                CurrentCityParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("friendship_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("is_memorialized");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("is_message_blocked_by_viewer");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_messenger_user");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("is_mobile_pushable");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 13);
            if (a) {
                jsonGenerator.a("is_partial");
                jsonGenerator.a(a);
            }
            long a3 = mutableFlatBuffer.a(i, 14, 0);
            if (a3 != 0) {
                jsonGenerator.a("messenger_install_time");
                jsonGenerator.a(a3);
            }
            a2 = mutableFlatBuffer.a(i, 15, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("messenger_invite_priority");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("montage_thread_fbid");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("name_search_tokens");
                SerializerHelpers.m4182a(mutableFlatBuffer.f(i, 17), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("subscribe_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            a2 = mutableFlatBuffer.a(i, 19, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("withTaggingRank");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }

    public static int m3979a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[12];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("added_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("bigPictureUrl")) {
                    iArr[1] = ContactGraphQLParsers$SquareImageParser.m3983a(jsonParser, flatBufferBuilder);
                } else if (i.equals("graph_api_write_id")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hugePictureUrl")) {
                    iArr[3] = ContactGraphQLParsers$SquareImageParser.m3983a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imported_phone_entries")) {
                    iArr[5] = ImportedPhoneEntriesParser.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_on_viewer_contact_list")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("name_entries")) {
                    iArr[7] = NameEntriesParser.m3985a(jsonParser, flatBufferBuilder);
                } else if (i.equals("phonetic_name")) {
                    iArr[8] = ContactGraphQLParsers$ContactNameParser.m3996a(jsonParser, flatBufferBuilder);
                } else if (i.equals("represented_profile")) {
                    iArr[9] = RepresentedProfileParser.m3992a(jsonParser, flatBufferBuilder);
                } else if (i.equals("smallPictureUrl")) {
                    iArr[10] = ContactGraphQLParsers$SquareImageParser.m3983a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_name")) {
                    iArr[11] = ContactGraphQLParsers$ContactNameParser.m3996a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(12);
        if (zArr[0]) {
            flatBufferBuilder.a(0, jArr[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, zArr2[0]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        return flatBufferBuilder.d();
    }

    public static int m3981b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m3979a(jsonParser, flatBufferBuilder)));
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

    public static void m3980a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m3982b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m3982b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int i2;
        jsonGenerator.f();
        long a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("added_time");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("bigPictureUrl");
            ContactGraphQLParsers$SquareImageParser.m3984a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("graph_api_write_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("hugePictureUrl");
            ContactGraphQLParsers$SquareImageParser.m3984a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("imported_phone_entries");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                ImportedPhoneEntriesParser.b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        boolean a2 = mutableFlatBuffer.a(i, 6);
        if (a2) {
            jsonGenerator.a("is_on_viewer_contact_list");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("name_entries");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                NameEntriesParser.m3987b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("phonetic_name");
            ContactGraphQLParsers$ContactNameParser.m3997a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("represented_profile");
            RepresentedProfileParser.m3993a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("smallPictureUrl");
            ContactGraphQLParsers$SquareImageParser.m3984a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            ContactGraphQLParsers$ContactNameParser.m3997a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
