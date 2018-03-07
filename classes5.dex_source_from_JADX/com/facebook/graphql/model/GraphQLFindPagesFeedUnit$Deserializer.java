package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFindPagesFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: header_image */
public class GraphQLFindPagesFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindPagesFeedUnit.class, new GraphQLFindPagesFeedUnit$Deserializer());
    }

    public Object m7517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFindPagesFeedUnitDeserializer.m4917a(jsonParser, (short) 412);
        Object graphQLFindPagesFeedUnit = new GraphQLFindPagesFeedUnit();
        ((BaseModel) graphQLFindPagesFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFindPagesFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLFindPagesFeedUnit).a();
        }
        return graphQLFindPagesFeedUnit;
    }
}
