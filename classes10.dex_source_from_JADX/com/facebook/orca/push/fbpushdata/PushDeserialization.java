package com.facebook.orca.push.fbpushdata;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceDataSerialization;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.messages.RecentMessageSource;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgXMAConverter;
import com.facebook.messaging.service.methods.AttachmentDeserializer;
import com.facebook.messaging.service.methods.PaymentTransactionDataDeserializer;
import com.facebook.messaging.service.methods.PaymentTransactionLogDataDeserializer;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.messaging.service.methods.SourceDeserializer;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: newMessageResults */
public class PushDeserialization {
    private static final Class<?> f6355a = PushDeserialization.class;
    private static ImmutableMap<String, MessageType> f6356b = ImmutableMap.of("log:thread-name", MessageType.SET_NAME, "log:thread-image", MessageType.SET_IMAGE, "log:unsubscribe", MessageType.REMOVE_MEMBERS, "log:subscribe", MessageType.ADD_MEMBERS);
    private final SourceDeserializer f6357c;
    private final AttachmentDeserializer f6358d;
    private final ObjectMapper f6359e;
    private final Provider<String> f6360f;
    private final DefaultThreadKeyFactory f6361g;
    private final PaymentTransactionDataDeserializer f6362h;
    private final PaymentTransactionLogDataDeserializer f6363i;
    private final RecentMessagesTracker f6364j;
    private final CommerceDataSerialization f6365k;

