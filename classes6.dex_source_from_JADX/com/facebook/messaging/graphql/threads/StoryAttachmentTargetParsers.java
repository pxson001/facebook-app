package com.facebook.messaging.graphql.threads;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLMomentsAppMessengerInviteActionType;
import com.facebook.graphql.enums.GraphQLMovieBotMovieListStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsParsers.PlatformCallToActionParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieButtonFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieDetailsFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieImageFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieTheaterFragmentParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.BusinessMessageParser.BusinessItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceBaseOrderReceiptParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceLocationParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderCancellationBubbleParser.CancelledItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderReceiptBubbleParser.RetailItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommercePromotionsParser.PromotionItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailCarrierParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailShipmentItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.ShipmentTrackingEventsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.LogoImageParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.PlatformContextParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionPaymentParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.AgentItemReceiptBubbleParser.ItemParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineBoardingPassBubbleParser.BoardingPassesParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineFlightInfoParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlinePassengerParser;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsParsers.BusinessRideLocationParser;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsParsers.BusinessRideReceiptFragmentParser.RideProviderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: videoTargetId wasn't set */
public class StoryAttachmentTargetParsers {

    /* compiled from: videoTargetId wasn't set */
    public final class FundraiserToCharityFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class FundraiserDetailedProgressTextParser {
            public static int m1778a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1779a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class FundraiserForCharityTextParser {
            public static int m1780a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1781a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m1782a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("fundraiser_detailed_progress_text")) {
                        iArr[1] = FundraiserDetailedProgressTextParser.m1778a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fundraiser_for_charity_text")) {
                        iArr[2] = FundraiserForCharityTextParser.m1780a(jsonParser, flatBufferBuilder);
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

        public static void m1783a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("fundraiser_detailed_progress_text");
                FundraiserDetailedProgressTextParser.m1779a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("fundraiser_for_charity_text");
                FundraiserForCharityTextParser.m1781a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class GroupFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class CoverPhotoParser {

            /* compiled from: videoTargetId wasn't set */
            public final class PhotoParser {

                /* compiled from: videoTargetId wasn't set */
                public final class ImageParser {
                    public static int m1784a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m1785a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m1786a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("image")) {
                                iArr[0] = ImageParser.m1784a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m1787a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("image");
                        ImageParser.m1785a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m1788a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("photo")) {
                            iArr[0] = PhotoParser.m1786a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m1789a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m1787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class GroupFriendMembersParser {
            public static int m1790a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1791a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class GroupMembersParser {
            public static int m1792a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1793a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class ViewerInviteToGroupParser {

            /* compiled from: videoTargetId wasn't set */
            public final class InviterParser {
                public static int m1794a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("name")) {
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

                public static void m1795a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m1796a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("inviter")) {
                            iArr[1] = InviterParser.m1794a(jsonParser, flatBufferBuilder);
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

            public static void m1797a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("inviter");
                    InviterParser.m1795a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1798a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("cover_photo")) {
                        iArr[0] = CoverPhotoParser.m1788a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_friend_members")) {
                        iArr[1] = GroupFriendMembersParser.m1790a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_members")) {
                        iArr[2] = GroupMembersParser.m1792a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("viewer_invite_to_group")) {
                        iArr[4] = ViewerInviteToGroupParser.m1796a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_join_state")) {
                        iArr[5] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                    } else if (i.equals("visibility")) {
                        iArr[6] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class MessageEventFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class EventCoordinatesParser {
            public static int m1799a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1800a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class EventPlaceParser {
            public static int m1801a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
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

            public static void m1802a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m1803a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[1];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("end_timestamp")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("event_coordinates")) {
                        iArr[1] = EventCoordinatesParser.m1799a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_place")) {
                        iArr[2] = EventPlaceParser.m1801a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_title")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_all_day")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("start_timestamp")) {
                        zArr[2] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(6);
            if (zArr[0]) {
                flatBufferBuilder.a(0, jArr[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[1]) {
                flatBufferBuilder.a(4, zArr2[0]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(5, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m1804a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            long a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("end_timestamp");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("event_coordinates");
                EventCoordinatesParser.m1800a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("event_place");
                EventPlaceParser.m1802a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("event_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            boolean a2 = mutableFlatBuffer.a(i, 4);
            if (a2) {
                jsonGenerator.a("is_all_day");
                jsonGenerator.a(a2);
            }
            a = mutableFlatBuffer.a(i, 5, 0);
            if (a != 0) {
                jsonGenerator.a("start_timestamp");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class MessageLocationFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class CoordinatesParser {
            public static int m1805a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1806a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class PlaceParser {
            public static int m1807a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1808a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        public static int m1809a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("coordinates")) {
                        iArr[0] = CoordinatesParser.m1805a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_current_location")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("place")) {
                        iArr[2] = PlaceParser.m1807a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("url")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class MomentsAppInvitationActionLinkFragmentParser {
        public static int m1813b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLMomentsAppMessengerInviteActionType.fromString(jsonParser.o()));
                    } else if (i.equals("logging_identifier")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("postback_payload_when_installed")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("postback_payload_when_not_installed")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("uri_when_installed")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static int m1810a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1813b(jsonParser, flatBufferBuilder)));
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

        public static void m1812a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m1811a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }

        public static void m1811a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("action_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("logging_identifier");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("postback_payload_when_installed");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("postback_payload_when_not_installed");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("uri_when_installed");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class PeerToPeerPaymentRequestFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class AmountParser {
            public static int m1814a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("currency")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("offset_amount")) {
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

            public static void m1815a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("currency");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("offset_amount");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class RequesteeParser {
            public static int m1816a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("requestee_id")) {
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

            public static void m1817a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("requestee_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class RequesterParser {
            public static int m1818a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("requester_id")) {
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

            public static void m1819a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("requester_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1820a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount")) {
                        iArr[0] = AmountParser.m1814a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("payment_request_id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("requestee")) {
                        iArr[2] = RequesteeParser.m1816a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("requester")) {
                        iArr[3] = RequesterParser.m1818a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class PeerToPeerTransferFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class AmountParser {
            public static int m1821a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("currency")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("offset_amount")) {
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

            public static void m1822a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("currency");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("offset_amount");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class ReceiverParser {
            public static int m1823a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("receiver_id")) {
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

            public static void m1824a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("receiver_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class SenderParser {
            public static int m1825a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("sender_id")) {
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

            public static void m1826a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("sender_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1827a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount")) {
                        iArr[0] = AmountParser.m1821a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("payment_id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("receiver")) {
                        iArr[2] = ReceiverParser.m1823a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sender")) {
                        iArr[3] = SenderParser.m1825a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: videoTargetId wasn't set */
    public final class StoryAttachmentTargetFragmentParser {

        /* compiled from: videoTargetId wasn't set */
        public final class AmountParser {
            public static int m1828a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("currency")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("offset_amount")) {
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

            public static void m1829a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("currency");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("offset_amount");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: videoTargetId wasn't set */
        public final class PageParser {
            public static int m1830a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1831a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: videoTargetId wasn't set */
        public final class PartnerLogoParser {
            public static int m1832a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m1833a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: videoTargetId wasn't set */
        public final class PaymentParser {
            public static int m1834a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("transfer_status")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLPeerToPeerTransferStatus.fromString(jsonParser.o()));
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

            public static void m1835a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("transfer_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m1836a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[141];
            boolean[] zArr = new boolean[9];
            boolean[] zArr2 = new boolean[3];
            int[] iArr2 = new int[3];
            long[] jArr = new long[2];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("amount")) {
                        iArr[1] = AmountParser.m1828a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("arrival_time_label")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("boarding_passes")) {
                        iArr[3] = BoardingPassesParser.m3179a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("boarding_time_label")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("boarding_zone_label")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("booking_number_label")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bubble_type")) {
                        iArr[7] = flatBufferBuilder.a(GraphQLMessengerCommerceBubbleType.fromString(jsonParser.o()));
                    } else if (i.equals("business_items")) {
                        iArr[8] = BusinessItemsParser.m1227a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("button_action_links")) {
                        iArr[9] = MomentsAppInvitationActionLinkFragmentParser.m1810a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("call_to_actions")) {
                        iArr[10] = PlatformCallToActionParser.m744a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("campaign")) {
                        iArr[11] = FundraiserToCharityFragmentParser.m1782a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_change_guest_status")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("cancelled_items")) {
                        iArr[13] = CancelledItemsParser.m1236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("carrier_tracking_url")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("checkin_cta_label")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("checkin_url")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("commerce_destination")) {
                        iArr[17] = CommerceLocationParser.m1234a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("commerce_origin")) {
                        iArr[18] = CommerceLocationParser.m1234a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("connection_style")) {
                        iArr[19] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                    } else if (i.equals("coordinates")) {
                        iArr[20] = CoordinatesParser.m1805a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[21] = CoverPhotoParser.m1788a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("currency")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("delayed_delivery_time_for_display")) {
                        iArr[23] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("departure_label")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("departure_time_label")) {
                        iArr[25] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("description")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("destination_address")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("destination_location")) {
                        iArr[28] = BusinessRideLocationParser.m3245a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("details_buttons")) {
                        iArr[29] = MovieButtonFragmentParser.m937a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_duration")) {
                        iArr[30] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("display_total")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("distance")) {
                        zArr[1] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("distance_unit")) {
                        iArr[33] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("end_timestamp")) {
                        zArr[2] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("estimated_delivery_time_for_display")) {
                        iArr[35] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("event_coordinates")) {
                        iArr[36] = EventCoordinatesParser.m1799a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_kind")) {
                        iArr[37] = flatBufferBuilder.a(GraphQLEventPrivacyType.fromString(jsonParser.o()));
                    } else if (i.equals("event_place")) {
                        iArr[38] = EventPlaceParser.m1801a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_title")) {
                        iArr[39] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("first_metaline")) {
                        iArr[40] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_gate_label")) {
                        iArr[41] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_info")) {
                        iArr[42] = AirlineFlightInfoParser.m3199a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("flight_infos")) {
                        iArr[43] = AirlineFlightInfoParser.m3200b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("flight_label")) {
                        iArr[44] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_status_label")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_terminal_label")) {
                        iArr[46] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("formatted_total")) {
                        iArr[47] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fundraiser_detailed_progress_text")) {
                        iArr[48] = FundraiserDetailedProgressTextParser.m1778a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fundraiser_for_charity_text")) {
                        iArr[49] = FundraiserForCharityTextParser.m1780a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_friend_members")) {
                        iArr[50] = GroupFriendMembersParser.m1790a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_members")) {
                        iArr[51] = GroupMembersParser.m1792a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[52] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_url")) {
                        iArr[53] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_all_day")) {
                        zArr[3] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("is_current_location")) {
                        zArr[4] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("item")) {
                        iArr[56] = ItemParser.m3013a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("itinerary_legs")) {
                        iArr[57] = ItineraryLegsParser.m3195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("list_title")) {
                        iArr[58] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("logo")) {
                        iArr[59] = LogoImageParser.m1269a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logo_image")) {
                        iArr[60] = MovieImageFragmentParser.m947a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_cta_label")) {
                        iArr[61] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("messenger_commerce_location")) {
                        iArr[62] = CommerceLocationParser.m1234a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("movie_list")) {
                        iArr[63] = MovieDetailsFragmentParser.m945b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("movie_list_style")) {
                        iArr[64] = flatBufferBuilder.a(GraphQLMovieBotMovieListStyle.fromString(jsonParser.o()));
                    } else if (i.equals("name")) {
                        iArr[65] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("native_link")) {
                        iArr[66] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("order_id")) {
                        iArr[67] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("order_payment_method")) {
                        iArr[68] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page")) {
                        iArr[69] = PageParser.m1830a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("partner_logo")) {
                        iArr[70] = PartnerLogoParser.m1832a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("passenger_infos")) {
                        iArr[71] = AirlinePassengerParser.m3207b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("passenger_name_label")) {
                        iArr[72] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("passenger_names_label")) {
                        iArr[73] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("passenger_seat_label")) {
                        iArr[74] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("payment")) {
                        iArr[75] = PaymentParser.m1834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("payment_id")) {
                        iArr[76] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("payment_request_id")) {
                        iArr[77] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photo_action_links")) {
                        iArr[78] = MomentsAppInvitationActionLinkFragmentParser.m1810a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place")) {
                        iArr[79] = PlaceParser.m1807a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("platform_context")) {
                        iArr[80] = PlatformContextParser.m1402a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("playing_movie")) {
                        iArr[81] = MovieDetailsFragmentParser.m943a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pnr_number")) {
                        iArr[82] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("price_amount")) {
                        iArr[83] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("price_currency")) {
                        iArr[84] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("promotion_items")) {
                        iArr[85] = PromotionItemsParser.m1250a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("receipt")) {
                        iArr[86] = CommerceBaseOrderReceiptParser.m1230a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("receipt_id")) {
                        iArr[87] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("receipt_url")) {
                        iArr[88] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("receiver")) {
                        iArr[89] = ReceiverParser.m1823a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("requestee")) {
                        iArr[90] = RequesteeParser.m1816a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("requester")) {
                        iArr[91] = RequesterParser.m1818a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("retail_carrier")) {
                        iArr[92] = RetailCarrierParser.m1259a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("retail_items")) {
                        iArr[93] = RetailItemsParser.m1239a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("retail_shipment_items")) {
                        iArr[94] = RetailShipmentItemsParser.m1261a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("ride_display_name")) {
                        iArr[95] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("ride_provider")) {
                        iArr[96] = RideProviderParser.m3247a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("schedule_buttons")) {
                        iArr[97] = MovieButtonFragmentParser.m937a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("second_metaline")) {
                        iArr[98] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("seller_info")) {
                        iArr[99] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sender")) {
                        iArr[100] = SenderParser.m1825a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service_type_description")) {
                        iArr[101] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("share_cta_label")) {
                        iArr[102] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("shipdate_for_display")) {
                        iArr[103] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("shipment")) {
                        iArr[104] = CommerceShipmentBubbleParser.m1265a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("shipment_tracking_event_type")) {
                        iArr[105] = flatBufferBuilder.a(GraphQLShipmentTrackingEventType.fromString(jsonParser.o()));
                    } else if (i.equals("shipment_tracking_events")) {
                        iArr[106] = ShipmentTrackingEventsParser.m1263a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("snippet")) {
                        iArr[107] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source_address")) {
                        iArr[108] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source_location")) {
                        iArr[109] = BusinessRideLocationParser.m3245a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("source_name")) {
                        iArr[110] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("start_timestamp")) {
                        zArr[5] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("status")) {
                        iArr[112] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("status_type")) {
                        iArr[113] = flatBufferBuilder.a(GraphQLMessengerRetailItemStatus.fromString(jsonParser.o()));
                    } else if (i.equals("structured_address")) {
                        iArr[114] = CommerceLocationParser.m1234a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subscribed_item")) {
                        iArr[115] = SubscribedItemParser.m1247a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("target_url")) {
                        iArr[116] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("theaters")) {
                        iArr[117] = MovieTheaterFragmentParser.m951a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("third_metaline")) {
                        iArr[118] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("timezone")) {
                        iArr[119] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tint_color")) {
                        iArr[120] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("total")) {
                        iArr[121] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("total_label")) {
                        iArr[122] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tracking_event_description")) {
                        iArr[123] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tracking_event_time_for_display")) {
                        iArr[124] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tracking_number")) {
                        iArr[125] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("transaction_discount")) {
                        zArr[6] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("transaction_payment")) {
                        iArr[127] = TransactionPaymentParser.m1406a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("transaction_products")) {
                        iArr[128] = TransactionProductsParser.m1416a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("transaction_status")) {
                        iArr[129] = flatBufferBuilder.a(GraphQLPageProductTransactionOrderStatusEnum.fromString(jsonParser.o()));
                    } else if (i.equals("transaction_status_display")) {
                        iArr[130] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("transaction_subtotal_cost")) {
                        zArr[7] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("transaction_total_cost")) {
                        zArr[8] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("update_type")) {
                        iArr[133] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[134] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("view_boarding_pass_cta_label")) {
                        iArr[135] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("view_details_cta_label")) {
                        iArr[136] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("viewer_guest_status")) {
                        iArr[137] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                    } else if (i.equals("viewer_invite_to_group")) {
                        iArr[138] = ViewerInviteToGroupParser.m1796a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_join_state")) {
                        iArr[139] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                    } else if (i.equals("visibility")) {
                        iArr[140] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(141);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            if (zArr[0]) {
                flatBufferBuilder.a(12, zArr2[0]);
            }
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
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            if (zArr[1]) {
                flatBufferBuilder.a(32, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(33, iArr[33]);
            if (zArr[2]) {
                flatBufferBuilder.a(34, jArr[0], 0);
            }
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            flatBufferBuilder.b(39, iArr[39]);
            flatBufferBuilder.b(40, iArr[40]);
            flatBufferBuilder.b(41, iArr[41]);
            flatBufferBuilder.b(42, iArr[42]);
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            flatBufferBuilder.b(46, iArr[46]);
            flatBufferBuilder.b(47, iArr[47]);
            flatBufferBuilder.b(48, iArr[48]);
            flatBufferBuilder.b(49, iArr[49]);
            flatBufferBuilder.b(50, iArr[50]);
            flatBufferBuilder.b(51, iArr[51]);
            flatBufferBuilder.b(52, iArr[52]);
            flatBufferBuilder.b(53, iArr[53]);
            if (zArr[3]) {
                flatBufferBuilder.a(54, zArr2[1]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(55, zArr2[2]);
            }
            flatBufferBuilder.b(56, iArr[56]);
            flatBufferBuilder.b(57, iArr[57]);
            flatBufferBuilder.b(58, iArr[58]);
            flatBufferBuilder.b(59, iArr[59]);
            flatBufferBuilder.b(60, iArr[60]);
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            flatBufferBuilder.b(63, iArr[63]);
            flatBufferBuilder.b(64, iArr[64]);
            flatBufferBuilder.b(65, iArr[65]);
            flatBufferBuilder.b(66, iArr[66]);
            flatBufferBuilder.b(67, iArr[67]);
            flatBufferBuilder.b(68, iArr[68]);
            flatBufferBuilder.b(69, iArr[69]);
            flatBufferBuilder.b(70, iArr[70]);
            flatBufferBuilder.b(71, iArr[71]);
            flatBufferBuilder.b(72, iArr[72]);
            flatBufferBuilder.b(73, iArr[73]);
            flatBufferBuilder.b(74, iArr[74]);
            flatBufferBuilder.b(75, iArr[75]);
            flatBufferBuilder.b(76, iArr[76]);
            flatBufferBuilder.b(77, iArr[77]);
            flatBufferBuilder.b(78, iArr[78]);
            flatBufferBuilder.b(79, iArr[79]);
            flatBufferBuilder.b(80, iArr[80]);
            flatBufferBuilder.b(81, iArr[81]);
            flatBufferBuilder.b(82, iArr[82]);
            flatBufferBuilder.b(83, iArr[83]);
            flatBufferBuilder.b(84, iArr[84]);
            flatBufferBuilder.b(85, iArr[85]);
            flatBufferBuilder.b(86, iArr[86]);
            flatBufferBuilder.b(87, iArr[87]);
            flatBufferBuilder.b(88, iArr[88]);
            flatBufferBuilder.b(89, iArr[89]);
            flatBufferBuilder.b(90, iArr[90]);
            flatBufferBuilder.b(91, iArr[91]);
            flatBufferBuilder.b(92, iArr[92]);
            flatBufferBuilder.b(93, iArr[93]);
            flatBufferBuilder.b(94, iArr[94]);
            flatBufferBuilder.b(95, iArr[95]);
            flatBufferBuilder.b(96, iArr[96]);
            flatBufferBuilder.b(97, iArr[97]);
            flatBufferBuilder.b(98, iArr[98]);
            flatBufferBuilder.b(99, iArr[99]);
            flatBufferBuilder.b(100, iArr[100]);
            flatBufferBuilder.b(101, iArr[101]);
            flatBufferBuilder.b(102, iArr[102]);
            flatBufferBuilder.b(103, iArr[103]);
            flatBufferBuilder.b(104, iArr[104]);
            flatBufferBuilder.b(105, iArr[105]);
            flatBufferBuilder.b(106, iArr[106]);
            flatBufferBuilder.b(107, iArr[107]);
            flatBufferBuilder.b(108, iArr[108]);
            flatBufferBuilder.b(109, iArr[109]);
            flatBufferBuilder.b(110, iArr[110]);
            if (zArr[5]) {
                flatBufferBuilder.a(111, jArr[1], 0);
            }
            flatBufferBuilder.b(112, iArr[112]);
            flatBufferBuilder.b(113, iArr[113]);
            flatBufferBuilder.b(114, iArr[114]);
            flatBufferBuilder.b(115, iArr[115]);
            flatBufferBuilder.b(116, iArr[116]);
            flatBufferBuilder.b(117, iArr[117]);
            flatBufferBuilder.b(118, iArr[118]);
            flatBufferBuilder.b(119, iArr[119]);
            flatBufferBuilder.b(120, iArr[120]);
            flatBufferBuilder.b(121, iArr[121]);
            flatBufferBuilder.b(122, iArr[122]);
            flatBufferBuilder.b(123, iArr[123]);
            flatBufferBuilder.b(124, iArr[124]);
            flatBufferBuilder.b(125, iArr[125]);
            if (zArr[6]) {
                flatBufferBuilder.a(126, iArr2[0], 0);
            }
            flatBufferBuilder.b(127, iArr[127]);
            flatBufferBuilder.b(128, iArr[128]);
            flatBufferBuilder.b(129, iArr[129]);
            flatBufferBuilder.b(130, iArr[130]);
            if (zArr[7]) {
                flatBufferBuilder.a(131, iArr2[1], 0);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(132, iArr2[2], 0);
            }
            flatBufferBuilder.b(133, iArr[133]);
            flatBufferBuilder.b(134, iArr[134]);
            flatBufferBuilder.b(135, iArr[135]);
            flatBufferBuilder.b(136, iArr[136]);
            flatBufferBuilder.b(137, iArr[137]);
            flatBufferBuilder.b(138, iArr[138]);
            flatBufferBuilder.b(139, iArr[139]);
            flatBufferBuilder.b(140, iArr[140]);
            return flatBufferBuilder.d();
        }

        public static void m1837a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("amount");
                AmountParser.m1829a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("arrival_time_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("boarding_passes");
                BoardingPassesParser.m3180a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("boarding_time_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("boarding_zone_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("booking_number_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("bubble_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("business_items");
                BusinessItemsParser.m1228a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("button_action_links");
                MomentsAppInvitationActionLinkFragmentParser.m1812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("call_to_actions");
                PlatformCallToActionParser.m745a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("campaign");
                FundraiserToCharityFragmentParser.m1783a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("can_viewer_change_guest_status");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("cancelled_items");
                CancelledItemsParser.m1237a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("carrier_tracking_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("checkin_cta_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("checkin_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("commerce_destination");
                CommerceLocationParser.m1235a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("commerce_origin");
                CommerceLocationParser.m1235a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("connection_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 19));
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("coordinates");
                CoordinatesParser.m1806a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                CoverPhotoParser.m1789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("delayed_delivery_time_for_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 23));
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("departure_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            if (mutableFlatBuffer.g(i, 25) != 0) {
                jsonGenerator.a("departure_time_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 25));
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("destination_address");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("destination_location");
                BusinessRideLocationParser.m3246a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("details_buttons");
                MovieButtonFragmentParser.m938a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("display_duration");
                jsonGenerator.b(mutableFlatBuffer.c(i, 30));
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("display_total");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            double a2 = mutableFlatBuffer.a(i, 32, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("distance");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("distance_unit");
                jsonGenerator.b(mutableFlatBuffer.c(i, 33));
            }
            long a3 = mutableFlatBuffer.a(i, 34, 0);
            if (a3 != 0) {
                jsonGenerator.a("end_timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("estimated_delivery_time_for_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 35));
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("event_coordinates");
                EventCoordinatesParser.m1800a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 37) != 0) {
                jsonGenerator.a("event_kind");
                jsonGenerator.b(mutableFlatBuffer.b(i, 37));
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("event_place");
                EventPlaceParser.m1802a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 39) != 0) {
                jsonGenerator.a("event_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 39));
            }
            if (mutableFlatBuffer.g(i, 40) != 0) {
                jsonGenerator.a("first_metaline");
                jsonGenerator.b(mutableFlatBuffer.c(i, 40));
            }
            if (mutableFlatBuffer.g(i, 41) != 0) {
                jsonGenerator.a("flight_gate_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 41));
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("flight_info");
                AirlineFlightInfoParser.m3201b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("flight_infos");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    AirlineFlightInfoParser.m3201b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 44) != 0) {
                jsonGenerator.a("flight_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 44));
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("flight_status_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            if (mutableFlatBuffer.g(i, 46) != 0) {
                jsonGenerator.a("flight_terminal_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 46));
            }
            if (mutableFlatBuffer.g(i, 47) != 0) {
                jsonGenerator.a("formatted_total");
                jsonGenerator.b(mutableFlatBuffer.c(i, 47));
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("fundraiser_detailed_progress_text");
                FundraiserDetailedProgressTextParser.m1779a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("fundraiser_for_charity_text");
                FundraiserForCharityTextParser.m1781a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 50);
            if (g != 0) {
                jsonGenerator.a("group_friend_members");
                GroupFriendMembersParser.m1791a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 51);
            if (g != 0) {
                jsonGenerator.a("group_members");
                GroupMembersParser.m1793a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 52) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 52));
            }
            if (mutableFlatBuffer.g(i, 53) != 0) {
                jsonGenerator.a("image_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 53));
            }
            a = mutableFlatBuffer.a(i, 54);
            if (a) {
                jsonGenerator.a("is_all_day");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 55);
            if (a) {
                jsonGenerator.a("is_current_location");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("item");
                ItemParser.m3014a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 57);
            if (g != 0) {
                jsonGenerator.a("itinerary_legs");
                ItineraryLegsParser.m3196a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 58) != 0) {
                jsonGenerator.a("list_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 58));
            }
            g = mutableFlatBuffer.g(i, 59);
            if (g != 0) {
                jsonGenerator.a("logo");
                LogoImageParser.m1270a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 60);
            if (g != 0) {
                jsonGenerator.a("logo_image");
                MovieImageFragmentParser.m948a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 61) != 0) {
                jsonGenerator.a("message_cta_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 61));
            }
            g = mutableFlatBuffer.g(i, 62);
            if (g != 0) {
                jsonGenerator.a("messenger_commerce_location");
                CommerceLocationParser.m1235a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 63);
            if (g != 0) {
                jsonGenerator.a("movie_list");
                MovieDetailsFragmentParser.m944a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 64) != 0) {
                jsonGenerator.a("movie_list_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 64));
            }
            if (mutableFlatBuffer.g(i, 65) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 65));
            }
            if (mutableFlatBuffer.g(i, 66) != 0) {
                jsonGenerator.a("native_link");
                jsonGenerator.b(mutableFlatBuffer.c(i, 66));
            }
            if (mutableFlatBuffer.g(i, 67) != 0) {
                jsonGenerator.a("order_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 67));
            }
            if (mutableFlatBuffer.g(i, 68) != 0) {
                jsonGenerator.a("order_payment_method");
                jsonGenerator.b(mutableFlatBuffer.c(i, 68));
            }
            g = mutableFlatBuffer.g(i, 69);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m1831a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 70);
            if (g != 0) {
                jsonGenerator.a("partner_logo");
                PartnerLogoParser.m1833a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 71);
            if (g != 0) {
                jsonGenerator.a("passenger_infos");
                AirlinePassengerParser.m3206a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 72) != 0) {
                jsonGenerator.a("passenger_name_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 72));
            }
            if (mutableFlatBuffer.g(i, 73) != 0) {
                jsonGenerator.a("passenger_names_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 73));
            }
            if (mutableFlatBuffer.g(i, 74) != 0) {
                jsonGenerator.a("passenger_seat_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 74));
            }
            g = mutableFlatBuffer.g(i, 75);
            if (g != 0) {
                jsonGenerator.a("payment");
                PaymentParser.m1835a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 76) != 0) {
                jsonGenerator.a("payment_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 76));
            }
            if (mutableFlatBuffer.g(i, 77) != 0) {
                jsonGenerator.a("payment_request_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 77));
            }
            g = mutableFlatBuffer.g(i, 78);
            if (g != 0) {
                jsonGenerator.a("photo_action_links");
                MomentsAppInvitationActionLinkFragmentParser.m1812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 79);
            if (g != 0) {
                jsonGenerator.a("place");
                PlaceParser.m1808a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 80);
            if (g != 0) {
                jsonGenerator.a("platform_context");
                PlatformContextParser.m1403a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 81);
            if (g != 0) {
                jsonGenerator.a("playing_movie");
                MovieDetailsFragmentParser.m946b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 82) != 0) {
                jsonGenerator.a("pnr_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 82));
            }
            if (mutableFlatBuffer.g(i, 83) != 0) {
                jsonGenerator.a("price_amount");
                jsonGenerator.b(mutableFlatBuffer.c(i, 83));
            }
            if (mutableFlatBuffer.g(i, 84) != 0) {
                jsonGenerator.a("price_currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 84));
            }
            g = mutableFlatBuffer.g(i, 85);
            if (g != 0) {
                jsonGenerator.a("promotion_items");
                PromotionItemsParser.m1251a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 86);
            if (g != 0) {
                jsonGenerator.a("receipt");
                CommerceBaseOrderReceiptParser.m1231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 87) != 0) {
                jsonGenerator.a("receipt_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 87));
            }
            if (mutableFlatBuffer.g(i, 88) != 0) {
                jsonGenerator.a("receipt_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 88));
            }
            g = mutableFlatBuffer.g(i, 89);
            if (g != 0) {
                jsonGenerator.a("receiver");
                ReceiverParser.m1824a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 90);
            if (g != 0) {
                jsonGenerator.a("requestee");
                RequesteeParser.m1817a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 91);
            if (g != 0) {
                jsonGenerator.a("requester");
                RequesterParser.m1819a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 92);
            if (g != 0) {
                jsonGenerator.a("retail_carrier");
                RetailCarrierParser.m1260a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 93);
            if (g != 0) {
                jsonGenerator.a("retail_items");
                RetailItemsParser.m1240a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 94);
            if (g != 0) {
                jsonGenerator.a("retail_shipment_items");
                RetailShipmentItemsParser.m1262a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 95) != 0) {
                jsonGenerator.a("ride_display_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 95));
            }
            g = mutableFlatBuffer.g(i, 96);
            if (g != 0) {
                jsonGenerator.a("ride_provider");
                RideProviderParser.m3248a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 97);
            if (g != 0) {
                jsonGenerator.a("schedule_buttons");
                MovieButtonFragmentParser.m938a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 98) != 0) {
                jsonGenerator.a("second_metaline");
                jsonGenerator.b(mutableFlatBuffer.c(i, 98));
            }
            if (mutableFlatBuffer.g(i, 99) != 0) {
                jsonGenerator.a("seller_info");
                jsonGenerator.b(mutableFlatBuffer.c(i, 99));
            }
            g = mutableFlatBuffer.g(i, 100);
            if (g != 0) {
                jsonGenerator.a("sender");
                SenderParser.m1826a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 101) != 0) {
                jsonGenerator.a("service_type_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 101));
            }
            if (mutableFlatBuffer.g(i, 102) != 0) {
                jsonGenerator.a("share_cta_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 102));
            }
            if (mutableFlatBuffer.g(i, 103) != 0) {
                jsonGenerator.a("shipdate_for_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 103));
            }
            g = mutableFlatBuffer.g(i, 104);
            if (g != 0) {
                jsonGenerator.a("shipment");
                CommerceShipmentBubbleParser.m1266a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 105) != 0) {
                jsonGenerator.a("shipment_tracking_event_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 105));
            }
            g = mutableFlatBuffer.g(i, 106);
            if (g != 0) {
                jsonGenerator.a("shipment_tracking_events");
                ShipmentTrackingEventsParser.m1264a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 107) != 0) {
                jsonGenerator.a("snippet");
                jsonGenerator.b(mutableFlatBuffer.c(i, 107));
            }
            if (mutableFlatBuffer.g(i, 108) != 0) {
                jsonGenerator.a("source_address");
                jsonGenerator.b(mutableFlatBuffer.c(i, 108));
            }
            g = mutableFlatBuffer.g(i, 109);
            if (g != 0) {
                jsonGenerator.a("source_location");
                BusinessRideLocationParser.m3246a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 110) != 0) {
                jsonGenerator.a("source_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 110));
            }
            a3 = mutableFlatBuffer.a(i, 111, 0);
            if (a3 != 0) {
                jsonGenerator.a("start_timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 112) != 0) {
                jsonGenerator.a("status");
                jsonGenerator.b(mutableFlatBuffer.c(i, 112));
            }
            if (mutableFlatBuffer.g(i, 113) != 0) {
                jsonGenerator.a("status_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 113));
            }
            g = mutableFlatBuffer.g(i, 114);
            if (g != 0) {
                jsonGenerator.a("structured_address");
                CommerceLocationParser.m1235a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 115);
            if (g != 0) {
                jsonGenerator.a("subscribed_item");
                SubscribedItemParser.m1248a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 116) != 0) {
                jsonGenerator.a("target_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 116));
            }
            g = mutableFlatBuffer.g(i, 117);
            if (g != 0) {
                jsonGenerator.a("theaters");
                MovieTheaterFragmentParser.m952a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 118) != 0) {
                jsonGenerator.a("third_metaline");
                jsonGenerator.b(mutableFlatBuffer.c(i, 118));
            }
            if (mutableFlatBuffer.g(i, 119) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 119));
            }
            if (mutableFlatBuffer.g(i, 120) != 0) {
                jsonGenerator.a("tint_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 120));
            }
            if (mutableFlatBuffer.g(i, 121) != 0) {
                jsonGenerator.a("total");
                jsonGenerator.b(mutableFlatBuffer.c(i, 121));
            }
            if (mutableFlatBuffer.g(i, 122) != 0) {
                jsonGenerator.a("total_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 122));
            }
            if (mutableFlatBuffer.g(i, 123) != 0) {
                jsonGenerator.a("tracking_event_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 123));
            }
            if (mutableFlatBuffer.g(i, 124) != 0) {
                jsonGenerator.a("tracking_event_time_for_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 124));
            }
            if (mutableFlatBuffer.g(i, 125) != 0) {
                jsonGenerator.a("tracking_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 125));
            }
            g = mutableFlatBuffer.a(i, 126, 0);
            if (g != 0) {
                jsonGenerator.a("transaction_discount");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 127);
            if (g != 0) {
                jsonGenerator.a("transaction_payment");
                TransactionPaymentParser.m1407a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 128);
            if (g != 0) {
                jsonGenerator.a("transaction_products");
                TransactionProductsParser.m1417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 129) != 0) {
                jsonGenerator.a("transaction_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 129));
            }
            if (mutableFlatBuffer.g(i, 130) != 0) {
                jsonGenerator.a("transaction_status_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 130));
            }
            g = mutableFlatBuffer.a(i, 131, 0);
            if (g != 0) {
                jsonGenerator.a("transaction_subtotal_cost");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 132, 0);
            if (g != 0) {
                jsonGenerator.a("transaction_total_cost");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 133) != 0) {
                jsonGenerator.a("update_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 133));
            }
            if (mutableFlatBuffer.g(i, 134) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 134));
            }
            if (mutableFlatBuffer.g(i, 135) != 0) {
                jsonGenerator.a("view_boarding_pass_cta_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 135));
            }
            if (mutableFlatBuffer.g(i, 136) != 0) {
                jsonGenerator.a("view_details_cta_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 136));
            }
            if (mutableFlatBuffer.g(i, 137) != 0) {
                jsonGenerator.a("viewer_guest_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 137));
            }
            g = mutableFlatBuffer.g(i, 138);
            if (g != 0) {
                jsonGenerator.a("viewer_invite_to_group");
                ViewerInviteToGroupParser.m1797a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 139) != 0) {
                jsonGenerator.a("viewer_join_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 139));
            }
            if (mutableFlatBuffer.g(i, 140) != 0) {
                jsonGenerator.a("visibility");
                jsonGenerator.b(mutableFlatBuffer.b(i, 140));
            }
            jsonGenerator.g();
        }
    }
}
