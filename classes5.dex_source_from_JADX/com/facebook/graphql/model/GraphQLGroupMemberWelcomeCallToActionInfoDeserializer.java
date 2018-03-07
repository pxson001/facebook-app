package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: outputs */
public class GraphQLGroupMemberWelcomeCallToActionInfoDeserializer extends FbJsonDeserializer {
    public Object m8452a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupMemberWelcomeCallToActionInfo graphQLGroupMemberWelcomeCallToActionInfo = new GraphQLGroupMemberWelcomeCallToActionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupMemberWelcomeCallToActionInfo = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String str = null;
                if ("group_id".equals(i)) {
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                        str = jsonParser.o();
                    }
                    graphQLGroupMemberWelcomeCallToActionInfo.f4204d = str;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupMemberWelcomeCallToActionInfo, "group_id", graphQLGroupMemberWelcomeCallToActionInfo.a_, 0, false);
                }
                jsonParser.f();
            }
        }
        return graphQLGroupMemberWelcomeCallToActionInfo;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMemberWelcomeCallToActionInfo.class, new GraphQLGroupMemberWelcomeCallToActionInfoDeserializer());
    }

    public GraphQLGroupMemberWelcomeCallToActionInfoDeserializer() {
        a(GraphQLGroupMemberWelcomeCallToActionInfo.class);
    }
}
