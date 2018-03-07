package com.facebook.composer.feedattachment.graphql;

import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedDefaultsEventPlaceFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedDefaultsEventPlaceFieldsModel.CityModel;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPlace.Builder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;

/* compiled from: gifUrl is null */
public final class ComposerAttachmentModelConversionHelper {
    public static GraphQLPlace m7946a(NewsFeedDefaultsEventPlaceFieldsModel newsFeedDefaultsEventPlaceFieldsModel) {
        if (newsFeedDefaultsEventPlaceFieldsModel == null) {
            return null;
        }
        GraphQLPage graphQLPage;
        GraphQLLocation graphQLLocation;
        Builder builder = new Builder();
        builder.X = newsFeedDefaultsEventPlaceFieldsModel.b();
        CityModel c = newsFeedDefaultsEventPlaceFieldsModel.c();
        if (c == null) {
            graphQLPage = null;
        } else {
            GraphQLPage.Builder builder2 = new GraphQLPage.Builder();
            builder2.G = c.a();
            graphQLPage = builder2.a();
        }
        builder.j = graphQLPage;
        builder.k = newsFeedDefaultsEventPlaceFieldsModel.d();
        builder.q = newsFeedDefaultsEventPlaceFieldsModel.bx_();
        DefaultLocationFields g = newsFeedDefaultsEventPlaceFieldsModel.g();
        if (g == null) {
            graphQLLocation = null;
        } else {
            GraphQLLocation.Builder builder3 = new GraphQLLocation.Builder();
            builder3.d = g.a();
            builder3.e = g.b();
            graphQLLocation = builder3.a();
        }
        builder.s = graphQLLocation;
        builder.c(newsFeedDefaultsEventPlaceFieldsModel.by_());
        builder.S = newsFeedDefaultsEventPlaceFieldsModel.bz_();
        return builder.a();
    }
}
