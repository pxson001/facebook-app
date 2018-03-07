package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: enable_ranked_replies */
public class GraphQLPagePostPromotionInfo$Builder extends Builder {
    @Nullable
    public GraphQLAdAccount f4744d;
    public GraphQLBoostedPostAudienceOption f4745e = GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLCurrencyQuantity f4746f;
    @Nullable
    public FeedUnit f4747g;
    public boolean f4748h;
    @Nullable
    public String f4749i;
    public int f4750j;
    @Nullable
    public String f4751k;
    @Nullable
    public GraphQLTextWithEntities f4752l;
    public int f4753m;
    public GraphQLBoostedPostStatus f4754n = GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public long f4755o;

    public GraphQLPagePostPromotionInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLPagePostPromotionInfo$Builder);
    }
}
