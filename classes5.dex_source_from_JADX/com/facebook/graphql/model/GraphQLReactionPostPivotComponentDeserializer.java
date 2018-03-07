package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_store_id */
public class GraphQLReactionPostPivotComponentDeserializer extends FbJsonDeserializer {
    public Object m21320a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLReactionPostPivotComponent graphQLReactionPostPivotComponent = new GraphQLReactionPostPivotComponent();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLReactionPostPivotComponent = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("component_logical_path".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLReactionPostPivotComponent.f12884d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLReactionPostPivotComponent, "component_logical_path", graphQLReactionPostPivotComponent.a_, 0, false);
                } else if ("component_style".equals(i)) {
                    graphQLReactionPostPivotComponent.f12885e = GraphQLReactionUnitComponentStyle.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLReactionPostPivotComponent, "component_style", graphQLReactionPostPivotComponent.a_, 1, false);
                } else if ("component_tracking_data".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLReactionPostPivotComponent.f12886f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLReactionPostPivotComponent, "component_tracking_data", graphQLReactionPostPivotComponent.a_, 2, false);
                } else if ("message".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                    }
                    graphQLReactionPostPivotComponent.f12887g = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLReactionPostPivotComponent, "message", graphQLReactionPostPivotComponent.a_, 3, true);
                }
                jsonParser.f();
            }
        }
        return graphQLReactionPostPivotComponent;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactionPostPivotComponent.class, new GraphQLReactionPostPivotComponentDeserializer());
    }

    public GraphQLReactionPostPivotComponentDeserializer() {
        a(GraphQLReactionPostPivotComponent.class);
    }
}
