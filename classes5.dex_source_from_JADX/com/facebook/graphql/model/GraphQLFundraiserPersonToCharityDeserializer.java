package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_optimistic_video_posts_card */
public class GraphQLFundraiserPersonToCharityDeserializer extends FbJsonDeserializer {
    public Object m7724a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFundraiserPersonToCharity graphQLFundraiserPersonToCharity = new GraphQLFundraiserPersonToCharity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFundraiserPersonToCharity = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3809d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "id", graphQLFundraiserPersonToCharity.a_, 0, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3810e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "url", graphQLFundraiserPersonToCharity.a_, 1, false);
                } else if ("campaign_title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3811f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "campaign_title", graphQLFundraiserPersonToCharity.a_, 2, false);
                } else if ("charity".equals(i)) {
                    GraphQLFundraiserCharity graphQLFundraiserCharity;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLFundraiserCharity = null;
                    } else {
                        graphQLFundraiserCharity = GraphQLFundraiserCharity__JsonHelper.m7675a(FieldAccessQueryTracker.a(jsonParser, "charity"));
                    }
                    graphQLFundraiserPersonToCharity.f3812g = graphQLFundraiserCharity;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "charity", graphQLFundraiserPersonToCharity.a_, 3, true);
                } else if ("fundraiser_for_charity_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_for_charity_text"));
                    }
                    graphQLFundraiserPersonToCharity.f3813h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "fundraiser_for_charity_text", graphQLFundraiserPersonToCharity.a_, 4, true);
                } else if ("logo_image".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "logo_image"));
                    }
                    graphQLFundraiserPersonToCharity.f3814i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "logo_image", graphQLFundraiserPersonToCharity.a_, 5, true);
                } else if ("mobile_donate_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3815j = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "mobile_donate_url", graphQLFundraiserPersonToCharity.a_, 6, false);
                } else if ("owner".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
                    }
                    graphQLFundraiserPersonToCharity.f3816k = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "owner", graphQLFundraiserPersonToCharity.a_, 7, true);
                } else if ("header_photo".equals(i)) {
                    GraphQLPhoto graphQLPhoto;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPhoto = null;
                    } else {
                        graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "header_photo"));
                    }
                    graphQLFundraiserPersonToCharity.f3817l = graphQLPhoto;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "header_photo", graphQLFundraiserPersonToCharity.a_, 8, true);
                } else if ("amount_raised_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3818m = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "amount_raised_text", graphQLFundraiserPersonToCharity.a_, 9, false);
                } else if ("campaign_goal_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3819n = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "campaign_goal_text", graphQLFundraiserPersonToCharity.a_, 10, false);
                } else if ("has_goal_amount".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLFundraiserPersonToCharity.f3820o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "has_goal_amount", graphQLFundraiserPersonToCharity.a_, 11, false);
                } else if ("percent_of_goal_reached".equals(i)) {
                    double d;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        d = 0.0d;
                    } else {
                        d = jsonParser.G();
                    }
                    graphQLFundraiserPersonToCharity.f3821p = d;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "percent_of_goal_reached", graphQLFundraiserPersonToCharity.a_, 12, false);
                } else if ("can_invite_to_campaign".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLFundraiserPersonToCharity.f3822q = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "can_invite_to_campaign", graphQLFundraiserPersonToCharity.a_, 13, false);
                } else if ("fundraiser_page_subtitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_page_subtitle"));
                    }
                    graphQLFundraiserPersonToCharity.f3823r = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "fundraiser_page_subtitle", graphQLFundraiserPersonToCharity.a_, 14, true);
                } else if ("donors".equals(i)) {
                    GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLFundraiserPersonToCharityDonorsConnection = null;
                    } else {
                        graphQLFundraiserPersonToCharityDonorsConnection = GraphQLFundraiserPersonToCharityDonorsConnection__JsonHelper.m7729a(FieldAccessQueryTracker.a(jsonParser, "donors"));
                    }
                    graphQLFundraiserPersonToCharity.f3824s = graphQLFundraiserPersonToCharityDonorsConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "donors", graphQLFundraiserPersonToCharity.a_, 15, true);
                } else if ("social_context_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3825t = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "social_context_text", graphQLFundraiserPersonToCharity.a_, 16, false);
                } else if ("fundraiser_detailed_progress_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_detailed_progress_text"));
                    }
                    graphQLFundraiserPersonToCharity.f3826u = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "fundraiser_detailed_progress_text", graphQLFundraiserPersonToCharity.a_, 18, true);
                } else if ("can_viewer_report".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLFundraiserPersonToCharity.f3827v = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "can_viewer_report", graphQLFundraiserPersonToCharity.a_, 19, false);
                } else if ("feedAwesomizerProfilePicture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
                    }
                    graphQLFundraiserPersonToCharity.f3828w = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "feedAwesomizerProfilePicture", graphQLFundraiserPersonToCharity.a_, 20, true);
                } else if ("imageHighOrig".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
                    }
                    graphQLFundraiserPersonToCharity.f3829x = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "imageHighOrig", graphQLFundraiserPersonToCharity.a_, 21, true);
                } else if ("inline_activities".equals(i)) {
                    GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLInlineActivitiesConnection = null;
                    } else {
                        graphQLInlineActivitiesConnection = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
                    }
                    graphQLFundraiserPersonToCharity.f3830y = graphQLInlineActivitiesConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "inline_activities", graphQLFundraiserPersonToCharity.a_, 22, true);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserPersonToCharity.f3831z = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "name", graphQLFundraiserPersonToCharity.a_, 23, false);
                } else if ("profileImageLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
                    }
                    graphQLFundraiserPersonToCharity.f3799A = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profileImageLarge", graphQLFundraiserPersonToCharity.a_, 24, true);
                } else if ("profileImageSmall".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
                    }
                    graphQLFundraiserPersonToCharity.f3800B = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profileImageSmall", graphQLFundraiserPersonToCharity.a_, 25, true);
                } else if ("profilePicture50".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
                    }
                    graphQLFundraiserPersonToCharity.f3801C = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profilePicture50", graphQLFundraiserPersonToCharity.a_, 26, true);
                } else if ("profilePictureHighRes".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
                    }
                    graphQLFundraiserPersonToCharity.f3802D = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profilePictureHighRes", graphQLFundraiserPersonToCharity.a_, 27, true);
                } else if ("profilePictureLarge".equals(i)) {
                    graphQLFundraiserPersonToCharity.f3803E = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profilePictureLarge", graphQLFundraiserPersonToCharity.a_, 28, true);
                } else if ("profile_photo".equals(i)) {
                    graphQLFundraiserPersonToCharity.f3804F = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profile_photo", graphQLFundraiserPersonToCharity.a_, 29, true);
                } else if ("profile_picture".equals(i)) {
                    graphQLFundraiserPersonToCharity.f3805G = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profile_picture", graphQLFundraiserPersonToCharity.a_, 30, true);
                } else if ("profile_picture_is_silhouette".equals(i)) {
                    graphQLFundraiserPersonToCharity.f3806H = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "profile_picture_is_silhouette", graphQLFundraiserPersonToCharity.a_, 31, false);
                } else if ("streaming_profile_picture".equals(i)) {
                    graphQLFundraiserPersonToCharity.f3807I = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "streaming_profile_picture", graphQLFundraiserPersonToCharity.a_, 32, true);
                } else if ("taggable_object_profile_picture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
                    }
                    graphQLFundraiserPersonToCharity.f3808J = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharity, "taggable_object_profile_picture", graphQLFundraiserPersonToCharity.a_, 33, true);
                }
                jsonParser.f();
            }
        }
        return graphQLFundraiserPersonToCharity;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPersonToCharity.class, new GraphQLFundraiserPersonToCharityDeserializer());
    }

    public GraphQLFundraiserPersonToCharityDeserializer() {
        a(GraphQLFundraiserPersonToCharity.class);
    }
}
