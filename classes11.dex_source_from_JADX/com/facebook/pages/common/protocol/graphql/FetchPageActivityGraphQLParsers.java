package com.facebook.pages.common.protocol.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAdproLimitResetPeriod;
import com.facebook.graphql.enums.GraphQLBoostedActionStatus;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageActivityFeedType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.PageLikersParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: setPageWithoutAnimation */
public class FetchPageActivityGraphQLParsers {

    /* compiled from: setPageWithoutAnimation */
    public final class FetchPageActivityQueryParser {

        /* compiled from: setPageWithoutAnimation */
        public final class ActivityAdminInfoParser {

            /* compiled from: setPageWithoutAnimation */
            public final class AllDraftPostsParser {
                public static int m2786a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m2787a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setPageWithoutAnimation */
            public final class AllScheduledPostsParser {
                public static int m2788a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m2789a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setPageWithoutAnimation */
            public final class BoostedLocalAwarenessPromotionsParser {

                /* compiled from: setPageWithoutAnimation */
                public final class NodesParser {
                    public static int m2791b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("boosting_status")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m2790a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("boosting_status");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m2792a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(NodesParser.m2791b(jsonParser, flatBufferBuilder)));
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

                public static void m2793a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            NodesParser.m2790a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setPageWithoutAnimation */
            public final class BoostedPageLikePromotionInfoParser {
                public static int m2794a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[9];
                    boolean[] zArr = new boolean[5];
                    boolean[] zArr2 = new boolean[1];
                    int[] iArr2 = new int[2];
                    long[] jArr = new long[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("boosting_status")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLBoostedActionStatus.fromString(jsonParser.o()));
                            } else if (i.equals("budget")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("has_editable_promotion")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("kpi")) {
                                zArr[1] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("reach")) {
                                zArr[2] = true;
                                iArr2[1] = jsonParser.E();
                            } else if (i.equals("reset_period")) {
                                iArr[5] = flatBufferBuilder.a(GraphQLAdproLimitResetPeriod.fromString(jsonParser.o()));
                            } else if (i.equals("spent")) {
                                iArr[6] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("start_time")) {
                                zArr[3] = true;
                                jArr[0] = jsonParser.F();
                            } else if (i.equals("stop_time")) {
                                zArr[4] = true;
                                jArr[1] = jsonParser.F();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(3, iArr2[0], 0);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(4, iArr2[1], 0);
                    }
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    if (zArr[3]) {
                        flatBufferBuilder.a(7, jArr[0], 0);
                    }
                    if (zArr[4]) {
                        flatBufferBuilder.a(8, jArr[1], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m2795a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("boosting_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("budget");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    boolean a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("has_editable_promotion");
                        jsonGenerator.a(a);
                    }
                    int a2 = mutableFlatBuffer.a(i, 3, 0);
                    if (a2 != 0) {
                        jsonGenerator.a("kpi");
                        jsonGenerator.b(a2);
                    }
                    a2 = mutableFlatBuffer.a(i, 4, 0);
                    if (a2 != 0) {
                        jsonGenerator.a("reach");
                        jsonGenerator.b(a2);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("reset_period");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                    }
                    if (mutableFlatBuffer.g(i, 6) != 0) {
                        jsonGenerator.a("spent");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                    }
                    long a3 = mutableFlatBuffer.a(i, 7, 0);
                    if (a3 != 0) {
                        jsonGenerator.a("start_time");
                        jsonGenerator.a(a3);
                    }
                    a3 = mutableFlatBuffer.a(i, 8, 0);
                    if (a3 != 0) {
                        jsonGenerator.a("stop_time");
                        jsonGenerator.a(a3);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setPageWithoutAnimation */
            public final class PageContactUsLeadsParser {
                public static int m2796a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m2797a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setPageWithoutAnimation */
            public final class PageInsightsSummaryParser {
                public static int m2798a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[2];
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("weekly_new_likes")) {
                                zArr[0] = true;
                                iArr[0] = jsonParser.E();
                            } else if (i.equals("weekly_post_reach")) {
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

                public static void m2799a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("weekly_new_likes");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 1, 0);
                    if (a != 0) {
                        jsonGenerator.a("weekly_post_reach");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m2800a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[10];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("all_draft_posts")) {
                            iArr[0] = AllDraftPostsParser.m2786a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_scheduled_posts")) {
                            iArr[1] = AllScheduledPostsParser.m2788a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("boosted_local_awareness_promotion_status_description")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("boosted_local_awareness_promotions")) {
                            iArr[3] = BoostedLocalAwarenessPromotionsParser.m2792a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("boosted_page_like_promotion_info")) {
                            iArr[4] = BoostedPageLikePromotionInfoParser.m2794a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("boosted_page_like_promotion_status_description")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("can_viewer_promote_for_page_likes")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_promote_local_awareness")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("page_contact_us_leads")) {
                            iArr[8] = PageContactUsLeadsParser.m2796a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_insights_summary")) {
                            iArr[9] = PageInsightsSummaryParser.m2798a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[0]) {
                    flatBufferBuilder.a(6, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(7, zArr2[1]);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                return flatBufferBuilder.d();
            }

            public static void m2801a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("all_draft_posts");
                    AllDraftPostsParser.m2787a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("all_scheduled_posts");
                    AllScheduledPostsParser.m2789a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("boosted_local_awareness_promotion_status_description");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("boosted_local_awareness_promotions");
                    BoostedLocalAwarenessPromotionsParser.m2793a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("boosted_page_like_promotion_info");
                    BoostedPageLikePromotionInfoParser.m2795a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("boosted_page_like_promotion_status_description");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                boolean a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("can_viewer_promote_for_page_likes");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("can_viewer_promote_local_awareness");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("page_contact_us_leads");
                    PageContactUsLeadsParser.m2797a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("page_insights_summary");
                    PageInsightsSummaryParser.m2799a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: setPageWithoutAnimation */
        public final class ActivityFeedsParser {
            public static int m2804b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("feed_type_enum")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLPageActivityFeedType.fromString(jsonParser.o()));
                        } else if (i.equals("unread_count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m2802a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m2804b(jsonParser, flatBufferBuilder)));
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

            public static void m2803a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("feed_type_enum");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("unread_count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: setPageWithoutAnimation */
        public final class PageCallToActionParser {

            /* compiled from: setPageWithoutAnimation */
            public final class CtaAdminInfoParser {
                public static int m2805a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("create_prompt")) {
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

                public static void m2806a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("create_prompt");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m2807a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cta_admin_info")) {
                            iArr[0] = CtaAdminInfoParser.m2805a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cta_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLPageCallToActionType.fromString(jsonParser.o()));
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

            public static void m2808a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("cta_admin_info");
                    CtaAdminInfoParser.m2806a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("cta_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m2809a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[12];
            boolean[] zArr = new boolean[5];
            boolean[] zArr2 = new boolean[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("activity_admin_info")) {
                        iArr[1] = ActivityAdminInfoParser.m2800a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("activity_feeds")) {
                        iArr[2] = ActivityFeedsParser.m2802a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("admin_info")) {
                        iArr[3] = AdminInfoParser.m3731a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page_call_to_action")) {
                        iArr[5] = PageCallToActionParser.m2807a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_likers")) {
                        iArr[6] = PageLikersParser.m3733a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_show_recent_activity_entry_point")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("should_show_recent_checkins_entry_point")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("should_show_recent_mentions_entry_point")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("should_show_recent_reviews_entry_point")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("should_show_recent_shares_entry_point")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[0]) {
                flatBufferBuilder.a(7, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(8, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(10, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(11, zArr2[4]);
            }
            return flatBufferBuilder.d();
        }
    }
}
