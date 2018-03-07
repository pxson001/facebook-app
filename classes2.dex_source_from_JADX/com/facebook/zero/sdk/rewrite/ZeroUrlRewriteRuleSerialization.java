package com.facebook.zero.sdk.rewrite;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: fonts/Roboto-Medium.ttf */
public class ZeroUrlRewriteRuleSerialization {
    private final ObjectMapper f23508a;
    private final JsonFactory f23509b;

    public static ZeroUrlRewriteRuleSerialization m31825b(InjectorLike injectorLike) {
        return new ZeroUrlRewriteRuleSerialization(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike));
    }

    @Inject
    public ZeroUrlRewriteRuleSerialization(ObjectMapper objectMapper, JsonFactory jsonFactory) {
        this.f23508a = objectMapper;
        this.f23509b = jsonFactory;
    }

    public static ImmutableList<ZeroUrlRewriteRule> m31824a(JsonNode jsonNode) {
        Builder builder = new Builder();
        Iterator G = jsonNode.mo704G();
        while (G.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) G.next();
            JsonNode b = jsonNode2.mo709b("matcher");
            jsonNode2 = jsonNode2.mo709b("replacer");
            if (!(b == null || jsonNode2 == null)) {
                builder.m1069c(new ZeroUrlRewriteRule(b.mo719B(), jsonNode2.mo719B()));
            }
        }
        return builder.m1068b();
    }

    public final ImmutableList<ZeroUrlRewriteRule> m31826a(String str) {
        return m31824a((JsonNode) this.f23508a.mo906a(this.f23509b.m7173b(str)));
    }

    public final String m31827a(ImmutableList<ZeroUrlRewriteRule> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.m1069c((ZeroUrlRewriteRule) immutableList.get(i));
        }
        return this.f23508a.m6659a(builder.m1068b());
    }
}
