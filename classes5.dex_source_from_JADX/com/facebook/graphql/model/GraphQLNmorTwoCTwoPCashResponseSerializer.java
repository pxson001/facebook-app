package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_user_location_shares_count */
public class GraphQLNmorTwoCTwoPCashResponseSerializer extends JsonSerializer<GraphQLNmorTwoCTwoPCashResponse> {
    public final void m9273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNmorTwoCTwoPCashResponse graphQLNmorTwoCTwoPCashResponse = (GraphQLNmorTwoCTwoPCashResponse) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNmorTwoCTwoPCashResponse.m9269j() != null) {
            jsonGenerator.a("id", graphQLNmorTwoCTwoPCashResponse.m9269j());
        }
        if (graphQLNmorTwoCTwoPCashResponse.m9270k() != null) {
            jsonGenerator.a("instructions_url", graphQLNmorTwoCTwoPCashResponse.m9270k());
        }
        if (graphQLNmorTwoCTwoPCashResponse.m9271l() != null) {
            jsonGenerator.a("url", graphQLNmorTwoCTwoPCashResponse.m9271l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNmorTwoCTwoPCashResponse.class, new GraphQLNmorTwoCTwoPCashResponseSerializer());
    }
}
