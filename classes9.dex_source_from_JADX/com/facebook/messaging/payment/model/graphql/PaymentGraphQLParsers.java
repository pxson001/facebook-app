package com.facebook.messaging.payment.model.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetTypeEnum;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferReceiverStatus;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferSenderStatus;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: held_wakelock_details */
public class PaymentGraphQLParsers {

    /* compiled from: held_wakelock_details */
    public final class CommerceOrderParser {
        public static int m13952a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("description")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_url")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("seller_info")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static void m13953a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("image_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("seller_info");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class FetchAllMoreTransactionsQueryParser {
        public static MutableFlatBuffer m13954a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchAllThemesQueryParser {
        public static int m13955a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_themes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(ThemeParser.m14030a(jsonParser, flatBufferBuilder)));
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
    }

    /* compiled from: held_wakelock_details */
    public final class FetchAllTransactionListQueryParser {
        public static MutableFlatBuffer m13956a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchIncomingMoreTransactionsQueryParser {
        public static MutableFlatBuffer m13957a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("incoming_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchIncomingPaymentRequestsQueryParser {

        /* compiled from: held_wakelock_details */
        public final class IncomingPeerToPeerPaymentRequestsParser {
            public static int m13958a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            iArr[0] = PaymentRequestParser.m14002a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m13959a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    PaymentRequestParser.m14003a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m13960a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("incoming_peer_to_peer_payment_requests")) {
                        iArr[0] = IncomingPeerToPeerPaymentRequestsParser.m13958a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchIncomingTransactionListQueryParser {
        public static MutableFlatBuffer m13961a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("incoming_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchOutgoingMoreTransactionsQueryParser {
        public static MutableFlatBuffer m13962a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("outgoing_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchOutgoingPaymentRequestsQueryParser {

        /* compiled from: held_wakelock_details */
        public final class OutgoingPeerToPeerPaymentRequestsParser {
            public static int m13963a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            iArr[0] = PaymentRequestParser.m14002a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m13964a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    PaymentRequestParser.m14003a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m13965a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("outgoing_peer_to_peer_payment_requests")) {
                        iArr[0] = OutgoingPeerToPeerPaymentRequestsParser.m13963a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchOutgoingTransactionListQueryParser {
        public static MutableFlatBuffer m13966a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("outgoing_messenger_payments")) {
                        iArr[0] = PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchPaymentAccountEnabledStatusQueryParser {
        public static MutableFlatBuffer m13967a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("peer_to_peer_payments")) {
                        iArr[0] = PaymentAccountEnabledStatusParser.m13978a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchPaymentPinStatusQueryParser {

        /* compiled from: held_wakelock_details */
        public final class PeerToPeerPaymentsParser {
            public static int m13968a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("peer_to_peer_payment_pin")) {
                            iArr[0] = PaymentPinStatusParser.m13990a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m13969a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("peer_to_peer_payment_pin");
                    PaymentPinStatusParser.m13991a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m13970a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("peer_to_peer_payments")) {
                        iArr[0] = PeerToPeerPaymentsParser.m13968a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class FetchPaymentPlatformContextsQueryParser {
        public static int m13971a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("peer_to_peer_platform_contexts")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(PaymentPlatformContextParser.m13994a(jsonParser, flatBufferBuilder)));
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
    }

    /* compiled from: held_wakelock_details */
    public final class FetchShippingAddressQueryParser {

        /* compiled from: held_wakelock_details */
        public final class MailingAddressesParser {
            public static int m13972a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(MailingAddressInfoParser.m13975a(jsonParser, flatBufferBuilder)));
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

            public static void m13973a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        MailingAddressInfoParser.m13976b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m13974a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("mailing_addresses")) {
                        iArr[0] = MailingAddressesParser.m13972a(jsonParser, flatBufferBuilder);
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

    /* compiled from: held_wakelock_details */
    public final class MailingAddressInfoParser {
        public static int m13975a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = StreetAddressInfoParser.m14022a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("city_name")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_default")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_messenger_eligible")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("label")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("region_name")) {
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
            if (zArr[0]) {
                flatBufferBuilder.a(3, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(4, zArr2[1]);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m13976b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("address");
                StreetAddressInfoParser.m14023a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("city_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            boolean a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("is_default");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("is_messenger_eligible");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("region_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PageInfoParser {
        public static MutableFlatBuffer m13977a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentAccountEnabledStatusParser {
        public static int m13978a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("account_enabled")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            return flatBufferBuilder.d();
        }

        public static void m13979a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("account_enabled");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentCurrencyAmountParser {
        public static int m13980a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount_in_hundredths")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("currency")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
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

        public static void m13981a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("amount_in_hundredths");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentCurrencyQuantityParser {
        public static int m13982a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount_with_offset")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("currency")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("offset")) {
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

        public static void m13983a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("amount_with_offset");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("offset");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentPinStatusParser {

        /* compiled from: held_wakelock_details */
        public final class ProtectedThreadProfilesParser {
            public static int m13986b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static int m13984a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m13986b(jsonParser, flatBufferBuilder)));
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

            public static void m13985a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: held_wakelock_details */
        public final class UnprotectedThreadProfilesParser {
            public static int m13989b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static int m13987a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m13989b(jsonParser, flatBufferBuilder)));
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

            public static void m13988a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        public static int m13990a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("payments_protected")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("protected_thread_profiles")) {
                        iArr[2] = ProtectedThreadProfilesParser.m13984a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unprotected_thread_profiles")) {
                        iArr[3] = UnprotectedThreadProfilesParser.m13987a(jsonParser, flatBufferBuilder);
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

        public static void m13991a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("payments_protected");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("protected_thread_profiles");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ProtectedThreadProfilesParser.m13985a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("unprotected_thread_profiles");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    UnprotectedThreadProfilesParser.m13988a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentPlatformContextParser {

        /* compiled from: held_wakelock_details */
        public final class PeerToPeerPlatformProductItemParser {
            public static int m13992a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("product_item_price")) {
                            iArr[0] = PaymentCurrencyAmountParser.m13980a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m13993a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("product_item_price");
                    PaymentCurrencyAmountParser.m13981a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m13994a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[14];
            boolean[] zArr = new boolean[6];
            boolean[] zArr2 = new boolean[4];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("buyer")) {
                        iArr[0] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("creation_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("modified_time")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("peer_to_peer_platform_item")) {
                        iArr[4] = PaymentPlatformItemParser.m14000a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("peer_to_peer_platform_product_item")) {
                        iArr[5] = PeerToPeerPlatformProductItemParser.m13992a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("selected_shipping_address")) {
                        iArr[6] = MailingAddressInfoParser.m13975a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("selected_shipping_option")) {
                        iArr[7] = PaymentShippingOptionParser.m14006a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("seller")) {
                        iArr[8] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("shipping_options")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(PaymentShippingOptionParser.m14006a(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[9] = i2;
                    } else if (i.equals("should_show_pay_button")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("should_show_to_buyer")) {
                        zArr[3] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("should_show_to_seller")) {
                        zArr[4] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("should_show_to_viewer")) {
                        zArr[5] = true;
                        zArr2[3] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, jArr[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[1]) {
                flatBufferBuilder.a(3, jArr[1], 0);
            }
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[2]) {
                flatBufferBuilder.a(10, zArr2[0]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(11, zArr2[1]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(12, zArr2[2]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(13, zArr2[3]);
            }
            return flatBufferBuilder.d();
        }

        public static void m13995b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("buyer");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("creation_time");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("modified_time");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("peer_to_peer_platform_item");
                PaymentPlatformItemParser.m14001a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("peer_to_peer_platform_product_item");
                PeerToPeerPlatformProductItemParser.m13993a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("selected_shipping_address");
                MailingAddressInfoParser.m13976b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("selected_shipping_option");
                PaymentShippingOptionParser.m14007a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("seller");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("shipping_options");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    PaymentShippingOptionParser.m14007a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            boolean a2 = mutableFlatBuffer.a(i, 10);
            if (a2) {
                jsonGenerator.a("should_show_pay_button");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 11);
            if (a2) {
                jsonGenerator.a("should_show_to_buyer");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 12);
            if (a2) {
                jsonGenerator.a("should_show_to_seller");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 13);
            if (a2) {
                jsonGenerator.a("should_show_to_viewer");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentPlatformItemParser {

        /* compiled from: held_wakelock_details */
        public final class MerchantLogoParser {
            public static int m13996a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m13997a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: held_wakelock_details */
        public final class PlatformImagesParser {
            public static int m13999b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m13998a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m14000a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[11];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("description")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("item_availability")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLProductAvailability.fromString(jsonParser.o()));
                    } else if (i.equals("item_details")) {
                        iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("merchant_logo")) {
                        iArr[5] = MerchantLogoParser.m13996a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("name")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("platform_images")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(PlatformImagesParser.m13999b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[7] = i2;
                    } else if (i.equals("product_item_price")) {
                        iArr[8] = PaymentCurrencyAmountParser.m13980a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reference_url")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("seller")) {
                        iArr[10] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(11);
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
            return flatBufferBuilder.d();
        }

        public static void m14001a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("item_availability");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("item_details");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("merchant_logo");
                MerchantLogoParser.m13997a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("platform_images");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    PlatformImagesParser.m13998a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("product_item_price");
                PaymentCurrencyAmountParser.m13981a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("reference_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("seller");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentRequestParser {
        public static int m14004b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[11];
            boolean[] zArr = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount")) {
                        iArr[0] = PaymentCurrencyQuantityParser.m13982a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("creation_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("group_thread_fbid")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("memo_text")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("request_status")) {
                        iArr[5] = flatBufferBuilder.a(GraphQLPeerToPeerPaymentRequestStatus.fromString(jsonParser.o()));
                    } else if (i.equals("request_theme")) {
                        iArr[6] = ThemeParser.m14030a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("requestee")) {
                        iArr[7] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("requester")) {
                        iArr[8] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("transfer")) {
                        iArr[9] = PaymentTransactionParser.m14008a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("updated_time")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, jArr[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[1]) {
                flatBufferBuilder.a(10, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m14002a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m14004b(jsonParser, flatBufferBuilder)));
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

        public static void m14003a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m14005b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m14005b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("amount");
                PaymentCurrencyQuantityParser.m13983a(mutableFlatBuffer, g, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("creation_time");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("group_thread_fbid");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("memo_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("request_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 5));
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("request_theme");
                ThemeParser.m14031b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("requestee");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("requester");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("transfer");
                PaymentTransactionParser.m14009b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 10, 0);
            if (a != 0) {
                jsonGenerator.a("updated_time");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentShippingOptionParser {
        public static int m14006a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[4];
            int[] iArr2 = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("currency")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("option_id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("shipping_price")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("subtotal")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("title")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("total")) {
                        zArr[2] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("total_tax")) {
                        zArr[3] = true;
                        iArr2[3] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(3, iArr2[1], 0);
            }
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, iArr2[2], 0);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(6, iArr2[3], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m14007a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("option_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("shipping_price");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("subtotal");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5, 0);
            if (a != 0) {
                jsonGenerator.a("total");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 6, 0);
            if (a != 0) {
                jsonGenerator.a("total_tax");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentTransactionParser {
        public static int m14008a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[3];
            long[] jArr = new long[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("amount")) {
                        iArr[1] = PaymentCurrencyQuantityParser.m13982a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("amount_fb_discount")) {
                        iArr[2] = PaymentCurrencyQuantityParser.m13982a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("commerce_order")) {
                        iArr[3] = CommerceOrderParser.m13952a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("completed_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_time")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("id")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("order_id")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("platform_item")) {
                        iArr[8] = PlatformItemParser.m14020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("receiver_profile")) {
                        iArr[9] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("receiver_status")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLPeerToPeerTransferReceiverStatus.fromString(jsonParser.o()));
                    } else if (i.equals("sender")) {
                        iArr[11] = PaymentUserParser.m14014a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sender_status")) {
                        iArr[12] = flatBufferBuilder.a(GraphQLPeerToPeerTransferSenderStatus.fromString(jsonParser.o()));
                    } else if (i.equals("transfer_context")) {
                        iArr[13] = TransferContextParser.m14032a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("updated_time")) {
                        zArr[2] = true;
                        jArr[2] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, jArr[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, jArr[1], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            if (zArr[2]) {
                flatBufferBuilder.a(14, jArr[2], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m14009b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("amount");
                PaymentCurrencyQuantityParser.m13983a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("amount_fb_discount");
                PaymentCurrencyQuantityParser.m13983a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("commerce_order");
                CommerceOrderParser.m13953a(mutableFlatBuffer, g, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("completed_time");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5, 0);
            if (a != 0) {
                jsonGenerator.a("creation_time");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("order_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("platform_item");
                PlatformItemParser.m14021a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("receiver_profile");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("receiver_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("sender");
                PaymentUserParser.m14015a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("sender_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("transfer_context");
                TransferContextParser.m14033a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 14, 0);
            if (a != 0) {
                jsonGenerator.a("updated_time");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentTransactionsParser {

        /* compiled from: held_wakelock_details */
        public final class PageInfoParser {
            public static int m14010a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("has_next_page")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                return flatBufferBuilder.d();
            }

            public static void m14011a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("has_next_page");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m14012a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("nodes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(PaymentTransactionParser.m14008a(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("page_info")) {
                        iArr[1] = PageInfoParser.m14010a(jsonParser, flatBufferBuilder);
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

        public static void m14013a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    PaymentTransactionParser.m14009b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                PageInfoParser.m14011a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PaymentUserParser {
        public static int m14014a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_messenger_user")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static void m14015a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("is_messenger_user");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class PlatformItemParser {

        /* compiled from: held_wakelock_details */
        public final class PhotosParser {

            /* compiled from: held_wakelock_details */
            public final class ImageParser {
                public static int m14016a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m14017a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m14018b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("image")) {
                            iArr[0] = ImageParser.m14016a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m14019b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m14017a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m14020a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("description")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photos")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(PhotosParser.m14018b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[3] = i2;
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

        public static void m14021a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            int g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("photos");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    PhotosParser.m14019b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class StreetAddressInfoParser {
        public static int m14022a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("addressee")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("building")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("city")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("country")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("postal_code")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("street")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            return flatBufferBuilder.d();
        }

        public static void m14023a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("addressee");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("building");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("city");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("country");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("postal_code");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("street");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class ThemeAssetParser {

        /* compiled from: held_wakelock_details */
        public final class ImageParser {
            public static int m14024a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m14025a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m14026b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("asset_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLMessengerPayThemeAssetTypeEnum.fromString(jsonParser.o()));
                    } else if (i.equals("compatible_with")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[2] = ImageParser.m14024a(jsonParser, flatBufferBuilder);
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

        public static void m14027b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("asset_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("compatible_with");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("image");
                ImageParser.m14025a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class ThemeParser {

        /* compiled from: held_wakelock_details */
        public final class AssetsParser {
            public static int m14028a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(ThemeAssetParser.m14026b(jsonParser, flatBufferBuilder)));
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

            public static void m14029a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ThemeAssetParser.m14027b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m14030a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("assets")) {
                        iArr[0] = AssetsParser.m14028a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
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

        public static void m14031b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("assets");
                AssetsParser.m14029a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("category");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: held_wakelock_details */
    public final class TransferContextParser {
        public static int m14032a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("memo_text")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("transfer_theme")) {
                        iArr[1] = ThemeParser.m14030a(jsonParser, flatBufferBuilder);
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

        public static void m14033a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("memo_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("transfer_theme");
                ThemeParser.m14031b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
