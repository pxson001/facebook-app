package com.facebook.messaging.business.airline.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.LogoImageParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineFlightInfoParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlinePassengerSegmentDetailParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: thread_list_context_menu */
public class AirlineQueryFragmentsParsers {

    /* compiled from: thread_list_context_menu */
    public final class AirlineItineraryParser {

        /* compiled from: thread_list_context_menu */
        public final class ItemizedPriceInfosParser {
            public static int m1534b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("formatted_amount")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
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

            public static void m1533a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("formatted_amount");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: thread_list_context_menu */
        public final class ItineraryLegsParser {

            /* compiled from: thread_list_context_menu */
            public final class NodesParser {

                /* compiled from: thread_list_context_menu */
                public final class SegmentsParser {

                    /* compiled from: thread_list_context_menu */
                    public final class SegmentsNodesParser {
                        public static int m1535b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("flight_info")) {
                                        iArr[0] = AirlineFlightInfoParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("passenger_details")) {
                                        int i2 = 0;
                                        ArrayList arrayList = new ArrayList();
                                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                arrayList.add(Integer.valueOf(AirlinePassengerSegmentDetailParser.a(jsonParser, flatBufferBuilder)));
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

                        public static void m1536b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("flight_info");
                                AirlineFlightInfoParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("passenger_details");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    AirlinePassengerSegmentDetailParser.b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m1537a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                            arrayList.add(Integer.valueOf(SegmentsNodesParser.m1535b(jsonParser, flatBufferBuilder)));
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

                    public static void m1538a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("nodes");
                            jsonGenerator.d();
                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                SegmentsNodesParser.m1536b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                            }
                            jsonGenerator.e();
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m1539b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("segments")) {
                                iArr[0] = SegmentsParser.m1537a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m1540b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("segments");
                        SegmentsParser.m1538a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m1541a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m1539b(jsonParser, flatBufferBuilder)));
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

            public static void m1542a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m1540b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m1543a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[23];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("aircraft_type_label")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("arrival_time_label")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("base_price_label")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("booking_number_label")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("cabin_type_label")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("departure_time_label")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_date_label")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_label")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("flight_terminal_label")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("formatted_base_price")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("formatted_tax")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("formatted_total")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("itemized_price_infos")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(ItemizedPriceInfosParser.m1534b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[13] = i2;
                    } else if (i.equals("itinerary_legs")) {
                        iArr[14] = ItineraryLegsParser.m1541a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logo")) {
                        iArr[15] = LogoImageParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("passenger_names_label")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("passenger_seat_label")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("pnr_number")) {
                        iArr[18] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("purchase_summary_label")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("taxes_label")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tint_color")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("total_label")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(23);
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
            return flatBufferBuilder.d();
        }

        public static void m1544a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("aircraft_type_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("arrival_time_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("base_price_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("booking_number_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("cabin_type_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("departure_time_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("flight_date_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("flight_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("flight_terminal_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("formatted_base_price");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("formatted_tax");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("formatted_total");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            int g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("itemized_price_infos");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ItemizedPriceInfosParser.m1533a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("itinerary_legs");
                ItineraryLegsParser.m1542a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("logo");
                LogoImageParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("passenger_names_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("passenger_seat_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("pnr_number");
                jsonGenerator.b(mutableFlatBuffer.c(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("purchase_summary_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("taxes_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("tint_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("total_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            jsonGenerator.g();
        }
    }
}
