package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: open_graph_action */
public class GraphQLLinkOpenActionLinkDeserializer extends FbJsonDeserializer {
    public Object m8941a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLLinkOpenActionLink graphQLLinkOpenActionLink = new GraphQLLinkOpenActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLLinkOpenActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("can_watch_and_browse".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLLinkOpenActionLink.f4393d = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "can_watch_and_browse", graphQLLinkOpenActionLink.a_, 0, false);
                } else if ("destination_type".equals(i)) {
                    graphQLLinkOpenActionLink.f4394e = GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "destination_type", graphQLLinkOpenActionLink.a_, 1, false);
                } else if ("link_description".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4395f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_description", graphQLLinkOpenActionLink.a_, 2, false);
                } else if ("link_display".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4396g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_display", graphQLLinkOpenActionLink.a_, 3, false);
                } else if ("link_icon_image".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "link_icon_image"));
                    }
                    graphQLLinkOpenActionLink.f4397h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_icon_image", graphQLLinkOpenActionLink.a_, 4, true);
                } else if ("link_style".equals(i)) {
                    graphQLLinkOpenActionLink.f4398i = GraphQLCallToActionStyle.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_style", graphQLLinkOpenActionLink.a_, 5, false);
                } else if ("link_target_store_data".equals(i)) {
                    GraphQLLinkTargetStoreData graphQLLinkTargetStoreData;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLLinkTargetStoreData = null;
                    } else {
                        graphQLLinkTargetStoreData = GraphQLLinkTargetStoreData__JsonHelper.m8947a(FieldAccessQueryTracker.a(jsonParser, "link_target_store_data"));
                    }
                    graphQLLinkOpenActionLink.f4399j = graphQLLinkTargetStoreData;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_target_store_data", graphQLLinkOpenActionLink.a_, 6, true);
                } else if ("link_title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4400k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_title", graphQLLinkOpenActionLink.a_, 7, false);
                } else if ("link_type".equals(i)) {
                    graphQLLinkOpenActionLink.f4401l = GraphQLCallToActionType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_type", graphQLLinkOpenActionLink.a_, 8, false);
                } else if ("link_video_endscreen_icon".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "link_video_endscreen_icon"));
                    }
                    graphQLLinkOpenActionLink.f4402m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "link_video_endscreen_icon", graphQLLinkOpenActionLink.a_, 9, true);
                } else if ("stateful_title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4403n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "stateful_title", graphQLLinkOpenActionLink.a_, 10, false);
                } else if ("title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4404o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "title", graphQLLinkOpenActionLink.a_, 11, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4405p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "url", graphQLLinkOpenActionLink.a_, 12, false);
                } else if ("video_annotations".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLVideoAnnotation a = GraphQLVideoAnnotation__JsonHelper.m22429a(FieldAccessQueryTracker.a(jsonParser, "video_annotations"));
                            if (a != null) {
                                collection.add(a);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLLinkOpenActionLink.f4406q = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "video_annotations", graphQLLinkOpenActionLink.a_, 13, true);
                } else if ("header_color".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4407r = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "header_color", graphQLLinkOpenActionLink.a_, 14, false);
                } else if ("logo_uri".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLinkOpenActionLink.f4408s = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLinkOpenActionLink, "logo_uri", graphQLLinkOpenActionLink.a_, 15, false);
                }
                jsonParser.f();
            }
        }
        return graphQLLinkOpenActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLinkOpenActionLink.class, new GraphQLLinkOpenActionLinkDeserializer());
    }

    public GraphQLLinkOpenActionLinkDeserializer() {
        a(GraphQLLinkOpenActionLink.class);
    }
}
