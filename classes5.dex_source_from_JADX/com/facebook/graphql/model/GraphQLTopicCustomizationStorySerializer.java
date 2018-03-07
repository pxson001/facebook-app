package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UFI */
public class GraphQLTopicCustomizationStorySerializer extends JsonSerializer<GraphQLTopicCustomizationStory> {
    public final void m22262a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopicCustomizationStory graphQLTopicCustomizationStory = (GraphQLTopicCustomizationStory) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTopicCustomizationStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLTopicCustomizationStory.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLTopicCustomizationStory.p() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLTopicCustomizationStory.p()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLTopicCustomizationStory.q() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLTopicCustomizationStory.q()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTopicCustomizationStory.r() != null) {
            jsonGenerator.a("app_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.r(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLTopicCustomizationStory.s() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLTopicCustomizationStory.s()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTopicCustomizationStory.g() != null) {
            jsonGenerator.a("cache_id", graphQLTopicCustomizationStory.g());
        }
        jsonGenerator.a("creation_time", graphQLTopicCustomizationStory.t());
        if (graphQLTopicCustomizationStory.S_() != null) {
            jsonGenerator.a("debug_info", graphQLTopicCustomizationStory.S_());
        }
        if (graphQLTopicCustomizationStory.u() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.u(), true);
        }
        if (graphQLTopicCustomizationStory.x() != null) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContext__JsonHelper.m7480a(jsonGenerator, graphQLTopicCustomizationStory.x(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLTopicCustomizationStory.T_());
        if (graphQLTopicCustomizationStory.y() != null) {
            jsonGenerator.a("hideable_token", graphQLTopicCustomizationStory.y());
        }
        if (graphQLTopicCustomizationStory.z() != null) {
            jsonGenerator.a("id", graphQLTopicCustomizationStory.z());
        }
        if (graphQLTopicCustomizationStory.A() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.A(), true);
        }
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLTopicCustomizationStory.B() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLTopicCustomizationStory.B()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTopicCustomizationStory.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLTopicCustomizationStory.C(), true);
        }
        if (graphQLTopicCustomizationStory.D() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLTopicCustomizationStory.D(), true);
        }
        if (graphQLTopicCustomizationStory.E() != null) {
            jsonGenerator.a("seen_state", graphQLTopicCustomizationStory.E().toString());
        }
        if (graphQLTopicCustomizationStory.F() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLTopicCustomizationStory.F(), true);
        }
        if (graphQLTopicCustomizationStory.G() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLTopicCustomizationStory.G());
        }
        if (graphQLTopicCustomizationStory.H() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.H(), true);
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLTopicCustomizationStory.I() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLTopicCustomizationStory.I()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTopicCustomizationStory.J() != null) {
            jsonGenerator.a("subtopic_options");
            GraphQLTrueTopicFeedOptionsConnection__JsonHelper.m22329a(jsonGenerator, graphQLTopicCustomizationStory.J(), true);
        }
        if (graphQLTopicCustomizationStory.K() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.K(), true);
        }
        if (graphQLTopicCustomizationStory.L() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTopicCustomizationStory.L(), true);
        }
        if (graphQLTopicCustomizationStory.k() != null) {
            jsonGenerator.a("tracking", graphQLTopicCustomizationStory.k());
        }
        if (graphQLTopicCustomizationStory.M() != null) {
            jsonGenerator.a("url", graphQLTopicCustomizationStory.M());
        }
        if (graphQLTopicCustomizationStory.N() != null) {
            jsonGenerator.a("topic_section");
            GraphQLExploreFeed__JsonHelper.m7405a(jsonGenerator, graphQLTopicCustomizationStory.N(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTopicCustomizationStory.class, new GraphQLTopicCustomizationStorySerializer());
    }
}
