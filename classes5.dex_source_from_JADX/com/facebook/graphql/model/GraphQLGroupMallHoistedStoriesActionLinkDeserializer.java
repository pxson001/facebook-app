package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: overall_rating */
public class GraphQLGroupMallHoistedStoriesActionLinkDeserializer extends FbJsonDeserializer {
    public Object m8445a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupMallHoistedStoriesActionLink graphQLGroupMallHoistedStoriesActionLink = new GraphQLGroupMallHoistedStoriesActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupMallHoistedStoriesActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("hoisted_story_ids".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (o != null) {
                                collection.add(o);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLGroupMallHoistedStoriesActionLink.f4201d = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallHoistedStoriesActionLink, "hoisted_story_ids", graphQLGroupMallHoistedStoriesActionLink.a_, 0, false);
                } else if ("title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupMallHoistedStoriesActionLink.f4202e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallHoistedStoriesActionLink, "title", graphQLGroupMallHoistedStoriesActionLink.a_, 1, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupMallHoistedStoriesActionLink.f4203f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallHoistedStoriesActionLink, "url", graphQLGroupMallHoistedStoriesActionLink.a_, 2, false);
                }
                jsonParser.f();
            }
        }
        return graphQLGroupMallHoistedStoriesActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMallHoistedStoriesActionLink.class, new GraphQLGroupMallHoistedStoriesActionLinkDeserializer());
    }

    public GraphQLGroupMallHoistedStoriesActionLinkDeserializer() {
        a(GraphQLGroupMallHoistedStoriesActionLink.class);
    }
}
