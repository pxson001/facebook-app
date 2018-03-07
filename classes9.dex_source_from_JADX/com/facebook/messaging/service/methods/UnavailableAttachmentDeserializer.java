package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: credential identifier cannot be empty */
public class UnavailableAttachmentDeserializer {
    public static boolean m17070a(JsonNode jsonNode) {
        for (int i = 0; i < jsonNode.e(); i++) {
            if ("unavailable_attachment".equals(JSONUtil.b(jsonNode.a(i)))) {
                return true;
            }
        }
        return false;
    }
}
