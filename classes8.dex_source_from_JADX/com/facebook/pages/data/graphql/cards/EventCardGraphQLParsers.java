package com.facebook.pages.data.graphql.cards;

import com.facebook.events.graphql.EventsGraphQLParsers.EventPlaceParser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventSocialContextFieldsParser.EventMembersParser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventSocialContextFieldsParser.FriendEventMaybesFirst5Parser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventSocialContextFieldsParser.FriendEventMembersFirst5Parser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventSocialContextFieldsParser.FriendEventWatchersFirst5Parser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventSocialContextFieldsParser.SuggestedEventContextSentenceParser;
import com.facebook.events.graphql.EventsGraphQLParsers.UserInEventFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: context_item_surface */
public class EventCardGraphQLParsers {

    /* compiled from: context_item_surface */
    public final class EventCardQueryParser {
        public static int m20443a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("events_calendar_can_viewer_subscribe")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("events_calendar_subscription_status")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLEventsCalendarSubscriptionStatus.fromString(jsonParser.o()));
                    } else if (i.equals("owned_events")) {
                        iArr[2] = PageEventsConnectionParser.m20454a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: context_item_surface */
    public final class PageEventsConnectionParser {

        /* compiled from: context_item_surface */
        public final class NodesParser {

            /* compiled from: context_item_surface */
            public final class CoverPhotoParser {

                /* compiled from: context_item_surface */
                public final class FocusParser {
                    public static int m20444a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        boolean[] zArr = new boolean[2];
                        double[] dArr = new double[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("x")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("y")) {
                                    zArr[1] = true;
                                    dArr[1] = jsonParser.G();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(2);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, dArr[0], 0.0d);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(1, dArr[1], 0.0d);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m20445a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        double a = mutableFlatBuffer.a(i, 0, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("x");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 1, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("y");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: context_item_surface */
                public final class PhotoParser {

                    /* compiled from: context_item_surface */
                    public final class ImageParser {
                        public static int m20446a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m20447a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                    public static int m20448a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("image")) {
                                    iArr[1] = ImageParser.m20446a(jsonParser, flatBufferBuilder);
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

                    public static void m20449a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("image");
                            ImageParser.m20447a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m20450a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("focus")) {
                                iArr[0] = FocusParser.m20444a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("photo")) {
                                iArr[1] = PhotoParser.m20448a(jsonParser, flatBufferBuilder);
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

                public static void m20451a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("focus");
                        FocusParser.m20445a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("photo");
                        PhotoParser.m20449a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m20452b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[19];
                boolean[] zArr = new boolean[5];
                boolean[] zArr2 = new boolean[3];
                long[] jArr = new long[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_change_guest_status")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_join")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("connection_style")) {
                            iArr[2] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("cover_photo")) {
                            iArr[3] = CoverPhotoParser.m20450a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("end_timestamp")) {
                            zArr[2] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("event_members")) {
                            iArr[5] = EventMembersParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("event_place")) {
                            iArr[6] = EventPlaceParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friendEventMaybesFirst5")) {
                            iArr[7] = FriendEventMaybesFirst5Parser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friendEventMembersFirst5")) {
                            iArr[8] = FriendEventMembersFirst5Parser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friendEventWatchersFirst5")) {
                            iArr[9] = FriendEventWatchersFirst5Parser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[10] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("is_all_day")) {
                            zArr[3] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("name")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("start_timestamp")) {
                            zArr[4] = true;
                            jArr[1] = jsonParser.F();
                        } else if (i.equals("suggested_event_context_sentence")) {
                            iArr[14] = SuggestedEventContextSentenceParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("timezone")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[16] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_inviters")) {
                            iArr[17] = UserInEventFragmentParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_watch_status")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(19);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, zArr2[1]);
                }
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                if (zArr[2]) {
                    flatBufferBuilder.a(4, jArr[0], 0);
                }
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                if (zArr[3]) {
                    flatBufferBuilder.a(11, zArr2[2]);
                }
                flatBufferBuilder.b(12, iArr[12]);
                if (zArr[4]) {
                    flatBufferBuilder.a(13, jArr[1], 0);
                }
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                return flatBufferBuilder.d();
            }

            public static void m20453b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_change_guest_status");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_join");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m20451a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                long a2 = mutableFlatBuffer.a(i, 4, 0);
                if (a2 != 0) {
                    jsonGenerator.a("end_timestamp");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("event_members");
                    EventMembersParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("friendEventMaybesFirst5");
                    FriendEventMaybesFirst5Parser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("friendEventMembersFirst5");
                    FriendEventMembersFirst5Parser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("friendEventWatchersFirst5");
                    FriendEventWatchersFirst5Parser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                }
                a = mutableFlatBuffer.a(i, 11);
                if (a) {
                    jsonGenerator.a("is_all_day");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                a2 = mutableFlatBuffer.a(i, 13, 0);
                if (a2 != 0) {
                    jsonGenerator.a("start_timestamp");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("suggested_event_context_sentence");
                    SuggestedEventContextSentenceParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 16));
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("viewer_inviters");
                    UserInEventFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("viewer_watch_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                jsonGenerator.g();
            }
        }

        public static int m20454a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("nodes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(NodesParser.m20452b(jsonParser, flatBufferBuilder)));
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

        public static void m20455a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    NodesParser.m20453b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }
}
