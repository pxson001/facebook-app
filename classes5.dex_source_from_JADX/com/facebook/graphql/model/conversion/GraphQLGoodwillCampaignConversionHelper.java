package com.facebook.graphql.model.conversion;

import com.facebook.graphql.model.GraphQLGoodwillBirthdayCampaign;
import com.facebook.graphql.model.GraphQLGoodwillBirthdayCampaign.Builder;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import javax.annotation.Nullable;

/* compiled from: TTHelper; */
public final class GraphQLGoodwillCampaignConversionHelper {
    @Nullable
    public static GraphQLGoodwillBirthdayCampaign m22602a(@Nullable GraphQLGoodwillCampaign graphQLGoodwillCampaign) {
        if (graphQLGoodwillCampaign == null || graphQLGoodwillCampaign.m7832j() == null || graphQLGoodwillCampaign.m7832j().g() != -538251524) {
            return null;
        }
        Builder builder = new Builder();
        builder.f3866d = graphQLGoodwillCampaign.m7833k();
        builder.f3867e = graphQLGoodwillCampaign.m7842t();
        builder.f3868f = graphQLGoodwillCampaign.m7828G();
        builder.f3869g = graphQLGoodwillCampaign.m7844v();
        builder.f3870h = graphQLGoodwillCampaign.m7824C();
        return new GraphQLGoodwillBirthdayCampaign(builder);
    }
}
