package com.facebook.pages.identity.common;

import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: placeholderTextColor */
public class PagesCardCacheKeySerializer implements GraphQLCacheKeySerializer {
    private final String f3792c;
    private final String f3793d;

    @Inject
    public PagesCardCacheKeySerializer(@Assisted String str, @Assisted String str2) {
        this.f3792c = (String) Preconditions.checkNotNull(str);
        this.f3793d = (String) Preconditions.checkNotNull(str2);
    }

    public final String m4759a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
        Collection arrayList = new ArrayList(2);
        arrayList.add(this.f3792c);
        arrayList.add(this.f3793d);
        Preconditions.checkArgument(graphQLRequest.d().a(this.f3793d) != null);
        return keyFactory.b(graphQLRequest.o, cls, graphQLRequest.d(), arrayList);
    }
}
