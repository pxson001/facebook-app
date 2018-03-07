package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ordered_snippets */
public class GraphQLInfoRequestFieldDeserializer extends FbJsonDeserializer {
    public Object m8682a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLInfoRequestField graphQLInfoRequestField = new GraphQLInfoRequestField();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLInfoRequestField = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("field_type".equals(i)) {
                    graphQLInfoRequestField.f4301d = GraphQLInfoRequestFieldType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLInfoRequestField, "field_type", graphQLInfoRequestField.a_, 0, false);
                } else if ("name".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInfoRequestField.f4302e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInfoRequestField, "name", graphQLInfoRequestField.a_, 1, false);
                } else if ("status".equals(i)) {
                    graphQLInfoRequestField.f4303f = GraphQLInfoRequestFieldStatus.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLInfoRequestField, "status", graphQLInfoRequestField.a_, 2, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInfoRequestField.f4304g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInfoRequestField, "url", graphQLInfoRequestField.a_, 3, false);
                }
                jsonParser.f();
            }
        }
        return graphQLInfoRequestField;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInfoRequestField.class, new GraphQLInfoRequestFieldDeserializer());
    }

    public GraphQLInfoRequestFieldDeserializer() {
        a(GraphQLInfoRequestField.class);
    }
}
