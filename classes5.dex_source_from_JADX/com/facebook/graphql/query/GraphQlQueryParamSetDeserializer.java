package com.facebook.graphql.query;

import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.util.Map;

/* compiled from: education_editor_review_duplicates_module */
public class GraphQlQueryParamSetDeserializer extends FbJsonDeserializer {

    /* compiled from: education_editor_review_duplicates_module */
    class C04701 extends TypeReference<Map<String, Object>> {
        final /* synthetic */ GraphQlQueryParamSetDeserializer f4791b;

        C04701(GraphQlQueryParamSetDeserializer graphQlQueryParamSetDeserializer) {
            this.f4791b = graphQlQueryParamSetDeserializer;
        }
    }

    /* compiled from: education_editor_review_duplicates_module */
    class C04712 extends TypeReference<String> {
        final /* synthetic */ GraphQlQueryParamSetDeserializer f4792b;

        C04712(GraphQlQueryParamSetDeserializer graphQlQueryParamSetDeserializer) {
            this.f4792b = graphQlQueryParamSetDeserializer;
        }
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQlQueryParamSet.class, new GraphQlQueryParamSetDeserializer());
    }

    public Object m9594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object obj = null;
        while (FbJsonChecker.a(jsonParser) != JsonToken.END_OBJECT) {
            try {
                if (jsonParser.g() == JsonToken.FIELD_NAME) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (i.equals("params")) {
                        obj = new GraphQlQueryParamSet((Map) jsonParser.a(new C04701(this)));
                    } else if (i.equals("input_name")) {
                        jsonParser.a(new C04712(this));
                    }
                    jsonParser.f();
                }
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw new JsonParseException("Failed to deserialize to instance GraphQlQueryParamSet\n" + FbJsonDeserializer.a(jsonParser), jsonParser.l(), e);
            }
        }
        return obj;
    }
}
