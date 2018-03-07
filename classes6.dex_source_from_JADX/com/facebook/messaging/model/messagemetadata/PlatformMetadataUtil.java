package com.facebook.messaging.model.messagemetadata;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: upsell_dialog_open */
public class PlatformMetadataUtil {
    private static ImmutableMap<PlatformMetadataType, PlatformMetadataCreator> f1943a = null;

    public static ObjectNode m3293a(ImmutableMap<PlatformMetadataType, PlatformMetadata> immutableMap) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            objectNode.c(((PlatformMetadataType) entry.getKey()).value, ((PlatformMetadata) entry.getValue()).mo151b());
        }
        return objectNode;
    }

    public static ImmutableMap<PlatformMetadataType, PlatformMetadata> m3295a(PlatformMetadata... platformMetadataArr) {
        Builder builder = ImmutableMap.builder();
        for (PlatformMetadata platformMetadata : platformMetadataArr) {
            builder.b(platformMetadata.mo150a(), platformMetadata);
        }
        return builder.b();
    }

    @Nullable
    public static <T extends PlatformMetadata> T m3291a(PlatformMetadataType platformMetadataType, ImmutableMap<PlatformMetadataType, PlatformMetadata> immutableMap) {
        if (immutableMap.containsKey(platformMetadataType)) {
            return (PlatformMetadata) immutableMap.get(platformMetadataType);
        }
        return null;
    }

    public static ImmutableMap<PlatformMetadataType, PlatformMetadata> m3294a(FbErrorReporter fbErrorReporter, ObjectMapper objectMapper, String str) {
        if (StringUtil.a(str)) {
            return ImmutableBiMap.a();
        }
        Builder builder = ImmutableMap.builder();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.a(str);
        } catch (Throwable e) {
            fbErrorReporter.a("PlatformMetadata", "Exception thrown when deserializing platform metadata", e);
        }
        if (jsonNode != null) {
            Iterator H = jsonNode.H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                PlatformMetadataType fromRawValue = PlatformMetadataType.fromRawValue((String) entry.getKey());
                PlatformMetadataCreator a = m3292a(fromRawValue);
                if (a != null) {
                    builder.b(fromRawValue, a.mo149a((JsonNode) entry.getValue()));
                }
            }
        }
        return builder.b();
    }

    @Nullable
    private static PlatformMetadataCreator m3292a(PlatformMetadataType platformMetadataType) {
        if (f1943a == null) {
            f1943a = ImmutableMap.builder().b(PlatformMetadataType.IGNORE_FOR_WEBHOOK, IgnoreForWebhookPlatformMetadata.CREATOR).b(PlatformMetadataType.QUICK_REPLIES, QuickRepliesPlatformMetadata.CREATOR).b();
        }
        return (PlatformMetadataCreator) f1943a.get(platformMetadataType);
    }
}
