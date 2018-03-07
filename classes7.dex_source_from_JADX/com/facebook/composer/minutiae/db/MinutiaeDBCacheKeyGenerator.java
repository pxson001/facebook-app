package com.facebook.composer.minutiae.db;

import com.facebook.composer.minutiae.config.MinutiaeXConfig;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQL;
import com.facebook.composer.minutiae.protocol.MinutiaeTypeaheadGraphQLCacheKeySerializer;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: topSelectionChange */
public class MinutiaeDBCacheKeyGenerator {
    private final KeyFactory f1465a;
    private final XConfigReader f1466b;

    public static MinutiaeDBCacheKeyGenerator m1561b(InjectorLike injectorLike) {
        return new MinutiaeDBCacheKeyGenerator(KeyFactory.b(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public MinutiaeDBCacheKeyGenerator(KeyFactory keyFactory, XConfigReader xConfigReader) {
        this.f1465a = keyFactory;
        this.f1466b = xConfigReader;
    }

    public final String m1562a(GraphQlQueryParamSet graphQlQueryParamSet) {
        String a = new MinutiaeTypeaheadGraphQLCacheKeySerializer(FetchTaggableActivitiesGraphQL.a(), graphQlQueryParamSet).m1696a(null, this.f1465a);
        return ':' + this.f1466b.a(MinutiaeXConfig.d, 0);
    }
}
