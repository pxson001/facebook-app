package com.facebook.messaging.service.methods;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.List;

/* compiled from: current_position */
public class PinnedThreadsUtils {
    public static PinnedThreadsUtils m17000a(InjectorLike injectorLike) {
        return new PinnedThreadsUtils();
    }

    static JsonNode m17001a(List<ThreadKey> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ThreadKey i : list) {
            arrayNode.h("t_" + i.i());
        }
        return arrayNode;
    }
}
