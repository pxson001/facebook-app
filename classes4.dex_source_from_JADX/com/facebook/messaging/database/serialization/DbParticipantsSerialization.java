package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: low_res_image_client_cdn_uri_expired_ratio */
public class DbParticipantsSerialization {
    private final ObjectMapperWithUncheckedException f8810a;

    public static DbParticipantsSerialization m9122b(InjectorLike injectorLike) {
        return new DbParticipantsSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbParticipantsSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8810a = objectMapperWithUncheckedException;
    }

    public final String m9125a(ParticipantInfo participantInfo) {
        if (participantInfo == null) {
            return null;
        }
        return m9123b(participantInfo).toString();
    }

    public static DbParticipantsSerialization m9120a(InjectorLike injectorLike) {
        return m9122b(injectorLike);
    }

    public final String m9126a(List<ParticipantInfo> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ParticipantInfo b : list) {
            arrayNode.a(m9123b(b));
        }
        return arrayNode.toString();
    }

    private static JsonNode m9123b(ParticipantInfo participantInfo) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("email", participantInfo.d);
        if (participantInfo.b != null) {
            objectNode.a("user_key", participantInfo.b.c());
        }
        objectNode.a("name", participantInfo.c);
        return objectNode;
    }

    public final ParticipantInfo m9124a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return m9121a(this.f8810a.a(str));
    }

    public final ImmutableList<ParticipantInfo> m9127b(String str) {
        JsonNode a = this.f8810a.a(str);
        Builder builder = ImmutableList.builder();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            builder.c(m9121a((JsonNode) it.next()));
        }
        return builder.b();
    }

    public static ParticipantInfo m9121a(JsonNode jsonNode) {
        return new ParticipantInfo(UserKey.a(JSONUtil.b(jsonNode.c("user_key"))), JSONUtil.b(jsonNode.c("name")), JSONUtil.b(jsonNode.c("email")), JSONUtil.b(jsonNode.c("phone")), JSONUtil.g(jsonNode.c("is_commerce")));
    }

    public final ImmutableList<ThreadParticipant> m9128c(String str) {
        JsonNode a = this.f8810a.a(str);
        Builder builder = ImmutableList.builder();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            a = (JsonNode) it.next();
            ParticipantInfo a2 = m9121a(a);
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = a2;
            ThreadParticipantBuilder threadParticipantBuilder2 = threadParticipantBuilder;
            threadParticipantBuilder2.b = JSONUtil.c(a.b("lastReadReceiptTimestampMs"));
            threadParticipantBuilder2 = threadParticipantBuilder2;
            threadParticipantBuilder2.c = JSONUtil.b(a.b("lastDeliveredReceiptMsgId"));
            threadParticipantBuilder2 = threadParticipantBuilder2;
            threadParticipantBuilder2.d = JSONUtil.c(a.b("lastDeliveredReceiptTimestampMs"));
            builder.c(threadParticipantBuilder2.f());
        }
        return builder.b();
    }
}