    public static PushDeserialization m6009a(InjectorLike injectorLike) {
        return new PushDeserialization(SourceDeserializer.a(injectorLike), AttachmentDeserializer.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), DefaultThreadKeyFactory.b(injectorLike), PaymentTransactionDataDeserializer.a(injectorLike), PaymentTransactionLogDataDeserializer.a(injectorLike), RecentMessagesTracker.a(injectorLike), CommerceDataSerialization.a(injectorLike));
    }

    @Inject
    public PushDeserialization(SourceDeserializer sourceDeserializer, AttachmentDeserializer attachmentDeserializer, ObjectMapper objectMapper, Provider<String> provider, ThreadKeyFactory threadKeyFactory, PaymentTransactionDataDeserializer paymentTransactionDataDeserializer, PaymentTransactionLogDataDeserializer paymentTransactionLogDataDeserializer, RecentMessagesTracker recentMessagesTracker, CommerceDataSerialization commerceDataSerialization) {
        this.f6357c = sourceDeserializer;
        this.f6358d = attachmentDeserializer;
        this.f6359e = objectMapper;
        this.f6360f = provider;
        this.f6361g = threadKeyFactory;
        this.f6362h = paymentTransactionDataDeserializer;
        this.f6363i = paymentTransactionLogDataDeserializer;
        this.f6364j = recentMessagesTracker;
        this.f6365k = commerceDataSerialization;
    }

    public final Message m6013a(String str, JsonNode jsonNode) {
        String b = JSONUtil.b(jsonNode.b("uid"));
        if (Objects.equal(b, "0") || b == null) {
            return null;
        }
        ThreadKey a;
        String str2;
        if (JSONUtil.d(jsonNode.b("g")) != 1) {
            a = this.f6361g.a(Long.parseLong(b));
        } else if (jsonNode.d("f")) {
            a = ThreadKey.a(JSONUtil.c(jsonNode.b("f")));
        } else {
            BLog.b(f6355a, "Received C2DM push for group without threadFbId.");
            a = null;
        }
        MessageType c = m6012c(jsonNode);
        if (str == null) {
            str2 = "";
            str = "";
        } else if (c == MessageType.ADMIN) {
            str2 = "";
        } else {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                str2 = split[0].trim();
                str = split[1].trim();
            } else {
                str2 = "";
            }
        }
        String b2 = JSONUtil.b(jsonNode.b("n"));
        ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.FACEBOOK, b), str2, b + "@facebook.com");
        str2 = null;
        if (jsonNode.d("o")) {
            switch (JSONUtil.d(jsonNode.b("o"))) {
                case 1:
                    str2 = "web";
                    break;
                case 2:
                    str2 = "mobile";
                    break;
                case 3:
                    str2 = "messenger";
                    break;
            }
        }
        long c2 = JSONUtil.c(jsonNode.b("s"));
        long a2 = m6008a(c2, jsonNode);
        String b3 = jsonNode.d("s_i") ? JSONUtil.b(jsonNode.b("s_i")) : null;
        Integer valueOf = jsonNode.d("ttl") ? Integer.valueOf(JSONUtil.d(jsonNode.b("ttl"))) : null;
        MessageBuilder a3 = Message.newBuilder().a(b2);
        a3.b = a;
        MessageBuilder messageBuilder = a3;
        messageBuilder.f = str;
        messageBuilder = messageBuilder.a(c2).c(a2);
        messageBuilder.k = b3;
        messageBuilder = messageBuilder;
        messageBuilder.e = participantInfo;
        messageBuilder = messageBuilder;
        messageBuilder.o = true;
        messageBuilder = messageBuilder;
        messageBuilder.q = ChannelSource.C2DM;
        messageBuilder = messageBuilder;
        messageBuilder.p = str2;
        messageBuilder = messageBuilder;
        messageBuilder.l = c;
        messageBuilder = messageBuilder;
        messageBuilder.v = Publicity.c;
        messageBuilder = messageBuilder;
        messageBuilder.J = valueOf;
        messageBuilder = messageBuilder;
        if (messageBuilder.l() == MessageType.CALL_LOG) {
            messageBuilder.G = RTCAdminMsgXMAConverter.a(str, b, c2, jsonNode);
        }
        Message R = messageBuilder.R();
        this.f6364j.a(RecentMessageSource.PUSH_C2DM_DELIVERY, R);
        return R;
    }

    @Nullable
    public final GroupMessageInfo m6014a(JsonNode jsonNode) {
        if (!jsonNode.d("gpc")) {
            return null;
        }
        int d = JSONUtil.d(jsonNode.b("gpc"));
        String b = JSONUtil.b(jsonNode.b("gpi"));
        String b2 = JSONUtil.b(jsonNode.b("gpn"));
        try {
            return new GroupMessageInfo(d, m6010a(this.f6359e.a(b), this.f6359e.a(b2)), JSONUtil.b(jsonNode.b("gn")), JSONUtil.b(jsonNode.b("gp")));
        } catch (IOException e) {
            BLog.b(f6355a, "Error deserializing ids and names. Return no group info.");
            return null;
        }
    }

    private static MessageType m6012c(JsonNode jsonNode) {
        MessageType messageType = MessageType.REGULAR;
        if (!jsonNode.d("l")) {
            return messageType;
        }
        switch (JSONUtil.d(jsonNode.b("l"))) {
            case 0:
                return MessageType.ADMIN;
            case 1:
                return MessageType.ADD_MEMBERS;
            case 2:
                return MessageType.REMOVE_MEMBERS;
            case 3:
                return MessageType.SET_NAME;
            case 4:
                return MessageType.SET_IMAGE;
            case 5:
                return MessageType.CALL_LOG;
            default:
                return MessageType.UNKNOWN;
        }
    }

    private static ImmutableList<ParticipantInfo> m6010a(JsonNode jsonNode, JsonNode jsonNode2) {
        Builder builder = ImmutableList.builder();
        int e = jsonNode.e();
        for (int i = 0; i < e; i++) {
            long c = JSONUtil.c(jsonNode.a(i));
            builder.c(new ParticipantInfo(new UserKey(Type.FACEBOOK, Long.toString(c)), JSONUtil.b(jsonNode2.a(i))));
        }
        return builder.b();
    }

    private static long m6008a(long j, JsonNode jsonNode) {
        if (jsonNode.d("action_id")) {
            return JSONUtil.c(jsonNode.b("action_id"));
        }
        return ActionIdHelper.a(j);
    }

    public static ServerMessageAlertFlags m6011b(JsonNode jsonNode) {
        boolean a = JSONUtil.a(jsonNode.b("disable_sound"), false);
        boolean a2 = JSONUtil.a(jsonNode.b("disable_vibrate"), false);
        boolean a3 = JSONUtil.a(jsonNode.b("disable_light"), false);
        ServerMessageAlertFlags.Builder builder = new ServerMessageAlertFlags.Builder();
        builder.a = a;
        ServerMessageAlertFlags.Builder builder2 = builder;
        builder2.b = a2;
        builder2 = builder2;
        builder2.c = a3;
        return builder2.a();
    }
}
