package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_ADMIN_PANEL */
public class GraphQLPeopleYouMayInviteFeedUnitSerializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnit> {
    public final void m20671a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouMayInviteFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPeopleYouMayInviteFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLPeopleYouMayInviteFeedUnit.s() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLPeopleYouMayInviteFeedUnit.s()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLPeopleYouMayInviteFeedUnit.t() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLPeopleYouMayInviteFeedUnit.t()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayInviteFeedUnit.u() != null) {
            jsonGenerator.a("all_contacts");
            GraphQLPeopleYouMayInviteFeedUnitContactsConnection__JsonHelper.m20653a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.u(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.x() != null) {
            jsonGenerator.a("app_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.x(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLPeopleYouMayInviteFeedUnit.z() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLPeopleYouMayInviteFeedUnit.z()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayInviteFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPeopleYouMayInviteFeedUnit.g());
        }
        jsonGenerator.a("creation_time", graphQLPeopleYouMayInviteFeedUnit.A());
        if (graphQLPeopleYouMayInviteFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPeopleYouMayInviteFeedUnit.S_());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.B() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.B(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.C() != null) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContext__JsonHelper.m7480a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.C(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLPeopleYouMayInviteFeedUnit.T_());
        if (graphQLPeopleYouMayInviteFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLPeopleYouMayInviteFeedUnit.y());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.D() != null) {
            jsonGenerator.a("id", graphQLPeopleYouMayInviteFeedUnit.D());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.E() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.E(), true);
        }
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLPeopleYouMayInviteFeedUnit.F() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLPeopleYouMayInviteFeedUnit.F()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayInviteFeedUnit.G() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.G(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.H() != null) {
            jsonGenerator.a("peopleYouMayInviteTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.H(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.I() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.I(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.J() != null) {
            jsonGenerator.a("seen_state", graphQLPeopleYouMayInviteFeedUnit.J().toString());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.K() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.K(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.L() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPeopleYouMayInviteFeedUnit.L());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.M() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.M(), true);
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLPeopleYouMayInviteFeedUnit.N() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLPeopleYouMayInviteFeedUnit.N()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayInviteFeedUnit.O() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.O(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.P() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnit.P(), true);
        }
        if (graphQLPeopleYouMayInviteFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouMayInviteFeedUnit.k());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.Q() != null) {
            jsonGenerator.a("url", graphQLPeopleYouMayInviteFeedUnit.Q());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.R() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPeopleYouMayInviteFeedUnit.R());
        }
        if (graphQLPeopleYouMayInviteFeedUnit.S() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPeopleYouMayInviteFeedUnit.S());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPeopleYouMayInviteFeedUnit.T());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnit.class, new GraphQLPeopleYouMayInviteFeedUnitSerializer());
    }
}
