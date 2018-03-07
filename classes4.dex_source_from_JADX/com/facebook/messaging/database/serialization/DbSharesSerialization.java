package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.share.Share;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: loomUpload */
public class DbSharesSerialization {
    private final DbShareSerialization f8831a;
    private final ObjectMapperWithUncheckedException f8832b;

    public static DbSharesSerialization m9151a(InjectorLike injectorLike) {
        return new DbSharesSerialization(DbShareSerialization.m9156b(injectorLike), ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbSharesSerialization(DbShareSerialization dbShareSerialization, ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8831a = dbShareSerialization;
        this.f8832b = objectMapperWithUncheckedException;
    }

    public final String m9153a(List<Share> list) {
        if (list == null) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Share a : list) {
            arrayNode.a(this.f8831a.m9159a(a));
        }
        return arrayNode.toString();
    }

    public final ImmutableList<Share> m9152a(String str) {
        if (StringUtil.a(str)) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = this.f8832b.a(str).iterator();
        while (it.hasNext()) {
            builder.c(this.f8831a.m9158a((JsonNode) it.next()));
        }
        return builder.b();
    }
}
