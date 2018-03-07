package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_mediaset */
public class GraphQLFundraiserToCharitySerializer extends JsonSerializer<GraphQLFundraiserToCharity> {
    public final void m7750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserToCharity graphQLFundraiserToCharity = (GraphQLFundraiserToCharity) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFundraiserToCharity.m7738j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLFundraiserToCharity.m7738j().e());
            jsonGenerator.g();
        }
        if (graphQLFundraiserToCharity.m7739k() != null) {
            jsonGenerator.a("campaign_title", graphQLFundraiserToCharity.m7739k());
        }
        if (graphQLFundraiserToCharity.m7740l() != null) {
            jsonGenerator.a("fundraiser_for_charity_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserToCharity.m7740l(), true);
        }
        if (graphQLFundraiserToCharity.m7741m() != null) {
            jsonGenerator.a("id", graphQLFundraiserToCharity.m7741m());
        }
        if (graphQLFundraiserToCharity.m7742n() != null) {
            jsonGenerator.a("logo_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserToCharity.m7742n(), true);
        }
        if (graphQLFundraiserToCharity.m7743o() != null) {
            jsonGenerator.a("mobile_donate_url", graphQLFundraiserToCharity.m7743o());
        }
        if (graphQLFundraiserToCharity.m7744p() != null) {
            jsonGenerator.a("charity");
            GraphQLFundraiserCharity__JsonHelper.m7676a(jsonGenerator, graphQLFundraiserToCharity.m7744p(), true);
        }
        jsonGenerator.a("can_invite_to_campaign", graphQLFundraiserToCharity.m7745q());
        if (graphQLFundraiserToCharity.m7746r() != null) {
            jsonGenerator.a("fundraiser_page_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserToCharity.m7746r(), true);
        }
        if (graphQLFundraiserToCharity.m7747s() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLFundraiserToCharity.m7747s(), true);
        }
        if (graphQLFundraiserToCharity.m7748t() != null) {
            jsonGenerator.a("fundraiser_detailed_progress_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserToCharity.m7748t(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserToCharity.class, new GraphQLFundraiserToCharitySerializer());
    }
}
