package com.facebook.messaging.database.serialization;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/threads/inbox */
public class DbMessagePlatformMetadataSerialization {
    private final AbstractFbErrorReporter f10419a;
    private final ObjectMapper f10420b;

    @Inject
    public DbMessagePlatformMetadataSerialization(AbstractFbErrorReporter abstractFbErrorReporter, ObjectMapper objectMapper) {
        this.f10419a = abstractFbErrorReporter;
        this.f10420b = objectMapper;
    }

    @Nullable
    public static String m11086a(ImmutableMap<PlatformMetadataType, PlatformMetadata> immutableMap) {
        if (immutableMap == null || immutableMap.isEmpty()) {
            return null;
        }
        return PlatformMetadataUtil.a(immutableMap).toString();
    }

    public final ImmutableMap<PlatformMetadataType, PlatformMetadata> m11087a(String str) {
        return PlatformMetadataUtil.a(this.f10419a, this.f10420b, str);
    }
}
