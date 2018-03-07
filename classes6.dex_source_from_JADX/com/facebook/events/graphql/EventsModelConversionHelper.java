package com.facebook.events.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel.TemplateTokensModel;
import com.facebook.events.graphql.EventsGraphQLModels.AttendingInlineActivityModel;
import com.facebook.events.graphql.EventsGraphQLModels.AttendingInlineActivityModel.TaggableActivityIconModel;
import com.facebook.events.graphql.EventsGraphQLModels.AttendingInlineActivityModel.TaggableActivityIconModel.ImageModel;
import com.facebook.events.graphql.EventsGraphQLModels.AttendingInlineActivityModel.TaggableActivityModel;
import com.facebook.graphql.model.GraphQLActivityTemplateToken;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLInlineActivity;
import com.facebook.graphql.model.GraphQLTaggableActivity;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: num_photos */
public final class EventsModelConversionHelper {
    public static GraphQLTaggableActivityPreviewTemplate m15186a(MinutiaePreviewTemplateModel minutiaePreviewTemplateModel) {
        if (minutiaePreviewTemplateModel == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = minutiaePreviewTemplateModel.a();
        if (minutiaePreviewTemplateModel.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < minutiaePreviewTemplateModel.b().size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken;
                TemplateTokensModel templateTokensModel = (TemplateTokensModel) minutiaePreviewTemplateModel.b().get(i);
                if (templateTokensModel == null) {
                    graphQLActivityTemplateToken = null;
                } else {
                    GraphQLActivityTemplateToken.Builder builder3 = new GraphQLActivityTemplateToken.Builder();
                    builder3.d = templateTokensModel.a();
                    builder3.e = templateTokensModel.b();
                    graphQLActivityTemplateToken = builder3.a();
                }
                builder2.c(graphQLActivityTemplateToken);
            }
            builder.e = builder2.b();
        }
        return builder.a();
    }

    public static GraphQLInlineActivity m15185a(AttendingInlineActivityModel attendingInlineActivityModel) {
        if (attendingInlineActivityModel == null) {
            return null;
        }
        GraphQLTaggableActivity graphQLTaggableActivity;
        GraphQLTaggableActivityIcon graphQLTaggableActivityIcon;
        GraphQLInlineActivity.Builder builder = new GraphQLInlineActivity.Builder();
        builder.d = attendingInlineActivityModel.m12990b();
        TaggableActivityModel c = attendingInlineActivityModel.m12991c();
        if (c == null) {
            graphQLTaggableActivity = null;
        } else {
            GraphQLTaggableActivity.Builder builder2 = new GraphQLTaggableActivity.Builder();
            builder2.g = c.m12975b();
            builder2.i = c.m12976c();
            builder2.j = c.m12977d();
            builder2.k = c.dK_();
            builder2.l = m15186a(c.m12984y());
            builder2.m = m15186a(c.m12983x());
            builder2.n = m15186a(c.m12982w());
            builder2.o = m15186a(c.m12981v());
            builder2.p = m15186a(c.m12980u());
            builder2.q = m15186a(c.m12979t());
            builder2.r = c.m12978g();
            graphQLTaggableActivity = builder2.a();
        }
        builder.f = graphQLTaggableActivity;
        TaggableActivityIconModel d = attendingInlineActivityModel.m12992d();
        if (d == null) {
            graphQLTaggableActivityIcon = null;
        } else {
            GraphQLImage graphQLImage;
            GraphQLTaggableActivityIcon.Builder builder3 = new GraphQLTaggableActivityIcon.Builder();
            builder3.e = d.m12961b();
            ImageModel c2 = d.m12962c();
            if (c2 == null) {
                graphQLImage = null;
            } else {
                GraphQLImage.Builder builder4 = new GraphQLImage.Builder();
                builder4.g = c2.m12955a();
                graphQLImage = builder4.a();
            }
            builder3.f = graphQLImage;
            graphQLTaggableActivityIcon = builder3.a();
        }
        builder.g = graphQLTaggableActivityIcon;
        return builder.a();
    }
}
