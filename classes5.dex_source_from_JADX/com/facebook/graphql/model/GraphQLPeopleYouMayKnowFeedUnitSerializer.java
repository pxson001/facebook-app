package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WIZARD_SUGGESTION */
public class GraphQLPeopleYouMayKnowFeedUnitSerializer extends JsonSerializer<GraphQLPeopleYouMayKnowFeedUnit> {
    public final void m20689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit = (GraphQLPeopleYouMayKnowFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPeopleYouMayKnowFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLPeopleYouMayKnowFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLPeopleYouMayKnowFeedUnit.l()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLPeopleYouMayKnowFeedUnit.r() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLPeopleYouMayKnowFeedUnit.r()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("attachments");
        if (graphQLPeopleYouMayKnowFeedUnit.s() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLPeopleYouMayKnowFeedUnit.s()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPeopleYouMayKnowFeedUnit.g());
        }
        jsonGenerator.a("creation_time", graphQLPeopleYouMayKnowFeedUnit.t());
        if (graphQLPeopleYouMayKnowFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPeopleYouMayKnowFeedUnit.S_());
        }
        if (graphQLPeopleYouMayKnowFeedUnit.u() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.u(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnit.x() != null) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContext__JsonHelper.m7480a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.x(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLPeopleYouMayKnowFeedUnit.T_());
        if (graphQLPeopleYouMayKnowFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLPeopleYouMayKnowFeedUnit.y());
        }
        jsonGenerator.a("items");
        if (graphQLPeopleYouMayKnowFeedUnit.z() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem : graphQLPeopleYouMayKnowFeedUnit.z()) {
                if (graphQLPeopleYouMayKnowFeedUnitItem != null) {
                    GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20687a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.A() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.A(), true);
        }
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLPeopleYouMayKnowFeedUnit.B() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLPeopleYouMayKnowFeedUnit.B()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.C(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnit.D() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.D(), true);
        }
        jsonGenerator.a("pymkItems");
        if (graphQLPeopleYouMayKnowFeedUnit.E() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem2 : graphQLPeopleYouMayKnowFeedUnit.E()) {
                if (graphQLPeopleYouMayKnowFeedUnitItem2 != null) {
                    GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20687a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.F() != null) {
            jsonGenerator.a("seen_state", graphQLPeopleYouMayKnowFeedUnit.F().toString());
        }
        if (graphQLPeopleYouMayKnowFeedUnit.G() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.G(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnit.H() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPeopleYouMayKnowFeedUnit.H());
        }
        if (graphQLPeopleYouMayKnowFeedUnit.I() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.I(), true);
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLPeopleYouMayKnowFeedUnit.J() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLPeopleYouMayKnowFeedUnit.J()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayKnowFeedUnit.K() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnit.K(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouMayKnowFeedUnit.k());
        }
        if (graphQLPeopleYouMayKnowFeedUnit.L() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPeopleYouMayKnowFeedUnit.L());
        }
        if (graphQLPeopleYouMayKnowFeedUnit.M() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPeopleYouMayKnowFeedUnit.M());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPeopleYouMayKnowFeedUnit.N());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnit.class, new GraphQLPeopleYouMayKnowFeedUnitSerializer());
    }
}
