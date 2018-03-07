package com.facebook.messaging.analytics.reliability;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.common.netchecker.NetChecker;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageAttachmentInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.push.mqtt.service.ConnectionState;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ListMultimap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_history_get_more_request */
public class MessagesReliabilityLogger {
    private final FbAppType f7653a;
    private final NetChecker f7654b;
    private final LoggerMapUtils f7655c;
    private final Clock f7656d;
    private final MonotonicClock f7657e;
    public final ReliabilityAnalyticsLogger f7658f;
    public final Provider<Boolean> f7659g;

    public static MessagesReliabilityLogger m7941b(InjectorLike injectorLike) {
        return new MessagesReliabilityLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), NetChecker.a(injectorLike), LoggerMapUtils.b(injectorLike), ReliabilityAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 4042));
    }

    public static MessagesReliabilityLogger m7934a(InjectorLike injectorLike) {
        return m7941b(injectorLike);
    }

    @Inject
    public MessagesReliabilityLogger(Clock clock, MonotonicClock monotonicClock, FbAppType fbAppType, NetChecker netChecker, LoggerMapUtils loggerMapUtils, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, Provider<Boolean> provider) {
        this.f7656d = clock;
        this.f7657e = monotonicClock;
        this.f7653a = fbAppType;
        this.f7654b = netChecker;
        this.f7655c = loggerMapUtils;
        this.f7658f = reliabilityAnalyticsLogger;
        this.f7659g = provider;
    }

    public final void m7948a(Mark mark, MarkThreadFields markThreadFields, NetworkChannel networkChannel) {
        this.f7658f.a("mark_thread", null, LoggerMapUtils.a(new String[]{"mark_type", mark.getApiName(), "state", String.valueOf(markThreadFields.f17205b), "request_action_id", String.valueOf(markThreadFields.f17206c), "channel", networkChannel.channelName}), null, null, null);
    }

    public final void m7953a(SendMessageParams sendMessageParams, MessageAttachmentInfo messageAttachmentInfo, String str, int i, ConnectionState connectionState, boolean z) {
        Message message = sendMessageParams.f17308a;
        Map a = LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "reason", str, "mqtt_back_to_back_attempt_number", Integer.toString(i), "initial_mqtt_push_state", connectionState.toString(), "network_connected", Boolean.toString(z), "channel", NetworkChannel.MQTT.channelName, "retry_count", Integer.toString(sendMessageParams.f17311d), "first_send_delta", m7936a(sendMessageParams.f17312e), "first_message_first_send_delta", m7936a(sendMessageParams.f17313f)});
        m7938a(a, messageAttachmentInfo, false);
        this.f7658f.a("msg_cant_send_via_mqtt", null, a, null, null, null);
    }

    public final void m7954a(SendMessageParams sendMessageParams, MessageAttachmentInfo messageAttachmentInfo, boolean z, NetworkChannel networkChannel) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            Map a = LoggerMapUtils.a(new String[]{"offline_threading_id", sendMessageParams.f17308a.n, "current_time", m7935a(), "network_connected", Boolean.toString(z), "channel", networkChannel.channelName, "retry_count", Integer.toString(sendMessageParams.f17311d), "first_send_delta", m7936a(sendMessageParams.f17312e), "first_message_first_send_delta", m7936a(sendMessageParams.f17313f)});
            m7939a(a, r0.b);
            m7938a(a, messageAttachmentInfo, true);
            this.f7655c.a(a);
            this.f7658f.a("msg_send_attempted", null, a, null, null, null);
        }
    }

    public final void m7945a(Message message, String str, @Nullable NavigationTrigger navigationTrigger) {
        String[] strArr = new String[6];
        strArr[0] = "offline_threading_id";
        strArr[1] = message.n;
        strArr[2] = "current_time";
        strArr[3] = m7935a();
        strArr[4] = "trigger";
        strArr[5] = navigationTrigger == null ? null : navigationTrigger.toString();
        Map a = LoggerMapUtils.a(strArr);
        m7939a(a, message.b);
        this.f7655c.a(a);
        this.f7658f.a("msg_send_click", null, a, null, null, str);
    }

    public final void m7946a(ThreadKey threadKey, long j, Throwable th) {
        Map a = LoggerMapUtils.a(new String[]{"since_action_id", Long.toString(j), "error_type", th.getClass().getName(), "error_message", th.getMessage(), "channel", NetworkChannel.GRAPH.channelName});
        m7939a(a, threadKey);
        this.f7655c.a(a);
        this.f7658f.a("fetch_thread_failure", null, a, null, null, null);
    }

    public final void m7944a(Message message, MessageAttachmentInfo messageAttachmentInfo, NetworkChannel networkChannel) {
        Map a = LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "current_time", m7935a(), "channel", networkChannel.channelName});
        m7938a(a, messageAttachmentInfo, false);
        this.f7655c.a(a);
        this.f7658f.a("msg_create_thread_attempted", null, a, null, null, null);
    }

    public final void m7947a(ThreadKey threadKey, Message message, long j, MessageAttachmentInfo messageAttachmentInfo, NetworkChannel networkChannel) {
        Map a = LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "sent_timestamp_ms", Long.toString(message.d), "send_time_delta", Long.toString(j), "total_attachment_size", Long.toString(messageAttachmentInfo.a), "current_time", m7935a(), "channel", networkChannel.channelName});
        m7939a(a, threadKey);
        this.f7658f.a("create_thread", "success", a, null, null, null);
    }

    public final void m7943a(Message message, long j, MessageAttachmentInfo messageAttachmentInfo, SendMessageException sendMessageException, NetworkChannel networkChannel) {
        this.f7658f.b("create_thread", "failed", LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "sent_timestamp_ms", Long.toString(message.d), "send_time_delta", Long.toString(j), "error_type", sendMessageException.m16838b().toString(), "error_message", sendMessageException.getMessage(), "total_attachment_size", Long.toString(messageAttachmentInfo.a), "current_time", m7935a(), "channel", networkChannel.channelName}), null, null, null);
    }

    public final void m7952a(SendMessageParams sendMessageParams, long j, MessageAttachmentInfo messageAttachmentInfo, String str, int i, boolean z, @Nullable ConnectionState connectionState, @Nullable ConnectionState connectionState2, boolean z2, NetworkChannel networkChannel, boolean z3) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            Message message = sendMessageParams.f17308a;
            String str2 = "messaging_send_" + str;
            Map a = this.f7655c.a(m7942c(message), new String[]{"offline_threading_id", message.n, "sent_timestamp_ms", Long.toString(message.d), "send_time_delta", Long.toString(j), "current_time", m7935a(), "mqtt_back_to_back_attempt_number", Integer.toString(i), "showed_optimistic_send", Boolean.toString(z), "channel", networkChannel.channelName, "network_connected", Boolean.toString(z2), "retry_count", Integer.toString(sendMessageParams.f17311d), "first_send_delta", m7936a(sendMessageParams.f17312e), "first_message_first_send_delta", m7936a(sendMessageParams.f17313f), "success_from_delta", Boolean.toString(z3)});
            m7939a(a, message.b);
            m7938a(a, messageAttachmentInfo, false);
            if (connectionState != null) {
                a.put("initial_mqtt_push_state", connectionState.toString());
            }
            if (connectionState2 != null) {
                a.put("mqtt_push_state", connectionState2.toString());
            }
            this.f7658f.a(str2, "success", a, null, null, null);
        }
    }

    public final void m7951a(SendMessageParams sendMessageParams, long j, MessageAttachmentInfo messageAttachmentInfo, String str, int i, boolean z, @Nullable ConnectionState connectionState, @Nullable ConnectionState connectionState2, boolean z2, int i2, boolean z3) {
        String connectionState3;
        boolean z4;
        Message message = sendMessageParams.f17308a;
        String str2 = "messaging_send_via_mqtt";
        String[] strArr = new String[36];
        strArr[0] = "offline_threading_id";
        strArr[1] = message.n;
        strArr[2] = "sent_timestamp_ms";
        strArr[3] = Long.toString(message.d);
        strArr[4] = "send_time_delta";
        strArr[5] = Long.toString(j);
        strArr[6] = "error_message";
        strArr[7] = str;
        strArr[8] = "error_number";
        strArr[9] = Integer.toString(i);
        strArr[10] = "initial_mqtt_push_state";
        if (connectionState != null) {
            connectionState3 = connectionState.toString();
        } else {
            connectionState3 = "UNKNOWN";
        }
        strArr[11] = connectionState3;
        strArr[12] = "mqtt_push_state";
        if (connectionState2 != null) {
            connectionState3 = connectionState2.toString();
        } else {
            connectionState3 = "UNKNOWN";
        }
        strArr[13] = connectionState3;
        strArr[14] = "network_connected";
        strArr[15] = Boolean.toString(z2);
        strArr[16] = "current_time";
        strArr[17] = m7935a();
        strArr[18] = "mqtt_back_to_back_attempt_number";
        strArr[19] = Integer.toString(i2);
        strArr[20] = "is_retriable";
        if (z) {
            z4 = false;
        } else {
            z4 = true;
        }
        strArr[21] = Boolean.toString(z4);
        strArr[22] = "showed_optimistic_send";
        strArr[23] = Boolean.toString(z3);
        strArr[24] = "channel";
        strArr[25] = NetworkChannel.MQTT.channelName;
        strArr[26] = "netcheck_state";
        strArr[27] = this.f7654b.c().toString();
        strArr[28] = "last_netcheck_time";
        strArr[29] = Long.toString(this.f7654b.d());
        strArr[30] = "retry_count";
        strArr[31] = Integer.toString(sendMessageParams.f17311d);
        strArr[32] = "first_send_delta";
        strArr[33] = m7936a(sendMessageParams.f17312e);
        strArr[34] = "first_message_first_send_delta";
        strArr[35] = m7936a(sendMessageParams.f17313f);
        Map a = LoggerMapUtils.a(strArr);
        m7939a(a, message.b);
        m7938a(a, messageAttachmentInfo, false);
        this.f7658f.b(str2, "failed", a, null, null, null);
    }

    public final void m7950a(SendMessageParams sendMessageParams, long j, MessageAttachmentInfo messageAttachmentInfo, SendMessageException sendMessageException, boolean z, String str) {
        Message message = sendMessageParams.f17308a;
        String str2 = "messaging_send_" + str;
        Map a = this.f7655c.a(m7942c(message), new String[]{"offline_threading_id", message.n, "sent_timestamp_ms", Long.toString(message.d), "send_time_delta", Long.toString(j), "error_type", sendMessageException.m16838b().toString(), "error_message", sendMessageException.getMessage(), "current_time", m7935a(), "network_connected", Boolean.toString(z), "channel", NetworkChannel.GRAPH.channelName, "netcheck_state", this.f7654b.c().toString(), "last_netcheck_time", Long.toString(this.f7654b.d()), "retry_count", Integer.toString(sendMessageParams.f17311d), "first_send_delta", m7936a(sendMessageParams.f17312e), "first_message_first_send_delta", m7936a(sendMessageParams.f17313f)});
        m7939a(a, message.b);
        m7938a(a, messageAttachmentInfo, false);
        if (this.f7653a.g() != IntendedAudience.PUBLIC) {
            a.put("stack_trace", ExceptionUtil.a(sendMessageException));
        } else if (sendMessageException.getCause() instanceof NullPointerException) {
            a.put("stack_trace", ExceptionUtil.a(sendMessageException.getCause()));
        }
        this.f7658f.b(str2, "failed", a, null, null, null);
    }

    public final void m7949a(SendMessageParams sendMessageParams, long j) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            Message message = sendMessageParams.f17308a;
            Map a = this.f7655c.a(m7942c(message), new String[]{"offline_threading_id", message.n, "sent_timestamp_ms", Long.toString(message.d), "send_time_delta", Long.toString(j), "current_time", m7935a(), "channel", NetworkChannel.MQTT.channelName, "retry_count", Integer.toString(sendMessageParams.f17311d), "first_send_delta", m7936a(sendMessageParams.f17312e), "first_message_first_send_delta", m7936a(sendMessageParams.f17313f)});
            m7939a(a, message.b);
            this.f7658f.a("messaging_pub_ack", "success_puback", a, null, null, null);
        }
    }

    public final void m7957a(String str, @Nullable ThreadKey threadKey, String str2, @Nullable String str3, String str4) {
        Map a = LoggerMapUtils.a(new String[0]);
        m7939a(a, threadKey);
        this.f7658f.a(str2, str3, str4, a, "message_id", str);
    }

    public final void m7958a(String str, String str2, long j, String str3) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            this.f7658f.a("messaging_received_delay", null, LoggerMapUtils.a(new String[]{"earlier_source", str, "later_source", str2, "delay_ms", Long.toString(j), "message_id", str3}), null, null, null);
        }
    }

    public final void m7956a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams, MessageAttachmentInfo messageAttachmentInfo, boolean z, NetworkChannel networkChannel) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            Map a = LoggerMapUtils.a(new String[]{"offline_threading_id", sendMessageToPendingThreadParams.f17320a.n, "current_time", m7935a(), "network_connected", Boolean.toString(z), "channel", networkChannel.channelName});
            m7939a(a, r0.b);
            m7938a(a, messageAttachmentInfo, true);
            this.f7655c.a(a);
            this.f7658f.a("msg_send_attempted", null, a, null, null, null);
        }
    }

    public final void m7955a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams, long j, MessageAttachmentInfo messageAttachmentInfo, String str, int i, boolean z, NetworkChannel networkChannel) {
        if (!((Boolean) this.f7659g.get()).booleanValue()) {
            Message a = sendMessageToPendingThreadParams.m17189a();
            String str2 = "messaging_send_" + str;
            Map a2 = this.f7655c.a(m7942c(a), new String[]{"offline_threading_id", a.n, "sent_timestamp_ms", Long.toString(a.d), "send_time_delta", Long.toString(j), "current_time", m7935a(), "mqtt_back_to_back_attempt_number", Integer.toString(i), "channel", networkChannel.channelName, "network_connected", Boolean.toString(z)});
            m7939a(a2, a.b);
            m7938a(a2, messageAttachmentInfo, false);
            this.f7658f.a(str2, "success", a2, null, null, null);
        }
    }

    private ImmutableMap<String, String> m7942c(Message message) {
        String str = "client_tag_";
        ImmutableMap immutableMap = message.v;
        Builder builder = ImmutableMap.builder();
        if (immutableMap != null) {
            for (Entry entry : immutableMap.entrySet()) {
                builder.b(str + ((String) entry.getKey()), entry.getValue());
            }
        }
        return builder.b();
    }

    public static void m7939a(Map<String, String> map, ThreadKey threadKey) {
        if (threadKey != null) {
            if (threadKey.a == Type.GROUP) {
                map.put("thread_fbid", Long.toString(threadKey.b));
            } else if (threadKey.a == Type.ONE_TO_ONE) {
                map.put("user_fbid", Long.toString(threadKey.d));
            } else if (threadKey.a == Type.SMS) {
                map.put("sms_tid", Long.toString(threadKey.b));
            } else if (threadKey.a == Type.PENDING_THREAD) {
                map.put("pending_tid", Long.toString(threadKey.c));
            }
        }
    }

    private static void m7940a(Map<String, String> map, String str, long j) {
        if (j > 0) {
            map.put(str, Long.toString(j));
        }
    }

    private void m7938a(Map<String, String> map, MessageAttachmentInfo messageAttachmentInfo, boolean z) {
        m7940a((Map) map, "total_attachment_size", messageAttachmentInfo.a);
        m7940a((Map) map, "photo_attachment_count", (long) messageAttachmentInfo.b);
        m7940a((Map) map, "video_attachment_count", (long) messageAttachmentInfo.c);
        m7940a((Map) map, "audio_attachment_count", (long) messageAttachmentInfo.d);
        m7940a((Map) map, "sticker_attachment_count", (long) messageAttachmentInfo.e);
        m7940a((Map) map, "like_attachment_count", (long) messageAttachmentInfo.f);
        m7940a((Map) map, "share_attachment_count", (long) messageAttachmentInfo.g);
        if (!messageAttachmentInfo.k.isEmpty()) {
            String str;
            String str2 = "attachment_mime_type_list";
            ImmutableList<String> immutableList = messageAttachmentInfo.k;
            if (immutableList.isEmpty()) {
                str = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                Object obj = 1;
                for (String str3 : immutableList) {
                    if (obj == null) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append('\"');
                    stringBuilder.append(str3);
                    stringBuilder.append('\"');
                    obj = null;
                }
                stringBuilder.append("]");
                str3 = stringBuilder.toString();
            }
            map.put(str2, str3);
        }
        if (z && !messageAttachmentInfo.j.n()) {
            map.put("type_source_map", m7937a(messageAttachmentInfo.j));
        }
    }

    private static String m7937a(ListMultimap<MediaResource.Type, Source> listMultimap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (MediaResource.Type type : listMultimap.p()) {
            for (Source source : listMultimap.a(type)) {
                stringBuilder.append("{\"");
                stringBuilder.append(type.toString());
                stringBuilder.append("\":\"");
                stringBuilder.append(source.toString());
                stringBuilder.append("\"}");
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private String m7935a() {
        return Long.toString(this.f7656d.a());
    }

    private String m7936a(long j) {
        return Long.toString(this.f7657e.now() - j);
    }
}
