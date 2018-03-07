package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friends_dash */
public final class C0390x30f1b3f9 {
    public static boolean m8390a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink graphQLGroupCanToggleCommentDisablingOnPostActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("feedback".equals(str)) {
            GraphQLFeedback a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLGroupCanToggleCommentDisablingOnPostActionLink.f4188d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupCanToggleCommentDisablingOnPostActionLink, "feedback", graphQLGroupCanToggleCommentDisablingOnPostActionLink.a_, 0, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupCanToggleCommentDisablingOnPostActionLink.f4189e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupCanToggleCommentDisablingOnPostActionLink, "title", graphQLGroupCanToggleCommentDisablingOnPostActionLink.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupCanToggleCommentDisablingOnPostActionLink.f4190f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupCanToggleCommentDisablingOnPostActionLink, "url", graphQLGroupCanToggleCommentDisablingOnPostActionLink.B_(), 2, false);
            return true;
        }
    }
}
