package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.interfaces.MediaQuery;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;
import javax.annotation.Nullable;

/* compiled from: language_model */
public abstract class PaginatedMediaQuery<T, Q extends QueryParam, E> extends MediaQuery<Q> {
    public final Class<E> f10611b;
    public final CallerContext f10612c;

    public abstract GraphQLRequest mo600a(int i, @Nullable String str);

    public abstract PageResult<E> mo601a(GraphQLResult<T> graphQLResult);

    protected PaginatedMediaQuery(Q q, Class<E> cls, @Nullable CallerContext callerContext) {
        super(q);
        this.f10611b = cls;
        this.f10612c = callerContext;
    }
}
