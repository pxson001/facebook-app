package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_suggestion */
public class GraphQLFindPagesFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFindPagesFeedUnit graphQLFindPagesFeedUnit = new GraphQLFindPagesFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFindPagesFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("__type__".equals(i)) {
                    graphQLFindPagesFeedUnit.d = GraphQLObjectType.a(jsonParser);
                    i2 = 1;
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLFindPagesFeedUnit.e = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFindPagesFeedUnit, "fetchTimeMs", graphQLFindPagesFeedUnit.a_, 0, false);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLFindPagesFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindPagesFeedUnit.class, new GraphQLFindPagesFeedUnitDeserializer());
    }

    public GraphQLFindPagesFeedUnitDeserializer() {
        a(GraphQLFindPagesFeedUnit.class);
    }
}
