package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: low_data_mode */
public class DbThreadRtcCallInfoSerialization {
    public final ObjectMapperWithUncheckedException f8812a;

    public static DbThreadRtcCallInfoSerialization m9135b(InjectorLike injectorLike) {
        return new DbThreadRtcCallInfoSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbThreadRtcCallInfoSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8812a = objectMapperWithUncheckedException;
    }

    @Nullable
    public static String m9134a(ThreadRtcCallInfoData threadRtcCallInfoData) {
        if (threadRtcCallInfoData == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("call_state", threadRtcCallInfoData.b.toString());
        objectNode.a("server_info", threadRtcCallInfoData.c);
        objectNode.a("initiator_id", threadRtcCallInfoData.d);
        return objectNode.toString();
    }

    public static DbThreadRtcCallInfoSerialization m9133a(InjectorLike injectorLike) {
        return m9135b(injectorLike);
    }
}
