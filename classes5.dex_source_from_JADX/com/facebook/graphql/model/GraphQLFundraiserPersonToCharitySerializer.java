package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_members */
public class GraphQLFundraiserPersonToCharitySerializer extends JsonSerializer<GraphQLFundraiserPersonToCharity> {
    public final void m7731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserPersonToCharity graphQLFundraiserPersonToCharity = (GraphQLFundraiserPersonToCharity) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFundraiserPersonToCharity.m7707j() != null) {
            jsonGenerator.a("id", graphQLFundraiserPersonToCharity.m7707j());
        }
        if (graphQLFundraiserPersonToCharity.m7708k() != null) {
            jsonGenerator.a("url", graphQLFundraiserPersonToCharity.m7708k());
        }
        if (graphQLFundraiserPersonToCharity.m7709l() != null) {
            jsonGenerator.a("campaign_title", graphQLFundraiserPersonToCharity.m7709l());
        }
        if (graphQLFundraiserPersonToCharity.m7710m() != null) {
            jsonGenerator.a("charity");
            GraphQLFundraiserCharity__JsonHelper.m7676a(jsonGenerator, graphQLFundraiserPersonToCharity.m7710m(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7711n() != null) {
            jsonGenerator.a("fundraiser_for_charity_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7711n(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7712o() != null) {
            jsonGenerator.a("logo_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7712o(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7713p() != null) {
            jsonGenerator.a("mobile_donate_url", graphQLFundraiserPersonToCharity.m7713p());
        }
        if (graphQLFundraiserPersonToCharity.m7714q() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7714q(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7715r() != null) {
            jsonGenerator.a("header_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLFundraiserPersonToCharity.m7715r(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7716s() != null) {
            jsonGenerator.a("amount_raised_text", graphQLFundraiserPersonToCharity.m7716s());
        }
        if (graphQLFundraiserPersonToCharity.m7717t() != null) {
            jsonGenerator.a("campaign_goal_text", graphQLFundraiserPersonToCharity.m7717t());
        }
        jsonGenerator.a("has_goal_amount", graphQLFundraiserPersonToCharity.m7718u());
        jsonGenerator.a("percent_of_goal_reached", graphQLFundraiserPersonToCharity.m7719v());
        jsonGenerator.a("can_invite_to_campaign", graphQLFundraiserPersonToCharity.m7720w());
        if (graphQLFundraiserPersonToCharity.m7721x() != null) {
            jsonGenerator.a("fundraiser_page_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7721x(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7722y() != null) {
            jsonGenerator.a("donors");
            GraphQLFundraiserPersonToCharityDonorsConnection__JsonHelper.m7730a(jsonGenerator, graphQLFundraiserPersonToCharity.m7722y(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7723z() != null) {
            jsonGenerator.a("social_context_text", graphQLFundraiserPersonToCharity.m7723z());
        }
        if (graphQLFundraiserPersonToCharity.m7687A() != null) {
            jsonGenerator.a("fundraiser_detailed_progress_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7687A(), true);
        }
        jsonGenerator.a("can_viewer_report", graphQLFundraiserPersonToCharity.m7688B());
        if (graphQLFundraiserPersonToCharity.m7689C() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7689C(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7690D() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7690D(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7691E() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLFundraiserPersonToCharity.m7691E(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7692F() != null) {
            jsonGenerator.a("name", graphQLFundraiserPersonToCharity.m7692F());
        }
        if (graphQLFundraiserPersonToCharity.m7693G() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7693G(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7694H() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7694H(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7695I() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7695I(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7696J() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7696J(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7697K() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7697K(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7698L() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLFundraiserPersonToCharity.m7698L(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7699M() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7699M(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLFundraiserPersonToCharity.m7700N());
        if (graphQLFundraiserPersonToCharity.m7701O() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLFundraiserPersonToCharity.m7701O(), true);
        }
        if (graphQLFundraiserPersonToCharity.m7702P() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharity.m7702P(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserPersonToCharity.class, new GraphQLFundraiserPersonToCharitySerializer());
    }
}
