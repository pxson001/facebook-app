package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: percent_of_goal_reached */
public class GraphQLEligibleClashUnitsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEligibleClashUnitsEdge.class, new GraphQLEligibleClashUnitsEdgeDeserializer());
    }

    public GraphQLEligibleClashUnitsEdgeDeserializer() {
        a(GraphQLEligibleClashUnitsEdge.class);
    }

    public Object m6997a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEligibleClashUnitsEdge__JsonHelper.m6999a(jsonParser);
    }
}
