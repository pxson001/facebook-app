package com.facebook.messaging.rtc.adminmsg.model;

import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.AttachmentPropertiesModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.AttachmentPropertiesModel.ValueModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.sync.model.thrift.DeltaRTCEventLog;
import com.facebook.messaging.sync.model.thrift.MessageMetadata;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: unliked */
public class RTCAdminMsgXMAConverter {

    /* compiled from: unliked */
    public class CallLogSnippet {
        public String f2439a;
        public long f2440b;
        public long f2441c;
        public TriState f2442d = TriState.UNSET;
        public TriState f2443e = TriState.UNSET;
        public TriState f2444f = TriState.UNSET;
        public TriState f2445g = TriState.UNSET;
    }

    public static XMAModel m3659a(String str, String str2, long j, JsonNode jsonNode) {
        boolean z = false;
        long j2 = 0;
        if (jsonNode.b("c_s") != null) {
            j = jsonNode.b("c_s").D();
        }
        if (jsonNode.b("c_d") != null) {
            j2 = jsonNode.b("c_d").D();
        }
        if (jsonNode.b("c_t") != null) {
            int b = jsonNode.b("c_t").b(3);
            if (!(b == 3 || b == 4)) {
                z = true;
            }
        }
        return m3660a(str, str2, str2, Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j));
    }

    public static CallLogSnippet m3661a(DeltaRTCEventLog deltaRTCEventLog) {
        MessageMetadata messageMetadata = deltaRTCEventLog.messageMetadata;
        String str = null;
        if (messageMetadata.threadKey.otherUserFbId != null) {
            str = messageMetadata.threadKey.otherUserFbId.toString();
        }
        CallLogSnippet callLogSnippet = new CallLogSnippet();
        callLogSnippet.f2442d = TriState.valueOf(deltaRTCEventLog.answered);
        callLogSnippet.f2439a = str;
        callLogSnippet.f2440b = deltaRTCEventLog.startTime.longValue();
        callLogSnippet.f2441c = deltaRTCEventLog.duration.longValue();
        callLogSnippet.f2445g = TriState.valueOf(deltaRTCEventLog.acknowledged);
        return callLogSnippet;
    }

    public static XMAModel m3663b(DeltaRTCEventLog deltaRTCEventLog) {
        MessageMetadata messageMetadata = deltaRTCEventLog.messageMetadata;
        String str = null;
        if (messageMetadata.threadKey.otherUserFbId != null) {
            str = messageMetadata.threadKey.otherUserFbId.toString();
        }
        return m3660a(messageMetadata.adminText, messageMetadata.actorFbId.toString(), str, deltaRTCEventLog.answered, deltaRTCEventLog.duration, deltaRTCEventLog.startTime);
    }

    public static XMAModel m3658a(JsonNode jsonNode) {
        Long l;
        Long l2;
        Boolean bool;
        String str;
        String str2;
        if (jsonNode.b("log_message") == null || jsonNode.b("log_message").b("callLog") == null) {
            l = null;
            l2 = null;
            bool = null;
            str = null;
            str2 = null;
        } else {
            Boolean valueOf;
            Long valueOf2;
            JsonNode b = jsonNode.b("log_message").b("callLog");
            str = JSONUtil.a(b.b("type"), "");
            String b2 = JSONUtil.b(jsonNode.b("body"));
            if (jsonNode.b("sender") != null) {
                str2 = JSONUtil.b(jsonNode.b("sender").b("user_id"));
            } else {
                str2 = null;
            }
            if (str.equals("incoming") || str.equals("outgoing")) {
                valueOf = Boolean.valueOf(true);
            } else if (str.equals("missed") || str.equals("cancelled")) {
                valueOf = Boolean.valueOf(false);
            } else {
                valueOf = null;
            }
            if (b.b("duration") != null) {
                valueOf2 = Long.valueOf(b.b("duration").D());
            } else {
                valueOf2 = null;
            }
            Long l3;
            if (b.b("startTime") != null) {
                l = Long.valueOf(b.b("startTime").D());
                l3 = valueOf2;
                bool = valueOf;
                str = str2;
                str2 = b2;
                l2 = l3;
            } else if (jsonNode.b("timestamp") != null) {
                l = Long.valueOf(jsonNode.b("timestamp").D());
                l3 = valueOf2;
                bool = valueOf;
                str = str2;
                str2 = b2;
                l2 = l3;
            } else {
                l = null;
                l3 = valueOf2;
                bool = valueOf;
                str = str2;
                str2 = b2;
                l2 = l3;
            }
        }
        return m3660a(str2, str, null, bool, l2, l);
    }

    public static XMAModel m3657a(MessageInfoModel messageInfoModel, @Nullable String str) {
        return m3660a(messageInfoModel.m2148E(), messageInfoModel.m2173x().m2861j().m2855b(), str, Boolean.valueOf(messageInfoModel.m2160k()), Long.valueOf((long) messageInfoModel.m2165p()), Long.valueOf(messageInfoModel.m2150G()));
    }

    public static XMAModel m3662b(MessageInfoModel messageInfoModel, @Nullable String str) {
        return m3660a(messageInfoModel.m2148E(), messageInfoModel.m2173x().m2861j().m2855b(), str, Boolean.valueOf(messageInfoModel.m2159j()), Long.valueOf((long) messageInfoModel.m2164o()), Long.valueOf(messageInfoModel.m2149F()));
    }

    private static XMAModel m3660a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Long l, @Nullable Long l2) {
        ImmutableList of = ImmutableList.of(GraphQLStoryAttachmentStyle.RTC_CALL_LOG);
        Builder builder = new Builder();
        if (str2 != null) {
            AttachmentPropertiesModel.Builder builder2 = new AttachmentPropertiesModel.Builder();
            builder2.f1592b = "senderID";
            builder2 = builder2;
            ValueModel.Builder builder3 = new ValueModel.Builder();
            builder3.f1595a = str2;
            builder2.f1594d = builder3.m2528a();
            builder.c(builder2.m2525a());
        }
        if (str3 != null) {
            builder2 = new AttachmentPropertiesModel.Builder();
            builder2.f1592b = "peerUserID";
            builder2 = builder2;
            builder3 = new ValueModel.Builder();
            builder3.f1595a = str3;
            builder2.f1594d = builder3.m2528a();
            builder.c(builder2.m2525a());
        }
        if (bool != null) {
            builder2 = new AttachmentPropertiesModel.Builder();
            builder2.f1592b = "answered";
            builder2 = builder2;
            builder3 = new ValueModel.Builder();
            builder3.f1595a = bool.toString();
            builder2.f1594d = builder3.m2528a();
            builder.c(builder2.m2525a());
        }
        if (l != null) {
            builder2 = new AttachmentPropertiesModel.Builder();
            builder2.f1592b = "duration";
            builder2 = builder2;
            builder3 = new ValueModel.Builder();
            builder3.f1595a = l.toString();
            builder2.f1594d = builder3.m2528a();
            builder.c(builder2.m2525a());
        }
        if (l2 != null) {
            builder2 = new AttachmentPropertiesModel.Builder();
            builder2.f1592b = "timestamp";
            builder2 = builder2;
            builder3 = new ValueModel.Builder();
            builder3.f1595a = l2.toString();
            builder2.f1594d = builder3.m2528a();
            builder.c(builder2.m2525a());
        }
        ImmutableList b = builder.b();
        XMAAttachmentStoryFieldsModel.Builder builder4 = new XMAAttachmentStoryFieldsModel.Builder();
        builder4.f1611k = str;
        builder4 = builder4;
        builder4.f1607g = of;
        XMAAttachmentStoryFieldsModel.Builder builder5 = builder4;
        builder5.f1602b = b;
        XMAAttachmentStoryFieldsModel a = builder5.m2543a();
        XMAModel.Builder builder6 = new XMAModel.Builder();
        builder6.f1650d = a;
        return builder6.m2592a();
    }
}
