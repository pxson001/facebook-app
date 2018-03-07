package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: full_address */
public class GraphQLGreetingCard$Builder extends Builder {
    @Nullable
    public GraphQLGreetingCardTemplate f4126d;
    @Nullable
    public String f4127e;
    @Nullable
    public GraphQLImage f4128f;
    @Nullable
    public GraphQLGreetingCardSlidesConnection f4129g;
    @Nullable
    public String f4130h;
    @Nullable
    public String f4131i;

    public GraphQLGreetingCard$Builder() {
        Preconditions.checkState(this instanceof GraphQLGreetingCard$Builder);
    }
}
