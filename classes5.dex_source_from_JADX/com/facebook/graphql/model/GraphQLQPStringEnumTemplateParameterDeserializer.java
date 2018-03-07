package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: negative index */
public class GraphQLQPStringEnumTemplateParameterDeserializer extends FbJsonDeserializer {
    public Object m21125a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLQPStringEnumTemplateParameter graphQLQPStringEnumTemplateParameter = new GraphQLQPStringEnumTemplateParameter();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLQPStringEnumTemplateParameter = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQPStringEnumTemplateParameter.f12817d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQPStringEnumTemplateParameter, "name", graphQLQPStringEnumTemplateParameter.a_, 0, false);
                } else if ("required".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLQPStringEnumTemplateParameter.f12818e = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQPStringEnumTemplateParameter, "required", graphQLQPStringEnumTemplateParameter.a_, 1, false);
                } else if ("string_value".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQPStringEnumTemplateParameter.f12819f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQPStringEnumTemplateParameter, "string_value", graphQLQPStringEnumTemplateParameter.a_, 2, false);
                }
                jsonParser.f();
            }
        }
        return graphQLQPStringEnumTemplateParameter;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQPStringEnumTemplateParameter.class, new GraphQLQPStringEnumTemplateParameterDeserializer());
    }

    public GraphQLQPStringEnumTemplateParameterDeserializer() {
        a(GraphQLQPStringEnumTemplateParameter.class);
    }
}
