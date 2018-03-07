package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: rtc_when */
public class GraphQLImage$Builder extends Builder {
    public int f3054d;
    @Nullable
    public String f3055e;
    public double f3056f;
    @Nullable
    public String f3057g;
    public int f3058h;
    @Nullable
    PropertyBag f3059i = null;

    public GraphQLImage$Builder() {
        Preconditions.checkState(this instanceof GraphQLImage$Builder);
    }

    public static GraphQLImage$Builder m3381a(GraphQLImage graphQLImage) {
        GraphQLImage$Builder graphQLImage$Builder = new GraphQLImage$Builder();
        graphQLImage.h();
        graphQLImage$Builder.f3054d = graphQLImage.a();
        graphQLImage$Builder.f3055e = graphQLImage.d();
        graphQLImage$Builder.f3056f = graphQLImage.j();
        graphQLImage$Builder.f3057g = graphQLImage.b();
        graphQLImage$Builder.f3058h = graphQLImage.c();
        Builder.a(graphQLImage$Builder, graphQLImage);
        graphQLImage$Builder.f3059i = (PropertyBag) graphQLImage.U_().clone();
        return graphQLImage$Builder;
    }

    public final GraphQLImage$Builder m3382a(int i) {
        this.f3054d = i;
        return this;
    }

    public final GraphQLImage$Builder m3383a(@Nullable String str) {
        this.f3055e = str;
        return this;
    }

    public final GraphQLImage$Builder m3386b(@Nullable String str) {
        this.f3057g = str;
        return this;
    }

    public final GraphQLImage$Builder m3385b(int i) {
        this.f3058h = i;
        return this;
    }

    public final GraphQLImage m3384a() {
        return new GraphQLImage(this);
    }
}
