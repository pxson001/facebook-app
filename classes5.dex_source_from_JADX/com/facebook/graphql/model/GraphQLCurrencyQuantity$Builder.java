package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: ios_report_duplicate */
public class GraphQLCurrencyQuantity$Builder extends Builder {
    public double f3507d;
    public int f3508e;
    @Nullable
    public String f3509f;
    @Nullable
    public String f3510g;
    public int f3511h;
    @Nullable
    public String f3512i;

    public GraphQLCurrencyQuantity$Builder() {
        Preconditions.checkState(this instanceof GraphQLCurrencyQuantity$Builder);
    }

    public final GraphQLCurrencyQuantity m6919a() {
        return new GraphQLCurrencyQuantity(this);
    }
}
