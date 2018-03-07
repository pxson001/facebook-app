package com.facebook.messaging.database.serialization;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONObject;

/* compiled from: me/pinned_threads */
public class MessageDebugDataSerializationHelper {
    private final MessageUtil f10422a;
    public final Provider<String> f10423b;
    private final DbMessageClientTagsSerialization f10424c;

    @Inject
    public MessageDebugDataSerializationHelper(MessageUtil messageUtil, Provider<String> provider, DbMessageClientTagsSerialization dbMessageClientTagsSerialization) {
        this.f10422a = messageUtil;
        this.f10423b = provider;
        this.f10424c = dbMessageClientTagsSerialization;
    }

    @Nullable
    public final JSONObject m11091a(@Nullable Message message) {
        if (message == null || message.e == null) {
            return null;
        }
        boolean z;
        String type;
        JSONObject put = new JSONObject().put("id", message.a).put("timeStampMs", message.c).put("thread_key", message.b).put("msgType", message.l.dbKeyValue).put("sentTimestampMs", m11089a(message.d)).put("senderInfo", message.e).put("actionId", message.g).put("attachments.count", m11088a(message.i)).put("shares.count", m11088a(message.j)).put("offlineThreadingId", message.n).put("isNonAuthoritative", message.o).put("source", message.p).put("channelSource", message.q.name()).put("sendChannel", message.r.name()).put("sentByUser", Objects.equal(this.f10423b.get(), message.e.b.b()));
        String str = "sentByDevice";
        if (message.d != 0) {
            z = true;
        } else {
            z = false;
        }
        JSONObject put2 = put.put(str, z).put("sendError.type", message.w.b.serializedString).put("sendError.errorMessage", message.w.c).put("sendError.errorNumber", message.w.d).put("sendError.timeStamp", m11089a(message.w.e));
        String str2 = "mediaAttachments.type";
        if (MessageUtil.e(message)) {
            type = ((MediaResource) message.t.get(0)).d.toString();
        } else {
            type = "none";
        }
        return put2.put(str2, type).put("mediaAttachments.totalSize", m11090c(message)).put("mediaAttachments.count", m11088a(message.t)).put("hasUnavailableAttachment", message.D).put("publicity", message.s.e).put("clientTags", DbMessageClientTagsSerialization.a(message.v)).put("sendQueueType", message.A == null ? "" : message.A.b.serializedValue).put("sentShareAttachments.type", message.u == null ? "" : message.u.a.DBSerialValue).put("composerAppAttribution.appId", message.E == null ? "" : message.E.a()).put("contentAppAttribution.appId", message.F == null ? "" : message.F.b);
    }

    private static <T> int m11088a(List<T> list) {
        return list == null ? -1 : list.size();
    }

    private static String m11089a(long j) {
        return j > 0 ? Long.toString(j) : "";
    }

    private int m11090c(Message message) {
        if (!MessageUtil.e(message)) {
            return -1;
        }
        ImmutableList immutableList = message.t;
        int i = 0;
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            i = (int) (((MediaResource) immutableList.get(i2)).p + ((long) i));
        }
        return i;
    }
}
