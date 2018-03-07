package com.facebook.messaging.business.nativesignup.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mypid */
public class NativeSignUpQueryParsers {

    /* compiled from: mypid */
    public final class NativeSignUpNewUserSignUpQueryParser {

        /* compiled from: mypid */
        public final class MessengerCommerceParser {

            /* compiled from: mypid */
            public final class NewUserSignupParser {

                /* compiled from: mypid */
                public final class PermissionsAvatarParser {
                    public static int m9130a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("uri")) {
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

                    public static void m9131a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: mypid */
                public final class ServiceIntroImageParser {
                    public static int m9132a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        boolean[] zArr = new boolean[2];
                        int[] iArr2 = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("height")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("uri")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("width")) {
                                    zArr[1] = true;
                                    iArr2[1] = jsonParser.E();
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
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, iArr2[1], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m9133a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("height");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0);
                        if (a != 0) {
                            jsonGenerator.a("width");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: mypid */
                public final class ServiceIntroLogoParser {
                    public static int m9134a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("uri")) {
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

                    public static void m9135a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m9136a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[29];
                    boolean[] zArr = new boolean[1];
                    boolean[] zArr2 = new boolean[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("existing_account_callback")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("existing_account_label")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("non_existing_account_label")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("optional_payment_enabled")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("permissions_avatar")) {
                                iArr[4] = PermissionsAvatarParser.m9130a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permissions_email_header")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("permissions_email_text")) {
                                iArr[6] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permissions_friends_header")) {
                                iArr[7] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("permissions_friends_text")) {
                                iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permissions_header")) {
                                iArr[9] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("permissions_payment_info_text")) {
                                iArr[10] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("permissions_public_profile_header")) {
                                iArr[11] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("permissions_public_profile_text")) {
                                iArr[12] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("privacy_policy_uri")) {
                                iArr[13] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("proxy_login_permissions_list")) {
                                iArr[14] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("proxy_login_relative_path")) {
                                iArr[15] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_app_package_name")) {
                                iArr[16] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_authorization_url")) {
                                iArr[17] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_fb_app_id")) {
                                iArr[18] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_intro_header")) {
                                iArr[19] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_intro_image")) {
                                iArr[20] = ServiceIntroImageParser.m9132a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("service_intro_logo")) {
                                iArr[21] = ServiceIntroLogoParser.m9134a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("service_intro_message")) {
                                iArr[22] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_intro_warning_message")) {
                                iArr[23] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_provider_name")) {
                                iArr[24] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("service_redirect_url")) {
                                iArr[25] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("terms_uri")) {
                                iArr[26] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("third_party_registration_relative_path")) {
                                iArr[27] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("verified_phone_number")) {
                                iArr[28] = PhoneNumberInfoParser.m9141a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(29);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(3, zArr2[0]);
                    }
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    flatBufferBuilder.b(7, iArr[7]);
                    flatBufferBuilder.b(8, iArr[8]);
                    flatBufferBuilder.b(9, iArr[9]);
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
                    flatBufferBuilder.b(22, iArr[22]);
                    flatBufferBuilder.b(23, iArr[23]);
                    flatBufferBuilder.b(24, iArr[24]);
                    flatBufferBuilder.b(25, iArr[25]);
                    flatBufferBuilder.b(26, iArr[26]);
                    flatBufferBuilder.b(27, iArr[27]);
                    flatBufferBuilder.b(28, iArr[28]);
                    return flatBufferBuilder.d();
                }

                public static void m9137a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("existing_account_callback");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("existing_account_label");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("non_existing_account_label");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    boolean a = mutableFlatBuffer.a(i, 3);
                    if (a) {
                        jsonGenerator.a("optional_payment_enabled");
                        jsonGenerator.a(a);
                    }
                    int g = mutableFlatBuffer.g(i, 4);
                    if (g != 0) {
                        jsonGenerator.a("permissions_avatar");
                        PermissionsAvatarParser.m9131a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("permissions_email_header");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    if (mutableFlatBuffer.g(i, 6) != 0) {
                        jsonGenerator.a("permissions_email_text");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 6), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 7) != 0) {
                        jsonGenerator.a("permissions_friends_header");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                    }
                    if (mutableFlatBuffer.g(i, 8) != 0) {
                        jsonGenerator.a("permissions_friends_text");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 9) != 0) {
                        jsonGenerator.a("permissions_header");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                    }
                    if (mutableFlatBuffer.g(i, 10) != 0) {
                        jsonGenerator.a("permissions_payment_info_text");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 10), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 11) != 0) {
                        jsonGenerator.a("permissions_public_profile_header");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                    }
                    if (mutableFlatBuffer.g(i, 12) != 0) {
                        jsonGenerator.a("permissions_public_profile_text");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 12), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 13) != 0) {
                        jsonGenerator.a("privacy_policy_uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                    }
                    if (mutableFlatBuffer.g(i, 14) != 0) {
                        jsonGenerator.a("proxy_login_permissions_list");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 14), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 15) != 0) {
                        jsonGenerator.a("proxy_login_relative_path");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                    }
                    if (mutableFlatBuffer.g(i, 16) != 0) {
                        jsonGenerator.a("service_app_package_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                    }
                    if (mutableFlatBuffer.g(i, 17) != 0) {
                        jsonGenerator.a("service_authorization_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                    }
                    if (mutableFlatBuffer.g(i, 18) != 0) {
                        jsonGenerator.a("service_fb_app_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 18));
                    }
                    if (mutableFlatBuffer.g(i, 19) != 0) {
                        jsonGenerator.a("service_intro_header");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                    }
                    g = mutableFlatBuffer.g(i, 20);
                    if (g != 0) {
                        jsonGenerator.a("service_intro_image");
                        ServiceIntroImageParser.m9133a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 21);
                    if (g != 0) {
                        jsonGenerator.a("service_intro_logo");
                        ServiceIntroLogoParser.m9135a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 22) != 0) {
                        jsonGenerator.a("service_intro_message");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                    }
                    if (mutableFlatBuffer.g(i, 23) != 0) {
                        jsonGenerator.a("service_intro_warning_message");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 23));
                    }
                    if (mutableFlatBuffer.g(i, 24) != 0) {
                        jsonGenerator.a("service_provider_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 24));
                    }
                    if (mutableFlatBuffer.g(i, 25) != 0) {
                        jsonGenerator.a("service_redirect_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 25));
                    }
                    if (mutableFlatBuffer.g(i, 26) != 0) {
                        jsonGenerator.a("terms_uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 26));
                    }
                    if (mutableFlatBuffer.g(i, 27) != 0) {
                        jsonGenerator.a("third_party_registration_relative_path");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 27));
                    }
                    g = mutableFlatBuffer.g(i, 28);
                    if (g != 0) {
                        jsonGenerator.a("verified_phone_number");
                        PhoneNumberInfoParser.m9142a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m9138a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("new_user_signup")) {
                            iArr[0] = NewUserSignupParser.m9136a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m9139a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("new_user_signup");
                    NewUserSignupParser.m9137a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m9140a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("messenger_commerce")) {
                        iArr[1] = MessengerCommerceParser.m9138a(jsonParser, flatBufferBuilder);
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

    /* compiled from: mypid */
    public final class PhoneNumberInfoParser {
        public static int m9141a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("country_code")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("display_number")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("national_number")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("universal_number")) {
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

        public static void m9142a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("country_code");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("display_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("national_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("universal_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }
}
