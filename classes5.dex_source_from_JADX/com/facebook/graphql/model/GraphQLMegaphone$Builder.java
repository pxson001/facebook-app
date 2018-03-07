package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: failed_status */
public class GraphQLMegaphone$Builder extends Builder {
    @Nullable
    public GraphQLMegaphoneAction f4490d;
    @Nullable
    public String f4491e;
    @Nullable
    public String f4492f;
    @Nullable
    public GraphQLTextWithEntities f4493g;
    @Nullable
    public GraphQLImage f4494h;
    @Nullable
    public String f4495i;
    public boolean f4496j;
    public GraphQLMegaphoneLocation f4497k = GraphQLMegaphoneLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities f4498l;
    @Nullable
    public String f4499m;
    @Nullable
    public String f4500n;
    @Nullable
    public String f4501o;
    @Nullable
    PropertyBag f4502p = null;

    public GraphQLMegaphone$Builder() {
        Preconditions.checkState(this instanceof GraphQLMegaphone$Builder);
    }

    public final GraphQLMegaphone$Builder m9081a(@Nullable GraphQLMegaphoneAction graphQLMegaphoneAction) {
        this.f4490d = graphQLMegaphoneAction;
        return this;
    }

    public final GraphQLMegaphone$Builder m9083a(@Nullable String str) {
        this.f4491e = str;
        return this;
    }

    public final GraphQLMegaphone$Builder m9082a(@Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        this.f4493g = graphQLTextWithEntities;
        return this;
    }

    public final GraphQLMegaphone$Builder m9084a(boolean z) {
        this.f4496j = z;
        return this;
    }

    public final GraphQLMegaphone$Builder m9080a(GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
        this.f4497k = graphQLMegaphoneLocation;
        return this;
    }

    public final GraphQLMegaphone$Builder m9086b(@Nullable String str) {
        this.f4499m = str;
        return this;
    }

    public final GraphQLMegaphone m9085a() {
        return new GraphQLMegaphone(this);
    }
}
