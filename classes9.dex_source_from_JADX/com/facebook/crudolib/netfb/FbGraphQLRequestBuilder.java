package com.facebook.crudolib.netfb;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: TimelineDbCache */
public class FbGraphQLRequestBuilder {
    private final ParamsCollectionPool f24100a;
    public final FbBaseRequestBuilder f24101b;
    @Nullable
    public ParamsCollectionMap f24102c;
    private final int f24103d;

    public FbGraphQLRequestBuilder(ParamsCollectionPool paramsCollectionPool, int i, String str, FbBaseRequestBuilder fbBaseRequestBuilder) {
        this.f24100a = paramsCollectionPool;
        this.f24101b = fbBaseRequestBuilder;
        this.f24103d = i;
        fbBaseRequestBuilder.f24096e = "graph";
        fbBaseRequestBuilder.f24097f = "graphql";
        fbBaseRequestBuilder.m26044a("query_id", str);
    }

    public final FbGraphQLRequestBuilder m26047a(long j, @Nullable String str) {
        m26045c().a(GraphQLParamHelper.m26056a(this.f24103d, j), str);
        return this;
    }

    public final FbGraphQLRequestBuilder m26046a(long j, @Nullable Number number) {
        m26045c().a(GraphQLParamHelper.m26056a(this.f24103d, j), number);
        return this;
    }

    @Nonnull
    private ParamsCollectionMap m26045c() {
        if (this.f24102c == null) {
            this.f24102c = this.f24100a.b();
        }
        return this.f24102c;
    }
}
