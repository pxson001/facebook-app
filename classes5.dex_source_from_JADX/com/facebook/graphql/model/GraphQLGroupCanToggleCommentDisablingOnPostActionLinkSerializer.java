package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_going */
public class GraphQLGroupCanToggleCommentDisablingOnPostActionLinkSerializer extends JsonSerializer<GraphQLGroupCanToggleCommentDisablingOnPostActionLink> {
    public final void m8389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupCanToggleCommentDisablingOnPostActionLink graphQLGroupCanToggleCommentDisablingOnPostActionLink = (GraphQLGroupCanToggleCommentDisablingOnPostActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8384a() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8384a(), true);
        }
        if (graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8386j() != null) {
            jsonGenerator.a("title", graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8386j());
        }
        if (graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8387k() != null) {
            jsonGenerator.a("url", graphQLGroupCanToggleCommentDisablingOnPostActionLink.m8387k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class, new GraphQLGroupCanToggleCommentDisablingOnPostActionLinkSerializer());
    }
}
