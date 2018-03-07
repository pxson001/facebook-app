package com.facebook.reaction;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Throwables;
import java.util.Arrays;

/* compiled from: c09689463f575d6ae1f9fde908495425 */
public class ReactionInitialQueryCacheKeySerializer implements GraphQLCacheKeySerializer {
    private final Surface f18607c;
    private final String f18608d;

    public ReactionInitialQueryCacheKeySerializer(Surface surface, String str) {
        this.f18607c = surface;
        this.f18608d = str;
    }

    public final String m22510a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
        try {
            return keyFactory.a(graphQLRequest.b(), cls, Integer.toString(keyFactory.a(graphQLRequest.d(), Arrays.asList(new String[]{"0", "83"})).a(this.f18607c).a(this.f18608d).hashCode()));
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }
}
