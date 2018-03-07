package com.facebook.messaging.database.serialization;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.messaging.model.messagemetadata.MessageMetadataAtTextRange;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/vaultimages */
public class DbMessageMetadataSerialization {
    private final AbstractFbErrorReporter f10417a;
    private final ObjectMapper f10418b;

    @Inject
    public DbMessageMetadataSerialization(AbstractFbErrorReporter abstractFbErrorReporter, ObjectMapper objectMapper) {
        this.f10417a = abstractFbErrorReporter;
        this.f10418b = objectMapper;
    }

    @Nullable
    public static String m11084a(List<MessageMetadataAtTextRange> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (MessageMetadataAtTextRange messageMetadataAtTextRange : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("type", messageMetadataAtTextRange.a.value);
            objectNode.a("offset", messageMetadataAtTextRange.b);
            objectNode.a("length", messageMetadataAtTextRange.c);
            objectNode.c("data", messageMetadataAtTextRange.d.a());
            arrayNode.a(objectNode);
        }
        return arrayNode.toString();
    }

    public final ImmutableList<MessageMetadataAtTextRange> m11085a(String str) {
        return MessageMetadataAtTextRange.a(this.f10418b, this.f10417a, str);
    }
}
