package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: grp_mmbr_list */
public final class GraphQLFundraiserCampaign__JsonHelper {
    public static GraphQLFundraiserCampaign m7668a(JsonParser jsonParser) {
        GraphQLFundraiserCampaign graphQLFundraiserCampaign = new GraphQLFundraiserCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7670a(graphQLFundraiserCampaign, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFundraiserCampaign;
    }

    private static boolean m7670a(GraphQLFundraiserCampaign graphQLFundraiserCampaign, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        String o;
        if ("amount_raised_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "amount_raised_text", graphQLFundraiserCampaign.a_, 0, false);
            return true;
        } else if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLFundraiserCampaign.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "blurredCoverPhoto", graphQLFundraiserCampaign.B_(), 1, true);
            return true;
        } else if ("campaign_goal_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "campaign_goal_text", graphQLFundraiserCampaign.B_(), 2, false);
            return true;
        } else if ("campaign_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.g = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "campaign_title", graphQLFundraiserCampaign.B_(), 3, false);
            return true;
        } else if ("can_invite_to_campaign".equals(str)) {
            graphQLFundraiserCampaign.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "can_invite_to_campaign", graphQLFundraiserCampaign.B_(), 4, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLFundraiserCampaign.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "cover_photo", graphQLFundraiserCampaign.B_(), 5, true);
            return true;
        } else if ("currency".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.j = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "currency", graphQLFundraiserCampaign.B_(), 6, false);
            return true;
        } else if ("default_share_message".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.k = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "default_share_message", graphQLFundraiserCampaign.B_(), 7, false);
            return true;
        } else if ("description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.l = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "description", graphQLFundraiserCampaign.B_(), 8, false);
            return true;
        } else if ("fundraiser_page".equals(str)) {
            GraphQLFundraiserPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFundraiserPage__JsonHelper.m7682a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_page"));
            }
            graphQLFundraiserCampaign.m = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "fundraiser_page", graphQLFundraiserCampaign.B_(), 10, true);
            return true;
        } else if ("has_goal_amount".equals(str)) {
            graphQLFundraiserCampaign.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "has_goal_amount", graphQLFundraiserCampaign.B_(), 11, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.o = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "id", graphQLFundraiserCampaign.B_(), 12, false);
            return true;
        } else if ("learn_more_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.p = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "learn_more_url", graphQLFundraiserCampaign.B_(), 13, false);
            return true;
        } else if ("logo_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "logo_image"));
            }
            graphQLFundraiserCampaign.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "logo_image", graphQLFundraiserCampaign.B_(), 14, true);
            return true;
        } else if ("matching_message".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.r = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "matching_message", graphQLFundraiserCampaign.B_(), 15, false);
            return true;
        } else if ("mobile_donate_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.s = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "mobile_donate_url", graphQLFundraiserCampaign.B_(), 16, false);
            return true;
        } else if ("percent_of_goal_reached".equals(str)) {
            graphQLFundraiserCampaign.t = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "percent_of_goal_reached", graphQLFundraiserCampaign.B_(), 17, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.u = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "url", graphQLFundraiserCampaign.B_(), 18, false);
            return true;
        } else if ("fundraiser_for_charity_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_for_charity_text"));
            }
            graphQLFundraiserCampaign.v = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "fundraiser_for_charity_text", graphQLFundraiserCampaign.B_(), 19, true);
            return true;
        } else if ("charity".equals(str)) {
            GraphQLFundraiserCharity a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFundraiserCharity__JsonHelper.m7675a(FieldAccessQueryTracker.a(jsonParser, "charity"));
            }
            graphQLFundraiserCampaign.w = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "charity", graphQLFundraiserCampaign.B_(), 20, true);
            return true;
        } else if ("fundraiser_page_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_page_subtitle"));
            }
            graphQLFundraiserCampaign.x = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "fundraiser_page_subtitle", graphQLFundraiserCampaign.B_(), 21, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLFundraiserCampaign.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "imageHighOrig", graphQLFundraiserCampaign.B_(), 22, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLFundraiserCampaign.z = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "name", graphQLFundraiserCampaign.B_(), 23, false);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLFundraiserCampaign.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "profilePictureHighRes", graphQLFundraiserCampaign.B_(), 24, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLFundraiserCampaign.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "profile_picture", graphQLFundraiserCampaign.B_(), 25, true);
            return true;
        } else if (!"fundraiser_detailed_progress_text".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_detailed_progress_text"));
            }
            graphQLFundraiserCampaign.C = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCampaign, "fundraiser_detailed_progress_text", graphQLFundraiserCampaign.B_(), 28, true);
            return true;
        }
    }

    public static void m7669a(JsonGenerator jsonGenerator, GraphQLFundraiserCampaign graphQLFundraiserCampaign, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFundraiserCampaign.j() != null) {
            jsonGenerator.a("amount_raised_text", graphQLFundraiserCampaign.j());
        }
        if (graphQLFundraiserCampaign.k() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLFundraiserCampaign.k(), true);
        }
        if (graphQLFundraiserCampaign.l() != null) {
            jsonGenerator.a("campaign_goal_text", graphQLFundraiserCampaign.l());
        }
        if (graphQLFundraiserCampaign.m() != null) {
            jsonGenerator.a("campaign_title", graphQLFundraiserCampaign.m());
        }
        jsonGenerator.a("can_invite_to_campaign", graphQLFundraiserCampaign.n());
        if (graphQLFundraiserCampaign.o() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLFundraiserCampaign.o(), true);
        }
        if (graphQLFundraiserCampaign.p() != null) {
            jsonGenerator.a("currency", graphQLFundraiserCampaign.p());
        }
        if (graphQLFundraiserCampaign.q() != null) {
            jsonGenerator.a("default_share_message", graphQLFundraiserCampaign.q());
        }
        if (graphQLFundraiserCampaign.r() != null) {
            jsonGenerator.a("description", graphQLFundraiserCampaign.r());
        }
        if (graphQLFundraiserCampaign.s() != null) {
            jsonGenerator.a("fundraiser_page");
            GraphQLFundraiserPage__JsonHelper.m7683a(jsonGenerator, graphQLFundraiserCampaign.s(), true);
        }
        jsonGenerator.a("has_goal_amount", graphQLFundraiserCampaign.t());
        if (graphQLFundraiserCampaign.u() != null) {
            jsonGenerator.a("id", graphQLFundraiserCampaign.u());
        }
        if (graphQLFundraiserCampaign.v() != null) {
            jsonGenerator.a("learn_more_url", graphQLFundraiserCampaign.v());
        }
        if (graphQLFundraiserCampaign.w() != null) {
            jsonGenerator.a("logo_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.w(), true);
        }
        if (graphQLFundraiserCampaign.x() != null) {
            jsonGenerator.a("matching_message", graphQLFundraiserCampaign.x());
        }
        if (graphQLFundraiserCampaign.y() != null) {
            jsonGenerator.a("mobile_donate_url", graphQLFundraiserCampaign.y());
        }
        jsonGenerator.a("percent_of_goal_reached", graphQLFundraiserCampaign.z());
        if (graphQLFundraiserCampaign.A() != null) {
            jsonGenerator.a("url", graphQLFundraiserCampaign.A());
        }
        if (graphQLFundraiserCampaign.B() != null) {
            jsonGenerator.a("fundraiser_for_charity_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.B(), true);
        }
        if (graphQLFundraiserCampaign.C() != null) {
            jsonGenerator.a("charity");
            GraphQLFundraiserCharity__JsonHelper.m7676a(jsonGenerator, graphQLFundraiserCampaign.C(), true);
        }
        if (graphQLFundraiserCampaign.D() != null) {
            jsonGenerator.a("fundraiser_page_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.D(), true);
        }
        if (graphQLFundraiserCampaign.E() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.E(), true);
        }
        if (graphQLFundraiserCampaign.F() != null) {
            jsonGenerator.a("name", graphQLFundraiserCampaign.F());
        }
        if (graphQLFundraiserCampaign.G() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.G(), true);
        }
        if (graphQLFundraiserCampaign.H() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.H(), true);
        }
        if (graphQLFundraiserCampaign.I() != null) {
            jsonGenerator.a("fundraiser_detailed_progress_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFundraiserCampaign.I(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
