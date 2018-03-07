package com.facebook.zero.sdk.util;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: soft_cap_exceeded */
public class StringListDataSerializer {
    private static final Class f4367a = StringListDataSerializer.class;
    private final ObjectMapper f4368b;
    private final JsonFactory f4369c;

    public static StringListDataSerializer m8059b(InjectorLike injectorLike) {
        return new StringListDataSerializer(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike));
    }

    @Inject
    public StringListDataSerializer(ObjectMapper objectMapper, JsonFactory jsonFactory) {
        this.f4368b = objectMapper;
        this.f4369c = jsonFactory;
    }

    public static ImmutableList<String> m8058a(JsonNode jsonNode) {
        if (jsonNode == null) {
            BLog.b(f4367a, "StringListDataSerializer trying to deserialize null. Returning empty list instead");
            return RegularImmutableList.f535a;
        }
        Builder builder = new Builder();
        Iterator G = jsonNode.mo704G();
        while (G.hasNext()) {
            builder.m1069c(((JsonNode) G.next()).mo719B());
        }
        return builder.m1068b();
    }

    public static StringListDataSerializer m8057a(InjectorLike injectorLike) {
        return m8059b(injectorLike);
    }

    public final ImmutableList<String> m8060a(String str) {
        if (str.isEmpty()) {
            return RegularImmutableList.f535a;
        }
        return m8058a((JsonNode) this.f4368b.mo906a(this.f4369c.m7173b(str)));
    }

    public final String m8061a(ImmutableList<String> immutableList) {
        return this.f4368b.m6659a((Object) immutableList);
    }
}
