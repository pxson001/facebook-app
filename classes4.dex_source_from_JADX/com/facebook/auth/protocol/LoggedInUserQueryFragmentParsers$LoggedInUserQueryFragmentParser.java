package com.facebook.auth.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers$DefaultNameFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers$DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;

/* compiled from: sort_key DESC */
public final class LoggedInUserQueryFragmentParsers$LoggedInUserQueryFragmentParser {

    /* compiled from: sort_key DESC */
    public final class AllPhonesParser {
        public static int m2033b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("is_verified")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("phone_number")) {
                        iArr[1] = PhoneNumberParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static int m2032a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m2033b(jsonParser, flatBufferBuilder)));
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
    }

    /* compiled from: sort_key DESC */
    public final class MessagingGeoParser {
        public static int m2038a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("current_location_prediction")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("home_location_prediction")) {
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
    }

    public static int m2031a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[17];
        boolean[] zArr = new boolean[6];
        boolean[] zArr2 = new boolean[6];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("all_phones")) {
                    iArr[0] = AllPhonesParser.m2032a(jsonParser, flatBufferBuilder);
                } else if (i.equals("email_addresses")) {
                    iArr[1] = DeserializerHelpers.m2034a(jsonParser, flatBufferBuilder);
                } else if (i.equals("gender")) {
                    iArr[2] = flatBufferBuilder.a(GraphQLGender.fromString(jsonParser.o()));
                } else if (i.equals("id")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_deactivated_allowed_on_messenger")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("is_minor")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("is_mobile_pushable")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("is_partial")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("is_work_user")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("messaging_geo")) {
                    iArr[9] = MessagingGeoParser.m2038a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("squareProfilePicBig")) {
                    iArr[12] = CommonGraphQLParsers$DefaultImageFieldsParser.m2039a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicHuge")) {
                    iArr[13] = CommonGraphQLParsers$DefaultImageFieldsParser.m2039a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicSmall")) {
                    iArr[14] = CommonGraphQLParsers$DefaultImageFieldsParser.m2039a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_name")) {
                    iArr[15] = CommonGraphQL2Parsers$DefaultNameFieldsParser.m2043a(jsonParser, flatBufferBuilder);
                } else if (i.equals("username")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(17);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(5, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(6, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(7, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(8, zArr2[4]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[5]) {
            flatBufferBuilder.a(11, zArr2[5]);
        }
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        return flatBufferBuilder.d();
    }
}
